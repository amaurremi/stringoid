package com.google.api.client.util.a;

public class c
  extends e
{
  private static final char[] aen = { '+' };
  private static final char[] aeo = "0123456789ABCDEF".toCharArray();
  private final boolean aep;
  private final boolean[] aeq;
  
  public c(String paramString, boolean paramBoolean)
  {
    if (paramString.matches(".*[0-9A-Za-z].*")) {
      throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
    }
    if ((paramBoolean) && (paramString.contains(" "))) {
      throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
    }
    if (paramString.contains("%")) {
      throw new IllegalArgumentException("The '%' character cannot be specified as 'safe'");
    }
    this.aep = paramBoolean;
    this.aeq = cA(paramString);
  }
  
  private static boolean[] cA(String paramString)
  {
    int k = 0;
    paramString = paramString.toCharArray();
    int m = paramString.length;
    int i = 0;
    int j = 122;
    while (i < m)
    {
      j = Math.max(paramString[i], j);
      i += 1;
    }
    boolean[] arrayOfBoolean = new boolean[j + 1];
    i = 48;
    while (i <= 57)
    {
      arrayOfBoolean[i] = true;
      i += 1;
    }
    i = 65;
    while (i <= 90)
    {
      arrayOfBoolean[i] = true;
      i += 1;
    }
    i = 97;
    while (i <= 122)
    {
      arrayOfBoolean[i] = true;
      i += 1;
    }
    j = paramString.length;
    i = k;
    while (i < j)
    {
      arrayOfBoolean[paramString[i]] = true;
      i += 1;
    }
    return arrayOfBoolean;
  }
  
  protected int a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      if (paramInt1 < paramInt2)
      {
        int i = paramCharSequence.charAt(paramInt1);
        if ((i < this.aeq.length) && (this.aeq[i] != 0)) {}
      }
      else
      {
        return paramInt1;
      }
      paramInt1 += 1;
    }
  }
  
  public String cz(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    for (;;)
    {
      String str = paramString;
      if (i < j)
      {
        int k = paramString.charAt(i);
        if ((k >= this.aeq.length) || (this.aeq[k] == 0)) {
          str = j(paramString, i);
        }
      }
      else
      {
        return str;
      }
      i += 1;
    }
  }
  
  protected char[] eP(int paramInt)
  {
    if ((paramInt < this.aeq.length) && (this.aeq[paramInt] != 0)) {
      return null;
    }
    if ((paramInt == 32) && (this.aep)) {
      return aen;
    }
    int i;
    if (paramInt <= 127)
    {
      i = aeo[(paramInt & 0xF)];
      return new char[] { '%', aeo[(paramInt >>> 4)], i };
    }
    int j;
    int k;
    if (paramInt <= 2047)
    {
      i = aeo[(paramInt & 0xF)];
      paramInt >>>= 4;
      j = aeo[(paramInt & 0x3 | 0x8)];
      paramInt >>>= 2;
      k = aeo[(paramInt & 0xF)];
      return new char[] { '%', aeo[(paramInt >>> 4 | 0xC)], k, '%', j, i };
    }
    int m;
    if (paramInt <= 65535)
    {
      i = aeo[(paramInt & 0xF)];
      paramInt >>>= 4;
      j = aeo[(paramInt & 0x3 | 0x8)];
      paramInt >>>= 2;
      k = aeo[(paramInt & 0xF)];
      paramInt >>>= 4;
      m = aeo[(paramInt & 0x3 | 0x8)];
      return new char[] { '%', 'E', aeo[(paramInt >>> 2)], '%', m, k, '%', j, i };
    }
    if (paramInt <= 1114111)
    {
      i = aeo[(paramInt & 0xF)];
      paramInt >>>= 4;
      j = aeo[(paramInt & 0x3 | 0x8)];
      paramInt >>>= 2;
      k = aeo[(paramInt & 0xF)];
      paramInt >>>= 4;
      m = aeo[(paramInt & 0x3 | 0x8)];
      paramInt >>>= 2;
      int n = aeo[(paramInt & 0xF)];
      paramInt >>>= 4;
      int i1 = aeo[(paramInt & 0x3 | 0x8)];
      return new char[] { '%', 'F', aeo[(paramInt >>> 2 & 0x7)], '%', i1, n, '%', m, k, '%', j, i };
    }
    throw new IllegalArgumentException("Invalid unicode character value " + paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/util/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */