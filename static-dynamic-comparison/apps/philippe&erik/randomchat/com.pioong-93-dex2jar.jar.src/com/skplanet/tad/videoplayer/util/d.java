package com.skplanet.tad.videoplayer.util;

import com.skplanet.tad.videoplayer.data.a;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class d
{
  public static com.skplanet.tad.videoplayer.data.b a(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return null;
    }
    for (;;)
    {
      String str1;
      Object localObject4;
      Object localObject2;
      int i;
      try
      {
        Object localObject3 = b(paramString);
        if (localObject3 == null) {
          return null;
        }
        str1 = a((Element)localObject3, "scenario_no");
        localObject4 = ((Element)localObject3).getElementsByTagName("menu");
        localObject2 = new a[((NodeList)localObject4).getLength()];
        if (!"2".equals(str1)) {
          break label274;
        }
        localObject1 = localObject2;
        if (((NodeList)localObject4).getLength() > 0)
        {
          i = 0;
          if (i >= ((NodeList)localObject4).getLength()) {
            localObject1 = localObject2;
          }
        }
        else
        {
          localObject2 = a((Element)localObject3, "tag_url");
          localObject4 = a((Element)localObject3, "video_url");
          localObject3 = a((Element)localObject3, "video_title");
          localObject1 = new com.skplanet.tad.videoplayer.data.b("Video", (String)localObject2, Integer.parseInt(str1), (String)localObject4, (String)localObject3, (a[])localObject1);
          b.a("META_DATA_XML= " + paramString);
          return (com.skplanet.tad.videoplayer.data.b)localObject1;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      Object localObject1 = a(((NodeList)localObject4).item(i), "menu_id");
      String str2 = a(((NodeList)localObject4).item(i), "menu_title");
      String str3 = a(((NodeList)localObject4).item(i), "landing_type");
      String str4 = a(((NodeList)localObject4).item(i), "landing_url");
      String str5 = a(((NodeList)localObject4).item(i), "video_title");
      localObject2[i] = new a(Integer.parseInt((String)localObject1), str2, str3, str4, str5);
      i += 1;
      continue;
      label274:
      localObject1 = localObject2;
      if ("1".equals(str1)) {
        localObject1 = new a[0];
      }
    }
  }
  
  private static String a(Element paramElement, String paramString)
  {
    paramElement = paramElement.getElementsByTagName(paramString);
    if (paramElement == null) {
      return "";
    }
    return a(paramElement.item(0));
  }
  
  private static String a(Node paramNode)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int j;
    int i;
    if (paramNode != null)
    {
      paramNode = paramNode.getChildNodes();
      localObject1 = localObject2;
      if (paramNode != null)
      {
        j = paramNode.getLength();
        localObject1 = new StringBuffer();
        i = 0;
      }
    }
    for (;;)
    {
      if (i >= j)
      {
        localObject1 = ((StringBuffer)localObject1).toString();
        return (String)localObject1;
      }
      ((StringBuffer)localObject1).append(paramNode.item(i).getNodeValue());
      i += 1;
    }
  }
  
  private static String a(Node paramNode, String paramString)
  {
    return a(((Element)paramNode).getElementsByTagName(paramString).item(0));
  }
  
  private static Element b(String paramString)
    throws Exception
  {
    return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8"))).getDocumentElement();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/videoplayer/util/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */