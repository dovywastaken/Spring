package com.springmvc.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.domain.Book;
import com.springmvc.service.BookService;

@Controller
//@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String requestBookList(Model model) {
        System.out.println("================================================================");
        System.out.println("[BookController: books로 매핑되어 컨트롤러로 들어왔습니다]");
        List<Book> list = bookService.getAllBookList();
        if (list == null) {
            System.out.println("받아온 ArrayList가 없음");
        } else {
            System.out.println("DTO " + list.size() + "개 받아옴");
            for (Book book : list) {
                System.out.println("Book: " + book.getName() + ", Author: " + book.getAuthor());
            }
        }
        model.addAttribute("bookList", list);
        System.out.println("모델에 bookList addAttribute 완료");
        System.out.println("[" + list.size() + "개의 dto를 들고 " + "books.jsp로 이동합니다]");
        return "books";
    }
    
    @GetMapping("/all")
    public String requestAllBookList(Model model) {
        System.out.println("================================================================");
        System.out.println("[BookController: requestAllBookList()으로 매핑되어 컨트롤러로 들어왔습니다]");
        
        System.out.println("BookController: /all 요청 받음");
        ModelAndView modelAndView = new ModelAndView();
        List<Book> list = bookService.getAllBookList();
        if (list == null) {
            System.out.println("받아온 ArrayList가 없음");
        } else {
            System.out.println("DTO " + list.size() + "개 받아옴");
            for (Book book : list) {
                System.out.println("Book: " + book.getName() + ", Author: " + book.getAuthor());
            }
        }
        modelAndView.addObject("bookList", list);
        modelAndView.setViewName("books");
        
        // model.addAttribute("bookList", list);
        System.out.println("BookController: 모델에 bookList 추가");
        
        System.out.println("[books.jsp로 이동합니다]");
        return "books";
    }
    
    @GetMapping("/{category}")
    public String requestBooksByCategory(@PathVariable("category") String bookCategory, Model model) {
        System.out.println("================================================================");
        System.out.println("[BookController: requestBooksByCategory()으로 매핑되어 컨트롤러로 들어왔습니다]");
        
        System.out.println("URL로 파라미터 받기: " + bookCategory);
        List<Book> booksByCategory = bookService.getBookListByCategory(bookCategory);
        if (booksByCategory == null) {
            System.out.println("받아온 ArrayList가 없음");
        } else {
            System.out.println("DTO " + booksByCategory.size() + "개 받아옴");
            for (Book book : booksByCategory) {
                System.out.println("Book: " + book.getName() + ", Author: " + book.getAuthor());
            }
        }
        model.addAttribute("bookList", booksByCategory);
        if (model.getAttribute("bookList") == null) {
            System.out.println("List에 값이 없습니다");
        }
        
        System.out.println("[books.jsp로 이동합니다]");
        return "books";
    }
    
    @GetMapping("/filter/{bookFilter}")
    public String requestBooksByFilter(@MatrixVariable(pathVar="bookFilter") Map<String, List<String>> bookFilter, Model model) {
        System.out.println("================================================================");
        System.out.println("[BookController: requestBooksByFilter()으로 매핑되어 컨트롤러로 들어왔습니다]");
        
        Set<Book> booksByFilter = bookService.getBookListByFilter(bookFilter);
        if (booksByFilter == null) {
            System.out.println("받아온 Set<Book>가 없음");
        } else {
            System.out.println("필터링된 책 " + booksByFilter.size() + "개 받아옴");
            for (Book book : booksByFilter) {
                System.out.println("Book: " + book.getName() + ", Author: " + book.getAuthor());
            }
        }
        model.addAttribute("bookList", booksByFilter);
        
        System.out.println("[books.jsp로 이동합니다]");
        return "books";
    }
    
    @GetMapping("/book")
    public String requestBookById(@RequestParam("id") String bookId, Model model) {
        System.out.println("================================================================");
        System.out.println("[BookController: requestBookById()으로 매핑되어 컨트롤러로 들어왔습니다]");
        
        System.out.println("요청받은 bookId: " + bookId);
        Book bookById = bookService.getBookById(bookId);
        if (bookById == null) {
            System.out.println("해당 ID의 책을 찾을 수 없음");
        } else {
            System.out.println("Book: " + bookById.getName() + ", Author: " + bookById.getAuthor());
        }
        model.addAttribute("book", bookById);
        
        System.out.println("[book.jsp로 이동합니다]");
        return "book";
    }
    
    
    @GetMapping("/add")
    public String requestAddBookForm(@ModelAttribute("NewBook") Book book) 
    {
    	System.out.println("================================================================");
        System.out.println("[BookController: requestAddBookForm() : 'add'로 매핑되어 컨트롤러로 들어왔습니다]");
        System.out.println("addBook.jsp로 이동합니다");
    	return "addBook";
    }
    
    @PostMapping("/add")
    public String submitAddNewBook(@ModelAttribute("NewBook") Book book) 
    {
    	System.out.println("================================================================");
        System.out.println("[BookController: submitAddNewBook() : 'PostMapping : add'(form태그)로 매핑되어 컨트롤러로 들어왔습니다]");
    	bookService.setNewBook(book);
    	System.out.println("form에서 작성한 데이터를 dto에 담고 books.jsp로 리다렉션 합니다");
    	return "redirect:/books";
    }
    
    @ModelAttribute
    public void addAttributes(Model model) {model.addAttribute("addTitle", "신규 도서 등록");}
    
    
}
