package br.com.i9virtual.imobby.controller;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
import javax.xml.ws.BindingProvider;

import org.jboss.logging.Logger;

import br.com.i9virtual.imobby.ws.ImobbyAut;
import br.com.i9virtual.imobby.ws.ImobbyAutWS;

@Named("login")
@SessionScoped
public class Login implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3242477213144907199L;

	Logger logger = Logger.getLogger(Login.class);
	
	private String usuario;
	private String senha;
	
	private Boolean usuarioLogado = false;

	public Login() {
		logger.info("chamada do construtor Login()");
	}
	
	public String getUsuario() {
		logger.info("chamada do metodo getUsuario()");
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void checkLogin(ComponentSystemEvent event) throws AbortProcessingException {
		if (!usuarioLogado) {
			FacesContext context = FacesContext.getCurrentInstance();
			ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler) context.getApplication().getNavigationHandler();
			handler.performNavigation("login");
		}
	}
	
	public String login(){	
		logger.info("chamada do metodo login()");
		
		boolean autenticado = false;
		
		// Create an instance of service stub
//        HelloWorldWS service = new HelloWorldWS();
        ImobbyAutWS service = new ImobbyAutWS();
        
        // Create an instance of SOAP message specific to this service
//        HelloWorld msg = service.getHelloWorldWSPort();
        ImobbyAut imobbyAut = service.getImobbyAutWSPort();

        // Use the BindingProvider's context to set the endpoint
        BindingProvider bp = (BindingProvider)imobbyAut;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://www.imobby.com.br:8080/ImobbyWS");
        
        // Invoke the method
//        long rate = msg.sum(1, 2);
        autenticado = imobbyAut.autenticar(usuario, senha);
        
        if(autenticado) {
			logger.info("return \"index\"");
			usuarioLogado = true;
			return "index?faces-redirect=true";
		} else {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			ResourceBundle bundle = facesContext.getApplication().getResourceBundle(facesContext, "msg");
			
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,bundle.getString("loginLoginFailSummary"), bundle.getString("loginLoginFailDetail"))); 
			return null;
			
		}
		
		
//		if("imobbyadm".equals(usuario) && "imobby".equals(senha)) {
//			logger.info("return \"index\"");
//			usuarioLogado = true;
//			return "index";
//		} else {
//			FacesContext facesContext = FacesContext.getCurrentInstance();
//			ResourceBundle bundle = facesContext.getApplication().getResourceBundle(facesContext, "msg");
//			
//			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,bundle.getString("loginLoginFailSummary"), bundle.getString("loginLoginFailDetail"))); 
//			return null;
//			
//		}
		
	}
	
	public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        usuarioLogado = false;
        return "/login.xhtml?faces-redirect=true";
    }
	
	public String setIdiomaPt() {
		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("pt", "br"));
		return "";
	}
	
	public String setIdiomaEn() {
		FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.ENGLISH);
		return "";
	}
	
	public String setIdiomaEs() {
		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("es"));
		return "";
	}
	
	public Boolean getUsuarioLogado() {
		return usuarioLogado;
	}
	
}
