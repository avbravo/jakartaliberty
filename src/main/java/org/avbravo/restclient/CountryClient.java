/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.avbravo.restclient;


import java.util.Base64;
import java.util.List;
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
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 *
 * @author avbravo
 */
@RegisterRestClient(baseUri = "http://localhost:8080/microprofilerestclientserver/api")
@Path("/country")
//@ClientHeaderParam(name = "Authorization", value = "{lookupAuth}")
public interface CountryClient {

     default String lookupAuth() {
    return "Basic " + 
//         Base64.getEncoder().encodeToString("user:pass".getBytes());
         Base64.getEncoder().encodeToString("E$g3t1.q4@n5:s7_$4wnT1den4=/pana1e1".getBytes());
  }
    
    @GET
    @Path("/text")
    public String getHello();

    @GET
    @Path("/first")
    @Produces(MediaType.APPLICATION_JSON)
    public Country first();  

  
    

    @GET
    @Path("/findall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Country> findAll();

    
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Country  country );
    
    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Country  country );
    
    
    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") String id) ;
    
    @GET
    @Path("/search/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Country findById(@PathParam("id") String id);
    
}
