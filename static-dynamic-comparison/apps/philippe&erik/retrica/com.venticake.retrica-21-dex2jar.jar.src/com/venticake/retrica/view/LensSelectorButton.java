package com.venticake.retrica.view;

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
import android.widget.LinearLayout;
import android.widget.TextView;
import com.venticake.retrica.engine.a.b;
import com.venticake.retrica.engine.a.g;

public class LensSelectorButton
  extends FrameLayout
  implements View.OnTouchListener
{
  public static final int BACK_BUTTON_HEIGHT_IN_DP = 50;
  public static final int BACK_BUTTON_MARGIN_Y_IN_DP = 13;
  public static final int BACK_BUTTON_WIDTH_IN_DP = 50;
  public static final int LENS_HEIGHT_IN_DP = 76;
  public static final int LENS_TEXT_HEIGHT_IN_DP = 28;
  public static final int LENS_WIDTH_IN_DP = 48;
  public static final int MARGIN_X_IN_DP = 5;
  public static final int MARGIN_Y_IN_DP = 0;
  public static final int PACK_HEIGHT_IN_DP = 76;
  public static final int PACK_WIDTH_IN_DP = 76;
  private final int BORDER_TYPE_HIGHLIGHTED = 1;
  private final int BORDER_TYPE_NORMAL = 0;
  private final int BORDER_TYPE_SELECTED = 2;
  private String lensID = null;
  private int lensIndex = -1;
  private LinearLayout linearLayout = null;
  private ImageView lockerImageView = null;
  private boolean mHighlighted = false;
  private boolean mSelected = false;
  private int packIndex = -1;
  private ImageView sampleImageView = null;
  private TextView titleTextView = null;
  private LensSelectorButton.LensSelectorButtonType type = LensSelectorButton.LensSelectorButtonType.Pack;
  
  public LensSelectorButton(Context paramContext)
  {
    this(paramContext, LensSelectorButton.LensSelectorButtonType.BackToPack);
  }
  
  public LensSelectorButton(Context paramContext, b paramb, int paramInt)
  {
    this(paramContext, LensSelectorButton.LensSelectorButtonType.Pack);
    setDisplay(paramb);
    setPackIndex(paramInt);
    setLensIndex(-1);
    updateBorderColor();
  }
  
  public LensSelectorButton(Context paramContext, g paramg, int paramInt1, int paramInt2)
  {
    this(paramContext, LensSelectorButton.LensSelectorButtonType.Lens);
    setDisplay(paramg);
    setPackIndex(paramInt2);
    setLensIndex(paramInt1);
    updateBorderColor();
  }
  
  public LensSelectorButton(Context paramContext, LensSelectorButton.LensSelectorButtonType paramLensSelectorButtonType)
  {
    super(paramContext);
    setOnTouchListener(this);
    setBackgroundColor(-1);
    int i;
    int j;
    FrameLayout.LayoutParams localLayoutParams;
    switch (paramLensSelectorButtonType)
    {
    default: 
      i = 0;
      j = 0;
      localLayoutParams = new FrameLayout.LayoutParams(dp2px(j + 10), dp2px(k * 2 + i));
      localLayoutParams.gravity = 17;
      setLayoutParams(localLayoutParams);
      setForegroundGravity(17);
      if (paramLensSelectorButtonType == LensSelectorButton.LensSelectorButtonType.Lens)
      {
        localLayoutParams = new FrameLayout.LayoutParams(dp2px(j), dp2px(i));
        localLayoutParams.gravity = 17;
        this.linearLayout = new LinearLayout(paramContext);
        this.linearLayout.setOrientation(1);
        this.linearLayout.setLayoutParams(localLayoutParams);
        addView(this.linearLayout);
      }
      break;
    }
    for (Object localObject1 = this.linearLayout;; localObject1 = this)
    {
      this.sampleImageView = new ImageView(paramContext);
      this.sampleImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      switch (paramLensSelectorButtonType)
      {
      default: 
        localLayoutParams = null;
      }
      for (;;)
      {
        localLayoutParams.gravity = 17;
        this.sampleImageView.setLayoutParams(localLayoutParams);
        ((ViewGroup)localObject1).addView(this.sampleImageView);
        if (paramLensSelectorButtonType != LensSelectorButton.LensSelectorButtonType.BackToPack) {
          break label471;
        }
        this.titleTextView = null;
        return;
        j = getPackWidthInDP();
        i = getPackHeightInDP();
        break;
        j = getLensWidthInDP();
        i = getLensHeightInDP();
        break;
        j = getBackButtonWidthInDP();
        i = getBackButtonHeightInDP();
        k = getBackButtonMarginYInDP();
        break;
        localLayoutParams = new FrameLayout.LayoutParams(dp2px(j), dp2px(i));
        continue;
        localLayoutParams = new FrameLayout.LayoutParams(dp2px(j), dp2px(i - getLensTextHeightInDP()));
        continue;
        localLayoutParams = new FrameLayout.LayoutParams(dp2px(j), dp2px(i));
      }
      label471:
      this.titleTextView = new TextView(paramContext);
      this.titleTextView.setGravity(17);
      switch (paramLensSelectorButtonType)
      {
      default: 
        paramContext = (Context)localObject2;
      }
      for (;;)
      {
        this.titleTextView.setLayoutParams(paramContext);
        ((ViewGroup)localObject1).addView(this.titleTextView);
        return;
        paramLensSelectorButtonType = new FrameLayout.LayoutParams(-1, -1);
        setPackTitleTextViewAppearance(paramContext, this.titleTextView);
        paramContext = paramLensSelectorButtonType;
        continue;
        paramLensSelectorButtonType = new FrameLayout.LayoutParams(-1, dp2px(getLensTextHeightInDP()));
        paramLensSelectorButtonType.gravity = 81;
        setLensTitleTextViewAppearance(paramContext, this.titleTextView);
        paramContext = paramLensSelectorButtonType;
      }
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
    return;
    setBorderColor(this.linearLayout, i);
    return;
    setBorderColor(this.sampleImageView, i);
  }
  
  protected int getBackButtonHeightInDP()
  {
    return 50;
  }
  
  protected int getBackButtonMarginYInDP()
  {
    return 13;
  }
  
  protected int getBackButtonWidthInDP()
  {
    return 50;
  }
  
  protected int getLensHeightInDP()
  {
    return 76;
  }
  
  public String getLensID()
  {
    return this.lensID;
  }
  
  public int getLensIndex()
  {
    return this.lensIndex;
  }
  
  protected int getLensTextHeightInDP()
  {
    return 28;
  }
  
  protected int getLensWidthInDP()
  {
    return 48;
  }
  
  protected int getLockerTopMarginInDP()
  {
    return 0;
  }
  
  protected int getPackHeightInDP()
  {
    return 76;
  }
  
  public int getPackIndex()
  {
    return this.packIndex;
  }
  
  protected int getPackWidthInDP()
  {
    return 76;
  }
  
  public LensSelectorButton.LensSelectorButtonType getType()
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
  
  public void setAsBackButtonWithPackIndex(int paramInt)
  {
    setPackIndex(paramInt);
    setLensIndex(-1);
    this.type = LensSelectorButton.LensSelectorButtonType.BackToPack;
    paramInt = getResources().getIdentifier("btn_back_packs", "drawable", "com.venticake.retrica");
    setImageBitmap(BitmapFactory.decodeResource(getResources(), paramInt));
    updateBorderColor();
  }
  
  public void setDisplay(b paramb)
  {
    this.type = LensSelectorButton.LensSelectorButtonType.Pack;
    this.titleTextView.setText(paramb.c());
    int i = getResources().getIdentifier(paramb.a(), "drawable", "com.venticake.retrica");
    setImageBitmap(BitmapFactory.decodeResource(getResources(), i));
  }
  
  public void setDisplay(g paramg)
  {
    this.type = LensSelectorButton.LensSelectorButtonType.Lens;
    this.titleTextView.setText(paramg.x());
    this.titleTextView.setBackgroundColor(paramg.C());
    int i = getResources().getIdentifier(paramg.a(), "drawable", "com.venticake.retrica");
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
  
  public void setLensID(String paramString)
  {
    this.lensID = paramString;
  }
  
  public void setLensIndex(int paramInt)
  {
    this.lensIndex = paramInt;
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
    this.packIndex = paramInt;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/LensSelectorButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */