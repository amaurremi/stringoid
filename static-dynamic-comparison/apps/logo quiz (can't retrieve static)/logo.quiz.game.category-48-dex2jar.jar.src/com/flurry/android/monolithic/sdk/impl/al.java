package com.flurry.android.monolithic.sdk.impl;

import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.flurry.android.impl.ads.avro.protocol.v6.AdSpaceLayout;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class al
  extends aj
{
  private static final Map<String, Integer> a = ;
  
  al()
  {
    super(null);
  }
  
  private static Integer a(String paramString)
  {
    return (Integer)a.get(paramString);
  }
  
  private static Map<String, Integer> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("b", Integer.valueOf(12));
    localHashMap.put("t", Integer.valueOf(10));
    localHashMap.put("m", Integer.valueOf(15));
    localHashMap.put("c", Integer.valueOf(14));
    localHashMap.put("l", Integer.valueOf(9));
    localHashMap.put("r", Integer.valueOf(11));
    return Collections.unmodifiableMap(localHashMap);
  }
  
  public ViewGroup.LayoutParams a(AdSpaceLayout paramAdSpaceLayout)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(b(paramAdSpaceLayout), c(paramAdSpaceLayout));
    paramAdSpaceLayout = paramAdSpaceLayout.f().toString().split("-");
    if (paramAdSpaceLayout.length == 2)
    {
      Integer localInteger = a(paramAdSpaceLayout[0]);
      if (localInteger != null) {
        localLayoutParams.addRule(localInteger.intValue());
      }
      paramAdSpaceLayout = a(paramAdSpaceLayout[1]);
      if (paramAdSpaceLayout != null) {
        localLayoutParams.addRule(paramAdSpaceLayout.intValue());
      }
    }
    return localLayoutParams;
  }
  
  public int g(AdSpaceLayout paramAdSpaceLayout)
  {
    return -1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */