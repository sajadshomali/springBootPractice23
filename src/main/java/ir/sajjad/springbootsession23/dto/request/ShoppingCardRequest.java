package ir.sajjad.springbootsession23.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class ShoppingCardRequest {
    @NotNull(message ="User.id.is.null" )
    private Long userId;
    @NotNull(message = "Book.id.is.null")
    private Long bookId;
    @NotNull(message ="count.is.null")
    @Min(value = 1,message = "count.not.valid")
    private int count;

    public ShoppingCardRequest(Long userId, long bookId, int count) {
        this.userId = userId;
        this.bookId = bookId;
        this.count = count;
    }

    public Long getUserId() {
        return userId;
    }

    public long getBookId() {
        return bookId;
    }

    public int getCount() {
        return count;
    }
}
