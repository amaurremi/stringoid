package com.go.weatherex.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.View;
import com.gau.go.launcherex.gowidget.weather.view.bu;
import com.go.weatherex.sidebar.b;
import com.go.weatherex.sidebar.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class l
  extends com.go.weatherex.framework.fragment.g
  implements FragmentManager.OnBackStackChangedListener, com.go.weatherex.sidebar.a
{
  private final Stack b = new Stack();
  private final Map c = new HashMap();
  private int d = 0;
  private final List e = new ArrayList();
  
  public l(FragmentActivity paramFragmentActivity)
  {
    super(paramFragmentActivity);
    a().addOnBackStackChangedListener(this);
    a(new int[] { 4, 5 });
  }
  
  private boolean a(String paramString)
  {
    boolean bool = false;
    if (!this.b.isEmpty()) {
      bool = ((String)this.b.peek()).equals(paramString);
    }
    return bool;
  }
  
  private void i()
  {
    if (this.b.isEmpty())
    {
      a(18, com.go.weatherex.home.current.t.class.getName());
      return;
    }
    a(18, this.b.peek());
  }
  
  private void j()
  {
    com.gtp.a.a.b.c.a("HomeFragmentManager", "onBackStackIncrease: " + this.e);
    this.b.push(this.e.remove(0));
  }
  
  private void k()
  {
    if ((a(com.go.weatherex.home.dayforecast.g.class.getName())) || (a(com.go.weatherex.home.hourforecast.c.class.getName())) || (a(com.go.weatherex.home.windforecast.c.class.getName())) || (a(com.go.weatherex.home.rain.g.class.getName())))
    {
      Fragment localFragment = a().findFragmentByTag(ab.class.getName());
      a().beginTransaction().hide(localFragment).commit();
      a(11, Boolean.valueOf(true));
      a(13, Boolean.valueOf(false));
      a(17, Boolean.valueOf(true));
    }
    this.b.pop();
    if (m()) {
      a(13, Boolean.valueOf(false));
    }
  }
  
  private Fragment l()
  {
    return a().findFragmentByTag(e.class.getName()).getChildFragmentManager().findFragmentByTag(c.class.getName());
  }
  
  private boolean m()
  {
    return (a().getBackStackEntryCount() == 0) && (this.b.isEmpty());
  }
  
  private int n()
  {
    int j = a().getBackStackEntryCount();
    Fragment localFragment = l();
    int i = j;
    if (localFragment != null) {
      i = j + localFragment.getChildFragmentManager().getBackStackEntryCount();
    }
    return i;
  }
  
  public void a(float paramFloat) {}
  
  public void a(bu parambu)
  {
    com.go.weatherex.home.a.a locala = new com.go.weatherex.home.a.a();
    locala.b(this.a);
    locala.setArguments(com.go.weatherex.home.a.a.a(parambu.a, parambu.b));
    ab localab = new ab();
    localab.b(this.a);
    e locale = new e();
    locale.b(this.a);
    locale.setArguments(e.a(parambu.a, parambu.e));
    parambu = a().beginTransaction();
    parambu.add(16908290, locala, com.go.weatherex.home.a.a.class.getName());
    parambu.add(16908290, localab, ab.class.getName());
    parambu.add(16908290, locale, e.class.getName());
    parambu.hide(localab);
    parambu.commit();
  }
  
  protected void a(com.go.weatherex.framework.fragment.a parama, Class paramClass, Bundle paramBundle)
  {
    com.gtp.a.a.b.c.a("HomeFragmentManager", paramClass.getName());
    if (this.e.contains(paramClass.getName())) {}
    Object localObject1;
    do
    {
      return;
      if (c.class.equals(paramClass))
      {
        parama = a().findFragmentByTag(e.class.getName()).getChildFragmentManager();
        localObject1 = (com.go.weatherex.framework.fragment.a)parama.findFragmentByTag(paramClass.getName());
        if (localObject1 == null)
        {
          paramBundle = (com.go.weatherex.framework.fragment.a)Fragment.instantiate(this.a, paramClass.getName(), paramBundle);
          paramBundle.b(this.a);
          parama.beginTransaction().add(2131231520, paramBundle, paramClass.getName()).commit();
          return;
        }
        a((com.go.weatherex.framework.fragment.a)localObject1, paramBundle);
        a(7, Boolean.valueOf(true));
        return;
      }
      if (b.class.equals(paramClass))
      {
        parama = a().findFragmentByTag(e.class.getName()).getChildFragmentManager();
        localObject1 = (com.go.weatherex.framework.fragment.a)parama.findFragmentByTag(paramClass.getName());
        if (localObject1 == null)
        {
          paramBundle = (com.go.weatherex.framework.fragment.a)Fragment.instantiate(this.a, paramClass.getName(), paramBundle);
          paramBundle.b(this.a);
          parama.beginTransaction().add(2131231520, paramBundle, paramClass.getName()).commit();
          return;
        }
        a((com.go.weatherex.framework.fragment.a)localObject1, paramBundle);
        a(8, Boolean.valueOf(true));
        return;
      }
      if (com.go.weatherex.home.current.t.class.equals(paramClass))
      {
        localObject1 = l().getChildFragmentManager();
        parama = ((FragmentManager)localObject1).beginTransaction();
        localObject1 = (com.go.weatherex.framework.fragment.a)((FragmentManager)localObject1).findFragmentByTag(paramClass.getName());
        if (localObject1 == null)
        {
          paramBundle = (com.go.weatherex.framework.fragment.a)Fragment.instantiate(this.a, paramClass.getName(), paramBundle);
          paramBundle.b(this.a);
          parama.add(2131231551, paramBundle, paramClass.getName());
        }
        for (;;)
        {
          parama.commit();
          a(13, Boolean.valueOf(false));
          return;
          a((com.go.weatherex.framework.fragment.a)localObject1, paramBundle);
          parama.show((Fragment)localObject1);
        }
      }
      if ((!com.go.weatherex.home.hourforecast.c.class.equals(paramClass)) && (!com.go.weatherex.home.dayforecast.g.class.equals(paramClass)) && (!com.go.weatherex.home.windforecast.c.class.equals(paramClass)) && (!com.go.weatherex.home.rain.g.class.equals(paramClass))) {
        break;
      }
    } while ((this.e.contains(com.go.weatherex.home.dayforecast.g.class.getName())) || (this.e.contains(com.go.weatherex.home.hourforecast.c.class.getName())) || (this.e.contains(com.go.weatherex.home.windforecast.c.class.getName())) || (this.e.contains(com.go.weatherex.home.rain.g.class.getName())) || (a(com.go.weatherex.home.dayforecast.g.class.getName())) || (a(com.go.weatherex.home.hourforecast.c.class.getName())) || (a(com.go.weatherex.home.windforecast.c.class.getName())) || (a(com.go.weatherex.home.rain.g.class.getName())));
    parama = paramBundle;
    if (paramBundle == null) {
      parama = new Bundle();
    }
    paramBundle = (Integer)this.c.get(paramClass.getName());
    if (paramBundle != null) {}
    for (int i = paramBundle.intValue();; i = 0)
    {
      if (i == 0)
      {
        bool = true;
        parama.putBoolean("extra_key_is_first_open_page", bool);
        this.c.put(paramClass.getName(), Integer.valueOf(i + 1));
        paramBundle = a().findFragmentByTag(ab.class.getName());
        a().beginTransaction().show(paramBundle).commit();
        localObject1 = l().getChildFragmentManager();
        paramBundle = ((FragmentManager)localObject1).beginTransaction();
        paramBundle.setCustomAnimations(2130968588, 2130968589, 2130968588, 2130968589);
        paramBundle.hide(((FragmentManager)localObject1).findFragmentByTag(com.go.weatherex.home.current.t.class.getName()));
        localObject1 = (com.go.weatherex.framework.fragment.a)((FragmentManager)localObject1).findFragmentByTag(paramClass.getName());
        if (localObject1 != null) {
          break label771;
        }
        parama = (com.go.weatherex.framework.fragment.a)Fragment.instantiate(this.a, paramClass.getName(), parama);
        parama.b(this.a);
        paramBundle.add(2131231551, parama, paramClass.getName());
        paramBundle.addToBackStack(paramClass.getName());
        this.e.add(paramClass.getName());
      }
      for (;;)
      {
        paramBundle.commit();
        a(11, Boolean.valueOf(false));
        a(13, Boolean.valueOf(true));
        a(17, Boolean.valueOf(false));
        return;
        bool = false;
        break;
        label771:
        a((com.go.weatherex.framework.fragment.a)localObject1, parama);
        paramBundle.show((Fragment)localObject1);
      }
      if ((com.go.weatherex.weatheralert.i.class.equals(paramClass)) || (com.go.weatherex.f.i.class.equals(paramClass)))
      {
        bool = m();
        localObject2 = a();
        parama = ((FragmentManager)localObject2).findFragmentByTag(e.class.getName());
        localObject1 = (com.go.weatherex.framework.fragment.a)((FragmentManager)localObject2).findFragmentByTag(paramClass.getName());
        localObject2 = ((FragmentManager)localObject2).beginTransaction();
        if (com.go.weatherex.f.i.class.equals(paramClass))
        {
          ((FragmentTransaction)localObject2).setCustomAnimations(2130968587, 2130968589, 2130968587, 2130968589);
          label880:
          ((FragmentTransaction)localObject2).hide(parama);
          if (localObject1 != null) {
            break label996;
          }
          parama = (com.go.weatherex.framework.fragment.a)Fragment.instantiate(this.a, paramClass.getName(), paramBundle);
          parama.b(this.a);
          ((FragmentTransaction)localObject2).add(16908290, parama, paramClass.getName());
          ((FragmentTransaction)localObject2).addToBackStack(paramClass.getName());
          this.e.add(paramClass.getName());
        }
        for (;;)
        {
          ((FragmentTransaction)localObject2).commit();
          if (!bool) {
            break;
          }
          a(13, Boolean.valueOf(true));
          return;
          ((FragmentTransaction)localObject2).setCustomAnimations(2130968588, 2130968589, 2130968588, 2130968589);
          break label880;
          label996:
          a((com.go.weatherex.framework.fragment.a)localObject1, paramBundle);
          ((FragmentTransaction)localObject2).show((Fragment)localObject1);
        }
      }
      if ((com.go.weatherex.f.a.class.equals(paramClass)) || (com.go.weatherex.f.t.class.equals(paramClass)))
      {
        localObject1 = a().findFragmentByTag(com.go.weatherex.f.i.class.getName()).getChildFragmentManager();
        parama = ((FragmentManager)localObject1).beginTransaction();
        localObject1 = (com.go.weatherex.framework.fragment.a)((FragmentManager)localObject1).findFragmentByTag(paramClass.getName());
        if (localObject1 == null)
        {
          paramBundle = (com.go.weatherex.framework.fragment.a)Fragment.instantiate(this.a, paramClass.getName(), paramBundle);
          paramBundle.b(this.a);
          parama.add(2131231340, paramBundle, paramClass.getName());
        }
        for (;;)
        {
          parama.commit();
          return;
          a((com.go.weatherex.framework.fragment.a)localObject1, paramBundle);
          parama.show((Fragment)localObject1);
        }
      }
      boolean bool = m();
      Object localObject2 = a();
      localObject1 = (com.go.weatherex.framework.fragment.a)((FragmentManager)localObject2).findFragmentByTag(paramClass.getName());
      localObject2 = ((FragmentManager)localObject2).beginTransaction();
      ((FragmentTransaction)localObject2).setCustomAnimations(2130968588, 2130968589, 2130968588, 2130968589);
      ((FragmentTransaction)localObject2).hide(parama);
      if (localObject1 == null)
      {
        parama = (com.go.weatherex.framework.fragment.a)Fragment.instantiate(this.a, paramClass.getName(), paramBundle);
        parama.b(this.a);
        ((FragmentTransaction)localObject2).add(16908290, parama, paramClass.getName());
        ((FragmentTransaction)localObject2).addToBackStack(paramClass.getName());
        this.e.add(paramClass.getName());
      }
      for (;;)
      {
        ((FragmentTransaction)localObject2).commit();
        if (!bool) {
          break;
        }
        a(13, Boolean.valueOf(true));
        return;
        a((com.go.weatherex.framework.fragment.a)localObject1, paramBundle);
        ((FragmentTransaction)localObject2).show((Fragment)localObject1);
      }
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  protected boolean a(com.go.weatherex.framework.fragment.a parama)
  {
    return super.a(parama);
  }
  
  protected void b(int paramInt, Object paramObject)
  {
    super.b(paramInt, paramObject);
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
      e_();
      return;
    }
    f_();
  }
  
  public void b(bu parambu)
  {
    if (!TextUtils.isEmpty(parambu.a))
    {
      a(10, parambu.a);
      a(12, parambu.a);
    }
  }
  
  protected void b(com.go.weatherex.framework.fragment.a parama)
  {
    if ((parama instanceof c))
    {
      parama.getChildFragmentManager().popBackStackImmediate();
      return;
    }
    super.b(parama);
  }
  
  public void c_() {}
  
  public void d(Fragment paramFragment)
  {
    super.d(paramFragment);
    if ((paramFragment instanceof c))
    {
      ((e)a().findFragmentByTag(e.class.getName())).b((com.go.weatherex.viewex.c)paramFragment.getView().findViewById(2131231547));
      paramFragment.getChildFragmentManager().addOnBackStackChangedListener(this);
    }
    while (!(paramFragment instanceof b)) {
      return;
    }
    ((e)a().findFragmentByTag(e.class.getName())).a((com.go.weatherex.viewex.c)paramFragment.getView().findViewById(2131231510));
  }
  
  protected boolean d()
  {
    if (m()) {
      return false;
    }
    if (a(b.class.getName()))
    {
      a(7, Boolean.valueOf(true));
      return true;
    }
    return super.d();
  }
  
  public void d_() {}
  
  public void e_()
  {
    this.b.push(b.class.getName());
    i();
  }
  
  public void f_()
  {
    this.b.pop();
    i();
  }
  
  public void g(Fragment paramFragment)
  {
    super.g(paramFragment);
  }
  
  public void onBackStackChanged()
  {
    int i = n();
    if (this.d > i) {
      k();
    }
    for (;;)
    {
      this.d = i;
      i();
      return;
      j();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */