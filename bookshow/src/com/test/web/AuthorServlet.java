package com.test.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.Author;
import com.test.service.AuthorService;

public class AuthorServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}	
	
	
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if("getAuthorList".equals(method)){
			getAuthorList(request,response);
		}else if("toAdd".equals(method)){
			toAdd(request,response);
		}else if("toEdit".equals(method)){
			toEdit(request,response);
		}else if("saveAuthor".equals(method)){
			saveAuthor(request,response);
		}else if("updateAuthor".equals(method)){
			updateAuthor(request,response);
		}else if("deleteAuthor".equals(method)){
			deleteAuthor(request,response);
		}
	}
	
	private void getAuthorList(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		AuthorService authorService = new AuthorService();
		List<Author> list = authorService.getAuthorList();
		request.setAttribute("authorList", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void toAdd(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/add.jsp");
		dispatcher.forward(request, response);
	}
	
	private void toEdit(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		AuthorService authorService = new AuthorService();
		Author author = authorService.getAuthor(id);
		request.setAttribute("author", author);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/edit.jsp");
		dispatcher.forward(request, response);
	}
	
	private void saveAuthor(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		Author author = new Author();
		int AuthorID = Integer.parseInt(request.getParameter("AuthorID"));
		author.setAuthorID(AuthorID);
		author.setName(request.getParameter("name"));
		author.setCountry(request.getParameter("Country"));
		int age = Integer.parseInt(request.getParameter("age"));
		author.setAge(age);
		
		AuthorService authorService = new AuthorService();
		authorService.saveAuthor(author);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
	
	private void updateAuthor(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		Author author = new Author();
		int AuthorID = Integer.parseInt(request.getParameter("AuthorID"));
		author.setAuthorID(AuthorID);
		author.setName(request.getParameter("name"));
		author.setCountry(request.getParameter("Country"));
		int age = Integer.parseInt(request.getParameter("age"));
		author.setAge(age);
		
		AuthorService authorService = new AuthorService();
		authorService.updateAuthor(author);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
	
	private void deleteAuthor(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("AuthorID"));
		AuthorService authorService = new AuthorService();
		authorService.deleteAuthort(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
	
}
