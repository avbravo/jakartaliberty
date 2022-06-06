/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.avbravo.restclient.province;

import org.avbravo.restclient.*;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 *
 * @author avbravo
 */
@Path("/province")
@ApplicationScoped
public class ProvinceServices {

    @Inject
    @RestClient
    ProvinceRestClient restClient; 

    @GET
    @Path("/text")
    public String getHello() {
        return restClient.getHello();
    }

    @GET
    @Path("/first")
    @Produces(MediaType.APPLICATION_JSON)
    public Province first() {
        return restClient.first();
    }

    

    @GET
    @Path("/findall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Province> findAll() {
        return restClient.findAll();
    }
    
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Province  province ){
            return restClient.add(province);
    } 
    
    
    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Province  province ){
        return restClient.update(province);
    }
    
    
     @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Integer id) {
        return restClient.delete(id);
    }
    @GET
    @Path("/search/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Province findById(@PathParam("id") Integer id){
        return restClient.findById(id);
    }
}
