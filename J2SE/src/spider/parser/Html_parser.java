package spider.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * Jsoup方式解析
 * Jsoup官网：https://jsoup.org/cookbook/extracting-data/attributes-text-html
 */
public class Html_parser {

    /**
     * 从文件加载文档
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        File input = new File("J2SE/testDirectory/input.html");
        // 第三个参数baseUri参数用于解决文件中URLs是相对路径的问题。如果不需要可以传入一个空的字符串。
        Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");

        System.out.println(doc);
    }

    /**
     * 从字符串解析文档
     */
    @Test
    void test1() {
        String html = "<div><p>Lorem ipsum.</p>";
        Document doc = Jsoup.parseBodyFragment(html);
        Element body = doc.body();              /*它相当于doc.getElementsByTag("body")*/
        System.out.println(body);
    }

    /**
     * 从URL加载文档
     *
     * @throws IOException
     */
    @Test
    void testFromURL() throws IOException {
        Document document = Jsoup.connect("http://example.com/").get();
        String title = document.title();
        System.out.println(title);

        /**
         * post方式
         */
        Document doc = Jsoup.connect("http://example.com")
                .data("query", "Java")
                .userAgent("Mozilla")
                .cookie("auth", "token")
                .timeout(3000)
                .post();
//        System.out.println("---------------body-----------------");
//        System.out.println(doc.body());
//        System.out.println("---------------body-----------------");

        Elements children = doc.body().children();
        childs(children);
    }

    private static void childs(Elements es) {
        Iterator<Element> iterator = es.iterator();
        while (iterator.hasNext()) {
            Element e = iterator.next();

            Elements p = e.select("p");//选择器

            Iterator<Element> i_c = p.iterator();
            while (i_c.hasNext()) {
                System.out.println("text : " + i_c.next().text());//输出值
            }
        }
    }
}
