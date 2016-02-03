package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.b.k;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class LinearLayoutICS
  extends LinearLayout
{
  private final Drawable a;
  private final int b;
  private final int c;
  private final int d;
  private final int e;
  
  public LinearLayoutICS(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, k.LinearLayoutICS);
    this.a = paramContext.getDrawable(0);
    if (this.a != null)
    {
      this.b = this.a.getIntrinsicWidth();
      this.c = this.a.getIntrinsicHeight();
      this.d = paramContext.getInt(1, 0);
      this.e = paramContext.getDimensionPixelSize(2, 0);
      paramContext.recycle();
      if (this.a != null) {
        break label105;
      }
    }
    for (;;)
    {
      setWillNotDraw(bool);
      return;
      this.b = 0;
      this.c = 0;
      break;
      label105:
      bool = false;
    }
  }
  
  void a(Canvas paramCanvas)
  {
    int j = getChildCount();
    int i = 0;
    View localView;
    while (i < j)
    {
      localView = getChildAt(i);
      if ((localView != null) && (localView.getVisibility() != 8) && (a(i)))
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
        a(paramCanvas, localView.getTop() - localLayoutParams.topMargin);
      }
      i += 1;
    }
    if (a(j))
    {
      localView = getChildAt(j - 1);
      if (localView != null) {
        break label119;
      }
    }
    label119:
    for (i = getHeight() - getPaddingBottom() - this.c;; i = localView.getBottom())
    {
      a(paramCanvas, i);
      return;
    }
  }
  
  void a(Canvas paramCanvas, int paramInt)
  {
    this.a.setBounds(getPaddingLeft() + this.e, paramInt, getWidth() - getPaddingRight() - this.e, this.c + paramInt);
    this.a.draw(paramCanvas);
  }
  
  protected boolean a(int paramInt)
  {
    if (paramInt == 0) {
      if ((this.d & 0x1) == 0) {}
    }
    do
    {
      return true;
      return false;
      if (paramInt != getChildCount()) {
        break;
      }
    } while ((this.d & 0x4) != 0);
    return false;
    if ((this.d & 0x2) != 0)
    {
      paramInt -= 1;
      for (;;)
      {
        if (paramInt < 0) {
          break label75;
        }
        if (getChildAt(paramInt).getVisibility() != 8) {
          break;
        }
        paramInt -= 1;
      }
    }
    return false;
    label75:
    return false;
  }
  
  void b(Canvas paramCanvas)
  {
    int j = getChildCount();
    int i = 0;
    View localView;
    while (i < j)
    {
      localView = getChildAt(i);
      if ((localView != null) && (localView.getVisibility() != 8) && (a(i)))
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
        b(paramCanvas, localView.getLeft() - localLayoutParams.leftMargin);
      }
      i += 1;
    }
    if (a(j))
    {
      localView = getChildAt(j - 1);
      if (localView != null) {
        break label119;
      }
    }
    label119:
    for (i = getWidth() - getPaddingRight() - this.b;; i = localView.getRight())
    {
      b(paramCanvas, i);
      return;
    }
  }
  
  void b(Canvas paramCanvas, int paramInt)
  {
    this.a.setBounds(paramInt, getPaddingTop() + this.e, this.b + paramInt, getHeight() - getPaddingBottom() - this.e);
    this.a.draw(paramCanvas);
  }
  
  public int getSupportDividerWidth()
  {
    return this.b;
  }
  
  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i;
    int j;
    LinearLayout.LayoutParams localLayoutParams;
    if (this.a != null)
    {
      i = indexOfChild(paramView);
      j = getChildCount();
      localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      if (getOrientation() != 1) {
        break label97;
      }
      if (!a(i)) {
        break label67;
      }
      localLayoutParams.topMargin = this.c;
    }
    for (;;)
    {
      super.measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
      label67:
      if ((i == j - 1) && (a(j)))
      {
        localLayoutParams.bottomMargin = this.c;
        continue;
        label97:
        if (a(i)) {
          localLayoutParams.leftMargin = this.b;
        } else if ((i == j - 1) && (a(j))) {
          localLayoutParams.rightMargin = this.b;
        }
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.a == null) {
      return;
    }
    if (getOrientation() == 1)
    {
      a(paramCanvas);
      return;
    }
    b(paramCanvas);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/widget/LinearLayoutICS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */