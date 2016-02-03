package com.pocket.widget.chip;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import java.util.HashMap;
import org.a.a.a.a;

public class ChipLayout
  extends a
  implements View.OnClickListener
{
  private final HashMap a = new HashMap();
  private j b;
  private boolean c;
  private k d;
  
  public ChipLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public ChipLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ChipLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(View paramView, CharSequence paramCharSequence, int paramInt)
  {
    if (this.d != null) {
      paramView.setOnClickListener(this);
    }
    this.a.put(paramView, paramCharSequence);
    setIsModifyingChildren(true);
    addView(paramView, paramInt);
    setIsModifyingChildren(false);
  }
  
  private boolean a()
  {
    return this.c;
  }
  
  public CharSequence a(View paramView)
  {
    return (CharSequence)this.a.get(paramView);
  }
  
  public void a(int paramInt)
  {
    if ((paramInt >= getChipCount()) || (paramInt < 0)) {
      throw new IndexOutOfBoundsException("index of " + paramInt + " is out of bounds. size is " + getChipCount() + ". Use getChipCount() instead of getChildCount()");
    }
    View localView = getChildAt(paramInt);
    this.a.remove(localView);
    setIsModifyingChildren(true);
    removeView(localView);
    setIsModifyingChildren(false);
  }
  
  public void a(i parami)
  {
    a(parami, getChipCount());
  }
  
  public void a(i parami, int paramInt)
  {
    CharSequence localCharSequence = parami.a();
    a(parami.a(localCharSequence, paramInt, this), localCharSequence, paramInt);
  }
  
  public void a(CharSequence paramCharSequence, int paramInt)
  {
    a(this.b.a(paramCharSequence, this), paramCharSequence, paramInt);
  }
  
  public void addView(View paramView)
  {
    if (a())
    {
      super.addView(paramView);
      return;
    }
    throw new UnsupportedOperationException("addView(View) is not supported. Use the chip specific methods to add and remove..");
  }
  
  public void addView(View paramView, int paramInt)
  {
    if (a())
    {
      super.addView(paramView, paramInt);
      return;
    }
    throw new UnsupportedOperationException("addView(View, int) is not supported. Use the chip specific methods to add and remove..");
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (a())
    {
      super.addView(paramView, paramInt, paramLayoutParams);
      return;
    }
    throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported. Use the chip specific methods to add and remove..");
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (a())
    {
      super.addView(paramView, paramLayoutParams);
      return;
    }
    throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported. Use the chip specific methods to add and remove..");
  }
  
  public CharSequence b(int paramInt)
  {
    return a(getChildAt(paramInt));
  }
  
  public void b(CharSequence paramCharSequence)
  {
    a(paramCharSequence, getChipCount());
  }
  
  public void c(CharSequence paramCharSequence)
  {
    int j = getChipCount();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if (org.apache.a.c.k.b(paramCharSequence, ((TextView)getChildAt(i)).getText())) {
          a(i);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  public j getAdapter()
  {
    return this.b;
  }
  
  public int getChipCount()
  {
    return getChildCount();
  }
  
  public void i()
  {
    this.a.clear();
    setIsModifyingChildren(true);
    while (getChipCount() > 0) {
      a(0);
    }
    setIsModifyingChildren(false);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView != this) && (this.d != null)) {
      this.d.a(this, paramView, indexOfChild(paramView));
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    StyledToolbar.a(this, arrayOfInt);
    return arrayOfInt;
  }
  
  public void removeAllViews()
  {
    if (a())
    {
      super.removeAllViews();
      return;
    }
    throw new UnsupportedOperationException("removAllViews() is not supported. Use the chip specific methods to add and remove..");
  }
  
  public void removeView(View paramView)
  {
    if (a())
    {
      super.removeView(paramView);
      return;
    }
    throw new UnsupportedOperationException("removeView(View) is not supported. Use the chip specific methods to add and remove..");
  }
  
  public void removeViewAt(int paramInt)
  {
    if (a())
    {
      super.removeViewAt(paramInt);
      return;
    }
    throw new UnsupportedOperationException("removeViewAt(int) is not supported. Use the chip specific methods to add and remove..");
  }
  
  public void setAdapter(j paramj)
  {
    this.b = paramj;
  }
  
  protected void setIsModifyingChildren(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setOnItemClickListener(k paramk)
  {
    this.d = paramk;
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      if (paramk != null) {}
      for (ChipLayout localChipLayout = this;; localChipLayout = null)
      {
        localView.setOnClickListener(localChipLayout);
        i += 1;
        break;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/chip/ChipLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */