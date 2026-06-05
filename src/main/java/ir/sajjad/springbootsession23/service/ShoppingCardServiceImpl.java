package ir.sajjad.springbootsession23.service;

import ir.sajjad.springbootsession23.dto.request.ShoppingCardRequest;
import ir.sajjad.springbootsession23.dto.response.ShoppingCardResponse;
import ir.sajjad.springbootsession23.exception.MyRuleException;
import ir.sajjad.springbootsession23.model.*;
import ir.sajjad.springbootsession23.repository.BookRepository;
import ir.sajjad.springbootsession23.repository.FactorRepository;
import ir.sajjad.springbootsession23.repository.ShoppingCardRepository;
import ir.sajjad.springbootsession23.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class ShoppingCardServiceImpl implements ShoppingCardService {
    private final ShoppingCardRepository shoppingCardRepository;
    private final FactorRepository factorRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public ShoppingCardServiceImpl(ShoppingCardRepository shoppingCardRepository, FactorRepository factorRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.shoppingCardRepository = shoppingCardRepository;
        this.factorRepository = factorRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public ShoppingCardResponse save(ShoppingCardRequest shoppingCardRequest) {
        User user = userRepository.findById(shoppingCardRequest.getUserId()).orElseThrow(()
                -> new MyRuleException("User.not.exist"));
        Book book = bookRepository.findById(shoppingCardRequest.getBookId()).orElseThrow(
                () -> new MyRuleException("Book.not.exist"));
        Optional<Factor> factorByID = factorRepository.findByUserAndPayed(user, Payed.UNPAYED);
        Factor factor;
        factor = factorByID.orElseGet(() -> createFactor(user));
        factorRepository.save(factor);
        return  createShoppingCardResponse(shoppingCardRepository.save(createShoppingCard(factor, book, shoppingCardRequest)));
    }

    private ShoppingCard createShoppingCard(Factor factor, Book book, ShoppingCardRequest shoppingCardRequest) {
        return ShoppingCard.builder()
                .factor(factor)
                .book(book)
                .count(shoppingCardRequest.getCount()).build();
    }

    private Factor createFactor(User user) {
        return Factor.builder()
                .payed(Payed.UNPAYED)
                .user(user)
                .build();
    }

    private ShoppingCardResponse createShoppingCardResponse(ShoppingCard shoppingCard){
        return ShoppingCardResponse.builder()
                .shoppingCardId(shoppingCard.getId())
                .factorId(shoppingCard.getFactor().getId())
                .build();
    }
}
