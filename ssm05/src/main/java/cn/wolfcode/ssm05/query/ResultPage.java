package cn.wolfcode.ssm05.query;

import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class ResultPage {
    public static final ResultPage EMPLY_PAGE = new ResultPage(1, 1, 0, Collections.emptyList());

    //当前页
    private int currentPage;
    //页面容量
    private int pageSize;

    //总数据条数
    private int pageCount;
    //总数据
    private List<?> data;

    //上一页
    private int prevPage;
    //下一页
    private int nextPage;
    //尾页
    private int endPage;

    public ResultPage(int currentPage, int pageSize, int pageCount, List<?> data){
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.pageCount = pageCount;
        this.data = data;

        if (pageCount <= pageSize){
            prevPage = 1;
            nextPage = 1;
            endPage = 1;
            return;
        }

        endPage = pageCount % pageSize == 0 ? pageCount / pageSize : pageCount / pageSize + 1;
        prevPage = currentPage > 2 ? currentPage - 1 : 1;
        nextPage = currentPage > endPage ? currentPage + 1 : endPage;
    }
}
