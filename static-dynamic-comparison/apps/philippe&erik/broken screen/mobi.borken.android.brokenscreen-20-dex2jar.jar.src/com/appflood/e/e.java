package com.appflood.e;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.appflood.b.b;
import com.appflood.b.b.a;
import com.appflood.c.f;

public final class e
  implements b.a
{
  public e(Drawable[] paramArrayOfDrawable, View paramView) {}
  
  public final void a(final b paramb)
  {
    paramb = paramb.d();
    if (paramb != null)
    {
      paramb = new BitmapDrawable(paramb);
      this.b[0] = paramb;
      f.a(new Runnable()
      {
        public final void run()
        {
          e.this.a.setBackgroundDrawable(paramb);
        }
      });
    }
  }
  
  public final void a(b paramb, int paramInt) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/e/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */