package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class y
  implements aq
{
  private static y aoQ;
  private static final Object xz = new Object();
  private String aoR;
  private String aoS;
  private ar aoT;
  private cg aoh;
  
  private y(Context paramContext)
  {
    this(as.Y(paramContext), new cw());
  }
  
  y(ar paramar, cg paramcg)
  {
    this.aoT = paramar;
    this.aoh = paramcg;
  }
  
  public static aq W(Context paramContext)
  {
    synchronized (xz)
    {
      if (aoQ == null) {
        aoQ = new y(paramContext);
      }
      paramContext = aoQ;
      return paramContext;
    }
  }
  
  public boolean cw(String paramString)
  {
    if (!this.aoh.eK())
    {
      bh.W("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
      return false;
    }
    String str = paramString;
    if (this.aoR != null)
    {
      str = paramString;
      if (this.aoS == null) {}
    }
    try
    {
      str = this.aoR + "?" + this.aoS + "=" + URLEncoder.encode(paramString, "UTF-8");
      bh.V("Sending wrapped url hit: " + str);
      this.aoT.cz(str);
      return true;
    }
    catch (UnsupportedEncodingException paramString)
    {
      bh.d("Error wrapping URL for testing.", paramString);
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/tagmanager/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */