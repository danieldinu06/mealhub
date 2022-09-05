package com.danieldinu.mealhub.controller;

import com.danieldinu.mealhub.model.utils.DrinkType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/drinks")
@CrossOrigin
public class DrinkTypeController {
    @GetMapping
    public List<DrinkType> getDrinkTypes() {
        return Arrays.stream(DrinkType.values()).sorted(Comparator.comparing(Enum::toString)).collect(Collectors.toList());
    }
}
