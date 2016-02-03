package com.jiubang.b.b;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import java.util.Calendar;
import java.util.Locale;

public class c
{
  private static final int[] a = { 19416, 19168, 42352, 21717, 53856, 55632, 91476, 22176, 39632, 21970, 19168, 42422, 42192, 53840, 119381, 46400, 54944, 44450, 38320, 84343, 18800, 42160, 46261, 27216, 27968, 109396, 11104, 38256, 21234, 18800, 25958, 54432, 59984, 28309, 23248, 11104, 100067, 37600, 116951, 51536, 54432, 120998, 46416, 22176, 107956, 9680, 37584, 53938, 43344, 46423, 27808, 46416, 86869, 19872, 42448, 83315, 21200, 43432, 59728, 27296, 44710, 43856, 19296, 43748, 42352, 21088, 62051, 55632, 23383, 22176, 38608, 19925, 19152, 42192, 54484, 53840, 54616, 46400, 46496, 103846, 38320, 18864, 43380, 42160, 45690, 27216, 27968, 44870, 43872, 38256, 19189, 18800, 25776, 29859, 59984, 27480, 21952, 43872, 38613, 37600, 51552, 55636, 54432, 55888, 30034, 22176, 43959, 9680, 37584, 51893, 43344, 46240, 47780, 44368, 21977, 19360, 42416, 86390, 21168, 43312, 31060, 27296, 44368, 23378, 19296, 42726, 42208, 53856, 60005, 54576, 23200, 30371, 38608, 19415, 19152, 42192, 118966, 53840, 54560, 56645, 46496, 22224, 21938, 18864, 42359, 42160, 43600, 111189, 27936, 44448 };
  private static final int[] b = new int[12];
  private static final int[] c = new int[30];
  private static final int[] d = new int[12];
  private static final int[] e = new int[24];
  private final int f = 348;
  private Context g = null;
  private int h = -1;
  private int i = -1;
  private int j = 0;
  private int k = 0;
  private int l = 0;
  
  public c(Context paramContext)
  {
    this.g = paramContext;
  }
  
  private int a(int paramInt)
  {
    if (paramInt < 0) {}
    for (;;)
    {
      return -1;
      int i1 = a.length;
      int n = 0;
      int m = paramInt;
      paramInt = n;
      while (paramInt < i1)
      {
        n = c(a[paramInt]);
        if (m <= n) {
          return paramInt;
        }
        m -= n;
        paramInt += 1;
      }
    }
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int n;
    for (int m = 0;; m = n)
    {
      if (paramInt1 >= paramInt2) {
        return m;
      }
      n = m;
      if (d(paramInt1)) {
        n = m + 1;
      }
      paramInt1 += 1;
    }
  }
  
  private int a(long paramLong, int paramInt)
  {
    if ((1 << 15 - paramInt & paramLong) == 0L) {
      return 29;
    }
    return 30;
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = b(paramInt1, paramInt2, paramInt3);
    this.l = paramInt1;
    this.l += 30;
    paramInt2 = b(paramInt1);
    paramInt1 = a(paramInt1);
    if (paramInt1 == -1) {}
    for (;;)
    {
      return false;
      int m = a[paramInt1];
      paramInt3 = m & 0xF;
      if (paramInt3 > 0)
      {
        this.i = (paramInt3 - 1);
        if ((0xF0000 & m) == 1)
        {
          this.k = 30;
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label223;
          }
          paramInt1 = 0;
        }
      }
      for (;;)
      {
        if (paramInt1 >= paramInt3)
        {
          if (paramInt2 > this.k) {
            break label171;
          }
          this.h = -1;
          this.j = paramInt2;
          return true;
          this.k = 29;
          paramInt1 = 1;
          break;
          paramInt1 = 0;
          break;
        }
        int n = a(m, paramInt1);
        if (paramInt2 <= n)
        {
          this.h = paramInt1;
          this.j = paramInt2;
          return true;
        }
        paramInt2 -= n;
        paramInt1 += 1;
      }
      label171:
      paramInt2 -= this.k;
      paramInt1 = paramInt3;
      while (paramInt1 < 12)
      {
        paramInt3 = a(m, paramInt1);
        if (paramInt2 <= paramInt3)
        {
          this.h = paramInt1;
          this.j = paramInt2;
          return true;
        }
        paramInt2 -= paramInt3;
        paramInt1 += 1;
        continue;
        label223:
        paramInt1 = 0;
      }
    }
  }
  
  private boolean a(Resources paramResources, String paramString)
  {
    b(paramResources, paramString);
    c(paramResources, paramString);
    d(paramResources, paramString);
    e(paramResources, paramString);
    return true;
  }
  
  private int b(int paramInt)
  {
    if (paramInt < 0) {}
    for (;;)
    {
      return -1;
      int n = a.length;
      int m = 0;
      while (m < n)
      {
        int i1 = c(a[m]);
        if (paramInt <= i1) {
          return paramInt;
        }
        m += 1;
        paramInt -= i1;
      }
    }
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    float f1 = paramInt1 - 1900;
    float f2 = paramInt2;
    return (int)(365.242D * f1 + 6.2D + 15.22D * f2 - Math.sin(f2 * 0.262D) * 1.9D);
  }
  
  private int b(int paramInt1, int paramInt2, int paramInt3)
  {
    int m = paramInt1;
    if (paramInt1 < 1900) {
      m = paramInt1 + 1900;
    }
    paramInt3 = (m - 1900) * 365 - 30 + a(1900, m) + e(paramInt2) + paramInt3;
    paramInt1 = paramInt3;
    if (d(m))
    {
      paramInt1 = paramInt3;
      if (paramInt2 > 1) {
        paramInt1 = paramInt3 + 1;
      }
    }
    return paramInt1;
  }
  
  private void b(Resources paramResources, String paramString)
  {
    b[0] = paramResources.getIdentifier("lunar_Jan", "string", paramString);
    b[1] = paramResources.getIdentifier("lunar_Feb", "string", paramString);
    b[2] = paramResources.getIdentifier("lunar_Mar", "string", paramString);
    b[3] = paramResources.getIdentifier("lunar_Apr", "string", paramString);
    b[4] = paramResources.getIdentifier("lunar_May", "string", paramString);
    b[5] = paramResources.getIdentifier("lunar_Jun", "string", paramString);
    b[6] = paramResources.getIdentifier("lunar_Jul", "string", paramString);
    b[7] = paramResources.getIdentifier("lunar_Aug", "string", paramString);
    b[8] = paramResources.getIdentifier("lunar_Sep", "string", paramString);
    b[9] = paramResources.getIdentifier("lunar_Oct", "string", paramString);
    b[10] = paramResources.getIdentifier("lunar_Nov", "string", paramString);
    b[11] = paramResources.getIdentifier("lunar_Dec", "string", paramString);
  }
  
  private int c(int paramInt)
  {
    int m = 348;
    long l1;
    if ((paramInt & 0xF) > 0L)
    {
      if (paramInt >> 16 == 1) {
        m = 378;
      }
    }
    else {
      l1 = 16L;
    }
    for (;;)
    {
      if (l1 > 32768L)
      {
        return m;
        m = 377;
        break;
      }
      int n = m;
      if ((paramInt & l1) > 0L) {
        n = m + 1;
      }
      l1 <<= 1;
      m = n;
    }
  }
  
  private void c(Resources paramResources, String paramString)
  {
    c[0] = paramResources.getIdentifier("lunar_day1", "string", paramString);
    c[1] = paramResources.getIdentifier("lunar_day2", "string", paramString);
    c[2] = paramResources.getIdentifier("lunar_day3", "string", paramString);
    c[3] = paramResources.getIdentifier("lunar_day4", "string", paramString);
    c[4] = paramResources.getIdentifier("lunar_day5", "string", paramString);
    c[5] = paramResources.getIdentifier("lunar_day6", "string", paramString);
    c[6] = paramResources.getIdentifier("lunar_day7", "string", paramString);
    c[7] = paramResources.getIdentifier("lunar_day8", "string", paramString);
    c[8] = paramResources.getIdentifier("lunar_day9", "string", paramString);
    c[9] = paramResources.getIdentifier("lunar_day10", "string", paramString);
    c[10] = paramResources.getIdentifier("lunar_day11", "string", paramString);
    c[11] = paramResources.getIdentifier("lunar_day12", "string", paramString);
    c[12] = paramResources.getIdentifier("lunar_day13", "string", paramString);
    c[13] = paramResources.getIdentifier("lunar_day14", "string", paramString);
    c[14] = paramResources.getIdentifier("lunar_day15", "string", paramString);
    c[15] = paramResources.getIdentifier("lunar_day16", "string", paramString);
    c[16] = paramResources.getIdentifier("lunar_day17", "string", paramString);
    c[17] = paramResources.getIdentifier("lunar_day18", "string", paramString);
    c[18] = paramResources.getIdentifier("lunar_day19", "string", paramString);
    c[19] = paramResources.getIdentifier("lunar_day20", "string", paramString);
    c[20] = paramResources.getIdentifier("lunar_day21", "string", paramString);
    c[21] = paramResources.getIdentifier("lunar_day22", "string", paramString);
    c[22] = paramResources.getIdentifier("lunar_day23", "string", paramString);
    c[23] = paramResources.getIdentifier("lunar_day24", "string", paramString);
    c[24] = paramResources.getIdentifier("lunar_day25", "string", paramString);
    c[25] = paramResources.getIdentifier("lunar_day26", "string", paramString);
    c[26] = paramResources.getIdentifier("lunar_day27", "string", paramString);
    c[27] = paramResources.getIdentifier("lunar_day28", "string", paramString);
    c[28] = paramResources.getIdentifier("lunar_day29", "string", paramString);
    c[29] = paramResources.getIdentifier("lunar_day30", "string", paramString);
  }
  
  private void d(Resources paramResources, String paramString)
  {
    d[0] = paramResources.getIdentifier("lunar_double1", "string", paramString);
    d[1] = paramResources.getIdentifier("lunar_double2", "string", paramString);
    d[2] = paramResources.getIdentifier("lunar_double3", "string", paramString);
    d[3] = paramResources.getIdentifier("lunar_double4", "string", paramString);
    d[4] = paramResources.getIdentifier("lunar_double5", "string", paramString);
    d[5] = paramResources.getIdentifier("lunar_double6", "string", paramString);
    d[6] = paramResources.getIdentifier("lunar_double7", "string", paramString);
    d[7] = paramResources.getIdentifier("lunar_double8", "string", paramString);
    d[8] = paramResources.getIdentifier("lunar_double9", "string", paramString);
    d[9] = paramResources.getIdentifier("lunar_double10", "string", paramString);
    d[10] = paramResources.getIdentifier("lunar_double11", "string", paramString);
    d[11] = paramResources.getIdentifier("lunar_double12", "string", paramString);
  }
  
  private boolean d(int paramInt)
  {
    return ((paramInt % 4 == 0) && (paramInt % 100 != 0)) || (paramInt % 400 == 0);
  }
  
  private int e(int paramInt)
  {
    int[] arrayOfInt = new int[12];
    arrayOfInt[1] = 31;
    arrayOfInt[2] = 59;
    arrayOfInt[3] = 90;
    arrayOfInt[4] = 120;
    arrayOfInt[5] = 151;
    arrayOfInt[6] = 181;
    arrayOfInt[7] = 212;
    arrayOfInt[8] = 243;
    arrayOfInt[9] = 273;
    arrayOfInt[10] = 304;
    arrayOfInt[11] = 334;
    return arrayOfInt[paramInt];
  }
  
  private void e(Resources paramResources, String paramString)
  {
    e[0] = paramResources.getIdentifier("lunar_xiaohan", "string", paramString);
    e[1] = paramResources.getIdentifier("lunar_dahan", "string", paramString);
    e[2] = paramResources.getIdentifier("lunar_licun", "string", paramString);
    e[3] = paramResources.getIdentifier("lunar_yushui", "string", paramString);
    e[4] = paramResources.getIdentifier("lunar_jingzhe", "string", paramString);
    e[5] = paramResources.getIdentifier("lunar_chunfen", "string", paramString);
    e[6] = paramResources.getIdentifier("lunar_qingming", "string", paramString);
    e[7] = paramResources.getIdentifier("lunar_guyu", "string", paramString);
    e[8] = paramResources.getIdentifier("lunar_lixia", "string", paramString);
    e[9] = paramResources.getIdentifier("lunar_xiaoman", "string", paramString);
    e[10] = paramResources.getIdentifier("lunar_mangzhong", "string", paramString);
    e[11] = paramResources.getIdentifier("lunar_xiazhi", "string", paramString);
    e[12] = paramResources.getIdentifier("lunar_xiaoshu", "string", paramString);
    e[13] = paramResources.getIdentifier("lunar_dashu", "string", paramString);
    e[14] = paramResources.getIdentifier("lunar_liqiu", "string", paramString);
    e[15] = paramResources.getIdentifier("lunar_chushu", "string", paramString);
    e[16] = paramResources.getIdentifier("lunar_bailu", "string", paramString);
    e[17] = paramResources.getIdentifier("lunar_qiufen", "string", paramString);
    e[18] = paramResources.getIdentifier("lunar_hanlu", "string", paramString);
    e[19] = paramResources.getIdentifier("lunar_shuangjiang", "string", paramString);
    e[20] = paramResources.getIdentifier("lunar_lidong", "string", paramString);
    e[21] = paramResources.getIdentifier("lunar_xiaoxue", "string", paramString);
    e[22] = paramResources.getIdentifier("lunar_daxue", "string", paramString);
    e[23] = paramResources.getIdentifier("lunar_dongzhi", "string", paramString);
  }
  
  public int a(Calendar paramCalendar)
  {
    if (!a(paramCalendar.get(1), paramCalendar.get(2), paramCalendar.get(5))) {
      return -1;
    }
    return this.l;
  }
  
  public String a(Calendar paramCalendar, boolean paramBoolean)
  {
    int m = paramCalendar.get(1);
    int n = paramCalendar.get(2);
    if (!a(m, n, paramCalendar.get(5))) {
      paramCalendar = null;
    }
    String str;
    label233:
    do
    {
      do
      {
        return paramCalendar;
        Resources localResources = this.g.getResources();
        a(localResources, this.g.getPackageName());
        n = n * 2 % 24;
        if (this.l == b(m, n)) {
          return localResources.getString(e[n]);
        }
        n += 1;
        if (this.l == b(m, n)) {
          return localResources.getString(e[n]);
        }
        if (this.h == -1) {}
        for (paramCalendar = localResources.getString(d[this.i]);; paramCalendar = localResources.getString(b[this.h]))
        {
          str = localResources.getString(c[(this.j - 1)]);
          if (localResources.getConfiguration().locale.getLanguage().equals("ko")) {
            break label233;
          }
          if (!paramBoolean) {
            break;
          }
          return paramCalendar + str;
        }
      } while (this.j == 1);
      return str;
      if (paramBoolean) {
        return paramCalendar + "." + str;
      }
    } while (this.j == 1);
    return str;
  }
  
  public int b(Calendar paramCalendar)
  {
    if (!a(paramCalendar.get(1), paramCalendar.get(2), paramCalendar.get(5))) {
      return -1;
    }
    return this.h;
  }
  
  public int c(Calendar paramCalendar)
  {
    if (!a(paramCalendar.get(1), paramCalendar.get(2), paramCalendar.get(5))) {
      return -1;
    }
    return this.j;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/b/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */