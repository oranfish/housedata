package com.oranfish.task;

import com.oranfish.common.HttpUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WikiTask {

    public static final String MAIN_URL = "http://wiki.odianyun.local";
    public static final String PAGE_URL = "/pages/viewpage.action?pageId=1441823";
    public static final String DIV_ID = "children1441823-0";

    public void process(String url,String divId){
        String htmlContent = HttpUtils.getPageContentRepeatedly(url);
        System.out.println(htmlContent);
        Document document = Jsoup.parse(htmlContent);
        Elements elements = document.select("#"+divId+" ul li");
        if(elements==null){
            Element mainElement = document.body().getElementById("main");
            System.out.println(mainElement.html());
        }else{
            for(Element e : elements){
                String childUrl = e.child(1).child(0).child(0).attr("href");
                String childDivId = e.child(2).id();
                process(MAIN_URL+childUrl,childDivId);
            }
        }
    }

    public static void main(String[] args){
        WikiTask wikiTask = new WikiTask();
        wikiTask.process(MAIN_URL+PAGE_URL,DIV_ID);
    }
}
