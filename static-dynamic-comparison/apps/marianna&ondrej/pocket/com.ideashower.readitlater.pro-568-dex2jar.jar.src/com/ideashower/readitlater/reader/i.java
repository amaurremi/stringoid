package com.ideashower.readitlater.reader;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.ideashower.readitlater.activity.ReaderFragment;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.e.x;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.util.z;
import com.pocket.widget.ag;

public class i
  extends ag
{
  private i(h paramh, View paramView)
  {
    super(paramh, paramView);
  }
  
  protected o a(x paramx)
  {
    return g.d(this.a.a);
  }
  
  protected void a(int paramInt)
  {
    View.OnClickListener localOnClickListener = null;
    super.a(paramInt);
    z.a(this.b, h.b(this.a));
    if (paramInt > 0) {
      this.b.setBackgroundResource(2130837507);
    }
    for (;;)
    {
      if (j.c())
      {
        int i = j.a(c.a(g.h(this.a.a).ar()));
        h.b(this.a).left = i;
        h.b(this.a).right = i;
      }
      z.a(this.b, h.b(this.a));
      ViewGroup localViewGroup = this.b;
      if (paramInt == 0) {
        localOnClickListener = g.l(this.a.a);
      }
      localViewGroup.setOnClickListener(localOnClickListener);
      return;
      if (!g.j(this.a.a)) {
        this.b.setBackgroundDrawable(g.k(this.a.a));
      } else {
        this.b.setBackgroundDrawable(null);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/reader/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */