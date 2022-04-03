package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import beans.Person;

import com.google.common.collect.ImmutableList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;


public class Lecture1 {

    @Test
    public void imperativeApproach() throws IOException {
        List<Person> people = MockData.getPeople();
        // 1. Find people aged less or equal 18
        List<Person> people1 = new ArrayList<>();
        for (Person person : people) {
            if (person.getAge() <= 18) {
                people1.add(person);
            }
        }
        System.out.println("HOMEWORK 1. Find people aged less or equal 18");
        for (Person person : people1) {
            System.out.println(person);
        }
        // 2. Then change implementation to find first 10 people
        List<Person> people2 = new ArrayList<>();
        final int limit = 10;
        int count = 0;
        for (Person person : people) {
            if (count == limit) {
                break;
            }
            people2.add(person);
            count++;
        }
        System.out.println("HOMEWORK 2. Then change implementation to find first 10 people");
        for (Person person : people1) {
            System.out.println(person);
        }

    }

    @Test
    public void declarativeApproachUsingStreams() throws Exception {
        MockData.getPeople().stream()
                .filter(peopl -> peopl.getAge() <= 18)
                .limit(10)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
