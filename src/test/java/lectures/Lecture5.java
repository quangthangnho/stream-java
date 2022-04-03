package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();
    List<Car> carList =  cars.stream()
            .filter(car -> car.getPrice() > 20000)
            .collect(Collectors.toList());

  }

  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();
//    List<PersonDTO> personDTOS = people.stream()
//            .map(person -> {
//              PersonDTO personDTO = new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
//              return personDTO;
//            })
//            .collect(Collectors.toList());
    List<PersonDTO> personDTOS = people.stream()
            .map(PersonDTO::map)
            .collect(Collectors.toList());

  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
    ImmutableList<Car> cars = MockData.getCars();
//    double asDouble = cars.stream()
//            .mapToDouble(car -> car.getPrice())
//            .average()
//            .getAsDouble();
    double asDouble = cars.stream()
            .mapToDouble(Car::getPrice)
            .average()
            .getAsDouble();
    System.out.println(asDouble);

  }

  @Test
  public void test() throws Exception {

  }
}



