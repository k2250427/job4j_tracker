package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        MemTracker memTracker = new MemTracker();
        UserAction[] actions = {
                new CreateAction(out),
                new Exit()
        };
        new StartUI(out).init(in, memTracker, actions);
        assertThat(memTracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Replaced item"));
        String id = String.valueOf(item.getId());
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", id, replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(out),
                new Exit()
        };
        new StartUI(out).init(in, memTracker, actions);
        assertThat(memTracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Deleted item"));
        String id = String.valueOf(item.getId());
        Input in = new StubInput(
                new String[] {"0", id, "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new Exit()
        };
        new StartUI(out).init(in, memTracker, actions);
        assertThat(memTracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindAllItems() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item[] list = new Item[3];
        Item item1 = memTracker.add(new Item("New item 1"));
        Item item2 = memTracker.add(new Item("New item 2"));
        Item item3 = memTracker.add(new Item("New item 3"));
        list[0] = item1;
        list[1] = item2;
        list[2] = item3;
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new FindAllAction(out),
                new Exit()
        };
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Show all items" + ln
                        + "1. Exit" + ln
                        + "=== Show all items ====" + ln
                        + "Item{id=" + item1.getId() + ", name='" + item1.getName()
                        + "', created=" + item1.getCreated() + "}" + ln
                        + "Item{id=" + item2.getId() + ", name='" + item2.getName()
                        + "', created=" + item2.getCreated() + "}" + ln
                        + "Item{id=" + item3.getId() + ", name='" + item3.getName()
                        + "', created=" + item3.getCreated() + "}" + ln
                        + "Menu." + ln
                        + "0. Show all items" + ln
                        + "1. Exit" + ln
                )
        );
    }

    @Test
    public void whenFindByIdItems() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item1 = memTracker.add(new Item("New item 1"));
        Item item2 = memTracker.add(new Item("New item 2"));
        Item item3 = memTracker.add(new Item("New item 3"));
        String id = String.valueOf(item2.getId());
        Input in = new StubInput(
                new String[] {"0", id, "1"}
        );
        UserAction[] actions = {
                new FindByIdAction(out),
                new Exit()
        };
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Find item by id" + ln
                        + "1. Exit" + ln
                        + "=== Find item by id ====" + ln
                        + "Item{id=" + item2.getId() + ", name='" + item2.getName()
                        + "', created=" + item2.getCreated() + "}" + ln
                        + "Menu." + ln
                        + "0. Find item by id" + ln
                        + "1. Exit" + ln
                )
        );
    }

    @Test
    public void whenFindByNameItems() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item1 = memTracker.add(new Item("New item 1"));
        Item item2 = memTracker.add(new Item("New item 2"));
        Item item3 = memTracker.add(new Item("New item 3"));
        String name = String.valueOf(item2.getName());
        Input in = new StubInput(
                new String[] {"0", name, "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(out),
                new Exit()
        };
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Find items by name" + ln
                        + "1. Exit" + ln
                        + "=== Find items by name ====" + ln
                        + "Item{id=" + item2.getId() + ", name='" + item2.getName()
                        + "', created=" + item2.getCreated() + "}" + ln
                        + "Menu." + ln
                        + "0. Find items by name" + ln
                        + "1. Exit" + ln
                )
        );
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        MemTracker memTracker = new MemTracker();
        UserAction[] actions = {
                new Exit()
        };
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"4", "0"}
        );
        MemTracker memTracker = new MemTracker();
        UserAction[] actions = new UserAction[]{
                new Exit()
        };
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Exit" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0. Exit" + ln
                )
        );
    }
}