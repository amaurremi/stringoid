package com.pocket.widget.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.ideashower.readitlater.util.i;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.CheckableTextView;
import com.ideashower.readitlater.views.p;

public class s
  extends CheckableTextView
{
  private static final int b = j.a(21.5F);
  private final k c;
  private m d;
  private Drawable e;
  private t f;
  private final u g;
  private n h;
  
  public s(Context paramContext, k paramk)
  {
    super(paramContext);
    paramContext = paramContext.getResources();
    this.c = paramk;
    setBackgroundDrawable(paramContext.getDrawable(2130837589));
    setPadding(j.a(58.0F), paramContext.getDimensionPixelSize(2131296288), j.a(13.0F), paramContext.getDimensionPixelSize(2131296287));
    setTextSize(0, paramContext.getDimension(2131296289));
    setTextColor(paramContext.getColorStateList(2131165771));
    this.g = new u(paramContext, true);
  }
  
  private void a()
  {
    int i;
    int j;
    if (this.e != null)
    {
      i = b;
      j = (int)((getHeight() - this.e.getIntrinsicHeight()) / 2.0F);
      this.e.setBounds(i, j, this.e.getIntrinsicWidth() + i, this.e.getIntrinsicHeight() + j);
    }
    if (this.f != null)
    {
      i = getWidth() - getPaddingRight() - this.f.getIntrinsicWidth();
      j = (int)((getHeight() - this.f.getIntrinsicHeight()) / 2.0F);
      this.f.setBounds(i, j, this.f.getIntrinsicWidth() + i, this.f.getIntrinsicHeight() + j);
    }
    if (this.h == n.b) {
      this.g.a(getPaddingLeft(), 0);
    }
    for (;;)
    {
      this.g.setBounds(0, getHeight() - 1, getWidth(), getHeight());
      return;
      this.g.a(0, 0);
    }
  }
  
  public void a(m paramm, n paramn)
  {
    this.d = paramm;
    this.h = paramn;
    setText(paramm.b);
    if (paramm.a != 0)
    {
      this.e = new p(paramm.a, getContext(), getResources().getColorStateList(2131165771));
      this.e.setState(getDrawableState());
      if (paramm.c != n.b) {
        break label168;
      }
      i.a(i.c, this);
      label82:
      int i = 0;
      if (paramm.d == l.b) {
        i = this.c.a(paramm);
      }
      if (i <= 0) {
        break label178;
      }
      if (this.f == null) {
        this.f = new t(this);
      }
      this.f.a(String.valueOf(i));
      this.f.setState(getDrawableState());
    }
    for (;;)
    {
      a();
      invalidate();
      return;
      this.e = null;
      break;
      label168:
      i.a(i.a, this);
      break label82;
      label178:
      if (this.f != null) {
        this.f.a(null);
      }
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.e != null) {
      this.e.draw(paramCanvas);
    }
    if (this.f != null) {
      this.f.draw(paramCanvas);
    }
    this.g.draw(paramCanvas);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    if (this.e != null) {
      this.e.setState(arrayOfInt);
    }
    if (this.f != null) {
      this.f.setState(arrayOfInt);
    }
    this.g.setState(arrayOfInt);
  }
  
  public u getDivider()
  {
    return this.g;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean) {
      a();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/navigation/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */