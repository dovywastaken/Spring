package com.springmvc.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springmvc.domain.Book;
import com.springmvc.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService 
{

    @Autowired
    private BookRepository bookRepository;

	@Override
    public List<Book> getAllBookList() 
	{
        System.out.println("Book서비스: getAllBookList 호출");
        return bookRepository.getAllBookList();
    }
	
    @Override
	public List<Book> getBookListByCategory(String category) 
    {
    	System.out.println("Book서비스 : getBookListByCategory 호출");
    	List<Book> booksByCategory = bookRepository.getBookListByCategory(category);
    	if(booksByCategory == null) System.out.println("booksByCategory가 null입니다");
    	System.out.println("Book서비스 : getBookListByCategory 종료");
		return booksByCategory;
	}

	@Override
	public Set<Book> getBookListByFilter(Map<String, List<String>> filter) 
	{
		Set<Book> booksByFilter = bookRepository.getBookListByFilter(filter);
		return booksByFilter;
	}

	@Override
	public Book getBookById(String bookId) 
	{
		Book bookById = bookRepository.getBookById(bookId);
		return bookById;
	}
    
    
    
}
