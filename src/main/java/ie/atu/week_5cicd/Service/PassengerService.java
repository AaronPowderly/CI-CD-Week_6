package ie.atu.week_5cicd.Service;

import ie.atu.week_5cicd.Model.Passenger;
import ie.atu.week_5cicd.errorHandling.DuplicateException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PassengerService {
    private final List<Passenger> store = new ArrayList<>();

    public List<Passenger> findALL() {
        return new ArrayList<>(store);
    }

    public Optional<Passenger> findById(String id) {
        for (Passenger p : store) {
            if (p.getPassengerID().equals(id)) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    public Passenger create(Passenger p) {
        for (Passenger pass : store) {
            if (findById(p.getPassengerID()).isPresent()) {
                throw new DuplicateException("Passenger with ID " + p.getPassengerID() + " already exists");
            }
        }
        store.add(p);
        return p;
    }

    public Passenger update(Passenger p) {
        if (findById(p.getPassengerID()).isPresent()) {
            throw new IllegalArgumentException("Passenger not found");
        }
        store.add(p);
        return p;
    }



}
