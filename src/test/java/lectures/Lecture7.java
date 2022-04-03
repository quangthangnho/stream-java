package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import com.google.common.collect.ImmutableList;
import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture7 {

  @Test
  public void count() throws Exception {
    ImmutableList<Person> people = MockData.getPeople();
    long count = people.stream()
            .filter(person -> person.getGender().equalsIgnoreCase("Female"))
            .count();
    System.out.println(count);
  }

  @Test
  public void min() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();
    double min = cars.stream()
            .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
            .mapToDouble(Car::getPrice)
            .min()
            .getAsDouble();
    System.out.println(min);
  }

  @Test
  public void max() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();
    double max = cars.stream()
            .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
            .mapToDouble(Car::getPrice)
            .max()
            .getAsDouble();
    System.out.println(max);
  }


  @Test
  public void average() throws Exception {
    List<Car> cars = MockData.getCars();
    double asDouble = cars.stream()
            .mapToDouble(Car::getPrice)
            .average()
            .getAsDouble();
    System.out.println(asDouble);
  }

  @Test
  public void sum() throws Exception {
    List<Car> cars = MockData.getCars();
    double sum = cars.stream()
        .mapToDouble(Car::getPrice)
        .sum();
    BigDecimal bigDecimalSum = BigDecimal.valueOf(sum);
    System.out.println(sum);
    System.out.println(bigDecimalSum);

  }

  @Test
  public void statistics() throws Exception {
    List<Car> cars = MockData.getCars();
    DoubleSummaryStatistics statistics = cars.stream()
        .mapToDouble(Car::getPrice)
        .summaryStatistics();
    System.out.println(statistics);
    System.out.println(statistics.getAverage());
    System.out.println(statistics.getCount());
    System.out.println(statistics.getMax());
    System.out.println(statistics.getMin());
    System.out.println(statistics.getSum());
  }

}