package cvr.bercut.lib.controls;

import com.vaadin.ui.ComboBox;

import java.util.List;

public class AComboBox extends ComboBox implements IControl, ISelect {
    private List<Object> values;


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

        super.setValue(o);
    }

    @Override
    public List<Object> getVals() {
        return values;
    }

    @Override
    public void setVals(List<Object> values) {
        this.values = values;
        this.setItems(values);
    }

}
