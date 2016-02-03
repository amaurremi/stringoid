package com.gau.go.launcherex.gowidget.scriptengine.parser;

import java.util.ArrayList;

public class p
  extends d
{
  private ArrayList h = new ArrayList();
  private int i;
  
  public p(int paramInt)
  {
    super(paramInt);
  }
  
  public int a()
  {
    return this.i;
  }
  
  public q a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.i)) {
      return (q)this.h.get(paramInt);
    }
    return null;
  }
  
  public q a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    q localq = new q(this);
    localq.a = paramString;
    localq.b = paramInt1;
    localq.c = paramInt2;
    localq.d = paramInt3;
    this.h.add(localq);
    return localq;
  }
  
  public void a(p paramp1, p paramp2)
  {
    super.a(paramp1, paramp2);
    paramp1.b(paramp2.a());
    int j = 0;
    while (j < paramp2.a())
    {
      q localq = paramp2.a(j);
      paramp1.a(localq.a, localq.b, localq.c, localq.d);
      j += 1;
    }
  }
  
  public void b(int paramInt)
  {
    this.i = paramInt;
  }
  
  public String toString()
  {
    String str = "frame\n" + "amount : " + this.i + "\n";
    int j = 0;
    while (j < this.i)
    {
      q localq = (q)this.h.get(j);
      str = str + "img : " + localq.a + ", startTime : " + localq.b + ", endTime : " + localq.c + ", visibility : " + localq.d + "\n";
      j += 1;
    }
    return str + "frame\n";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/scriptengine/parser/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */