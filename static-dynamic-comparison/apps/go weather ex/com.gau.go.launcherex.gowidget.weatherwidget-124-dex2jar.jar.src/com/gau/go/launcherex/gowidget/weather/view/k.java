package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.view.LayoutInflater;

public class k
{
  private LayoutInflater a;
  
  public k(Context paramContext)
  {
    this.a = LayoutInflater.from(paramContext);
  }
  
  public ViewPage a(int paramInt)
  {
    ViewPage localViewPage = null;
    int i;
    int j;
    switch (paramInt)
    {
    default: 
      i = -1;
      j = -1;
      paramInt = -1;
    }
    for (;;)
    {
      if (j != -1)
      {
        localViewPage = (ViewPage)this.a.inflate(2130903054, null);
        localViewPage.a(paramInt, j, i);
      }
      return localViewPage;
      j = 2130903051;
      i = 2131166014;
      continue;
      j = 2130903046;
      i = 2131166010;
      continue;
      j = 2130903055;
      i = 2131166015;
      continue;
      j = 2130903056;
      i = 2131166012;
      continue;
      j = 2130903053;
      i = 2131166013;
      continue;
      j = 2130903047;
      i = 2131166016;
      continue;
      j = 2130903049;
      i = 2131166017;
      continue;
      j = 2130903052;
      i = -1;
      continue;
      j = 2130903050;
      i = 2131166018;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */