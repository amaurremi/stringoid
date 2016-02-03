package com.ideashower.readitlater.views.toolbars;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;
import com.ideashower.readitlater.b;
import com.ideashower.readitlater.h.m;
import com.ideashower.readitlater.views.CheckableImageButton;
import com.ideashower.readitlater.views.p;

public class ThemedIconButton
  extends CheckableImageButton
{
  public static final int[] c = { 16842919 };
  public static final int[] d = { 16842913 };
  public static final int[] e = { -16842910 };
  private final ColorStateList b;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  private p i;
  private int j = -1;
  
  public ThemedIconButton(Context paramContext)
  {
    super(paramContext);
    this.b = null;
    a();
  }
  
  public ThemedIconButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.ThemedIconButton);
    this.b = paramContext.getColorStateList(0);
    paramContext.recycle();
    if ((this.b != null) && (this.i != null)) {
      setImageBitmap(this.i.b());
    }
    a();
  }
  
  protected void a()
  {
    setBackgroundDrawable(null);
    setScaleType(ImageView.ScaleType.CENTER);
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void b()
  {
    setFocusable(false);
    setFocusableInTouchMode(false);
    setClickable(false);
    setLongClickable(false);
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt2 = super.onCreateDrawableState(paramInt + 3);
    if (this.j == -1) {}
    for (int[] arrayOfInt1 = m.b(this);; arrayOfInt1 = m.c(this.j))
    {
      mergeDrawableStates(arrayOfInt2, arrayOfInt1);
      StyledToolbar.a(this, arrayOfInt2);
      return arrayOfInt2;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int k = 0;
    p localp;
    boolean bool;
    if (this.i != null)
    {
      localp = this.i;
      if ((!this.h) && ((!this.g) || (!isChecked()))) {
        break label69;
      }
      bool = true;
      localp.a(bool);
      localp = this.i;
      if (!this.f) {
        break label74;
      }
    }
    for (;;)
    {
      localp.setAlpha(k);
      super.onDraw(paramCanvas);
      return;
      label69:
      bool = false;
      break;
      label74:
      k = 255;
    }
  }
  
  public void setAlwaysUseSourceImage(boolean paramBoolean)
  {
    this.h = paramBoolean;
    invalidate();
  }
  
  public void setCheckedUseSourceImage(boolean paramBoolean)
  {
    this.g = paramBoolean;
    invalidate();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    Object localObject = paramDrawable;
    if (paramDrawable != null)
    {
      localObject = paramDrawable;
      if ((paramDrawable instanceof BitmapDrawable)) {
        if (this.b == null) {
          break label59;
        }
      }
    }
    label59:
    for (this.i = new p(((BitmapDrawable)paramDrawable).getBitmap(), getContext(), this.b);; this.i = new p(((BitmapDrawable)paramDrawable).getBitmap(), getContext()))
    {
      localObject = this.i;
      super.setImageDrawable((Drawable)localObject);
      return;
    }
  }
  
  public void setImageResource(int paramInt)
  {
    setImageDrawable(getResources().getDrawable(paramInt));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/toolbars/ThemedIconButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */