package cvr.bercut.empty.ui;

import com.vaadin.ui.MenuBar;
import com.vaadin.ui.VerticalLayout;
import cvr.bercut.lib.menu.*;
import cvr.bercut.lib.security.QSecurity;

@QSecurity(menu = MainFrameMenu.class)
public class MainFrame extends VerticalLayout {
    private MenuBar menuBar = new MenuBar();

    public MainFrame() {
        addComponent(menuBar);
        setVisible(true);
    }

    public void buildMenu() {
        final QSecurity ann = MainFrame.class.getAnnotation(QSecurity.class);
        if (ann == null)
            return;
        final Class<? extends IMenu> clazz = ann.menu();
        if (clazz == null)
            return;
        final QMenu menu = clazz.getAnnotation(QMenu.class);
        final QMenuBar[] bars = menu.bars();
        for (QMenuBar mb : bars) {
            final QMenuItem[] items = mb.items();
            final MenuBar.MenuItem menuItem = menuBar.addItem(mb.caption());
            if (items.length > 0) {
                for (int i = 0; i < items.length; i++)
                    menuItem.addItem(items[i].caption());
            }
        }
    }

}
