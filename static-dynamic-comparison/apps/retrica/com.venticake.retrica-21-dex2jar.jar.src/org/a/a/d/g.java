package org.a.a.d;

import org.a.a.d;

abstract class g
  implements p, s
{
  protected final d a;
  protected final int b;
  protected final boolean c;
  
  g(d paramd, int paramInt, boolean paramBoolean)
  {
    this.a = paramd;
    this.b = paramInt;
    this.c = paramBoolean;
  }
  
  public int a(q paramq, String paramString, int paramInt)
  {
    int m = Math.min(this.b, paramString.length() - paramInt);
    int j = 0;
    int i = paramInt;
    int k = 0;
    paramInt = j;
    j = k;
    k = paramInt;
    int n;
    if (j < m)
    {
      n = paramString.charAt(i + j);
      if ((j == 0) && ((n == 45) || (n == 43)) && (this.c)) {
        if (n == 45)
        {
          paramInt = 1;
          label87:
          k = paramInt;
          if (j + 1 >= m) {
            break label367;
          }
          n = paramString.charAt(i + j + 1);
          k = paramInt;
          if (n < 48) {
            break label367;
          }
          if (n <= 57) {
            break label144;
          }
        }
      }
    }
    for (;;)
    {
      if (j == 0)
      {
        return i ^ 0xFFFFFFFF;
        paramInt = 0;
        break label87;
        label144:
        if (paramInt != 0) {
          j += 1;
        }
        for (;;)
        {
          m = Math.min(m + 1, paramString.length() - i);
          break;
          i += 1;
        }
        k = paramInt;
        if (n < 48) {
          break label367;
        }
        if (n > 57) {
          continue;
        }
        j += 1;
        break;
      }
      if (j >= 9)
      {
        k = i + j;
        j = Integer.parseInt(paramString.substring(i, k));
        paramq.a(this.a, j);
        return k;
      }
      if (paramInt != 0) {}
      for (k = i + 1;; k = i)
      {
        n = k + 1;
        try
        {
          k = paramString.charAt(k);
          m = i + j;
          i = k - 48;
          j = n;
          while (j < m)
          {
            i = paramString.charAt(j) + ((i << 3) + (i << 1)) - 48;
            j += 1;
          }
          j = i;
        }
        catch (StringIndexOutOfBoundsException paramq)
        {
          return i ^ 0xFFFFFFFF;
        }
        k = m;
        if (paramInt == 0) {
          break;
        }
        j = -i;
        k = m;
        break;
      }
      label367:
      paramInt = k;
    }
  }
  
  public int b()
  {
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/d/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */