package com.oranfish.service.impl;

import com.oranfish.common.HttpUtils;
import com.oranfish.common.RegexUtils;
import com.oranfish.entity.House;
import com.oranfish.service.ClawService;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
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
        List<House> list = new ArrayList<House>();
        for (Element li : lis) {
            House house = new House();
            String title = li.select(".js_fanglist_title").attr("title");
            BigDecimal totalPrice = new BigDecimal(li.select(".total-price").text());
            BigDecimal unitPrice = RegexUtils.regFirstNumber(li.select(".minor").text());
            String houseDetail = li.select(".row1-text").text();
            String communityDetail = li.select(".row2-text").text();
            String label = li.select(".property-tag-container").text();
            house.setTitle(title);
            house.setTotalPrice(totalPrice);
            house.setUnitPrice(unitPrice);
            house.setHouseDetail(houseDetail);
            house.setCommunityDetail(communityDetail);
            house.setLabel(label);
            list.add(house);
        }
        return list;
    }
}
