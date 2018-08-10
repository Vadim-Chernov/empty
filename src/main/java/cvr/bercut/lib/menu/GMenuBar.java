package cvr.bercut.lib.menu;

public class GMenuBar {
    public String caption = null;
    public GMenuItem[] items = null;

    public GMenuBar(String caption, String... items) {
        this.caption = caption;
        this.items = new GMenuItem[items.length];
        int cou = 0;
        for (String tilte : items) {
            this.items[cou++] = new GMenuItem(tilte);
        }
    }

    public GMenuBar(GMenuItem bar, GMenuItem[] items) {
        this.caption = bar.caption;
        this.items = new GMenuItem[items.length];
        int cou = 0;
        for (GMenuItem item : items) {
            this.items[cou++] = new GMenuItem(item);
        }
    }

}
