package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.springmvc.domain.Book;
import com.springmvc.service.BookService;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value="/books", method = RequestMethod.GET)
    public String requestBookList(Model model) {
        System.out.println("BookController: /books 요청 받음");
        List<Book> list = bookService.getAllBookList();
        if(list == null)
        	System.out.println("받아온 ArrayList가 없음");
        else {System.out.println("dto" + list.size()+ "개 받아옴");}
        model.addAttribute("bookList", list);
        System.out.println("BookController: 모델에 bookList 추가");
        return "books";
    }
}
