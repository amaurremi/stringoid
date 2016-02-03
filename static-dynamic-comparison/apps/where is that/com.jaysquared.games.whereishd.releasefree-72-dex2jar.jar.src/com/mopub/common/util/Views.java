package com.mopub.common.util;

import android.view.View;
import android.view.ViewGroup;

public class Views
{
  public static void removeFromParent(View paramView)
  {
    if ((paramView == null) || (paramView.getParent() == null)) {}
    while (!(paramView.getParent() instanceof ViewGroup)) {
      return;
    }
    ((ViewGroup)paramView.getParent()).removeView(paramView);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/common/util/Views.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */