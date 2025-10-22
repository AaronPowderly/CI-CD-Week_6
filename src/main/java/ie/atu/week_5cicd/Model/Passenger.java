package ie.atu.week_5cicd.Model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@AllArgsConstructor @Builder
public class Passenger {

    @NotBlank(message = "passengerID is required")
    @Size(message = "size of passengerID to long", max = 40)
    private String passengerID;

    @NotBlank(message = "name is required")
    @Size(message = "size name to long",max = 60)
    private String name;

    @NotBlank(message = "email is required")
    @Email(message = "email must be a valid address")
    private String email;



}
