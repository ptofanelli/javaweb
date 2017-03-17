package org.primefaces.examples.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.PieChartModel;

@SessionScoped
@ManagedBean(name="chartBean")
public class ChartBean implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2490555390115714156L;
	private PieChartModel pieModel;

	public ChartBean() {
        createPieModel();
	}

    public PieChartModel getPieModel() {
        return pieModel;
    }

    private void createPieModel() {
        pieModel = new PieChartModel();

        pieModel.set("Brand 1", 540);
        pieModel.set("Brand 2", 325);
        pieModel.set("Brand 3", 702);
        pieModel.set("Brand 4", 421);
    }
}
            