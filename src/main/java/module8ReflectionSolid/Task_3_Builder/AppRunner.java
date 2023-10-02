package module8ReflectionSolid.Task_3_Builder;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppRunner {
    public static void main(String[] args) {
        Person person = Person.builder()
                .name("Sergey")
                .surname("Vorobyev")
                .birthday(BirthInfo.builder()
                        .birthday(LocalDate.of(1990, 1, 1))
                        .birthtime(LocalTime.now())
                        .birthplace("Perm")
                        .weight(3.5)
                        .height(45.0)
                        .build())
                .address(Address.builder()
                        .country("Russia")
                        .city("Saint - Petesburg")
                        .street("Fermskoe shosse")
                        .houseNumber(148)
                        .build())
                .build();

        System.out.println(person);
    }
}
