package cn.wolfcode.ssm04.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Employee {
    private Long id;
    private String name;
    private String email;
    private Long age;
}
