package com.google.android.gms.internal;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;

public final class bt
  extends FrameLayout
  implements View.OnClickListener
{
  private final Activity Cy;
  private final ImageButton Dj;
  
  public bt(Activity paramActivity, int paramInt)
  {
    super(paramActivity);
    this.Cy = paramActivity;
    setOnClickListener(this);
    this.Dj = new ImageButton(paramActivity);
    this.Dj.setImageResource(17301527);
    this.Dj.setBackgroundColor(0);
    this.Dj.setOnClickListener(this);
    this.Dj.setPadding(0, 0, 0, 0);
    paramInt = cb.b(paramActivity, paramInt);
    addView(this.Dj, new FrameLayout.LayoutParams(paramInt, paramInt, 17));
  }
  
  public void onClick(View paramView)
  {
    this.Cy.finish();
  }
  
  public void x(boolean paramBoolean)
  {
    ImageButton localImageButton = this.Dj;
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      localImageButton.setVisibility(i);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */