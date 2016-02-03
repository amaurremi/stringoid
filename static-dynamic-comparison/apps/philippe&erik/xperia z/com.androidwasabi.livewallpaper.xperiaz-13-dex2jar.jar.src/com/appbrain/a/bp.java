package com.appbrain.a;

import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

final class bp
  implements View.OnKeyListener
{
  bp(bn parambn, long paramLong) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (SystemClock.elapsedRealtime() >= this.a + 1500L) {
        bn.a(this.b);
      }
      return true;
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */