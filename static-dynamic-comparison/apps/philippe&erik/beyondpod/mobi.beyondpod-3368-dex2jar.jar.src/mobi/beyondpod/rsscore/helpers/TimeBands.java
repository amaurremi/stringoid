package mobi.beyondpod.rsscore.helpers;

import java.util.Calendar;

public class TimeBands
{
  public static final int DATE_BAND_LAST_MONTH = 5;
  public static final int DATE_BAND_LAST_WEEK = 4;
  public static final int DATE_BAND_OLDER = 6;
  public static final int DATE_BAND_THIS_MONTH = 2;
  public static final int DATE_BAND_THIS_WEEK = 1;
  public static final int DATE_BAND_THIS_YEAR = 3;
  public static final int DATE_BAND_TODAY = 0;
  Calendar LastMonthStart;
  Calendar LastWeekStart;
  Calendar ThisMonthStart;
  Calendar ThisWeekStart;
  Calendar ThisYearStart;
  Calendar TodayStart;
  
  public TimeBands()
  {
    this(Calendar.getInstance());
  }
  
  public TimeBands(Calendar paramCalendar)
  {
    int i = paramCalendar.get(1);
    int j = paramCalendar.get(2);
    int k = paramCalendar.get(5);
    this.TodayStart = Calendar.getInstance();
    this.TodayStart.set(i, j, k, 0, 0, 0);
    this.ThisWeekStart = Calendar.getInstance();
    this.ThisWeekStart.set(i, j, k, 0, 0, 0);
    this.ThisWeekStart.set(7, this.ThisWeekStart.getFirstDayOfWeek());
    this.LastWeekStart = Calendar.getInstance();
    this.LastWeekStart.set(this.ThisWeekStart.get(1), this.ThisWeekStart.get(2), this.ThisWeekStart.get(5), 0, 0, 0);
    this.LastWeekStart.add(3, -1);
    this.ThisMonthStart = Calendar.getInstance();
    this.ThisMonthStart.set(i, j, 1, 0, 0, 0);
    this.LastMonthStart = Calendar.getInstance();
    this.LastMonthStart.set(i, j, 1, 0, 0, 0);
    this.LastMonthStart.add(2, -1);
    this.ThisYearStart = Calendar.getInstance();
    this.ThisYearStart.set(i, 0, 1, 0, 0, 0);
  }
  
  public int GetDateBand(Calendar paramCalendar)
  {
    long l = paramCalendar.getTimeInMillis();
    if (l >= this.TodayStart.getTimeInMillis()) {
      return 0;
    }
    if (l >= this.ThisWeekStart.getTimeInMillis()) {
      return 1;
    }
    if (l >= this.LastWeekStart.getTimeInMillis()) {
      return 4;
    }
    if (l >= this.ThisMonthStart.getTimeInMillis()) {
      return 2;
    }
    if (l >= this.LastMonthStart.getTimeInMillis()) {
      return 5;
    }
    if (l >= this.ThisYearStart.getTimeInMillis()) {
      return 3;
    }
    return 6;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/helpers/TimeBands.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */