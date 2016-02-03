package com.pocket.widget.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import com.ideashower.readitlater.b;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.ThemedTextView;
import com.pocket.i.a.k;

public class ChipView
  extends ThemedTextView
{
  private static final float a = j.a(4.0F);
  private final k b = new k();
  
  public ChipView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ChipView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
    a(paramAttributeSet);
  }
  
  public ChipView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
    a(paramAttributeSet);
  }
  
  private void a()
  {
    setBackgroundDrawable(this.b);
    setEllipsize(TextUtils.TruncateAt.MIDDLE);
    setSingleLine(true);
    setMaxLines(1);
    this.b.a(a);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, b.ChipView);
    setChipStrokeColor(paramAttributeSet.getColorStateList(0));
    setChipFillColor(paramAttributeSet.getColorStateList(1));
    setChipStrokeWidth(paramAttributeSet.getDimensionPixelSize(2, 0));
    setChipCornerRadius(paramAttributeSet.getDimensionPixelSize(3, (int)a));
    paramAttributeSet.recycle();
  }
  
  private void setChipCornerRadius(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public void setChipFillColor(ColorStateList paramColorStateList)
  {
    this.b.b(paramColorStateList);
  }
  
  public void setChipStrokeColor(ColorStateList paramColorStateList)
  {
    this.b.a(paramColorStateList);
  }
  
  public void setChipStrokeWidth(int paramInt)
  {
    this.b.a(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/chip/ChipView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */