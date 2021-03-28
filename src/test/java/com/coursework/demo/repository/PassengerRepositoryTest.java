package com.coursework.demo.repository;

import com.coursework.demo.entity.Passenger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
public class PassengerRepositoryTest {

    @Autowired
    private PassengerRepository passengerRepository;

    @Test
    @Sql("/getPassengersByRoute.sql")
    public void testGetPassengersByRoute() {
        List<Passenger> result = passengerRepository.getPassengersByRoute(1L);

        assertFalse(result.isEmpty());
        assertEquals(getExpectedPassengersList(), result);
    }

    private List<Passenger> getExpectedPassengersList() {
        return Arrays.asList(
                Passenger.builder().id(1L).email("abc@gmail.com").name("Oleg").surname("Kucherenko").build(),
                Passenger.builder().id(2L).email("adc@gmail.com").name("Dima").surname("Andriichuk").build(),
                Passenger.builder().id(3L).email("azx@gmail.com").name("Andrii").surname("Batuiev").build(),
                Passenger.builder().id(4L).email("zzz@gmail.com").name("Serhii").surname("Kachmarskiy").build()
        );
    }
}
