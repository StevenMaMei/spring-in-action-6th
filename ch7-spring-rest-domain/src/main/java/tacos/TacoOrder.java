package tacos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import org.hibernate.validator.constraints.CreditCardNumber;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Data
@Entity
public class TacoOrder {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    private Date placedAt;

    @NotBlank(message = "Delivery name is required")
    private String deliveryName;

    @NotBlank(message = "Street is required")
    private String deliveryStreet;

    @NotBlank(message = "City is required")
    private String deliveryCity;

    @NotBlank(message = "State is required")
    private String deliveryState;

    @NotBlank(message = "Zip code is required")
    private String deliveryZip;

    @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber;

    @Pattern(regexp="(^0[1-9]|1[0-2])([\\/])([2-9][0-9])", message = "Must be formatted MM/YY")
    private String ccExpiration;
    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;

    // one Order many tacos
    @OneToMany(cascade = CascadeType.ALL)
    private List<Taco> tacos = new ArrayList<>();
    public void addTaco(Taco taco) {
        tacos.add(taco);
    }
}
