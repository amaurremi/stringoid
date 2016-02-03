package com.skplanet.tad.controller;

import com.skplanet.tad.common.a;
import java.text.SimpleDateFormat;
import java.util.Date;

public class h
  implements Runnable
{
  private Object a;
  private String b;
  private String c;
  private StringBuffer d = new StringBuffer();
  
  public h(Object paramObject, String paramString1, String paramString2)
  {
    this.a = paramObject;
    this.b = paramString1;
    this.c = paramString2;
    this.d.append("AdTracker for " + paramObject.hashCode());
    this.d.append("\n");
  }
  
  public void a(String paramString)
  {
    String str = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
    this.d.append(this.b);
    this.d.append(", ");
    this.d.append(this.c);
    this.d.append(", ");
    this.d.append(str);
    this.d.append(", ");
    this.d.append(paramString);
    this.d.append("\n");
  }
  
  public void run()
  {
    if (this.d.length() > 0)
    {
      a.c("AdTracker for " + this.a.hashCode());
      a.c(this.d.toString());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/controller/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */