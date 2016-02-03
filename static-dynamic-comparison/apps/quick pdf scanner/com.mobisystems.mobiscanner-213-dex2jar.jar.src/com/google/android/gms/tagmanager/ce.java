package com.google.android.gms.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

class ce
{
  private static ce WV;
  private volatile a WW;
  private volatile String WX;
  private volatile String WY;
  private volatile String Wq;
  
  ce()
  {
    clear();
  }
  
  private String br(String paramString)
  {
    return paramString.split("&")[0].split("=")[1];
  }
  
  private String g(Uri paramUri)
  {
    return paramUri.getQuery().replace("&gtm_debug=x", "");
  }
  
  static ce vX()
  {
    try
    {
      if (WV == null) {
        WV = new ce();
      }
      ce localce = WV;
      return localce;
    }
    finally {}
  }
  
  void clear()
  {
    this.WW = a.WZ;
    this.WX = null;
    this.Wq = null;
    this.WY = null;
  }
  
  boolean f(Uri paramUri)
  {
    boolean bool = true;
    String str;
    try
    {
      str = URLDecoder.decode(paramUri.toString(), "UTF-8");
      if (!str.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
        break label153;
      }
      j.C("Container preview url: " + str);
      if (!str.matches(".*?&gtm_debug=x$")) {
        break label138;
      }
      this.WW = a.Xb;
    }
    catch (UnsupportedEncodingException paramUri)
    {
      for (;;)
      {
        bool = false;
        continue;
        this.WW = a.Xa;
      }
    }
    finally {}
    this.WY = g(paramUri);
    if ((this.WW == a.Xa) || (this.WW == a.Xb)) {
      this.WX = ("/r?" + this.WY);
    }
    this.Wq = br(this.WY);
    for (;;)
    {
      return bool;
      label138:
      label153:
      if (str.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$"))
      {
        if (br(paramUri.getQuery()).equals(this.Wq))
        {
          j.C("Exit preview mode for container: " + this.Wq);
          this.WW = a.WZ;
          this.WX = null;
        }
      }
      else
      {
        j.D("Invalid preview uri: " + str);
        bool = false;
        continue;
      }
      bool = false;
    }
  }
  
  String vD()
  {
    return this.Wq;
  }
  
  a vY()
  {
    return this.WW;
  }
  
  String vZ()
  {
    return this.WX;
  }
  
  static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/tagmanager/ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */