package com.reindeer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.reindeer.domain.Reindeer;
import com.reindeer.factory.ReindeerFactory;
import com.reindeer.repositories.ReindeerRepository;
import com.reindeer.requests.ReindeerBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ReindeerService {

    @Autowired
    ReindeerFactory reindeerFactory;
    @Autowired
    ReindeerRepository reindeerRepository;

    public List<Reindeer> getAll() {
        List<Reindeer> reindeers = new ArrayList<Reindeer>();

        reindeerRepository.findAll().forEach(reindeers::add);
        return reindeers;
    }

    public Optional<Reindeer> getById(@PathVariable("id") Integer id) {
        return reindeerRepository.findById(id);
    }

    public Reindeer create(@RequestBody ReindeerBody body) {
        // factory from body to entity
        Reindeer newReindeer = reindeerFactory.build(body);
        Reindeer savedReindeer = reindeerRepository.save(newReindeer);

        return savedReindeer;
    }

    public Reindeer update(@PathVariable("id") Integer id, @RequestBody ReindeerBody body) {
        Optional<Reindeer> existingItemOptional = reindeerRepository.findById(id);
        if (existingItemOptional.isPresent()) {
            Reindeer existingItem = existingItemOptional.get();
            existingItem.setName(body.getName());
            existingItem.setAge(body.getAge());

            return reindeerRepository.save(existingItem);
        } else {
            return null;
        }
    }

    public void delete(@PathVariable("id") Integer id) {
        reindeerRepository.deleteById(id);
    }
}