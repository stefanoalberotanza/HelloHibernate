package it.main.rest;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
public class AutoRest {	
	
	@GET
	@Consumes("application/json") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllAuto() {

		try {
			ArrayList<Auto> listAuto = (ArrayList<Auto>) UtilsDAO.getAuto();

			ObjectMapper mapper = new ObjectMapper();
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			mapper.setDateFormat(df);
			String jsonInString = mapper.writeValueAsString(listAuto);

			return Response.status(200).entity(jsonInString).build();
			//writer().withDefaultPrettyPrinter();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(405).build();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "Hello Jersey";
	}
	
	@POST
	@Path("/post")
	@Consumes("application/json")
	public Response newAuto(Auto auto) {
		try {
			UtilsDAO.newAuto(auto);
//			if(!auto.getVendite().isEmpty()) {
//				this.venditeRestNew(auto.getVendite(), auto);
//			}
			return Response.status(200).build();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(405).build();
	}

	@POST
	@Path("/post")
	@Consumes("application/json")
	public Response newListAuto(List<Auto> listAuto) {
		try {
			for(Auto auto:  listAuto) {
				UtilsDAO.newAuto(auto);
			}
			return Response.status(200).build();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(405).build();
	}
	//	private VenditeRest venditeRestNew(List<Vendite> listVendite, Auto auto) {
//		for(Vendite vendita : listVendite) {
//			vendita.setAuto(auto);
//		}
//		
//		return new VenditeRest(listVendite);		
//	}

	
	// This method is called if XML is request
//	@GET
//	@Produces(MediaType.TEXT_XML)
//	public String sayXMLHello() {
//		return "<?xml version=\"1.0\"?>" + "<hello> Hello O" + "</hello>";
//	}

	//This method is called if HTML is request
//		@GET
//		@Path("/{username}")
//		@Produces(MediaType.TEXT_HTML)
//		public String sayHtmlHello(@PathParam("username") String userName) {
//			return "<html> " + "<title>" + "Hello Jersey" + "</title>"
//					+ "<body><h1>" + "Hello " + userName + "</body></h1>" + "</html> ";
//		}
}
