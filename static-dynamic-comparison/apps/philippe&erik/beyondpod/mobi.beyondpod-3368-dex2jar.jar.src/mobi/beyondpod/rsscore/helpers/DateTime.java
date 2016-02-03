package mobi.beyondpod.rsscore.helpers;

import android.content.Context;
import android.text.format.DateUtils;
import android.text.format.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.R.string;

public class DateTime
{
  public static SimpleDateFormat HOURMINAMPMFORMAT;
  public static SimpleDateFormat HOURMINSECFORMAT;
  public static SimpleDateFormat MONTHDAYFORMAT;
  public static final Date MaxValue;
  public static SimpleDateFormat RFC822DATEFORMAT;
  public static SimpleDateFormat RFC822DATEFORMATUTC;
  private static final String TODAY = CoreHelper.LoadResourceString(R.string.date_time_today);
  static TimeZone TZ_GMT = TimeZone.getTimeZone("GMT");
  public static final SimpleDateFormat[] rfc822DateFormats = { new SimpleDateFormat("EEE, d MMM yy kk:mm:ss z", Locale.US), new SimpleDateFormat("EEE, d MMM yyyy kk:mm:ss z", Locale.US), new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss'Z'"), new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ssz"), new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss"), new SimpleDateFormat("EEE MMM  d kk:mm:ss zzz yyyy", Locale.US), new SimpleDateFormat("EEE, dd MMMM yyyy kk:mm:ss", Locale.US), new SimpleDateFormat("d MMM yy kk:mm:ss z", Locale.US), new SimpleDateFormat("yyyy-MM-dd kk:mm:ss.0"), new SimpleDateFormat("-yy-MM"), new SimpleDateFormat("-yyMM"), new SimpleDateFormat("yy-MM-dd"), new SimpleDateFormat("yyyy-MM-dd"), new SimpleDateFormat("yyyy-MM"), new SimpleDateFormat("yyyy-D"), new SimpleDateFormat("-yyMM"), new SimpleDateFormat("yyyyMMdd"), new SimpleDateFormat("yyMMdd"), new SimpleDateFormat("yyyy"), new SimpleDateFormat("yyD") };
  Date _date;
  
  static
  {
    MaxValue = new Date();
    RFC822DATEFORMATUTC = new SimpleDateFormat("EEE', 'dd' 'MMM' 'yyyy' 'HH:mm:ss' 'z", Locale.US);
    MONTHDAYFORMAT = new SimpleDateFormat("MMM d");
    RFC822DATEFORMAT = new SimpleDateFormat("EEE', 'dd' 'MMM' 'yyyy' 'HH:mm:ss' 'z", Locale.US);
    HOURMINAMPMFORMAT = new SimpleDateFormat("H:mm");
    HOURMINSECFORMAT = new SimpleDateFormat("HH:mm:ss");
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(TZ_GMT);
    localGregorianCalendar.set(2050, 1, 1, 0, 0, 0);
    MaxValue.setTime(localGregorianCalendar.getTime().getTime());
    RFC822DATEFORMATUTC.setCalendar(localGregorianCalendar);
    rfc822DateFormats[2].setTimeZone(TZ_GMT);
    int i = rfc822DateFormats.length - 12;
    for (;;)
    {
      if (i == rfc822DateFormats.length) {
        return;
      }
      rfc822DateFormats[i].setTimeZone(TZ_GMT);
      i += 1;
    }
  }
  
  public static String Format24HourTime(Date paramDate)
  {
    return DateUtils.formatDateTime(BeyondPodApplication.GetInstance().getApplicationContext(), paramDate.getTime(), 129);
  }
  
  public static String FormatDate(Date paramDate)
  {
    if (paramDate == null) {
      return "";
    }
    if (DateUtils.isToday(paramDate.getTime())) {
      return TODAY;
    }
    return DateUtils.formatDateTime(BeyondPodApplication.GetInstance().getApplicationContext(), paramDate.getTime(), 65544);
  }
  
  public static String FormatDateTime(Date paramDate)
  {
    if (paramDate == null) {
      return "";
    }
    Context localContext = BeyondPodApplication.GetInstance().getApplicationContext();
    Time localTime1 = new Time();
    localTime1.set(paramDate.getTime());
    Time localTime2 = new Time();
    localTime2.setToNow();
    int i;
    if (localTime1.year != localTime2.year) {
      i = 0x80A00 | 0x14;
    }
    for (;;)
    {
      return DateUtils.formatDateTime(localContext, paramDate.getTime(), i);
      if (localTime1.yearDay != localTime2.yearDay) {
        i = 0x80A00 | 0x10;
      } else {
        i = 0x80A00 | 0x1;
      }
    }
  }
  
  public static String FormatDateTimeToday(Date paramDate)
  {
    if (DateUtils.isToday(paramDate.getTime())) {
      return TODAY;
    }
    return FormatDateTime(paramDate);
  }
  
  public static String FormatTime(Date paramDate)
  {
    Context localContext = BeyondPodApplication.GetInstance().getApplicationContext();
    int i = 1;
    if (android.text.format.DateFormat.is24HourFormat(localContext)) {
      i = 0x1 | 0x80;
    }
    return DateUtils.formatDateTime(localContext, paramDate.getTime(), i);
  }
  
  public static void PrimeTimeZones()
  {
    try
    {
      RFC822DATEFORMATUTC.parse("Wed, 28 Jan 2009 11:03:42 -0500");
      return;
    }
    catch (ParseException localParseException) {}
  }
  
  public static String ToLongString(Date paramDate)
  {
    return Long.toString(paramDate.getTime());
  }
  
  public static String ToRFC822String(Date paramDate)
  {
    return RFC822DATEFORMAT.format(paramDate);
  }
  
  public static String ToRFC822UTCString(Date paramDate)
  {
    return RFC822DATEFORMATUTC.format(paramDate);
  }
  
  public static String ToShortString(Date paramDate)
  {
    return SimpleDateFormat.getDateTimeInstance(3, 2).format(paramDate);
  }
  
  public static SimpleDateFormat TryFindFormatOfRFC822Time(String paramString)
  {
    Object localObject;
    if (StringUtils.IsNullOrEmpty(paramString))
    {
      localObject = null;
      return (SimpleDateFormat)localObject;
    }
    SimpleDateFormat[] arrayOfSimpleDateFormat = rfc822DateFormats;
    int j = arrayOfSimpleDateFormat.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return null;
      }
      SimpleDateFormat localSimpleDateFormat = arrayOfSimpleDateFormat[i];
      localObject = localSimpleDateFormat;
      if (TryParseDateTimeWithFormat(paramString, localSimpleDateFormat) != null) {
        break;
      }
      i += 1;
    }
  }
  
  public static Date TryParseDateTime(String paramString)
  {
    if (StringUtils.IsNullOrEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        long l = StringUtils.TryParseLongFromString(paramString, Long.valueOf(0L)).longValue();
        if (l != 0L)
        {
          Date localDate = new Date(l);
          return localDate;
        }
      }
      catch (NumberFormatException localNumberFormatException) {}
    }
    return TryParseRFC822Time(paramString, null);
  }
  
  public static Date TryParseDateTimeWithFormat(String paramString, SimpleDateFormat paramSimpleDateFormat)
  {
    try
    {
      paramString = paramSimpleDateFormat.parse(paramString);
      return paramString;
    }
    catch (ParseException paramString) {}
    return null;
  }
  
  public static Date TryParseRFC822Time(String paramString, SimpleDateFormat paramSimpleDateFormat)
  {
    if (StringUtils.IsNullOrEmpty(paramString)) {
      paramSimpleDateFormat = null;
    }
    Date localDate;
    do
    {
      return paramSimpleDateFormat;
      localDate = null;
      if (paramSimpleDateFormat != null) {
        localDate = TryParseDateTimeWithFormat(paramString, paramSimpleDateFormat);
      }
      paramSimpleDateFormat = localDate;
    } while (localDate != null);
    SimpleDateFormat[] arrayOfSimpleDateFormat = rfc822DateFormats;
    int j = arrayOfSimpleDateFormat.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return null;
      }
      localDate = TryParseDateTimeWithFormat(paramString, arrayOfSimpleDateFormat[i]);
      paramSimpleDateFormat = localDate;
      if (localDate != null) {
        break;
      }
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/helpers/DateTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */