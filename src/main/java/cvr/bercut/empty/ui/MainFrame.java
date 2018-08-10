package cvr.bercut.empty.ui;

import com.vaadin.ui.MenuBar;
import com.vaadin.ui.VerticalLayout;
import cvr.bercut.lib.menu.GMenu;
import cvr.bercut.lib.menu.GMenuBar;
import cvr.bercut.lib.menu.GMenuItem;
import cvr.bercut.lib.security.QSecurity;

@QSecurity(menu = MainMenu.class)
public class MainFrame extends VerticalLayout {
    private MenuBar menuBar = new MenuBar();

    public MainFrame() {
        addComponent(menuBar);
        setVisible(true);
    }

    private GMenu gMenu;

    public void buildMenu() {
        final QSecurity ann = MainFrame.class.getAnnotation(QSecurity.class);
        final Class<? extends GMenu> menu = ann.menu();
        try {
            gMenu = menu.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        final GMenuBar[] bars = gMenu.bars;
        for (GMenuBar mb : bars) {
            final String caption = mb.caption;
            final GMenuItem[] mi = mb.items;
            final MenuBar.MenuItem menuItem = menuBar.addItem(caption);
            for (GMenuItem mim : mi) {
                menuItem.addItem(mim.caption);
            }
        }
    }
}

//class MenuCreator{
//    private Class<? extends GMenu> clazz;
//
//    public MenuCreator(Class clazz) {
//        this.clazz = clazz;
//    }
//    public GMenuItem itemgenerator(GMenuItem item){
//        return null;
//    }
//}
//
class MainMenu extends GMenu {
    public MainMenu() {
        this.caption = "Основное меню";
        this.bars = new GMenuBar[2];
        this.bars[0] = new GMenuBar("File", "Выход", "222", "333");
        this.bars[1] = new GMenuBar("Справочники", "Работники", "Подразделения", "Должности");
    }
}

class Menu1 extends GMenu{
    public Menu1() {
        this.caption="";
        this.bars = new GMenuBar[1];

        GMenuItem file = new GMenuItem("File");
        file.items=new GMenuItem[2];
        file.items[0] = new GMenuItem("Выход");
        file.items[1] = new GMenuItem("Вход");

        this.bars[0] = new GMenuBar(file,file.items);
    }
}