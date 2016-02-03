package com.gtp.go.weather.sharephoto;

import android.view.View;
import android.widget.ImageView;
import com.a.c.c;
import com.gtp.go.weather.sharephoto.d.p;
import com.gtp.go.weather.sharephoto.d.s;

class n
  implements s
{
  n(PhotoDetailActivity paramPhotoDetailActivity) {}
  
  public void a(boolean paramBoolean)
  {
    float f2 = 1.0F;
    boolean bool;
    float f1;
    if (PhotoDetailActivity.c(this.a))
    {
      Object localObject = PhotoDetailActivity.d(this.a);
      if (paramBoolean)
      {
        bool = true;
        ((ImageView)localObject).setEnabled(bool);
        PhotoDetailActivity.a(this.a, PhotoDetailActivity.d(this.a));
        localObject = c.a(PhotoDetailActivity.d(this.a));
        if (!paramBoolean) {
          break label250;
        }
        f1 = 1.0F;
        label67:
        localObject = ((c)localObject).a(f1);
        if (!paramBoolean) {
          break label255;
        }
        f1 = f2;
        label81:
        ((c)localObject).b(f1).a(PhotoDetailActivity.e(this.a)).a();
      }
    }
    else
    {
      if (PhotoDetailActivity.a(this.a) == 1)
      {
        PhotoDetailActivity.g(this.a).removeCallbacks(PhotoDetailActivity.f(this.a));
        if (!paramBoolean) {
          break label260;
        }
        if (PhotoDetailActivity.h(this.a).getVisibility() != 0)
        {
          PhotoDetailActivity.a(this.a, PhotoDetailActivity.h(this.a));
          PhotoDetailActivity.h(this.a).startAnimation(PhotoDetailActivity.i(this.a));
        }
      }
      label178:
      if (!paramBoolean) {
        break label280;
      }
      if (PhotoDetailActivity.k(this.a).getVisibility() != 0)
      {
        PhotoDetailActivity.a(this.a, PhotoDetailActivity.k(this.a));
        PhotoDetailActivity.k(this.a).startAnimation(PhotoDetailActivity.l(this.a));
      }
    }
    for (;;)
    {
      if (!paramBoolean) {
        break label300;
      }
      PhotoDetailActivity.b(this.a).a(3000);
      return;
      bool = false;
      break;
      label250:
      f1 = 0.0F;
      break label67;
      label255:
      f1 = 0.0F;
      break label81;
      label260:
      PhotoDetailActivity.h(this.a).startAnimation(PhotoDetailActivity.j(this.a));
      break label178;
      label280:
      PhotoDetailActivity.k(this.a).startAnimation(PhotoDetailActivity.m(this.a));
    }
    label300:
    PhotoDetailActivity.b(this.a).f();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */