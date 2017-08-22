package com.oranfish.service.impl;

import com.oranfish.common.HttpUtils;
import com.oranfish.entity.House;
import com.oranfish.service.ClawService;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClawServiceImpl implements ClawService{
    public Integer getTotalPages(String url) {
        String htmlContent = HttpUtils.getPageContent(url);
        Document document = Jsoup.parse(htmlContent);
        String totalPageStr = document.select(".c-pagination a[gahref=results_totalpage]").text();
        Integer totalPage = null;
        if(StringUtils.isNotBlank(totalPageStr)){
            try {
                totalPage = Integer.parseInt(totalPageStr);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return totalPage;
    }

    public List<House> getPaginateData(String url) {
        String htmlContent = HttpUtils.getPageContent(url);
        Document document = Jsoup.parse(htmlContent);
        Elements lis = document.select(".js_fang_list li");
        for (Element li : lis) {
            String title = li.select(".js_fanglist_title").attr("title");
 //           String totalPrice = li.select(".total-price").text();

        }

        return null;
    }
}
