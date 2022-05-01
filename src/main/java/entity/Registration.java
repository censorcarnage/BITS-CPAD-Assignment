package entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Registration {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private Long mobileNumber;
    private Long pincode;
    private String type;
}
