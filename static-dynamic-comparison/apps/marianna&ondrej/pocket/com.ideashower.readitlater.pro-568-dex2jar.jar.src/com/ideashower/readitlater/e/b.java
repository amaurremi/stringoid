package com.ideashower.readitlater.e;

import com.ideashower.readitlater.util.l;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.a.c.k;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

public class b
{
  private static Pattern a;
  private static Pattern b;
  private final String c;
  private final int d;
  private final String e;
  private final int f;
  private final int g;
  private final int h;
  private b i;
  
  public b(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    this(paramString1, paramInt1, paramString2, paramInt2, 0, 0);
  }
  
  public b(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4)
  {
    this.c = paramString1;
    this.d = paramInt1;
    this.e = paramString2;
    this.f = paramInt2;
    this.h = paramInt4;
    this.g = paramInt3;
  }
  
  public static b a(String paramString)
  {
    if (paramString == null) {}
    Matcher localMatcher;
    do
    {
      return null;
      if (k.h(paramString, "vnd.youtube:")) {
        return new b(paramString, 1, paramString.substring("vnd.youtube:".length()), 1);
      }
      localMatcher = k().matcher(paramString);
      if (localMatcher.find())
      {
        paramString = localMatcher.group(3);
        return new b(b(paramString), 1, paramString, 1);
      }
      localMatcher = l().matcher(paramString);
    } while (!localMatcher.find());
    return new b(paramString, 1, localMatcher.group(2), 2);
  }
  
  public static b a(ObjectNode paramObjectNode)
  {
    String str1 = paramObjectNode.get("src").asText();
    int j = paramObjectNode.get("video_id").asInt();
    int k = paramObjectNode.get("type").asInt();
    String str2 = paramObjectNode.get("vid").asText();
    if (paramObjectNode.has("width")) {
      return new b(str1, j, str2, k, l.a(paramObjectNode, "width", 0), l.a(paramObjectNode, "height", 0));
    }
    return new b(str1, j, str2, k);
  }
  
  public static String b(String paramString)
  {
    return "http://www.youtube.com/watch?v=".concat(paramString);
  }
  
  public static b c(String paramString)
  {
    return a(l.a(paramString));
  }
  
  private static Pattern k()
  {
    if (a == null) {
      a = Pattern.compile("(?i)youtube.([a-z]{1,10})(.*?/watch\\?.*v=|/v/|/embed/)([a-z0-9\\_-]*)", 2);
    }
    return a;
  }
  
  private static Pattern l()
  {
    if (b == null) {
      b = Pattern.compile("(?i)vimeo.com/(m/)?([0-9]*)", 2);
    }
    return b;
  }
  
  public String a()
  {
    return this.c;
  }
  
  public int b()
  {
    return this.d;
  }
  
  public String c()
  {
    if (this.i == null) {
      return this.e;
    }
    return this.i.e;
  }
  
  public int d()
  {
    if (this.i == null) {
      return this.f;
    }
    return this.i.f;
  }
  
  public int e()
  {
    return this.g;
  }
  
  public int f()
  {
    return this.h;
  }
  
  public boolean g()
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.i != null) {
      bool1 = true;
    }
    b localb;
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.f != 7);
      localb = a(this.c);
      bool1 = bool2;
    } while (localb == null);
    this.i = new b(this.c, this.d, localb.c(), localb.d(), this.g, this.h);
    return true;
  }
  
  public boolean h()
  {
    if (this.i != null)
    {
      this.i = null;
      return true;
    }
    return false;
  }
  
  public ObjectNode i()
  {
    ObjectNode localObjectNode = l.a().createObjectNode();
    localObjectNode.put("src", a());
    localObjectNode.put("video_id", b());
    localObjectNode.put("type", d());
    localObjectNode.put("vid", c());
    localObjectNode.put("width", e());
    localObjectNode.put("height", f());
    return localObjectNode;
  }
  
  public boolean j()
  {
    return this.f == 1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */