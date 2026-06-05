package ir.sajjad.springbootsession23.controller;

import ir.sajjad.springbootsession23.dto.request.ShoppingCardRequest;
import ir.sajjad.springbootsession23.dto.response.ShoppingCardResponse;
import ir.sajjad.springbootsession23.model.ShoppingCard;
import ir.sajjad.springbootsession23.service.ShoppingCardService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping")
public class ShoppingCardController {
    private final ShoppingCardService shoppingCardService;

    public ShoppingCardController(ShoppingCardService shoppingCardService) {
        this.shoppingCardService = shoppingCardService;
    }

    @PostMapping("/order")
    public ResponseEntity<ShoppingCardResponse> addBook(@RequestBody @Valid ShoppingCardRequest shoppingCardRequest){
        return ResponseEntity.ok(shoppingCardService.save(shoppingCardRequest));
    }
}
