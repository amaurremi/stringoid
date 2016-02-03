package com.jiubang.playsdk.imageload;

import android.graphics.Bitmap;
import com.android.a.aa;
import com.android.a.p;
import java.util.LinkedList;

class h
{
  private final p b;
  private Bitmap c;
  private aa d;
  private final LinkedList e = new LinkedList();
  
  public h(d paramd, p paramp, j paramj)
  {
    this.b = paramp;
    this.e.add(paramj);
  }
  
  public aa a()
  {
    return this.d;
  }
  
  public void a(aa paramaa)
  {
    this.d = paramaa;
  }
  
  public void a(j paramj)
  {
    this.e.add(paramj);
  }
  
  public boolean b(j paramj)
  {
    this.e.remove(paramj);
    if (this.e.size() == 0)
    {
      this.b.g();
      return true;
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/imageload/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */