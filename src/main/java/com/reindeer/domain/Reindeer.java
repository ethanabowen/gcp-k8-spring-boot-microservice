package com.reindeer.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Reindeer {
    private Integer id;

    private String name;

    private Integer age;

    @JsonProperty("isRudoulf")
    public boolean isRudoulf() {
        return this.name != null && this.name.equals("Rudolph");
    }
}