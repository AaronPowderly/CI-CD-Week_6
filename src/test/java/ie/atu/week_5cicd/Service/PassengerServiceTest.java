package ie.atu.week_5cicd.Service;


import ie.atu.week_5cicd.Model.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class PassengerServiceTest {

    private PassengerService service;

    @BeforeEach
    void setUp() { service = new PassengerService(); }

    @Test
    void createThenFindById() {
        Passenger p = Passenger.builder()
                .passengerID("A1")
                .name("Aaron")
                .email("Aaron@atu.ie")
                .build();

        service.create(p);
        Optional<Passenger> found = service.findById("A1");
        assertTrue(found.isPresent());
        assertEquals("Aaron", found.get().getName());
    }

    @Test
    void duplicateIdThrows() {
        service.create(Passenger.builder()
                .passengerID("A2")
                .name("James")
                .email("James@atu.ie")
                .build());

        assertThrows(IllegalArgumentException.class, () ->
                service.create(Passenger.builder()
                        .passengerID("A2")
                        .name("Jimmy")
                        .email("James@ex.com")
                        .build()));

    }
}
