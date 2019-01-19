package com.wolfcode.ssm02.query;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

@Setter@Getter
public class EmployeeQueryObject {
    private int currentPage = 1;
    private int pageSize = 3;

    private String keyword;

    public int getStart(){
        return (currentPage - 1) * pageSize;
    }

    public String getKeyword(){
        return StringUtils.hasLength(keyword) ? keyword : null;
    }
}
