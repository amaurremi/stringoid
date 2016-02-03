package com.gtp.nextlauncher.widget.weatherwidget;

import java.nio.ShortBuffer;
import java.util.ArrayList;

public class l
{
  public m a;
  public m b;
  public m c;
  public m d;
  private ArrayList e = new ArrayList();
  
  public l(m paramm1, m paramm2, m paramm3, m paramm4)
  {
    this.a = paramm1;
    this.b = paramm2;
    this.c = paramm3;
    this.d = paramm4;
    this.e.add(this.a);
    this.e.add(this.b);
    this.e.add(this.c);
    this.e.add(this.d);
  }
  
  public int a()
  {
    return 6;
  }
  
  public void a(ShortBuffer paramShortBuffer)
  {
    paramShortBuffer.put(this.a.a());
    paramShortBuffer.put(this.b.a());
    paramShortBuffer.put(this.d.a());
    paramShortBuffer.put(this.b.a());
    paramShortBuffer.put(this.c.a());
    paramShortBuffer.put(this.d.a());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/weatherwidget/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */