package com.vungle.sdk;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.VideoView;

final class ab
  implements DialogInterface.OnClickListener
{
  ab(y paramy) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    long l1 = y.b(this.a).getCurrentPosition();
    long l2 = y.b(this.a).getDuration();
    y.b(this.a).stopPlayback();
    y.g(this.a);
    y.f(this.a);
    y.i(this.a).a(y.h(this.a), l1, l2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */