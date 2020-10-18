package by.htp.jd2.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.jd2.entity.BookBean;
import by.htp.jd2.entity.ItemBean;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;       

    public Controller() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		List<BookBean> books = new ArrayList<>();
		for(int i=0; i<5; i++) {
			books.add(new BookBean());
			books.get(i).setIndex(i+1);
		}
		
		books.get(0).setParameters("War and Peace", "L. Tolstoy", 7);
		books.get(1).setParameters("1984", "G. Orwell", 10);
		books.get(2).setParameters("Roadside picnic", "A., B. Strugatsky", 6);
		books.get(3).setParameters("Inferno", "D. Braun", 2);
		books.get(4).setParameters("The Magus", "J. Fowles", 8);
		
		Set<ItemBean> items = new HashSet<>();
		ItemBean one = new ItemBean();
		ItemBean two = new ItemBean();
		ItemBean three = new ItemBean();
		ItemBean four = new ItemBean();
		
		items.add(one.setParameters("Laptop", 400.00, 5, new Date()));
		items.add(two.setParameters("PC", 800.00, 2, new Date()));
		items.add(three.setParameters("Phone", 300.00, 8, new Date()));
		items.add(four.setParameters("Printer", 900.00, 3, new Date()));
		
		request.setAttribute("books", books);
		request.setAttribute("items", items);
		
		if("naming".equals(request.getParameter("command"))) {
			request.getRequestDispatcher("/WEB-INF/jsp/usebean.jsp").forward(request, response);
		}	
	}
	
	

}
