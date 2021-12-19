package com.javamaster.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class XMLParsingController {

    @GetMapping("/xmlParsing")
    public String home(@RequestParam(required = false)
                       String PermissionCodeCountry, Long idTeam, String nameTeam) {


        String xml =
                "<item>\r\n" +
                        "   <title> this is title 1 </title>\r\n" +
                        "   <description> description 1 </description>\r\n" +
                        "   <pubDate> date 1 </pubDate>\r\n" +
                        "</item>\r\n" +
                        "\r\n" +
                        "<item>\r\n" +
                        "   <title> this is title 2 </title>\r\n" +
                        "   <description> description 2 </description>\r\n" +
                        "   <pubDate> date 2 </pubDate>\r\n" +
                        "</item>";

        Document doc = Jsoup.parse(xml, "", Parser.xmlParser());

        for (Element item : doc.select("item")) {
            Elements children = item.children();
            for (Element child : children) {
                System.out.println(child.text());
            }
        }

        return "answerXMLParsingGood_page";
    }
}