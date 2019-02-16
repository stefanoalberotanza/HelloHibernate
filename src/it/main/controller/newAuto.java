package it.main.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.main.model.Auto;
import it.main.utils.UtilsDAO;

/**
 * Servlet implementation class NewAuto
 */
@WebServlet("/newAuto")
public class newAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityManager em = EMF.createEntityManager();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newAuto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hi");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String targa= request.getParameter("targa");
		String marca= request.getParameter("marca");
		int anno = Integer.parseInt(request.getParameter("anno"));
		int chilometri = Integer.parseInt(request.getParameter("chilometri"));
		Auto auto = new Auto();
		
		auto.setChilometri(chilometri);
		auto.setTarga(targa);
		auto.setMarca(marca);
		auto.setAnno(anno);
		
		try {
			UtilsDAO.newAuto(auto);
			request.setAttribute("listaAuto", UtilsDAO.getAutoByMarca(marca));
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
