package module8ReflectionSolid.Task_3_Builder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Person {
    private String name;
    private String surname;
    private BirthInfo birthday;
    private Address address;
}