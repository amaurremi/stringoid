package com.appbrain.d;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.LevelListDrawable;
import cmn.aa;

public final class h
  extends LevelListDrawable
{
  private Context a;
  private int b;
  private Runnable c;
  private int d;
  
  public h(Context paramContext, String paramString)
  {
    this.a = paramContext;
    this.d = 0;
    addLevel(0, 2, new ColorDrawable(0));
    this.b = 1;
    setLevel(1);
    aa.a(null, paramString, new i(this));
  }
  
  protected final boolean onLevelChange(int paramInt)
  {
    if (paramInt != this.b) {
      setLevel(this.b);
    }
    return super.onLevelChange(this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/d/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */