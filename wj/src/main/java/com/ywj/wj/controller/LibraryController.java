package com.ywj.wj.controller;

import com.sun.org.apache.xpath.internal.compiler.Keywords;
import com.ywj.wj.pojo.Book;
import com.ywj.wj.pojo.Search;
import com.ywj.wj.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin
public class LibraryController {
    @Autowired
    private BookService bookService;

    @GetMapping("/api/books")
    public List<Book> list() throws Exception {
        return bookService.list();
    }

    @PostMapping("/api/books")
    public Book addOrUpdate(@RequestBody Book book) throws Exception {
        bookService.addOrUpdate(book);
        return book;
    }

    @PostMapping("/api/delete")
    public void delete(@RequestBody Book book) throws Exception {
        bookService.deleteById(book.getId());
    }

    @PostMapping("/api/search")
    public List<Book> searchResult(@RequestBody Search search) throws Exception {
        System.out.println(search.getKeywords());
        if (search.getKeywords() == null) {
            return bookService.list();
        } else {
            System.out.println(bookService.search(search.getKeywords()));
            return bookService.search(search.getKeywords());
        }
    }

    @GetMapping("/api/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") Integer cid) throws Exception {
        if (cid != 0) {
            return bookService.listByCategory(cid);
        } else {
            return list();
        }
    }

    @PostMapping("/api/cover")
    public String coverUpload(MultipartFile file, HttpServletRequest request) throws Exception {
        String folder = "E:/Image/img";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, getRandomString(5) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        String fileName = file.getName();
        System.out.println("========>" + fileName);
        System.out.println("========>" + file.getOriginalFilename());
        if (! f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8443/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0;i < length;i ++) {
            int number = random.nextInt(base.length());
            buffer.append(base.charAt(number));
        }
        return buffer.toString();
    }
}
