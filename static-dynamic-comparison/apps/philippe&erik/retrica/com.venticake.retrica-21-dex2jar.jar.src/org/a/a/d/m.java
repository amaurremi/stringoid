package org.a.a.d;

import java.util.Locale;
import org.a.a.a;
import org.a.a.i;

class m
  implements p, s
{
  private final String a;
  private final String b;
  private final boolean c;
  private final int d;
  private final int e;
  
  m(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramBoolean;
    if ((paramInt1 <= 0) || (paramInt2 < paramInt1)) {
      throw new IllegalArgumentException();
    }
    if (paramInt1 > 4)
    {
      paramInt2 = 4;
      paramInt1 = i;
    }
    for (;;)
    {
      this.d = paramInt1;
      this.e = paramInt2;
      return;
    }
  }
  
  private int a(String paramString, int paramInt1, int paramInt2)
  {
    paramInt2 = Math.min(paramString.length() - paramInt1, paramInt2);
    int i = 0;
    for (;;)
    {
      if (paramInt2 > 0)
      {
        int j = paramString.charAt(paramInt1 + i);
        if ((j >= 48) && (j <= 57)) {}
      }
      else
      {
        return i;
      }
      i += 1;
      paramInt2 -= 1;
    }
  }
  
  public int a()
  {
    int j = this.d + 1 << 1;
    int i = j;
    if (this.c) {
      i = j + (this.d - 1);
    }
    j = i;
    if (this.a != null)
    {
      j = i;
      if (this.a.length() > i) {
        j = this.a.length();
      }
    }
    return j;
  }
  
  public int a(q paramq, String paramString, int paramInt)
  {
    int m = 0;
    int i = paramString.length() - paramInt;
    if (this.b != null)
    {
      if (this.b.length() != 0) {
        break label74;
      }
      if (i <= 0) {
        break label64;
      }
      j = paramString.charAt(paramInt);
      if ((j != 45) && (j != 43)) {
        break label64;
      }
    }
    while (i <= 1)
    {
      return paramInt ^ 0xFFFFFFFF;
      label64:
      paramq.a(Integer.valueOf(0));
      return paramInt;
      label74:
      if (paramString.regionMatches(true, paramInt, this.b, 0, this.b.length()))
      {
        paramq.a(Integer.valueOf(0));
        return paramInt + this.b.length();
      }
    }
    int j = paramString.charAt(paramInt);
    if (j == 45) {}
    for (int k = 1;; k = 0)
    {
      j = paramInt + 1;
      if (a(paramString, j, 2) >= 2) {
        break label169;
      }
      return j ^ 0xFFFFFFFF;
      if (j != 43) {
        break;
      }
    }
    return paramInt ^ 0xFFFFFFFF;
    label169:
    paramInt = t.a(paramString, j);
    if (paramInt > 23) {
      return j ^ 0xFFFFFFFF;
    }
    paramInt *= 3600000;
    int n = i - 1 - 2;
    j += 2;
    if (n <= 0) {
      i = j;
    }
    label305:
    label312:
    label666:
    for (;;)
    {
      if (k != 0) {
        paramInt = -paramInt;
      }
      for (;;)
      {
        paramq.a(Integer.valueOf(paramInt));
        return i;
        int i1 = paramString.charAt(j);
        if (i1 == 58)
        {
          n -= 1;
          i = j + 1;
          m = 1;
        }
        do
        {
          j = a(paramString, i, 2);
          if ((j != 0) || (m != 0)) {
            break label312;
          }
          break;
          if (i1 < 48) {
            break label305;
          }
          i = j;
        } while (i1 <= 57);
        i = j;
        break;
        if (j < 2) {
          return i ^ 0xFFFFFFFF;
        }
        j = t.a(paramString, i);
        if (j > 59) {
          return i ^ 0xFFFFFFFF;
        }
        paramInt += j * 60000;
        i1 = n - 2;
        j = i + 2;
        if (i1 <= 0)
        {
          i = j;
          break;
        }
        n = i1;
        i = j;
        if (m != 0)
        {
          if (paramString.charAt(j) != ':')
          {
            i = j;
            break;
          }
          n = i1 - 1;
          i = j + 1;
        }
        j = a(paramString, i, 2);
        if ((j == 0) && (m == 0)) {
          break;
        }
        if (j < 2) {
          return i ^ 0xFFFFFFFF;
        }
        j = t.a(paramString, i);
        if (j > 59) {
          return i ^ 0xFFFFFFFF;
        }
        paramInt += j * 1000;
        j = n - 2;
        i += 2;
        if (j <= 0) {
          break;
        }
        j = i;
        if (m != 0)
        {
          if ((paramString.charAt(i) != '.') && (paramString.charAt(i) != ',')) {
            break;
          }
          j = i + 1;
        }
        n = a(paramString, j, 3);
        if ((n == 0) && (m == 0))
        {
          i = j;
          break;
        }
        if (n < 1) {
          return j ^ 0xFFFFFFFF;
        }
        i = j + 1;
        paramInt = (paramString.charAt(j) - '0') * 100 + paramInt;
        if (n <= 1) {
          break label666;
        }
        j = i + 1;
        m = (paramString.charAt(i) - '0') * 10 + paramInt;
        paramInt = m;
        i = j;
        if (n <= 2) {
          break;
        }
        paramInt = m + (paramString.charAt(j) - '0');
        i = j + 1;
        break;
      }
    }
  }
  
  public void a(StringBuffer paramStringBuffer, long paramLong, a parama, int paramInt, i parami, Locale paramLocale)
  {
    if (parami == null) {
      return;
    }
    if ((paramInt == 0) && (this.a != null))
    {
      paramStringBuffer.append(this.a);
      return;
    }
    if (paramInt >= 0) {
      paramStringBuffer.append('+');
    }
    for (;;)
    {
      int i = paramInt / 3600000;
      t.a(paramStringBuffer, i, 2);
      if (this.e == 1) {
        break;
      }
      paramInt -= i * 3600000;
      if ((paramInt == 0) && (this.d <= 1)) {
        break;
      }
      i = paramInt / 60000;
      if (this.c) {
        paramStringBuffer.append(':');
      }
      t.a(paramStringBuffer, i, 2);
      if (this.e == 2) {
        break;
      }
      paramInt -= i * 60000;
      if ((paramInt == 0) && (this.d <= 2)) {
        break;
      }
      i = paramInt / 1000;
      if (this.c) {
        paramStringBuffer.append(':');
      }
      t.a(paramStringBuffer, i, 2);
      if (this.e == 3) {
        break;
      }
      paramInt -= i * 1000;
      if ((paramInt == 0) && (this.d <= 3)) {
        break;
      }
      if (this.c) {
        paramStringBuffer.append('.');
      }
      t.a(paramStringBuffer, paramInt, 3);
      return;
      paramStringBuffer.append('-');
      paramInt = -paramInt;
    }
  }
  
  public int b()
  {
    return a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/d/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */