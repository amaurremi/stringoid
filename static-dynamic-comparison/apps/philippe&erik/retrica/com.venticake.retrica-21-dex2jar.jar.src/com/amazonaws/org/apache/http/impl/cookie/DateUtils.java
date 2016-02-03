package com.amazonaws.org.apache.http.impl.cookie;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.apache.http.annotation.Immutable;

@Immutable
public final class DateUtils
{
  private static final String[] DEFAULT_PATTERNS = { "EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy" };
  private static final Date DEFAULT_TWO_DIGIT_YEAR_START;
  public static final TimeZone GMT = TimeZone.getTimeZone("GMT");
  
  static
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeZone(GMT);
    localCalendar.set(2000, 0, 1, 0, 0, 0);
    localCalendar.set(14, 0);
    DEFAULT_TWO_DIGIT_YEAR_START = localCalendar.getTime();
  }
  
  public static Date parseDate(String paramString, String[] paramArrayOfString)
  {
    return parseDate(paramString, paramArrayOfString, null);
  }
  
  public static Date parseDate(String paramString, String[] paramArrayOfString, Date paramDate)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("dateValue is null");
    }
    String[] arrayOfString = paramArrayOfString;
    if (paramArrayOfString == null) {
      arrayOfString = DEFAULT_PATTERNS;
    }
    paramArrayOfString = paramDate;
    if (paramDate == null) {
      paramArrayOfString = DEFAULT_TWO_DIGIT_YEAR_START;
    }
    paramDate = paramString;
    if (paramString.length() > 1)
    {
      paramDate = paramString;
      if (paramString.startsWith("'"))
      {
        paramDate = paramString;
        if (paramString.endsWith("'")) {
          paramDate = paramString.substring(1, paramString.length() - 1);
        }
      }
    }
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = DateUtils.DateFormatHolder.formatFor(arrayOfString[i]);
      ((SimpleDateFormat)localObject).set2DigitYearStart(paramArrayOfString);
      paramString = new ParsePosition(0);
      localObject = ((SimpleDateFormat)localObject).parse(paramDate, paramString);
      if (paramString.getIndex() != 0) {
        return (Date)localObject;
      }
      i += 1;
    }
    throw new DateParseException("Unable to parse the date " + paramDate);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/cookie/DateUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */