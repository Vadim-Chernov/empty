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

    public boolean hasChildren() {
        if (items == null)
            return false;
        return items.length > 0;
    }

    public void setItems(GMenuItem item, GMenuItem[] items) {
        this.caption = item.caption;
        this.icon = item.icon;
        this.items = items;
    }
}
