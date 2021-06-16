import java.util.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;
public class UseSAXParseXML{
  public static void main(String[] args){
   String fileName = "publication.xml";
 try{
    ConfigParser handler = new ConfigParser();//将我们的解析器对象化
    SAXParserFactory factory = SAXParserFactory.newInstance();//获得SAX工厂对象
    factory.setNamespaceAware(false);//对 XML 名称空间的不支持 
    factory.setValidating(false);//解析文档时不验证文档 
    SAXParser parser = factory.newSAXParser();//获得SAX解析
    parser.parse(fileName, handler);//将解析器和解析对象联系起来并开始解析
        }
    catch(Exception e){
      e.printStackTrace();}  
  }
}
