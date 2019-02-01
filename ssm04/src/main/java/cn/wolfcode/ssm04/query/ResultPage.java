package cn.wolfcode.ssm04.query;

import lombok.Data;
import sun.invoke.empty.Empty;

import java.util.Collections;
import java.util.List;

/**
 * 结果页面类
 */
@Data
public class ResultPage {
    public static final ResultPage EMPLY_PAGE = new ResultPage(1,1,0, Collections.emptyList());

    private int currentPage;
    private int pageSize;

    private int dataCount;
    private List<?> data;

    private int prevPage;
    private int nextPage;
    private int endPage;

    public ResultPage(int currentPage, int pageSize, int dataCount, List<?> data){
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.dataCount = dataCount;
        this.data = data;

        if(dataCount <= pageSize){
            prevPage = 1;
            nextPage = 1;
            endPage = 1;
            return;
        }

        endPage = dataCount % pageSize == 0 ? dataCount / pageSize : dataCount / pageSize + 1;
        prevPage = currentPage > 2 ? currentPage - 1 : 1;
        nextPage = currentPage > endPage ? currentPage + 1 : endPage;
    }
}
