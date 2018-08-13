package cvr.bercut.lib.menu;

import com.vaadin.ui.MenuBar;

public class MenuBuilder<TB, TI> extends AbstractMenuBuilder<TB, TI> {
    @Override
    public TI makeMenuBar(TB menuBar, String caption) {
        MenuBar.MenuItem menuItem = ((MenuBar) menuBar).addItem(caption);
        return (TI) menuItem;
    }

    @Override
    public TI makeMenuItem(TI menuItem, String caption) {
        MenuBar.MenuItem ret = ((MenuBar.MenuItem) menuItem).addItem(caption);
        return (TI) ret;
    }

}
