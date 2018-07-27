/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvr.bercut.lib.controls;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.ui.*;
import cvr.bercut.lib.forms.QCell;

import java.util.Collection;
import java.util.List;

/**
 * @author chernov
 */
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
