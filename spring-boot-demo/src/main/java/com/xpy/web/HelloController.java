package com.xpy.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class HelloController {

   /* @Autowired
    private Book book;*/

    @RequestMapping("/say")
    public String hello() {

        return "Hello Spring Boot"; //return a String

    }

    @RequestMapping(value="/books", method=RequestMethod.GET)
    public String getAll() {
        return "books";  //return a string, but this string also same name as a mapping html file, so it returns to the html file.

    }

  /*  @GetMapping("/books/{id}/{username}")
    public Object getOne(@PathVariable("id") long wojiubuidxx, @PathVariable String username){
        System.out.println(wojiubuidxx+" "+username);

        return book;
    }*/

    /*@PostMapping("/books")
    public Object post(@RequestParam("name") String name,
                       @RequestParam("author") String author,
                       @RequestParam("isbn") String isbn){

        Map<String, Object> book=new HashMap<String, Object>();
        book.put("name", name);
        book.put("author", author);
        book.put("isbn", isbn);

        return book;

    }*/
}
