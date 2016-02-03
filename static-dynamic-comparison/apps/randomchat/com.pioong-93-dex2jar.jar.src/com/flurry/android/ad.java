package com.flurry.android;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class ad
  extends ck
{
  private static final Map<String, Integer> at;
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("b", Integer.valueOf(12));
    localHashMap.put("t", Integer.valueOf(10));
    localHashMap.put("m", Integer.valueOf(15));
    localHashMap.put("c", Integer.valueOf(14));
    localHashMap.put("l", Integer.valueOf(9));
    localHashMap.put("r", Integer.valueOf(11));
    at = Collections.unmodifiableMap(localHashMap);
  }
  
  private static Integer d(String paramString)
  {
    return (Integer)at.get(paramString);
  }
  
  public final ViewGroup.LayoutParams a(Context paramContext, AdSpaceLayout paramAdSpaceLayout)
  {
    paramContext = new RelativeLayout.LayoutParams(b(paramContext, paramAdSpaceLayout), c(paramContext, paramAdSpaceLayout));
    paramAdSpaceLayout = paramAdSpaceLayout.getAlignment().toString().split("-");
    if (paramAdSpaceLayout.length == 2)
    {
      Integer localInteger = d(paramAdSpaceLayout[0]);
      if (localInteger != null) {
        paramContext.addRule(localInteger.intValue());
      }
      paramAdSpaceLayout = d(paramAdSpaceLayout[1]);
      if (paramAdSpaceLayout != null) {
        paramContext.addRule(paramAdSpaceLayout.intValue());
      }
    }
    return paramContext;
  }
  
  public final int l()
  {
    return -1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */