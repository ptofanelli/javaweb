package br.com.i9virtual.imobby.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "br.com.i9virtual.imobby.ws.ImobbyAut", serviceName = "ImobbyAutWS")
public class ImobbyAutWS implements ImobbyAut {

	@WebMethod
	public boolean autenticar(String usuario, String token) {
		System.out.println("boolean autenticar(String usuario, String token)");
		System.out.println("usuario = " + usuario);
		System.out.println("token = " + token);

		return ("imobbyadm".equals(usuario) && "imobby".equals(token));
	}
}
