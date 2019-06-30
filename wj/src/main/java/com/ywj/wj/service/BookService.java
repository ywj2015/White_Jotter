package com.ywj.wj.service;

import com.ywj.wj.dao.BookDao;
import com.ywj.wj.pojo.Book;
import com.ywj.wj.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    @Autowired
    private CategoryService categoryService;

    public List<Book> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return bookDao.findAll(sort);
    }

    public void addOrUpdate(Book book) {
        bookDao.save(book);
    }

    public void deleteById(Integer id) {
        bookDao.deleteById(id);
    }

    public List<Book> search(String keywords) {
        return bookDao.findAllByNameMatch("%" + keywords + "%");
    }

    public List<Book> listByCategory(Integer cid) {
        Category category = categoryService.get(cid);
        return bookDao.findAllByCategory(category);
    }
}
