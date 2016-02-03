package com.badlogic.gdx.backends.android.b;

import android.os.Build.VERSION;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;

class i
  extends BaseInputConnection
{
  i(h paramh, View paramView, boolean paramBoolean)
  {
    super(paramView, paramBoolean);
  }
  
  private void a(int paramInt)
  {
    long l = SystemClock.uptimeMillis();
    super.sendKeyEvent(new KeyEvent(l, l, 0, paramInt, 0, 0, -1, 0, 6));
    super.sendKeyEvent(new KeyEvent(SystemClock.uptimeMillis(), l, 1, paramInt, 0, 0, -1, 0, 6));
  }
  
  public boolean deleteSurroundingText(int paramInt1, int paramInt2)
  {
    if ((Integer.parseInt(Build.VERSION.SDK) >= 16) && (paramInt1 == 1) && (paramInt2 == 0))
    {
      a(67);
      return true;
    }
    return super.deleteSurroundingText(paramInt1, paramInt2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/b/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */