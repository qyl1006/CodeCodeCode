package cn.wolfcode.ssm03.query;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Getter @Setter
public class ResultPage {
    public static final ResultPage EMPLY_PAGE = new ResultPage(1,1,0, Collections.emptyList());


    private int currentPage;
    private int pageSize;

    private int pageCount;
    private List<?> data;

    private int prevPage;
    private int nextPage;
    private int endPage;

    public ResultPage(int currentPage, int pageSize, int pageCount, List<?> data){
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.pageCount = pageCount;
        this.data = data;

        if(pageCount <= pageSize){
            prevPage = 1;
            nextPage = 1;
            endPage = 1;
            return;
        }

        endPage = pageCount % pageSize == 0 ? pageCount / pageSize : pageCount / pageSize + 1;
        prevPage = currentPage > 2 ? currentPage - 1 : 1;
        nextPage = currentPage < endPage ? currentPage + 1 : endPage;
    }
}
