package com.go.weatherex.viewex;

class h
  implements i
{
  private int[] a;
  private int[] b;
  
  public final int a(int paramInt)
  {
    return this.a[(paramInt % this.a.length)];
  }
  
  void a(int... paramVarArgs)
  {
    this.a = paramVarArgs;
  }
  
  public final int b(int paramInt)
  {
    return this.b[(paramInt % this.b.length)];
  }
  
  void b(int... paramVarArgs)
  {
    this.b = paramVarArgs;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/viewex/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */