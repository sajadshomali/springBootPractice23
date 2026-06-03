package ir.sajjad.springbootsession23.dto.response;

public class BookResponse {
    private Long id;
    private String name;
    private long price;

    public BookResponse(Long id,String name, long price) {
        this.id= id;
        this.name = name;
        this.price = price;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Builder builder(){
        return new Builder();
    }

    public static class Builder{
        public Long id;
        public String name;
        public long price;

        public Builder name(String name){
            this.name= name;
            return this;
        }

        public Builder price(long price){
            this.price = price;
            return this;
        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public BookResponse build(){
            return new BookResponse(id,name,price);
        }

    }
}
