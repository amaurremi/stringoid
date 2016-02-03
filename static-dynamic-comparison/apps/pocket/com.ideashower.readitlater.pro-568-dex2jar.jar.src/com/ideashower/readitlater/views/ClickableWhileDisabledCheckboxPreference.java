package com.ideashower.readitlater.views;

import android.content.Context;
import android.preference.CheckBoxPreference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.a.m;

public class ClickableWhileDisabledCheckboxPreference
  extends CheckBoxPreference
{
  private boolean mEnabledView = true;
  
  public ClickableWhileDisabledCheckboxPreference(Context paramContext)
  {
    super(paramContext);
  }
  
  public ClickableWhileDisabledCheckboxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ClickableWhileDisabledCheckboxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void enableView(View paramView, boolean paramBoolean)
  {
    try
    {
      paramView.setEnabled(paramBoolean);
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int i = 0;
        while (i < paramView.getChildCount())
        {
          enableView(paramView.getChildAt(i), paramBoolean);
          i += 1;
        }
      }
      return;
    }
    catch (Throwable paramView)
    {
      g.s().b(paramView);
      setEnabled(paramBoolean);
    }
  }
  
  protected void onBindView(View paramView)
  {
    super.onBindView(paramView);
    if ((this.mEnabledView) && (isEnabled())) {}
    for (boolean bool = true;; bool = false)
    {
      enableView(paramView, bool);
      return;
    }
  }
  
  public void setViewEnabled(boolean paramBoolean)
  {
    this.mEnabledView = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/ClickableWhileDisabledCheckboxPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */