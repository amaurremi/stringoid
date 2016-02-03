package com.gtp.go.weather.sharephoto.takephoto;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

class v
  implements TextWatcher
{
  v(PublishPhotoActivity paramPublishPhotoActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i = paramEditable.length();
    PublishPhotoActivity.e(this.a).setText(String.valueOf(80 - i));
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/takephoto/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */