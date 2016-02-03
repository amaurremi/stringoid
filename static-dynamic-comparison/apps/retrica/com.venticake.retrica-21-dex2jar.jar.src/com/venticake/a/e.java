package com.venticake.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.venticake.retrica.MainActivity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e
{
  public long a = 0L;
  public long b = 0L;
  public int c = 0;
  public int d = 0;
  
  public e(int paramInt, JSONArray paramJSONArray)
  {
    for (;;)
    {
      if (i >= paramJSONArray.length()) {
        return;
      }
      try
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        int j = localJSONObject.getInt("id");
        if (paramInt == j) {
          break;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
      i += 1;
    }
    try
    {
      this.a = (localJSONException.getInt("ind") * 1000L);
    }
    catch (JSONException paramJSONArray)
    {
      try
      {
        this.b = (localJSONException.getInt("itv") * 1000L);
      }
      catch (JSONException paramJSONArray)
      {
        try
        {
          for (;;)
          {
            this.c = localJSONException.getInt("pad");
            try
            {
              this.d = localJSONException.getInt("ats");
              return;
            }
            catch (JSONException paramJSONArray)
            {
              paramJSONArray.printStackTrace();
              return;
            }
            paramJSONArray = paramJSONArray;
            paramJSONArray.printStackTrace();
            continue;
            paramJSONArray = paramJSONArray;
            paramJSONArray.printStackTrace();
          }
        }
        catch (JSONException paramJSONArray)
        {
          for (;;)
          {
            paramJSONArray.printStackTrace();
          }
        }
      }
    }
  }
  
  public static void a(int paramInt)
  {
    SharedPreferences.Editor localEditor = i().edit();
    localEditor.putInt("cfd", paramInt);
    localEditor.commit();
  }
  
  public static void a(Date paramDate)
  {
    SharedPreferences.Editor localEditor = i().edit();
    localEditor.putLong("ldt", paramDate.getTime());
    localEditor.commit();
  }
  
  public static boolean a(Date paramDate1, Date paramDate2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar1.setTime(paramDate1);
    localCalendar2.setTime(paramDate2);
    return (localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) == localCalendar2.get(6));
  }
  
  public static Date b()
  {
    long l = i().getLong("ldt", 0L);
    if (l > 0L) {
      return new Date(l);
    }
    return null;
  }
  
  public static void b(int paramInt)
  {
    SharedPreferences.Editor localEditor = i().edit();
    localEditor.putInt("cft", paramInt);
    localEditor.commit();
  }
  
  public static void b(Date paramDate)
  {
    SharedPreferences.Editor localEditor = i().edit();
    localEditor.putLong("ltd", paramDate.getTime());
    localEditor.commit();
  }
  
  public static int c()
  {
    return i().getInt("cfd", 0);
  }
  
  private String c(Date paramDate)
  {
    return new SimpleDateFormat("dd-MM-yyy HH:mm:ss z", Locale.getDefault()).format(paramDate);
  }
  
  public static void d()
  {
    a(c() + 1);
  }
  
  private void d(Date paramDate)
  {
    SharedPreferences.Editor localEditor = i().edit();
    localEditor.putLong("idt", paramDate.getTime());
    localEditor.commit();
  }
  
  public static Date e()
  {
    long l = i().getLong("ltd", 0L);
    if (l > 0L) {
      return new Date(l);
    }
    return null;
  }
  
  public static void f()
  {
    b(new Date());
  }
  
  public static int g()
  {
    Date localDate = e();
    if (localDate == null) {}
    while (!a(localDate, new Date())) {
      return 0;
    }
    return i().getInt("cft", 0);
  }
  
  public static void h()
  {
    f();
    b(g() + 1);
  }
  
  private static SharedPreferences i()
  {
    return ((MainActivity)MainActivity.a).getPreferences(0);
  }
  
  private Date j()
  {
    long l = i().getLong("idt", 0L);
    if (l > 0L) {
      return new Date(l);
    }
    Date localDate = new Date();
    d(localDate);
    return localDate;
  }
  
  public boolean a()
  {
    Date localDate2 = new Date();
    long l1 = localDate2.getTime();
    Date localDate1 = b();
    Log.d("spad", "isValid for : " + toString());
    StringBuilder localStringBuilder = new StringBuilder("lastDate: ");
    if (localDate1 == null) {}
    for (Object localObject = "null";; localObject = localDate1)
    {
      Log.d("spad", localObject);
      if ((localDate1 != null) && (a(localDate2, localDate1))) {
        break;
      }
      Log.d("spad", String.format("tries: %d (afterTries: %d)", new Object[] { Integer.valueOf(g()), Integer.valueOf(this.d) }));
      if ((this.d <= 0) || (this.d <= g())) {
        break label195;
      }
      return false;
    }
    Log.d("spad", String.format("already played - tries: %d (afterTries: %d) (%s)", new Object[] { Integer.valueOf(g()), Integer.valueOf(this.d), localDate1 }));
    label195:
    localObject = j();
    if (this.a > 0L)
    {
      long l2 = l1 - ((Date)localObject).getTime();
      if (this.a > l2)
      {
        Log.d("spad", String.format("fromInit: %d (initialDelay: %d) => INVALID", new Object[] { Long.valueOf(l2), Long.valueOf(this.a) }));
        return false;
      }
      Log.d("spad", String.format("fromInit: %d (initialDelay: %d)", new Object[] { Long.valueOf(l2), Long.valueOf(this.a) }));
    }
    if ((this.c > 0) && (localDate1 != null))
    {
      Log.d("spad", String.format("The day of lastDate: %s, that of now: %s", new Object[] { c(localDate1), c(localDate2) }));
      if (!a(localDate2, localDate1)) {
        break label495;
      }
      int i = c();
      if (i > this.c)
      {
        Log.d("spad", String.format("countForADay: %d (peraday: %d) => INVALID", new Object[] { Integer.valueOf(i), Integer.valueOf(this.c) }));
        return false;
      }
      Log.d("spad", String.format("countForADay: %d (peraday: %d)", new Object[] { Integer.valueOf(i), Integer.valueOf(this.c) }));
    }
    while ((this.b > 0L) && (localDate1 != null))
    {
      l1 -= localDate1.getTime();
      if (l1 < this.b)
      {
        Log.d("spad", String.format("fromLast: %d (interval: %d) => INVALID", new Object[] { Long.valueOf(l1), Long.valueOf(this.b) }));
        return false;
        label495:
        Log.d("spad", String.format("Last Date(%s) is NOT a today: %s", new Object[] { localDate1, localDate2 }));
      }
      else
      {
        Log.d("spad", String.format("fromLast: %d (interval: %d)", new Object[] { Long.valueOf(l1), Long.valueOf(this.b) }));
      }
    }
    return true;
  }
  
  public String toString()
  {
    return String.format("initialDelay: %d, interval: %d, perADay: %d, afterTries: %d", new Object[] { Long.valueOf(this.a), Long.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d) });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */