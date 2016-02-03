package com.google.android.gms.internal;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;

public final class cl
  extends FrameLayout
  implements View.OnClickListener
{
  private final ImageButton oP;
  private final Activity oe;
  
  public cl(Activity paramActivity, int paramInt)
  {
    super(paramActivity);
    this.oe = paramActivity;
    setOnClickListener(this);
    this.oP = new ImageButton(paramActivity);
    this.oP.setImageResource(17301527);
    this.oP.setBackgroundColor(0);
    this.oP.setOnClickListener(this);
    this.oP.setPadding(0, 0, 0, 0);
    paramInt = eu.a(paramActivity, paramInt);
    addView(this.oP, new FrameLayout.LayoutParams(paramInt, paramInt, 17));
  }
  
  public void j(boolean paramBoolean)
  {
    ImageButton localImageButton = this.oP;
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      localImageButton.setVisibility(i);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    this.oe.finish();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/cl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */