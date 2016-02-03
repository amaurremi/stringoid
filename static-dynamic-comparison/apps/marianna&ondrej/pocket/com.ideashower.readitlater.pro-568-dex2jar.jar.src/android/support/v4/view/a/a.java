package android.support.v4.view.a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;

public class a
{
  private static final c a = new g();
  private final Object b;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      a = new f();
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      a = new e();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      a = new d();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      a = new b();
      return;
    }
  }
  
  public a(Object paramObject)
  {
    this.b = paramObject;
  }
  
  public static a a(a parama)
  {
    return a(a.a(parama.b));
  }
  
  static a a(Object paramObject)
  {
    if (paramObject != null) {
      return new a(paramObject);
    }
    return null;
  }
  
  private static String b(int paramInt)
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
  
  public Object a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    a.a(this.b, paramInt);
  }
  
  public void a(Rect paramRect)
  {
    a.a(this.b, paramRect);
  }
  
  public void a(View paramView)
  {
    a.c(this.b, paramView);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    a.c(this.b, paramCharSequence);
  }
  
  public void a(boolean paramBoolean)
  {
    a.c(this.b, paramBoolean);
  }
  
  public int b()
  {
    return a.b(this.b);
  }
  
  public void b(Rect paramRect)
  {
    a.c(this.b, paramRect);
  }
  
  public void b(View paramView)
  {
    a.a(this.b, paramView);
  }
  
  public void b(CharSequence paramCharSequence)
  {
    a.a(this.b, paramCharSequence);
  }
  
  public void b(boolean paramBoolean)
  {
    a.d(this.b, paramBoolean);
  }
  
  public void c(Rect paramRect)
  {
    a.b(this.b, paramRect);
  }
  
  public void c(View paramView)
  {
    a.b(this.b, paramView);
  }
  
  public void c(CharSequence paramCharSequence)
  {
    a.b(this.b, paramCharSequence);
  }
  
  public void c(boolean paramBoolean)
  {
    a.h(this.b, paramBoolean);
  }
  
  public boolean c()
  {
    return a.g(this.b);
  }
  
  public void d(Rect paramRect)
  {
    a.d(this.b, paramRect);
  }
  
  public void d(boolean paramBoolean)
  {
    a.i(this.b, paramBoolean);
  }
  
  public boolean d()
  {
    return a.h(this.b);
  }
  
  public void e(boolean paramBoolean)
  {
    a.g(this.b, paramBoolean);
  }
  
  public boolean e()
  {
    return a.k(this.b);
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
        if (this.b != null) {
          break;
        }
      } while (((a)paramObject).b == null);
      return false;
    } while (this.b.equals(((a)paramObject).b));
    return false;
  }
  
  public void f(boolean paramBoolean)
  {
    a.a(this.b, paramBoolean);
  }
  
  public boolean f()
  {
    return a.l(this.b);
  }
  
  public void g(boolean paramBoolean)
  {
    a.e(this.b, paramBoolean);
  }
  
  public boolean g()
  {
    return a.r(this.b);
  }
  
  public void h(boolean paramBoolean)
  {
    a.b(this.b, paramBoolean);
  }
  
  public boolean h()
  {
    return a.s(this.b);
  }
  
  public int hashCode()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.hashCode();
  }
  
  public void i(boolean paramBoolean)
  {
    a.f(this.b, paramBoolean);
  }
  
  public boolean i()
  {
    return a.p(this.b);
  }
  
  public boolean j()
  {
    return a.i(this.b);
  }
  
  public boolean k()
  {
    return a.m(this.b);
  }
  
  public boolean l()
  {
    return a.j(this.b);
  }
  
  public boolean m()
  {
    return a.n(this.b);
  }
  
  public boolean n()
  {
    return a.o(this.b);
  }
  
  public CharSequence o()
  {
    return a.e(this.b);
  }
  
  public CharSequence p()
  {
    return a.c(this.b);
  }
  
  public CharSequence q()
  {
    return a.f(this.b);
  }
  
  public CharSequence r()
  {
    return a.d(this.b);
  }
  
  public void s()
  {
    a.q(this.b);
  }
  
  public String t()
  {
    return a.t(this.b);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    Rect localRect = new Rect();
    a(localRect);
    localStringBuilder.append("; boundsInParent: " + localRect);
    c(localRect);
    localStringBuilder.append("; boundsInScreen: " + localRect);
    localStringBuilder.append("; packageName: ").append(o());
    localStringBuilder.append("; className: ").append(p());
    localStringBuilder.append("; text: ").append(q());
    localStringBuilder.append("; contentDescription: ").append(r());
    localStringBuilder.append("; viewId: ").append(t());
    localStringBuilder.append("; checkable: ").append(c());
    localStringBuilder.append("; checked: ").append(d());
    localStringBuilder.append("; focusable: ").append(e());
    localStringBuilder.append("; focused: ").append(f());
    localStringBuilder.append("; selected: ").append(i());
    localStringBuilder.append("; clickable: ").append(j());
    localStringBuilder.append("; longClickable: ").append(k());
    localStringBuilder.append("; enabled: ").append(l());
    localStringBuilder.append("; password: ").append(m());
    localStringBuilder.append("; scrollable: " + n());
    localStringBuilder.append("; [");
    int i = b();
    while (i != 0)
    {
      int k = 1 << Integer.numberOfTrailingZeros(i);
      int j = i & (k ^ 0xFFFFFFFF);
      localStringBuilder.append(b(k));
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/view/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */