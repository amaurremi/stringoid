package com.atomic.apps.ringtone.cutter;

import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Spinner;

final class e
  implements View.OnClickListener
{
  e(d paramd) {}
  
  public final void onClick(View paramView)
  {
    d.a(this.a).obj = d.b(this.a).getText();
    d.a(this.a).arg1 = d.c(this.a).getSelectedItemPosition();
    d.a(this.a).sendToTarget();
    this.a.dismiss();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/atomic/apps/ringtone/cutter/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */