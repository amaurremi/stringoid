package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.view.View;
import android.widget.MediaController;

public class cf
  extends MediaController
{
  private final String a = getClass().getSimpleName();
  private n b;
  private o c;
  
  public cf(Context paramContext, n paramn, o paramo)
  {
    super(paramContext);
    this.b = paramn;
    this.c = paramo;
  }
  
  public void setAnchorView(View paramView)
  {
    super.setAnchorView(paramView);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */