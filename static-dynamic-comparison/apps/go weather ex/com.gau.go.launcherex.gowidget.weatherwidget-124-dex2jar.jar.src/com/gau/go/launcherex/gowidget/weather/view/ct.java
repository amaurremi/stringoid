package com.gau.go.launcherex.gowidget.weather.view;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.scroller.WidgetScrollGroup;
import com.gau.go.launcherex.gowidget.weather.util.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ct
  extends Handler
{
  ct(WeatherWidget41Style2 paramWeatherWidget41Style2) {}
  
  public void handleMessage(Message paramMessage)
  {
    label68:
    Object localObject2;
    label83:
    Object localObject3;
    Object localObject4;
    Object localObject1;
    switch (paramMessage.what)
    {
    default: 
    case 1: 
      do
      {
        return;
        if (paramMessage.obj == null) {
          break;
        }
        paramMessage = (List)paramMessage.obj;
        localObject2 = this.a.mWidgetScrollGroup.c().iterator();
      } while (!((Iterator)localObject2).hasNext());
      localObject3 = (bo)((Iterator)localObject2).next();
      localObject4 = paramMessage.iterator();
      do
      {
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        localObject1 = (WeatherBean)((Iterator)localObject4).next();
      } while (!((WeatherBean)localObject1).c().equals(((bo)localObject3).d()));
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ((bo)localObject3).a((WeatherBean)localObject1);
        ((bo)localObject3).a = true;
        ((bo)localObject3).f();
      }
      ((bo)localObject3).b(false);
      break label83;
      paramMessage = new ArrayList();
      break label68;
      paramMessage = paramMessage.getData();
      if (paramMessage == null) {
        break;
      }
      WeatherWidget41Style2.a(this.a, paramMessage);
      return;
      e.a(paramMessage.arg1, paramMessage.arg2, this.a.mWidgetScrollGroup);
      this.a.mWidgetScrollGroup.a();
      WeatherWidget41Style2.A(this.a);
      return;
      paramMessage = (WeatherBean)paramMessage.obj;
      if (paramMessage == null) {
        break;
      }
      WeatherWidget41Style2.B(this.a);
      paramMessage = WeatherWidget41Style2.a(this.a, paramMessage);
      this.a.mWidgetScrollGroup.a(this.a.mWidgetScrollGroup.indexOfChild(paramMessage));
      return;
      localObject1 = (ArrayList)paramMessage.obj;
      if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty())) {
        break;
      }
      paramMessage = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
      int i = 0;
      label329:
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = this.a.mWidgetScrollGroup.c().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (bo)((Iterator)localObject3).next();
          String str = ((bo)localObject4).d();
          if (((String)localObject2).equals(str))
          {
            if (str.equals(WeatherWidget41Style2.C(this.a))) {
              i = 1;
            }
            paramMessage.add(localObject4);
          }
        }
      }
      for (;;)
      {
        break label329;
        localObject1 = (bo)this.a.mWidgetScrollGroup.getChildAt(WeatherWidget41Style2.D(this.a));
        paramMessage = paramMessage.iterator();
        while (paramMessage.hasNext())
        {
          localObject2 = (bo)paramMessage.next();
          this.a.mWidgetScrollGroup.removeView((View)localObject2);
        }
        this.a.mWidgetScrollGroup.a();
        if (i != 0)
        {
          this.a.mWidgetScrollGroup.a(0);
          return;
        }
        WeatherWidget41Style2.b(this.a, this.a.mWidgetScrollGroup.indexOfChild((View)localObject1));
        if (WeatherWidget41Style2.D(this.a) == -1) {
          WeatherWidget41Style2.b(this.a, 0);
        }
        this.a.mWidgetScrollGroup.a(WeatherWidget41Style2.D(this.a));
        return;
        localObject2 = (WeatherBean)paramMessage.obj;
        if (localObject2 == null) {
          break;
        }
        localObject3 = ((WeatherBean)localObject2).c();
        localObject4 = this.a.mWidgetScrollGroup.c().iterator();
        paramMessage = null;
        if (((Iterator)localObject4).hasNext())
        {
          localObject1 = (bo)((Iterator)localObject4).next();
          if (localObject1 != null) {
            if (((bo)localObject1).d().equals(localObject3)) {
              paramMessage = (Message)localObject1;
            }
          }
          for (;;)
          {
            break;
            i = ((bo)localObject1).c().e();
            if (i == 2)
            {
              this.a.mWidgetScrollGroup.removeView((View)localObject1);
              this.a.mWidgetScrollGroup.a();
            }
            else if (i == 3)
            {
              ((bo)localObject1).c().a(1);
            }
          }
        }
        if (paramMessage != null) {
          paramMessage.c().a(3);
        }
        for (i = this.a.mWidgetScrollGroup.indexOfChild(paramMessage); i != -1; i = this.a.mWidgetScrollGroup.indexOfChild(paramMessage))
        {
          this.a.mWidgetScrollGroup.a(i);
          return;
          paramMessage = WeatherWidget41Style2.a(this.a, (WeatherBean)localObject2);
          this.a.mWidgetScrollGroup.a();
        }
        this.a.onBillingStatusChange(((Boolean)paramMessage.obj).booleanValue());
        return;
        WeatherWidget41Style2.e(this.a, ((Boolean)paramMessage.obj).booleanValue());
        return;
      }
      localObject1 = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/ct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */