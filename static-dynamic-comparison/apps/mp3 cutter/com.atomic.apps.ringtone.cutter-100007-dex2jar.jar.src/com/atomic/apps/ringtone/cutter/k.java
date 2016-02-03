package com.atomic.apps.ringtone.cutter;

import android.database.Cursor;
import android.view.View;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter.ViewBinder;

final class k
  implements SimpleCursorAdapter.ViewBinder
{
  k(MusicSelectActivity paramMusicSelectActivity) {}
  
  public final boolean setViewValue(View paramView, Cursor paramCursor, int paramInt)
  {
    if (paramView.getId() == 2131099718)
    {
      ((ImageView)paramView).setOnClickListener(new l(this));
      return true;
    }
    if (paramView.getId() == 2131099714)
    {
      MusicSelectActivity.a(this.a, (ImageView)paramView, paramCursor);
      return true;
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/atomic/apps/ringtone/cutter/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */