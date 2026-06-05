package ir.sajjad.springbootsession23.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(schema = SchemaName.schemaName)
public class ShoppingCard extends BaseEntity{
    private int count;
    @ManyToOne
    private Book book;
    @ManyToOne
    private Factor factor;

    public ShoppingCard(int count, Book book, Factor factor) {
        this.count = count;
        this.book = book;
        this.factor = factor;
    }

    public ShoppingCard() {
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        public int count;
        public Book book;
        public Factor factor;
        public Builder count(int count){
            this.count = count;
            return this;
        }
        public Builder book(Book book){
            this.book =book;
            return this;
        }
        public Builder factor(Factor factor){
            this.factor = factor;
            return this;
        }

        public ShoppingCard build(){
            return new ShoppingCard(count,book,factor);
        }
    }
}
