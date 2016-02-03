package com.gtp.go.weather.sharephoto.photo;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.gtp.go.weather.sharephoto.b.g;
import com.jiubang.pla.listview.MultiColumnListView;

class x
  implements e
{
  x(PhotoActivity paramPhotoActivity, g paramg) {}
  
  public void a(Drawable paramDrawable, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = PhotoActivity.h(this.b).findViewWithTag(paramString2);
    if (paramString1 != null)
    {
      paramString2 = PhotoActivity.h(this.b).findViewWithTag(paramString3);
      if (paramDrawable == null) {
        break label53;
      }
      paramString1.setBackgroundDrawable(paramDrawable);
      paramString1.setVisibility(0);
      if (paramString2 != null) {
        paramString2.setVisibility(4);
      }
    }
    return;
    label53:
    paramString1.setBackgroundResource(2130838889);
    paramString1.setVisibility(4);
    if (paramString2 != null) {
      paramString2.setVisibility(0);
    }
    PhotoActivity.a(this.b, this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/photo/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */