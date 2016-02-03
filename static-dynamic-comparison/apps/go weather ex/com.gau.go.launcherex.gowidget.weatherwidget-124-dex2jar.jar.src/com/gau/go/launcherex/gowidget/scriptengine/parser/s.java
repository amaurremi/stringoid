package com.gau.go.launcherex.gowidget.scriptengine.parser;

import java.util.ArrayList;

public class s
{
  private ArrayList a = new ArrayList();
  private int b;
  private int c;
  private String d;
  
  public r a()
  {
    r localr = new r(1);
    this.a.add(localr);
    return localr;
  }
  
  public r a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return (r)this.a.get(paramInt);
    }
    return null;
  }
  
  public int b()
  {
    return this.a.size();
  }
  
  public String toString()
  {
    String str = "ImageBeans areaX = " + this.b + ", areaY = " + this.c + ", src = " + this.d + "\n";
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      str = str + "\t" + ((r)this.a.get(i)).toString();
      i += 1;
    }
    return str + "ImageBeans\n";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/scriptengine/parser/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */