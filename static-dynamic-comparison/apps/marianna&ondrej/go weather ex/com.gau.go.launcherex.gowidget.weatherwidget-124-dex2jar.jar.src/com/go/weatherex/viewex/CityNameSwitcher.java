package com.go.weatherex.viewex;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class CityNameSwitcher
  extends ViewSwitcher
{
  public CityNameSwitcher(Context paramContext)
  {
    super(paramContext);
  }
  
  public CityNameSwitcher(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    j localj = (j)getNextView();
    localj.b.setText(paramCharSequence);
    paramCharSequence = localj.a;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      paramCharSequence.setVisibility(i);
      showNext();
      return;
    }
  }
  
  public void b(CharSequence paramCharSequence, boolean paramBoolean)
  {
    j localj = (j)getCurrentView();
    localj.b.setText(paramCharSequence);
    paramCharSequence = localj.a;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      paramCharSequence.setVisibility(i);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/viewex/CityNameSwitcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */