package ir.sajjad.springbootsession23.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = SchemaName.schemaName)
public class Book extends BaseEntity {
    private String name;
    private long price;

    public Book(String name, long price) {
        this.name = name;
        this.price = price;
    }

    public Book(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Build builder(){
        return new Build();
    }

    public static class Build{
        public String name;
        public long price;

        public Build name(String name){
            this.name= name;
            return this;
        }

        public Build price(long price){
            this.price = price;
            return this;
        }

        public Book build(){
            return new Book(name,price);
        }

    }
}
