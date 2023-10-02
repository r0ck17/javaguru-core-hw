1) Подключите lombok

2) Для класса Person из предыдущего задания, сделайте адрес классом Address с полями:

private String Country;

private String city;

private String street;

private Integer houseNumber;

Создайте конструктор по умолчанию, конструктор со всеми аргументами, геттеры и сеттры, toString, equals и hashCode  для Address и для Person

*Попробуйте аннотацию Data, какие аннотации теперь можно убрать?

3) Сделайте неизменяемый класс BirthInfo вместо поля год рождения с полями

private final LocalDate birthday;

private final LocalTime birthtime;

private final String birthplace;

private final Double weight;

private final Double height;

Добавьте аннотацию @Value

Проверьте в idea какой код генерирует аннотация  Refactor->Delombok->@Value

4) Создайте объект Person одной строкой через builder