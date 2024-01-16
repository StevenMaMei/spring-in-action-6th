package tacos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
// JPA Requires no args constructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Table("ingredients")
public class Ingredient {

    @PrimaryKey
    private final String id;
    private final String name;
    private final Type   type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
