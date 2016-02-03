package com.parse.gdata;

public class PercentEscaper
  extends UnicodeEscaper
{
  public static final String SAFECHARS_URLENCODER = "-_.*";
  public static final String SAFEPATHCHARS_URLENCODER = "-_.!~*'()@:$&,;=";
  public static final String SAFEQUERYSTRINGCHARS_URLENCODER = "-_.!~*'()@:$,;/?:";
  private static final char[] UPPER_HEX_DIGITS = "0123456789ABCDEF".toCharArray();
  private static final char[] URI_ESCAPED_SPACE = { '+' };
  private final boolean plusForSpace;
  private final boolean[] safeOctets;
  
  public PercentEscaper(String paramString, boolean paramBoolean)
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
    this.plusForSpace = paramBoolean;
    this.safeOctets = createSafeOctets(paramString);
  }
  
  private static boolean[] createSafeOctets(String paramString)
  {
    int k = 0;
    int j = 122;
    paramString = paramString.toCharArray();
    int m = paramString.length;
    int i = 0;
    boolean[] arrayOfBoolean;
    if (i >= m)
    {
      arrayOfBoolean = new boolean[j + 1];
      i = 48;
      label32:
      if (i <= 57) {
        break label84;
      }
      i = 65;
      label41:
      if (i <= 90) {
        break label96;
      }
      i = 97;
      label50:
      if (i <= 122) {
        break label108;
      }
      j = paramString.length;
      i = k;
    }
    for (;;)
    {
      if (i >= j)
      {
        return arrayOfBoolean;
        j = Math.max(paramString[i], j);
        i += 1;
        break;
        label84:
        arrayOfBoolean[i] = true;
        i += 1;
        break label32;
        label96:
        arrayOfBoolean[i] = true;
        i += 1;
        break label41;
        label108:
        arrayOfBoolean[i] = true;
        i += 1;
        break label50;
      }
      arrayOfBoolean[paramString[i]] = true;
      i += 1;
    }
  }
  
  public String escape(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return paramString;
      }
      int k = paramString.charAt(i);
      if ((k >= this.safeOctets.length) || (this.safeOctets[k] == 0)) {
        return escapeSlow(paramString, i);
      }
      i += 1;
    }
  }
  
  protected char[] escape(int paramInt)
  {
    if ((paramInt < this.safeOctets.length) && (this.safeOctets[paramInt] != 0)) {
      return null;
    }
    if ((paramInt == 32) && (this.plusForSpace)) {
      return URI_ESCAPED_SPACE;
    }
    int i;
    if (paramInt <= 127)
    {
      i = UPPER_HEX_DIGITS[(paramInt & 0xF)];
      return new char[] { '%', UPPER_HEX_DIGITS[(paramInt >>> 4)], i };
    }
    int j;
    int k;
    if (paramInt <= 2047)
    {
      i = UPPER_HEX_DIGITS[(paramInt & 0xF)];
      paramInt >>>= 4;
      j = UPPER_HEX_DIGITS[(paramInt & 0x3 | 0x8)];
      paramInt >>>= 2;
      k = UPPER_HEX_DIGITS[(paramInt & 0xF)];
      return new char[] { '%', UPPER_HEX_DIGITS[(paramInt >>> 4 | 0xC)], k, '%', j, i };
    }
    int m;
    if (paramInt <= 65535)
    {
      i = UPPER_HEX_DIGITS[(paramInt & 0xF)];
      paramInt >>>= 4;
      j = UPPER_HEX_DIGITS[(paramInt & 0x3 | 0x8)];
      paramInt >>>= 2;
      k = UPPER_HEX_DIGITS[(paramInt & 0xF)];
      paramInt >>>= 4;
      m = UPPER_HEX_DIGITS[(paramInt & 0x3 | 0x8)];
      return new char[] { '%', 'E', UPPER_HEX_DIGITS[(paramInt >>> 2)], '%', m, k, '%', j, i };
    }
    if (paramInt <= 1114111)
    {
      i = UPPER_HEX_DIGITS[(paramInt & 0xF)];
      paramInt >>>= 4;
      j = UPPER_HEX_DIGITS[(paramInt & 0x3 | 0x8)];
      paramInt >>>= 2;
      k = UPPER_HEX_DIGITS[(paramInt & 0xF)];
      paramInt >>>= 4;
      m = UPPER_HEX_DIGITS[(paramInt & 0x3 | 0x8)];
      paramInt >>>= 2;
      int n = UPPER_HEX_DIGITS[(paramInt & 0xF)];
      paramInt >>>= 4;
      int i1 = UPPER_HEX_DIGITS[(paramInt & 0x3 | 0x8)];
      return new char[] { '%', 'F', UPPER_HEX_DIGITS[(paramInt >>> 2 & 0x7)], '%', i1, n, '%', m, k, '%', j, i };
    }
    throw new IllegalArgumentException("Invalid unicode character value " + paramInt);
  }
  
  protected int nextEscapeIndex(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      if (paramInt1 >= paramInt2) {}
      int i;
      do
      {
        return paramInt1;
        i = paramCharSequence.charAt(paramInt1);
      } while ((i >= this.safeOctets.length) || (this.safeOctets[i] == 0));
      paramInt1 += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/gdata/PercentEscaper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */