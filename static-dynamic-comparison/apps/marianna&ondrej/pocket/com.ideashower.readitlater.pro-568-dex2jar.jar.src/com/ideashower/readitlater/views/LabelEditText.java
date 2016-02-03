package com.ideashower.readitlater.views;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.util.AttributeSet;
import com.ideashower.readitlater.b;
import com.ideashower.readitlater.h.m;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.pocket.i.a.i;

public class LabelEditText
  extends ThemedEditText
{
  private Paint a;
  private String b;
  private boolean c = false;
  private int d;
  private boolean e = false;
  
  public LabelEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public LabelEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public LabelEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, b.LabelEditText);
    setLabel(paramAttributeSet.getString(0));
    paramAttributeSet.recycle();
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 2);
    mergeDrawableStates(arrayOfInt, m.b(this));
    StyledToolbar.a(this, arrayOfInt);
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.a != null) && (this.b != null))
    {
      int i = getPaddingLeft();
      int j = j.a(21.0F);
      paramCanvas.drawText(this.b, i, j, this.a);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((getWidth() >= 0) && (!this.c))
    {
      this.c = true;
      this.d = getPaddingTop();
      if (this.e) {
        setLabel(this.b);
      }
    }
  }
  
  public void setLabel(int paramInt)
  {
    setLabel(getResources().getString(paramInt));
  }
  
  public void setLabel(String paramString)
  {
    this.b = paramString;
    if (this.b != null)
    {
      this.b = this.b.toUpperCase();
      if (!this.b.endsWith(":")) {
        this.b = this.b.concat(":");
      }
      this.a = new Paint();
      this.a.setColor(i.b);
      this.a.setTextAlign(Paint.Align.LEFT);
      this.a.setTextSize(getResources().getDimension(2131296293));
      this.a.setAntiAlias(true);
      this.a.setTypeface(getTypeface());
    }
    if (getWidth() == 0)
    {
      this.e = true;
      return;
    }
    if (this.b != null) {}
    for (int i = j.a(23.0F);; i = this.d)
    {
      setPadding(getPaddingLeft(), i + getPaddingTop(), getPaddingRight(), getPaddingBottom());
      requestLayout();
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/LabelEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */