package b.a.d;

import b.a.c;
import b.a.c.a;
import b.a.c.b;
import java.net.URI;
import java.util.Iterator;
import java.util.Set;

public class d
{
  private b a;
  private a b;
  
  public d(b paramb, a parama)
  {
    this.a = paramb;
    this.b = parama;
  }
  
  public String a()
  {
    try
    {
      String str1 = b();
      String str2 = c();
      str1 = this.a.a() + '&' + c.a(str1) + '&' + c.a(str2);
      return str1;
    }
    catch (Exception localException)
    {
      throw new b.a.b.d(localException);
    }
  }
  
  public String b()
  {
    Object localObject3 = new URI(this.a.b());
    String str = ((URI)localObject3).getScheme().toLowerCase();
    Object localObject2 = ((URI)localObject3).getAuthority().toLowerCase();
    if (((str.equals("http")) && (((URI)localObject3).getPort() == 80)) || ((str.equals("https")) && (((URI)localObject3).getPort() == 443))) {}
    for (int i = 1;; i = 0)
    {
      Object localObject1 = localObject2;
      if (i != 0)
      {
        i = ((String)localObject2).lastIndexOf(":");
        localObject1 = localObject2;
        if (i >= 0) {
          localObject1 = ((String)localObject2).substring(0, i);
        }
      }
      localObject3 = ((URI)localObject3).getRawPath();
      if (localObject3 != null)
      {
        localObject2 = localObject3;
        if (((String)localObject3).length() > 0) {}
      }
      else
      {
        localObject2 = "/";
      }
      return str + "://" + (String)localObject1 + (String)localObject2;
    }
  }
  
  public String c()
  {
    if (this.b == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.b.keySet().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (("oauth_signature".equals(str)) || ("realm".equals(str))) {}
      for (;;)
      {
        i += 1;
        break;
        if (i > 0) {
          localStringBuilder.append("&");
        }
        localStringBuilder.append(this.b.b(str, false));
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/b/a/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */