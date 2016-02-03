package com.google.gson.stream;

final class StringPool
{
  private final String[] pool = new String['Ȁ'];
  
  public String get(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int k = 0;
    int i = paramInt1;
    int j = 0;
    while (i < paramInt1 + paramInt2)
    {
      j = j * 31 + paramArrayOfChar[i];
      i += 1;
    }
    i = j >>> 20 ^ j >>> 12 ^ j;
    j = this.pool.length - 1 & (i ^ i >>> 7 ^ i >>> 4);
    String str2 = this.pool[j];
    String str1;
    if (str2 != null)
    {
      i = k;
      if (str2.length() == paramInt2) {}
    }
    else
    {
      str1 = new String(paramArrayOfChar, paramInt1, paramInt2);
      this.pool[j] = str1;
      return str1;
    }
    do
    {
      i += 1;
      str1 = str2;
      if (i >= paramInt2) {
        break;
      }
    } while (str2.charAt(i) == paramArrayOfChar[(paramInt1 + i)]);
    paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
    this.pool[j] = paramArrayOfChar;
    return paramArrayOfChar;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/stream/StringPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */