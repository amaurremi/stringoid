package com.atomic.apps.ringtone.cutter;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

final class r
  implements TextWatcher
{
  r(RingtoneEditActivity paramRingtoneEditActivity) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    if (RingtoneEditActivity.c(this.a).hasFocus()) {}
    try
    {
      RingtoneEditActivity.e(this.a, RingtoneEditActivity.j(this.a).b(Double.parseDouble(RingtoneEditActivity.c(this.a).getText().toString())));
      RingtoneEditActivity.m(this.a);
      if (RingtoneEditActivity.f(this.a).hasFocus()) {}
      try
      {
        RingtoneEditActivity.f(this.a, RingtoneEditActivity.j(this.a).b(Double.parseDouble(RingtoneEditActivity.f(this.a).getText().toString())));
        RingtoneEditActivity.m(this.a);
        return;
      }
      catch (Throwable paramEditable) {}
    }
    catch (Throwable paramEditable)
    {
      for (;;) {}
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/atomic/apps/ringtone/cutter/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */