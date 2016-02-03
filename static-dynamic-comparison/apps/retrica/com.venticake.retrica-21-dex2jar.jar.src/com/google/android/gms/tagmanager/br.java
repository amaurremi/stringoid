package com.google.android.gms.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

class br
{
  private static br a;
  private volatile bs b;
  private volatile String c;
  private volatile String d;
  private volatile String e;
  
  br()
  {
    e();
  }
  
  static br a()
  {
    try
    {
      if (a == null) {
        a = new br();
      }
      br localbr = a;
      return localbr;
    }
    finally {}
  }
  
  private String a(String paramString)
  {
    return paramString.split("&")[0].split("=")[1];
  }
  
  private String b(Uri paramUri)
  {
    return paramUri.getQuery().replace("&gtm_debug=x", "");
  }
  
  boolean a(Uri paramUri)
  {
    boolean bool = true;
    String str;
    try
    {
      str = URLDecoder.decode(paramUri.toString(), "UTF-8");
      if (!str.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
        break label153;
      }
      as.e("Container preview url: " + str);
      if (!str.matches(".*?&gtm_debug=x$")) {
        break label138;
      }
      this.b = bs.c;
    }
    catch (UnsupportedEncodingException paramUri)
    {
      for (;;)
      {
        bool = false;
        continue;
        this.b = bs.b;
      }
    }
    finally {}
    this.e = b(paramUri);
    if ((this.b == bs.b) || (this.b == bs.c)) {
      this.d = ("/r?" + this.e);
    }
    this.c = a(this.e);
    for (;;)
    {
      return bool;
      label138:
      label153:
      if (str.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$"))
      {
        if (a(paramUri.getQuery()).equals(this.c))
        {
          as.e("Exit preview mode for container: " + this.c);
          this.b = bs.a;
          this.d = null;
        }
      }
      else
      {
        as.b("Invalid preview uri: " + str);
        bool = false;
        continue;
      }
      bool = false;
    }
  }
  
  bs b()
  {
    return this.b;
  }
  
  String c()
  {
    return this.d;
  }
  
  String d()
  {
    return this.c;
  }
  
  void e()
  {
    this.b = bs.a;
    this.d = null;
    this.c = null;
    this.e = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */