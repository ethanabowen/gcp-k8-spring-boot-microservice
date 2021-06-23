package com.reindeer.endpoints;

import java.util.List;
import java.util.Optional;

import com.reindeer.domain.Reindeer;
import com.reindeer.requests.ReindeerBody;
import com.reindeer.service.ReindeerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/reindeer")
public class ReindeerEndpoints {
    @Autowired
    private ReindeerService reindeerService;

    @GetMapping
    public ResponseEntity<List<Reindeer>> getAll() {
        try {
            List<Reindeer> reindeers = reindeerService.getAll();

            if (reindeers.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(reindeers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Reindeer> getById(@PathVariable("id") Integer id) {
        Optional<Reindeer> existingItemOptional = reindeerService.getById(id);

        if (existingItemOptional.isPresent()) {
            return new ResponseEntity<>(existingItemOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Reindeer> create(@RequestBody ReindeerBody body) {
        try {
            Reindeer savedItem = reindeerService.create(body);

            return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Reindeer> update(@PathVariable("id") Integer id, @RequestBody ReindeerBody body) {
        Reindeer updatedReindeer = reindeerService.update(id, body);

        if (updatedReindeer != null) {
            return new ResponseEntity<>(updatedReindeer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
        try {
            reindeerService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}