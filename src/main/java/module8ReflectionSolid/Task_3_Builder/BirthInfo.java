package module8ReflectionSolid.Task_3_Builder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@AllArgsConstructor
@Value
public class BirthInfo {
    LocalDate birthday;
    LocalTime birthtime;
    String birthplace;
    Double weight;
    Double height;
}
