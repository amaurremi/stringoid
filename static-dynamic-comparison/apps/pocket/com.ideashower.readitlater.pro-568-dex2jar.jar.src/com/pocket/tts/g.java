package com.pocket.tts;

import com.ideashower.readitlater.util.u;
import java.util.Iterator;
import java.util.List;
import org.apache.a.c.k;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

public class g
{
  public final String a;
  public final int b;
  
  private g(String paramString)
  {
    this(paramString, -1);
  }
  
  private g(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }
  
  protected static g a(Element paramElement)
  {
    paramElement = b(paramElement);
    if (paramElement != null) {
      return new g(paramElement);
    }
    return null;
  }
  
  protected static g a(TextNode paramTextNode)
  {
    if ((paramTextNode.parent() instanceof Element)) {
      return new g(b((Element)paramTextNode.parent()), b(paramTextNode));
    }
    return null;
  }
  
  private static int b(TextNode paramTextNode)
  {
    Node localNode = paramTextNode.parent();
    if (localNode == null) {
      return -1;
    }
    if ((localNode instanceof Element)) {
      return ((Element)localNode).childNodes().indexOf(paramTextNode);
    }
    return -1;
  }
  
  private static String b(Element paramElement)
  {
    Object localObject1 = d(paramElement);
    if (localObject1 != null) {
      return (String)localObject1;
    }
    Object localObject2 = paramElement.parent().parents();
    localObject1 = u.a();
    int i = c(paramElement);
    if (i >= 0) {
      ((StringBuilder)localObject1).append(":eq(").append(i).append(")");
    }
    paramElement = ((Elements)localObject2).iterator();
    while (paramElement.hasNext())
    {
      localObject2 = (Element)paramElement.next();
      String str = d((Element)localObject2);
      if (str != null)
      {
        ((StringBuilder)localObject1).insert(0, str);
        paramElement = ((StringBuilder)localObject1).toString();
        u.a((StringBuilder)localObject1);
        return paramElement;
      }
      ((StringBuilder)localObject1).insert(0, ")").insert(0, c((Element)localObject2)).insert(0, ":eq(");
    }
    if (com.ideashower.readitlater.a.g.y()) {
      throw new RuntimeException("unexpected state");
    }
    return null;
  }
  
  private static int c(Element paramElement)
  {
    Element localElement = paramElement.parent();
    if (localElement == null) {
      return -1;
    }
    return localElement.children().indexOf(paramElement);
  }
  
  private static String d(Element paramElement)
  {
    int i = a.a(paramElement);
    if (i != 0) {
      paramElement = "[nodeIndex=" + i + "]";
    }
    String str;
    do
    {
      do
      {
        return paramElement;
        if (!k.c(paramElement.id())) {
          return "#" + paramElement.id();
        }
        str = paramElement.tagName();
        paramElement = str;
      } while (k.b(str, "body"));
      paramElement = str;
    } while (k.b(str, "html"));
    return null;
  }
  
  public String toString()
  {
    return "NodeSelector [mElement=" + this.a + ", mIndex=" + this.b + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/tts/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */