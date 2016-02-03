package com.go.weatherex.f;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.gau.go.launcherex.gowidget.weather.util.r;

public class i
  extends com.go.weatherex.framework.fragment.a
{
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (r.a(getActivity()) == 1)
    {
      a(t.class, null);
      return;
    }
    a(a.class, null);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903138, paramViewGroup, false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/f/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */