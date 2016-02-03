package com.ideashower.readitlater.views;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.util.z;
import com.pocket.widget.chip.ChipEditText;

public class SearchField
  extends ChipEditText
{
  private p a;
  
  public SearchField(Context paramContext)
  {
    super(paramContext);
    a(null);
  }
  
  public SearchField(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public SearchField(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    a();
  }
  
  public void a()
  {
    this.a = new p(2130837690, getContext());
    this.a.a();
    Object localObject = this.a.getBounds();
    ((Rect)localObject).offset(0, -j.a(2.0F));
    this.a.setBounds((Rect)localObject);
    localObject = new SpannableStringBuilder("   ");
    ((SpannableStringBuilder)localObject).setSpan(new ImageSpan(this.a), 1, 2, 18);
    setHint((CharSequence)localObject);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = z.a(getDrawableState());
    this.a.setState(arrayOfInt);
    invalidate();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/SearchField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */