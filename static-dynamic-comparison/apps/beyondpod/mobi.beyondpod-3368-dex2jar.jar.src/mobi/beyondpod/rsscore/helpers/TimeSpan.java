package mobi.beyondpod.rsscore.helpers;

import java.util.Calendar;
import java.util.Date;

public class TimeSpan
  implements Comparable<TimeSpan>
{
  private long duration;
  
  public TimeSpan(long paramLong)
  {
    long l = paramLong;
    if (paramLong < 0L) {
      l = paramLong * -1L;
    }
    this.duration = l;
  }
  
  public TimeSpan(long paramLong1, long paramLong2, long paramLong3)
  {
    this(0L, paramLong1, paramLong2, paramLong3, 0L);
  }
  
  public TimeSpan(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this(paramLong1, paramLong2, paramLong3, paramLong4, 0L);
  }
  
  public TimeSpan(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    this.duration = (1000L * paramLong1 * 60L * 60L * 24L);
    this.duration += 1000L * paramLong2 * 60L * 60L;
    this.duration += 1000L * paramLong3 * 60L;
    this.duration += 1000L * paramLong4;
    this.duration += paramLong5;
  }
  
  public static TimeSpan fromDays(double paramDouble)
  {
    return new TimeSpan(paramDouble * 86400000L);
  }
  
  public static TimeSpan fromHours(double paramDouble)
  {
    return new TimeSpan(paramDouble * 3600000L);
  }
  
  public static TimeSpan fromMinutes(double paramDouble)
  {
    return new TimeSpan(paramDouble * 60000L);
  }
  
  public static TimeSpan fromSeconds(double paramDouble)
  {
    return new TimeSpan(paramDouble * 1000L);
  }
  
  public Date AddTo(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    double d = getTotalDays();
    if (d > 365.0D) {}
    for (d /= 365.0D;; d = 0.0D)
    {
      localCalendar.add(1, (int)d);
      localCalendar.add(6, (int)getDays());
      localCalendar.add(10, (int)getHours());
      localCalendar.add(12, (int)getMinutes());
      localCalendar.add(13, (int)getSeconds());
      return localCalendar.getTime();
    }
  }
  
  public Date SubstractFrom(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    double d = getTotalDays();
    if (d > 365.0D) {}
    for (d /= 365.0D;; d = 0.0D)
    {
      localCalendar.add(1, (int)d * -1);
      localCalendar.add(6, (int)(getDays() * -1L));
      localCalendar.add(10, (int)(getHours() * -1L));
      localCalendar.add(12, (int)(getMinutes() * -1L));
      localCalendar.add(13, (int)(getSeconds() * -1L));
      return localCalendar.getTime();
    }
  }
  
  public TimeSpan add(TimeSpan paramTimeSpan)
  {
    return new TimeSpan(this.duration + paramTimeSpan.duration);
  }
  
  public int compareTo(TimeSpan paramTimeSpan)
  {
    return (int)(this.duration - paramTimeSpan.duration);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof TimeSpan)) {}
    while (((TimeSpan)paramObject).duration != this.duration) {
      return false;
    }
    return true;
  }
  
  public long getDays()
  {
    return this.duration / 86400000L;
  }
  
  public long getHours()
  {
    return this.duration / 3600000L % 24L;
  }
  
  public long getMilliseconds()
  {
    return this.duration % 1000L;
  }
  
  public long getMinutes()
  {
    return this.duration / 60000L % 60L;
  }
  
  public long getSeconds()
  {
    return this.duration / 1000L % 60L;
  }
  
  public double getTotalDays()
  {
    return (float)this.duration / 8.64E7F;
  }
  
  public double getTotalHours()
  {
    return (float)this.duration / 3600000.0F;
  }
  
  public long getTotalMilliseconds()
  {
    return this.duration;
  }
  
  public double getTotalMinutes()
  {
    return (float)this.duration / 60000.0F;
  }
  
  public double getTotalSeconds()
  {
    return (float)this.duration / 1000.0F;
  }
  
  public long getYears()
  {
    return this.duration / 86400000L;
  }
  
  public int hashCode()
  {
    return (int)(this.duration ^ this.duration >>> 32);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (getDays() > 0L)
    {
      localStringBuffer.append(getDays());
      localStringBuffer.append(".");
    }
    localStringBuffer.append(String.format("%02d:%02d:%02d", new Object[] { Long.valueOf(getHours()), Long.valueOf(getMinutes()), Long.valueOf(getSeconds()) }));
    if (getMilliseconds() > 0L) {
      localStringBuffer.append(String.format(".%03d", new Object[] { Long.valueOf(getMilliseconds()) }));
    }
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/helpers/TimeSpan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */