package cvr.bercut.lib.menu;

import cvr.bercut.lib.security.QSecurity;

public abstract class AbstractMenuBuilder<TB, TI> {

    public abstract TI makeMenuBar(TB menuBar, String caption);

    public abstract TI makeMenuItem(TI menuItem, String caption);

    public void makeMenuBar(QSecurity ann, TB menuBar) {
        final Class<? extends IMenu> clazz = ann.menu();
        if (clazz == null)
            return;
        final QMenu menu = clazz.getAnnotation(QMenu.class);
        final QMenuBar[] bars = menu.bars();
        for (QMenuBar mb : bars) {
            final QMenuItem[] items = mb.items();
            final TI menuItem = makeMenuBar(menuBar, mb.caption());
            buildItems(menuItem, items);
        }
    }

    private void buildItems(TI menuItem, QMenuItem[] items) {
        for (QMenuItem qMenuItem : items) {
            final QMenuItem1[] items1 = qMenuItem.items();
            final TI menuItem1 = makeMenuItem(menuItem, qMenuItem.caption());
            if (items1.length > 0) {
                buildItems1(menuItem1, items1);
            }
        }
    }

    private void buildItems1(TI menuItem, QMenuItem1[] items) {
        for (QMenuItem1 qMenuItem : items) {
            final QMenuItem2[] items1 = qMenuItem.items();
            final TI menuItem2 = makeMenuItem(menuItem, qMenuItem.caption());
            if (items1.length > 0) {
                buildItems2(menuItem2, items1);
            }
        }
    }

    private void buildItems2(TI menuItem, QMenuItem2[] items) {
        for (QMenuItem2 qMenuItem : items) {
            makeMenuItem(menuItem, qMenuItem.caption());
        }
    }
}
