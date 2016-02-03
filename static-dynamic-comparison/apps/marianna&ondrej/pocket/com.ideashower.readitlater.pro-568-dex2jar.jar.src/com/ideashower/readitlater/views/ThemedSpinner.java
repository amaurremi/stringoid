package com.ideashower.readitlater.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.Toast;
import com.ideashower.readitlater.h.m;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.util.z;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.ideashower.readitlater.views.toolbars.b;
import java.util.ArrayList;

public class ThemedSpinner
  extends Spinner
  implements AdapterView.OnItemSelectedListener, b
{
  protected int a;
  private int b = StyledToolbar.a;
  private au c;
  private p d;
  private int e = -1;
  private int f;
  private int g;
  private boolean h = false;
  private String i;
  private AdapterView.OnItemSelectedListener j;
  private av k;
  private boolean l;
  
  public ThemedSpinner(Context paramContext)
  {
    super(z.a(paramContext));
    c();
  }
  
  public ThemedSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(z.a(paramContext), paramAttributeSet);
    c();
  }
  
  public ThemedSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(z.a(paramContext), paramAttributeSet, paramInt);
    c();
  }
  
  private void c()
  {
    this.f = 2130903106;
    this.g = 2130903107;
    this.e = m.a(this);
    setBackgroundResource(2130837774);
    this.c = new au(this);
    setAdapter(this.c);
    this.d = new p(BitmapFactory.decodeResource(getResources(), 2130837590), getContext());
    super.setOnItemSelectedListener(this);
    setPadding(0, 0, 0, 0);
    setOnLongClickListener(new View.OnLongClickListener()
    {
      public boolean onLongClick(View paramAnonymousView)
      {
        boolean bool = false;
        if (ThemedSpinner.a(ThemedSpinner.this) != null)
        {
          Toast.makeText(ThemedSpinner.this.getContext(), ThemedSpinner.a(ThemedSpinner.this), 0).show();
          bool = true;
        }
        return bool;
      }
    });
  }
  
  private void d()
  {
    ThemedSpinner localThemedSpinner = b();
    if ((!getClass().equals(ThemedSpinner.class)) && (localThemedSpinner.getClass().equals(ThemedSpinner.class))) {
      throw new RuntimeException("Subclasses of ThemedSpinner must override createSpinner() and return an instance of the subclass.");
    }
    a(this, localThemedSpinner);
    z.a(this, localThemedSpinner);
    if (this.k != null) {
      this.k.a(localThemedSpinner);
    }
  }
  
  private int getSelectedItemWidth()
  {
    if (this.c == null) {
      return 0;
    }
    int m = View.MeasureSpec.makeMeasureSpec(0, 0);
    int n = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i1 = Math.max(0, getSelectedItemPosition());
    View localView = this.c.getView(i1, null, this);
    if (localView.getLayoutParams() == null) {
      localView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    }
    localView.measure(m, n);
    return localView.getMeasuredWidth();
  }
  
  public void a()
  {
    this.d = new p(BitmapFactory.decodeResource(getResources(), 2130837591), getContext());
    this.h = true;
    invalidate();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.f = paramInt1;
    this.g = paramInt2;
    this.c.notifyDataSetChanged();
  }
  
  protected void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.j != null) {
      this.j.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
  
  protected void a(ThemedSpinner paramThemedSpinner1, ThemedSpinner paramThemedSpinner2)
  {
    paramThemedSpinner2.setStyle(this.b);
    paramThemedSpinner2.setSpinnerStyle(this.a);
    if (paramThemedSpinner1.h) {
      paramThemedSpinner2.a();
    }
    paramThemedSpinner2.setTooltip(paramThemedSpinner1.i);
    paramThemedSpinner2.setOnItemSelectedListener(this.j);
    paramThemedSpinner2.setOptions(au.a(paramThemedSpinner1.c));
    paramThemedSpinner2.setSelection(paramThemedSpinner1.getSelectedItemPosition());
    paramThemedSpinner2.a(this.f, this.g);
  }
  
  protected ThemedSpinner b()
  {
    return new ThemedSpinner(getContext());
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int m = m.a(this);
    if ((getParent() != null) && (this.e != -1) && (m != this.e)) {
      d();
    }
    this.e = m;
    if (this.d != null) {
      this.d.setState(getDrawableState());
    }
  }
  
  public int getStyle()
  {
    return this.b;
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 3);
    mergeDrawableStates(arrayOfInt, m.b(this));
    StyledToolbar.a(this, arrayOfInt);
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int n;
    if (this.d != null)
    {
      if (this.h) {
        break label74;
      }
      n = getWidth() - j.a(5.0F) - this.d.getIntrinsicWidth();
    }
    for (int m = (int)(getHeight() / 2.0F + j.a(5.0F));; m = getHeight() - j.a(32.0F))
    {
      this.d.a(n, m);
      this.d.draw(paramCanvas);
      return;
      label74:
      n = getWidth() - j.a(32.0F);
    }
  }
  
  public final void onItemSelected(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!this.l)
    {
      this.l = true;
      return;
    }
    a(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getSize(paramInt1);
    super.onMeasure(paramInt1, paramInt2);
    if ((m != 1073741824) && (this.c == null) && (this.c.getCount() > 0))
    {
      paramInt1 = getMeasuredWidth();
      paramInt2 = getSelectedItemWidth();
      if (paramInt2 != 0) {
        break label81;
      }
    }
    for (;;)
    {
      paramInt2 = paramInt1;
      if (m == Integer.MIN_VALUE) {
        paramInt2 = Math.min(paramInt1, n);
      }
      setMeasuredDimension(paramInt2, getMeasuredHeight());
      return;
      label81:
      paramInt1 = paramInt2;
    }
  }
  
  public void onNothingSelected(AdapterView paramAdapterView) {}
  
  public final void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.j = paramOnItemSelectedListener;
  }
  
  public void setOnRebuildListener(av paramav)
  {
    this.k = paramav;
  }
  
  public void setOptions(ArrayList paramArrayList)
  {
    this.c.a(paramArrayList);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = (int)(paramInt3 + getResources().getDimension(2131296394));
    super.setPadding(0, 0, 0, 0);
  }
  
  public void setSpinnerStyle(int paramInt)
  {
    this.a = paramInt;
    this.c.notifyDataSetChanged();
    requestLayout();
    invalidate();
  }
  
  public void setStyle(int paramInt)
  {
    this.b = paramInt;
    refreshDrawableState();
  }
  
  public void setTooltip(String paramString)
  {
    this.i = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/ThemedSpinner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */