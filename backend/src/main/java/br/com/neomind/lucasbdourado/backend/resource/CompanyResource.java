package br.com.neomind.lucasbdourado.backend.resource;

import br.com.neomind.lucasbdourado.backend.domain.Company;
import br.com.neomind.lucasbdourado.backend.service.CompanyService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/company")
public class CompanyResource {

    private final CompanyService companyService;

    public CompanyResource(){
        this.companyService = new CompanyService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCompanies(){
        try{
            List<Company> companies = companyService.getAll();

            return Response.status(Response.Status.OK).entity(companies).build();
        } catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCompany(Company company){
        try{
            Company createdCompany = companyService.create(company);

            if (createdCompany != null) {
                return Response.status(Response.Status.CREATED).entity(createdCompany).build();
            } else {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            }
        }catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{\"error\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id){
        try {
            Company deletedCompany = companyService.delete(id);

            if (deletedCompany != null) {
                return Response.ok(deletedCompany).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{\"error\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response read(@PathParam("id") Long id){
        try {
            Company company = companyService.read(id);

            if (company != null) {
                return Response.ok(company).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{\"error\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, Company company){
        try {
            Company updatedCompany = companyService.update(id, company);

            if (updatedCompany != null) {
                return Response.ok(updatedCompany).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{\"error\": \"" + e.getMessage() + "\"}").build();
        }
    }


}
