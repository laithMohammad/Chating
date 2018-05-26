package services.utils;
import org.jdom2.Element;
import org.jdom2.input.DOMBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class XMLServiceReader{

    public static Element init(){
        String fileName = "services.xml";
        try {
            Class.forName("org.jdom2.Element");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File(fileName));
            DOMBuilder domBuilder = new DOMBuilder();
            org.jdom2.Document jdomDoc = domBuilder.build(doc);
            return jdomDoc.getRootElement();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Not Declared");
        }
        return null;
    }


    /**
     *
     * @return
     */
    public static ConcurrentMap<String, Service> servicesLoader () {
        ConcurrentMap<String, Service>  services = new ConcurrentHashMap<>();
        List<Element> children = init().getChildren();
        for (Element child: children){
            String serviceName = child.getAttributeValue("name");
            String serviceClass = child.getAttributeValue("class");
            services.put(serviceName, instantiate(serviceClass));
        }
        return services;
    }

    public static Service instantiate(String serviceClass) {
        try {
            return (Service) Class.forName(serviceClass).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
            return null;
        }
    }
}