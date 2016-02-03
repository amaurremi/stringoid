package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.core.io.NumberInput;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class StdDateFormat
  extends DateFormat
{
  protected static final String[] ALL_FORMATS = { "yyyy-MM-dd'T'HH:mm:ss.SSSZ", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "EEE, dd MMM yyyy HH:mm:ss zzz", "yyyy-MM-dd" };
  protected static final DateFormat DATE_FORMAT_ISO8601;
  protected static final DateFormat DATE_FORMAT_ISO8601_Z;
  protected static final DateFormat DATE_FORMAT_PLAIN;
  protected static final DateFormat DATE_FORMAT_RFC1123;
  private static final TimeZone DEFAULT_TIMEZONE = TimeZone.getTimeZone("GMT");
  public static final StdDateFormat instance = new StdDateFormat();
  protected transient DateFormat _formatISO8601;
  protected transient DateFormat _formatISO8601_z;
  protected transient DateFormat _formatPlain;
  protected transient DateFormat _formatRFC1123;
  protected transient TimeZone _timezone;
  
  static
  {
    DATE_FORMAT_RFC1123 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
    DATE_FORMAT_RFC1123.setTimeZone(DEFAULT_TIMEZONE);
    DATE_FORMAT_ISO8601 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    DATE_FORMAT_ISO8601.setTimeZone(DEFAULT_TIMEZONE);
    DATE_FORMAT_ISO8601_Z = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    DATE_FORMAT_ISO8601_Z.setTimeZone(DEFAULT_TIMEZONE);
    DATE_FORMAT_PLAIN = new SimpleDateFormat("yyyy-MM-dd");
    DATE_FORMAT_PLAIN.setTimeZone(DEFAULT_TIMEZONE);
  }
  
  public StdDateFormat() {}
  
  public StdDateFormat(TimeZone paramTimeZone)
  {
    this._timezone = paramTimeZone;
  }
  
  private final DateFormat _cloneFormat(DateFormat paramDateFormat)
  {
    return _cloneFormat(paramDateFormat, this._timezone);
  }
  
  private static final DateFormat _cloneFormat(DateFormat paramDateFormat, TimeZone paramTimeZone)
  {
    paramDateFormat = (DateFormat)paramDateFormat.clone();
    if (paramTimeZone != null) {
      paramDateFormat.setTimeZone(paramTimeZone);
    }
    return paramDateFormat;
  }
  
  public static DateFormat getISO8601Format(TimeZone paramTimeZone)
  {
    return _cloneFormat(DATE_FORMAT_ISO8601, paramTimeZone);
  }
  
  private static final boolean hasTimeZone(String paramString)
  {
    int i = paramString.length();
    if (i >= 6)
    {
      int j = paramString.charAt(i - 6);
      if ((j == 43) || (j == 45)) {}
      do
      {
        do
        {
          return true;
          j = paramString.charAt(i - 5);
        } while ((j == 43) || (j == 45));
        i = paramString.charAt(i - 3);
      } while ((i == 43) || (i == 45));
    }
    return false;
  }
  
  public StdDateFormat clone()
  {
    return new StdDateFormat();
  }
  
  public StringBuffer format(Date paramDate, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition)
  {
    if (this._formatISO8601 == null) {
      this._formatISO8601 = _cloneFormat(DATE_FORMAT_ISO8601);
    }
    return this._formatISO8601.format(paramDate, paramStringBuffer, paramFieldPosition);
  }
  
  protected boolean looksLikeISO8601(String paramString)
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
  
  public Date parse(String paramString)
  {
    paramString = paramString.trim();
    ParsePosition localParsePosition = new ParsePosition(0);
    Object localObject = parse(paramString, localParsePosition);
    if (localObject != null) {
      return (Date)localObject;
    }
    localObject = new StringBuilder();
    String[] arrayOfString = ALL_FORMATS;
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      String str = arrayOfString[i];
      if (((StringBuilder)localObject).length() > 0) {
        ((StringBuilder)localObject).append("\", \"");
      }
      for (;;)
      {
        ((StringBuilder)localObject).append(str);
        i += 1;
        break;
        ((StringBuilder)localObject).append('"');
      }
    }
    ((StringBuilder)localObject).append('"');
    throw new ParseException(String.format("Can not parse date \"%s\": not compatible with any of standard forms (%s)", new Object[] { paramString, ((StringBuilder)localObject).toString() }), localParsePosition.getErrorIndex());
  }
  
  public Date parse(String paramString, ParsePosition paramParsePosition)
  {
    if (looksLikeISO8601(paramString)) {
      return parseAsISO8601(paramString, paramParsePosition);
    }
    int i = paramString.length();
    int j;
    int k;
    do
    {
      j = i - 1;
      if (j < 0) {
        break;
      }
      k = paramString.charAt(j);
      if (k < 48) {
        break;
      }
      i = j;
    } while (k <= 57);
    if ((j < 0) && (NumberInput.inLongRange(paramString, false))) {
      return new Date(Long.parseLong(paramString));
    }
    return parseAsRFC1123(paramString, paramParsePosition);
  }
  
  protected Date parseAsISO8601(String paramString, ParsePosition paramParsePosition)
  {
    int i = paramString.length();
    char c = paramString.charAt(i - 1);
    Object localObject2;
    Object localObject1;
    String str;
    if ((i <= 10) && (Character.isDigit(c)))
    {
      localObject2 = this._formatPlain;
      localObject1 = localObject2;
      str = paramString;
      if (localObject2 == null)
      {
        localObject1 = _cloneFormat(DATE_FORMAT_PLAIN);
        this._formatPlain = ((DateFormat)localObject1);
        str = paramString;
      }
    }
    for (;;)
    {
      return ((DateFormat)localObject1).parse(str, paramParsePosition);
      if (c == 'Z')
      {
        localObject1 = this._formatISO8601_z;
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = _cloneFormat(DATE_FORMAT_ISO8601_Z);
          this._formatISO8601_z = ((DateFormat)localObject2);
        }
        localObject1 = localObject2;
        str = paramString;
        if (paramString.charAt(i - 4) == ':')
        {
          paramString = new StringBuilder(paramString);
          paramString.insert(i - 1, ".000");
          str = paramString.toString();
          localObject1 = localObject2;
        }
      }
      else
      {
        if (hasTimeZone(paramString))
        {
          int j = paramString.charAt(i - 3);
          if (j == 58)
          {
            paramString = new StringBuilder(paramString);
            paramString.delete(i - 3, i - 2);
            localObject1 = paramString.toString();
          }
          for (;;)
          {
            i = ((String)localObject1).length();
            paramString = (String)localObject1;
            if (Character.isDigit(((String)localObject1).charAt(i - 9)))
            {
              paramString = new StringBuilder((String)localObject1);
              paramString.insert(i - 5, ".000");
              paramString = paramString.toString();
            }
            localObject1 = this._formatISO8601;
            str = paramString;
            if (this._formatISO8601 != null) {
              break;
            }
            localObject1 = _cloneFormat(DATE_FORMAT_ISO8601);
            this._formatISO8601 = ((DateFormat)localObject1);
            str = paramString;
            break;
            if (j != 43)
            {
              localObject1 = paramString;
              if (j != 45) {}
            }
            else
            {
              localObject1 = paramString + "00";
            }
          }
        }
        localObject1 = new StringBuilder(paramString);
        if (i - paramString.lastIndexOf('T') - 1 <= 8) {
          ((StringBuilder)localObject1).append(".000");
        }
        ((StringBuilder)localObject1).append('Z');
        paramString = ((StringBuilder)localObject1).toString();
        localObject2 = this._formatISO8601_z;
        localObject1 = localObject2;
        str = paramString;
        if (localObject2 == null)
        {
          localObject1 = _cloneFormat(DATE_FORMAT_ISO8601_Z);
          this._formatISO8601_z = ((DateFormat)localObject1);
          str = paramString;
        }
      }
    }
  }
  
  protected Date parseAsRFC1123(String paramString, ParsePosition paramParsePosition)
  {
    if (this._formatRFC1123 == null) {
      this._formatRFC1123 = _cloneFormat(DATE_FORMAT_RFC1123);
    }
    return this._formatRFC1123.parse(paramString, paramParsePosition);
  }
  
  public void setTimeZone(TimeZone paramTimeZone)
  {
    if (paramTimeZone != this._timezone)
    {
      this._formatRFC1123 = null;
      this._formatISO8601 = null;
      this._formatISO8601_z = null;
      this._formatPlain = null;
      this._timezone = paramTimeZone;
    }
  }
  
  public StdDateFormat withTimeZone(TimeZone paramTimeZone)
  {
    TimeZone localTimeZone = paramTimeZone;
    if (paramTimeZone == null) {
      localTimeZone = DEFAULT_TIMEZONE;
    }
    return new StdDateFormat(localTimeZone);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/util/StdDateFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */