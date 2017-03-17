/**
 * 
 */
package br.com.i9virtual.imobby.controller.sobre;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.event.map.StateChangeEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.LatLngBounds;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 * @author ptofanelli
 *
 */
@Named("mapaController")
@SessionScoped
public class MapaController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -866807398184765149L;

	/**
	 * Modelo de mapa para atribuicao de marcadores
	 */
	private MapModel simpleModel;
	
	/**
	 * Marcador para o mapa
	 */
	private Marker marker;
	
	private MapModel emptyModel;
	
	private String title;
	
	private double lat;
	
	private double lng;
	
	public MapModel getEmptyModel() {
		return emptyModel;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}
	
	public void addMarker(ActionEvent actionEvent) {
		Marker marker = new Marker(new LatLng(lat, lng), title);
		emptyModel.addOverlay(marker);
		
		addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Added", "Lat:" + lat + ", Lng:" + lng));
	}

	public MapaController() {
		// modelo padrao de mapa
		simpleModel = new DefaultMapModel();
		
		emptyModel = new DefaultMapModel();
		
		//Shared coordinates
		LatLng coord1 = new LatLng(36.879466, 30.667648);
		LatLng coord2 = new LatLng(36.883707, 30.689216);
		LatLng coord3 = new LatLng(36.879703, 30.706707);
		LatLng coord4 = new LatLng(36.885233, 30.702323);
		
		//Basic marker
		simpleModel.addOverlay(new Marker(coord1, "Konyaalti"));
		simpleModel.addOverlay(new Marker(coord2, "Ataturk Parki"));
		simpleModel.addOverlay(new Marker(coord3, "Karaalioglu Parki"));
		simpleModel.addOverlay(new Marker(coord4, "Kaleici"));
	}

	public MapModel getSimpleModel() {
		return simpleModel;
	}
	
	/**
	 * Event: marker selection
	 * @param event Event
	 */
	public void onMarkerSelect(OverlaySelectEvent event) {
		marker = (Marker) event.getOverlay();
		
		addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Selected", marker.getTitle()));
	}
	
	public Marker getMarker() {
		return marker;
	}
	
	/**
	 * Event: The state of the map changes (zoom and/or move).
	 * @param event The event object.
	 */
	public void onStateChange(StateChangeEvent event) {
		LatLngBounds bounds = event.getBounds();
		int zoomLevel = event.getZoomLevel();
		
		addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Zoom Level", String.valueOf(zoomLevel)));
		addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Center", event.getCenter().toString()));
		addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "NorthEast", bounds.getNorthEast().toString()));
		addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "SouthWest", bounds.getSouthWest().toString()));
	}
	
	/**
	 * Event: A point is selected on the map.
	 * @param event The event object.
	 */
	public void onPointSelect(PointSelectEvent event) {
		LatLng latlng = event.getLatLng();
		
		addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Point Selected", "Lat:" + latlng.getLat() + ", Lng:" + latlng.getLng()));
	}
	
	/**
	 * Add a new message to the current instance of the faces context.
	 * @param message message to be added.
	 */
	public void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
