package com.xpy.web;

import com.xpy.Service.BookService;
import com.xpy.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class BookController {
    //autowired
    @Autowired
    private BookService bookService;

    private List<Book> bookList;

    //get all the book records
    @RequestMapping(value="/books", method=RequestMethod.GET)
    public List<Book> getBooks(){

        List<Book> bookList=new ArrayList<Book>();
        bookList=bookService.getBooks();

        return bookList;
    }

    /*//create book record
    @RequestMapping(value="/books", method=RequestMethod.POST)
    public Book saveBook(@RequestParam String name,
                         @RequestParam String description,
                         @RequestParam String author,
                         @RequestParam String isbn,
                         @RequestParam int status,
                         @RequestParam Long id){

        Book newBook=new Book();
        newBook.setAuthor(author);
        newBook.setName(name);
        newBook.setDescription(description);
        newBook.setIsbn(isbn);
        newBook.setStatus(status);
        newBook.setId(id);

        newBook=bookService.save(newBook);

        return newBook;
    }*/


    //get one book record
    @RequestMapping(value="/books/{id}", method=RequestMethod.GET)
    public Book getOneBook(@PathVariable Long id){
        Book book=bookService.getOne(id);

        return book;
    }


    @RequestMapping(value="/books", method=RequestMethod.PUT)
    public Book updateBook(@RequestParam String name,
                           @RequestParam String description,
                           @RequestParam String author,
                           @RequestParam String isbn,
                           @RequestParam int status,
                           @RequestParam Long id){

        Book newBook=new Book();
        newBook.setAuthor(author);
        newBook.setName(name);
        newBook.setDescription(description);
        newBook.setIsbn(isbn);
        newBook.setStatus(status);
        newBook.setId(id);

        newBook=bookService.save(newBook);

        return newBook;
    }


    //delete a book record
    @RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
    public void deleteBook(@PathVariable Long id){



        bookService.delete(id);


    }

/*
    @RequestMapping(value="/books/", method=RequestMethod.POST)
    public List<Book> findByAuthorAndStatus(@RequestParam String author, @RequestParam int status){



        return bookService.findByAuthorAndStatus(author, status);


    }
*/

 /*   @RequestMapping(value="/books/", method=RequestMethod.POST)
    public List<Book> findByAuthorAndStatus(@RequestParam int len){

        return bookService.findByAuthorAndStatus(len);

    }*/

    @RequestMapping(value="/books/", method=RequestMethod.POST)
    public List<Book> findByAuthorAndStatus2(@RequestParam int len){

        return bookService.findByAuthorAndStatus2(len);

    }

    @RequestMapping(value="/books/update", method=RequestMethod.POST)
    public int updateABook(@RequestParam String author, @RequestParam int status){

        return bookService.updateByJPQL(author, status);

    }
}
