package ir.sajjad.springbootsession23.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponse {
    private final Long id;
    private final String username;
    private final boolean enabled;

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        public Long id;
        public String username;
        public boolean enabled;

        public Builder id(Long id){
            this.id = id;
            return this;
        }
        public Builder username(String username){
            this.username=username;
            return this;
        }
        public Builder enabled(boolean enabled){
            this.enabled = enabled;
            return this;
        }
        public UserResponse build(){
            return new UserResponse(id,username,enabled);
        }
    }
}
