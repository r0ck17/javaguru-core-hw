package module8ReflectionSolid.Task_3_Builder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Address {
    private String country;
    private String city;
    private String street;
    private Integer houseNumber;
}
