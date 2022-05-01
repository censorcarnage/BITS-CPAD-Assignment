package entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
@Document("ProductCatalogue")
public class Product {
    @Id
    private String id;
    private String vendorId;
    private String vendorName;
    private String productDescription;
    private String category;
    private Long unitPrice;
    private AvailableColors availableColors;
    private String availableSizes;
    private int unitsInStock;
    private int unitWeight;
    private String picture;
    private String gender;
}
