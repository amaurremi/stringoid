package com.flurry.android.monolithic.sdk.impl;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class aen
  extends DateFormat
{
  protected static final String[] a = { "yyyy-MM-dd'T'HH:mm:ss.SSSZ", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "EEE, dd MMM yyyy HH:mm:ss zzz", "yyyy-MM-dd" };
  protected static final DateFormat b;
  protected static final DateFormat c;
  protected static final DateFormat d;
  protected static final DateFormat e;
  public static final aen f = new aen();
  protected transient DateFormat g;
  protected transient DateFormat h;
  protected transient DateFormat i;
  protected transient DateFormat j;
  
  static
  {
    TimeZone localTimeZone = TimeZone.getTimeZone("GMT");
    b = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");
    b.setTimeZone(localTimeZone);
    c = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    c.setTimeZone(localTimeZone);
    d = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    d.setTimeZone(localTimeZone);
    e = new SimpleDateFormat("yyyy-MM-dd");
    e.setTimeZone(localTimeZone);
  }
  
  private static final boolean b(String paramString)
  {
    int k = paramString.length();
    if (k >= 6)
    {
      int m = paramString.charAt(k - 6);
      if ((m == 43) || (m == 45)) {}
      do
      {
        do
        {
          return true;
          m = paramString.charAt(k - 5);
        } while ((m == 43) || (m == 45));
        k = paramString.charAt(k - 3);
      } while ((k == 43) || (k == 45));
    }
    return false;
  }
  
  public aen a()
  {
    return new aen();
  }
  
  protected Date a(String paramString, ParsePosition paramParsePosition)
  {
    int k = paramString.length();
    char c1 = paramString.charAt(k - 1);
    Object localObject2;
    Object localObject1;
    String str;
    if ((k <= 10) && (Character.isDigit(c1)))
    {
      localObject2 = this.j;
      localObject1 = localObject2;
      str = paramString;
      if (localObject2 == null)
      {
        localObject1 = (DateFormat)e.clone();
        this.j = ((DateFormat)localObject1);
        str = paramString;
      }
    }
    for (;;)
    {
      return ((DateFormat)localObject1).parse(str, paramParsePosition);
      if (c1 == 'Z')
      {
        localObject1 = this.i;
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = (DateFormat)d.clone();
          this.i = ((DateFormat)localObject2);
        }
        localObject1 = localObject2;
        str = paramString;
        if (paramString.charAt(k - 4) == ':')
        {
          paramString = new StringBuilder(paramString);
          paramString.insert(k - 1, ".000");
          str = paramString.toString();
          localObject1 = localObject2;
        }
      }
      else
      {
        if (b(paramString))
        {
          int m = paramString.charAt(k - 3);
          if (m == 58)
          {
            paramString = new StringBuilder(paramString);
            paramString.delete(k - 3, k - 2);
            localObject1 = paramString.toString();
          }
          for (;;)
          {
            k = ((String)localObject1).length();
            paramString = (String)localObject1;
            if (Character.isDigit(((String)localObject1).charAt(k - 9)))
            {
              paramString = new StringBuilder((String)localObject1);
              paramString.insert(k - 5, ".000");
              paramString = paramString.toString();
            }
            localObject1 = this.h;
            str = paramString;
            if (this.h != null) {
              break;
            }
            localObject1 = (DateFormat)c.clone();
            this.h = ((DateFormat)localObject1);
            str = paramString;
            break;
            if (m != 43)
            {
              localObject1 = paramString;
              if (m != 45) {}
            }
            else
            {
              localObject1 = paramString + "00";
            }
          }
        }
        localObject1 = new StringBuilder(paramString);
        if (k - paramString.lastIndexOf('T') - 1 <= 8) {
          ((StringBuilder)localObject1).append(".000");
        }
        ((StringBuilder)localObject1).append('Z');
        paramString = ((StringBuilder)localObject1).toString();
        localObject2 = this.i;
        localObject1 = localObject2;
        str = paramString;
        if (localObject2 == null)
        {
          localObject1 = (DateFormat)d.clone();
          this.i = ((DateFormat)localObject1);
          str = paramString;
        }
      }
    }
  }
  
  protected boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString.length() >= 5)
    {
      bool1 = bool2;
      if (Character.isDigit(paramString.charAt(0)))
      {
        bool1 = bool2;
        if (Character.isDigit(paramString.charAt(3)))
        {
          bool1 = bool2;
          if (paramString.charAt(4) == '-') {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  protected Date b(String paramString, ParsePosition paramParsePosition)
  {
    if (this.g == null) {
      this.g = ((DateFormat)b.clone());
    }
    return this.g.parse(paramString, paramParsePosition);
  }
  
  public StringBuffer format(Date paramDate, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition)
  {
    if (this.h == null) {
      this.h = ((DateFormat)c.clone());
    }
    return this.h.format(paramDate, paramStringBuffer, paramFieldPosition);
  }
  
  public Date parse(String paramString)
    throws ParseException
  {
    paramString = paramString.trim();
    ParsePosition localParsePosition = new ParsePosition(0);
    Object localObject = parse(paramString, localParsePosition);
    if (localObject != null) {
      return (Date)localObject;
    }
    localObject = new StringBuilder();
    String[] arrayOfString = a;
    int m = arrayOfString.length;
    int k = 0;
    if (k < m)
    {
      String str = arrayOfString[k];
      if (((StringBuilder)localObject).length() > 0) {
        ((StringBuilder)localObject).append("\", \"");
      }
      for (;;)
      {
        ((StringBuilder)localObject).append(str);
        k += 1;
        break;
        ((StringBuilder)localObject).append('"');
      }
    }
    ((StringBuilder)localObject).append('"');
    throw new ParseException(String.format("Can not parse date \"%s\": not compatible with any of standard forms (%s)", new Object[] { paramString, ((StringBuilder)localObject).toString() }), localParsePosition.getErrorIndex());
  }
  
  public Date parse(String paramString, ParsePosition paramParsePosition)
  {
    if (a(paramString)) {
      return a(paramString, paramParsePosition);
    }
    int k = paramString.length();
    int m;
    int n;
    do
    {
      m = k - 1;
      if (m < 0) {
        break;
      }
      n = paramString.charAt(m);
      if (n < 48) {
        break;
      }
      k = m;
    } while (n <= 57);
    if ((m < 0) && (pt.a(paramString, false))) {
      return new Date(Long.parseLong(paramString));
    }
    return b(paramString, paramParsePosition);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/aen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */