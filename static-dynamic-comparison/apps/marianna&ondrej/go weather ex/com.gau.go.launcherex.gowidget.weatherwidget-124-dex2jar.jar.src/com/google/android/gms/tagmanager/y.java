package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class y
  implements aq
{
  private static y XM;
  private static final Object sf = new Object();
  private String XN;
  private String XO;
  private ar XP;
  private cf Xa;
  
  private y(Context paramContext)
  {
    this(as.H(paramContext), new cv());
  }
  
  y(ar paramar, cf paramcf)
  {
    this.XP = paramar;
    this.Xa = paramcf;
  }
  
  public static aq F(Context paramContext)
  {
    synchronized (sf)
    {
      if (XM == null) {
        XM = new y(paramContext);
      }
      paramContext = XM;
      return paramContext;
    }
  }
  
  public boolean bz(String paramString)
  {
    if (!this.Xa.cS())
    {
      bh.z("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
      return false;
    }
    String str = paramString;
    if (this.XN != null)
    {
      str = paramString;
      if (this.XO == null) {}
    }
    try
    {
      str = this.XN + "?" + this.XO + "=" + URLEncoder.encode(paramString, "UTF-8");
      bh.y("Sending wrapped url hit: " + str);
      this.XP.bC(str);
      return true;
    }
    catch (UnsupportedEncodingException paramString)
    {
      bh.c("Error wrapping URL for testing.", paramString);
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/tagmanager/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */