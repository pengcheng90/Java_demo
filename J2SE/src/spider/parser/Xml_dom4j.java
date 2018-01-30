package spider.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * xml解析：dom4j方式
 */
public class Xml_dom4j {
    public static void main(String[] args) {
        try {
            SAXReader saxReader = new SAXReader();
            FileInputStream fin = new FileInputStream(new File("J2SE/testDirectory/demo.xml"));
            Document doc = saxReader.read(fin);
            Element ele = doc.getRootElement();

            String str = ele.getName();
            System.out.println(str);

            List<Element> elements = ele.elements();
            for (Element e : elements) {
                System.out.println(e.attributeValue("name") + "\t" + e.getText());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}