package com.gtp.go.weather.sharephoto;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.gtp.go.weather.sharephoto.d.p;

class j
  implements DialogInterface.OnDismissListener
{
  j(PhotoDetailActivity paramPhotoDetailActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    PhotoDetailActivity.b(this.a).g();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */