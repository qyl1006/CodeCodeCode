package cn.wolfcode.ssm.query;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

//页面结果类 结果集
@Setter @Getter
public class PageResult {
    public static final PageResult EMPTY_PAGE = new PageResult(1, 1, 0, Collections.EMPTY_LIST);

    private int currentPage;
    private int pageSize;

    private Integer totalCount; //总共多少条数据
    private List<?> data;      //查询出来的List数据

    private int endPage;
    private int prevPage;
    private int nextPage;

    public PageResult(int currentPage, int pageSize, int totalCount, List<?> data) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.data = data;

        if(totalCount <= pageSize){
            endPage = 1;
            prevPage = 1;
            nextPage = 1;
            return;
        }

        endPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        prevPage = currentPage > 2 ? currentPage - 1 : 1;
        nextPage = currentPage < endPage ? currentPage + 1 : endPage;
    }
}
