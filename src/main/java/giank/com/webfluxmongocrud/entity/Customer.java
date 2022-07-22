package giank.com.webfluxmongocrud.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Document("CUSTOMER")
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    String _id;

    @NotEmpty
    String name;

    @NotEmpty
    String lastName;

    @NotNull
    String dni;

    @NotNull
    Integer edad;

    @NotNull
    String sexo;
}
