package cvr.bercut.lib.controls;

import com.vaadin.ui.Label;

public class AEmpty extends Label implements IControl {

    @Override
    public Object getVal() {
        return "";
    }

    @Override
    public void setVal(Object o) {
    }

    @Override
    public void setCaption(String caption) {
        super.setCaption("");
        setVal("");
    }

    @Override
    public IControl self() {
        return this;
    }

}
