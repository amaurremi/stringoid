package android.support.v7.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.b.k;
import android.util.AttributeSet;
import android.view.ViewGroup.MarginLayoutParams;

public class c
  extends ViewGroup.MarginLayoutParams
{
  public int a = -1;
  
  public c(int paramInt)
  {
    this(-2, -1, paramInt);
  }
  
  public c(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2);
    this.a = paramInt3;
  }
  
  public c(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, k.ActionBarLayout);
    this.a = paramContext.getInt(0, -1);
    paramContext.recycle();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */