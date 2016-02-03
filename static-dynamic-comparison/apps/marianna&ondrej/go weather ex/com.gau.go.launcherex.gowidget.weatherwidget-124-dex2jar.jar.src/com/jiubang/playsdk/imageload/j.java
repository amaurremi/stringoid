package com.jiubang.playsdk.imageload;

import android.graphics.Bitmap;
import java.util.HashMap;
import java.util.LinkedList;

public class j
{
  private Bitmap b;
  private final k c;
  private final String d;
  private final String e;
  
  public j(d paramd, Bitmap paramBitmap, String paramString1, String paramString2, k paramk)
  {
    this.b = paramBitmap;
    this.e = paramString1;
    this.d = paramString2;
    this.c = paramk;
  }
  
  public void a()
  {
    if (this.c == null) {}
    h localh;
    do
    {
      do
      {
        do
        {
          return;
          localh = (h)d.a(this.a).get(this.d);
          if (localh == null) {
            break;
          }
        } while (!localh.b(this));
        d.a(this.a).remove(this.d);
        return;
        localh = (h)d.b(this.a).get(this.d);
      } while (localh == null);
      localh.b(this);
    } while (h.a(localh).size() != 0);
    d.b(this.a).remove(this.d);
  }
  
  public Bitmap b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.e;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/imageload/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */