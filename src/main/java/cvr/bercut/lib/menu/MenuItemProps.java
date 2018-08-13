package cvr.bercut.lib.menu;

public class MenuItemProps {
    private String caption;
    private String icon;
    private String method;
    private MenuElementType type;

    public MenuItemProps(QMenuItem g) {
        this.caption = g.caption();
        this.icon = g.icon();
        this.method = g.method();
        this.type = g.type();
    }

    public MenuItemProps(QMenuItem1 g) {
        this.caption = g.caption();
        this.icon = g.icon();
        this.method = g.method();
        this.type = g.type();
    }

    public String getCaption() {
        return caption;
    }

    public String getIcon() {
        return icon;
    }

    public String getMethod() {
        return method;
    }

    public MenuElementType getType() {
        return type;
    }

    private MenuItemProps get() {
        return this;
    }
}
