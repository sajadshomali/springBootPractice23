package ir.sajjad.springbootsession23.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Getter
@Setter
@Table(schema = SchemaName.schemaName)
@AllArgsConstructor
@NoArgsConstructor
@SQLRestriction("enabled is true")
public class User extends BaseEntity{
    private String username;
    private String password;
    private boolean enabled = true;

    public static Build builder(){
        return new Build();
    }

    public static class Build {
        public String username;
        public String password;
        public boolean enabled;

        public Build username(String username){
            this.username = username;
            return this;
        }

        public Build password(String password){
            this.password = password;
            return this;
        }

        public Build enabled(boolean enabled){
            this.enabled = enabled;
            return this;
        }

        public User build(){
            return new User(username,password,enabled);
        }
    }
}