package ir.sajjad.springbootsession23.service;

import ir.sajjad.springbootsession23.dto.request.BookRequest;
import ir.sajjad.springbootsession23.dto.response.BookResponse;

public interface BookService{

    BookResponse save(BookRequest bookRequest);
}
