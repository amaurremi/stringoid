package com.pocket.p;

import android.app.Activity;
import android.app.Dialog;
import android.support.v4.app.Fragment;
import android.support.v4.app.d;
import android.support.v4.app.j;
import android.support.v4.app.n;
import android.view.View;

public abstract class k
{
  public static void a(Fragment paramFragment, android.support.v4.app.f paramf)
  {
    paramf = paramf.e().a();
    paramf.a(paramFragment);
    paramf.a();
  }
  
  public static void a(Fragment paramFragment, android.support.v4.app.f paramf, int paramInt, String paramString, boolean paramBoolean)
  {
    a(paramFragment, paramf, paramInt, paramString, paramBoolean, true);
  }
  
  public static void a(Fragment paramFragment, android.support.v4.app.f paramf, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    n localn = paramf.e().a();
    localn.a(paramInt, paramFragment, paramString);
    if (paramBoolean1) {
      localn.a(null);
    }
    localn.a();
    if (paramBoolean2) {
      paramf.e().b();
    }
  }
  
  public static void a(d paramd)
  {
    if (paramd.e()) {
      paramd.c().setCanceledOnTouchOutside(false);
    }
  }
  
  public static void a(d paramd, android.support.v4.app.f paramf)
  {
    a(paramd, paramf, null);
  }
  
  public static void a(d paramd, android.support.v4.app.f paramf, String paramString)
  {
    a(paramd, paramf, paramString, true);
  }
  
  public static void a(d paramd, android.support.v4.app.f paramf, String paramString, boolean paramBoolean)
  {
    n localn = paramf.e().a();
    localn.a(null);
    paramd.a(localn, paramString);
    if (paramBoolean) {
      paramf.e().b();
    }
  }
  
  public static boolean a(Fragment paramFragment)
  {
    if (paramFragment == null) {}
    android.support.v4.app.f localf;
    do
    {
      return false;
      localf = paramFragment.m();
    } while ((localf != null) && (!localf.isFinishing()) && (!paramFragment.q()) && (!paramFragment.r()));
    return true;
  }
  
  public static boolean b(Fragment paramFragment)
  {
    return (paramFragment.m() != null) && (paramFragment.m().isFinishing());
  }
  
  public static View c(Fragment paramFragment)
  {
    if ((paramFragment instanceof com.ideashower.readitlater.activity.f)) {
      return ((com.ideashower.readitlater.activity.f)paramFragment).X();
    }
    return paramFragment.v();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/p/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */