package cvr.bercut.lib.menu;

public class MenuItemProps {
    private String id;
    private String caption;
    private String icon;
    private String method;
    private MenuElementType type;
    private boolean enabled;
    private boolean visible;

     MenuItemProps(QMenuBar g) {
        this.id = g.id();
        this.caption = g.caption();
        this.icon = g.icon();
        this.enabled=g.enabled();
        this.visible=g.visible();
    }

    MenuItemProps(QMenuItem g) {
        this.id = g.id();
        this.caption = g.caption();
        this.icon = g.icon();
        this.method = g.method();
        this.type = g.type();
        this.enabled=g.enabled();
        this.visible=g.visible();
    }

    MenuItemProps(QMenuItem1 g) {
        this.id = g.id();
        this.caption = g.caption();
        this.icon = g.icon();
        this.method = g.method();
        this.type = g.type();
        this.enabled=g.enabled();
        this.visible=g.visible();
    }

    MenuItemProps(QMenuItem2 g) {
        this.id = g.id();
        this.caption = g.caption();
        this.icon = g.icon();
        this.method = g.method();
        this.type = g.type();
        this.enabled=g.enabled();
        this.visible=g.visible();
    }

    public String getCaption() {
        return caption;
    }

    String getIcon() {
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

    public String getId() {
        return id;
    }

    boolean isEnabled() {
        return enabled;
    }

    boolean isVisible() {
        return visible;
    }
}
