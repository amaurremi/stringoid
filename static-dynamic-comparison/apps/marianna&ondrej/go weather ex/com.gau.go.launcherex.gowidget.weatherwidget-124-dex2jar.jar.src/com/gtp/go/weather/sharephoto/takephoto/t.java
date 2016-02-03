package com.gtp.go.weather.sharephoto.takephoto;

import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;

class t
  implements PopupWindow.OnDismissListener
{
  t(PublishPhotoActivity paramPublishPhotoActivity) {}
  
  public void onDismiss()
  {
    PublishPhotoActivity.a(this.a).setImageResource(2130838485);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/takephoto/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */