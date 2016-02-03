package com.ideashower.readitlater.reader;

import android.content.Context;
import android.view.MotionEvent;
import com.ideashower.readitlater.util.a;
import com.ideashower.readitlater.views.ThemedListView;
import com.pocket.widget.n;

public class k
  extends ThemedListView
{
  private n b;
  
  public k(Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.b != null) && (a.d()) && ((this.b.h()) || (!this.b.g()))) {
      return false;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void setDrawer(n paramn)
  {
    this.b = paramn;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/reader/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */