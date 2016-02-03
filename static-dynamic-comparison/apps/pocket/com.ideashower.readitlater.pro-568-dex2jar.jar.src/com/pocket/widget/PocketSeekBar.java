package com.pocket.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import com.ideashower.readitlater.b;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.at;

public class PocketSeekBar
  extends at
{
  private static final int a = j.a(11.0F);
  private static final int b = j.a(6.5F);
  private static final int c = j.a(1.1F);
  private static final int d = j.a(5.0F);
  private ab e = ab.a;
  
  public PocketSeekBar(Context paramContext)
  {
    super(paramContext);
    e();
  }
  
  public PocketSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
    e();
  }
  
  public PocketSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
    e();
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = getContext().obtainStyledAttributes(paramAttributeSet, b.PocketSeekBar);
    if (localTypedArray.getInt(0, 0) == 0) {}
    for (paramAttributeSet = ab.a;; paramAttributeSet = ab.b)
    {
      this.e = paramAttributeSet;
      localTypedArray.recycle();
      return;
    }
  }
  
  private void e()
  {
    setThumb(new z(this, getResources(), null));
    int i = 2131165788;
    if (this.e == ab.b) {
      i = 2131165789;
    }
    ClipDrawable localClipDrawable = new ClipDrawable(new aa(this, getResources(), i, null), 3, 1);
    setProgressDrawable(new LayerDrawable(new Drawable[] { new aa(this, getResources(), 2131165790, null), localClipDrawable }));
    i = j.a(9.0F);
    setThumbOffset(i);
    setPadding(i, 0, i, 0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/PocketSeekBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */