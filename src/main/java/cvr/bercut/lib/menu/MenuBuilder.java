package cvr.bercut.lib.menu;

import com.vaadin.ui.MenuBar;
import cvr.bercut.lib.security.QSecurity;

public  class MenuBuilder<T> {

    public MenuBar.MenuItem makeMenuBar(MenuBar menuBar, QMenuBar mb ) {
        final MenuBar.MenuItem menuItem = menuBar.addItem(mb.caption());
        return menuItem;
    }


    public void makeMenuBar(QSecurity ann, MenuBar menuBar) {
        final Class<? extends IMenu> clazz = ann.menu();
        if (clazz == null)
            return;
        final QMenu menu = clazz.getAnnotation(QMenu.class);
        final QMenuBar[] bars = menu.bars();
        for (QMenuBar mb : bars) {
            final QMenuItem[] items = mb.items();
            final MenuBar.MenuItem menuItem = makeMenuBar(menuBar, mb);
            buildItems(menuItem, items);
        }
    }

    private void buildItems(MenuBar.MenuItem menuItem, QMenuItem[] items) {
        for (QMenuItem qMenuItem : items) {
            final QMenuItem1[] items1 = qMenuItem.items();
            final MenuBar.MenuItem menuItem1 = menuItem.addItem(qMenuItem.caption());
            if (items1.length > 0) {
                buildItems1(menuItem1, items1);
            }
        }
    }

    private void buildItems1(MenuBar.MenuItem menuItem, QMenuItem1[] items) {
        for (QMenuItem1 qMenuItem : items) {
            final QMenuItem2[] items1 = qMenuItem.items();
            final MenuBar.MenuItem menuItem2 = menuItem.addItem(qMenuItem.caption());
            if (items1.length > 0) {
                buildItems2(menuItem2, items1);
            }
        }
    }

    private void buildItems2(MenuBar.MenuItem menuItem, QMenuItem2[] items) {
        for (QMenuItem2 qMenuItem : items) {
            final MenuBar.MenuItem menuItem2 = menuItem.addItem(qMenuItem.caption());
        }
    }
}
