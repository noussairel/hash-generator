package com.noussair.todoapp;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Getter
@Service
public class RandomIdService {
    private final String id = UUID.randomUUID().toString();

}
