package ir.sajjad.springbootsession23.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(schema = SchemaName.schemaName)
public class Factor extends BaseEntity{
    @ManyToOne
    private User user;


}
