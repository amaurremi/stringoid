package android.support.v7.internal.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.b.a.a;
import android.support.v4.view.j;
import android.support.v7.b.d;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class o
  implements a
{
  private static final int[] d = { 1, 4, 5, 3, 2, 0 };
  CharSequence a;
  Drawable b;
  View c;
  private final Context e;
  private final Resources f;
  private boolean g;
  private boolean h;
  private p i;
  private ArrayList<s> j;
  private ArrayList<s> k;
  private boolean l;
  private ArrayList<s> m;
  private ArrayList<s> n;
  private boolean o;
  private int p = 0;
  private ContextMenu.ContextMenuInfo q;
  private boolean r = false;
  private boolean s = false;
  private boolean t = false;
  private boolean u = false;
  private ArrayList<s> v = new ArrayList();
  private CopyOnWriteArrayList<WeakReference<ab>> w = new CopyOnWriteArrayList();
  private s x;
  
  public o(Context paramContext)
  {
    this.e = paramContext;
    this.f = paramContext.getResources();
    this.j = new ArrayList();
    this.k = new ArrayList();
    this.l = true;
    this.m = new ArrayList();
    this.n = new ArrayList();
    this.o = true;
    d(true);
  }
  
  private static int a(ArrayList<s> paramArrayList, int paramInt)
  {
    int i1 = paramArrayList.size() - 1;
    while (i1 >= 0)
    {
      if (((s)paramArrayList.get(i1)).b() <= paramInt) {
        return i1 + 1;
      }
      i1 -= 1;
    }
    return 0;
  }
  
  private MenuItem a(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    int i1 = c(paramInt3);
    paramCharSequence = new s(this, paramInt1, paramInt2, paramInt3, i1, paramCharSequence, this.p);
    if (this.q != null) {
      paramCharSequence.a(this.q);
    }
    this.j.add(a(this.j, i1), paramCharSequence);
    b(true);
    return paramCharSequence;
  }
  
  private void a(int paramInt1, CharSequence paramCharSequence, int paramInt2, Drawable paramDrawable, View paramView)
  {
    Resources localResources = c();
    if (paramView != null)
    {
      this.c = paramView;
      this.a = null;
      this.b = null;
      b(false);
      return;
    }
    if (paramInt1 > 0)
    {
      this.a = localResources.getText(paramInt1);
      label47:
      if (paramInt2 <= 0) {
        break label81;
      }
      this.b = localResources.getDrawable(paramInt2);
    }
    for (;;)
    {
      this.c = null;
      break;
      if (paramCharSequence == null) {
        break label47;
      }
      this.a = paramCharSequence;
      break label47;
      label81:
      if (paramDrawable != null) {
        this.b = paramDrawable;
      }
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if ((paramInt < 0) || (paramInt >= this.j.size())) {}
    do
    {
      return;
      this.j.remove(paramInt);
    } while (!paramBoolean);
    b(true);
  }
  
  private boolean a(ah paramah)
  {
    if (this.w.isEmpty()) {
      return false;
    }
    Iterator localIterator = this.w.iterator();
    boolean bool = false;
    ab localab;
    if (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      localab = (ab)localWeakReference.get();
      if (localab == null) {
        this.w.remove(localWeakReference);
      }
    }
    for (;;)
    {
      break;
      if (!bool)
      {
        bool = localab.a(paramah);
        continue;
        return bool;
      }
    }
  }
  
  private static int c(int paramInt)
  {
    int i1 = (0xFFFF0000 & paramInt) >> 16;
    if ((i1 < 0) || (i1 >= d.length)) {
      throw new IllegalArgumentException("order does not contain a valid category.");
    }
    return d[i1] << 16 | 0xFFFF & paramInt;
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.w.isEmpty()) {
      return;
    }
    f();
    Iterator localIterator = this.w.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      ab localab = (ab)localWeakReference.get();
      if (localab == null) {
        this.w.remove(localWeakReference);
      } else {
        localab.c(paramBoolean);
      }
    }
    g();
  }
  
  private void d(boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramBoolean) && (this.f.getConfiguration().keyboard != 1) && (this.f.getBoolean(d.abc_config_showMenuShortcutsWhenKeyboardPresent))) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.h = paramBoolean;
      return;
    }
  }
  
  public int a(int paramInt)
  {
    int i2 = size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (((s)this.j.get(i1)).getItemId() == paramInt) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    int i2 = size();
    int i1 = paramInt2;
    if (paramInt2 < 0) {
      i1 = 0;
    }
    while (i1 < i2)
    {
      if (((s)this.j.get(i1)).getGroupId() == paramInt1) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  protected o a(Drawable paramDrawable)
  {
    a(0, null, 0, paramDrawable, null);
    return this;
  }
  
  protected o a(View paramView)
  {
    a(0, null, 0, null, paramView);
    return this;
  }
  
  protected o a(CharSequence paramCharSequence)
  {
    a(0, paramCharSequence, 0, null, null);
    return this;
  }
  
  s a(int paramInt, KeyEvent paramKeyEvent)
  {
    ArrayList localArrayList = this.v;
    localArrayList.clear();
    a(localArrayList, paramInt, paramKeyEvent);
    if (localArrayList.isEmpty())
    {
      paramKeyEvent = null;
      return paramKeyEvent;
    }
    int i3 = paramKeyEvent.getMetaState();
    KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
    paramKeyEvent.getKeyData(localKeyData);
    int i4 = localArrayList.size();
    if (i4 == 1) {
      return (s)localArrayList.get(0);
    }
    boolean bool = a();
    int i1 = 0;
    label84:
    if (i1 < i4)
    {
      s locals = (s)localArrayList.get(i1);
      if (bool) {}
      for (int i2 = locals.getAlphabeticShortcut();; i2 = locals.getNumericShortcut())
      {
        if (i2 == localKeyData.meta[0])
        {
          paramKeyEvent = locals;
          if ((i3 & 0x2) == 0) {
            break;
          }
        }
        if (i2 == localKeyData.meta[2])
        {
          paramKeyEvent = locals;
          if ((i3 & 0x2) != 0) {
            break;
          }
        }
        if ((bool) && (i2 == 8))
        {
          paramKeyEvent = locals;
          if (paramInt == 67) {
            break;
          }
        }
        i1 += 1;
        break label84;
      }
    }
    return null;
  }
  
  public void a(ab paramab)
  {
    this.w.add(new WeakReference(paramab));
    paramab.a(this.e, this);
    this.o = true;
  }
  
  public void a(p paramp)
  {
    this.i = paramp;
  }
  
  void a(s params)
  {
    this.l = true;
    b(true);
  }
  
  void a(MenuItem paramMenuItem)
  {
    int i2 = paramMenuItem.getGroupId();
    int i3 = this.j.size();
    int i1 = 0;
    if (i1 < i3)
    {
      s locals = (s)this.j.get(i1);
      if ((locals.getGroupId() != i2) || (!locals.f())) {}
      while (!locals.isCheckable())
      {
        i1 += 1;
        break;
      }
      if (locals == paramMenuItem) {}
      for (boolean bool = true;; bool = false)
      {
        locals.b(bool);
        break;
      }
    }
  }
  
  void a(List<s> paramList, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = a();
    int i3 = paramKeyEvent.getMetaState();
    KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
    if ((!paramKeyEvent.getKeyData(localKeyData)) && (paramInt != 67)) {
      return;
    }
    int i4 = this.j.size();
    int i1 = 0;
    label49:
    s locals;
    if (i1 < i4)
    {
      locals = (s)this.j.get(i1);
      if (locals.hasSubMenu()) {
        ((o)locals.getSubMenu()).a(paramList, paramInt, paramKeyEvent);
      }
      if (!bool) {
        break label184;
      }
    }
    label184:
    for (int i2 = locals.getAlphabeticShortcut();; i2 = locals.getNumericShortcut())
    {
      if (((i3 & 0x5) == 0) && (i2 != 0) && ((i2 == localKeyData.meta[0]) || (i2 == localKeyData.meta[2]) || ((bool) && (i2 == 8) && (paramInt == 67))) && (locals.isEnabled())) {
        paramList.add(locals);
      }
      i1 += 1;
      break label49;
      break;
    }
  }
  
  final void a(boolean paramBoolean)
  {
    if (this.u) {
      return;
    }
    this.u = true;
    Iterator localIterator = this.w.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      ab localab = (ab)localWeakReference.get();
      if (localab == null) {
        this.w.remove(localWeakReference);
      } else {
        localab.a(this, paramBoolean);
      }
    }
    this.u = false;
  }
  
  boolean a()
  {
    return this.g;
  }
  
  boolean a(o paramo, MenuItem paramMenuItem)
  {
    return (this.i != null) && (this.i.a(paramo, paramMenuItem));
  }
  
  public boolean a(MenuItem paramMenuItem, int paramInt)
  {
    boolean bool2 = false;
    Object localObject = (s)paramMenuItem;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      if (((s)localObject).isEnabled()) {
        break label33;
      }
      bool1 = bool2;
    }
    label33:
    label99:
    do
    {
      return bool1;
      bool1 = ((s)localObject).a();
      paramMenuItem = ((s)localObject).m();
      if ((paramMenuItem != null) && (paramMenuItem.g())) {}
      for (int i1 = 1;; i1 = 0)
      {
        if (!((s)localObject).n()) {
          break label99;
        }
        bool2 = ((s)localObject).expandActionView() | bool1;
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        a(true);
        return bool2;
      }
      if ((!((s)localObject).hasSubMenu()) && (i1 == 0)) {
        break;
      }
      a(false);
      if (!((s)localObject).hasSubMenu()) {
        ((s)localObject).a(new ah(d(), this, (s)localObject));
      }
      localObject = (ah)((s)localObject).getSubMenu();
      if (i1 != 0) {
        paramMenuItem.a((SubMenu)localObject);
      }
      bool2 = a((ah)localObject) | bool1;
      bool1 = bool2;
    } while (bool2);
    a(true);
    return bool2;
    if ((paramInt & 0x1) == 0) {
      a(true);
    }
    return bool1;
  }
  
  public MenuItem add(int paramInt)
  {
    return a(0, 0, 0, this.f.getString(paramInt));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(paramInt1, paramInt2, paramInt3, this.f.getString(paramInt4));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return a(paramInt1, paramInt2, paramInt3, paramCharSequence);
  }
  
  public MenuItem add(CharSequence paramCharSequence)
  {
    return a(0, 0, 0, paramCharSequence);
  }
  
  public int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem)
  {
    PackageManager localPackageManager = this.e.getPackageManager();
    List localList = localPackageManager.queryIntentActivityOptions(paramComponentName, paramArrayOfIntent, paramIntent, 0);
    int i1;
    label52:
    ResolveInfo localResolveInfo;
    if (localList != null)
    {
      i1 = localList.size();
      if ((paramInt4 & 0x1) == 0) {
        removeGroup(paramInt1);
      }
      paramInt4 = 0;
      if (paramInt4 >= i1) {
        break label214;
      }
      localResolveInfo = (ResolveInfo)localList.get(paramInt4);
      if (localResolveInfo.specificIndex >= 0) {
        break label201;
      }
    }
    label201:
    for (paramComponentName = paramIntent;; paramComponentName = paramArrayOfIntent[localResolveInfo.specificIndex])
    {
      paramComponentName = new Intent(paramComponentName);
      paramComponentName.setComponent(new ComponentName(localResolveInfo.activityInfo.applicationInfo.packageName, localResolveInfo.activityInfo.name));
      paramComponentName = add(paramInt1, paramInt2, paramInt3, localResolveInfo.loadLabel(localPackageManager)).setIcon(localResolveInfo.loadIcon(localPackageManager)).setIntent(paramComponentName);
      if ((paramArrayOfMenuItem != null) && (localResolveInfo.specificIndex >= 0)) {
        paramArrayOfMenuItem[localResolveInfo.specificIndex] = paramComponentName;
      }
      paramInt4 += 1;
      break label52;
      i1 = 0;
      break;
    }
    label214:
    return i1;
  }
  
  public SubMenu addSubMenu(int paramInt)
  {
    return addSubMenu(0, 0, 0, this.f.getString(paramInt));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return addSubMenu(paramInt1, paramInt2, paramInt3, this.f.getString(paramInt4));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    paramCharSequence = (s)a(paramInt1, paramInt2, paramInt3, paramCharSequence);
    ah localah = new ah(this.e, this, paramCharSequence);
    paramCharSequence.a(localah);
    return localah;
  }
  
  public SubMenu addSubMenu(CharSequence paramCharSequence)
  {
    return addSubMenu(0, 0, 0, paramCharSequence);
  }
  
  public int b(int paramInt)
  {
    return a(paramInt, 0);
  }
  
  public void b(ab paramab)
  {
    Iterator localIterator = this.w.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      ab localab = (ab)localWeakReference.get();
      if ((localab == null) || (localab == paramab)) {
        this.w.remove(localWeakReference);
      }
    }
  }
  
  void b(s params)
  {
    this.o = true;
    b(true);
  }
  
  void b(boolean paramBoolean)
  {
    if (!this.r)
    {
      if (paramBoolean)
      {
        this.l = true;
        this.o = true;
      }
      c(paramBoolean);
      return;
    }
    this.s = true;
  }
  
  public boolean b()
  {
    return this.h;
  }
  
  Resources c()
  {
    return this.f;
  }
  
  public boolean c(s params)
  {
    boolean bool2 = false;
    if (this.w.isEmpty()) {
      return bool2;
    }
    f();
    Iterator localIterator = this.w.iterator();
    boolean bool1 = false;
    if (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      ab localab = (ab)localWeakReference.get();
      if (localab == null) {
        this.w.remove(localWeakReference);
      }
      do
      {
        break;
        bool2 = localab.a(this, params);
        bool1 = bool2;
      } while (!bool2);
      bool1 = bool2;
    }
    for (;;)
    {
      g();
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      this.x = params;
      return bool1;
    }
  }
  
  public void clear()
  {
    if (this.x != null) {
      d(this.x);
    }
    this.j.clear();
    b(true);
  }
  
  public void clearHeader()
  {
    this.b = null;
    this.a = null;
    this.c = null;
    b(false);
  }
  
  public void close()
  {
    a(true);
  }
  
  public Context d()
  {
    return this.e;
  }
  
  public boolean d(s params)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (!this.w.isEmpty())
    {
      if (this.x != params) {
        bool2 = bool1;
      }
    }
    else {
      return bool2;
    }
    f();
    Iterator localIterator = this.w.iterator();
    bool1 = false;
    if (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      ab localab = (ab)localWeakReference.get();
      if (localab == null) {
        this.w.remove(localWeakReference);
      }
      do
      {
        break;
        bool2 = localab.b(this, params);
        bool1 = bool2;
      } while (!bool2);
      bool1 = bool2;
    }
    for (;;)
    {
      g();
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      this.x = null;
      return bool1;
    }
  }
  
  public void e()
  {
    if (this.i != null) {
      this.i.a(this);
    }
  }
  
  public void f()
  {
    if (!this.r)
    {
      this.r = true;
      this.s = false;
    }
  }
  
  public MenuItem findItem(int paramInt)
  {
    int i2 = size();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = (s)this.j.get(i1);
      if (((s)localObject).getItemId() == paramInt) {}
      MenuItem localMenuItem;
      do
      {
        return (MenuItem)localObject;
        if (!((s)localObject).hasSubMenu()) {
          break;
        }
        localMenuItem = ((s)localObject).getSubMenu().findItem(paramInt);
        localObject = localMenuItem;
      } while (localMenuItem != null);
      i1 += 1;
    }
    return null;
  }
  
  public void g()
  {
    this.r = false;
    if (this.s)
    {
      this.s = false;
      b(true);
    }
  }
  
  public MenuItem getItem(int paramInt)
  {
    return (MenuItem)this.j.get(paramInt);
  }
  
  ArrayList<s> h()
  {
    if (!this.l) {
      return this.k;
    }
    this.k.clear();
    int i2 = this.j.size();
    int i1 = 0;
    while (i1 < i2)
    {
      s locals = (s)this.j.get(i1);
      if (locals.isVisible()) {
        this.k.add(locals);
      }
      i1 += 1;
    }
    this.l = false;
    this.o = true;
    return this.k;
  }
  
  public boolean hasVisibleItems()
  {
    int i2 = size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (((s)this.j.get(i1)).isVisible()) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public void i()
  {
    if (!this.o) {
      return;
    }
    Object localObject1 = this.w.iterator();
    int i1 = 0;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WeakReference)((Iterator)localObject1).next();
      ab localab = (ab)((WeakReference)localObject2).get();
      if (localab == null) {
        this.w.remove(localObject2);
      }
      for (;;)
      {
        break;
        i1 = localab.g() | i1;
      }
    }
    if (i1 != 0)
    {
      this.m.clear();
      this.n.clear();
      localObject1 = h();
      int i3 = ((ArrayList)localObject1).size();
      i1 = 0;
      if (i1 < i3)
      {
        localObject2 = (s)((ArrayList)localObject1).get(i1);
        if (((s)localObject2).i()) {
          this.m.add(localObject2);
        }
        for (;;)
        {
          int i2;
          i1 += 1;
          break;
          this.n.add(localObject2);
        }
      }
    }
    else
    {
      this.m.clear();
      this.n.clear();
      this.n.addAll(h());
    }
    this.o = false;
  }
  
  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    return a(paramInt, paramKeyEvent) != null;
  }
  
  ArrayList<s> j()
  {
    i();
    return this.m;
  }
  
  ArrayList<s> k()
  {
    i();
    return this.n;
  }
  
  public CharSequence l()
  {
    return this.a;
  }
  
  public Drawable m()
  {
    return this.b;
  }
  
  public View n()
  {
    return this.c;
  }
  
  public o o()
  {
    return this;
  }
  
  boolean p()
  {
    return this.t;
  }
  
  public boolean performIdentifierAction(int paramInt1, int paramInt2)
  {
    return a(findItem(paramInt1), paramInt2);
  }
  
  public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    paramKeyEvent = a(paramInt1, paramKeyEvent);
    boolean bool = false;
    if (paramKeyEvent != null) {
      bool = a(paramKeyEvent, paramInt2);
    }
    if ((paramInt2 & 0x2) != 0) {
      a(true);
    }
    return bool;
  }
  
  public s q()
  {
    return this.x;
  }
  
  public void removeGroup(int paramInt)
  {
    int i2 = b(paramInt);
    if (i2 >= 0)
    {
      int i3 = this.j.size();
      int i1 = 0;
      while ((i1 < i3 - i2) && (((s)this.j.get(i2)).getGroupId() == paramInt))
      {
        a(i2, false);
        i1 += 1;
      }
      b(true);
    }
  }
  
  public void removeItem(int paramInt)
  {
    a(a(paramInt), true);
  }
  
  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = this.j.size();
    int i1 = 0;
    while (i1 < i2)
    {
      s locals = (s)this.j.get(i1);
      if (locals.getGroupId() == paramInt)
      {
        locals.a(paramBoolean2);
        locals.setCheckable(paramBoolean1);
      }
      i1 += 1;
    }
  }
  
  public void setGroupEnabled(int paramInt, boolean paramBoolean)
  {
    int i2 = this.j.size();
    int i1 = 0;
    while (i1 < i2)
    {
      s locals = (s)this.j.get(i1);
      if (locals.getGroupId() == paramInt) {
        locals.setEnabled(paramBoolean);
      }
      i1 += 1;
    }
  }
  
  public void setGroupVisible(int paramInt, boolean paramBoolean)
  {
    int i3 = this.j.size();
    int i2 = 0;
    int i1 = 0;
    if (i2 < i3)
    {
      s locals = (s)this.j.get(i2);
      if ((locals.getGroupId() != paramInt) || (!locals.c(paramBoolean))) {
        break label74;
      }
      i1 = 1;
    }
    label74:
    for (;;)
    {
      i2 += 1;
      break;
      if (i1 != 0) {
        b(true);
      }
      return;
    }
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    this.g = paramBoolean;
    b(false);
  }
  
  public int size()
  {
    return this.j.size();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/view/menu/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */