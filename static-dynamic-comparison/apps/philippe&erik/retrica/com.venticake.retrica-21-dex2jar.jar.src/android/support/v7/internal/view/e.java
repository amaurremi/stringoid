package android.support.v7.internal.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ad;
import android.support.v4.view.j;
import android.support.v7.b.k;
import android.support.v7.internal.view.menu.s;
import android.support.v7.internal.view.menu.t;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;

class e
{
  private Menu b;
  private int c;
  private int d;
  private int e;
  private int f;
  private boolean g;
  private boolean h;
  private boolean i;
  private int j;
  private int k;
  private CharSequence l;
  private CharSequence m;
  private int n;
  private char o;
  private char p;
  private int q;
  private boolean r;
  private boolean s;
  private boolean t;
  private int u;
  private int v;
  private String w;
  private String x;
  private String y;
  private j z;
  
  public e(c paramc, Menu paramMenu)
  {
    this.b = paramMenu;
    a();
  }
  
  private char a(String paramString)
  {
    if (paramString == null) {
      return '\000';
    }
    return paramString.charAt(0);
  }
  
  private <T> T a(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      paramArrayOfClass = c.a(this.a).getClassLoader().loadClass(paramString).getConstructor(paramArrayOfClass).newInstance(paramArrayOfObject);
      return paramArrayOfClass;
    }
    catch (Exception paramArrayOfClass)
    {
      Log.w("SupportMenuInflater", "Cannot instantiate class: " + paramString, paramArrayOfClass);
    }
    return null;
  }
  
  private void a(MenuItem paramMenuItem)
  {
    int i1 = 1;
    Object localObject = paramMenuItem.setChecked(this.r).setVisible(this.s).setEnabled(this.t);
    if (this.q >= 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((MenuItem)localObject).setCheckable(bool).setTitleCondensed(this.m).setIcon(this.n).setAlphabeticShortcut(this.o).setNumericShortcut(this.p);
      if (this.u >= 0) {
        ad.a(paramMenuItem, this.u);
      }
      if (this.y == null) {
        break label162;
      }
      if (!c.a(this.a).isRestricted()) {
        break;
      }
      throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
    }
    paramMenuItem.setOnMenuItemClickListener(new d(c.c(this.a), this.y));
    label162:
    if ((paramMenuItem instanceof s)) {
      localObject = (s)paramMenuItem;
    }
    if (this.q >= 2)
    {
      if ((paramMenuItem instanceof s)) {
        ((s)paramMenuItem).a(true);
      }
    }
    else
    {
      if (this.w == null) {
        break label297;
      }
      ad.a(paramMenuItem, (View)a(this.w, c.b(), c.d(this.a)));
    }
    for (;;)
    {
      if (this.v > 0)
      {
        if (i1 != 0) {
          break label286;
        }
        ad.b(paramMenuItem, this.v);
      }
      for (;;)
      {
        if (this.z != null) {
          ad.a(paramMenuItem, this.z);
        }
        return;
        if (!(paramMenuItem instanceof t)) {
          break;
        }
        ((t)paramMenuItem).a(true);
        break;
        label286:
        Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
      }
      label297:
      i1 = 0;
    }
  }
  
  public void a()
  {
    this.c = 0;
    this.d = 0;
    this.e = 0;
    this.f = 0;
    this.g = true;
    this.h = true;
  }
  
  public void a(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = c.a(this.a).obtainStyledAttributes(paramAttributeSet, k.MenuGroup);
    this.c = paramAttributeSet.getResourceId(1, 0);
    this.d = paramAttributeSet.getInt(3, 0);
    this.e = paramAttributeSet.getInt(4, 0);
    this.f = paramAttributeSet.getInt(5, 0);
    this.g = paramAttributeSet.getBoolean(2, true);
    this.h = paramAttributeSet.getBoolean(0, true);
    paramAttributeSet.recycle();
  }
  
  public void b()
  {
    this.i = true;
    a(this.b.add(this.c, this.j, this.k, this.l));
  }
  
  public void b(AttributeSet paramAttributeSet)
  {
    int i2 = 1;
    paramAttributeSet = c.a(this.a).obtainStyledAttributes(paramAttributeSet, k.MenuItem);
    this.j = paramAttributeSet.getResourceId(2, 0);
    this.k = (paramAttributeSet.getInt(5, this.d) & 0xFFFF0000 | paramAttributeSet.getInt(6, this.e) & 0xFFFF);
    this.l = paramAttributeSet.getText(7);
    this.m = paramAttributeSet.getText(8);
    this.n = paramAttributeSet.getResourceId(0, 0);
    this.o = a(paramAttributeSet.getString(9));
    this.p = a(paramAttributeSet.getString(10));
    int i1;
    if (paramAttributeSet.hasValue(11)) {
      if (paramAttributeSet.getBoolean(11, false))
      {
        i1 = 1;
        this.q = i1;
        label143:
        this.r = paramAttributeSet.getBoolean(3, false);
        this.s = paramAttributeSet.getBoolean(4, this.g);
        this.t = paramAttributeSet.getBoolean(1, this.h);
        this.u = paramAttributeSet.getInt(13, -1);
        this.y = paramAttributeSet.getString(12);
        this.v = paramAttributeSet.getResourceId(14, 0);
        this.w = paramAttributeSet.getString(15);
        this.x = paramAttributeSet.getString(16);
        if (this.x == null) {
          break label309;
        }
        i1 = i2;
        label240:
        if ((i1 == 0) || (this.v != 0) || (this.w != null)) {
          break label314;
        }
      }
    }
    for (this.z = ((j)a(this.x, c.a(), c.b(this.a)));; this.z = null)
    {
      paramAttributeSet.recycle();
      this.i = false;
      return;
      i1 = 0;
      break;
      this.q = this.f;
      break label143;
      label309:
      i1 = 0;
      break label240;
      label314:
      if (i1 != 0) {
        Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
      }
    }
  }
  
  public SubMenu c()
  {
    this.i = true;
    SubMenu localSubMenu = this.b.addSubMenu(this.c, this.j, this.k, this.l);
    a(localSubMenu.getItem());
    return localSubMenu;
  }
  
  public boolean d()
  {
    return this.i;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/view/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */