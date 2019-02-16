package it.main.controller;


import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.main.model.Auto;
import it.main.utils.UtilsDAO;

/**
 * Servlet implementation class take
 */
@WebServlet("/take")
public class take extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityManager em = EMF.createEntityManager();
	

    /**
     * @see HttpServlet#HttpServlet()
     */
    public take() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*dao.remVend();
		System.out.println("Done");*/
//		System.out.println(dao.findVend());
		Auto auto = null;
		System.out.println(auto);
		System.out.println(UtilsDAO.findAuto("AA100AA"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
