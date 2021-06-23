package com.reindeer.repositories;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.reindeer.domain.Reindeer;

import org.springframework.stereotype.Repository;

@Repository
public class ReindeerRepository {
    List<Reindeer> reindeers = buildReindeers();

    public List<Reindeer> buildReindeers() {
        List<Reindeer> reindeers = new ArrayList<>();

        reindeers.add(new Reindeer(1, "Dasher", 14));
        reindeers.add(new Reindeer(2, "Dancer", 20));
        reindeers.add(new Reindeer(3, "Prancer", 8));
        reindeers.add(new Reindeer(4, "Vixen", 40));
        reindeers.add(new Reindeer(5, "Comet", 1000));
        reindeers.add(new Reindeer(6, "Cupid", 18));
        reindeers.add(new Reindeer(7, "Donner", 25));
        reindeers.add(new Reindeer(8, "Blitzen", 5));
        reindeers.add(new Reindeer(9, "Rudolph", 12));

        return reindeers;
    }

    public List<Reindeer> findAll() {
        return reindeers;
    }

    public Optional<Reindeer> findById(Integer id) {
        for (Reindeer reindeer : reindeers) {
            if (reindeer.getId().intValue() == id.intValue()) {
                return Optional.ofNullable(reindeer);
            }
        }

        return Optional.of(null);
    }

    public Reindeer save(Reindeer reindeer) {
        reindeers.add(reindeer);

        return reindeer;
    }

    public void deleteById(Integer id) {
        Iterator<Reindeer> reindeerIterator = reindeers.iterator();
        while (reindeerIterator.hasNext()) {
            if (reindeerIterator.next().getId().intValue() == id.intValue()) {
                reindeerIterator.remove();
            }
        }
    }
}
