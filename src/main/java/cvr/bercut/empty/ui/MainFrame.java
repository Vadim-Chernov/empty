package cvr.bercut.empty.ui;

import com.vaadin.ui.MenuBar;
import com.vaadin.ui.VerticalLayout;
import cvr.bercut.lib.security.QSecurity;

@QSecurity
public class MainFrame extends VerticalLayout {
    private MenuBar menuBar = new MenuBar();

    public MainFrame() {
        addComponent(menuBar);
        setVisible(true);
    }

    public void buildMenu(){
        final MenuBar.MenuItem mi1 = menuBar.addItem("=");
        final MenuBar.MenuItem выход = mi1.addItem("выход");
        выход.setCommand(new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem) {
                setVisible(false);
                getUI().close();
            }
        });
    }
}
