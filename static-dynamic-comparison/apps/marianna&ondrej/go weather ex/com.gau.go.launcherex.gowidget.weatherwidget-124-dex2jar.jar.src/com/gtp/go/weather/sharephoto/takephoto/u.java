package com.gtp.go.weather.sharephoto.takephoto;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class u
  implements DialogInterface.OnKeyListener
{
  u(PublishPhotoActivity paramPublishPhotoActivity) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    return (paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/takephoto/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */