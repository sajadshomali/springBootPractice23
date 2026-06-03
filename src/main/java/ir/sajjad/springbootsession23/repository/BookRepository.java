package ir.sajjad.springbootsession23.repository;

import ir.sajjad.springbootsession23.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
