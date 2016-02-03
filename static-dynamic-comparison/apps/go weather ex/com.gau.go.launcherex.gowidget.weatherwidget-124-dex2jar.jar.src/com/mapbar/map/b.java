package com.mapbar.map;

public class b
{
  private static int[] a = { 4500000, 2000000, 1000000, 500000, 250000, 100000, 50000, 25000, 10000, 5000, 2500, 1000, 500, 250, 100 };
  private static int[] b = { 3600000, 1600000, 800000, 400000, 200000, 80000, 40000, 20000, 8000, 4000, 2000, 800, 400, 200, 80 };
  
  public static String a(int paramInt1, int paramInt2, int paramInt3)
  {
    int n = 8;
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      return null;
    }
    Object localObject = "" + paramInt3;
    int i2 = a[paramInt3];
    int i1 = b[paramInt3];
    int k = paramInt1 / i2;
    int m = paramInt2 / i1;
    int j;
    int i;
    if (paramInt3 >= 5)
    {
      j = 1000;
      i = 800;
      int i3 = paramInt1 * 100 / 1000 / 100000;
      int i4 = paramInt2 * 100 / 800 / 100000;
      String str = (String)localObject + "/" + i3 + "_" + i4;
      localObject = str;
      if (paramInt3 >= 8)
      {
        j = 100;
        i = 80;
        i3 = paramInt1 * 100 / 100 / 100000;
        i4 = paramInt2 * 100 / 80 / 100000;
        str = str + "/" + i3 % 10 + "_" + i4 % 10;
        localObject = str;
        if (paramInt3 >= 11)
        {
          paramInt3 = 10;
          paramInt1 = paramInt1 * 100 / 10 / 100000;
          paramInt2 = paramInt2 * 100 / 8 / 100000;
          localObject = str + "/" + paramInt1 % 10 + "_" + paramInt2 % 10;
          paramInt2 = paramInt3;
          paramInt1 = n;
          paramInt2 = k % (paramInt2 * 100000 / i2 / 100);
          paramInt1 = m % (paramInt1 * 100000 / i1 / 100);
        }
      }
    }
    for (;;)
    {
      return (String)localObject + "/" + paramInt2 + "_" + paramInt1;
      paramInt1 = i;
      paramInt2 = j;
      break;
      paramInt1 = m;
      paramInt2 = k;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/map/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */