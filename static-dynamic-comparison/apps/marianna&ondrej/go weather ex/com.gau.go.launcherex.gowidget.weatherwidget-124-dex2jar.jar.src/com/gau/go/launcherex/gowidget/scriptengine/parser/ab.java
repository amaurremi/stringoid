package com.gau.go.launcherex.gowidget.scriptengine.parser;

import java.util.ArrayList;

public class ab
  extends d
{
  private ArrayList h = new ArrayList();
  
  public ab(int paramInt)
  {
    super(paramInt);
  }
  
  public int a()
  {
    return this.h.size();
  }
  
  public d a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 2: 
      localObject = new a(paramInt);
      this.h.add(localObject);
      return (d)localObject;
    case 4: 
      localObject = new x(paramInt);
      this.h.add(localObject);
      return (d)localObject;
    case 1: 
      localObject = new y(paramInt);
      this.h.add(localObject);
      return (d)localObject;
    case 3: 
      localObject = new ad(paramInt);
      this.h.add(localObject);
      return (d)localObject;
    case 6: 
      localObject = new ab(paramInt);
      this.h.add(localObject);
      return (d)localObject;
    case 5: 
      localObject = new p(paramInt);
      this.h.add(localObject);
      return (d)localObject;
    }
    Object localObject = new g(paramInt);
    this.h.add(localObject);
    return (d)localObject;
  }
  
  public d b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.h.size())) {
      return null;
    }
    return (d)this.h.get(paramInt);
  }
  
  public String toString()
  {
    int j = this.h.size();
    String str = "SetBehavior \n";
    int i = 0;
    while (i < j)
    {
      str = str + "\t" + ((d)this.h.get(i)).toString();
      i += 1;
    }
    return str + "SetBehavior\n";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/scriptengine/parser/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */