package ir.sajjad.springbootsession23.service;

import ir.sajjad.springbootsession23.dto.request.ShoppingCardRequest;
import ir.sajjad.springbootsession23.dto.response.ShoppingCardResponse;

public interface ShoppingCardService {
    ShoppingCardResponse save(ShoppingCardRequest shoppingCardRequest);
}
