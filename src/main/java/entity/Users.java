package entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
@Document("Users")
public class Users {
    @Id
    private String id;

    @Field("userName")
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
    @Field("pinCode")
    private Long pincode;
    private String type;
}
