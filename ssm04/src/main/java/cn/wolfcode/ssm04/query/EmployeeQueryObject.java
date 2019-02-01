package cn.wolfcode.ssm04.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

/**
 * 员工的查询对象
 */

@Data
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
