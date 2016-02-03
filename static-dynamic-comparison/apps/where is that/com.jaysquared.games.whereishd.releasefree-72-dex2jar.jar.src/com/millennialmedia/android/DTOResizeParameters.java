package com.millennialmedia.android;

class DTOResizeParameters
{
  boolean allowOffScreen;
  String customClosePosition;
  int height;
  int offsetX;
  int offsetY;
  int width;
  int xMax;
  int yMax;
  
  DTOResizeParameters(float paramFloat, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6)
  {
    this.width = ((int)(paramInt1 * paramFloat));
    this.height = ((int)(paramInt2 * paramFloat));
    this.customClosePosition = paramString;
    this.offsetX = ((int)(paramInt3 * paramFloat));
    this.offsetY = ((int)(paramInt4 * paramFloat));
    this.allowOffScreen = paramBoolean;
    this.xMax = paramInt5;
    this.yMax = paramInt6;
  }
  
  public String toString()
  {
    return String.format("width[%d] height[%d] offsetX[%d] offsetY[%d] allowOffScreen[%b] customClosePosition[%s] maxX[%d] maxY[%d]", new Object[] { Integer.valueOf(this.width), Integer.valueOf(this.height), Integer.valueOf(this.offsetX), Integer.valueOf(this.offsetY), Boolean.valueOf(this.allowOffScreen), this.customClosePosition, Integer.valueOf(this.xMax), Integer.valueOf(this.yMax) });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/millennialmedia/android/DTOResizeParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */