package com.google.android.gms.internal;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;

public final class ck
  extends FrameLayout
  implements View.OnClickListener
{
  private final ImageButton oR;
  private final Activity og;
  
  public ck(Activity paramActivity, int paramInt)
  {
    super(paramActivity);
    this.og = paramActivity;
    setOnClickListener(this);
    this.oR = new ImageButton(paramActivity);
    this.oR.setImageResource(17301527);
    this.oR.setBackgroundColor(0);
    this.oR.setOnClickListener(this);
    this.oR.setPadding(0, 0, 0, 0);
    paramInt = et.a(paramActivity, paramInt);
    addView(this.oR, new FrameLayout.LayoutParams(paramInt, paramInt, 17));
  }
  
  public void j(boolean paramBoolean)
  {
    ImageButton localImageButton = this.oR;
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      localImageButton.setVisibility(i);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    this.og.finish();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */