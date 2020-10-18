package com.fukuda.bookstore.ms.book.controller;

import com.fukuda.bookstore.base.dto.BookDto;
import com.fukuda.bookstore.ms.book.entity.Author;
import com.fukuda.bookstore.ms.book.entity.Book;
import com.fukuda.bookstore.ms.book.enums.BookCategory;
import com.fukuda.bookstore.ms.book.form.BookForm;
import com.fukuda.bookstore.ms.book.mapper.BookDtoMapper;
import com.fukuda.bookstore.ms.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/book")
public class BookRestController extends BaseCrudRestController {
    @Autowired
    protected BookService mService;
    @Autowired
    protected BookDtoMapper bookDtoMapper;

    @GetMapping(path = "/")
    public Iterable<BookDto> index(){
        return bookDtoMapper.toDto(mService.findAll());
    }

    @GetMapping(path = "/{id}")
    public BookDto index(@PathVariable(value = "id") Book entity){
        return bookDtoMapper.toDto(mService.findById(entity.getId()).get());
    }

    @PostMapping(path = "/")
    public BookDto  create(@Valid @RequestBody BookForm baseForm){
        return bookDtoMapper.toDto(mService.create(baseForm));
    }

    @PatchMapping(path = "/{id}")
    public BookDto create(@PathVariable(name = "id") Book entity, @Valid @RequestBody BookForm baseForm){
        return bookDtoMapper.toDto(mService.update(entity.getId(), baseForm));
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable(name = "id") Book entity){
        mService.deleteById(entity.getId());
    }

    @GetMapping(path = "/category/{category}")
    public Iterable<BookDto> findAllByBookCategory(@PathVariable(name = "category") BookCategory bookCategory){
        return bookDtoMapper.toDto(this.mService.findAllByBookCategory(bookCategory));
    }

    @GetMapping(path = "/author/{author}")
    public Iterable<BookDto> findAllByAuthor(@PathVariable(name = "author") Author author){
        return bookDtoMapper.toDto(this.mService.findAllByAuthors(author));
    }
}
