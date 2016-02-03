package com.go.weatherex.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.go.weatherex.framework.fragment.a;

public class ab
  extends a
{
  public Animation onCreateAnimation(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramBoolean) {
      return AnimationUtils.loadAnimation(getActivity(), 2130968587);
    }
    return AnimationUtils.loadAnimation(getActivity(), 2130968589);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903142, paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView.setBackgroundColor(Color.argb(64, 0, 0, 0));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */