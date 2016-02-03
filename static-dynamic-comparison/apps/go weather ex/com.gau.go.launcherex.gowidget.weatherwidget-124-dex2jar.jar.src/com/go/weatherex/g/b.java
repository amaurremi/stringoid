package com.go.weatherex.g;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.SQLException;
import com.gau.go.gostaticsdk.d;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidget21Provider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidget41Provider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidget42Provider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidgetDays41Provider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidgetDays42Provider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidgetWorldClock42Provider;
import com.gtp.a.a.b.c;

public class b
{
  private Context a;
  
  public b(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[上传信息：");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    paramString = localStringBuilder.toString();
    c.a("BehaviorStaticStatisticsHandler", paramString);
    com.gtp.a.a.a.a.a().a(paramString, "behavior_static_statistics.txt");
  }
  
  private String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    a locala = new a(this.a);
    int i14 = 0;
    int i1 = 0;
    int i15 = 0;
    int i8 = 0;
    int i16 = 0;
    int n = 0;
    int i17 = 0;
    int i9 = 0;
    int i18 = 0;
    int m = 0;
    int i19 = 0;
    int i10 = 0;
    int i20 = 0;
    int k = 0;
    int i21 = 0;
    int i11 = 0;
    int i22 = 0;
    int j = 0;
    int i23 = 0;
    int i12 = 0;
    int i24 = 0;
    int i = 0;
    int i25 = 0;
    int i13 = 0;
    Object localObject1 = this.a.getContentResolver().query(WeatherContentProvider.l, new String[] { "go_widget_type" }, null, null, "go_widget_id");
    int i2;
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    if (localObject1 != null)
    {
      i2 = i24;
      i3 = i22;
      i4 = i20;
      i5 = i18;
      i6 = i16;
      i7 = i14;
      i1 = i25;
      n = i23;
      m = i21;
      k = i19;
      j = i17;
      i = i15;
    }
    for (;;)
    {
      try
      {
        int i26;
        if (((Cursor)localObject1).getCount() > 0)
        {
          i1 = i25;
          n = i23;
          m = i21;
          k = i19;
          j = i17;
          i = i15;
          i26 = ((Cursor)localObject1).getColumnIndex("go_widget_type");
          i2 = i24;
          i3 = i22;
          i4 = i20;
          i5 = i18;
          i6 = i16;
          i7 = i14;
          if (i26 != -1)
          {
            i2 = i24;
            i3 = i22;
            i4 = i20;
            i5 = i18;
            i6 = i16;
            i7 = i14;
            i1 = i25;
            n = i23;
            m = i21;
            k = i19;
            j = i17;
            i = i15;
            if (((Cursor)localObject1).moveToFirst())
            {
              i1 = i13;
              n = i12;
              m = i11;
              k = i10;
              j = i9;
              i = i8;
            }
          }
        }
        switch (((Cursor)localObject1).getInt(i26))
        {
        case 0: 
          i1 = i2;
          n = i3;
          m = i4;
          k = i5;
          j = i6;
          i = i7;
          boolean bool = ((Cursor)localObject1).moveToNext();
          i13 = i2;
          i12 = i3;
          i11 = i4;
          i10 = i5;
          i9 = i6;
          i8 = i7;
          if (bool) {
            continue;
          }
          ((Cursor)localObject1).close();
          i = i2;
          j = i3;
          k = i4;
          m = i5;
          n = i6;
          i1 = i7;
        }
      }
      catch (SQLException localSQLException1)
      {
        if (!c.a()) {
          continue;
        }
        localSQLException1.printStackTrace();
        ((Cursor)localObject1).close();
        i2 = k;
        i3 = j;
        i4 = i;
        i = i1;
        j = n;
        k = m;
        m = i2;
        n = i3;
        i1 = i4;
        continue;
      }
      finally
      {
        ((Cursor)localObject1).close();
      }
      localObject1 = this.a.getContentResolver().query(WeatherContentProvider.a, new String[] { "cityId" }, null, null, "cityId");
      if (localObject1 != null)
      {
        try
        {
          i2 = ((Cursor)localObject1).getCount();
        }
        catch (SQLException localSQLException2)
        {
          if (!c.a()) {
            break label1393;
          }
          localSQLException2.printStackTrace();
          label1393:
          ((Cursor)localObject1).close();
          i2 = 0;
          continue;
        }
        finally
        {
          ((Cursor)localObject1).close();
        }
        locala.b("4*2_gw");
        if (i1 != 0)
        {
          localObject1 = "1";
          locala.c((String)localObject1);
          localStringBuilder.append(locala.b());
          localStringBuilder.append("\r\n");
          locala.a();
          locala.b("4*1_gw");
          if (n != 0)
          {
            localObject1 = "1";
            locala.c((String)localObject1);
            localStringBuilder.append(locala.b());
            localStringBuilder.append("\r\n");
            locala.a();
            locala.b("4*1gwf");
            if (j == 0) {
              break label1432;
            }
            localObject1 = "1";
            locala.c((String)localObject1);
            localStringBuilder.append(locala.b());
            localStringBuilder.append("\r\n");
            locala.a();
            locala.b("4*1gwn");
            if (i == 0) {
              break label1439;
            }
            localObject1 = "1";
            locala.c((String)localObject1);
            localStringBuilder.append(locala.b());
            localStringBuilder.append("\r\n");
            locala.a();
            locala.b("2*1_gw");
            if (m == 0) {
              break label1446;
            }
            localObject1 = "1";
            locala.c((String)localObject1);
            localStringBuilder.append(locala.b());
            localStringBuilder.append("\r\n");
            locala.a();
            locala.b("1*1_gw");
            if (k == 0) {
              break label1453;
            }
            localObject1 = "1";
            locala.c((String)localObject1);
            localStringBuilder.append(locala.b());
            localStringBuilder.append("\r\n");
            locala.a();
            locala.b("4*2_aw");
            if (!com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(this.a, AppWidget42Provider.class)) {
              break label1460;
            }
            localObject1 = "1";
            locala.c((String)localObject1);
            localStringBuilder.append(locala.b());
            localStringBuilder.append("\r\n");
            locala.a();
            locala.b("4*2_awf");
            if (!com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(this.a, AppWidgetDays42Provider.class)) {
              break label1467;
            }
            localObject1 = "1";
            locala.c((String)localObject1);
            localStringBuilder.append(locala.b());
            localStringBuilder.append("\r\n");
            locala.a();
            locala.b("4*1_aw");
            if (!com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(this.a, AppWidget41Provider.class)) {
              break label1474;
            }
            localObject1 = "1";
            locala.c((String)localObject1);
            localStringBuilder.append(locala.b());
            localStringBuilder.append("\r\n");
            locala.a();
            locala.b("4*1_awf");
            if (!com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(this.a, AppWidgetDays41Provider.class)) {
              break label1481;
            }
            localObject1 = "1";
            locala.c((String)localObject1);
            localStringBuilder.append(locala.b());
            localStringBuilder.append("\r\n");
            locala.a();
            locala.b("2*1_aw");
            if (!com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(this.a, AppWidget21Provider.class)) {
              break label1488;
            }
            localObject1 = "1";
            locala.c((String)localObject1);
            localStringBuilder.append(locala.b());
            localStringBuilder.append("\r\n");
            locala.a();
            locala.b("wlw");
            if (!com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(this.a, AppWidgetWorldClock42Provider.class)) {
              break label1495;
            }
            localObject1 = "1";
            locala.c((String)localObject1);
            localStringBuilder.append(locala.b());
            localStringBuilder.append("\r\n");
            localObject1 = "1_city";
            if (i2 >= 7) {
              localObject1 = "7-9_city";
            }
            if (i2 < 4) {
              break label1502;
            }
            localObject1 = "4-6_city";
            locala.a();
            locala.b((String)localObject1);
            locala.c("1");
            localStringBuilder.append(locala.b());
            return localStringBuilder.toString();
            i7 = 1;
            i2 = i13;
            i3 = i12;
            i4 = i11;
            i5 = i10;
            i6 = i9;
            continue;
            i6 = 1;
            i2 = i13;
            i3 = i12;
            i4 = i11;
            i5 = i10;
            i7 = i8;
            continue;
            i3 = 1;
            i2 = i13;
            i4 = i11;
            i5 = i10;
            i6 = i9;
            i7 = i8;
            continue;
            i2 = 1;
            i3 = i12;
            i4 = i11;
            i5 = i10;
            i6 = i9;
            i7 = i8;
            continue;
            i5 = 1;
            i2 = i13;
            i3 = i12;
            i4 = i11;
            i6 = i9;
            i7 = i8;
            continue;
            i4 = 1;
            i2 = i13;
            i3 = i12;
            i5 = i10;
            i6 = i9;
            i7 = i8;
          }
        }
        else
        {
          localObject1 = "0";
          continue;
        }
        localObject1 = "0";
        continue;
        label1432:
        localObject1 = "0";
        continue;
        label1439:
        localObject1 = "0";
        continue;
        label1446:
        localObject1 = "0";
        continue;
        label1453:
        localObject1 = "0";
        continue;
        label1460:
        localObject1 = "0";
        continue;
        label1467:
        localObject1 = "0";
        continue;
        label1474:
        localObject1 = "0";
        continue;
        label1481:
        localObject1 = "0";
        continue;
        label1488:
        localObject1 = "0";
        continue;
        label1495:
        localObject1 = "0";
        continue;
        label1502:
        if (i2 == 3) {
          localObject1 = "3_city";
        } else if (i2 == 2) {
          localObject1 = "2_city";
        } else if (i2 == 1) {
          localObject1 = "1_city";
        } else {}
      }
      else
      {
        i2 = 0;
        continue;
        i2 = i13;
        i3 = i12;
        i4 = i11;
        i5 = i10;
        i6 = i9;
        i7 = i8;
      }
    }
  }
  
  private void c()
  {
    String str = b();
    d.a(this.a).a(str);
    a(str);
    e();
  }
  
  private long d()
  {
    return GoWidgetApplication.c(this.a).a().getLong("key_behavior_static_statistics_upload_time", 0L);
  }
  
  private void e()
  {
    SharedPreferences.Editor localEditor = GoWidgetApplication.c(this.a).a().edit();
    localEditor.putLong("key_behavior_static_statistics_upload_time", System.currentTimeMillis());
    localEditor.commit();
  }
  
  public void a()
  {
    if (System.currentTimeMillis() - d() >= 86400000L) {
      c();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/g/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */