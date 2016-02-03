package com.venticake.retrica.view.watermark;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.venticake.retrica.engine.a.b;

public class WatermarkSelectorButton
  extends FrameLayout
  implements View.OnTouchListener
{
  private final int BORDER_TYPE_HIGHLIGHTED = 1;
  private final int BORDER_TYPE_NORMAL = 0;
  private final int BORDER_TYPE_SELECTED = 2;
  private final int MARGIN_X_IN_DP = 5;
  private final int MARGIN_Y_IN_DP = 0;
  private int PACK_HEIGHT_IN_DP = 76;
  private int PACK_WIDTH_IN_DP = 76;
  private ImageView lockerImageView = null;
  private boolean mHighlighted = false;
  private int mIndex = -1;
  private boolean mSelected = false;
  private ImageView sampleImageView = null;
  private TextView titleTextView = null;
  private WaterMarkType type = WaterMarkType.BUNDLE_WATERMARK;
  
  public WatermarkSelectorButton(Context paramContext, b paramb, int paramInt)
  {
    this(paramContext, WaterMarkType.BUNDLE_WATERMARK);
    setDisplay(paramb);
    setPackIndex(paramInt);
    updateBorderColor();
  }
  
  public WatermarkSelectorButton(Context paramContext, WaterMarkType paramWaterMarkType)
  {
    super(paramContext);
    setOnTouchListener(this);
    setBackgroundColor(-1);
    int j;
    FrameLayout.LayoutParams localLayoutParams;
    switch (paramWaterMarkType)
    {
    default: 
      j = 0;
      localLayoutParams = new FrameLayout.LayoutParams(dp2px(j + 10), dp2px(i + 0));
      localLayoutParams.gravity = 17;
      setLayoutParams(localLayoutParams);
      setForegroundGravity(17);
      this.sampleImageView = new ImageView(paramContext);
      this.sampleImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      switch (paramWaterMarkType)
      {
      default: 
        localLayoutParams = null;
        label219:
        localLayoutParams.gravity = 17;
        this.sampleImageView.setLayoutParams(localLayoutParams);
        addView(this.sampleImageView);
        this.titleTextView = new TextView(paramContext);
        this.titleTextView.setGravity(17);
        switch (paramWaterMarkType)
        {
        }
        break;
      }
      break;
    }
    for (paramContext = (Context)localObject;; paramContext = paramWaterMarkType)
    {
      this.titleTextView.setLayoutParams(paramContext);
      addView(this.titleTextView);
      return;
      j = this.PACK_WIDTH_IN_DP;
      i = this.PACK_HEIGHT_IN_DP;
      break;
      localLayoutParams = new FrameLayout.LayoutParams(dp2px(j), dp2px(i));
      break label219;
      paramWaterMarkType = new FrameLayout.LayoutParams(-1, -1);
      setPackTitleTextViewAppearance(paramContext, this.titleTextView);
    }
  }
  
  private int dp2px(int paramInt)
  {
    return (int)(getResources().getDisplayMetrics().density * paramInt + 0.5F);
  }
  
  @SuppressLint({"NewApi"})
  private void setBorderColor(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramInt = 2130837934;
    }
    while (Build.VERSION.SDK_INT >= 16)
    {
      paramView.setBackground(getResources().getDrawable(paramInt));
      return;
      paramInt = 2130837918;
      continue;
      paramInt = 2130837979;
    }
    paramView.setBackgroundDrawable(getResources().getDrawable(paramInt));
  }
  
  private void updateBorderColor()
  {
    int i = 0;
    if (this.mHighlighted) {
      i = 1;
    }
    for (;;)
    {
      switch (this.type)
      {
      default: 
        return;
        if (this.mSelected) {
          i = 2;
        }
        break;
      }
    }
    setBorderColor(this.sampleImageView, i);
  }
  
  protected int getLockerTopMarginInDP()
  {
    return 0;
  }
  
  public int getPackHeightInDP()
  {
    return this.PACK_HEIGHT_IN_DP;
  }
  
  public int getPackIndex()
  {
    return this.mIndex;
  }
  
  public WaterMarkType getType()
  {
    return this.type;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return false;
    case 0: 
      setHighlighted(true);
      return false;
    }
    setHighlighted(false);
    return false;
  }
  
  public void setDisplay(b paramb)
  {
    this.type = WaterMarkType.BUNDLE_WATERMARK;
    this.titleTextView.setText(paramb.c());
    int i = getResources().getIdentifier(paramb.a(), "drawable", "com.venticake.retrica");
    setImageBitmap(BitmapFactory.decodeResource(getResources(), i));
  }
  
  public void setHighlighted(boolean paramBoolean)
  {
    this.mHighlighted = paramBoolean;
    updateBorderColor();
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.sampleImageView.setImageBitmap(paramBitmap);
  }
  
  protected void setLensTitleTextViewAppearance(Context paramContext, TextView paramTextView)
  {
    paramTextView.setTextAppearance(paramContext, 2131099798);
  }
  
  public void setLocked(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.lockerImageView == null)
      {
        this.lockerImageView = new ImageView(getContext());
        i = getResources().getIdentifier("ico_locker", "drawable", "com.venticake.retrica");
        this.lockerImageView.setImageResource(i);
        this.lockerImageView.setBackgroundColor(0);
        localLayoutParams = new FrameLayout.LayoutParams(-1, -2, 48);
        localLayoutParams.setMargins(0, dp2px(getLockerTopMarginInDP()), 0, 0);
        addView(this.lockerImageView, localLayoutParams);
      }
    }
    while (this.lockerImageView == null)
    {
      int i;
      FrameLayout.LayoutParams localLayoutParams;
      return;
    }
    this.lockerImageView.setImageResource(0);
    removeView(this.lockerImageView);
    this.lockerImageView = null;
  }
  
  public void setPackIndex(int paramInt)
  {
    this.mIndex = paramInt;
  }
  
  protected void setPackTitleTextViewAppearance(Context paramContext, TextView paramTextView)
  {
    paramTextView.setTextAppearance(paramContext, 2131099797);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    this.mSelected = paramBoolean;
    updateBorderColor();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/watermark/WatermarkSelectorButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */