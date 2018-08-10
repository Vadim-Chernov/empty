package cvr.bercut.lib.menu;

public class GMenuItem {

    public String caption = null;
    public GMenuItem[] items = null;
    public String icon;

    public GMenuItem(String caption) {
        this.caption = caption;
    }

    public GMenuItem(GMenuItem item) {
        this.caption = item.caption;
        this.icon = item.icon;
        this.items = item.items;

    }
}
