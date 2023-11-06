/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:SecureResource [secure]<br>
 * USAGE:
 * <pre>
 *        SecureClient client = new SecureClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author root
 */
public class SecureClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "https://localhost:8080/CarRentalSecurity/webresources";

    public SecureClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        client.register(new MyRestFilter());
        webTarget = client.target(BASE_URI).path("secure");
//                .queryParam("username", username)
//                .queryParam("password", password);
    }

     
    
    
    public String sayHello() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }

    public void close() {
        client.close();
    }
    
     public String InsertCity( String cityname) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("InsertCity/{0}/{1}", new Object[]{ cityname})).request().post(null, String.class);
    }
}
