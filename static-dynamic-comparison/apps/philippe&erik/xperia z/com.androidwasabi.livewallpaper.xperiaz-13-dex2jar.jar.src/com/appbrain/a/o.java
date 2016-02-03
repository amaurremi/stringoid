package com.appbrain.a;

import android.content.Context;
import com.appbrain.b.u;
import com.appbrain.e.aa;
import com.appbrain.e.an;
import com.appbrain.e.ar;
import com.appbrain.e.au;

public final class o
  extends ag
{
  public o(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void a(u paramu, aa paramaa)
  {
    if ((paramu instanceof au))
    {
      ((au)paramu).a(paramaa);
      return;
    }
    if ((paramu instanceof ar))
    {
      ((ar)paramu).a(paramaa);
      return;
    }
    if ((paramu instanceof an))
    {
      ((an)paramu).a(paramaa);
      return;
    }
    throw new IllegalArgumentException("Unknown builder type.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */