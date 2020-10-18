package com.fukuda.bookstore.ms.book.service;

import com.fukuda.bookstore.ms.book.entity.Author;
import com.fukuda.bookstore.ms.book.entity.Book;
import com.fukuda.bookstore.ms.book.enums.BookCategory;
import com.fukuda.bookstore.ms.book.exception.BookNotFoundException;
import com.fukuda.bookstore.ms.book.form.BookForm;
import com.fukuda.bookstore.ms.book.observable.BookCreatedObservable;
import com.fukuda.bookstore.ms.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BookServiceImpl extends BaseCrudServiceImpl<Book, BookForm, BookRepository> implements BookService {
    private AuthorServiceImpl mAuthorService;
    private BookCreatedObservable mBookCreatedObservable;

    @Autowired
    public BookServiceImpl(
            AuthorServiceImpl authorService,
            BookCreatedObservable bookCreatedObservable
    ) {
        this.mAuthorService = authorService;
        this.mBookCreatedObservable = bookCreatedObservable;
    }

    public Book create(BookForm bookForm){
        Book book = this.createBook(bookForm);
        mBookCreatedObservable.notify(book);
        return book;
    }

    public Book update(Integer bookId, BookForm bookForm){
        Book book = this.updateBook(bookId, bookForm);
        return book;
    }

    @Transactional(rollbackFor = Exception.class)
    private Book createBook(BookForm bookForm){
        Book book = new Book();
        fillEntityDataFromForm(book, bookForm);
        return mRepository.save(book);
    }

    @Transactional(rollbackFor = Exception.class)
    private Book updateBook(Integer bookId, BookForm bookForm){
        Book book = this.findById(bookId).orElseThrow(BookNotFoundException::new);
        fillEntityDataFromForm(book, bookForm);
        return book;
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Book> findAllByBookCategory(BookCategory bookCategory) {
        return this.mRepository.findAllByBookCategory(bookCategory);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Book> findAllByAuthors(Author author) {
        return this.mRepository.findAllByAuthors(author);
    }

    private void fillEntityDataFromForm(Book book, BookForm bookForm){
        book.getAuthors().clear();
        bookForm.getAuthors().stream().forEach(id -> {
            Optional<Author> author = mAuthorService.findById(id);
            if(author.isPresent()){
                book.getAuthors().add(author.get());
            }
        });
        book.setName(bookForm.getName());
        book.setBookCategory(BookCategory.getById(bookForm.getBookCategory()));
    }
}
