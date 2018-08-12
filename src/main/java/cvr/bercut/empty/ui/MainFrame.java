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
        MenuBuilder builder = new MenuBuilder();
        builder.makeMenuBar(ann,menuBar);
    }

}
