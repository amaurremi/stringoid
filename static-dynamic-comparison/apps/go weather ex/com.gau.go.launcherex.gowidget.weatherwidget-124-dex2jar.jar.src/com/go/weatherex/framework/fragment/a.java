package com.go.weatherex.framework.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.view.View;
import com.go.weatherex.framework.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
  extends Fragment
  implements com.go.weatherex.framework.a.a
{
  private c a;
  private d b;
  private boolean c;
  private final f d = new f(this);
  
  private com.gau.go.launcherex.gowidget.d.a a(boolean paramBoolean)
  {
    if (this.b == null) {
      throw new IllegalStateException("do you forget to call onNew(Activity)");
    }
    com.gau.go.launcherex.gowidget.d.a locala = this.b.d();
    if ((locala == null) && (paramBoolean)) {
      throw new IllegalStateException("need to implements getCellBroadcastCenter in activity");
    }
    return locala;
  }
  
  private void a(Activity paramActivity)
  {
    if (this.b != null) {
      return;
    }
    if (paramActivity == null) {
      throw new IllegalStateException("fragment has not yet associate to activity");
    }
    if ((paramActivity instanceof d))
    {
      this.b = ((d)paramActivity);
      return;
    }
    throw new IllegalStateException("the attach activity of this fragment should implements FragmentFunctionExtended to make some features available");
  }
  
  private g b(boolean paramBoolean)
  {
    if (this.b == null) {
      throw new IllegalStateException("do you forget to call onNew(Activity)");
    }
    g localg = this.b.a();
    if ((localg == null) && (paramBoolean)) {
      throw new IllegalStateException("need to implements getGwFragmentManager in activity");
    }
    return localg;
  }
  
  private b c(boolean paramBoolean)
  {
    if (this.b == null) {
      throw new IllegalStateException("do you forget to call onNew(Activity)");
    }
    b localb = this.b.e();
    if ((localb == null) && (paramBoolean)) {
      throw new IllegalStateException("need to implements getWeatherChangeMonitor in activity");
    }
    return localb;
  }
  
  private com.go.weatherex.framework.a.a d(boolean paramBoolean)
  {
    if (this.b == null) {
      throw new IllegalStateException("do you forget to call onNew(Activity)");
    }
    com.go.weatherex.framework.a.a locala = this.b.f();
    if ((locala == null) && (paramBoolean)) {
      throw new IllegalStateException("need to implements getFontManager in activity");
    }
    return locala;
  }
  
  public final void a(int paramInt, Object paramObject)
  {
    a(true).a(paramInt, paramObject);
  }
  
  public final void a(int paramInt, Object paramObject, long paramLong, boolean paramBoolean)
  {
    a(true).a(paramInt, paramObject, paramLong, paramBoolean);
  }
  
  protected void a(Bundle paramBundle) {}
  
  public void a(View paramView)
  {
    a(paramView, 2, true);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    d(true).a(paramView, paramInt1, paramInt2);
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    d(true).a(paramView, paramInt, paramBoolean);
  }
  
  public final void a(com.go.weatherex.framework.a parama)
  {
    c(true).a(parama);
  }
  
  public final void a(Class paramClass, Bundle paramBundle)
  {
    b(true).a(this, paramClass, paramBundle);
  }
  
  public final void a(int... paramVarArgs)
  {
    com.gau.go.launcherex.gowidget.d.a locala = a(true);
    if (this.a == null) {
      this.a = new c(this, null);
    }
    locala.a(this.a, paramVarArgs);
  }
  
  protected boolean a()
  {
    FragmentManager localFragmentManager = getChildFragmentManager();
    if ((localFragmentManager != null) && (isResumed()) && (isVisible()) && (localFragmentManager.getBackStackEntryCount() > 0)) {
      return localFragmentManager.popBackStackImmediate();
    }
    return false;
  }
  
  protected void b(int paramInt, Object paramObject) {}
  
  public void b(Activity paramActivity)
  {
    a(paramActivity);
  }
  
  public final void b(com.go.weatherex.framework.a parama)
  {
    c(true).b(parama);
  }
  
  public final View c(int paramInt)
  {
    return getView().findViewById(paramInt);
  }
  
  boolean e()
  {
    return this.c;
  }
  
  protected void f()
  {
    Object localObject = getChildFragmentManager().getFragments();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Fragment localFragment = (Fragment)((Iterator)localObject).next();
        if ((localFragment instanceof a)) {
          ((a)localFragment).f();
        }
      }
    }
  }
  
  protected boolean g()
  {
    this.c = false;
    Object localObject = getChildFragmentManager();
    if ((localObject != null) && (((FragmentManager)localObject).getFragments() != null))
    {
      localObject = new ArrayList(((FragmentManager)localObject).getFragments());
      if (((List)localObject).size() > 0)
      {
        int i = ((List)localObject).size() - 1;
        while (i >= 0)
        {
          Fragment localFragment = (Fragment)((List)localObject).get(i);
          if ((localFragment != null) && (localFragment.isVisible()) && ((localFragment instanceof a)))
          {
            if (((a)localFragment).g()) {
              return true;
            }
            if (((a)localFragment).e())
            {
              this.c = true;
              return false;
            }
          }
          i -= 1;
        }
      }
    }
    localObject = b(false);
    if ((localObject != null) && (((g)localObject).a(this)))
    {
      this.c = true;
      return false;
    }
    return a();
  }
  
  public void h()
  {
    if ((isAdded()) && (isResumed())) {
      b(true).b(this);
    }
  }
  
  public f i()
  {
    return this.d;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = b(false);
    if (paramBundle != null) {
      paramBundle.e(this);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    a(paramActivity);
    paramActivity = b(false);
    if (paramActivity != null) {
      paramActivity.b(this);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = b(false);
    if (paramBundle != null) {
      paramBundle.c(this);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    g localg = b(false);
    if (localg != null) {
      localg.j(this);
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    Object localObject = b(false);
    if (localObject != null) {
      ((g)localObject).k(this);
    }
    localObject = a(false);
    if ((localObject != null) && (this.a != null))
    {
      ((com.gau.go.launcherex.gowidget.d.a)localObject).a(this.a);
      this.a = null;
    }
    this.b = null;
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    g localg = b(false);
    if (localg != null) {
      localg.l(this);
    }
  }
  
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    super.onInflate(paramActivity, paramAttributeSet, paramBundle);
    a(paramActivity);
    paramActivity = b(false);
    if (paramActivity != null) {
      paramActivity.a(this);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    g localg = b(false);
    if (localg != null) {
      localg.h(this);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    g localg = b(false);
    if (localg != null) {
      localg.g(this);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    g localg = b(false);
    if (localg != null) {
      localg.f(this);
    }
  }
  
  public void onStop()
  {
    super.onStop();
    g localg = b(false);
    if (localg != null) {
      localg.i(this);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramBundle = b(false);
    if (paramBundle != null) {
      paramBundle.d(this);
    }
    a(paramView);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/framework/fragment/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */