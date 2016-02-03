package com.google.android.gms.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

class ce
{
  private static ce apS;
  private volatile String anR;
  private volatile a apT;
  private volatile String apU;
  private volatile String apV;
  
  ce()
  {
    clear();
  }
  
  private String cF(String paramString)
  {
    return paramString.split("&")[0].split("=")[1];
  }
  
  private String j(Uri paramUri)
  {
    return paramUri.getQuery().replace("&gtm_debug=x", "");
  }
  
  static ce oH()
  {
    try
    {
      if (apS == null) {
        apS = new ce();
      }
      ce localce = apS;
      return localce;
    }
    finally {}
  }
  
  void clear()
  {
    this.apT = a.apW;
    this.apU = null;
    this.anR = null;
    this.apV = null;
  }
  
  String getContainerId()
  {
    return this.anR;
  }
  
  boolean i(Uri paramUri)
  {
    boolean bool = true;
    String str;
    try
    {
      str = URLDecoder.decode(paramUri.toString(), "UTF-8");
      if (!str.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
        break label153;
      }
      bh.V("Container preview url: " + str);
      if (!str.matches(".*?&gtm_debug=x$")) {
        break label138;
      }
      this.apT = a.apY;
    }
    catch (UnsupportedEncodingException paramUri)
    {
      for (;;)
      {
        bool = false;
        continue;
        this.apT = a.apX;
      }
    }
    finally {}
    this.apV = j(paramUri);
    if ((this.apT == a.apX) || (this.apT == a.apY)) {
      this.apU = ("/r?" + this.apV);
    }
    this.anR = cF(this.apV);
    for (;;)
    {
      return bool;
      label138:
      label153:
      if (str.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$"))
      {
        if (cF(paramUri.getQuery()).equals(this.anR))
        {
          bh.V("Exit preview mode for container: " + this.anR);
          this.apT = a.apW;
          this.apU = null;
        }
      }
      else
      {
        bh.W("Invalid preview uri: " + str);
        bool = false;
        continue;
      }
      bool = false;
    }
  }
  
  a oI()
  {
    return this.apT;
  }
  
  String oJ()
  {
    return this.apU;
  }
  
  static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/tagmanager/ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */