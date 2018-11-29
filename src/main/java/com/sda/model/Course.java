package com.sda.model;

import lombok.Data;

@Data
public class Course {
    private Long id;
    private String nazwa;
    private double cena;
    private int iloscGodzin;
}

