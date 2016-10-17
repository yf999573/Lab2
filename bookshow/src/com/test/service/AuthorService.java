package com.test.service;

import java.util.List;

import com.test.dao.AuthorDao;
import com.test.model.Author;


public class AuthorService {
	
	public List<Author> getAuthorList(){
		AuthorDao authorDao = new AuthorDao();
		List<Author> list = authorDao.getAuthorList();
		return list;
	}
	
	public void saveAuthor(Author author){
		AuthorDao authorDao = new AuthorDao();
		authorDao.saveAuthor(author);
	}
	
	public Author getAuthor(int id){
		AuthorDao authorDao = new AuthorDao();
		return authorDao.getAuthor(id);
	}
	
	public void deleteAuthort(int id){
		AuthorDao authorDao = new AuthorDao();
		authorDao.deleteAuthor(id);
	}
	
	public void updateAuthor(Author author){
		AuthorDao authorDao = new AuthorDao();
		authorDao.updateAuthor(author);
	}
}
