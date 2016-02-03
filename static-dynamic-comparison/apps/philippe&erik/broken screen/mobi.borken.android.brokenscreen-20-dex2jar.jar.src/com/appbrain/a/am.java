package com.appbrain.a;

import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

final class am
  implements View.OnKeyListener
{
  am(ak paramak, long paramLong) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (SystemClock.elapsedRealtime() >= this.a + 1500L) {
        ak.a(this.b);
      }
      return true;
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */