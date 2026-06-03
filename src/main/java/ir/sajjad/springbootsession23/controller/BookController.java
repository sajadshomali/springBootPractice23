package ir.sajjad.springbootsession23.controller;

import ir.sajjad.springbootsession23.dto.request.BookRequest;
import ir.sajjad.springbootsession23.dto.response.BookResponse;
import ir.sajjad.springbootsession23.service.BookService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookResponse> save(@RequestBody @Valid BookRequest bookRequest){
        return ResponseEntity.ok(bookService.save(bookRequest));
    }

    @GetMapping("/list")
    public ResponseEntity<Page<BookResponse>>showBookList(Pageable pageable){
      return ResponseEntity.ok(bookService.findAll(pageable));
    }

}
