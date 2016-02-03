package com.pocket.i.a;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class l
  extends Drawable
{
  private final ArrayList a = new ArrayList();
  
  protected void a(Paint paramPaint)
  {
    this.a.add(paramPaint);
    paramPaint.setAntiAlias(true);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    super.onStateChange(paramArrayOfInt);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Paint localPaint = (Paint)localIterator.next();
      if ((localPaint instanceof m)) {
        ((m)localPaint).a(paramArrayOfInt);
      }
    }
    return true;
  }
  
  public void setAlpha(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((Paint)localIterator.next()).setAlpha(paramInt);
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((Paint)localIterator.next()).setColorFilter(paramColorFilter);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/i/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */