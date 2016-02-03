package com.ideashower.readitlater.views.toolbars;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
import com.ideashower.readitlater.b;
import com.ideashower.readitlater.views.u;
import com.ideashower.readitlater.views.x;

public class StyledIconButton
  extends ThemedIconButton
  implements x
{
  protected String b;
  private int f;
  private u g;
  private boolean h = true;
  private boolean i = false;
  private final boolean j = false;
  
  public StyledIconButton(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public StyledIconButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.Tooltip);
    this.b = paramContext.getString(0);
    paramContext.recycle();
    a();
  }
  
  private void b(int paramInt)
  {
    this.f = paramInt;
    if ((this.h) && (paramInt != 0)) {
      setBackgroundResource(paramInt);
    }
    for (;;)
    {
      c();
      return;
      setBackgroundDrawable(null);
    }
  }
  
  private void c()
  {
    int k = (int)getResources().getDimension(getDefaultPaddingLeft());
    int m = (int)getResources().getDimension(getDefaultPaddingRight());
    setPadding(k, getPaddingTop(), m, getPaddingBottom());
    invalidate();
  }
  
  protected void a()
  {
    super.a();
    setClickable(true);
    c();
    setOnLongClickListener(new View.OnLongClickListener()
    {
      public boolean onLongClick(View paramAnonymousView)
      {
        boolean bool = false;
        if (StyledIconButton.this.b != null)
        {
          Toast.makeText(StyledIconButton.this.getContext(), StyledIconButton.this.b, 0).show();
          bool = true;
        }
        return bool;
      }
    });
    b(2130837774);
  }
  
  protected int getDefaultPaddingLeft()
  {
    return 2131296392;
  }
  
  protected int getDefaultPaddingRight()
  {
    return getDefaultPaddingLeft();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    getBackground();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt1);
    super.onMeasure(paramInt1, paramInt2);
    if (k != 1073741824)
    {
      paramInt2 = getMeasuredWidth();
      paramInt1 = getMeasuredHeight();
      if (paramInt1 <= (int)getResources().getDimension(2131296393)) {
        break label77;
      }
      if (paramInt2 >= paramInt1) {
        break label91;
      }
    }
    for (;;)
    {
      paramInt2 = paramInt1;
      if (k == Integer.MIN_VALUE) {
        paramInt2 = Math.min(paramInt1, m);
      }
      setMeasuredDimension(paramInt2, getMeasuredHeight());
      return;
      label77:
      paramInt1 = (int)getResources().getDimension(2131296393);
      break;
      label91:
      paramInt1 = paramInt2;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.g != null) {
      this.g.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setBackgroundEnabled(boolean paramBoolean)
  {
    if (this.h == paramBoolean) {
      return;
    }
    this.h = paramBoolean;
    b(this.f);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    c();
    requestLayout();
  }
  
  public void setOnResizeListener(u paramu)
  {
    this.g = paramu;
  }
  
  public void setTooltip(int paramInt)
  {
    setTooltip(getResources().getString(paramInt));
  }
  
  public void setTooltip(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/toolbars/StyledIconButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */