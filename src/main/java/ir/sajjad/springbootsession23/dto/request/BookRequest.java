package ir.sajjad.springbootsession23.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BookRequest {
    @NotNull(message = "{Book.is.null}")
    @NotBlank(message = "{Book.is.empty}")
    private String name;
    @NotNull(message = "{book.price.is.null}")
    @Min(value = 0, message = "{price.is.lower.than.min}")
    private long price;


    public BookRequest(String name, long price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }
}
