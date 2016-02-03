package org.a.a.b;

import java.util.Locale;

final class q
  extends j
{
  q(d paramd)
  {
    super(paramd, 2);
  }
  
  protected int a(String paramString, Locale paramLocale)
  {
    return p.a(paramLocale).b(paramString);
  }
  
  public int a(Locale paramLocale)
  {
    return p.a(paramLocale).b();
  }
  
  public String a(int paramInt, Locale paramLocale)
  {
    return p.a(paramLocale).b(paramInt);
  }
  
  public String b(int paramInt, Locale paramLocale)
  {
    return p.a(paramLocale).c(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/b/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */