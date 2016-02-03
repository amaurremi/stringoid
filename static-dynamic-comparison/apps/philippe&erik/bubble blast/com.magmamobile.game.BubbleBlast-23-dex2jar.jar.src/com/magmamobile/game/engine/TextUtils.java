package com.magmamobile.game.engine;

import android.graphics.Paint;
import android.graphics.Rect;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class TextUtils
{
  private static final int CMAX = 16;
  private static Rect _bounds;
  private static char[] chars;
  
  private static final String additif(int paramInt, char paramChar1, char paramChar2)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return paramChar1;
    case 2: 
      return paramChar1 + paramChar1;
    case 3: 
      return paramChar1 + paramChar1 + paramChar1;
    case 4: 
      return paramChar1 + paramChar1 + paramChar1 + paramChar1;
    case 5: 
      return paramChar2;
    case 6: 
      return paramChar2 + paramChar1;
    case 7: 
      return paramChar2 + paramChar1 + paramChar1;
    case 8: 
      return paramChar2 + paramChar1 + paramChar1 + paramChar1;
    }
    return paramChar2 + paramChar1 + paramChar1 + paramChar1 + paramChar1;
  }
  
  public static final String format00(int paramInt)
  {
    if (paramInt < 0)
    {
      if (paramInt < 9) {
        return "-" + -paramInt;
      }
      return "-0" + -paramInt;
    }
    if (paramInt > 9) {
      return paramInt;
    }
    return "0" + paramInt;
  }
  
  public static String formatDist(long paramLong)
  {
    if (chars == null) {
      chars = new char[16];
    }
    long l = Math.abs(paramLong);
    chars[15] = 'm';
    int j = 1 + 1;
    int i = j;
    paramLong = l;
    if (l == 0L)
    {
      chars[14] = '-';
      i = j + 1;
    }
    for (;;)
    {
      return String.copyValueOf(chars, 16 - i + 1, i - 1);
      do
      {
        chars[(16 - i)] = ((char)(int)(paramLong % 10L + 48L));
        i += 1;
        paramLong /= 10L;
      } while (paramLong > 0L);
    }
  }
  
  public static String formatSpeed(float paramFloat)
  {
    if (chars == null) {
      chars = new char[16];
    }
    long l2 = Math.abs((int)paramFloat);
    chars[15] = 'h';
    chars[14] = '/';
    chars[13] = 'm';
    chars[12] = 'k';
    int j = 1 + 1 + 1 + 1 + 1;
    int i = j;
    long l1 = l2;
    if (l2 == 0L)
    {
      chars[11] = '-';
      i = j + 1;
    }
    for (;;)
    {
      return String.copyValueOf(chars, 16 - i + 1, i - 1);
      do
      {
        chars[(16 - i)] = ((char)(int)(l1 % 10L + 48L));
        i += 1;
        l1 /= 10L;
      } while (l1 > 0L);
    }
  }
  
  public static String formatTime(long paramLong)
  {
    if (chars == null) {
      chars = new char[16];
    }
    long l = Math.abs(paramLong / 10L);
    chars[15] = 's';
    int j = 1 + 1;
    int i = j;
    paramLong = l;
    if (l == 0L)
    {
      chars[14] = '-';
      i = j + 1;
    }
    for (;;)
    {
      return String.copyValueOf(chars, 16 - i + 1, i - 1);
      do
      {
        chars[(16 - i)] = ((char)(int)(paramLong % 10L + 48L));
        j = i + 1;
        i = j;
        if (j == 4)
        {
          chars[(16 - j)] = '.';
          i = j + 1;
        }
        paramLong /= 10L;
      } while (paramLong > 0L);
    }
  }
  
  public static String formatmmss(long paramLong)
  {
    if (chars == null) {
      chars = new char[16];
    }
    long l = paramLong;
    if (paramLong < 0L) {
      l = -paramLong;
    }
    int j = (int)(l / 1000L);
    int i = j % 60;
    int k = j / 60 % 60;
    if (i > 9)
    {
      chars[15] = ((char)(i % 10 + 48));
      chars[14] = ((char)(i / 10 % 10 + 48));
      i = 1 + 1 + 1;
      chars[13] = ':';
      i += 1;
      if (k != 0) {
        break label174;
      }
      chars[12] = '0';
      chars[11] = '0';
    }
    for (j = i + 1 + 1;; j = i + 1 + 1)
    {
      return String.copyValueOf(chars, 16 - j + 1, j - 1);
      chars[15] = ((char)(i + 48));
      chars[14] = '0';
      i = 1 + 1 + 1;
      break;
      label174:
      if (k >= 10) {
        break label210;
      }
      chars[12] = ((char)(k + 48));
      chars[11] = '0';
    }
    for (;;)
    {
      label210:
      j = i;
      if (k <= 0) {
        break;
      }
      chars[(16 - i)] = ((char)(k % 10 + 48));
      j = i + 1;
      i = j;
      if (j == 4)
      {
        chars[(16 - j)] = '.';
        i = j + 1;
      }
      k /= 10;
    }
  }
  
  public static int getBottomLine(String paramString, Paint paramPaint)
  {
    if (_bounds == null) {
      _bounds = new Rect();
    }
    paramPaint.getTextBounds(paramString, 0, paramString.length(), _bounds);
    return _bounds.top;
  }
  
  public static String getFormatTime(long paramLong)
  {
    int j = (int)(paramLong / 1000L);
    int i = j % 60;
    j /= 60;
    StringBuilder localStringBuilder;
    if (j < 10)
    {
      str = "0" + j;
      localStringBuilder = new StringBuilder(String.valueOf(str)).append(":");
      if (i >= 10) {
        break label114;
      }
    }
    label114:
    for (String str = "0" + i;; str = i)
    {
      return str;
      str = j;
      break;
    }
  }
  
  public static final String getNowDate()
  {
    return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
  }
  
  public static final String getNowDateTime()
  {
    return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
  }
  
  public static final String getNowTime()
  {
    return new SimpleDateFormat("HH:mm:ss").format(new Date());
  }
  
  public static int getTextHeight(String paramString, Paint paramPaint)
  {
    if (_bounds == null) {
      _bounds = new Rect();
    }
    paramPaint.getTextBounds(paramString, 0, paramString.length(), _bounds);
    return _bounds.bottom - _bounds.top;
  }
  
  public static int getTextWidth(String paramString, Paint paramPaint)
  {
    if (_bounds == null) {
      _bounds = new Rect();
    }
    paramPaint.getTextBounds(paramString, 0, paramString.length(), _bounds);
    return _bounds.right - _bounds.left;
  }
  
  public static String int2String000(int paramInt)
  {
    String str = String.valueOf(paramInt);
    return "000".substring(0, "000".length() - str.length()).concat(str);
  }
  
  public static final boolean isEqual(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2 == null;
    }
    return paramString1.equals(paramString2);
  }
  
  public static final boolean isNullOrEmpty(String paramString)
  {
    if (paramString == null) {}
    while (paramString.length() <= 0) {
      return true;
    }
    return false;
  }
  
  public static final String limit(String paramString, int paramInt)
  {
    return limit(paramString, paramInt, "...");
  }
  
  public static final String limit(String paramString1, int paramInt, String paramString2)
  {
    String str;
    if (paramString1 == null) {
      str = null;
    }
    do
    {
      return str;
      str = paramString1;
    } while (paramString1.length() <= paramInt);
    return paramString1.substring(0, paramInt).concat(paramString2);
  }
  
  private static final String soustractif(int paramInt, char paramChar1, char paramChar2, char paramChar3)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return paramChar1;
    case 2: 
      return paramChar1 + paramChar1;
    case 3: 
      return paramChar1 + paramChar1 + paramChar1;
    case 4: 
      return paramChar1 + paramChar2;
    case 5: 
      return paramChar2;
    case 6: 
      return paramChar2 + paramChar1;
    case 7: 
      return paramChar2 + paramChar1 + paramChar1;
    case 8: 
      return paramChar2 + paramChar1 + paramChar1 + paramChar1;
    }
    return paramChar1 + paramChar3;
  }
  
  public static final String toRoman(int paramInt, boolean paramBoolean)
  {
    if ((paramInt >= 1) && (paramInt <= 4999))
    {
      int i = paramInt % 10;
      int j = paramInt / 10 % 10;
      int k = paramInt / 100 % 10;
      paramInt = paramInt / 1000 % 1000;
      if (paramBoolean) {
        return additif(paramInt, 'M', '?') + additif(k, 'C', 'D') + additif(j, 'X', 'L') + additif(i, 'I', 'V');
      }
      return soustractif(paramInt, 'M', '?', '?') + soustractif(k, 'C', 'D', 'M') + soustractif(j, 'X', 'L', 'C') + soustractif(i, 'I', 'V', 'X');
    }
    return "";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/TextUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */