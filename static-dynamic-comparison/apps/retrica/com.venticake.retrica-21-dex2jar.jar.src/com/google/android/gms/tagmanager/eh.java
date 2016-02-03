package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class eh
  implements aa
{
  private static eh a;
  private static final Object b = new Object();
  private String c;
  private String d;
  private bv e;
  private ab f;
  
  private eh(Context paramContext)
  {
    this(ac.a(paramContext), new cp());
  }
  
  eh(ab paramab, bv parambv)
  {
    this.f = paramab;
    this.e = parambv;
  }
  
  public static aa a(Context paramContext)
  {
    synchronized (b)
    {
      if (a == null) {
        a = new eh(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
  }
  
  public boolean a(String paramString)
  {
    if (!this.e.a())
    {
      as.b("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
      return false;
    }
    String str = paramString;
    if (this.c != null)
    {
      str = paramString;
      if (this.d == null) {}
    }
    try
    {
      str = this.c + "?" + this.d + "=" + URLEncoder.encode(paramString, "UTF-8");
      as.e("Sending wrapped url hit: " + str);
      this.f.a(str);
      return true;
    }
    catch (UnsupportedEncodingException paramString)
    {
      as.b("Error wrapping URL for testing.", paramString);
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/eh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */