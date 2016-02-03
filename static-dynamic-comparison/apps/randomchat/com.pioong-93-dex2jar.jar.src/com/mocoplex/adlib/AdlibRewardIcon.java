package com.mocoplex.adlib;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;

public class AdlibRewardIcon
{
  public static final int ALIGN_LEFT_BOTTOM = 3;
  public static final int ALIGN_LEFT_TOP = 1;
  public static final int ALIGN_RIGHT_BOTTOM = 4;
  public static final int ALIGN_RIGHT_TOP = 2;
  private int _height;
  private int _width;
  public AnimationDrawable animation = null;
  public boolean bShowIcon = false;
  public int iconAlign = 1;
  public View iconFrame = null;
  public String iconId = null;
  public int iconX = 0;
  public int iconY = 0;
  public String rLinkId = null;
  
  public int getHeight()
  {
    return this._height;
  }
  
  public int getWidth()
  {
    return this._width;
  }
  
  public void setIconSize(int paramInt1, int paramInt2)
  {
    this._width = paramInt1;
    this._height = paramInt2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mocoplex/adlib/AdlibRewardIcon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */