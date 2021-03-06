package cvr.bercut.empty.ui;

import com.vaadin.ui.MenuBar;
import com.vaadin.ui.VerticalLayout;
import cvr.bercut.lib.forms.IFrame;
import cvr.bercut.lib.menu.*;
import cvr.bercut.lib.security.QSecurity;
import cvr.bercut.lib.uiutils.Say;


// Главная форма
@QSecurity(menu = MainFrameMenu.class)
public class MainFrame extends VerticalLayout implements IFrame {
    private MenuBar menuBar = new MenuBar();

    public MainFrame() {
        addComponent(menuBar);
        setVisible(true);
    }

    void buildMenu() {
        this.setVisible(true);
        final QSecurity ann = MainFrame.class.getAnnotation(QSecurity.class);
        if (ann == null)
            return;
        UIMenuBuilder builder = new UIMenuBuilder(this);
        menuBar.getItems().clear();
        builder.makeMenuBar(ann, menuBar);
    }

    @QSecurity
    private MenuBar.Command close = (MenuBar.Command) selectedItem -> exit();
    private MenuBar.Command say = (MenuBar.Command) selectedItem -> Say.warning("Привет");

    private void exit(){
        this.setVisible(false);
        getUI().close();
    }
    
    @Override
    public VerticalLayout getMainLayout() {
        return this;
    }
}
