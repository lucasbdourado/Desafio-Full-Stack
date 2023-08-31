package br.com.neomind.lucasbdourado.backend.resource;

import br.com.neomind.lucasbdourado.backend.domain.Company;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/company")
public class CompanyResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCompanies(){
        try{
            List<Company> companies = new ArrayList<>();

            return Response.status(Response.Status.FOUND).entity(companies).build();
        } catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
