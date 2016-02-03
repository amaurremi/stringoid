package com.atomic.apps.ringtone.cutter;

import android.app.Dialog;
import android.content.Context;
import android.os.Message;
import android.widget.Button;

public final class a
  extends Dialog
{
  private Message a;
  
  public a(Context paramContext, Message paramMessage)
  {
    super(paramContext);
    setContentView(2130903040);
    setTitle(2130968664);
    ((Button)findViewById(2131099668)).setOnClickListener(new b(this));
    ((Button)findViewById(2131099669)).setOnClickListener(new c(this));
    this.a = paramMessage;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/atomic/apps/ringtone/cutter/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */