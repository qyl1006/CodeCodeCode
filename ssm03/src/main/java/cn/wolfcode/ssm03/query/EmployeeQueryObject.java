package cn.wolfcode.ssm03.query;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.StringUtils;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class EmployeeQueryObject {
    private int currentPage = 1;
    private int pageSize = 3;

    private String keyworld;

    public int getStart(){
        return (currentPage - 1) * pageSize;
    }

    public String getKeyworld(){
        return StringUtils.hasLength(keyworld) ? keyworld : null;
    }
}
