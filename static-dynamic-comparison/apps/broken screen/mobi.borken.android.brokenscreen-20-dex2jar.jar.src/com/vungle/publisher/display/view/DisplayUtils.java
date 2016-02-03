package com.vungle.publisher.display.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DisplayUtils
{
  @Inject
  Context a;
  
  public final float a(int paramInt)
  {
    return TypedValue.applyDimension(1, paramInt, this.a.getResources().getDisplayMetrics());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/display/view/DisplayUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */