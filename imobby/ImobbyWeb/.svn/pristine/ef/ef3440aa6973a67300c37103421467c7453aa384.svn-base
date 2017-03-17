package org.primefaces.examples.view;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.imageio.ImageIO;

import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@RequestScoped
@ManagedBean(name="dynamicImageController")
public class DynamicImageController {

	private StreamedContent graphicText;
	
	private StreamedContent barcode;
	
	private StreamedContent chart;

	public DynamicImageController() {
        try {
            //Graphic Text
            BufferedImage bufferedImg = new BufferedImage(100, 25, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = bufferedImg.createGraphics();
            g2.drawString("Texto Grafico", 0, 10);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(bufferedImg, "png", os);
            graphicText = new DefaultStreamedContent(new ByteArrayInputStream(os.toByteArray()), "image/png"); 

            //Chart
            JFreeChart jfreechart = ChartFactory.createPieChart("Custos por Departamento", createDataset(), true, true, false);
            File chartFile = new File("dynamichart");
            ChartUtilities.saveChartAsPNG(chartFile, jfreechart, 300, 250);
            chart = new DefaultStreamedContent(new FileInputStream(chartFile), "image/png");

            //Barcode
			File barcodeFile = new File("dynamicbarcode");
			BarcodeImageHandler.saveJPEG(BarcodeFactory.createCode128("i9Virtual Imobby"), barcodeFile);
			barcode = new DefaultStreamedContent(new FileInputStream(barcodeFile), "image/jpeg");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public StreamedContent getBarcode() {
		return barcode;
	}

    public StreamedContent getGraphicText() {
        return graphicText;
    }
		
	public StreamedContent getChart() {
		return chart;
	}
	
	private PieDataset createDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Comercial", new Double(45.0));
		dataset.setValue("Financeiro", new Double(15.0));
		dataset.setValue("Producao", new Double(25.2));
		dataset.setValue("Suporte", new Double(14.8));

		return dataset;
	}
}

            