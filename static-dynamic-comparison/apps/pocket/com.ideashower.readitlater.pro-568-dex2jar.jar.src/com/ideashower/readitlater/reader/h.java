package com.ideashower.readitlater.reader;

import android.graphics.Rect;
import android.view.View;
import com.ideashower.readitlater.db.operation.action.UiTrigger;
import com.ideashower.readitlater.e.c;
import com.ideashower.readitlater.e.x;
import com.ideashower.readitlater.e.y;
import com.pocket.widget.af;
import com.pocket.widget.ag;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.a.c.k;

public class h
  extends af
{
  private final Rect k = new Rect();
  
  public h(g paramg)
  {
    super(g.h(paramg), null, g.i(paramg), paramg.getContext(), UiTrigger.l, "reader");
  }
  
  private ArrayList e()
  {
    return this.h;
  }
  
  protected int a(int paramInt)
  {
    if ((c(paramInt) instanceof y))
    {
      if (com.ideashower.readitlater.util.j.c()) {
        return 2130903191;
      }
      return 2130903190;
    }
    if (com.ideashower.readitlater.util.j.c()) {
      return 2130903182;
    }
    return 2130903181;
  }
  
  protected com.pocket.widget.h a(View paramView, int paramInt)
  {
    return new i(this, paramView, null);
  }
  
  protected void a(j paramj)
  {
    this.g.clear();
    if (g.d(this.a) != null) {
      this.g.a(g.d(this.a));
    }
    if (j.a(paramj) != null)
    {
      this.h = j.a(paramj);
      Collections.sort(this.h, x.a);
      return;
    }
    this.h.clear();
  }
  
  protected void a(ag paramag, View paramView)
  {
    super.a(paramag, paramView);
    this.a.a();
  }
  
  public boolean a()
  {
    boolean bool2 = true;
    if (this.h.isEmpty()) {
      bool1 = false;
    }
    c localc;
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.h.size() > 1);
      localc = (c)this.h.get(0);
      bool1 = bool2;
    } while (!(localc instanceof x));
    if ((((x)localc).g() == 0) || (!k.c(((x)localc).d())) || (!k.c(((x)localc).e()))) {}
    for (boolean bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/reader/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */