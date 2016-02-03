package com.gau.go.launcherex.gowidget.scriptengine.parser;

import java.util.ArrayList;

public class z
{
  private DescriptionBean a = new DescriptionBean();
  private b b;
  private o c;
  private aa d;
  private ArrayList e = new ArrayList();
  
  public DescriptionBean a()
  {
    return this.a;
  }
  
  public t a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      localObject = new r(paramInt);
      this.e.add(localObject);
      return (t)localObject;
    }
    Object localObject = new t(paramInt);
    this.e.add(localObject);
    return (t)localObject;
  }
  
  public void a(s params)
  {
    int j = params.b();
    int i = 0;
    while (i < j)
    {
      this.e.add(params.a(i));
      i += 1;
    }
  }
  
  public aa b()
  {
    return this.d;
  }
  
  public t b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.e.size())) {
      return null;
    }
    return (t)this.e.get(paramInt);
  }
  
  public aa c()
  {
    this.d = new aa();
    return this.d;
  }
  
  public b d()
  {
    return this.b;
  }
  
  public b e()
  {
    this.b = new b();
    return this.b;
  }
  
  public o f()
  {
    return this.c;
  }
  
  public o g()
  {
    this.c = new o();
    return this.c;
  }
  
  public int h()
  {
    return this.e.size();
  }
  
  public void i()
  {
    this.b = null;
    this.d = null;
    this.c = null;
    this.e.clear();
  }
  
  public String toString()
  {
    Object localObject1 = "ScriptBean\n";
    if (this.b != null) {
      localObject1 = "ScriptBean\n" + "\t" + this.b.toString();
    }
    Object localObject2 = localObject1;
    if (this.d != null) {
      localObject2 = (String)localObject1 + "\t" + this.d.toString();
    }
    int j = this.e.size();
    int i = 0;
    while (i < j)
    {
      localObject2 = (String)localObject2 + "\t" + ((t)this.e.get(i)).toString();
      i += 1;
    }
    localObject1 = localObject2;
    if (this.c != null) {
      localObject1 = (String)localObject2 + "\t" + this.c.toString();
    }
    return (String)localObject1 + "ScriptBean\n";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/scriptengine/parser/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */