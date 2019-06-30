package com.ywj.wj.dao;

import com.ywj.wj.pojo.Book;
import com.ywj.wj.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Integer> {
    List<Book> findAllByCategory(Category category);

    @Query(value = "from Book where title like %?1% or author like %?1%")
    List<Book> findAllByNameMatch(String keywords);
}
