package ir.sajjad.springbootsession23.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(schema = SchemaName.schemaName)
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity{
    private String username;
    private String password;

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        public String username;
        public String password;

        public Builder username(String username){
            this.username = username;
            return this;
        }
        public Builder password(String password){
            this.password = password;
            return this;
        }

        public User build(){
            return new User(username,password);
        }
    }
}