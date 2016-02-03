package com.go.weatherex.home.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.c.c;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.go.weatherex.framework.fragment.a;

public class f
  extends a
{
  private ImageView a;
  private Bitmap b;
  
  private int a(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      if (!paramBoolean) {
        break;
      }
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 1: 
      do
      {
        do
        {
          return 2130837851;
        } while (paramBoolean);
        return 2130837852;
        if (paramBoolean) {
          return 2130837841;
        }
        return 2130837842;
        if (paramBoolean) {
          return 2130837845;
        }
        return 2130837846;
        if (paramBoolean) {
          return 2130837849;
        }
        return 2130837850;
        if (paramBoolean) {
          return 2130837843;
        }
        return 2130837844;
        if (paramBoolean) {
          return 2130837847;
        }
        return 2130837848;
        if (paramBoolean) {
          return 2130837853;
        }
        return 2130837854;
      } while (paramBoolean);
      return 2130837852;
    }
    return 2130837852;
  }
  
  public static Bundle a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("cityId", paramString);
    return localBundle;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    boolean bool = true;
    super.onActivityCreated(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getString("cityId");; paramBundle = null)
    {
      Object localObject1 = paramBundle;
      if (paramBundle == null) {
        localObject1 = "";
      }
      Object localObject2 = c.a(getActivity().getApplicationContext());
      paramBundle = ((c)localObject2).g();
      localObject1 = ((c)localObject2).h().a((String)localObject1);
      int i;
      String str;
      if (localObject1 != null)
      {
        i = ((WeatherBean)localObject1).k.d();
        localObject2 = ((WeatherBean)localObject1).k.j();
        str = ((WeatherBean)localObject1).k.k();
        if ((GoWidgetApplication.b(getActivity().getApplicationContext()).b()) && (paramBundle.d())) {
          bool = r.a((String)localObject2, str, paramBundle.b(((WeatherBean)localObject1).k.n()));
        }
      }
      for (;;)
      {
        try
        {
          paramBundle = new BitmapFactory.Options();
          paramBundle.inSampleSize = 2;
          paramBundle.inPreferredConfig = Bitmap.Config.ALPHA_8;
          this.b = BitmapFactory.decodeResource(getResources(), a(i, bool), paramBundle);
          if (Build.VERSION.SDK_INT < 11) {
            continue;
          }
          paramBundle = e.a(getActivity().getApplicationContext(), this.b, 15);
          if (paramBundle == null) {
            continue;
          }
          this.b.recycle();
          this.b = paramBundle;
        }
        catch (OutOfMemoryError paramBundle)
        {
          if ((this.b == null) || (this.b.isRecycled())) {
            continue;
          }
          this.b.recycle();
          this.b = null;
          continue;
          ((FrameLayout)c(2131231368)).setForeground(new ColorDrawable(Color.argb(90, 0, 0, 0)));
          continue;
        }
        this.a = ((ImageView)c(2131231369));
        if (this.b != null) {
          this.a.setImageBitmap(this.b);
        }
        return;
        bool = r.a((String)localObject2, str);
        continue;
        ((FrameLayout)c(2131231368)).setForeground(new ColorDrawable(Color.argb(90, 0, 0, 0)));
        continue;
        i = 1;
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903145, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.b != null) && (!this.b.isRecycled()))
    {
      this.b.recycle();
      this.b = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */