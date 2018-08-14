package cvr.bercut.lib.menu;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.MenuBar;
import cvr.bercut.lib.forms.IFrame;
import cvr.bercut.lib.uiutils.Say;

import java.lang.reflect.Field;

public class UIMenuBuilder extends AbstractMenuBuilder {
    private Class clazz;
    private IFrame frame;
    public UIMenuBuilder(IFrame frame) {
        this.frame = frame;
        this.clazz = frame.getClass();
    }

    @Override
    public Object makeMenuBar(Object menuBar, MenuItemProps props) {
        MenuBar.MenuItem menuItem = ((MenuBar) menuBar).addItem(props.getCaption());
        if (!"".equals(props.getIcon()))
            menuItem.setIcon(new ThemeResource(props.getIcon()));
        menuItem.setEnabled(props.isEnabled());
        menuItem.setVisible(props.isVisible());
        return menuItem;
    }

    @Override
    public Object makeMenuItem(Object menuItem, MenuItemProps props) {
        MenuBar.MenuItem ret;
        if (props.getType().equals(MenuElementType.ITEM))
            ret = ((MenuBar.MenuItem) menuItem).addItem(props.getCaption());
        else
            ret = ((MenuBar.MenuItem) menuItem).addSeparator();
        if (!"".equals(props.getIcon()))
            ret.setIcon(new ThemeResource(props.getIcon()));
        ret.setEnabled(props.isEnabled());
        ret.setVisible(props.isVisible());
        final String method = props.getMethod();
        final MenuBar.Command command = findCommand(method);
        if(command!=null)
            ret.setCommand(command);
        return ret;
    }

    private MenuBar.Command findCommand(String commandName) {
        MenuBar.Command reslt = null;
        try {
            Field field;
            field = clazz.getDeclaredField(commandName);
            field.setAccessible(true);
            reslt = (MenuBar.Command) field.get(frame);
        } catch (NoSuchFieldException
                | SecurityException
                | IllegalArgumentException
                | IllegalAccessException ex) {
            Say.warning("Команда " + commandName + " не определена");
        }
        return reslt;
    }
}
