package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection cn;

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement statement =
                     cn.prepareStatement("insert into items(name,created) values (?,?)",
                             Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean rsl = false;
        try {
            try (PreparedStatement statement =
                         cn.prepareStatement("update items set name = '?' where id = ?;")) {
                statement.setString(1, item.getName());
                statement.setInt(2, id);
                rsl = (statement.executeUpdate() > 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    private List<Item> selectItems(String sql, String name) {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement =
                     cn.prepareStatement(sql)) {
            if (Objects.nonNull(name)) {
                statement.setString(1, name);
            }
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(new Item(resultSet.getString("name"),
                            resultSet.getInt("id"),
                            resultSet.getTimestamp("created").toLocalDateTime()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    private Item selectItem(String sql, int id) {
        Item item = null;
        try (PreparedStatement statement =
                     cn.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    item = new Item(resultSet.getString("name"),
                            resultSet.getInt("id"),
                            resultSet.getTimestamp("created").toLocalDateTime());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean delete(int id) {
        boolean rsl = false;
        try {
            try (Statement statement = cn.createStatement()) {
                String sql = String.format("delete from items where id = %s;",
                        id
                );
                rsl = statement.execute(sql);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        return selectItems("select * from items;", null);
    }

    @Override
    public List<Item> findByName(String key) {
        return selectItems("select * from items where name = '?';", key);
    }

    @Override
    public Item findById(int id) {
        return selectItem("select * from items where id = ?;", id);
    }
}
