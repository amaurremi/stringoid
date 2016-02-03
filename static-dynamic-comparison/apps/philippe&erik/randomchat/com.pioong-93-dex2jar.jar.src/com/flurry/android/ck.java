package com.flurry.android;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;

abstract class ck
{
  private ck(byte paramByte) {}
  
  public abstract ViewGroup.LayoutParams a(Context paramContext, AdSpaceLayout paramAdSpaceLayout);
  
  public final int b(Context paramContext, AdSpaceLayout paramAdSpaceLayout)
  {
    if (paramAdSpaceLayout.getAdWidth().intValue() != 0) {}
    for (int i = 1; i != 0; i = 0) {
      return bd.b(paramContext, paramAdSpaceLayout.getAdWidth().intValue());
    }
    return -1;
  }
  
  public final int c(Context paramContext, AdSpaceLayout paramAdSpaceLayout)
  {
    if (paramAdSpaceLayout.getAdHeight().intValue() != 0) {}
    for (int i = 1; i != 0; i = 0) {
      return bd.b(paramContext, paramAdSpaceLayout.getAdHeight().intValue());
    }
    return l();
  }
  
  public int l()
  {
    return -2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/ck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */