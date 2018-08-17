package cvr.bercut.lib.controls;

import com.vaadin.ui.*;

import java.util.List;

import cvr.bercut.lib.forms.QCell;

/**
 * @author chernov
 */
public class ACheckBox extends CheckBox implements IControl {

    @Override
    public IControl self() {
        return this;
    }

    @Override
    public Object getVal() {
        return getValue();
    }

    @Override
    public void setVal(Object o) {
        String value;
        value = ((String) o).toLowerCase();
        switch (value) {
            case "ok":
            case "yes":
            case "y":
            case "да":
            case "1":
                setValue(true);
                break;
            case "n":
            case "no":
            case "нет":
            case "0":
            case "":
                setValue(false);
                break;
        }
    }
}
