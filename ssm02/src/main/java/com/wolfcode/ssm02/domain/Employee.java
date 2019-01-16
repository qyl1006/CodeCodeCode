package com.wolfcode.ssm02.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class Employee {
    private Long id;
    private String name;
    private String email;
    private Integer age;
}
