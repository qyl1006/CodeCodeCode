package cn.wolfcode.ssm03.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class Employee {
    private Long id;
    private String name;
    private String email;
    private Long age;
}
