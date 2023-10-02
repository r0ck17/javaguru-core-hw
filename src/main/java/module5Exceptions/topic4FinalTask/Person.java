package module5Exceptions.topic4FinalTask;

import java.time.LocalDate;
import java.util.Objects;

public final class Person {
    private final String name;
    private String telephone;
    private final LocalDate createdDate;

    public Person(String name, String telephone, LocalDate createdDate) {
        this.name = name;
        this.telephone = telephone;
        this.createdDate = createdDate;
    }

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(telephone, person.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, telephone);
    }
}
