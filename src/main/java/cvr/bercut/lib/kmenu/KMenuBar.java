package cvr.bercut.lib.kmenu;

import java.util.ArrayList;
import java.util.List;

public class KMenuBar {
    private String caption;
    private String icon;
    private List<KMenuItem> items=new ArrayList<>();

    public KMenuBar(String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<KMenuItem> getItems() {
        return items;
    }

    public void setItems(List<KMenuItem> items) {
        this.items = items;
    }
}
