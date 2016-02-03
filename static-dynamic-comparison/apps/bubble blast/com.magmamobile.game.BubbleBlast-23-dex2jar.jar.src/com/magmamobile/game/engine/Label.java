package com.magmamobile.game.engine;

import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import java.util.StringTokenizer;

public class Label
  extends GameObject
{
  private boolean _autoSize = false;
  private byte _hAlign = 0;
  private int _innerHeight;
  private int _innerWidth;
  private int _interline = Game.scalei(4);
  private int _maxHeight;
  protected int _maxLines = 10;
  private int _maxWidth;
  private int _minHeight;
  private int _minWidth;
  private Painter _painter = new Painter();
  private StringParcel[] _parcels;
  private LabelShader _shader;
  private String _text;
  private byte _vAlign = 0;
  private boolean _wordWrap = false;
  
  public Label()
  {
    this.visible = true;
    this.enabled = true;
  }
  
  public Label(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    this();
    setX(paramInt1);
    setY(paramInt2);
    setW(paramInt3);
    setH(paramInt4);
    setText(paramString);
  }
  
  public Label(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5)
  {
    this(paramInt1, paramInt2, paramInt3, paramInt4, paramString);
    setHorizontalAlign((byte)paramInt5);
  }
  
  private void computeHorizontalOfs()
  {
    int j = this._parcels.length;
    switch (this._hAlign)
    {
    }
    for (;;)
    {
      return;
      int i = 0;
      StringParcel localStringParcel;
      while (i < j)
      {
        localStringParcel = this._parcels[i];
        localStringParcel.ofsX = (this.cw - localStringParcel.width / 2);
        i += 1;
      }
      continue;
      i = 0;
      while (i < j)
      {
        this._parcels[i].ofsX = 0;
        i += 1;
      }
      continue;
      i = 0;
      while (i < j)
      {
        localStringParcel = this._parcels[i];
        localStringParcel.ofsX = (this.w - localStringParcel.width);
        i += 1;
      }
    }
  }
  
  private void computeParcelBounds(Painter paramPainter)
  {
    int j = this._parcels.length;
    this._minWidth = Integer.MAX_VALUE;
    this._minHeight = Integer.MAX_VALUE;
    this._maxWidth = Integer.MIN_VALUE;
    this._maxHeight = Integer.MIN_VALUE;
    this._innerHeight = 0;
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        this._innerWidth = this._maxWidth;
        return;
      }
      StringParcel localStringParcel = this._parcels[i];
      localStringParcel.computeBounds(paramPainter);
      if (this._minWidth > localStringParcel.width) {
        this._minWidth = localStringParcel.width;
      }
      if (this._minHeight > localStringParcel.height) {
        this._minHeight = localStringParcel.height;
      }
      if (this._maxWidth < localStringParcel.width) {
        this._maxWidth = localStringParcel.width;
      }
      if (this._maxHeight < localStringParcel.height) {
        this._maxHeight = localStringParcel.height;
      }
      if (j > 0) {
        this._innerHeight += this._interline;
      }
      this._innerHeight += localStringParcel.height;
      i += 1;
    }
  }
  
  private void computeVerticalOfs()
  {
    int m = this._parcels.length;
    int i = 0;
    int k = 0;
    int j = 0;
    switch (this._vAlign)
    {
    }
    for (;;)
    {
      return;
      i = 0;
      StringParcel localStringParcel;
      while (i < m)
      {
        localStringParcel = this._parcels[i];
        localStringParcel.ofsY = (this.ch + j - this._innerHeight / 2 + (localStringParcel.height - localStringParcel.bounds.bottom));
        j += localStringParcel.height + this._interline;
        i += 1;
      }
      continue;
      k = 0;
      j = i;
      i = k;
      while (i < m)
      {
        localStringParcel = this._parcels[i];
        localStringParcel.ofsY = (localStringParcel.height - localStringParcel.bounds.bottom + j);
        j += localStringParcel.height + this._interline;
        i += 1;
      }
      continue;
      i = 0;
      j = k;
      while (i < m)
      {
        localStringParcel = this._parcels[i];
        localStringParcel.ofsY = (this.h + j - this._innerHeight + (localStringParcel.height - localStringParcel.bounds.bottom));
        j += localStringParcel.height + this._interline;
        i += 1;
      }
    }
  }
  
  public static Paint createLabelPaint(float paramFloat, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return createLabelPaint(paramFloat, paramInt, paramBoolean1, paramBoolean2, paramBoolean3, 0.0F);
  }
  
  public static Paint createLabelPaint(float paramFloat1, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, float paramFloat2)
  {
    Paint localPaint = new Paint();
    localPaint.setTextSize(paramFloat1);
    localPaint.setAntiAlias(true);
    localPaint.setFilterBitmap(true);
    localPaint.setFakeBoldText(paramBoolean1);
    localPaint.setTypeface(Game.typeface);
    if (paramBoolean2) {
      localPaint.setTextAlign(Paint.Align.CENTER);
    }
    for (;;)
    {
      if (paramBoolean3) {
        localPaint.setShadowLayer(Game.scalef(3.0F), Game.scalef(1.0F), Game.scalef(1.0F), Integer.MIN_VALUE);
      }
      localPaint.setColor(paramInt);
      if (paramFloat2 != 0.0F)
      {
        localPaint.setStyle(Paint.Style.STROKE);
        localPaint.setStrokeWidth(paramFloat2);
      }
      return localPaint;
      localPaint.setTextAlign(Paint.Align.LEFT);
    }
  }
  
  private void drawWordWrap()
  {
    StringTokenizer localStringTokenizer = new StringTokenizer(this._text, " ,:;.", true);
    float f = this._painter.getTextSize();
    String[] arrayOfString = new String[this._maxLines];
    int[] arrayOfInt = new int[this._maxLines];
    int i = 0;
    arrayOfString[0] = "";
    label57:
    int j;
    if (!localStringTokenizer.hasMoreTokens())
    {
      if (this._hAlign != 1) {
        break label231;
      }
      j = 0;
      label67:
      if (j <= i) {
        break label194;
      }
    }
    for (;;)
    {
      return;
      String str = localStringTokenizer.nextToken();
      j = this._painter.getTextWidth(arrayOfString[i] + str);
      if (j > this.w)
      {
        arrayOfString[(i + 1)] = str;
        arrayOfInt[(i + 1)] = this._painter.getTextWidth(str);
        j = i + 1;
        i = j;
        if (j < this._maxLines) {
          break;
        }
        i = j;
        break label57;
      }
      arrayOfString[i] = (arrayOfString[i] + str);
      arrayOfInt[i] = j;
      break;
      label194:
      this._painter.draw(arrayOfString[j], (int)this.x, (int)((int)this.y + j * f));
      j += 1;
      break label67;
      label231:
      if (this._hAlign == 0)
      {
        j = 0;
        while (j <= i)
        {
          this._painter.draw(arrayOfString[j], (int)this.x + this.cw - arrayOfInt[j] / 2, (int)((int)this.y + j * f));
          j += 1;
        }
      }
      else if (this._hAlign == 2)
      {
        j = 0;
        while (j <= i)
        {
          this._painter.draw(arrayOfString[j], (int)this.x + this.cw - arrayOfInt[j], (int)((int)this.y + j * f));
          j += 1;
        }
      }
    }
  }
  
  public static Paint getDefaultPaint()
  {
    AppParameters localAppParameters = Game.getParameters();
    return createLabelPaint(localAppParameters.DEFAULT_BUTTON_TEXT_SIZE, localAppParameters.DEFAULT_BUTTON_TEXT_COLOR, false, true, false);
  }
  
  @Deprecated
  public static Typeface getDefaultTypeface()
  {
    return Game.typeface;
  }
  
  public static Typeface getSystemDefaultTypeface()
  {
    return Typeface.DEFAULT;
  }
  
  public static Typeface loadTypeface(String paramString)
  {
    if (paramString == null) {}
    try
    {
      return getSystemDefaultTypeface();
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    paramString = Typeface.createFromAsset(Game.getContext().getAssets(), paramString);
    return paramString;
    return getSystemDefaultTypeface();
  }
  
  @Deprecated
  public static void setDefaultTypeface(Typeface paramTypeface)
  {
    Game.typeface = paramTypeface;
  }
  
  @Deprecated
  public static void setDefaultTypeface(String paramString)
  {
    setDefaultTypeface(loadTypeface(paramString));
  }
  
  public int getAlpha()
  {
    return this._painter.getAlpha();
  }
  
  public int getColor()
  {
    return this._painter.getFontColor();
  }
  
  public byte getHorizontalAlign()
  {
    return this._hAlign;
  }
  
  public int getInterline()
  {
    return this._interline;
  }
  
  public int getMaxLines()
  {
    return this._maxLines;
  }
  
  public int getMesuredHeight()
  {
    return this._innerHeight;
  }
  
  public int getMesuredWidth()
  {
    return this._innerWidth;
  }
  
  public int getMinWidth()
  {
    return this._minWidth;
  }
  
  @Deprecated
  public Paint getPaint()
  {
    return this._painter.getFillPaint();
  }
  
  public Painter getPainter()
  {
    return this._painter;
  }
  
  public LabelShader getShader()
  {
    return this._shader;
  }
  
  public float getSize()
  {
    return this._painter.getFontSize();
  }
  
  public String getText()
  {
    return this._text;
  }
  
  public Typeface getTypeface()
  {
    return this._painter.getFontFace();
  }
  
  public byte getVerticalAlign()
  {
    return this._vAlign;
  }
  
  public boolean isAutoSize()
  {
    return this._autoSize;
  }
  
  public boolean isWordWrap()
  {
    return this._wordWrap;
  }
  
  protected final void measure()
  {
    if (this._text == null) {
      return;
    }
    computeParcelBounds(this._painter);
    if (this._autoSize)
    {
      this.w = this._maxWidth;
      this.h = this._maxHeight;
      if (this.w < this._minWidth) {
        this.w = this._minWidth;
      }
      if (this.h < this._minHeight) {
        this.h = this._minHeight;
      }
      this.cw = (this.w >> 1);
      this.ch = (this.h >> 1);
    }
    computeHorizontalOfs();
    computeVerticalOfs();
  }
  
  public void onAction() {}
  
  public void onRender()
  {
    if ((!this.visible) || (!this.enabled) || (this._text == null)) {}
    for (;;)
    {
      return;
      if (this._shader != null) {
        this._shader.onUpdate(this);
      }
      if (this._wordWrap)
      {
        drawWordWrap();
        return;
      }
      if (this._painter != null)
      {
        int j = this._parcels.length;
        int i = 0;
        while (i < j)
        {
          StringParcel localStringParcel = this._parcels[i];
          if (localStringParcel != null) {
            this._painter.draw(localStringParcel.string, (int)this.x + localStringParcel.ofsX, (int)this.y + localStringParcel.ofsY);
          }
          i += 1;
        }
      }
    }
  }
  
  public void setAlpha(int paramInt)
  {
    this._painter.setAlpha(paramInt);
  }
  
  public void setAutoSize(boolean paramBoolean)
  {
    if (this._autoSize != paramBoolean)
    {
      this._autoSize = paramBoolean;
      measure();
    }
  }
  
  public void setColor(int paramInt)
  {
    this._painter.setFontColor(paramInt);
  }
  
  @Deprecated
  public void setGravity(int paramInt)
  {
    setHorizontalAlign((byte)paramInt);
  }
  
  public void setHeight(int paramInt)
  {
    if (paramInt != this.h)
    {
      this.h = paramInt;
      this.ch = (this.h >> 1);
      measure();
    }
  }
  
  public void setHorizontalAlign(byte paramByte)
  {
    if (this._hAlign != paramByte)
    {
      this._hAlign = paramByte;
      measure();
    }
  }
  
  public void setInterline(int paramInt)
  {
    if (this._interline != paramInt)
    {
      this._interline = paramInt;
      measure();
    }
  }
  
  public void setMaxLines(int paramInt)
  {
    if (this._maxLines != paramInt)
    {
      this._maxLines = paramInt;
      measure();
    }
  }
  
  public void setMinWidth(int paramInt)
  {
    this._minWidth = paramInt;
  }
  
  public void setPainter(Painter paramPainter)
  {
    if (paramPainter != this._painter)
    {
      this._painter = paramPainter;
      measure();
    }
  }
  
  public void setShader(LabelShader paramLabelShader)
  {
    this._shader = paramLabelShader;
  }
  
  public void setSize(float paramFloat)
  {
    if (paramFloat != this._painter.getFontSize())
    {
      this._painter.setFontSize(paramFloat);
      measure();
    }
  }
  
  public void setStrokeColor(int paramInt)
  {
    this._painter.setStrokeColor(paramInt);
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    this._painter.setStrokeWidth(paramFloat);
  }
  
  public void setText(int paramInt)
  {
    setText(Game.getResString(paramInt));
  }
  
  public void setText(String paramString)
  {
    if (TextUtils.isEqual(paramString, this._text)) {
      return;
    }
    this._text = paramString;
    if (this._text == null) {
      this._parcels = null;
    }
    for (;;)
    {
      measure();
      return;
      paramString = android.text.TextUtils.split(this._text, "\n");
      this._parcels = new StringParcel[paramString.length];
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        StringParcel localStringParcel = new StringParcel();
        localStringParcel.string = paramString[i];
        this._parcels[i] = localStringParcel;
        i += 1;
      }
    }
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    this._painter.setFontFace(paramTypeface);
    measure();
  }
  
  public void setVerticalAlign(byte paramByte)
  {
    if (this._vAlign != paramByte)
    {
      this._vAlign = paramByte;
      measure();
    }
  }
  
  public void setWidth(int paramInt)
  {
    if (paramInt != this.w)
    {
      this.w = paramInt;
      this.cw = (this.w >> 1);
      measure();
    }
  }
  
  public void setWordWrap(boolean paramBoolean)
  {
    this._wordWrap = paramBoolean;
  }
  
  public static class Align
  {
    public static final byte BOTTOM = 2;
    public static final byte CENTER = 0;
    public static final byte LEFT = 1;
    public static final byte RIGHT = 2;
    public static final byte TOP = 1;
  }
  
  @Deprecated
  public static class Gravity
  {
    public static final int CENTER = 0;
    public static final int LEFT = 1;
    public static final int RIGHT = 2;
  }
  
  private static class StringParcel
  {
    public Rect bounds = new Rect();
    public int height;
    public int ofsX;
    public int ofsY;
    public String string;
    public int width;
    
    public void computeBounds(Painter paramPainter)
    {
      paramPainter.getTextBounds(this.string, 0, this.string.length(), this.bounds);
      this.width = (this.bounds.right - this.bounds.left);
      this.height = (this.bounds.bottom - this.bounds.top);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/Label.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */