package com.scoreloop.client.android.core.model;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PlistParser
{
  private Object a(Node paramNode)
  {
    while (paramNode != null)
    {
      if (paramNode.getNodeType() == 1)
      {
        String str = paramNode.getNodeName();
        if (str.equalsIgnoreCase("dict")) {
          return e(paramNode);
        }
        if (str.equalsIgnoreCase("array")) {
          return d(paramNode);
        }
        if (str.equalsIgnoreCase("key")) {
          return c(paramNode);
        }
        if (str.equalsIgnoreCase("string")) {
          return c(paramNode);
        }
        if (str.equalsIgnoreCase("integer")) {
          return b(paramNode);
        }
        throw new IllegalStateException("unknown node name: " + str);
      }
      paramNode = paramNode.getNextSibling();
    }
    return null;
  }
  
  public static Map<String, Object> a(Object paramObject)
  {
    if (!(paramObject instanceof Map)) {
      throw new IllegalArgumentException();
    }
    return (Map)paramObject;
  }
  
  private Integer b(Node paramNode)
  {
    return Integer.valueOf(c(paramNode));
  }
  
  public static List<Object> b(Object paramObject)
  {
    if (!(paramObject instanceof List)) {
      throw new IllegalArgumentException();
    }
    return (List)paramObject;
  }
  
  public static String c(Object paramObject)
  {
    if (!(paramObject instanceof String)) {
      throw new IllegalArgumentException();
    }
    return (String)paramObject;
  }
  
  private String c(Node paramNode)
  {
    for (paramNode = paramNode.getFirstChild(); paramNode != null; paramNode = paramNode.getNextSibling()) {
      if (paramNode.getNodeType() == 3) {
        return paramNode.getNodeValue();
      }
    }
    return null;
  }
  
  public static Integer d(Object paramObject)
  {
    if (!(paramObject instanceof Integer)) {
      throw new IllegalArgumentException();
    }
    return (Integer)paramObject;
  }
  
  private List<Object> d(Node paramNode)
  {
    ArrayList localArrayList = new ArrayList();
    for (paramNode = paramNode.getFirstChild(); paramNode != null; paramNode = paramNode.getNextSibling()) {
      if (paramNode.getNodeType() == 1) {
        localArrayList.add(a(paramNode));
      }
    }
    return localArrayList;
  }
  
  private Object e(Node paramNode)
  {
    HashMap localHashMap = new HashMap();
    paramNode = paramNode.getFirstChild();
    Node localNode;
    if (paramNode != null)
    {
      localNode = paramNode;
      label22:
      if (localNode == null) {
        break label124;
      }
      if (localNode.getNodeType() != 1) {
        break label52;
      }
    }
    label52:
    label69:
    label124:
    for (paramNode = c(a(localNode));; paramNode = null)
    {
      if (localNode == null)
      {
        return localHashMap;
        localNode = localNode.getNextSibling();
        break label22;
      }
      localNode = localNode.getNextSibling();
      if (localNode != null) {
        if (localNode.getNodeType() != 1) {}
      }
      for (Object localObject = a(localNode);; localObject = null)
      {
        localHashMap.put(paramNode, localObject);
        paramNode = localNode.getNextSibling();
        break;
        localNode = localNode.getNextSibling();
        break label69;
      }
    }
  }
  
  public Object a(InputStream paramInputStream)
  {
    try
    {
      DocumentBuilderFactory localDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
      localDocumentBuilderFactory.setIgnoringComments(true);
      paramInputStream = a(localDocumentBuilderFactory.newDocumentBuilder().parse(paramInputStream).getElementsByTagName("plist").item(0).getFirstChild());
      return paramInputStream;
    }
    catch (Exception paramInputStream)
    {
      paramInputStream.printStackTrace();
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/model/PlistParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */