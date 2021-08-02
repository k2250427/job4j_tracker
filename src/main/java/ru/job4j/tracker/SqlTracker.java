package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
            try (Statement statement = cn.createStatement()) {
                String sql = String.format("update items set name = '%s' where id = %s;",
                    item.getName(), id
                );
                rsl = (statement.executeUpdate(sql) > 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
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

    private List<Item> selectItems(String sql) {
        List<Item> items = new ArrayList<>();
        try {
            try (Statement statement = cn.createStatement()) {
                statement.executeQuery(sql);
                var sel = statement.getResultSet();
                while (sel.next()) {
                    items.add(new Item(sel.getString("name"),
                            sel.getInt("id"),
                            sel.getTimestamp("created").toLocalDateTime()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    private Item selectItem(String sql) {
        Item item = null;
        try {
            try (Statement statement = cn.createStatement()) {
                statement.executeQuery(sql);
                var sel = statement.getResultSet();
                while (sel.next()) {
                    item = new Item(sel.getString("name"),
                            sel.getInt("id"),
                            sel.getTimestamp("created").toLocalDateTime());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public List<Item> findAll() {
        return selectItems("select * from items;");
    }

    @Override
    public List<Item> findByName(String key) {
        return selectItems(String.format("select * from items where name = '%s';", key));
    }

    @Override
    public Item findById(int id) {
        return selectItem(String.format("select * from items where id = %s;", id));
    }
}
