package com.ideashower.readitlater.views;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class SearchBarView
  extends RelativeLayout
{
  private SearchField a;
  private View b;
  
  public SearchBarView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public SearchBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public SearchBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903177, this, true);
    this.a = ((SearchField)findViewById(2131230965));
    this.b = findViewById(2131231133);
    paramContext = new RelativeLayout.LayoutParams(-1, (int)getResources().getDimension(2131296378));
    paramContext.addRule(10);
    setLayoutParams(paramContext);
  }
  
  public SearchField getField()
  {
    return this.a;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      this.b.setVisibility(8);
      return;
    }
    this.b.setVisibility(0);
    this.b.setClickable(true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/SearchBarView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */