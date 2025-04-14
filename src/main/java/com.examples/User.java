package org.kafka.examples;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.confluent.kafka.schemaregistry.annotations.Schema;

import java.io.Serializable;

@Schema(value = "{"
        + "\"type\": \"object\","
        + "\"properties\": {\"age\": {\"type\": \"integer\"}},"
        + "\"required\": [\"age\"]"
        + "}", refs={})
public class User implements Serializable {

    @JsonProperty
    public int age;

    public User() {}

    public User(int age) {
        this.age = age;
    }
}