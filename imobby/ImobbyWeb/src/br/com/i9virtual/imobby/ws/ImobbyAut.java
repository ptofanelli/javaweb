
package br.com.i9virtual.imobby.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ImobbyAut", targetNamespace = "http://ws.imobby.i9virtual.com.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ImobbyAut {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "autenticar", targetNamespace = "http://ws.imobby.i9virtual.com.br/", className = "br.com.i9virtual.imobby.ws.Autenticar")
    @ResponseWrapper(localName = "autenticarResponse", targetNamespace = "http://ws.imobby.i9virtual.com.br/", className = "br.com.i9virtual.imobby.ws.AutenticarResponse")
    public boolean autenticar(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

}
