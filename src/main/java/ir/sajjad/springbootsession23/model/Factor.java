package ir.sajjad.springbootsession23.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(schema = SchemaName.schemaName)
public class Factor extends BaseEntity{
    @ManyToOne
    private User user;
    @Enumerated(EnumType.STRING)
    private Payed payed;
}
