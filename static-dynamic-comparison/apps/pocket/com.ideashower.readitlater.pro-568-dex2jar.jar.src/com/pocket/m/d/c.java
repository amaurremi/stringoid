package com.pocket.m.d;

import com.pocket.m.b.f;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class c
  extends a
{
  private static final Pattern s = Pattern.compile("([\\s\\\"\\'](?:background|src)=[\\\"\\'])(https?:[^\\\"\\']*)([\\\"\\'])", 2);
  private static final Pattern t = Pattern.compile("(youtube)\\.", 2);
  private static final Pattern u = Pattern.compile("^http://player\\.vimeo\\.com.*$", 2);
  
  public c(f paramf, String paramString1, String paramString2)
  {
    super(paramf, paramString1, paramString2, null);
  }
  
  protected void a()
  {
    a(a);
    a(b);
    a(c);
    a(d);
    Matcher localMatcher1 = s.matcher(this.q);
    StringBuffer localStringBuffer = new StringBuffer();
    if ((!a_()) && (localMatcher1.find()))
    {
      String str2 = localMatcher1.group(1);
      String str1 = localMatcher1.group(2);
      String str3 = localMatcher1.group(3);
      Matcher localMatcher3 = u.matcher(str1);
      Matcher localMatcher2 = t.matcher(str1);
      if (localMatcher3.find()) {
        str1 = "file:///android_asset/video.html#" + str1;
      }
      for (;;)
      {
        localMatcher1.appendReplacement(localStringBuffer, str2 + str1 + str3);
        break;
        if (!localMatcher2.find()) {
          str1 = "";
        }
      }
    }
    localMatcher1.appendTail(localStringBuffer);
    this.q = localStringBuffer.toString();
    this.p.a(this.q);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/m/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */