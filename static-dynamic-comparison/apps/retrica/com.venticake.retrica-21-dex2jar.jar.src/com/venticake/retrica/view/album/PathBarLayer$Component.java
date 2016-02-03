package com.venticake.retrica.view.album;

import android.graphics.Typeface;

final class PathBarLayer$Component
{
  private static final float ICON_WIDTH = 38.0F;
  public Runnable action;
  public float animWidth;
  public int[] animatedIcons;
  public int icon;
  public String origString;
  public StringTexture texture;
  public float timeElapsed;
  public float width;
  public float x;
  
  PathBarLayer$Component(int paramInt, String paramString, Runnable paramRunnable, float paramFloat)
  {
    this.action = paramRunnable;
    this.origString = paramString;
    this.icon = paramInt;
    computeLabel(paramFloat);
  }
  
  public final void computeLabel(float paramFloat)
  {
    String str;
    if (PathBarLayer.access$0().bold)
    {
      localObject = Typeface.DEFAULT_BOLD;
      if (this.origString == null) {
        break label103;
      }
      str = this.origString.substring(0, StringTexture.lengthToFit(PathBarLayer.access$0().fontSize, paramFloat, (Typeface)localObject, this.origString));
      localObject = str;
      if (str.length() == this.origString.length()) {}
    }
    label103:
    for (Object localObject = str + "...";; localObject = "")
    {
      this.texture = new StringTexture((String)localObject, PathBarLayer.access$0());
      return;
      localObject = Typeface.DEFAULT;
      break;
    }
  }
  
  public float getIconWidth()
  {
    return 38.0F * Gallery.PIXEL_DENSITY;
  }
  
  public final boolean update(float paramFloat)
  {
    this.timeElapsed += paramFloat;
    if (this.animWidth == 0.0F) {
      this.animWidth = this.width;
    }
    this.animWidth = FloatUtils.animate(this.animWidth, this.width, paramFloat);
    if ((this.animatedIcons != null) && (this.animatedIcons.length > 1)) {}
    while (this.animWidth != this.width) {
      return true;
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/PathBarLayer$Component.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */