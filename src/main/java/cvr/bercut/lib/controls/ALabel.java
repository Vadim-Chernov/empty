package cvr.bercut.lib.controls;

import com.vaadin.ui.*;
import cvr.bercut.lib.forms.QCell;

import java.util.List;

public class ALabel extends Label implements IControl {

    @Override
    public Object getVal() {
        return getCaption();
    }

    @Override
    public void setVal(Object o) {
    }

    @Override
    public void setCaption(String caption) {
        super.setCaption(caption);
        setVal(caption);
    }

    @Override
    public IControl self() {
        return this;
    }

}
