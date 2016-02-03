package com.google.android.gms.internal;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;

public final class bp
  extends FrameLayout
  implements View.OnClickListener
{
  private final ImageButton gZ;
  private final Activity gs;
  
  public bp(Activity paramActivity, int paramInt)
  {
    super(paramActivity);
    this.gs = paramActivity;
    setOnClickListener(this);
    this.gZ = new ImageButton(paramActivity);
    this.gZ.setImageResource(17301527);
    this.gZ.setBackgroundColor(0);
    this.gZ.setOnClickListener(this);
    this.gZ.setPadding(0, 0, 0, 0);
    paramInt = cs.a(paramActivity, paramInt);
    addView(this.gZ, new FrameLayout.LayoutParams(paramInt, paramInt, 17));
  }
  
  public void g(boolean paramBoolean)
  {
    ImageButton localImageButton = this.gZ;
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      localImageButton.setVisibility(i);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    this.gs.finish();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */