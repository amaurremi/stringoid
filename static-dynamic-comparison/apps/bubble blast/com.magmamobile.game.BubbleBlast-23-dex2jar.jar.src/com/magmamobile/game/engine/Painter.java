package com.magmamobile.game.engine;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;

public class Painter
{
  private Rect bounds = new Rect();
  private Paint.Align fontAlign;
  private int fontAlpha;
  private boolean fontBold = false;
  private int fontColor = Game.parameters.DEFAULT_BUTTON_TEXT_COLOR;
  private Typeface fontFace = Game.typeface;
  private int fontGradient1 = 0;
  private int fontGradient2 = 0;
  private float fontSize = Game.parameters.DEFAULT_BUTTON_TEXT_SIZE;
  private Paint pFill = new Paint();
  private Paint pShadow;
  private Paint pStroke;
  private int shadowColor = 0;
  private float shadowDx = 0.0F;
  private float shadowDy = 0.0F;
  private float shadowRadius = 0.0F;
  private int strokeColor = 0;
  private float strokeWidth = 0.0F;
  private boolean useGradient = false;
  
  public Painter()
  {
    this.pFill.setAntiAlias(true);
    this.pFill.setColor(this.fontColor);
    this.pFill.setTextSize(this.fontSize);
    this.pFill.setFilterBitmap(true);
    this.pFill.setStyle(Paint.Style.FILL);
    this.pFill.setFakeBoldText(this.fontBold);
    this.pFill.setTypeface(this.fontFace);
    this.pFill.setShadowLayer(this.shadowRadius, this.shadowDx, this.shadowDy, this.shadowColor);
    this.pStroke = new Paint();
    this.pStroke.setAntiAlias(true);
    this.pStroke.setColor(this.strokeColor);
    this.pStroke.setTextSize(this.fontSize);
    this.pStroke.setFilterBitmap(true);
    if (Game.androidSDKVersion >= 19) {
      this.pStroke.setStyle(Paint.Style.FILL_AND_STROKE);
    }
    for (;;)
    {
      this.pStroke.setFakeBoldText(this.fontBold);
      this.pStroke.setTypeface(this.fontFace);
      this.pStroke.setStrokeWidth(this.strokeWidth);
      this.pShadow = new Paint();
      this.pShadow.setAntiAlias(true);
      this.pShadow.setColor(0);
      this.pShadow.setTextSize(this.fontSize);
      this.pShadow.setFilterBitmap(true);
      this.pShadow.setStyle(Paint.Style.FILL);
      this.pShadow.setFakeBoldText(this.fontBold);
      this.pShadow.setTypeface(this.fontFace);
      return;
      this.pStroke.setStyle(Paint.Style.STROKE);
    }
  }
  
  public void draw(String paramString, float paramFloat1, float paramFloat2)
  {
    if (this.shadowColor != 0) {
      Game.mCanvas.drawText(paramString, paramFloat1, paramFloat2, this.pShadow);
    }
    if (this.strokeWidth > 0.0F) {
      Game.mCanvas.drawText(paramString, paramFloat1, paramFloat2, this.pStroke);
    }
    if (this.useGradient) {
      this.pFill.setShader(new LinearGradient(0.0F, paramFloat2 - this.pFill.getTextSize(), 0.0F, paramFloat2, this.fontGradient1, this.fontGradient2, Shader.TileMode.CLAMP));
    }
    Game.mCanvas.drawText(paramString, paramFloat1, paramFloat2, this.pFill);
  }
  
  public int getAlpha()
  {
    return this.fontAlpha;
  }
  
  public Paint getFillPaint()
  {
    return this.pFill;
  }
  
  public Paint.Align getFontAlign()
  {
    return this.fontAlign;
  }
  
  public boolean getFontBold()
  {
    return this.fontBold;
  }
  
  public int getFontColor()
  {
    return this.fontColor;
  }
  
  public Typeface getFontFace()
  {
    return this.fontFace;
  }
  
  public float getFontSize()
  {
    return this.fontSize;
  }
  
  public int getGradient1()
  {
    return this.fontGradient1;
  }
  
  public int getGradient2()
  {
    return this.fontGradient2;
  }
  
  public int getShadowColor()
  {
    return this.shadowColor;
  }
  
  public float getShadowDx()
  {
    return this.shadowDx;
  }
  
  public float getShadowDy()
  {
    return this.shadowDy;
  }
  
  public float getShadowRadius()
  {
    return this.shadowRadius;
  }
  
  public int getStrokeColor()
  {
    return this.strokeColor;
  }
  
  public float getStrokeWidth()
  {
    return this.strokeWidth;
  }
  
  public Rect getTextBounds(String paramString)
  {
    this.pFill.getTextBounds(paramString, 0, paramString.length(), this.bounds);
    return this.bounds;
  }
  
  public void getTextBounds(String paramString, int paramInt1, int paramInt2, Rect paramRect)
  {
    this.pFill.getTextBounds(paramString, paramInt1, paramInt2, paramRect);
  }
  
  public float getTextSize()
  {
    return this.pFill.getTextSize();
  }
  
  public int getTextWidth(String paramString)
  {
    this.pFill.getTextBounds(paramString, 0, paramString.length(), this.bounds);
    return this.bounds.right - this.bounds.left;
  }
  
  public boolean getUseGradient()
  {
    return this.useGradient;
  }
  
  public void setAlpha(int paramInt)
  {
    if (this.fontAlpha != paramInt)
    {
      this.pFill.setAlpha(paramInt);
      this.pStroke.setAlpha(paramInt);
      this.pShadow.setAlpha(paramInt);
      this.fontAlpha = paramInt;
    }
  }
  
  public void setFontAlign(Paint.Align paramAlign)
  {
    if (this.fontAlign != paramAlign)
    {
      this.pFill.setTextAlign(paramAlign);
      this.pStroke.setTextAlign(paramAlign);
      this.pShadow.setTextAlign(paramAlign);
      this.fontAlign = paramAlign;
    }
  }
  
  public void setFontBold(boolean paramBoolean)
  {
    if (this.fontBold != paramBoolean)
    {
      this.pFill.setFakeBoldText(paramBoolean);
      this.pStroke.setFakeBoldText(paramBoolean);
      this.pShadow.setFakeBoldText(paramBoolean);
      this.fontBold = paramBoolean;
    }
  }
  
  public void setFontColor(int paramInt)
  {
    if (this.fontColor != paramInt)
    {
      this.fontColor = paramInt;
      this.pFill.setColor(this.fontColor);
    }
  }
  
  public void setFontFace(Typeface paramTypeface)
  {
    if (this.fontFace != paramTypeface)
    {
      this.pFill.setTypeface(paramTypeface);
      this.pStroke.setTypeface(paramTypeface);
      this.pShadow.setTypeface(paramTypeface);
      this.fontFace = paramTypeface;
    }
  }
  
  public void setFontSize(float paramFloat)
  {
    if (this.fontSize != paramFloat)
    {
      this.pFill.setTextSize(paramFloat);
      this.pStroke.setTextSize(paramFloat);
      this.pShadow.setTextSize(paramFloat);
      this.fontSize = paramFloat;
    }
  }
  
  public void setGradient1(int paramInt)
  {
    this.fontGradient1 = paramInt;
  }
  
  public void setGradient2(int paramInt)
  {
    this.fontGradient2 = paramInt;
  }
  
  public void setShadowColor(int paramInt)
  {
    if (this.shadowColor != paramInt)
    {
      this.shadowColor = paramInt;
      this.pShadow.setColor(this.shadowColor);
      this.pShadow.setShadowLayer(this.shadowRadius, this.shadowDx, this.shadowDy, this.shadowColor);
    }
  }
  
  public void setShadowDensity(float paramFloat)
  {
    this.pShadow.setStyle(Paint.Style.FILL_AND_STROKE);
    this.pShadow.setStrokeWidth(paramFloat);
  }
  
  public void setShadowDx(float paramFloat)
  {
    if (this.shadowDx != paramFloat)
    {
      this.shadowDx = paramFloat;
      this.pShadow.setShadowLayer(this.shadowRadius, this.shadowDx, this.shadowDy, this.shadowColor);
    }
  }
  
  public void setShadowDy(float paramFloat)
  {
    if (this.shadowDy != paramFloat)
    {
      this.shadowDy = paramFloat;
      this.pShadow.setShadowLayer(this.shadowRadius, this.shadowDx, this.shadowDy, this.shadowColor);
    }
  }
  
  public void setShadowRadius(float paramFloat)
  {
    if (this.shadowRadius != paramFloat)
    {
      this.shadowRadius = paramFloat;
      this.pShadow.setShadowLayer(this.shadowRadius, this.shadowDx, this.shadowDy, this.shadowColor);
    }
  }
  
  public void setStrokeColor(int paramInt)
  {
    if (this.strokeColor != paramInt)
    {
      this.strokeColor = paramInt;
      this.pStroke.setColor(this.strokeColor);
    }
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    if (this.strokeWidth != paramFloat)
    {
      this.strokeWidth = paramFloat;
      this.pStroke.setStrokeWidth(this.strokeWidth);
    }
  }
  
  public void setUseGradient(boolean paramBoolean)
  {
    if ((this.useGradient) && (!paramBoolean)) {
      this.pFill.setShader(null);
    }
    this.useGradient = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/Painter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */