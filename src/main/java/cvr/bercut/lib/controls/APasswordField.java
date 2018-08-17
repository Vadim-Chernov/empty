/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvr.bercut.lib.controls;

import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

/**
 *
 * @author chernov
 */
public class APasswordField extends PasswordField implements IControl {

    @Override
    public Object getVal() {
        return getValue();
    }

    @Override
    public void setVal(Object o) {
        String value;
        value = (String) o;
        super.setValue(value);
    }

    @Override
    public IControl self() {
        return this;
    }
}
