package cn.wolfcode.ssm05.domain;

import lombok.Data;

@Data
public class Employee {
    private Long id;
    private String name;
    private String email;
    private Long age;
}
