package com.venticake.retrica.a;

public enum h
{
  private int e;
  
  private h(int paramInt1)
  {
    this.e = paramInt1;
  }
  
  public static h a(int paramInt)
  {
    h[] arrayOfh = values();
    int j = arrayOfh.length;
    int i = 0;
    for (;;)
    {
      Object localObject;
      if (i >= j) {
        localObject = null;
      }
      h localh;
      do
      {
        return (h)localObject;
        localh = arrayOfh[i];
        localObject = localh;
      } while (localh.a() == paramInt);
      i += 1;
    }
  }
  
  public int a()
  {
    return this.e;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */