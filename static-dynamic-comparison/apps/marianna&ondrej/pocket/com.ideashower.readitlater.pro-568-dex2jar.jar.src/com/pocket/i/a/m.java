package com.pocket.i.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Paint;

public class m
  extends Paint
{
  private ColorStateList a;
  
  public m()
  {
    setAntiAlias(true);
  }
  
  public m(Context paramContext, int paramInt)
  {
    this();
    this.a = paramContext.getResources().getColorStateList(paramInt);
  }
  
  public void a(ColorStateList paramColorStateList, int[] paramArrayOfInt)
  {
    this.a = paramColorStateList;
    a(paramArrayOfInt);
  }
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public boolean a(int[] paramArrayOfInt)
  {
    if (this.a != null) {}
    for (int i = this.a.getColorForState(paramArrayOfInt, 0); getColor() == i; i = 0) {
      return false;
    }
    setColor(i);
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/i/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */