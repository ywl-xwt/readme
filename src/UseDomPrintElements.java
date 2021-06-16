import java.io.*;
import javax.xml.parsers.*; // 
import org.w3c.dom.*; //
public class UseDomPrintElements{
public static void main(String[] args){
  try{
       //得到DOM解析器的工厂实例 
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       //从DOM工厂获得DOM解析器  
      DocumentBuilder builder = factory.newDocumentBuilder();
      //DOM解析器解析XML文档得到Document对象，Document对象代表整个XML文档
      Document document = builder.parse(new File("publication.xml"));
      //得到Dom树的根节点
      Element element = document.getDocumentElement();
      NodeList nodelist = element.getChildNodes(); //得到子节点列表
      getElement(nodelist); //用递归实现DOM树的遍历
   } catch(Exception e){
      e.printStackTrace();}
   }
public static void getElement(NodeList nodelist){
    Node cnode;
    String str;
    if(nodelist.getLength()==0)
       {return;}
    for(int i=0;i<nodelist.getLength();i++){
     cnode = nodelist.item(i);//返回集合中第index项
     if(cnode.getNodeType()==Node.ELEMENT_NODE){//该节点为Element
      System.out.println(cnode.getNodeName());
      getElement(cnode.getChildNodes());}//递归调用
    
    else if(cnode.getNodeType()==Node.TEXT_NODE){//该节点为TEXT节点
      str=cnode.getNodeValue().trim();//返回String副本忽略前后空白
      if(str.length()>0)
       System.out.println("   "+str);}
     }
}
}
