package it.main.rest;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.main.model.Auto;
import it.main.model.Vendite;
import it.main.utils.UtilsDAO;

@Path("/auto")
public class VenditeRest {
	
	@GET
	@Consumes("application/json") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllVendite() {

		try {
			ArrayList<Vendite> listVendite = (ArrayList<Vendite>) UtilsDAO.getVendite();

			ObjectMapper mapper = new ObjectMapper();
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			mapper.setDateFormat(df);
			String jsonInString = mapper.writeValueAsString(listVendite);

			return Response.status(200).entity(jsonInString).build();
			//writer().withDefaultPrettyPrinter();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(405).build();
	}
	
	@POST
	@Path("/post")
	@Consumes("application/json")
	public Response newVendita(Vendite vendita) {
		try {
			UtilsDAO.newVendita(vendita);
			return Response.status(200).build();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(405).build();
	}
	
	public Response newListVendite(ArrayList<Vendite> listVendite) {
		try {
			for(Vendite vendita : listVendite) {
				UtilsDAO.newVendita(vendita);
			}
			
			return Response.status(200).build();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(405).build();
	}
}
