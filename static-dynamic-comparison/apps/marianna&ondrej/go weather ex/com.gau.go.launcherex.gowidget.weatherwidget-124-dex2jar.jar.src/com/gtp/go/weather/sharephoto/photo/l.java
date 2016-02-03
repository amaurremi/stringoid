package com.gtp.go.weather.sharephoto.photo;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.gtp.go.weather.sharephoto.award.o;
import com.gtp.go.weather.sharephoto.b.d;
import java.util.Iterator;
import java.util.List;

class l
  extends o
{
  l(PhotoActivity paramPhotoActivity) {}
  
  public void a(List paramList)
  {
    if ((PhotoActivity.a(this.a).getVisibility() == 0) && (paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        d locald = (d)paramList.next();
        if ((PhotoActivity.b(this.a) != null) && (PhotoActivity.b(this.a).f() == locald.b()))
        {
          PhotoActivity.a(this.a).setVisibility(8);
          PhotoActivity.b(this.a).a(false);
          PhotoActivity.c(this.a).a(PhotoActivity.b(this.a));
        }
      }
    }
  }
  
  public void b(List paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = (com.gtp.go.weather.sharephoto.b.k)paramList.get(0);
      if ((paramList != null) && (paramList.a()))
      {
        String str = paramList.e();
        if (!TextUtils.isEmpty(str))
        {
          PhotoActivity.a(this.a, paramList);
          PhotoActivity.a(this.a).setVisibility(0);
          PhotoActivity.b(this.a).a(false);
          PhotoActivity.c(this.a).a(PhotoActivity.b(this.a));
          PhotoActivity.d(this.a).setText(str);
          PhotoActivity.d(this.a).setOnClickListener(new m(this, paramList));
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/photo/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */