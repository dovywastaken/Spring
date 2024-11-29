package com.springmvc.repository;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.springmvc.domain.Book;
import com.springmvc.exception.BookIdException;

@Repository
public class BookRepositoryImpl implements BookRepository 
{
    private List<Book> listOfBooks = new ArrayList<Book>();
    private JdbcTemplate template; //DB와 상호작용하는 객체
    
    @Autowired
    public void setJdbctemplate(DataSource dataSource) //DataSource 객체가 DB연결 정보 가짐
    {
    	System.out.println("+++++++++++++++++++++++++++++++++++++++++");
        System.out.println("[setJdbctemplate: DB연결]");
        if (dataSource == null) {
            System.out.println("[setJdbcTemplate: Error] dataSource is null.");
            throw new IllegalArgumentException("DataSource must not be null.");
        }
    	this.template = new JdbcTemplate(dataSource);
    	
    	if (this.template == null) {
    	    System.out.println("[setJdbcTemplate: Error] JdbcTemplate initialization failed.");
    	} else {
    	    System.out.println("[setJdbcTemplate: Success] JdbcTemplate initialized successfully.");
    	}
    	try (Connection connection = dataSource.getConnection()) {
    	    if (connection != null && !connection.isClosed()) {
    	        System.out.println("[setJdbcTemplate: Success] Connection to DB is valid.");
    	    }
    	} catch (Exception e) {
    	    System.out.println("[setJdbcTemplate: Error] Failed to validate DataSource connection.");
    	    e.printStackTrace();
    	}

    	System.out.println("[setJdbctemplate: DB연결]");
    }
    
    public BookRepositoryImpl() {}

    @Override
    public List<Book> getAllBookList() 
    {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++");
        System.out.println("[BookRepositoryImpl: getAllBookList() 호출됨]");
        
        /*
        List<Book> books = listOfBooks;
        if (books == null || books.isEmpty()) {
            System.out.println("반환할 책 리스트가 없습니다.");
        } else {
            System.out.println(books.size() + "개의 책 리스트 반환됨.");
        } */
        
        String SQL = "select * from book";
        System.out.println("SQL 문을 담았습니다");
        List<Book> listOfBooks = template.query(SQL, new BookRowMapper());
        System.out.println("listOfBooks : "+listOfBooks.size() + "개");
        System.out.println("[BookRepositoryImpl: getAllBookList() 종료]");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++");
        
        return listOfBooks;
    }

    @Override
    public List<Book> getBookListByCategory(String category) 
    {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++");
        System.out.println("[BookRepositoryImpl: getBookListByCategory() 호출됨]");
        List<Book> booksByCategory = new ArrayList<Book>();
        /*
        for (int i = 0; i < listOfBooks.size(); i++) 
        {
            Book book = listOfBooks.get(i);
            if (category.equalsIgnoreCase(book.getCategory())) 
            {
                booksByCategory.add(book);
                System.out.println("BookRepositoryImpl: 카테고리 " + category + "에 해당하는 책 추가: " + book.getName());
            }
        }
        if (booksByCategory.isEmpty()) {
            System.out.println("BookRepositoryImpl: 해당 카테고리에 책이 없습니다.");
        }
        */
        
        String SQL = "select * from book where b_category like '%" + category + "%'";
        booksByCategory = template.query(SQL, new BookRowMapper());
        
        System.out.println("[BookRepositoryImpl: getBookListByCategory() 종료]");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++");
        
        return booksByCategory;
    }

    @Override
    public Set<Book> getBookListByFilter(Map<String, List<String>> filter)
    {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++");
        System.out.println("[BookRepositoryImpl: getBookListByFilter() 호출됨]");
        Set<Book> booksByPublisher = new HashSet<Book>();
        Set<Book> booksByCategory = new HashSet<Book>();
        
        /*
        Set<String> booksByFilter = filter.keySet();
        
        if (booksByFilter.contains("publisher")) 
        {
            for (int j = 0; j < filter.get("publisher").size(); j++) 
            {
                String publisherName = filter.get("publisher").get(j);
                for (int i = 0; i < listOfBooks.size(); i++) 
                {
                    Book book = listOfBooks.get(i);
                    if (publisherName.equalsIgnoreCase(book.getPublisher())) {
                        booksByPublisher.add(book);
                        System.out.println("BookRepositoryImpl: 출판사 " + publisherName + "에 해당하는 책 추가: " + book.getName());
                    }
                }
            }
        }
        
        if (booksByFilter.contains("category")) 
        {
            for (int i = 0; i < filter.get("category").size(); i++) 
            {
                String category = filter.get("category").get(i);
                List<Book> list = getBookListByCategory(category);
                booksByCategory.addAll(list);
                System.out.println("BookRepositoryImpl: 카테고리 " + category + "에 해당하는 책 리스트 추가");
            }
        }
        
        booksByCategory.retainAll(booksByPublisher);
        
        */
        Set<String> criterias = filter.keySet();
        if(criterias.contains("publisher")) 
        {
        	for(int j=0; j< filter.get("publisher").size(); j++) 
        	{
        		String publisherName = filter.get("publisher").get(j);
        		String SQL = "select * from book where b_publisher like '%" + publisherName + "%'";
        		booksByPublisher.addAll(template.query(SQL, new BookRowMapper()));
        	}
       	}
        
        if(criterias.contains("category")) 
        {
        	for(int i = 0; i<filter.get("category").size(); i++) 
        	{
        		String category = filter.get("category").get(i);
        		String SQL = "select * from book where b_category like '%" + category + "%'";
        		booksByCategory.addAll(template.query(SQL, new BookRowMapper()));
        	}
        }
        booksByCategory.retainAll(booksByPublisher);
        System.out.println("[BookRepositoryImpl: getBookListByFilter() 종료]");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++");
        
        return booksByCategory;
    }

