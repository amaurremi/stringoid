package com.gtp.go.weather.sharephoto.photo;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.jiubang.pla.listview.MultiColumnListView;

class o
  implements e
{
  o(PhotoActivity paramPhotoActivity) {}
  
  public void a(Drawable paramDrawable, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = PhotoActivity.h(this.a).findViewWithTag(paramString2);
    if (paramString1 != null)
    {
      paramString2 = PhotoActivity.h(this.a).findViewWithTag(paramString3);
      if (paramDrawable == null) {
        break label53;
      }
      if (paramString2 != null) {
        paramString2.setVisibility(4);
      }
      paramString1.setVisibility(0);
      paramString1.setBackgroundDrawable(paramDrawable);
    }
    label53:
    do
    {
      return;
      paramString1.setBackgroundResource(2130838889);
      paramString1.setVisibility(4);
    } while (paramString2 == null);
    paramString2.setVisibility(0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/photo/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */