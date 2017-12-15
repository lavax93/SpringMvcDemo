package com.lavax.saxReaderDemo;


import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 * Created by LAVAX on 2017/12/15.
 */
public class SaxReader {


    public static void main(String[] args) throws Exception {
        System.out.println("xml配置读取");
        File xmlFile = new File(SaxReader.class.getResource("/").getPath() + "\\book.xml");
        System.out.println(xmlFile);
        loadXml(new FileInputStream(xmlFile));
        System.out.println("properties配置读取");
        File propertiesFile = new File(SaxReader.class.getResource("/").getPath() + "\\book.properties");
        System.out.println(propertiesFile);
        loadProperties(new FileInputStream(propertiesFile));
    }

    /**
     * 解析xml配置
     *
     * @param inputStream
     */
    private static void loadXml(InputStream inputStream) {
        SAXReader reader = new SAXReader();
        try {
            Document fileDocument = reader.read(inputStream);
            //获取根节点
            Element rootElement = fileDocument.getRootElement();
            //获取子节点
            Iterator<Element> iterator = rootElement.elementIterator();
            while (iterator.hasNext()) {
                Element ele = iterator.next();
                System.out.println("attribute中的配置:");
                List<Attribute> attributeList = ele.attributes();
                for (Attribute attr : attributeList) {
                    String name = attr.getName();
                    String value = attr.getValue();
                    System.out.println(name + " ---> " + value);
                }
                System.out.println("element中的配置:");
                Iterator<Element> elementIterator = ele.elementIterator();
                while (elementIterator.hasNext()) {
                    Element elem = elementIterator.next();
                    String name = elem.getName();
                    String text = elem.getText();
                    System.out.println(name + " ---> " + text);
                }
                System.out.println();
            }

        } catch (DocumentException ex) {

        }


    }

    /**
     * 解析properties配置
     */
    private static void loadProperties(InputStream inputStream) {
        Properties prop = new Properties();
        try {
            prop.load(new InputStreamReader(inputStream, "utf-8"));
            for (String name : prop.stringPropertyNames()) {
                String value = prop.getProperty(name);
                System.out.println(name + " ---> " + value);
            }

        } catch (Exception ex) {

        }
    }
}

