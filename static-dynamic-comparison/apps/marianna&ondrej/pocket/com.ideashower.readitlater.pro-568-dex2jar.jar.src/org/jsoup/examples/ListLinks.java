package org.jsoup.examples;

import java.io.PrintStream;
import java.util.Iterator;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ListLinks
{
  public static void main(String[] paramArrayOfString)
  {
    boolean bool;
    Object localObject2;
    if (paramArrayOfString.length == 1)
    {
      bool = true;
      Validate.isTrue(bool, "usage: supply url to fetch");
      paramArrayOfString = paramArrayOfString[0];
      print("Fetching %s...", new Object[] { paramArrayOfString });
      localObject1 = Jsoup.connect(paramArrayOfString).get();
      paramArrayOfString = ((Document)localObject1).select("a[href]");
      localObject2 = ((Document)localObject1).select("[src]");
      localObject1 = ((Document)localObject1).select("link[href]");
      print("\nMedia: (%d)", new Object[] { Integer.valueOf(((Elements)localObject2).size()) });
      localObject2 = ((Elements)localObject2).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label219;
      }
      Element localElement = (Element)((Iterator)localObject2).next();
      if (localElement.tagName().equals("img"))
      {
        print(" * %s: <%s> %sx%s (%s)", new Object[] { localElement.tagName(), localElement.attr("abs:src"), localElement.attr("width"), localElement.attr("height"), trim(localElement.attr("alt"), 20) });
        continue;
        bool = false;
        break;
      }
      print(" * %s: <%s>", new Object[] { localElement.tagName(), localElement.attr("abs:src") });
    }
    label219:
    print("\nImports: (%d)", new Object[] { Integer.valueOf(((Elements)localObject1).size()) });
    Object localObject1 = ((Elements)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Element)((Iterator)localObject1).next();
      print(" * %s <%s> (%s)", new Object[] { ((Element)localObject2).tagName(), ((Element)localObject2).attr("abs:href"), ((Element)localObject2).attr("rel") });
    }
    print("\nLinks: (%d)", new Object[] { Integer.valueOf(paramArrayOfString.size()) });
    paramArrayOfString = paramArrayOfString.iterator();
    while (paramArrayOfString.hasNext())
    {
      localObject1 = (Element)paramArrayOfString.next();
      print(" * a: <%s>  (%s)", new Object[] { ((Element)localObject1).attr("abs:href"), trim(((Element)localObject1).text(), 35) });
    }
  }
  
  private static void print(String paramString, Object... paramVarArgs)
  {
    System.out.println(String.format(paramString, paramVarArgs));
  }
  
  private static String trim(String paramString, int paramInt)
  {
    String str = paramString;
    if (paramString.length() > paramInt) {
      str = paramString.substring(0, paramInt - 1) + ".";
    }
    return str;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/examples/ListLinks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */