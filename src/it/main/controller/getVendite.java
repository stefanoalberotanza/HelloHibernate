package it.main.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.main.model.Vendite;
import it.main.utils.UtilsDAO;

/**
 * Servlet implementation class getVendite
 */
@WebServlet("/getVendite")
public class getVendite extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityManager em = EMF.createEntityManager();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getVendite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			List<Vendite> listVendite = UtilsDAO.getVendite();
			request.setAttribute("listVendite", listVendite);
			request.getRequestDispatcher("/viewVendite.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
