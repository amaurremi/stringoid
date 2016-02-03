package com.google.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

class PreviewManager
{
  private static PreviewManager aix;
  private volatile String aiA;
  private volatile String aiB;
  private volatile PreviewMode aiy;
  private volatile String aiz;
  
  PreviewManager()
  {
    clear();
  }
  
  static PreviewManager Au()
  {
    try
    {
      if (aix == null) {
        aix = new PreviewManager();
      }
      PreviewManager localPreviewManager = aix;
      return localPreviewManager;
    }
    finally {}
  }
  
  private String cT(String paramString)
  {
    return paramString.split("&")[0].split("=")[1];
  }
  
  private String i(Uri paramUri)
  {
    return paramUri.getQuery().replace("&gtm_debug=x", "");
  }
  
  PreviewMode Av()
  {
    return this.aiy;
  }
  
  String Aw()
  {
    return this.aiA;
  }
  
  void clear()
  {
    this.aiy = PreviewMode.aiC;
    this.aiA = null;
    this.aiz = null;
    this.aiB = null;
  }
  
  boolean h(Uri paramUri)
  {
    boolean bool = true;
    String str;
    try
    {
      str = URLDecoder.decode(paramUri.toString(), "UTF-8");
      if (!str.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
        break label153;
      }
      f.C("Container preview url: " + str);
      if (!str.matches(".*?&gtm_debug=x$")) {
        break label138;
      }
      this.aiy = PreviewMode.aiE;
    }
    catch (UnsupportedEncodingException paramUri)
    {
      for (;;)
      {
        bool = false;
        continue;
        this.aiy = PreviewMode.aiD;
      }
    }
    finally {}
    this.aiB = i(paramUri);
    if ((this.aiy == PreviewMode.aiD) || (this.aiy == PreviewMode.aiE)) {
      this.aiA = ("/r?" + this.aiB);
    }
    this.aiz = cT(this.aiB);
    for (;;)
    {
      return bool;
      label138:
      label153:
      if (str.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$"))
      {
        if (cT(paramUri.getQuery()).equals(this.aiz))
        {
          f.C("Exit preview mode for container: " + this.aiz);
          this.aiy = PreviewMode.aiC;
          this.aiA = null;
        }
      }
      else
      {
        f.D("Invalid preview uri: " + str);
        bool = false;
        continue;
      }
      bool = false;
    }
  }
  
  String vD()
  {
    return this.aiz;
  }
  
  static enum PreviewMode
  {
    private PreviewMode() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/tagmanager/PreviewManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */