package com.ideashower.readitlater.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.ideashower.readitlater.b;
import com.ideashower.readitlater.h.m;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;

public class ThemedImageView
  extends ImageView
{
  private int a;
  private ColorStateList b;
  
  public ThemedImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ThemedImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public ThemedImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.ThemedIconButton);
    this.b = paramContext.getColorStateList(0);
    paramContext.recycle();
    if ((this.b != null) && ((getDrawable() instanceof BitmapDrawable))) {
      setImageDrawable(getDrawable());
    }
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 2);
    mergeDrawableStates(arrayOfInt, m.b(this));
    StyledToolbar.a(this, arrayOfInt);
    return arrayOfInt;
  }
  
  public void refreshDrawableState()
  {
    super.refreshDrawableState();
    invalidate();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    Object localObject = paramDrawable;
    if (this.b != null)
    {
      localObject = paramDrawable;
      if ((paramDrawable instanceof BitmapDrawable)) {
        localObject = new p(((BitmapDrawable)paramDrawable).getBitmap(), getContext(), this.b);
      }
    }
    super.setImageDrawable((Drawable)localObject);
  }
  
  public void setStyle(int paramInt)
  {
    this.a = paramInt;
    refreshDrawableState();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/ThemedImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */