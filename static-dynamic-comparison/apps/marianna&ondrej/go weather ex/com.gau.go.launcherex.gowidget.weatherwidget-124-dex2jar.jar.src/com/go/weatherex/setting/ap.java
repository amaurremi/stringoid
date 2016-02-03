package com.go.weatherex.setting;

import com.gau.go.launcherex.gowidget.weather.globalview.a;
import com.gau.go.launcherex.gowidget.weather.globalview.i;
import com.gau.go.launcherex.gowidget.weather.globalview.m;
import java.util.ArrayList;
import java.util.Iterator;

class ap
  implements m
{
  ap(an paraman) {}
  
  public void a(i parami, boolean paramBoolean, ArrayList paramArrayList)
  {
    if (paramBoolean)
    {
      an.b(this.a).c = 0;
      an.b(this.a).d = 0;
      an.b(this.a).e = 0;
      parami = paramArrayList.iterator();
      while (parami.hasNext())
      {
        paramArrayList = (at)((a)parami.next()).c;
        paramArrayList.c = 1;
        switch (paramArrayList.a)
        {
        default: 
          break;
        case 2131166193: 
          an.b(this.a).c = paramArrayList.c;
          break;
        case 2131166194: 
          an.b(this.a).d = paramArrayList.c;
          break;
        case 2131166195: 
          an.b(this.a).e = paramArrayList.c;
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */