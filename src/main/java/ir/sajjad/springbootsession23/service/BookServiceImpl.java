package ir.sajjad.springbootsession23.service;

import ir.sajjad.springbootsession23.dto.request.BookRequest;
import ir.sajjad.springbootsession23.dto.response.BookResponse;
import ir.sajjad.springbootsession23.exception.MyRuleException;
import ir.sajjad.springbootsession23.model.Book;
import ir.sajjad.springbootsession23.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookResponse save(BookRequest bookRequest) {
        Optional<Book> book = bookRepository.findByName(bookRequest.getName());
       if (book.isPresent()){
           throw new MyRuleException("Book.is.exist");
       }
        return mapBookToBookResponse(bookRepository.save(mapBookRequestToBook(bookRequest)));
    }

    @Override
    public Page<BookResponse> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable).map((book)->
                new BookResponse.Builder()
                        .id(book.getId())
                        .name(book.getName())
                        .price(book.getPrice())
                        .build());
    }

    @Override
    public List<BookResponse> findByName(String name) {
      return bookRepository.findByNameAsList(name).stream().map((book)->
                new BookResponse().builder()
                        .name(book.getName())
                        .id(book.getId())
                        .price(book.getPrice())
                        .build()).toList();
    }

    @Override
    public BookResponse findById(long id) {
        return mapBookToBookResponse(bookRepository.findById(id).orElseThrow(
                 ()->new MyRuleException("Book.not.found")));
    }

    private BookResponse mapBookToBookResponse(Book book){
        return new BookResponse.Builder()
                .id(book.getId())
                .name(book.getName())
                .price(book.getPrice())
                .build();
    }

    private Book mapBookRequestToBook(BookRequest bookRequest){
        return new Book.Build()
                .name(bookRequest.getName())
                .price(bookRequest.getPrice())
                .build();
    }
}