    @Override
    public Book getBookById(String bookId) 
    {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++");
        System.out.println("[BookRepositoryImpl: getBookById() 호출됨]");
        Book bookInfo = null;
        
        /*
        for (int i = 0; i < listOfBooks.size(); i++) 
        {
            Book book = listOfBooks.get(i);
            if (book != null && book.getBookId() != null && book.getBookId().equals(bookId)) 
            {
                bookInfo = book;
                System.out.println("BookRepositoryImpl: 도서 ID가 " + bookId + "인 책 찾음: " + book.getName());
                break;
            }
        }*/
        
        String SQL = "select count(*) from book where b_bookId=?";
        int rowCount = template.queryForObject(SQL, Integer.class, bookId);
        if(rowCount != 0) 
        {
        	SQL = "select * from book where b_bookId=?";
        	bookInfo = template.queryForObject(SQL, new Object[] {bookId}, new BookRowMapper());
        }
        if (bookInfo == null) 
        {
            throw new BookIdException(bookId);
        }
        System.out.println("[BookRepositoryImpl: getBookById() 종료]");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++");
        
        return bookInfo;
    }

    public void setNewBook(Book book) 
    {
    	System.out.println("+++++++++++++++++++++++++++++++++++++++++");
        System.out.println("[BookRepositoryImpl: setNewBook() 호출됨]");
        
        String SQL = "insert into book (b_bookId, b_name, b_unitPrice, b_author, b_description, b_publisher, b_category, b_unitsInstock, b_releaseDate, b_condition, b_fileName)"
        							+ "values(?,?,?,?,?,?,?,?,?,?,?)";
        System.out.println("SQL문을 작성했습니다 : "+SQL);
        System.out.println("테스트용 "+book.getFileName());
        template.update(SQL, book.getBookId(), book.getName(), book.getUnitPrice(),book.getAuthor(),
        					book.getDescription(),book.getPublisher(),book.getCategory(),book.getUnitsInstock(),
        					book.getReleaseDate(),book.getCondition(),book.getFileName());

    	//listOfBooks.add(book);
    	System.out.println("폼에 맞춰 작성한 dto를 JdbcTemplate 객체를 통해 DB에 저장합니다");
    	System.out.println("[BookRepositoryImpl: setNewBook() 종료]");
    	System.out.println("+++++++++++++++++++++++++++++++++++++++++");
    }

	@Override
	public void setUpdateBook(Book book) 
	{
		System.out.println("+++++++++++++++++++++++++++++++++++++++++");
        System.out.println("[BookRepositoryImpl: setUpdateBook() 호출됨]");
		if(book.getFileName() != null)
		{
			System.out.println(book.getFileName() + "이 null이 아님");
			String SQL = "update Book set b_name = ?, b_unitPrice = ?, b_author =?, b_description = ?, b_publisher = ?, b_category = ?, b_unitsInstock =?, b_releaseDate = ?, b_condition = ?, b_fileName = ? where b_bookId =?";
			template.update(SQL,book.getName(), book.getUnitPrice(),book.getAuthor(),
					book.getDescription(),book.getPublisher(),book.getCategory(),book.getUnitsInstock(),
					book.getReleaseDate(),book.getCondition(),book.getFileName(),book.getBookId());
		}
		else if(book.getFileName() == null) 
		{
			System.out.println(book.getFileName() + "이 null임");
			String SQL = "update Book set b_name = ?, b_unitPrice = ?, b_author =?, b_description = ?, b_publisher = ?, b_category = ?, b_unitsInstock =?, b_releaseDate = ?, b_condition = ? where b_bookId =?";
			template.update(SQL,book.getName(), book.getUnitPrice(),book.getAuthor(),
					book.getDescription(),book.getPublisher(),book.getCategory(),book.getUnitsInstock(),
					book.getReleaseDate(),book.getCondition(),book.getBookId());
		}
		System.out.println("[BookRepositoryImpl: setUpdateBook() 종료]");
    	System.out.println("+++++++++++++++++++++++++++++++++++++++++");
	}
    
}
