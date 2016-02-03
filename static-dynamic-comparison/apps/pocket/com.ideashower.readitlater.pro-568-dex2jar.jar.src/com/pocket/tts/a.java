package com.pocket.tts;

import android.util.SparseArray;
import com.ideashower.readitlater.g.m;
import com.ideashower.readitlater.util.u;
import com.pocket.m.b.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.a.c.k;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

public class a
{
  private static final Pattern a = Pattern.compile(" '[a-zA-Z]");
  private static final Pattern b = Pattern.compile("[a-zA-Z]' ");
  private final ArrayList c = new ArrayList();
  private final SparseArray d = new SparseArray();
  private String e;
  private int f;
  private final String g;
  private String h;
  private final c i;
  private boolean j;
  private final ArrayList k = new ArrayList();
  
  public a(String paramString, c paramc)
  {
    this.g = paramString;
    this.i = paramc;
  }
  
  protected static int a(Element paramElement)
  {
    paramElement = paramElement.attr("nodeIndex");
    if (!k.a(paramElement)) {
      return Integer.valueOf(paramElement).intValue();
    }
    return 0;
  }
  
  public static String a(String paramString)
  {
    paramString = a.matcher(paramString).replaceAll(" \"");
    return b.matcher(paramString).replaceAll("\" ");
  }
  
  private void a(File paramFile, String paramString)
  {
    paramFile = Jsoup.parse(paramFile, "UTF-8", paramString);
    paramString = paramFile.select("#RIL_header h1").first();
    c(paramString);
    this.e = paramString.text();
    paramString = paramFile.getElementsByClass("RIL_author").first();
    if (paramString != null)
    {
      a(paramString, " by ");
      this.h = paramString.text();
    }
    c(paramFile.getElementsByClass("RIL_date").first());
    b(paramFile.getElementById("RIL_body"));
    b();
  }
  
  private void a(String paramString, g paramg, int paramInt, boolean paramBoolean)
  {
    a(paramString, paramg, paramInt, paramBoolean, -1);
  }
  
  private void a(String paramString, g paramg, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (k.c(paramString)) {}
    do
    {
      return;
      paramString = a(paramString);
      if (paramString.length() >= 3000) {
        break;
      }
      this.f += paramString.length();
      paramString = new d(paramString, paramg, paramInt1, paramBoolean, this.f, paramInt2, this.c.size(), null);
      this.c.add(paramString);
      b();
    } while (paramInt1 == 0);
    this.d.put(paramInt1, paramString);
    return;
    paramString = new StringTokenizer(paramString, " ");
    StringBuilder localStringBuilder = u.a();
    int m = 0;
    paramInt2 = 0;
    while (paramString.hasMoreTokens())
    {
      String str = paramString.nextToken();
      int n = str.length();
      if (paramInt2 + n < 3000)
      {
        localStringBuilder.append(str);
        paramInt2 += n;
      }
      else
      {
        a(localStringBuilder.toString(), paramg, paramInt1, false, m);
        m += 1;
        localStringBuilder.setLength(0);
        paramInt2 = 0;
      }
    }
    if (localStringBuilder.length() > 0) {
      a(localStringBuilder.toString(), paramg, paramInt1, false, m);
    }
    u.a(localStringBuilder);
  }
  
  private void a(Element paramElement, String paramString)
  {
    if (paramElement == null) {}
    int m;
    String str2;
    do
    {
      return;
      paramElement.select("[style*=display:none]").remove();
      paramElement.select("[type=hidden]").remove();
      paramElement.select("[width=0]").select("[height=0]").remove();
      m = a(paramElement);
      str2 = paramElement.text();
      if (!k.c(str2)) {
        break;
      }
    } while (m == 0);
    this.k.add(Integer.valueOf(m));
    return;
    String str1 = str2;
    if (!k.a(paramString)) {
      str1 = (paramString + str2).trim();
    }
    a(str1, g.a(paramElement), m, d(paramElement));
  }
  
  private void a(TextNode paramTextNode)
  {
    if (k.c(paramTextNode.text())) {
      return;
    }
    a(paramTextNode.text(), g.a(paramTextNode), 0, false);
  }
  
  private static Elements b(Element paramElement, String paramString)
  {
    paramString = paramElement.select(paramString);
    paramString.remove(paramElement);
    return paramString;
  }
  
  private void b()
  {
    d locald = (d)this.c.get(this.c.size() - 1);
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      this.d.put(localInteger.intValue(), locald);
    }
    this.k.clear();
  }
  
  private void b(Element paramElement)
  {
    paramElement = paramElement.childNodes().iterator();
    while (paramElement.hasNext())
    {
      Object localObject = (Node)paramElement.next();
      if ((localObject instanceof TextNode))
      {
        a((TextNode)localObject);
      }
      else if ((localObject instanceof Element))
      {
        localObject = (Element)localObject;
        String str = ((Element)localObject).tagName().toLowerCase();
        if ((!str.equals("script")) && (!str.equals("style")) && (!((Element)localObject).hasAttr("pktnolisten"))) {
          if (b((Element)localObject, "[nodeIndex]").isEmpty())
          {
            c((Element)localObject);
          }
          else
          {
            int m = a((Element)localObject);
            if ((m != 0) && (e((Element)localObject)))
            {
              c((Element)localObject);
            }
            else
            {
              if (m != 0) {
                this.k.add(Integer.valueOf(m));
              }
              b((Element)localObject);
            }
          }
        }
      }
    }
  }
  
  private void c(Element paramElement)
  {
    a(paramElement, null);
  }
  
  private static boolean d(Element paramElement)
  {
    paramElement = paramElement.tagName();
    if (paramElement.length() != 2) {}
    while ((paramElement.charAt(0) != 'h') && (paramElement.charAt(0) != 'H')) {
      return false;
    }
    return Character.isDigit(paramElement.charAt(1));
  }
  
  private static boolean e(Element paramElement)
  {
    paramElement = b(paramElement, "[nodeIndex]").iterator();
    while (paramElement.hasNext())
    {
      Element localElement = (Element)paramElement.next();
      int m = localElement.text().length();
      if ((m != 0) && ((!k.b(localElement.tagName(), "a")) || (m >= 30))) {
        return false;
      }
    }
    return true;
  }
  
  public void a()
  {
    if (this.j) {
      throw new RuntimeException("already parsing / parsed");
    }
    this.j = true;
    com.pocket.m.b.g.a(this.g, new h()
    {
      public void a()
      {
        a.b(a.this).a(a.a(a.this), -1);
      }
      
      public void a(final File paramAnonymousFile)
      {
        new m()
        {
          protected void a()
          {
            a.a(a.this, paramAnonymousFile, a.a(a.this));
          }
          
          protected void a(boolean paramAnonymous2Boolean, Throwable paramAnonymous2Throwable)
          {
            if ((!paramAnonymous2Boolean) || (a.c(a.this).isEmpty()))
            {
              a.b(a.this).a(a.a(a.this), -2);
              return;
            }
            a.b(a.this).a(a.a(a.this), new b(a.c(a.this), a.d(a.this), a.e(a.this), a.a(a.this), a.f(a.this), a.g(a.this), null));
          }
        }.h();
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/tts/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */