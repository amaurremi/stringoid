package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.chartboost.sdk.CBPreferences;

public final class s
  extends LinearLayout
  implements t.a
{
  private TextView a;
  private u b;
  private v c;
  
  public s(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setGravity(17);
    this.a = new TextView(getContext());
    this.a.setTextColor(-1);
    this.a.setTextSize(2, 16.0F);
    this.a.setTypeface(null, 1);
    this.a.setText("Loading...");
    this.a.setGravity(17);
    this.b = new u(paramContext, this.a);
    this.c = new v(getContext());
    addView(this.b);
    addView(this.c);
    a();
  }
  
  public void a()
  {
    removeView(this.b);
    removeView(this.c);
    float f = getContext().getResources().getDisplayMetrics().density;
    int i = Math.round(20.0F * f);
    Object localObject = CBPreferences.getInstance().getForcedOrientationDifference();
    switch (1.a[localObject.ordinal()])
    {
    default: 
      setOrientation(1);
      localObject = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject).setMargins(i, i, i, 0);
      addView(this.b, (ViewGroup.LayoutParams)localObject);
      localObject = new LinearLayout.LayoutParams(-1, Math.round(f * 32.0F));
      ((LinearLayout.LayoutParams)localObject).setMargins(i, i, i, i);
      addView(this.c, (ViewGroup.LayoutParams)localObject);
      return;
    case 1: 
      setOrientation(0);
      localObject = new LinearLayout.LayoutParams(Math.round(f * 32.0F), -1);
      ((LinearLayout.LayoutParams)localObject).setMargins(i, i, 0, i);
      addView(this.c, (ViewGroup.LayoutParams)localObject);
      localObject = new LinearLayout.LayoutParams(-2, -1);
      ((LinearLayout.LayoutParams)localObject).setMargins(i, i, i, i);
      addView(this.b, (ViewGroup.LayoutParams)localObject);
      return;
    case 2: 
      setOrientation(1);
      localObject = new LinearLayout.LayoutParams(-1, Math.round(f * 32.0F));
      ((LinearLayout.LayoutParams)localObject).setMargins(i, i, i, 0);
      addView(this.c, (ViewGroup.LayoutParams)localObject);
      localObject = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject).setMargins(i, i, i, i);
      addView(this.b, (ViewGroup.LayoutParams)localObject);
      return;
    }
    setOrientation(0);
    localObject = new LinearLayout.LayoutParams(-2, -1);
    ((LinearLayout.LayoutParams)localObject).setMargins(i, i, 0, i);
    addView(this.b, (ViewGroup.LayoutParams)localObject);
    localObject = new LinearLayout.LayoutParams(Math.round(f * 32.0F), -1);
    ((LinearLayout.LayoutParams)localObject).setMargins(i, i, i, i);
    addView(this.c, (ViewGroup.LayoutParams)localObject);
  }
  
  public View b()
  {
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */