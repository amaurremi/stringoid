package com.gtp.go.weather.sharephoto;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.ImageView;
import com.gtp.go.weather.sharephoto.d.p;

class t
  extends BroadcastReceiver
{
  t(PhotoDetailActivity paramPhotoDetailActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    PhotoDetailActivity localPhotoDetailActivity;
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if ((paramContext != null) && (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_CHANGE_USER_DATA")))
      {
        paramContext = paramIntent.getStringExtra("extra_user_id");
        paramIntent = paramIntent.getStringExtra("extra_user_gamil");
        localPhotoDetailActivity = this.a;
        if ((TextUtils.isEmpty(paramContext)) || (TextUtils.isEmpty(paramIntent))) {
          break label115;
        }
      }
    }
    label115:
    for (boolean bool = true;; bool = false)
    {
      PhotoDetailActivity.e(localPhotoDetailActivity, bool);
      if ((PhotoDetailActivity.c(this.a)) && (PhotoDetailActivity.a(this.a) == 1))
      {
        PhotoDetailActivity.d(this.a).setVisibility(0);
        PhotoDetailActivity.b(this.a).d();
        PhotoDetailActivity.z(this.a);
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */