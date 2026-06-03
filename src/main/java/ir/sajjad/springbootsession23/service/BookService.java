package ir.sajjad.springbootsession23.service;

import ir.sajjad.springbootsession23.dto.request.BookRequest;
import ir.sajjad.springbootsession23.dto.response.BookResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService{

    BookResponse save(BookRequest bookRequest);

    Page<BookResponse> findAll(Pageable pageable );

   List<BookResponse> findByName(String name);

}
