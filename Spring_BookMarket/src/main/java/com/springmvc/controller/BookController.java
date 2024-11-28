package com.springmvc.controller;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.domain.Book;
import com.springmvc.exception.BookIdException;
import com.springmvc.exception.CategoryException;
import com.springmvc.service.BookService;
import com.springmvc.validator.BookValidator;
import com.springmvc.validator.UnitsInstockValidator;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;
    
    @Autowired
    private BookValidator bookValidator;

    @GetMapping
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
        if (booksByCategory == null || booksByCategory.isEmpty()) {
            throw new CategoryException();
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
    public String submitAddNewBook(@Valid @ModelAttribute("NewBook") Book book, BindingResult result, HttpServletRequest req) {
        System.out.println("================================================================");
        System.out.println("[BookController: submitAddNewBook() : 'PostMapping : add'(form태그)로 매핑되어 컨트롤러로 들어왔습니다]");
        
        String save = req.getServletContext().getRealPath("/resources/images");
        if (save == null) {
            System.out.println("경로 불러오기 실패");
        } else {
            System.out.println("저장 경로" + save);
        }
        
        if (result.hasErrors()) {
            return "addBook";
        }
        
        MultipartFile bookImage = book.getBookImage();
        if (bookImage == null) {
            System.out.println("dto에서 이미지 불러오기 실패");
        } else {
            System.out.println("dto에서 불러온 책 " + bookImage);
        }
        
        String saveName = bookImage.getOriginalFilename();
        if (saveName == null) {
            System.out.println("파일 이름 불러오기 실패");
        } else {
            System.out.println("DTO에서 불러온 파일 이름은 " + saveName);
        }
        
        File saveFile = new File(save, saveName);
        if (saveFile == null) {
            System.out.println("saveFile 실패" + saveFile);
        } else {
            System.out.println("saveFile 성공" + saveFile);
        }
        
        if (bookImage != null && !bookImage.isEmpty()) {
            try {
                bookImage.transferTo(saveFile);
                book.setFileName(saveName);
            } catch (Exception e) {
                throw new RuntimeException("도서 이미지 업로드가 실패하였습니다", e);
            }
        }
        
        bookService.setNewBook(book);
        System.out.println("form에서 작성한 데이터를 dto에 담고 books.jsp로 리다렉션 합니다");
        return "redirect:/books";
    }

    
    @ModelAttribute
    public void addAttributes(Model model) {model.addAttribute("addTitle", "신규 도서 등록");}
    
    @InitBinder
    public void initBinder(WebDataBinder binder) 
    //WebDataBinder는 컨트롤러로 넘어오는 데이터를 특정 객체 예)Book 에 바인딩하고 등록된 Validator를 사용해서 유효성 검사를 수행해요
    {
    	//binder.setValidator((Validator) unitsInstockValidator);
    	binder.setValidator(bookValidator);
    	binder.setAllowedFields("bookId", "name", "unitPrice", "author", "description", "publisher", "category", "unitsInstock","totalPages", "releaseDate", "condition", "bookImage");
    }
    
    @ExceptionHandler(value= {BookIdException.class})
    public ModelAndView handleError(HttpServletRequest req, BookIdException exception) 
    {
    	ModelAndView mav = new ModelAndView();
    	mav.addObject("invalidBookId", exception.getBookId());
    	mav.addObject("exception", exception);
    	mav.addObject("url", req.getRequestURI() + "?" + req.getQueryString());
    	mav.setViewName("errorBook");
    	return mav;
    }
}
