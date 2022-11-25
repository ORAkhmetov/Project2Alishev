package ru.alishev.springcourse.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alishev.springcourse.models.Book;
import ru.alishev.springcourse.models.Person;
import ru.alishev.springcourse.repositories.BooksRepository;


import java.util.List;
import java.util.Optional;

/**
 * @author Oleg Akhmetov on 24.11.2022
 */
@Service
@Transactional(readOnly = true) //Все методы readOnly, если не помечены аналогичной аннотацией
public class BooksService {

    private final BooksRepository booksRepository;


    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;

    }

    public List<Book> findAll(boolean sortByYear) {
        if (sortByYear)
            return booksRepository.findAll(Sort.by("year"));
        else
            return booksRepository.findAll();
    }

    public List<Book> findWithPagination(int page, int itemsPerPage, boolean sortByYear) {
        if (sortByYear)
            return booksRepository.findAll(PageRequest.of(page, itemsPerPage, Sort.by("year"))).getContent();
        else
            return booksRepository.findAll(PageRequest.of(page, itemsPerPage)).getContent();
    }

    public Book findOne(int id) {
        Optional<Book> foundedBook = booksRepository.findById(id);
        return foundedBook.orElse(null);
    }

    @Transactional
    public void save(Book book) {
        booksRepository.save(book);
    }

    @Transactional
    public void update(int id, Book updatedBook) {
        updatedBook.setId(id);
        booksRepository.save(updatedBook);
    }

    @Transactional
    public void delete(int id) {
        booksRepository.deleteById(id);
    }

    public Optional<Person> getBookReader(int id) {
        Optional<Book> book = booksRepository.findById(id);
        return Optional.ofNullable(book.get().getReader());
    }

    @Transactional
    public void assign(int id, Person selectedPerson) {
        Optional<Book> book = booksRepository.findById(id);
        book.get().setReader(selectedPerson);
    }

    @Transactional
    public void release (int id) {
        booksRepository.findById(id).get().setReader(null);
    }
    public List<Book> searchByTitle(String query) {
        return booksRepository.findByTitleStartingWith(query);
    }
}
