/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvr.bercut.lib.controls;

/**
 *
 * @author chernov
 */
public interface IMinMax {

    double getMin();

    void setMin(double min);

    double getMax();

    void setMax(double min);

    int getResolution();

    void setResolution(int r);
}
