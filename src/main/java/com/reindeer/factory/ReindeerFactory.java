package com.reindeer.factory;

import java.util.concurrent.ThreadLocalRandom;

import com.reindeer.domain.Reindeer;
import com.reindeer.requests.ReindeerBody;

import org.springframework.stereotype.Component;

@Component
public class ReindeerFactory {
    public Reindeer build(ReindeerBody body) {
        Integer id = ThreadLocalRandom.current().nextInt(0, 12 + 1);
        String name = body.getName();
        Integer age = body.getAge();

        return new Reindeer(id, name, age);
    }
}
