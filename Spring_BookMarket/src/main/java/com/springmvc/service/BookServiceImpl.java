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
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("서비스를 거쳐갑니다");
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        return bookRepository.getAllBookList();
    }
	
    @Override
	public List<Book> getBookListByCategory(String category) 
    {
    	System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    	List<Book> booksByCategory = bookRepository.getBookListByCategory(category);
    	if(booksByCategory == null) System.out.println("booksByCategory가 null입니다");
    	System.out.println("서비스를 거쳐갑니다");
    	System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		return booksByCategory;
	}

	@Override
	public Set<Book> getBookListByFilter(Map<String, List<String>> filter) 
	{
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("서비스를 거쳐갑니다");
		Set<Book> booksByFilter = bookRepository.getBookListByFilter(filter);
		
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		return booksByFilter;
	}

	@Override
	public Book getBookById(String bookId) 
	{
	    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
	    System.out.println("서비스를 거쳐갑니다");
	    
	    if (bookId == null || bookId.trim().isEmpty()) {
	        throw new IllegalArgumentException("bookId가 유효하지 않습니다.");
	    }

	    Book bookById = bookRepository.getBookById(bookId);
	    System.out.println("서비스에서 도서 정보를 확인 후 반환합니다: " + bookById.getName());
	    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
	    return bookById;
	}


	@Override
	public void setNewBook(Book book) 
	{
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		bookRepository.setNewBook(book);
		System.out.println("서비스를 거쳐갑니다");
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
	}
    
    
}
