import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
public class UseDomEditElement{
 public static void main(String[] args){
   Text textMsg;
       try{
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       DocumentBuilder builder = factory.newDocumentBuilder();
       Document document = builder.parse(new File("publication.xml"));
       Element root = document.getDocumentElement();//获得根节点
       Element book = document.createElement("book");//增加一个Element节点
       Element title =document.createElement("Title");//增加一个Element节点
       textMsg=document.createTextNode("MiddlewareTech");//增加一个Text节点
       title.appendChild(textMsg);
       book.appendChild(title);//把title节点转化为book的子节点
       Element writer =document.createElement("Writer");
textMsg=document.createTextNode("wanghuadong");
       writer.appendChild(textMsg);
       book.appendChild(writer);//把writer节点转化为book的子节点
       Element date = document.createElement("PublishDate");
textMsg=document.createTextNode("1994-02-23");
       date.appendChild(textMsg);
       book.appendChild(date);//把date节点转化为book的子节点
       root.appendChild(book);//把book节点转化为root的子节点
      //实现获得将DOM文档转化为XML文档的转化器
       TransformerFactory tFactory = TransformerFactory.newInstance();
      // 类Transformer  实现转化
       Transformer transformer = tFactory.newTransformer();
       DOMSource source = new DOMSource(document);
       StreamResult result = new StreamResult("publication.xml");
       //调用API，将DOM文档转化为XML 
       transformer.transform(source, result);
        }catch(Exception e){
   e.printStackTrace();}
}
 }
