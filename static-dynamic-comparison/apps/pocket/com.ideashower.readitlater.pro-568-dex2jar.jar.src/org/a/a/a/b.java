package org.a.a.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;

public class b
  extends ViewGroup.LayoutParams
{
  private static int a = -1;
  private int b;
  private int c;
  private int d;
  private int e = a;
  private int f = a;
  private boolean g = false;
  private boolean h = false;
  
  public b(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public b(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public b(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, com.ideashower.readitlater.b.FlowLayout_LayoutParams);
    try
    {
      this.e = paramContext.getDimensionPixelSize(1, a);
      this.f = paramContext.getDimensionPixelSize(2, a);
      this.h = paramContext.getBoolean(0, false);
      this.g = paramContext.getBoolean(3, false);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public boolean a()
  {
    return this.e != a;
  }
  
  public boolean b()
  {
    return this.f != a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/a/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */