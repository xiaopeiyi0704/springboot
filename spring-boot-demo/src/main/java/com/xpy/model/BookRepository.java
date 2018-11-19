package com.xpy.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

   // public List<Book> findByAuthorAndStatus(String author, int status);

    public List<Book> findByAuthorAndStatus(String author, int status);

    @Query("select b from Book b where length(b.name)>?1")
    public List<Book> findBookByNameLength(int len);

    @Query(value="select * from book where length(name)>?1", nativeQuery=true)
    public List<Book> findBookByNameLength2(int len);

    @Transactional
    @Modifying
    @Query("update Book b set b.status=?2 where author=?1")
    public int updateByJPQL(String author, int status);
}
