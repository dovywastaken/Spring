package com.springmvc.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.springmvc.domain.Book;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private List<Book> listOfBooks = new ArrayList<Book>();

    public BookRepositoryImpl() {
        Book book1 = new Book("ISBN1234", "C# 교과서", 30000);
        book1.setAuthor("박용준");
        book1.setDescription("C# 교과서 설명");
        book1.setPublisher("길벗");
        book1.setCategory("IT전문서");
        book1.setUnitsInstock(1000);
        book1.setReleaseDate("2020/05/29");

        Book book2 = new Book("ISBN1235", "Node.js 교과서", 36000);
        book2.setAuthor("조현영");
        book2.setDescription("Node.js 교과서 설명");
        book2.setPublisher("길벗");
        book2.setCategory("IT전문서");
        book2.setUnitsInstock(1000);
        book2.setReleaseDate("2020/07/25");

        Book book3 = new Book("ISBN1236", "어도비 XD CC 2020", 25000);
        book3.setAuthor("김두한");
        book3.setDescription("어도비 XD CC 2020 설명");
        book3.setPublisher("길벗");
        book3.setCategory("IT활용서");
        book3.setUnitsInstock(1000);
        book3.setReleaseDate("2019/05/29");

        listOfBooks.add(book1);
        listOfBooks.add(book2);
        listOfBooks.add(book3);
    }

    @Override
    public List<Book> getAllBookList() {
        System.out.println("BookRepositoryImpl: getAllBookList 호출");
        return listOfBooks;
    }
}
