package tacos;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Table("tacos")
public class Taco {

    @PrimaryKeyColumn(type= PrimaryKeyType.PARTITIONED)
    private UUID id;
    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED,
                        ordering = Ordering.DESCENDING)
    private Date createdAt = new Date();

    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    @Size(min = 1, message = "You must choose at least 1 ingredient")
    @Column("ingredients")
    private List<IngredientUDT> ingredients;

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(TacoUDRUtils.toIngredientUDT(ingredient));
    }
}
