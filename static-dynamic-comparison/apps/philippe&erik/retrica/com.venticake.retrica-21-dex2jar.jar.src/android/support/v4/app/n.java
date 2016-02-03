package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.d.c;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class n
  extends l
{
  static final Interpolator A = new DecelerateInterpolator(1.5F);
  static final Interpolator B = new AccelerateInterpolator(2.5F);
  static final Interpolator C = new AccelerateInterpolator(1.5F);
  static boolean a;
  static final boolean b;
  static final Interpolator z;
  ArrayList<Runnable> c;
  Runnable[] d;
  boolean e;
  ArrayList<Fragment> f;
  ArrayList<Fragment> g;
  ArrayList<Integer> h;
  ArrayList<d> i;
  ArrayList<Fragment> j;
  ArrayList<d> k;
  ArrayList<Integer> l;
  ArrayList<m> m;
  int n = 0;
  h o;
  k p;
  Fragment q;
  boolean r;
  boolean s;
  boolean t;
  String u;
  boolean v;
  Bundle w = null;
  SparseArray<Parcelable> x = null;
  Runnable y = new Runnable()
  {
    public void run()
    {
      n.this.f();
    }
  };
  
  static
  {
    boolean bool = false;
    a = false;
    if (Build.VERSION.SDK_INT >= 11) {
      bool = true;
    }
    b = bool;
    z = new DecelerateInterpolator(2.5F);
  }
  
  static Animation a(Context paramContext, float paramFloat1, float paramFloat2)
  {
    paramContext = new AlphaAnimation(paramFloat1, paramFloat2);
    paramContext.setInterpolator(A);
    paramContext.setDuration(220L);
    return paramContext;
  }
  
  static Animation a(Context paramContext, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramContext = new AnimationSet(false);
    Object localObject = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setInterpolator(z);
    ((ScaleAnimation)localObject).setDuration(220L);
    paramContext.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(paramFloat3, paramFloat4);
    ((AlphaAnimation)localObject).setInterpolator(A);
    ((AlphaAnimation)localObject).setDuration(220L);
    paramContext.addAnimation((Animation)localObject);
    return paramContext;
  }
  
  private void a(RuntimeException paramRuntimeException)
  {
    Log.e("FragmentManager", paramRuntimeException.getMessage());
    Log.e("FragmentManager", "Activity state:");
    PrintWriter localPrintWriter = new PrintWriter(new android.support.v4.d.d("FragmentManager"));
    if (this.o != null) {}
    for (;;)
    {
      try
      {
        this.o.dump("  ", null, localPrintWriter, new String[0]);
        throw paramRuntimeException;
      }
      catch (Exception localException1)
      {
        Log.e("FragmentManager", "Failed dumping state", localException1);
        continue;
      }
      try
      {
        a("  ", null, localException1, new String[0]);
      }
      catch (Exception localException2)
      {
        Log.e("FragmentManager", "Failed dumping state", localException2);
      }
    }
  }
  
  public static int b(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 4097: 
      if (paramBoolean) {
        return 1;
      }
      return 2;
    case 8194: 
      if (paramBoolean) {
        return 3;
      }
      return 4;
    }
    if (paramBoolean) {
      return 5;
    }
    return 6;
  }
  
  public static int c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 4097: 
      return 8194;
    case 8194: 
      return 4097;
    }
    return 4099;
  }
  
  private void u()
  {
    if (this.s) {
      throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }
    if (this.u != null) {
      throw new IllegalStateException("Can not perform this action inside of " + this.u);
    }
  }
  
  public int a(d paramd)
  {
    try
    {
      if ((this.l == null) || (this.l.size() <= 0))
      {
        if (this.k == null) {
          this.k = new ArrayList();
        }
        i1 = this.k.size();
        if (a) {
          Log.v("FragmentManager", "Setting back stack index " + i1 + " to " + paramd);
        }
        this.k.add(paramd);
        return i1;
      }
      int i1 = ((Integer)this.l.remove(this.l.size() - 1)).intValue();
      if (a) {
        Log.v("FragmentManager", "Adding back stack index " + i1 + " with " + paramd);
      }
      this.k.set(i1, paramd);
      return i1;
    }
    finally {}
  }
  
  public Fragment a(int paramInt)
  {
    int i1;
    Object localObject;
    if (this.g != null)
    {
      i1 = this.g.size() - 1;
      while (i1 >= 0)
      {
        localObject = (Fragment)this.g.get(i1);
        if ((localObject != null) && (((Fragment)localObject).mFragmentId == paramInt)) {
          return (Fragment)localObject;
        }
        i1 -= 1;
      }
    }
    if (this.f != null)
    {
      i1 = this.f.size() - 1;
      for (;;)
      {
        if (i1 < 0) {
          break label112;
        }
        Fragment localFragment = (Fragment)this.f.get(i1);
        if (localFragment != null)
        {
          localObject = localFragment;
          if (localFragment.mFragmentId == paramInt) {
            break;
          }
        }
        i1 -= 1;
      }
    }
    label112:
    return null;
  }
  
  public Fragment a(Bundle paramBundle, String paramString)
  {
    int i1 = paramBundle.getInt(paramString, -1);
    if (i1 == -1) {
      paramBundle = null;
    }
    Fragment localFragment;
    do
    {
      return paramBundle;
      if (i1 >= this.f.size()) {
        a(new IllegalStateException("Fragement no longer exists for key " + paramString + ": index " + i1));
      }
      localFragment = (Fragment)this.f.get(i1);
      paramBundle = localFragment;
    } while (localFragment != null);
    a(new IllegalStateException("Fragement no longer exists for key " + paramString + ": index " + i1));
    return localFragment;
  }
  
  public Fragment a(String paramString)
  {
    int i1;
    Object localObject;
    if ((this.g != null) && (paramString != null))
    {
      i1 = this.g.size() - 1;
      while (i1 >= 0)
      {
        localObject = (Fragment)this.g.get(i1);
        if ((localObject != null) && (paramString.equals(((Fragment)localObject).mTag))) {
          return (Fragment)localObject;
        }
        i1 -= 1;
      }
    }
    if ((this.f != null) && (paramString != null))
    {
      i1 = this.f.size() - 1;
      for (;;)
      {
        if (i1 < 0) {
          break label126;
        }
        Fragment localFragment = (Fragment)this.f.get(i1);
        if (localFragment != null)
        {
          localObject = localFragment;
          if (paramString.equals(localFragment.mTag)) {
            break;
          }
        }
        i1 -= 1;
      }
    }
    label126:
    return null;
  }
  
  public p a()
  {
    return new d(this);
  }
  
  Animation a(Fragment paramFragment, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Animation localAnimation = paramFragment.onCreateAnimation(paramInt1, paramBoolean, paramFragment.mNextAnim);
    if (localAnimation != null) {
      paramFragment = localAnimation;
    }
    do
    {
      return paramFragment;
      if (paramFragment.mNextAnim == 0) {
        break;
      }
      localAnimation = AnimationUtils.loadAnimation(this.o, paramFragment.mNextAnim);
      paramFragment = localAnimation;
    } while (localAnimation != null);
    if (paramInt1 == 0) {
      return null;
    }
    paramInt1 = b(paramInt1, paramBoolean);
    if (paramInt1 < 0) {
      return null;
    }
    switch (paramInt1)
    {
    default: 
      paramInt1 = paramInt2;
      if (paramInt2 == 0)
      {
        paramInt1 = paramInt2;
        if (this.o.getWindow() != null) {
          paramInt1 = this.o.getWindow().getAttributes().windowAnimations;
        }
      }
      if (paramInt1 == 0) {
        return null;
      }
      break;
    case 1: 
      return a(this.o, 1.125F, 1.0F, 0.0F, 1.0F);
    case 2: 
      return a(this.o, 1.0F, 0.975F, 1.0F, 0.0F);
    case 3: 
      return a(this.o, 0.975F, 1.0F, 0.0F, 1.0F);
    case 4: 
      return a(this.o, 1.0F, 1.075F, 1.0F, 0.0F);
    case 5: 
      return a(this.o, 0.0F, 1.0F);
    case 6: 
      return a(this.o, 1.0F, 0.0F);
    }
    return null;
  }
  
  public void a(final int paramInt1, final int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("Bad id: " + paramInt1);
    }
    a(new Runnable()
    {
      public void run()
      {
        n.this.a(n.this.o.a, null, paramInt1, paramInt2);
      }
    }, false);
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if ((this.o == null) && (paramInt1 != 0)) {
      throw new IllegalStateException("No activity");
    }
    if ((!paramBoolean) && (this.n == paramInt1)) {}
    do
    {
      return;
      this.n = paramInt1;
    } while (this.f == null);
    int i1 = 0;
    boolean bool = false;
    label54:
    if (i1 < this.f.size())
    {
      Fragment localFragment = (Fragment)this.f.get(i1);
      if (localFragment == null) {
        break label169;
      }
      a(localFragment, paramInt1, paramInt2, paramInt3, false);
      if (localFragment.mLoaderManager == null) {
        break label169;
      }
      bool |= localFragment.mLoaderManager.a();
    }
    label169:
    for (;;)
    {
      i1 += 1;
      break label54;
      if (!bool) {
        e();
      }
      if ((!this.r) || (this.o == null) || (this.n != 5)) {
        break;
      }
      this.o.c();
      this.r = false;
      return;
    }
  }
  
  /* Error */
  public void a(int paramInt, d paramd)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 216	android/support/v4/app/n:k	Ljava/util/ArrayList;
    //   6: ifnonnull +14 -> 20
    //   9: aload_0
    //   10: new 210	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 217	java/util/ArrayList:<init>	()V
    //   17: putfield 216	android/support/v4/app/n:k	Ljava/util/ArrayList;
    //   20: aload_0
    //   21: getfield 216	android/support/v4/app/n:k	Ljava/util/ArrayList;
    //   24: invokevirtual 214	java/util/ArrayList:size	()I
    //   27: istore 4
    //   29: iload 4
    //   31: istore_3
    //   32: iload_1
    //   33: iload 4
    //   35: if_icmpge +56 -> 91
    //   38: getstatic 61	android/support/v4/app/n:a	Z
    //   41: ifeq +37 -> 78
    //   44: ldc -116
    //   46: new 195	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   53: ldc -37
    //   55: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: iload_1
    //   59: invokevirtual 222	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc -32
    //   64: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_2
    //   68: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 229	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   77: pop
    //   78: aload_0
    //   79: getfield 216	android/support/v4/app/n:k	Ljava/util/ArrayList;
    //   82: iload_1
    //   83: aload_2
    //   84: invokevirtual 250	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   87: pop
    //   88: aload_0
    //   89: monitorexit
    //   90: return
    //   91: iload_3
    //   92: iload_1
    //   93: if_icmpge +81 -> 174
    //   96: aload_0
    //   97: getfield 216	android/support/v4/app/n:k	Ljava/util/ArrayList;
    //   100: aconst_null
    //   101: invokevirtual 233	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   104: pop
    //   105: aload_0
    //   106: getfield 208	android/support/v4/app/n:l	Ljava/util/ArrayList;
    //   109: ifnonnull +14 -> 123
    //   112: aload_0
    //   113: new 210	java/util/ArrayList
    //   116: dup
    //   117: invokespecial 217	java/util/ArrayList:<init>	()V
    //   120: putfield 208	android/support/v4/app/n:l	Ljava/util/ArrayList;
    //   123: getstatic 61	android/support/v4/app/n:a	Z
    //   126: ifeq +29 -> 155
    //   129: ldc -116
    //   131: new 195	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   138: ldc_w 361
    //   141: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: iload_3
    //   145: invokevirtual 222	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   148: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 229	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   154: pop
    //   155: aload_0
    //   156: getfield 208	android/support/v4/app/n:l	Ljava/util/ArrayList;
    //   159: iload_3
    //   160: invokestatic 365	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   163: invokevirtual 233	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   166: pop
    //   167: iload_3
    //   168: iconst_1
    //   169: iadd
    //   170: istore_3
    //   171: goto -80 -> 91
    //   174: getstatic 61	android/support/v4/app/n:a	Z
    //   177: ifeq +37 -> 214
    //   180: ldc -116
    //   182: new 195	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   189: ldc -12
    //   191: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: iload_1
    //   195: invokevirtual 222	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   198: ldc -10
    //   200: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload_2
    //   204: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 229	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   213: pop
    //   214: aload_0
    //   215: getfield 216	android/support/v4/app/n:k	Ljava/util/ArrayList;
    //   218: aload_2
    //   219: invokevirtual 233	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   222: pop
    //   223: goto -135 -> 88
    //   226: astore_2
    //   227: aload_0
    //   228: monitorexit
    //   229: aload_2
    //   230: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	this	n
    //   0	231	1	paramInt	int
    //   0	231	2	paramd	d
    //   31	140	3	i1	int
    //   27	9	4	i2	int
    // Exception table:
    //   from	to	target	type
    //   2	20	226	finally
    //   20	29	226	finally
    //   38	78	226	finally
    //   78	88	226	finally
    //   88	90	226	finally
    //   96	123	226	finally
    //   123	155	226	finally
    //   155	167	226	finally
    //   174	214	226	finally
    //   214	223	226	finally
    //   227	229	226	finally
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, 0, 0, paramBoolean);
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.g != null)
    {
      int i1 = 0;
      while (i1 < this.g.size())
      {
        Fragment localFragment = (Fragment)this.g.get(i1);
        if (localFragment != null) {
          localFragment.performConfigurationChanged(paramConfiguration);
        }
        i1 += 1;
      }
    }
  }
  
  public void a(Bundle paramBundle, String paramString, Fragment paramFragment)
  {
    if (paramFragment.mIndex < 0) {
      a(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager"));
    }
    paramBundle.putInt(paramString, paramFragment.mIndex);
  }
  
  void a(Parcelable paramParcelable, ArrayList<Fragment> paramArrayList)
  {
    if (paramParcelable == null) {}
    for (;;)
    {
      return;
      paramParcelable = (FragmentManagerState)paramParcelable;
      if (paramParcelable.a != null)
      {
        Object localObject1;
        Object localObject2;
        if (paramArrayList != null)
        {
          i1 = 0;
          while (i1 < paramArrayList.size())
          {
            localObject1 = (Fragment)paramArrayList.get(i1);
            if (a) {
              Log.v("FragmentManager", "restoreAllState: re-attaching retained " + localObject1);
            }
            localObject2 = paramParcelable.a[localObject1.mIndex];
            ((FragmentState)localObject2).k = ((Fragment)localObject1);
            ((Fragment)localObject1).mSavedViewState = null;
            ((Fragment)localObject1).mBackStackNesting = 0;
            ((Fragment)localObject1).mInLayout = false;
            ((Fragment)localObject1).mAdded = false;
            ((Fragment)localObject1).mTarget = null;
            if (((FragmentState)localObject2).j != null)
            {
              ((FragmentState)localObject2).j.setClassLoader(this.o.getClassLoader());
              ((Fragment)localObject1).mSavedViewState = ((FragmentState)localObject2).j.getSparseParcelableArray("android:view_state");
            }
            i1 += 1;
          }
        }
        this.f = new ArrayList(paramParcelable.a.length);
        if (this.h != null) {
          this.h.clear();
        }
        int i1 = 0;
        if (i1 < paramParcelable.a.length)
        {
          localObject1 = paramParcelable.a[i1];
          if (localObject1 != null)
          {
            localObject2 = ((FragmentState)localObject1).a(this.o, this.q);
            if (a) {
              Log.v("FragmentManager", "restoreAllState: active #" + i1 + ": " + localObject2);
            }
            this.f.add(localObject2);
            ((FragmentState)localObject1).k = null;
          }
          for (;;)
          {
            i1 += 1;
            break;
            this.f.add(null);
            if (this.h == null) {
              this.h = new ArrayList();
            }
            if (a) {
              Log.v("FragmentManager", "restoreAllState: avail #" + i1);
            }
            this.h.add(Integer.valueOf(i1));
          }
        }
        if (paramArrayList != null)
        {
          i1 = 0;
          if (i1 < paramArrayList.size())
          {
            localObject1 = (Fragment)paramArrayList.get(i1);
            if (((Fragment)localObject1).mTargetIndex >= 0) {
              if (((Fragment)localObject1).mTargetIndex >= this.f.size()) {
                break label452;
              }
            }
            for (((Fragment)localObject1).mTarget = ((Fragment)this.f.get(((Fragment)localObject1).mTargetIndex));; ((Fragment)localObject1).mTarget = null)
            {
              i1 += 1;
              break;
              label452:
              Log.w("FragmentManager", "Re-attaching retained fragment " + localObject1 + " target no longer exists: " + ((Fragment)localObject1).mTargetIndex);
            }
          }
        }
        if (paramParcelable.b != null)
        {
          this.g = new ArrayList(paramParcelable.b.length);
          i1 = 0;
          while (i1 < paramParcelable.b.length)
          {
            paramArrayList = (Fragment)this.f.get(paramParcelable.b[i1]);
            if (paramArrayList == null) {
              a(new IllegalStateException("No instantiated fragment for index #" + paramParcelable.b[i1]));
            }
            paramArrayList.mAdded = true;
            if (a) {
              Log.v("FragmentManager", "restoreAllState: added #" + i1 + ": " + paramArrayList);
            }
            if (this.g.contains(paramArrayList)) {
              throw new IllegalStateException("Already added!");
            }
            this.g.add(paramArrayList);
            i1 += 1;
          }
        }
        this.g = null;
        if (paramParcelable.c == null) {
          break;
        }
        this.i = new ArrayList(paramParcelable.c.length);
        i1 = 0;
        while (i1 < paramParcelable.c.length)
        {
          paramArrayList = paramParcelable.c[i1].a(this);
          if (a)
          {
            Log.v("FragmentManager", "restoreAllState: back stack #" + i1 + " (index " + paramArrayList.o + "): " + paramArrayList);
            paramArrayList.a("  ", new PrintWriter(new android.support.v4.d.d("FragmentManager")), false);
          }
          this.i.add(paramArrayList);
          if (paramArrayList.o >= 0) {
            a(paramArrayList.o, paramArrayList);
          }
          i1 += 1;
        }
      }
    }
    this.i = null;
  }
  
  public void a(Fragment paramFragment)
  {
    if (paramFragment.mDeferStart)
    {
      if (this.e) {
        this.v = true;
      }
    }
    else {
      return;
    }
    paramFragment.mDeferStart = false;
    a(paramFragment, this.n, 0, 0, false);
  }
  
  public void a(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (a) {
      Log.v("FragmentManager", "remove: " + paramFragment + " nesting=" + paramFragment.mBackStackNesting);
    }
    if (!paramFragment.isInBackStack())
    {
      i1 = 1;
      if ((!paramFragment.mDetached) || (i1 != 0))
      {
        if (this.g != null) {
          this.g.remove(paramFragment);
        }
        if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
          this.r = true;
        }
        paramFragment.mAdded = false;
        paramFragment.mRemoving = true;
        if (i1 == 0) {
          break label137;
        }
      }
    }
    label137:
    for (int i1 = 0;; i1 = 1)
    {
      a(paramFragment, i1, paramInt1, paramInt2, false);
      return;
      i1 = 0;
      break;
    }
  }
  
  void a(final Fragment paramFragment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i1;
    if (paramFragment.mAdded)
    {
      i1 = paramInt1;
      if (!paramFragment.mDetached) {}
    }
    else
    {
      i1 = paramInt1;
      if (paramInt1 > 1) {
        i1 = 1;
      }
    }
    int i2 = i1;
    if (paramFragment.mRemoving)
    {
      i2 = i1;
      if (i1 > paramFragment.mState) {
        i2 = paramFragment.mState;
      }
    }
    paramInt1 = i2;
    if (paramFragment.mDeferStart)
    {
      paramInt1 = i2;
      if (paramFragment.mState < 4)
      {
        paramInt1 = i2;
        if (i2 > 3) {
          paramInt1 = 3;
        }
      }
    }
    int i3;
    label557:
    Object localObject2;
    if (paramFragment.mState < paramInt1)
    {
      if ((paramFragment.mFromLayout) && (!paramFragment.mInLayout)) {
        return;
      }
      if (paramFragment.mAnimatingAway != null)
      {
        paramFragment.mAnimatingAway = null;
        a(paramFragment, paramFragment.mStateAfterAnimating, 0, 0, true);
      }
      i1 = paramInt1;
      i3 = paramInt1;
      i2 = paramInt1;
      switch (paramFragment.mState)
      {
      default: 
        i1 = paramInt1;
        paramFragment.mState = i1;
        return;
      case 0: 
        if (a) {
          Log.v("FragmentManager", "moveto CREATED: " + paramFragment);
        }
        i2 = paramInt1;
        if (paramFragment.mSavedFragmentState != null)
        {
          paramFragment.mSavedViewState = paramFragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
          paramFragment.mTarget = a(paramFragment.mSavedFragmentState, "android:target_state");
          if (paramFragment.mTarget != null) {
            paramFragment.mTargetRequestCode = paramFragment.mSavedFragmentState.getInt("android:target_req_state", 0);
          }
          paramFragment.mUserVisibleHint = paramFragment.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
          i2 = paramInt1;
          if (!paramFragment.mUserVisibleHint)
          {
            paramFragment.mDeferStart = true;
            i2 = paramInt1;
            if (paramInt1 > 3) {
              i2 = 3;
            }
          }
        }
        paramFragment.mActivity = this.o;
        paramFragment.mParentFragment = this.q;
        if (this.q != null) {}
        for (localObject1 = this.q.mChildFragmentManager;; localObject1 = this.o.b)
        {
          paramFragment.mFragmentManager = ((n)localObject1);
          paramFragment.mCalled = false;
          paramFragment.onAttach(this.o);
          if (paramFragment.mCalled) {
            break;
          }
          throw new aa("Fragment " + paramFragment + " did not call through to super.onAttach()");
        }
        if (paramFragment.mParentFragment == null) {
          this.o.a(paramFragment);
        }
        if (!paramFragment.mRetaining) {
          paramFragment.performCreate(paramFragment.mSavedFragmentState);
        }
        paramFragment.mRetaining = false;
        i1 = i2;
        if (paramFragment.mFromLayout)
        {
          paramFragment.mView = paramFragment.performCreateView(paramFragment.getLayoutInflater(paramFragment.mSavedFragmentState), null, paramFragment.mSavedFragmentState);
          if (paramFragment.mView == null) {
            break label993;
          }
          paramFragment.mInnerView = paramFragment.mView;
          paramFragment.mView = z.a(paramFragment.mView);
          if (paramFragment.mHidden) {
            paramFragment.mView.setVisibility(8);
          }
          paramFragment.onViewCreated(paramFragment.mView, paramFragment.mSavedFragmentState);
          i1 = i2;
        }
      case 1: 
        i3 = i1;
        if (i1 > 1)
        {
          if (a) {
            Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + paramFragment);
          }
          if (!paramFragment.mFromLayout)
          {
            if (paramFragment.mContainerId == 0) {
              break label1574;
            }
            localObject2 = (ViewGroup)this.p.a(paramFragment.mContainerId);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = localObject2;
              if (!paramFragment.mRestored) {
                a(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(paramFragment.mContainerId) + " (" + paramFragment.getResources().getResourceName(paramFragment.mContainerId) + ") for fragment " + paramFragment));
              }
            }
          }
        }
        break;
      }
    }
    label993:
    label1070:
    label1433:
    label1568:
    label1574:
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      paramFragment.mContainer = ((ViewGroup)localObject1);
      paramFragment.mView = paramFragment.performCreateView(paramFragment.getLayoutInflater(paramFragment.mSavedFragmentState), (ViewGroup)localObject1, paramFragment.mSavedFragmentState);
      if (paramFragment.mView != null)
      {
        paramFragment.mInnerView = paramFragment.mView;
        paramFragment.mView = z.a(paramFragment.mView);
        if (localObject1 != null)
        {
          localObject2 = a(paramFragment, paramInt2, true, paramInt3);
          if (localObject2 != null) {
            paramFragment.mView.startAnimation((Animation)localObject2);
          }
          ((ViewGroup)localObject1).addView(paramFragment.mView);
        }
        if (paramFragment.mHidden) {
          paramFragment.mView.setVisibility(8);
        }
        paramFragment.onViewCreated(paramFragment.mView, paramFragment.mSavedFragmentState);
      }
      for (;;)
      {
        paramFragment.performActivityCreated(paramFragment.mSavedFragmentState);
        if (paramFragment.mView != null) {
          paramFragment.restoreViewState(paramFragment.mSavedFragmentState);
        }
        paramFragment.mSavedFragmentState = null;
        i3 = i1;
        i2 = i3;
        if (i3 > 3)
        {
          if (a) {
            Log.v("FragmentManager", "moveto STARTED: " + paramFragment);
          }
          paramFragment.performStart();
          i2 = i3;
        }
        i1 = i2;
        if (i2 <= 4) {
          break;
        }
        if (a) {
          Log.v("FragmentManager", "moveto RESUMED: " + paramFragment);
        }
        paramFragment.mResumed = true;
        paramFragment.performResume();
        paramFragment.mSavedFragmentState = null;
        paramFragment.mSavedViewState = null;
        i1 = i2;
        break;
        paramFragment.mInnerView = null;
        i1 = i2;
        break label557;
        paramFragment.mInnerView = null;
      }
      i1 = paramInt1;
      if (paramFragment.mState <= paramInt1) {
        break;
      }
      switch (paramFragment.mState)
      {
      default: 
        i1 = paramInt1;
        break;
      case 1: 
      case 5: 
      case 4: 
      case 3: 
      case 2: 
        do
        {
          i1 = paramInt1;
          if (paramInt1 >= 1) {
            break;
          }
          if ((this.t) && (paramFragment.mAnimatingAway != null))
          {
            localObject1 = paramFragment.mAnimatingAway;
            paramFragment.mAnimatingAway = null;
            ((View)localObject1).clearAnimation();
          }
          if (paramFragment.mAnimatingAway == null) {
            break label1433;
          }
          paramFragment.mStateAfterAnimating = paramInt1;
          i1 = 1;
          break;
          if (paramInt1 < 5)
          {
            if (a) {
              Log.v("FragmentManager", "movefrom RESUMED: " + paramFragment);
            }
            paramFragment.performPause();
            paramFragment.mResumed = false;
          }
          if (paramInt1 < 4)
          {
            if (a) {
              Log.v("FragmentManager", "movefrom STARTED: " + paramFragment);
            }
            paramFragment.performStop();
          }
          if (paramInt1 < 3)
          {
            if (a) {
              Log.v("FragmentManager", "movefrom STOPPED: " + paramFragment);
            }
            paramFragment.performReallyStop();
          }
        } while (paramInt1 >= 2);
        if (a) {
          Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + paramFragment);
        }
        if ((paramFragment.mView != null) && (!this.o.isFinishing()) && (paramFragment.mSavedViewState == null)) {
          e(paramFragment);
        }
        paramFragment.performDestroyView();
        if ((paramFragment.mView != null) && (paramFragment.mContainer != null)) {
          if ((this.n <= 0) || (this.t)) {
            break label1568;
          }
        }
        for (localObject1 = a(paramFragment, paramInt2, false, paramInt3);; localObject1 = null)
        {
          if (localObject1 != null)
          {
            paramFragment.mAnimatingAway = paramFragment.mView;
            paramFragment.mStateAfterAnimating = paramInt1;
            ((Animation)localObject1).setAnimationListener(new Animation.AnimationListener()
            {
              public void onAnimationEnd(Animation paramAnonymousAnimation)
              {
                if (paramFragment.mAnimatingAway != null)
                {
                  paramFragment.mAnimatingAway = null;
                  n.this.a(paramFragment, paramFragment.mStateAfterAnimating, 0, 0, false);
                }
              }
              
              public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
              
              public void onAnimationStart(Animation paramAnonymousAnimation) {}
            });
            paramFragment.mView.startAnimation((Animation)localObject1);
          }
          paramFragment.mContainer.removeView(paramFragment.mView);
          paramFragment.mContainer = null;
          paramFragment.mView = null;
          paramFragment.mInnerView = null;
          break label1070;
          if (a) {
            Log.v("FragmentManager", "movefrom CREATED: " + paramFragment);
          }
          if (!paramFragment.mRetaining) {
            paramFragment.performDestroy();
          }
          paramFragment.mCalled = false;
          paramFragment.onDetach();
          if (!paramFragment.mCalled) {
            throw new aa("Fragment " + paramFragment + " did not call through to super.onDetach()");
          }
          i1 = paramInt1;
          if (paramBoolean) {
            break;
          }
          if (!paramFragment.mRetaining)
          {
            d(paramFragment);
            i1 = paramInt1;
            break;
          }
          paramFragment.mActivity = null;
          paramFragment.mFragmentManager = null;
          i1 = paramInt1;
          break;
        }
      }
    }
  }
  
  public void a(Fragment paramFragment, boolean paramBoolean)
  {
    if (this.g == null) {
      this.g = new ArrayList();
    }
    if (a) {
      Log.v("FragmentManager", "add: " + paramFragment);
    }
    c(paramFragment);
    if (!paramFragment.mDetached)
    {
      if (this.g.contains(paramFragment)) {
        throw new IllegalStateException("Fragment already added: " + paramFragment);
      }
      this.g.add(paramFragment);
      paramFragment.mAdded = true;
      paramFragment.mRemoving = false;
      if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
        this.r = true;
      }
      if (paramBoolean) {
        b(paramFragment);
      }
    }
  }
  
  public void a(h paramh, k paramk, Fragment paramFragment)
  {
    if (this.o != null) {
      throw new IllegalStateException("Already attached");
    }
    this.o = paramh;
    this.p = paramk;
    this.q = paramFragment;
  }
  
  public void a(Runnable paramRunnable, boolean paramBoolean)
  {
    if (!paramBoolean) {
      u();
    }
    try
    {
      if ((this.t) || (this.o == null)) {
        throw new IllegalStateException("Activity has been destroyed");
      }
    }
    finally
    {
      throw paramRunnable;
      if (this.c == null) {
        this.c = new ArrayList();
      }
      this.c.add(paramRunnable);
      if (this.c.size() == 1) {
        this.o.a.removeCallbacks(this.y);
      }
    }
  }
  
  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int i2 = 0;
    String str = paramString + "    ";
    int i3;
    int i1;
    Object localObject;
    if (this.f != null)
    {
      i3 = this.f.size();
      if (i3 > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("Active Fragments in ");
        paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
        paramPrintWriter.println(":");
        i1 = 0;
        while (i1 < i3)
        {
          localObject = (Fragment)this.f.get(i1);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i1);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localObject);
          if (localObject != null) {
            ((Fragment)localObject).dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
          }
          i1 += 1;
        }
      }
    }
    if (this.g != null)
    {
      i3 = this.g.size();
      if (i3 > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Added Fragments:");
        i1 = 0;
        while (i1 < i3)
        {
          localObject = (Fragment)this.g.get(i1);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i1);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(((Fragment)localObject).toString());
          i1 += 1;
        }
      }
    }
    if (this.j != null)
    {
      i3 = this.j.size();
      if (i3 > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Fragments Created Menus:");
        i1 = 0;
        while (i1 < i3)
        {
          localObject = (Fragment)this.j.get(i1);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i1);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(((Fragment)localObject).toString());
          i1 += 1;
        }
      }
    }
    if (this.i != null)
    {
      i3 = this.i.size();
      if (i3 > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Back Stack:");
        i1 = 0;
        while (i1 < i3)
        {
          localObject = (d)this.i.get(i1);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i1);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(((d)localObject).toString());
          ((d)localObject).a(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
          i1 += 1;
        }
      }
    }
    try
    {
      if (this.k != null)
      {
        i3 = this.k.size();
        if (i3 > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Back Stack Indices:");
          i1 = 0;
          while (i1 < i3)
          {
            paramFileDescriptor = (d)this.k.get(i1);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i1);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(paramFileDescriptor);
            i1 += 1;
          }
        }
      }
      if ((this.l != null) && (this.l.size() > 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mAvailBackStackIndices: ");
        paramPrintWriter.println(Arrays.toString(this.l.toArray()));
      }
      if (this.c != null)
      {
        i3 = this.c.size();
        if (i3 > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Pending Actions:");
          i1 = i2;
          while (i1 < i3)
          {
            paramFileDescriptor = (Runnable)this.c.get(i1);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i1);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(paramFileDescriptor);
            i1 += 1;
          }
        }
      }
      paramPrintWriter.print(paramString);
    }
    finally {}
    paramPrintWriter.println("FragmentManager misc state:");
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mActivity=");
    paramPrintWriter.println(this.o);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mContainer=");
    paramPrintWriter.println(this.p);
    if (this.q != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mParent=");
      paramPrintWriter.println(this.q);
    }
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mCurState=");
    paramPrintWriter.print(this.n);
    paramPrintWriter.print(" mStateSaved=");
    paramPrintWriter.print(this.s);
    paramPrintWriter.print(" mDestroyed=");
    paramPrintWriter.println(this.t);
    if (this.r)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mNeedMenuInvalidate=");
      paramPrintWriter.println(this.r);
    }
    if (this.u != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mNoTransactionsBecause=");
      paramPrintWriter.println(this.u);
    }
    if ((this.h != null) && (this.h.size() > 0))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mAvailIndices: ");
      paramPrintWriter.println(Arrays.toString(this.h.toArray()));
    }
  }
  
  boolean a(Handler paramHandler, String paramString, int paramInt1, int paramInt2)
  {
    if (this.i == null) {
      break label114;
    }
    label7:
    do
    {
      return false;
      if ((paramString != null) || (paramInt1 >= 0) || ((paramInt2 & 0x1) != 0)) {
        break;
      }
      paramInt1 = this.i.size() - 1;
    } while (paramInt1 < 0);
    ((d)this.i.remove(paramInt1)).b(true);
    g();
    for (;;)
    {
      return true;
      int i1 = -1;
      if ((paramString != null) || (paramInt1 >= 0))
      {
        int i2 = this.i.size() - 1;
        for (;;)
        {
          if (i2 >= 0)
          {
            paramHandler = (d)this.i.get(i2);
            if ((paramString == null) || (!paramString.equals(paramHandler.c()))) {}
          }
          else
          {
            label114:
            if (i2 < 0) {
              break label7;
            }
            i1 = i2;
            if ((paramInt2 & 0x1) == 0) {
              break label223;
            }
            paramInt2 = i2 - 1;
            for (;;)
            {
              i1 = paramInt2;
              if (paramInt2 < 0) {
                break;
              }
              paramHandler = (d)this.i.get(paramInt2);
              if ((paramString == null) || (!paramString.equals(paramHandler.c())))
              {
                i1 = paramInt2;
                if (paramInt1 < 0) {
                  break;
                }
                i1 = paramInt2;
                if (paramInt1 != paramHandler.o) {
                  break;
                }
              }
              paramInt2 -= 1;
            }
          }
          if ((paramInt1 >= 0) && (paramInt1 == paramHandler.o)) {
            break;
          }
          i2 -= 1;
        }
      }
      label223:
      if (i1 == this.i.size() - 1) {
        break label7;
      }
      paramHandler = new ArrayList();
      paramInt1 = this.i.size() - 1;
      while (paramInt1 > i1)
      {
        paramHandler.add(this.i.remove(paramInt1));
        paramInt1 -= 1;
      }
      paramInt2 = paramHandler.size() - 1;
      paramInt1 = 0;
      if (paramInt1 <= paramInt2)
      {
        if (a) {
          Log.v("FragmentManager", "Popping back stack state: " + paramHandler.get(paramInt1));
        }
        paramString = (d)paramHandler.get(paramInt1);
        if (paramInt1 == paramInt2) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.b(bool);
          paramInt1 += 1;
          break;
        }
      }
      g();
    }
  }
  
  public boolean a(Menu paramMenu)
  {
    if (this.g != null)
    {
      int i1 = 0;
      for (boolean bool1 = false;; bool1 = bool2)
      {
        bool2 = bool1;
        if (i1 >= this.g.size()) {
          break;
        }
        Fragment localFragment = (Fragment)this.g.get(i1);
        bool2 = bool1;
        if (localFragment != null)
        {
          bool2 = bool1;
          if (localFragment.performPrepareOptionsMenu(paramMenu)) {
            bool2 = true;
          }
        }
        i1 += 1;
      }
    }
    boolean bool2 = false;
    return bool2;
  }
  
  public boolean a(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    int i2 = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    int i1;
    if (this.g != null)
    {
      i1 = 0;
      boolean bool1 = false;
      for (;;)
      {
        localObject2 = localObject1;
        bool2 = bool1;
        if (i1 >= this.g.size()) {
          break;
        }
        Fragment localFragment = (Fragment)this.g.get(i1);
        localObject2 = localObject1;
        bool2 = bool1;
        if (localFragment != null)
        {
          localObject2 = localObject1;
          bool2 = bool1;
          if (localFragment.performCreateOptionsMenu(paramMenu, paramMenuInflater))
          {
            bool2 = true;
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            ((ArrayList)localObject2).add(localFragment);
          }
        }
        i1 += 1;
        bool1 = bool2;
        localObject1 = localObject2;
      }
    }
    boolean bool2 = false;
    if (this.j != null)
    {
      i1 = i2;
      while (i1 < this.j.size())
      {
        paramMenu = (Fragment)this.j.get(i1);
        if ((localObject2 == null) || (!((ArrayList)localObject2).contains(paramMenu))) {
          paramMenu.onDestroyOptionsMenu();
        }
        i1 += 1;
      }
    }
    this.j = ((ArrayList)localObject2);
    return bool2;
  }
  
  public boolean a(MenuItem paramMenuItem)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i1;
    if (this.g != null) {
      i1 = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i1 < this.g.size())
      {
        Fragment localFragment = (Fragment)this.g.get(i1);
        if ((localFragment != null) && (localFragment.performOptionsItemSelected(paramMenuItem))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public Fragment b(String paramString)
  {
    if ((this.f != null) && (paramString != null))
    {
      int i1 = this.f.size() - 1;
      while (i1 >= 0)
      {
        Fragment localFragment = (Fragment)this.f.get(i1);
        if (localFragment != null)
        {
          localFragment = localFragment.findFragmentByWho(paramString);
          if (localFragment != null) {
            return localFragment;
          }
        }
        i1 -= 1;
      }
    }
    return null;
  }
  
  public void b(int paramInt)
  {
    try
    {
      this.k.set(paramInt, null);
      if (this.l == null) {
        this.l = new ArrayList();
      }
      if (a) {
        Log.v("FragmentManager", "Freeing back stack index " + paramInt);
      }
      this.l.add(Integer.valueOf(paramInt));
      return;
    }
    finally {}
  }
  
  void b(Fragment paramFragment)
  {
    a(paramFragment, this.n, 0, 0, false);
  }
  
  public void b(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (a) {
      Log.v("FragmentManager", "hide: " + paramFragment);
    }
    if (!paramFragment.mHidden)
    {
      paramFragment.mHidden = true;
      if (paramFragment.mView != null)
      {
        Animation localAnimation = a(paramFragment, paramInt1, false, paramInt2);
        if (localAnimation != null) {
          paramFragment.mView.startAnimation(localAnimation);
        }
        paramFragment.mView.setVisibility(8);
      }
      if ((paramFragment.mAdded) && (paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
        this.r = true;
      }
      paramFragment.onHiddenChanged(true);
    }
  }
  
  void b(d paramd)
  {
    if (this.i == null) {
      this.i = new ArrayList();
    }
    this.i.add(paramd);
    g();
  }
  
  public void b(Menu paramMenu)
  {
    if (this.g != null)
    {
      int i1 = 0;
      while (i1 < this.g.size())
      {
        Fragment localFragment = (Fragment)this.g.get(i1);
        if (localFragment != null) {
          localFragment.performOptionsMenuClosed(paramMenu);
        }
        i1 += 1;
      }
    }
  }
  
  public boolean b()
  {
    return f();
  }
  
  public boolean b(MenuItem paramMenuItem)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i1;
    if (this.g != null) {
      i1 = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i1 < this.g.size())
      {
        Fragment localFragment = (Fragment)this.g.get(i1);
        if ((localFragment != null) && (localFragment.performContextItemSelected(paramMenuItem))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public List<Fragment> c()
  {
    return this.f;
  }
  
  void c(Fragment paramFragment)
  {
    if (paramFragment.mIndex >= 0) {}
    for (;;)
    {
      return;
      if ((this.h == null) || (this.h.size() <= 0))
      {
        if (this.f == null) {
          this.f = new ArrayList();
        }
        paramFragment.setIndex(this.f.size(), this.q);
        this.f.add(paramFragment);
      }
      while (a)
      {
        Log.v("FragmentManager", "Allocated fragment index " + paramFragment);
        return;
        paramFragment.setIndex(((Integer)this.h.remove(this.h.size() - 1)).intValue(), this.q);
        this.f.set(paramFragment.mIndex, paramFragment);
      }
    }
  }
  
  public void c(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (a) {
      Log.v("FragmentManager", "show: " + paramFragment);
    }
    if (paramFragment.mHidden)
    {
      paramFragment.mHidden = false;
      if (paramFragment.mView != null)
      {
        Animation localAnimation = a(paramFragment, paramInt1, true, paramInt2);
        if (localAnimation != null) {
          paramFragment.mView.startAnimation(localAnimation);
        }
        paramFragment.mView.setVisibility(0);
      }
      if ((paramFragment.mAdded) && (paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
        this.r = true;
      }
      paramFragment.onHiddenChanged(false);
    }
  }
  
  void d(Fragment paramFragment)
  {
    if (paramFragment.mIndex < 0) {
      return;
    }
    if (a) {
      Log.v("FragmentManager", "Freeing fragment index " + paramFragment);
    }
    this.f.set(paramFragment.mIndex, null);
    if (this.h == null) {
      this.h = new ArrayList();
    }
    this.h.add(Integer.valueOf(paramFragment.mIndex));
    this.o.a(paramFragment.mWho);
    paramFragment.initState();
  }
  
  public void d(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (a) {
      Log.v("FragmentManager", "detach: " + paramFragment);
    }
    if (!paramFragment.mDetached)
    {
      paramFragment.mDetached = true;
      if (paramFragment.mAdded)
      {
        if (this.g != null)
        {
          if (a) {
            Log.v("FragmentManager", "remove from detach: " + paramFragment);
          }
          this.g.remove(paramFragment);
        }
        if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
          this.r = true;
        }
        paramFragment.mAdded = false;
        a(paramFragment, 1, paramInt1, paramInt2, false);
      }
    }
  }
  
  public boolean d()
  {
    u();
    b();
    return a(this.o.a, null, -1, 0);
  }
  
  void e()
  {
    if (this.f == null) {}
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 < this.f.size())
      {
        Fragment localFragment = (Fragment)this.f.get(i1);
        if (localFragment != null) {
          a(localFragment);
        }
        i1 += 1;
      }
    }
  }
  
  void e(Fragment paramFragment)
  {
    if (paramFragment.mInnerView == null) {
      return;
    }
    if (this.x == null) {
      this.x = new SparseArray();
    }
    for (;;)
    {
      paramFragment.mInnerView.saveHierarchyState(this.x);
      if (this.x.size() <= 0) {
        break;
      }
      paramFragment.mSavedViewState = this.x;
      this.x = null;
      return;
      this.x.clear();
    }
  }
  
  public void e(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (a) {
      Log.v("FragmentManager", "attach: " + paramFragment);
    }
    if (paramFragment.mDetached)
    {
      paramFragment.mDetached = false;
      if (!paramFragment.mAdded)
      {
        if (this.g == null) {
          this.g = new ArrayList();
        }
        if (this.g.contains(paramFragment)) {
          throw new IllegalStateException("Fragment already added: " + paramFragment);
        }
        if (a) {
          Log.v("FragmentManager", "add from attach: " + paramFragment);
        }
        this.g.add(paramFragment);
        paramFragment.mAdded = true;
        if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
          this.r = true;
        }
        a(paramFragment, this.n, paramInt1, paramInt2, false);
      }
    }
  }
  
  Bundle f(Fragment paramFragment)
  {
    if (this.w == null) {
      this.w = new Bundle();
    }
    paramFragment.performSaveInstanceState(this.w);
    Object localObject2;
    if (!this.w.isEmpty())
    {
      localObject2 = this.w;
      this.w = null;
    }
    for (;;)
    {
      if (paramFragment.mView != null) {
        e(paramFragment);
      }
      Object localObject1 = localObject2;
      if (paramFragment.mSavedViewState != null)
      {
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new Bundle();
        }
        ((Bundle)localObject1).putSparseParcelableArray("android:view_state", paramFragment.mSavedViewState);
      }
      localObject2 = localObject1;
      if (!paramFragment.mUserVisibleHint)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new Bundle();
        }
        ((Bundle)localObject2).putBoolean("android:user_visible_hint", paramFragment.mUserVisibleHint);
      }
      return (Bundle)localObject2;
      localObject2 = null;
    }
  }
  
  public boolean f()
  {
    if (this.e) {
      throw new IllegalStateException("Recursive entry to executePendingTransactions");
    }
    if (Looper.myLooper() != this.o.a.getLooper()) {
      throw new IllegalStateException("Must be called from main thread of process");
    }
    int i2;
    for (boolean bool = false;; bool = true) {
      try
      {
        if ((this.c == null) || (this.c.size() == 0))
        {
          if (!this.v) {
            break label276;
          }
          i1 = 0;
          int i4;
          for (i2 = 0; i1 < this.f.size(); i2 = i4)
          {
            Fragment localFragment = (Fragment)this.f.get(i1);
            int i3 = i2;
            if (localFragment != null)
            {
              i3 = i2;
              if (localFragment.mLoaderManager != null) {
                i4 = i2 | localFragment.mLoaderManager.a();
              }
            }
            i1 += 1;
          }
        }
        i2 = this.c.size();
        if ((this.d == null) || (this.d.length < i2)) {
          this.d = new Runnable[i2];
        }
        this.c.toArray(this.d);
        this.c.clear();
        this.o.a.removeCallbacks(this.y);
        this.e = true;
        int i1 = 0;
        while (i1 < i2)
        {
          this.d[i1].run();
          this.d[i1] = null;
          i1 += 1;
        }
        this.e = false;
      }
      finally {}
    }
    if (i2 == 0)
    {
      this.v = false;
      e();
    }
    label276:
    return bool;
  }
  
  void g()
  {
    if (this.m != null)
    {
      int i1 = 0;
      while (i1 < this.m.size())
      {
        ((m)this.m.get(i1)).a();
        i1 += 1;
      }
    }
  }
  
  ArrayList<Fragment> h()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (this.f != null)
    {
      int i1 = 0;
      localObject2 = localObject1;
      if (i1 < this.f.size())
      {
        Fragment localFragment = (Fragment)this.f.get(i1);
        Object localObject3 = localObject1;
        if (localFragment != null)
        {
          localObject3 = localObject1;
          if (localFragment.mRetainInstance)
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            ((ArrayList)localObject2).add(localFragment);
            localFragment.mRetaining = true;
            if (localFragment.mTarget == null) {
              break label164;
            }
          }
        }
        label164:
        for (int i2 = localFragment.mTarget.mIndex;; i2 = -1)
        {
          localFragment.mTargetIndex = i2;
          localObject3 = localObject2;
          if (a)
          {
            Log.v("FragmentManager", "retainNonConfig: keeping retained " + localFragment);
            localObject3 = localObject2;
          }
          i1 += 1;
          localObject1 = localObject3;
          break;
        }
      }
    }
    return (ArrayList<Fragment>)localObject2;
  }
  
  Parcelable i()
  {
    Object localObject3 = null;
    f();
    if (b) {
      this.s = true;
    }
    if ((this.f == null) || (this.f.size() <= 0)) {
      return null;
    }
    int i3 = this.f.size();
    FragmentState[] arrayOfFragmentState = new FragmentState[i3];
    int i2 = 0;
    int i1 = 0;
    label56:
    Object localObject1;
    Object localObject2;
    if (i2 < i3)
    {
      localObject1 = (Fragment)this.f.get(i2);
      if (localObject1 == null) {
        break label719;
      }
      if (((Fragment)localObject1).mIndex < 0) {
        a(new IllegalStateException("Failure saving state: active " + localObject1 + " has cleared index: " + ((Fragment)localObject1).mIndex));
      }
      localObject2 = new FragmentState((Fragment)localObject1);
      arrayOfFragmentState[i2] = localObject2;
      if ((((Fragment)localObject1).mState > 0) && (((FragmentState)localObject2).j == null))
      {
        ((FragmentState)localObject2).j = f((Fragment)localObject1);
        if (((Fragment)localObject1).mTarget != null)
        {
          if (((Fragment)localObject1).mTarget.mIndex < 0) {
            a(new IllegalStateException("Failure saving state: " + localObject1 + " has target not in fragment manager: " + ((Fragment)localObject1).mTarget));
          }
          if (((FragmentState)localObject2).j == null) {
            ((FragmentState)localObject2).j = new Bundle();
          }
          a(((FragmentState)localObject2).j, "android:target_state", ((Fragment)localObject1).mTarget);
          if (((Fragment)localObject1).mTargetRequestCode != 0) {
            ((FragmentState)localObject2).j.putInt("android:target_req_state", ((Fragment)localObject1).mTargetRequestCode);
          }
        }
        label303:
        if (a) {
          Log.v("FragmentManager", "Saved state of " + localObject1 + ": " + ((FragmentState)localObject2).j);
        }
        i1 = 1;
      }
    }
    label719:
    for (;;)
    {
      i2 += 1;
      break label56;
      ((FragmentState)localObject2).j = ((Fragment)localObject1).mSavedFragmentState;
      break label303;
      if (i1 == 0)
      {
        if (!a) {
          break;
        }
        Log.v("FragmentManager", "saveAllState: no fragments!");
        return null;
      }
      if (this.g != null)
      {
        i2 = this.g.size();
        if (i2 > 0)
        {
          localObject2 = new int[i2];
          i1 = 0;
          for (;;)
          {
            localObject1 = localObject2;
            if (i1 >= i2) {
              break;
            }
            localObject2[i1] = ((Fragment)this.g.get(i1)).mIndex;
            if (localObject2[i1] < 0) {
              a(new IllegalStateException("Failure saving state: active " + this.g.get(i1) + " has cleared index: " + localObject2[i1]));
            }
            if (a) {
              Log.v("FragmentManager", "saveAllState: adding fragment #" + i1 + ": " + this.g.get(i1));
            }
            i1 += 1;
          }
        }
      }
      localObject1 = null;
      localObject2 = localObject3;
      if (this.i != null)
      {
        i2 = this.i.size();
        localObject2 = localObject3;
        if (i2 > 0)
        {
          localObject3 = new BackStackState[i2];
          i1 = 0;
          for (;;)
          {
            localObject2 = localObject3;
            if (i1 >= i2) {
              break;
            }
            localObject3[i1] = new BackStackState(this, (d)this.i.get(i1));
            if (a) {
              Log.v("FragmentManager", "saveAllState: adding back stack #" + i1 + ": " + this.i.get(i1));
            }
            i1 += 1;
          }
        }
      }
      localObject3 = new FragmentManagerState();
      ((FragmentManagerState)localObject3).a = arrayOfFragmentState;
      ((FragmentManagerState)localObject3).b = ((int[])localObject1);
      ((FragmentManagerState)localObject3).c = ((BackStackState[])localObject2);
      return (Parcelable)localObject3;
    }
  }
  
  public void j()
  {
    this.s = false;
  }
  
  public void k()
  {
    this.s = false;
    a(1, false);
  }
  
  public void l()
  {
    this.s = false;
    a(2, false);
  }
  
  public void m()
  {
    this.s = false;
    a(4, false);
  }
  
  public void n()
  {
    this.s = false;
    a(5, false);
  }
  
  public void o()
  {
    a(4, false);
  }
  
  public void p()
  {
    this.s = true;
    a(3, false);
  }
  
  public void q()
  {
    a(2, false);
  }
  
  public void r()
  {
    a(1, false);
  }
  
  public void s()
  {
    this.t = true;
    f();
    a(0, false);
    this.o = null;
    this.p = null;
    this.q = null;
  }
  
  public void t()
  {
    if (this.g != null)
    {
      int i1 = 0;
      while (i1 < this.g.size())
      {
        Fragment localFragment = (Fragment)this.g.get(i1);
        if (localFragment != null) {
          localFragment.performLowMemory();
        }
        i1 += 1;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("FragmentManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    if (this.q != null) {
      c.a(this.q, localStringBuilder);
    }
    for (;;)
    {
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
      c.a(this.o, localStringBuilder);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v4/app/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */