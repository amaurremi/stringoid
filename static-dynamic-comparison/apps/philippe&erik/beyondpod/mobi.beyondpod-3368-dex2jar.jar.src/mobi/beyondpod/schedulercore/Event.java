package mobi.beyondpod.schedulercore;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import mobi.beyondpod.rsscore.helpers.DateTime;
import mobi.beyondpod.rsscore.helpers.TimeSpan;

public class Event
{
  private boolean _IsModified;
  private int _RecurrenceInterval = 0;
  private TimeSpan _RecurrencePeriod;
  private Date _StartTime;
  
  public Event(Date paramDate, int paramInt, TimeSpan paramTimeSpan)
  {
    setRecurrenceInterval(paramInt);
    setRecurrencePeriod(paramTimeSpan);
    SetUnadjustedStartTime(paramDate);
  }
  
  private Date NextStartTimeAfter(Date paramDate)
  {
    Date localDate = UnadjustedStartTimeFor(paramDate);
    if (localDate == null) {
      return localDate;
    }
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    localGregorianCalendar.setTime(localDate);
    int i = localGregorianCalendar.get(6);
    TimeSpan localTimeSpan = Recurrence();
    for (;;)
    {
      if ((localTimeSpan.getTotalSeconds() <= 0.0D) || (localDate.compareTo(paramDate) > 0)) {
        return localDate;
      }
      localDate = localTimeSpan.AddTo(localDate);
      localGregorianCalendar.setTime(localDate);
      if (localGregorianCalendar.get(6) != i)
      {
        localGregorianCalendar.set(11, this._StartTime.getHours());
        localGregorianCalendar.set(12, this._StartTime.getMinutes());
        localDate = localGregorianCalendar.getTime();
        i = localGregorianCalendar.get(6);
      }
    }
  }
  
  private Date UnadjustedStartTimeFor(Date paramDate)
  {
    if (this._StartTime == null) {
      return this._StartTime;
    }
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    localGregorianCalendar.setTime(paramDate);
    localGregorianCalendar.set(11, this._StartTime.getHours());
    localGregorianCalendar.set(12, this._StartTime.getMinutes());
    localGregorianCalendar.set(13, 0);
    localGregorianCalendar.set(14, 0);
    this._StartTime = localGregorianCalendar.getTime();
    return this._StartTime;
  }
  
  public boolean IsModified()
  {
    return this._IsModified;
  }
  
  public boolean OccursInTheFuture()
  {
    Date localDate = StartTime();
    if (localDate == null) {}
    while (localDate.compareTo(new Date()) <= 0) {
      return false;
    }
    return true;
  }
  
  public boolean OverlapsWith(Event paramEvent)
  {
    if (paramEvent == null) {}
    while (new TimeSpan(Math.abs(StartTime().getTime() - paramEvent.StartTime().getTime())).getTotalMinutes() >= 10.0D) {
      return false;
    }
    return true;
  }
  
  public TimeSpan Recurrence()
  {
    return new TimeSpan(getRecurrencePeriod().getTotalMilliseconds() * getRecurrenceInterval());
  }
  
  public void SetIsModified(boolean paramBoolean)
  {
    this._IsModified = paramBoolean;
  }
  
  public void SetUnadjustedStartTime(Date paramDate)
  {
    if (paramDate == null) {}
    GregorianCalendar localGregorianCalendar;
    for (this._StartTime = null;; this._StartTime = localGregorianCalendar.getTime())
    {
      this._IsModified = true;
      return;
      localGregorianCalendar = new GregorianCalendar();
      localGregorianCalendar.setTime(paramDate);
      localGregorianCalendar.set(13, 0);
      localGregorianCalendar.set(14, 0);
    }
  }
  
  public Date StartTime()
  {
    return NextStartTimeAfter(new Date());
  }
  
  public Date UnadjustedStartTime()
  {
    return UnadjustedStartTimeFor(new Date());
  }
  
  public int getRecurrenceInterval()
  {
    return this._RecurrenceInterval;
  }
  
  public TimeSpan getRecurrencePeriod()
  {
    return this._RecurrencePeriod;
  }
  
  public void setRecurrenceInterval(int paramInt)
  {
    this._RecurrenceInterval = paramInt;
    this._IsModified = true;
  }
  
  public void setRecurrencePeriod(TimeSpan paramTimeSpan)
  {
    this._RecurrencePeriod = paramTimeSpan;
    this._IsModified = true;
  }
  
  public String toString()
  {
    String str1;
    int i;
    if (StartTime() != null)
    {
      str1 = DateTime.ToShortString(StartTime());
      i = getRecurrenceInterval();
      if (getRecurrencePeriod().getTotalHours() >= 1.0D) {
        break label89;
      }
    }
    label89:
    for (String str2 = getRecurrencePeriod().getTotalMinutes() + " minutes";; str2 = getRecurrencePeriod().getTotalHours() + " hours")
    {
      return String.format("Start: %s and repeat every %d %s", new Object[] { str1, Integer.valueOf(i), str2 });
      str1 = "[Not Set]";
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/schedulercore/Event.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */