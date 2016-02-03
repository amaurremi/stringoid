package com.gtp.go.weather.sharephoto.photo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.gtp.go.weather.sharephoto.b.g;
import java.util.ArrayList;
import java.util.Iterator;

class z
  extends BroadcastReceiver
{
  private z(PhotoActivity paramPhotoActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool2 = true;
    paramContext = paramIntent.getAction();
    int i;
    long l;
    boolean bool1;
    if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_CHANGE_FAVOUR_OR_BACKCOUNT"))
    {
      i = paramIntent.getIntExtra("extra_change_type", 0);
      if (i == 1)
      {
        l = paramIntent.getLongExtra("extra_change_photo_id", 0L);
        i = paramIntent.getIntExtra("extra_change_value", 0);
        if ((l != 0L) && (i != 0))
        {
          paramContext = PhotoActivity.n(this.a).iterator();
          while (paramContext.hasNext())
          {
            paramIntent = (g)paramContext.next();
            if ((paramIntent != null) && (paramIntent.a() == l))
            {
              boolean bool3 = paramIntent.h();
              if (i != 1) {
                break label159;
              }
              bool1 = true;
              if (bool3 != bool1)
              {
                if (i != 1) {
                  break label165;
                }
                bool1 = bool2;
                label132:
                paramIntent.a(bool1);
                paramIntent.a(paramIntent.c() + i);
                this.a.a.notifyDataSetChanged();
              }
            }
          }
        }
      }
    }
    label159:
    label165:
    do
    {
      return;
      while (!paramContext.hasNext())
      {
        do
        {
          do
          {
            do
            {
              bool1 = false;
              break;
              bool1 = false;
              break label132;
            } while (i != 2);
            return;
            if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY"))
            {
              PhotoActivity.f(this.a).clear();
              paramContext = f.a(this.a.getApplicationContext()).d();
              paramIntent = new ab(this.a, null);
              paramIntent.a = this.a.e().getString(2131166344);
              PhotoActivity.f(this.a).add(paramIntent);
              paramContext = paramContext.iterator();
              while (paramContext.hasNext())
              {
                paramIntent = (WeatherBean)paramContext.next();
                if (paramIntent != null)
                {
                  ab localab = new ab(this.a, null);
                  localab.a = paramIntent.d();
                  localab.b = paramIntent.c();
                  PhotoActivity.f(this.a).add(localab);
                }
              }
              PhotoActivity.o(this.a).notifyDataSetChanged();
              return;
            }
          } while ((!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DELETE_USER_PHOTO")) || (PhotoActivity.i(this.a) != 2));
          l = paramIntent.getLongExtra("extra_delete_photo_id", 0L);
        } while (l == 0L);
        paramContext = PhotoActivity.n(this.a).iterator();
      }
      paramIntent = (g)paramContext.next();
    } while ((paramIntent == null) || (paramIntent.a() != l) || (paramIntent.g() != 1));
    PhotoActivity.n(this.a).remove(paramIntent);
    this.a.a.notifyDataSetChanged();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/photo/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */