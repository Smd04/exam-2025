package org.example.exam.Controller;

import org.example.exam.DAO.BookDAO;
import org.example.exam.Model.Book;

public class BookController {
    private BookDAO bookDAO=new BookDAO();
    private Book book=new Book();

    public void add(Book book){
        bookDAO.addBook(book);
        book=new Book();
    }

    public void update(Book book){
        bookDAO.updateBook(book);
        book=new Book();
    }
    public void delete(long id){
        bookDAO.deleteBook(id);
    }
    public Book get(long id){
        return bookDAO.getBookById(id);
    }
}
