package android.support.v4.view.a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;

public class a
{
  private static final b cN = new f();
  private final Object cO;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      cN = new e();
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      cN = new d();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      cN = new c();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      cN = new a();
      return;
    }
  }
  
  public a(Object paramObject)
  {
    this.cO = paramObject;
  }
  
  public static a a(a parama)
  {
    return c(cN.d(parama.cO));
  }
  
  static a c(Object paramObject)
  {
    if (paramObject != null) {
      return new a(paramObject);
    }
    return null;
  }
  
  private static String p(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "ACTION_UNKNOWN";
    case 1: 
      return "ACTION_FOCUS";
    case 2: 
      return "ACTION_CLEAR_FOCUS";
    case 4: 
      return "ACTION_SELECT";
    case 8: 
      return "ACTION_CLEAR_SELECTION";
    case 16: 
      return "ACTION_CLICK";
    case 32: 
      return "ACTION_LONG_CLICK";
    case 64: 
      return "ACTION_ACCESSIBILITY_FOCUS";
    case 128: 
      return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
    case 256: 
      return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
    case 512: 
      return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
    case 1024: 
      return "ACTION_NEXT_HTML_ELEMENT";
    case 2048: 
      return "ACTION_PREVIOUS_HTML_ELEMENT";
    case 4096: 
      return "ACTION_SCROLL_FORWARD";
    case 8192: 
      return "ACTION_SCROLL_BACKWARD";
    case 65536: 
      return "ACTION_CUT";
    case 16384: 
      return "ACTION_COPY";
    case 32768: 
      return "ACTION_PASTE";
    }
    return "ACTION_SET_SELECTION";
  }
  
  public Object P()
  {
    return this.cO;
  }
  
  public void addAction(int paramInt)
  {
    cN.a(this.cO, paramInt);
  }
  
  public void addChild(View paramView)
  {
    cN.c(this.cO, paramView);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (a)paramObject;
        if (this.cO != null) {
          break;
        }
      } while (((a)paramObject).cO == null);
      return false;
    } while (this.cO.equals(((a)paramObject).cO));
    return false;
  }
  
  public int getActions()
  {
    return cN.e(this.cO);
  }
  
  public void getBoundsInParent(Rect paramRect)
  {
    cN.a(this.cO, paramRect);
  }
  
  public void getBoundsInScreen(Rect paramRect)
  {
    cN.b(this.cO, paramRect);
  }
  
  public CharSequence getClassName()
  {
    return cN.f(this.cO);
  }
  
  public CharSequence getContentDescription()
  {
    return cN.g(this.cO);
  }
  
  public int getMovementGranularities()
  {
    return cN.u(this.cO);
  }
  
  public CharSequence getPackageName()
  {
    return cN.h(this.cO);
  }
  
  public CharSequence getText()
  {
    return cN.i(this.cO);
  }
  
  public String getViewIdResourceName()
  {
    return cN.x(this.cO);
  }
  
  public int hashCode()
  {
    if (this.cO == null) {
      return 0;
    }
    return this.cO.hashCode();
  }
  
  public boolean isAccessibilityFocused()
  {
    return cN.w(this.cO);
  }
  
  public boolean isCheckable()
  {
    return cN.j(this.cO);
  }
  
  public boolean isChecked()
  {
    return cN.k(this.cO);
  }
  
  public boolean isClickable()
  {
    return cN.l(this.cO);
  }
  
  public boolean isEnabled()
  {
    return cN.m(this.cO);
  }
  
  public boolean isFocusable()
  {
    return cN.n(this.cO);
  }
  
  public boolean isFocused()
  {
    return cN.o(this.cO);
  }
  
  public boolean isLongClickable()
  {
    return cN.p(this.cO);
  }
  
  public boolean isPassword()
  {
    return cN.q(this.cO);
  }
  
  public boolean isScrollable()
  {
    return cN.r(this.cO);
  }
  
  public boolean isSelected()
  {
    return cN.s(this.cO);
  }
  
  public boolean isVisibleToUser()
  {
    return cN.v(this.cO);
  }
  
  public void recycle()
  {
    cN.t(this.cO);
  }
  
  public void setAccessibilityFocused(boolean paramBoolean)
  {
    cN.i(this.cO, paramBoolean);
  }
  
  public void setBoundsInParent(Rect paramRect)
  {
    cN.c(this.cO, paramRect);
  }
  
  public void setBoundsInScreen(Rect paramRect)
  {
    cN.d(this.cO, paramRect);
  }
  
  public void setClassName(CharSequence paramCharSequence)
  {
    cN.a(this.cO, paramCharSequence);
  }
  
  public void setClickable(boolean paramBoolean)
  {
    cN.a(this.cO, paramBoolean);
  }
  
  public void setContentDescription(CharSequence paramCharSequence)
  {
    cN.b(this.cO, paramCharSequence);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    cN.b(this.cO, paramBoolean);
  }
  
  public void setFocusable(boolean paramBoolean)
  {
    cN.c(this.cO, paramBoolean);
  }
  
  public void setFocused(boolean paramBoolean)
  {
    cN.d(this.cO, paramBoolean);
  }
  
  public void setLongClickable(boolean paramBoolean)
  {
    cN.e(this.cO, paramBoolean);
  }
  
  public void setMovementGranularities(int paramInt)
  {
    cN.b(this.cO, paramInt);
  }
  
  public void setPackageName(CharSequence paramCharSequence)
  {
    cN.c(this.cO, paramCharSequence);
  }
  
  public void setParent(View paramView)
  {
    cN.d(this.cO, paramView);
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    cN.f(this.cO, paramBoolean);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    cN.g(this.cO, paramBoolean);
  }
  
  public void setSource(View paramView)
  {
    cN.e(this.cO, paramView);
  }
  
  public void setVisibleToUser(boolean paramBoolean)
  {
    cN.h(this.cO, paramBoolean);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    Rect localRect = new Rect();
    getBoundsInParent(localRect);
    localStringBuilder.append("; boundsInParent: " + localRect);
    getBoundsInScreen(localRect);
    localStringBuilder.append("; boundsInScreen: " + localRect);
    localStringBuilder.append("; packageName: ").append(getPackageName());
    localStringBuilder.append("; className: ").append(getClassName());
    localStringBuilder.append("; text: ").append(getText());
    localStringBuilder.append("; contentDescription: ").append(getContentDescription());
    localStringBuilder.append("; viewId: ").append(getViewIdResourceName());
    localStringBuilder.append("; checkable: ").append(isCheckable());
    localStringBuilder.append("; checked: ").append(isChecked());
    localStringBuilder.append("; focusable: ").append(isFocusable());
    localStringBuilder.append("; focused: ").append(isFocused());
    localStringBuilder.append("; selected: ").append(isSelected());
    localStringBuilder.append("; clickable: ").append(isClickable());
    localStringBuilder.append("; longClickable: ").append(isLongClickable());
    localStringBuilder.append("; enabled: ").append(isEnabled());
    localStringBuilder.append("; password: ").append(isPassword());
    localStringBuilder.append("; scrollable: " + isScrollable());
    localStringBuilder.append("; [");
    int i = getActions();
    while (i != 0)
    {
      int k = 1 << Integer.numberOfTrailingZeros(i);
      int j = i & (k ^ 0xFFFFFFFF);
      localStringBuilder.append(p(k));
      i = j;
      if (j != 0)
      {
        localStringBuilder.append(", ");
        i = j;
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  static class a
    extends a.f
  {
    public void a(Object paramObject, int paramInt)
    {
      b.a(paramObject, paramInt);
    }
    
    public void a(Object paramObject, Rect paramRect)
    {
      b.a(paramObject, paramRect);
    }
    
    public void a(Object paramObject, CharSequence paramCharSequence)
    {
      b.a(paramObject, paramCharSequence);
    }
    
    public void a(Object paramObject, boolean paramBoolean)
    {
      b.a(paramObject, paramBoolean);
    }
    
    public void b(Object paramObject, Rect paramRect)
    {
      b.b(paramObject, paramRect);
    }
    
    public void b(Object paramObject, CharSequence paramCharSequence)
    {
      b.b(paramObject, paramCharSequence);
    }
    
    public void b(Object paramObject, boolean paramBoolean)
    {
      b.b(paramObject, paramBoolean);
    }
    
    public void c(Object paramObject, Rect paramRect)
    {
      b.c(paramObject, paramRect);
    }
    
    public void c(Object paramObject, View paramView)
    {
      b.c(paramObject, paramView);
    }
    
    public void c(Object paramObject, CharSequence paramCharSequence)
    {
      b.c(paramObject, paramCharSequence);
    }
    
    public void c(Object paramObject, boolean paramBoolean)
    {
      b.c(paramObject, paramBoolean);
    }
    
    public Object d(Object paramObject)
    {
      return b.d(paramObject);
    }
    
    public void d(Object paramObject, Rect paramRect)
    {
      b.d(paramObject, paramRect);
    }
    
    public void d(Object paramObject, View paramView)
    {
      b.d(paramObject, paramView);
    }
    
    public void d(Object paramObject, boolean paramBoolean)
    {
      b.d(paramObject, paramBoolean);
    }
    
    public int e(Object paramObject)
    {
      return b.e(paramObject);
    }
    
    public void e(Object paramObject, View paramView)
    {
      b.e(paramObject, paramView);
    }
    
    public void e(Object paramObject, boolean paramBoolean)
    {
      b.e(paramObject, paramBoolean);
    }
    
    public CharSequence f(Object paramObject)
    {
      return b.f(paramObject);
    }
    
    public void f(Object paramObject, boolean paramBoolean)
    {
      b.f(paramObject, paramBoolean);
    }
    
    public CharSequence g(Object paramObject)
    {
      return b.g(paramObject);
    }
    
    public void g(Object paramObject, boolean paramBoolean)
    {
      b.g(paramObject, paramBoolean);
    }
    
    public CharSequence h(Object paramObject)
    {
      return b.h(paramObject);
    }
    
    public CharSequence i(Object paramObject)
    {
      return b.i(paramObject);
    }
    
    public boolean j(Object paramObject)
    {
      return b.j(paramObject);
    }
    
    public boolean k(Object paramObject)
    {
      return b.k(paramObject);
    }
    
    public boolean l(Object paramObject)
    {
      return b.l(paramObject);
    }
    
    public boolean m(Object paramObject)
    {
      return b.m(paramObject);
    }
    
    public boolean n(Object paramObject)
    {
      return b.n(paramObject);
    }
    
    public boolean o(Object paramObject)
    {
      return b.o(paramObject);
    }
    
    public boolean p(Object paramObject)
    {
      return b.p(paramObject);
    }
    
    public boolean q(Object paramObject)
    {
      return b.q(paramObject);
    }
    
    public boolean r(Object paramObject)
    {
      return b.r(paramObject);
    }
    
    public boolean s(Object paramObject)
    {
      return b.s(paramObject);
    }
    
    public void t(Object paramObject)
    {
      b.t(paramObject);
    }
  }
  
  static abstract interface b
  {
    public abstract void a(Object paramObject, int paramInt);
    
    public abstract void a(Object paramObject, Rect paramRect);
    
    public abstract void a(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void a(Object paramObject, boolean paramBoolean);
    
    public abstract void b(Object paramObject, int paramInt);
    
    public abstract void b(Object paramObject, Rect paramRect);
    
    public abstract void b(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void b(Object paramObject, boolean paramBoolean);
    
    public abstract void c(Object paramObject, Rect paramRect);
    
    public abstract void c(Object paramObject, View paramView);
    
    public abstract void c(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void c(Object paramObject, boolean paramBoolean);
    
    public abstract Object d(Object paramObject);
    
    public abstract void d(Object paramObject, Rect paramRect);
    
    public abstract void d(Object paramObject, View paramView);
    
    public abstract void d(Object paramObject, boolean paramBoolean);
    
    public abstract int e(Object paramObject);
    
    public abstract void e(Object paramObject, View paramView);
    
    public abstract void e(Object paramObject, boolean paramBoolean);
    
    public abstract CharSequence f(Object paramObject);
    
    public abstract void f(Object paramObject, boolean paramBoolean);
    
    public abstract CharSequence g(Object paramObject);
    
    public abstract void g(Object paramObject, boolean paramBoolean);
    
    public abstract CharSequence h(Object paramObject);
    
    public abstract void h(Object paramObject, boolean paramBoolean);
    
    public abstract CharSequence i(Object paramObject);
    
    public abstract void i(Object paramObject, boolean paramBoolean);
    
    public abstract boolean j(Object paramObject);
    
    public abstract boolean k(Object paramObject);
    
    public abstract boolean l(Object paramObject);
    
    public abstract boolean m(Object paramObject);
    
    public abstract boolean n(Object paramObject);
    
    public abstract boolean o(Object paramObject);
    
    public abstract boolean p(Object paramObject);
    
    public abstract boolean q(Object paramObject);
    
    public abstract boolean r(Object paramObject);
    
    public abstract boolean s(Object paramObject);
    
    public abstract void t(Object paramObject);
    
    public abstract int u(Object paramObject);
    
    public abstract boolean v(Object paramObject);
    
    public abstract boolean w(Object paramObject);
    
    public abstract String x(Object paramObject);
  }
  
  static class c
    extends a.a
  {
    public void b(Object paramObject, int paramInt)
    {
      c.b(paramObject, paramInt);
    }
    
    public void h(Object paramObject, boolean paramBoolean)
    {
      c.h(paramObject, paramBoolean);
    }
    
    public void i(Object paramObject, boolean paramBoolean)
    {
      c.j(paramObject, paramBoolean);
    }
    
    public int u(Object paramObject)
    {
      return c.u(paramObject);
    }
    
    public boolean v(Object paramObject)
    {
      return c.v(paramObject);
    }
    
    public boolean w(Object paramObject)
    {
      return c.w(paramObject);
    }
  }
  
  static class d
    extends a.c
  {
    public String x(Object paramObject)
    {
      return d.x(paramObject);
    }
  }
  
  static class e
    extends a.d
  {}
  
  static class f
    implements a.b
  {
    public void a(Object paramObject, int paramInt) {}
    
    public void a(Object paramObject, Rect paramRect) {}
    
    public void a(Object paramObject, CharSequence paramCharSequence) {}
    
    public void a(Object paramObject, boolean paramBoolean) {}
    
    public void b(Object paramObject, int paramInt) {}
    
    public void b(Object paramObject, Rect paramRect) {}
    
    public void b(Object paramObject, CharSequence paramCharSequence) {}
    
    public void b(Object paramObject, boolean paramBoolean) {}
    
    public void c(Object paramObject, Rect paramRect) {}
    
    public void c(Object paramObject, View paramView) {}
    
    public void c(Object paramObject, CharSequence paramCharSequence) {}
    
    public void c(Object paramObject, boolean paramBoolean) {}
    
    public Object d(Object paramObject)
    {
      return null;
    }
    
    public void d(Object paramObject, Rect paramRect) {}
    
    public void d(Object paramObject, View paramView) {}
    
    public void d(Object paramObject, boolean paramBoolean) {}
    
    public int e(Object paramObject)
    {
      return 0;
    }
    
    public void e(Object paramObject, View paramView) {}
    
    public void e(Object paramObject, boolean paramBoolean) {}
    
    public CharSequence f(Object paramObject)
    {
      return null;
    }
    
    public void f(Object paramObject, boolean paramBoolean) {}
    
    public CharSequence g(Object paramObject)
    {
      return null;
    }
    
    public void g(Object paramObject, boolean paramBoolean) {}
    
    public CharSequence h(Object paramObject)
    {
      return null;
    }
    
    public void h(Object paramObject, boolean paramBoolean) {}
    
    public CharSequence i(Object paramObject)
    {
      return null;
    }
    
    public void i(Object paramObject, boolean paramBoolean) {}
    
    public boolean j(Object paramObject)
    {
      return false;
    }
    
    public boolean k(Object paramObject)
    {
      return false;
    }
    
    public boolean l(Object paramObject)
    {
      return false;
    }
    
    public boolean m(Object paramObject)
    {
      return false;
    }
    
    public boolean n(Object paramObject)
    {
      return false;
    }
    
    public boolean o(Object paramObject)
    {
      return false;
    }
    
    public boolean p(Object paramObject)
    {
      return false;
    }
    
    public boolean q(Object paramObject)
    {
      return false;
    }
    
    public boolean r(Object paramObject)
    {
      return false;
    }
    
    public boolean s(Object paramObject)
    {
      return false;
    }
    
    public void t(Object paramObject) {}
    
    public int u(Object paramObject)
    {
      return 0;
    }
    
    public boolean v(Object paramObject)
    {
      return false;
    }
    
    public boolean w(Object paramObject)
    {
      return false;
    }
    
    public String x(Object paramObject)
    {
      return null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/view/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */