package com.gau.go.launcherex.gowidget.scriptengine.parser;

public class g
  extends d
{
  private int h;
  private int i;
  private int j;
  
  public g(int paramInt)
  {
    super(paramInt);
  }
  
  public int a()
  {
    return this.h;
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public int b()
  {
    return this.i;
  }
  
  public void b(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void h(int paramInt)
  {
    this.j = paramInt;
  }
  
  public int i()
  {
    return this.j;
  }
  
  public String toString()
  {
    String str = "cycle\n" + super.toString();
    str = str + "initOffsetX : " + this.h + ", initOffsetY : " + this.i + ", direction : " + this.j;
    return str + "\n";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/scriptengine/parser/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */