package com.pocket.h;

import android.content.Context;
import com.android.a.b;

public class d
  extends b
{
  private e a;
  
  public d(Context paramContext, e parame)
  {
    super(paramContext);
    this.a = parame;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    if (this.a != null) {
      this.a.a(this);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/h/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */