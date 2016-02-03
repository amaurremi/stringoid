package com.mobisystems.pdf;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilsSE
{
  private static final Pattern TIME_ZONE_PREFIX = Pattern.compile("[\\+\\-Z]");
  
  public static Date parsePdfDateString(String paramString)
  {
    if (paramString.startsWith("D:"))
    {
      Matcher localMatcher = TIME_ZONE_PREFIX.matcher(paramString);
      StringBuilder localStringBuilder;
      if (localMatcher.find())
      {
        localStringBuilder = new StringBuilder(paramString.substring(2, localMatcher.start()));
        paramString = new StringBuilder(paramString.substring(localMatcher.start()));
      }
      while (localStringBuilder.length() < "yyyyMMddHHmmss".length()) {
        if ((localStringBuilder.length() == 4) || (localStringBuilder.length() == 6))
        {
          localStringBuilder.append("01");
          continue;
          localStringBuilder = new StringBuilder(paramString.substring(2));
          paramString = null;
        }
        else
        {
          localStringBuilder.append("00");
        }
      }
      if (paramString != null) {}
      try
      {
        if (paramString.length() < 3) {
          return new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).parse(localStringBuilder.toString());
        }
        if (paramString.length() == 3) {
          paramString.append("00");
        }
        for (;;)
        {
          return new SimpleDateFormat("yyyyMMddHHmmssZ", Locale.US).parse(paramString);
          if (paramString.charAt(3) == '\'') {
            paramString.delete(3, 4);
          }
        }
        return null;
      }
      catch (ParseException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static String toPdfDateString(Date paramDate)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("'D:'yyyyMMddHHmmss'Z'", Locale.US);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    return localSimpleDateFormat.format(paramDate);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/UtilsSE.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */