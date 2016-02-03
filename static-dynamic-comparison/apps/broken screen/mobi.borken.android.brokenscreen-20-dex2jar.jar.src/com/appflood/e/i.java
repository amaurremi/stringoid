package com.appflood.e;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.SeekBar;
import com.appflood.b.b;
import com.appflood.b.b.a;
import com.appflood.c.f;

public final class i
  implements b.a
{
  public i(StateListDrawable paramStateListDrawable, View paramView) {}
  
  public final void a(b paramb)
  {
    paramb = paramb.d();
    if (paramb != null)
    {
      paramb = new BitmapDrawable(paramb);
      this.a.addState(new int[0], paramb);
      if ((this.b instanceof SeekBar)) {
        f.a(new Runnable()
        {
          public final void run()
          {
            j.a();
            ((SeekBar)i.this.b).setThumb(i.this.a);
          }
        });
      }
    }
  }
  
  public final void a(b paramb, int paramInt) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/e/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */