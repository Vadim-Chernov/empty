package cvr.bercut.lib.menu;

import cvr.bercut.lib.exceptions.DublicateKeyError;
import cvr.bercut.lib.security.QSecurity;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractMenuBuilder<TB, TI> {

    protected Map<String, Object> nodes = new HashMap<>();

    protected Map<String, MenuItemProps> propsMap = new HashMap<>();

    public abstract TI makeMenuBar(TB menuBar, MenuItemProps props);

    public abstract TI makeMenuItem(TI menuItem, MenuItemProps props);

    private Class<? extends IMenu> clazz;

    public void makeMenuBar(final QSecurity ann,final TB menuBar) {

        nodes.clear();
        if (ann == null)
            return;
        clazz = ann.menu();
        final QMenu menu = clazz.getAnnotation(QMenu.class);
        final QMenuBar[] bars = menu.bars();
        for (QMenuBar mb : bars) {
            propsMap.put(mb.id(), new MenuItemProps(mb));
            final QMenuItem[] items = mb.items();
            MenuItemProps props = new MenuItemProps(mb);
            final TI menuItem = makeMenuBar(menuBar, props);
            includeNode(mb.id(), menuItem);
            buildItems(menuItem, items);
        }
    }

    private void buildItems(final TI menuItem,final QMenuItem[] items) {
        for (QMenuItem qMenuItem : items) {
            propsMap.put(qMenuItem.id(), new MenuItemProps(qMenuItem));

            final QMenuItem1[] items1 = qMenuItem.items();
            MenuItemProps props = new MenuItemProps(qMenuItem);
            final TI menuItem1 = makeMenuItem(menuItem, props);
            includeNode(qMenuItem.id(), menuItem);
            if (items1.length > 0) {
                buildItems1(menuItem1, items1);
            }
        }
    }

    private void buildItems1(final TI menuItem,final QMenuItem1[] items) {
        for (QMenuItem1 qMenuItem : items) {
            propsMap.put(qMenuItem.id(), new MenuItemProps(qMenuItem));

            final QMenuItem2[] items1 = qMenuItem.items();
            MenuItemProps props = new MenuItemProps(qMenuItem);
            final TI menuItem2 = makeMenuItem(menuItem, props);
            includeNode(qMenuItem.id(), menuItem);
            if (items1.length > 0) {
                buildItems2(menuItem2, items1);
            }
        }
    }

    private void includeNode(final String id,final Object node) {
        final boolean exist = nodes.containsKey(id);
        if (exist)
            throw new DublicateKeyError("Дублирование id в меню ");
        else
            nodes.put(id, node);
    }

    private void buildItems2(final TI menuItem,final QMenuItem2[] items) {
        for (QMenuItem2 qMenuItem : items) {
            MenuItemProps props = new MenuItemProps(qMenuItem);
            propsMap.put(qMenuItem.id(), props);

            includeNode(qMenuItem.id(), menuItem);
            makeMenuItem(menuItem, props);
        }
    }

    public Object getItemById(final String id) {
        return nodes.get(id);
    }
}
