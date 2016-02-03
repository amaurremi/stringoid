package com.magmamobile.game.engine;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public final class GameLayout
  extends RelativeLayout
{
  public GameLayout(Context paramContext)
  {
    super(paramContext);
    setBackgroundColor(-2130706688);
  }
  
  public static final class LayoutParams
    extends RelativeLayout.LayoutParams
  {
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public int getLeft()
    {
      return this.leftMargin;
    }
    
    public int getTop()
    {
      return this.topMargin;
    }
    
    public void setLeft(int paramInt)
    {
      this.leftMargin = paramInt;
    }
    
    public void setTop(int paramInt)
    {
      this.topMargin = paramInt;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/GameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */