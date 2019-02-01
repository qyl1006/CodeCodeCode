package cn.wolfcode.ssm05.query;

import lombok.Data;
import org.springframework.util.StringUtils;

/**
 * Employee查询对象
 */
@Data
public class EmployeeQueryObject {
    //当前页
   private int currentPage = 1;
   //页面容量
    private int pageSize = 2;

    //关键字
    private String keyword;

    //提供get属性用于sql 分页使用
    public int getStart(){
        return (currentPage - 1) * pageSize;
    }

    //keyword为空则为null 变于判断
    public String getKeyword(){
        return StringUtils.hasLength(keyword) ? keyword : null;
    }
}
