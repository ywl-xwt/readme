import java.util.*;
//import javax.xml.parsers.SAXParser;
//import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;

class ConfigParser extends DefaultHandler{
    private String temp;
    private Stack<String> element =new Stack<String>();
    private StringBuffer currentValue = new StringBuffer();
    public void startElement(String uri, String localName, String qName, Attributes attributes)    
               throws SAXException{  //接收元素开始的通知
           currentValue.delete(0, currentValue.length());              
           element.push(qName);
          } //读到结束标签会触发该方法
    public void endElement(String uri, String localName, String qName )throws SAXException{
           temp=(String)element.pop();
           if(temp.equals("Title"))
              System.out.println("Title:"+currentValue);
           if(temp.equals("Writer"))
              System.out.println("Writer:"+currentValue);
           if(temp.equals("PublishDate"))
              System.out.println("PublishDate:"+currentValue);
           }
    //此方法用来处理XML文件中字符串
    public void characters(char[] ch, int start, int length)throws SAXException{
           currentValue.append(ch, start, length);
}
}