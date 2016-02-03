package com.magmamobile.game.engine;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public abstract class AdLayout
  extends LinearLayout
{
  protected AdType adType;
  protected boolean hooked;
  protected GameLayout.LayoutParams lParams;
  protected int marginLeft;
  protected int marginTop;
  protected int[] rules = new int[20];
  protected int theoricalHeight;
  protected int theoricalWidth;
  protected boolean visible;
  
  public AdLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AdLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void addRule(int paramInt)
  {
    this.rules[paramInt] = 1;
  }
  
  public void addRule(int paramInt1, int paramInt2)
  {
    this.rules[paramInt1] = paramInt2;
  }
  
  public int getMarginLeft()
  {
    return this.marginLeft;
  }
  
  public int getMarginTop()
  {
    return this.marginTop;
  }
  
  public int getPixelHeight()
  {
    return (int)(this.theoricalHeight * Game.density * Game.mMulRatioY);
  }
  
  public int getPixelLeft()
  {
    return (int)(this.lParams.getLeft() * Game.mMulRatioX);
  }
  
  public int getPixelTop()
  {
    return (int)(this.lParams.getTop() * Game.mMulRatioY);
  }
  
  public int getPixelWidth()
  {
    return (int)(this.theoricalWidth * Game.density * Game.mMulRatioX);
  }
  
  public int[] getRules()
  {
    return this.rules;
  }
  
  public int getTheoricalDpiHeight()
  {
    return (int)(this.theoricalHeight * Game.density);
  }
  
  public int getTheoricalDpiWidth()
  {
    return (int)(this.theoricalWidth * Game.density);
  }
  
  public int getTheoricalHeight()
  {
    return this.theoricalHeight;
  }
  
  public int getTheoricalWidth()
  {
    return this.theoricalWidth;
  }
  
  public AdType getType()
  {
    return this.adType;
  }
  
  public void hide()
  {
    this.visible = false;
    Game.getHandler().hideAds(this);
  }
  
  public boolean isVisible()
  {
    return this.visible;
  }
  
  public void onCreate() {}
  
  public void onDestroy() {}
  
  protected void onHideCallback()
  {
    try
    {
      setVisibility(8);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  protected void onShowCallback()
  {
    try
    {
      setVisibility(0);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onStart() {}
  
  public void onStop() {}
  
  public void removeRule(int paramInt)
  {
    this.rules[paramInt] = 0;
  }
  
  public void setMarginLeft(int paramInt)
  {
    this.marginLeft = paramInt;
  }
  
  public void setMarginTop(int paramInt)
  {
    this.marginTop = paramInt;
  }
  
  public void show()
  {
    this.visible = true;
    Game.getHandler().showAds(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/AdLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */