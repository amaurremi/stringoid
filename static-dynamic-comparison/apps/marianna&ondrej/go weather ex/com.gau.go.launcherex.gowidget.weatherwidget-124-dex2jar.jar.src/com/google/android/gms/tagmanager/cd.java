package com.google.android.gms.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

class cd
{
  private static cd YP;
  private volatile String WJ;
  private volatile a YQ;
  private volatile String YR;
  private volatile String YS;
  
  cd()
  {
    clear();
  }
  
  private String bI(String paramString)
  {
    return paramString.split("&")[0].split("=")[1];
  }
  
  private String h(Uri paramUri)
  {
    return paramUri.getQuery().replace("&gtm_debug=x", "");
  }
  
  static cd kT()
  {
    try
    {
      if (YP == null) {
        YP = new cd();
      }
      cd localcd = YP;
      return localcd;
    }
    finally {}
  }
  
  void clear()
  {
    this.YQ = a.YT;
    this.YR = null;
    this.WJ = null;
    this.YS = null;
  }
  
  boolean g(Uri paramUri)
  {
    boolean bool = true;
    String str;
    try
    {
      str = URLDecoder.decode(paramUri.toString(), "UTF-8");
      if (!str.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
        break label153;
      }
      bh.y("Container preview url: " + str);
      if (!str.matches(".*?&gtm_debug=x$")) {
        break label138;
      }
      this.YQ = a.YV;
    }
    catch (UnsupportedEncodingException paramUri)
    {
      for (;;)
      {
        bool = false;
        continue;
        this.YQ = a.YU;
      }
    }
    finally {}
    this.YS = h(paramUri);
    if ((this.YQ == a.YU) || (this.YQ == a.YV)) {
      this.YR = ("/r?" + this.YS);
    }
    this.WJ = bI(this.YS);
    for (;;)
    {
      return bool;
      label138:
      label153:
      if (str.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$"))
      {
        if (bI(paramUri.getQuery()).equals(this.WJ))
        {
          bh.y("Exit preview mode for container: " + this.WJ);
          this.YQ = a.YT;
          this.YR = null;
        }
      }
      else
      {
        bh.z("Invalid preview uri: " + str);
        bool = false;
        continue;
      }
      bool = false;
    }
  }
  
  String getContainerId()
  {
    return this.WJ;
  }
  
  a kU()
  {
    return this.YQ;
  }
  
  String kV()
  {
    return this.YR;
  }
  
  static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/tagmanager/cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */