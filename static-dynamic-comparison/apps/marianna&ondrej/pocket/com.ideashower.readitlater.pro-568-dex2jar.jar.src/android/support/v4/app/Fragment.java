package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.c.c;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Fragment
  implements ComponentCallbacks, View.OnCreateContextMenuListener
{
  private static final android.support.v4.c.l a = new android.support.v4.c.l();
  int A;
  l B;
  f C;
  l D;
  Fragment E;
  int F;
  int G;
  String H;
  boolean I;
  boolean J;
  boolean K;
  boolean L;
  boolean M;
  boolean N = true;
  boolean O;
  int P;
  ViewGroup Q;
  View R;
  View S;
  boolean T;
  boolean U = true;
  q V;
  boolean W;
  boolean X;
  int j = 0;
  View k;
  int l;
  Bundle m;
  SparseArray n;
  int o = -1;
  String p;
  Bundle q;
  Fragment r;
  int s = -1;
  int t;
  boolean u;
  boolean v;
  boolean w;
  boolean x;
  boolean y;
  boolean z;
  
  public static Fragment a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, null);
  }
  
  public static Fragment a(Context paramContext, String paramString, Bundle paramBundle)
  {
    try
    {
      Class localClass2 = (Class)a.get(paramString);
      Class localClass1 = localClass2;
      if (localClass2 == null)
      {
        localClass1 = paramContext.getClassLoader().loadClass(paramString);
        a.put(paramString, localClass1);
      }
      paramContext = (Fragment)localClass1.newInstance();
      if (paramBundle != null)
      {
        paramBundle.setClassLoader(paramContext.getClass().getClassLoader());
        paramContext.q = paramBundle;
      }
      return paramContext;
    }
    catch (ClassNotFoundException paramContext)
    {
      throw new e("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an" + " empty constructor that is public", paramContext);
    }
    catch (InstantiationException paramContext)
    {
      throw new e("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an" + " empty constructor that is public", paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new e("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an" + " empty constructor that is public", paramContext);
    }
  }
  
  static boolean b(Context paramContext, String paramString)
  {
    try
    {
      Class localClass2 = (Class)a.get(paramString);
      Class localClass1 = localClass2;
      if (localClass2 == null)
      {
        localClass1 = paramContext.getClassLoader().loadClass(paramString);
        a.put(paramString, localClass1);
      }
      boolean bool = Fragment.class.isAssignableFrom(localClass1);
      return bool;
    }
    catch (ClassNotFoundException paramContext) {}
    return false;
  }
  
  public void A() {}
  
  void B()
  {
    this.D = new l();
    this.D.a(this.C, new i()
    {
      public View a(int paramAnonymousInt)
      {
        if (Fragment.this.R == null) {
          throw new IllegalStateException("Fragment does not have a view");
        }
        return Fragment.this.R.findViewById(paramAnonymousInt);
      }
    }, this);
  }
  
  void C()
  {
    if (this.D != null)
    {
      this.D.k();
      this.D.g();
    }
    this.O = false;
    g();
    if (!this.O) {
      throw new ak("Fragment " + this + " did not call through to super.onStart()");
    }
    if (this.D != null) {
      this.D.n();
    }
    if (this.V != null) {
      this.V.g();
    }
  }
  
  void D()
  {
    if (this.D != null)
    {
      this.D.k();
      this.D.g();
    }
    this.O = false;
    w();
    if (!this.O) {
      throw new ak("Fragment " + this + " did not call through to super.onResume()");
    }
    if (this.D != null)
    {
      this.D.o();
      this.D.g();
    }
  }
  
  void E()
  {
    onLowMemory();
    if (this.D != null) {
      this.D.u();
    }
  }
  
  void F()
  {
    if (this.D != null) {
      this.D.p();
    }
    this.O = false;
    x();
    if (!this.O) {
      throw new ak("Fragment " + this + " did not call through to super.onPause()");
    }
  }
  
  void G()
  {
    if (this.D != null) {
      this.D.q();
    }
    this.O = false;
    h();
    if (!this.O) {
      throw new ak("Fragment " + this + " did not call through to super.onStop()");
    }
  }
  
  void H()
  {
    if (this.D != null) {
      this.D.r();
    }
    if (this.W)
    {
      this.W = false;
      if (!this.X)
      {
        this.X = true;
        this.V = this.C.a(this.p, this.W, false);
      }
      if (this.V != null)
      {
        if (this.C.h) {
          break label83;
        }
        this.V.c();
      }
    }
    return;
    label83:
    this.V.d();
  }
  
  void I()
  {
    if (this.D != null) {
      this.D.s();
    }
    this.O = false;
    i();
    if (!this.O) {
      throw new ak("Fragment " + this + " did not call through to super.onDestroyView()");
    }
    if (this.V != null) {
      this.V.f();
    }
  }
  
  void J()
  {
    if (this.D != null) {
      this.D.t();
    }
    this.O = false;
    y();
    if (!this.O) {
      throw new ak("Fragment " + this + " did not call through to super.onDestroy()");
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return null;
  }
  
  public Animation a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return null;
  }
  
  public final String a(int paramInt)
  {
    return n().getString(paramInt);
  }
  
  public final String a(int paramInt, Object... paramVarArgs)
  {
    return n().getString(paramInt, paramVarArgs);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  final void a(int paramInt, Fragment paramFragment)
  {
    this.o = paramInt;
    if (paramFragment != null)
    {
      this.p = (paramFragment.p + ":" + this.o);
      return;
    }
    this.p = ("android:fragment:" + this.o);
  }
  
  public void a(Activity paramActivity)
  {
    this.O = true;
  }
  
  public void a(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    this.O = true;
  }
  
  public void a(Intent paramIntent)
  {
    if (this.C == null) {
      throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }
    this.C.a(this, paramIntent, -1);
  }
  
  public void a(Intent paramIntent, int paramInt)
  {
    if (this.C == null) {
      throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }
    this.C.a(this, paramIntent, paramInt);
  }
  
  void a(Configuration paramConfiguration)
  {
    onConfigurationChanged(paramConfiguration);
    if (this.D != null) {
      this.D.a(paramConfiguration);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    this.O = true;
  }
  
  public void a(Menu paramMenu) {}
  
  public void a(Menu paramMenu, MenuInflater paramMenuInflater) {}
  
  public void a(View paramView, Bundle paramBundle) {}
  
  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mFragmentId=#");
    paramPrintWriter.print(Integer.toHexString(this.F));
    paramPrintWriter.print(" mContainerId=#");
    paramPrintWriter.print(Integer.toHexString(this.G));
    paramPrintWriter.print(" mTag=");
    paramPrintWriter.println(this.H);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mState=");
    paramPrintWriter.print(this.j);
    paramPrintWriter.print(" mIndex=");
    paramPrintWriter.print(this.o);
    paramPrintWriter.print(" mWho=");
    paramPrintWriter.print(this.p);
    paramPrintWriter.print(" mBackStackNesting=");
    paramPrintWriter.println(this.A);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mAdded=");
    paramPrintWriter.print(this.u);
    paramPrintWriter.print(" mRemoving=");
    paramPrintWriter.print(this.v);
    paramPrintWriter.print(" mResumed=");
    paramPrintWriter.print(this.w);
    paramPrintWriter.print(" mFromLayout=");
    paramPrintWriter.print(this.x);
    paramPrintWriter.print(" mInLayout=");
    paramPrintWriter.println(this.y);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mHidden=");
    paramPrintWriter.print(this.I);
    paramPrintWriter.print(" mDetached=");
    paramPrintWriter.print(this.J);
    paramPrintWriter.print(" mMenuVisible=");
    paramPrintWriter.print(this.N);
    paramPrintWriter.print(" mHasMenu=");
    paramPrintWriter.println(this.M);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mRetainInstance=");
    paramPrintWriter.print(this.K);
    paramPrintWriter.print(" mRetaining=");
    paramPrintWriter.print(this.L);
    paramPrintWriter.print(" mUserVisibleHint=");
    paramPrintWriter.println(this.U);
    if (this.B != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mFragmentManager=");
      paramPrintWriter.println(this.B);
    }
    if (this.C != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mActivity=");
      paramPrintWriter.println(this.C);
    }
    if (this.E != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mParentFragment=");
      paramPrintWriter.println(this.E);
    }
    if (this.q != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mArguments=");
      paramPrintWriter.println(this.q);
    }
    if (this.m != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedFragmentState=");
      paramPrintWriter.println(this.m);
    }
    if (this.n != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedViewState=");
      paramPrintWriter.println(this.n);
    }
    if (this.r != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTarget=");
      paramPrintWriter.print(this.r);
      paramPrintWriter.print(" mTargetRequestCode=");
      paramPrintWriter.println(this.t);
    }
    if (this.P != 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mNextAnim=");
      paramPrintWriter.println(this.P);
    }
    if (this.Q != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mContainer=");
      paramPrintWriter.println(this.Q);
    }
    if (this.R != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mView=");
      paramPrintWriter.println(this.R);
    }
    if (this.S != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mInnerView=");
      paramPrintWriter.println(this.R);
    }
    if (this.k != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAnimatingAway=");
      paramPrintWriter.println(this.k);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStateAfterAnimating=");
      paramPrintWriter.println(this.l);
    }
    if (this.V != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Loader Manager:");
      this.V.a(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    if (this.D != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Child " + this.D + ":");
      this.D.a(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  public boolean a(MenuItem paramMenuItem)
  {
    return false;
  }
  
  public LayoutInflater b(Bundle paramBundle)
  {
    return this.C.getLayoutInflater();
  }
  
  View b(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.D != null) {
      this.D.k();
    }
    return a(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void b(Menu paramMenu) {}
  
  boolean b(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    if (!this.I)
    {
      boolean bool1 = bool3;
      if (this.M)
      {
        bool1 = bool3;
        if (this.N)
        {
          bool1 = true;
          a(paramMenu, paramMenuInflater);
        }
      }
      bool2 = bool1;
      if (this.D != null) {
        bool2 = bool1 | this.D.a(paramMenu, paramMenuInflater);
      }
    }
    return bool2;
  }
  
  public boolean b(MenuItem paramMenuItem)
  {
    return false;
  }
  
  boolean c(Menu paramMenu)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    if (!this.I)
    {
      boolean bool1 = bool3;
      if (this.M)
      {
        bool1 = bool3;
        if (this.N)
        {
          bool1 = true;
          a(paramMenu);
        }
      }
      bool2 = bool1;
      if (this.D != null) {
        bool2 = bool1 | this.D.a(paramMenu);
      }
    }
    return bool2;
  }
  
  boolean c(MenuItem paramMenuItem)
  {
    if (!this.I)
    {
      if ((this.M) && (this.N) && (a(paramMenuItem))) {}
      while ((this.D != null) && (this.D.a(paramMenuItem))) {
        return true;
      }
    }
    return false;
  }
  
  public void d(Bundle paramBundle)
  {
    this.O = true;
  }
  
  void d(Menu paramMenu)
  {
    if (!this.I)
    {
      if ((this.M) && (this.N)) {
        b(paramMenu);
      }
      if (this.D != null) {
        this.D.b(paramMenu);
      }
    }
  }
  
  public void d(boolean paramBoolean) {}
  
  boolean d(MenuItem paramMenuItem)
  {
    if (!this.I)
    {
      if (b(paramMenuItem)) {}
      while ((this.D != null) && (this.D.b(paramMenuItem))) {
        return true;
      }
    }
    return false;
  }
  
  public void e(Bundle paramBundle) {}
  
  public final boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  public void f()
  {
    this.O = true;
  }
  
  final void f(Bundle paramBundle)
  {
    if (this.n != null)
    {
      this.S.restoreHierarchyState(this.n);
      this.n = null;
    }
    this.O = false;
    h(paramBundle);
    if (!this.O) {
      throw new ak("Fragment " + this + " did not call through to super.onViewStateRestored()");
    }
  }
  
  public void g()
  {
    this.O = true;
    if (!this.W)
    {
      this.W = true;
      if (!this.X)
      {
        this.X = true;
        this.V = this.C.a(this.p, this.W, false);
      }
      if (this.V != null) {
        this.V.b();
      }
    }
  }
  
  public void g(Bundle paramBundle)
  {
    if (this.o >= 0) {
      throw new IllegalStateException("Fragment already active");
    }
    this.q = paramBundle;
  }
  
  public void h()
  {
    this.O = true;
  }
  
  public void h(Bundle paramBundle)
  {
    this.O = true;
  }
  
  public final int hashCode()
  {
    return super.hashCode();
  }
  
  public void i()
  {
    this.O = true;
  }
  
  void i(Bundle paramBundle)
  {
    if (this.D != null) {
      this.D.k();
    }
    this.O = false;
    a(paramBundle);
    if (!this.O) {
      throw new ak("Fragment " + this + " did not call through to super.onCreate()");
    }
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getParcelable("android:support:fragments");
      if (paramBundle != null)
      {
        if (this.D == null) {
          B();
        }
        this.D.a(paramBundle, null);
        this.D.l();
      }
    }
  }
  
  void j(Bundle paramBundle)
  {
    if (this.D != null) {
      this.D.k();
    }
    this.O = false;
    d(paramBundle);
    if (!this.O) {
      throw new ak("Fragment " + this + " did not call through to super.onActivityCreated()");
    }
    if (this.D != null) {
      this.D.m();
    }
  }
  
  final boolean j()
  {
    return this.A > 0;
  }
  
  public final String k()
  {
    return this.H;
  }
  
  void k(Bundle paramBundle)
  {
    e(paramBundle);
    if (this.D != null)
    {
      Parcelable localParcelable = this.D.j();
      if (localParcelable != null) {
        paramBundle.putParcelable("android:support:fragments", localParcelable);
      }
    }
  }
  
  public final Bundle l()
  {
    return this.q;
  }
  
  public final f m()
  {
    return this.C;
  }
  
  public final Resources n()
  {
    if (this.C == null) {
      throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }
    return this.C.getResources();
  }
  
  public final j o()
  {
    return this.B;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.O = true;
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    m().onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }
  
  public void onLowMemory()
  {
    this.O = true;
  }
  
  public final boolean p()
  {
    return (this.C != null) && (this.u);
  }
  
  public final boolean q()
  {
    return this.J;
  }
  
  public final boolean r()
  {
    return this.v;
  }
  
  public final boolean s()
  {
    return this.w;
  }
  
  public final boolean t()
  {
    return (p()) && (!u()) && (this.R != null) && (this.R.getWindowToken() != null) && (this.R.getVisibility() == 0);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    c.a(this, localStringBuilder);
    if (this.o >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(this.o);
    }
    if (this.F != 0)
    {
      localStringBuilder.append(" id=0x");
      localStringBuilder.append(Integer.toHexString(this.F));
    }
    if (this.H != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.H);
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public final boolean u()
  {
    return this.I;
  }
  
  public View v()
  {
    return this.R;
  }
  
  public void w()
  {
    this.O = true;
  }
  
  public void x()
  {
    this.O = true;
  }
  
  public void y()
  {
    this.O = true;
    if (!this.X)
    {
      this.X = true;
      this.V = this.C.a(this.p, this.W, false);
    }
    if (this.V != null) {
      this.V.h();
    }
  }
  
  void z()
  {
    this.o = -1;
    this.p = null;
    this.u = false;
    this.v = false;
    this.w = false;
    this.x = false;
    this.y = false;
    this.z = false;
    this.A = 0;
    this.B = null;
    this.C = null;
    this.F = 0;
    this.G = 0;
    this.H = null;
    this.I = false;
    this.J = false;
    this.L = false;
    this.V = null;
    this.W = false;
    this.X = false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/app/Fragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */