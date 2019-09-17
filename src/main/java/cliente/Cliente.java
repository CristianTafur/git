/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.api.client.Client; 
import com.sun.jersey.api.client.ClientResponse; 
import com.sun.jersey.api.client.WebResource;
import modelo.Usuario;
/**
 *
 * @author Cristian Tafur
 */

public class Cliente {
   
    WebResource resource;
    Client client;
    public Cliente() { 
    ClientConfig clientConfig= new DefaultClientConfig();
    clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
    client=Client.create(clientConfig); 
    }

    public boolean post(Usuario usuario) {
        ClientResponse response=resource.type("application/json").post(ClientResponse.class,usuario);
        try {
           response.getEntity(Usuario.class);
           return true;
        } catch (Exception e) {
             
        }
       return false;
    }
    public Usuario get(String id){
        path("http://localhost:8080/MavenRESTAPI/webresources/modelo.usuario/usuario/"+id);
        ClientResponse response=resource.type("application/json").get(ClientResponse.class);
        try {
           return response.getEntity(Usuario.class);
        } catch (Exception e) {
        }
        return null;
    }
    
    public  Usuario put(Usuario usuario){
         ClientResponse response=resource.type("application/json").put(ClientResponse.class,usuario);
         try {
             return response.getEntity(Usuario.class);
        } catch (Exception e) {
        }
        return null;
    }
    public Usuario delete(Usuario id){
      
        try { ClientResponse response=resource.type("application/json").delete(ClientResponse.class);
            System.out.println("entro");
            return response.getEntity(Usuario.class);
        } catch (Exception e) {
             System.out.println("error");
        }
        return null;
    }
    public void path(String url){
         resource=client.resource(url); 
    }
    
}
