package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.c.c;
import android.support.v4.c.d;
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

final class l
  extends j
{
  static final Interpolator A = new DecelerateInterpolator(1.5F);
  static final Interpolator B = new AccelerateInterpolator(2.5F);
  static final Interpolator C = new AccelerateInterpolator(1.5F);
  static boolean a;
  static final boolean b;
  static final Interpolator z;
  ArrayList c;
  Runnable[] d;
  boolean e;
  ArrayList f;
  ArrayList g;
  ArrayList h;
  ArrayList i;
  ArrayList j;
  ArrayList k;
  ArrayList l;
  ArrayList m;
  int n = 0;
  f o;
  i p;
  Fragment q;
  boolean r;
  boolean s;
  boolean t;
  String u;
  boolean v;
  Bundle w = null;
  SparseArray x = null;
  Runnable y = new Runnable()
  {
    public void run()
    {
      l.this.g();
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
    PrintWriter localPrintWriter = new PrintWriter(new d("FragmentManager"));
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
  
  private void v()
  {
    if (this.s) {
      throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }
    if (this.u != null) {
      throw new IllegalStateException("Can not perform this action inside of " + this.u);
    }
  }
  
  public int a(b paramb)
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
          Log.v("FragmentManager", "Setting back stack index " + i1 + " to " + paramb);
        }
        this.k.add(paramb);
        return i1;
      }
      int i1 = ((Integer)this.l.remove(this.l.size() - 1)).intValue();
      if (a) {
        Log.v("FragmentManager", "Adding back stack index " + i1 + " with " + paramb);
      }
      this.k.set(i1, paramb);
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
        if ((localObject != null) && (((Fragment)localObject).F == paramInt)) {
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
          if (localFragment.F == paramInt) {
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
        if ((localObject != null) && (paramString.equals(((Fragment)localObject).H))) {
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
          if (paramString.equals(localFragment.H)) {
            break;
          }
        }
        i1 -= 1;
      }
    }
    label126:
    return null;
  }
  
  public n a()
  {
    return new b(this);
  }
  
  Animation a(Fragment paramFragment, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Animation localAnimation = paramFragment.a(paramInt1, paramBoolean, paramFragment.P);
    if (localAnimation != null) {
      paramFragment = localAnimation;
    }
    do
    {
      return paramFragment;
      if (paramFragment.P == 0) {
        break;
      }
      localAnimation = AnimationUtils.loadAnimation(this.o, paramFragment.P);
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
        l.this.a(l.this.o.a, null, paramInt1, paramInt2);
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
      if (localFragment.V == null) {
        break label169;
      }
      bool |= localFragment.V.a();
    }
    label169:
    for (;;)
    {
      i1 += 1;
      break label54;
      if (!bool) {
        f();
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
  public void a(int paramInt, b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 210	android/support/v4/app/l:k	Ljava/util/ArrayList;
    //   6: ifnonnull +14 -> 20
    //   9: aload_0
    //   10: new 204	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 211	java/util/ArrayList:<init>	()V
    //   17: putfield 210	android/support/v4/app/l:k	Ljava/util/ArrayList;
    //   20: aload_0
    //   21: getfield 210	android/support/v4/app/l:k	Ljava/util/ArrayList;
    //   24: invokevirtual 208	java/util/ArrayList:size	()I
    //   27: istore 4
    //   29: iload 4
    //   31: istore_3
    //   32: iload_1
    //   33: iload 4
    //   35: if_icmpge +56 -> 91
    //   38: getstatic 55	android/support/v4/app/l:a	Z
    //   41: ifeq +37 -> 78
    //   44: ldc -122
    //   46: new 189	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   53: ldc -43
    //   55: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: iload_1
    //   59: invokevirtual 216	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc -38
    //   64: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_2
    //   68: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 223	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   77: pop
    //   78: aload_0
    //   79: getfield 210	android/support/v4/app/l:k	Ljava/util/ArrayList;
    //   82: iload_1
    //   83: aload_2
    //   84: invokevirtual 244	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   87: pop
    //   88: aload_0
    //   89: monitorexit
    //   90: return
    //   91: iload_3
    //   92: iload_1
    //   93: if_icmpge +81 -> 174
    //   96: aload_0
    //   97: getfield 210	android/support/v4/app/l:k	Ljava/util/ArrayList;
    //   100: aconst_null
    //   101: invokevirtual 227	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   104: pop
    //   105: aload_0
    //   106: getfield 202	android/support/v4/app/l:l	Ljava/util/ArrayList;
    //   109: ifnonnull +14 -> 123
    //   112: aload_0
    //   113: new 204	java/util/ArrayList
    //   116: dup
    //   117: invokespecial 211	java/util/ArrayList:<init>	()V
    //   120: putfield 202	android/support/v4/app/l:l	Ljava/util/ArrayList;
    //   123: getstatic 55	android/support/v4/app/l:a	Z
    //   126: ifeq +29 -> 155
    //   129: ldc -122
    //   131: new 189	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   138: ldc_w 354
    //   141: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: iload_3
    //   145: invokevirtual 216	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   148: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 223	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   154: pop
    //   155: aload_0
    //   156: getfield 202	android/support/v4/app/l:l	Ljava/util/ArrayList;
    //   159: iload_3
    //   160: invokestatic 358	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   163: invokevirtual 227	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   166: pop
    //   167: iload_3
    //   168: iconst_1
    //   169: iadd
    //   170: istore_3
    //   171: goto -80 -> 91
    //   174: getstatic 55	android/support/v4/app/l:a	Z
    //   177: ifeq +37 -> 214
    //   180: ldc -122
    //   182: new 189	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   189: ldc -18
    //   191: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: iload_1
    //   195: invokevirtual 216	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   198: ldc -16
    //   200: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload_2
    //   204: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 223	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   213: pop
    //   214: aload_0
    //   215: getfield 210	android/support/v4/app/l:k	Ljava/util/ArrayList;
    //   218: aload_2
    //   219: invokevirtual 227	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   222: pop
    //   223: goto -135 -> 88
    //   226: astore_2
    //   227: aload_0
    //   228: monitorexit
    //   229: aload_2
    //   230: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	this	l
    //   0	231	1	paramInt	int
    //   0	231	2	paramb	b
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
          localFragment.a(paramConfiguration);
        }
        i1 += 1;
      }
    }
  }
  
  public void a(Bundle paramBundle, String paramString, Fragment paramFragment)
  {
    if (paramFragment.o < 0) {
      a(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager"));
    }
    paramBundle.putInt(paramString, paramFragment.o);
  }
  
  void a(Parcelable paramParcelable, ArrayList paramArrayList)
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
            localObject2 = paramParcelable.a[localObject1.o];
            ((FragmentState)localObject2).k = ((Fragment)localObject1);
            ((Fragment)localObject1).n = null;
            ((Fragment)localObject1).A = 0;
            ((Fragment)localObject1).y = false;
            ((Fragment)localObject1).u = false;
            ((Fragment)localObject1).r = null;
            if (((FragmentState)localObject2).j != null)
            {
              ((FragmentState)localObject2).j.setClassLoader(this.o.getClassLoader());
              ((Fragment)localObject1).n = ((FragmentState)localObject2).j.getSparseParcelableArray("android:view_state");
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
            if (((Fragment)localObject1).s >= 0) {
              if (((Fragment)localObject1).s >= this.f.size()) {
                break label452;
              }
            }
            for (((Fragment)localObject1).r = ((Fragment)this.f.get(((Fragment)localObject1).s));; ((Fragment)localObject1).r = null)
            {
              i1 += 1;
              break;
              label452:
              Log.w("FragmentManager", "Re-attaching retained fragment " + localObject1 + " target no longer exists: " + ((Fragment)localObject1).s);
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
            paramArrayList.u = true;
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
            paramArrayList.a("  ", new PrintWriter(new d("FragmentManager")), false);
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
    if (paramFragment.T)
    {
      if (this.e) {
        this.v = true;
      }
    }
    else {
      return;
    }
    paramFragment.T = false;
    a(paramFragment, this.n, 0, 0, false);
  }
  
  public void a(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (a) {
      Log.v("FragmentManager", "remove: " + paramFragment + " nesting=" + paramFragment.A);
    }
    if (!paramFragment.j())
    {
      i1 = 1;
      if ((!paramFragment.J) || (i1 != 0))
      {
        if (this.g != null) {
          this.g.remove(paramFragment);
        }
        if ((paramFragment.M) && (paramFragment.N)) {
          this.r = true;
        }
        paramFragment.u = false;
        paramFragment.v = true;
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
    if (paramFragment.u)
    {
      i1 = paramInt1;
      if (!paramFragment.J) {}
    }
    else
    {
      i1 = paramInt1;
      if (paramInt1 > 1) {
        i1 = 1;
      }
    }
    int i2 = i1;
    if (paramFragment.v)
    {
      i2 = i1;
      if (i1 > paramFragment.j) {
        i2 = paramFragment.j;
      }
    }
    paramInt1 = i2;
    if (paramFragment.T)
    {
      paramInt1 = i2;
      if (paramFragment.j < 4)
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
    if (paramFragment.j < paramInt1)
    {
      if ((paramFragment.x) && (!paramFragment.y)) {
        return;
      }
      if (paramFragment.k != null)
      {
        paramFragment.k = null;
        a(paramFragment, paramFragment.l, 0, 0, true);
      }
      i1 = paramInt1;
      i3 = paramInt1;
      i2 = paramInt1;
      switch (paramFragment.j)
      {
      default: 
        i1 = paramInt1;
        paramFragment.j = i1;
        return;
      case 0: 
        if (a) {
          Log.v("FragmentManager", "moveto CREATED: " + paramFragment);
        }
        i2 = paramInt1;
        if (paramFragment.m != null)
        {
          paramFragment.n = paramFragment.m.getSparseParcelableArray("android:view_state");
          paramFragment.r = a(paramFragment.m, "android:target_state");
          if (paramFragment.r != null) {
            paramFragment.t = paramFragment.m.getInt("android:target_req_state", 0);
          }
          paramFragment.U = paramFragment.m.getBoolean("android:user_visible_hint", true);
          i2 = paramInt1;
          if (!paramFragment.U)
          {
            paramFragment.T = true;
            i2 = paramInt1;
            if (paramInt1 > 3) {
              i2 = 3;
            }
          }
        }
        paramFragment.C = this.o;
        paramFragment.E = this.q;
        if (this.q != null) {}
        for (localObject1 = this.q.D;; localObject1 = this.o.b)
        {
          paramFragment.B = ((l)localObject1);
          paramFragment.O = false;
          paramFragment.a(this.o);
          if (paramFragment.O) {
            break;
          }
          throw new ak("Fragment " + paramFragment + " did not call through to super.onAttach()");
        }
        if (paramFragment.E == null) {
          this.o.a(paramFragment);
        }
        if (!paramFragment.L) {
          paramFragment.i(paramFragment.m);
        }
        paramFragment.L = false;
        i1 = i2;
        if (paramFragment.x)
        {
          paramFragment.R = paramFragment.b(paramFragment.b(paramFragment.m), null, paramFragment.m);
          if (paramFragment.R == null) {
            break label993;
          }
          paramFragment.S = paramFragment.R;
          paramFragment.R = s.a(paramFragment.R);
          if (paramFragment.I) {
            paramFragment.R.setVisibility(8);
          }
          paramFragment.a(paramFragment.R, paramFragment.m);
          i1 = i2;
        }
      case 1: 
        i3 = i1;
        if (i1 > 1)
        {
          if (a) {
            Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + paramFragment);
          }
          if (!paramFragment.x)
          {
            if (paramFragment.G == 0) {
              break label1574;
            }
            localObject2 = (ViewGroup)this.p.a(paramFragment.G);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = localObject2;
              if (!paramFragment.z) {
                a(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(paramFragment.G) + " (" + paramFragment.n().getResourceName(paramFragment.G) + ") for fragment " + paramFragment));
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
      paramFragment.Q = ((ViewGroup)localObject1);
      paramFragment.R = paramFragment.b(paramFragment.b(paramFragment.m), (ViewGroup)localObject1, paramFragment.m);
      if (paramFragment.R != null)
      {
        paramFragment.S = paramFragment.R;
        paramFragment.R = s.a(paramFragment.R);
        if (localObject1 != null)
        {
          localObject2 = a(paramFragment, paramInt2, true, paramInt3);
          if (localObject2 != null) {
            paramFragment.R.startAnimation((Animation)localObject2);
          }
          ((ViewGroup)localObject1).addView(paramFragment.R);
        }
        if (paramFragment.I) {
          paramFragment.R.setVisibility(8);
        }
        paramFragment.a(paramFragment.R, paramFragment.m);
      }
      for (;;)
      {
        paramFragment.j(paramFragment.m);
        if (paramFragment.R != null) {
          paramFragment.f(paramFragment.m);
        }
        paramFragment.m = null;
        i3 = i1;
        i2 = i3;
        if (i3 > 3)
        {
          if (a) {
            Log.v("FragmentManager", "moveto STARTED: " + paramFragment);
          }
          paramFragment.C();
          i2 = i3;
        }
        i1 = i2;
        if (i2 <= 4) {
          break;
        }
        if (a) {
          Log.v("FragmentManager", "moveto RESUMED: " + paramFragment);
        }
        paramFragment.w = true;
        paramFragment.D();
        paramFragment.m = null;
        paramFragment.n = null;
        i1 = i2;
        break;
        paramFragment.S = null;
        i1 = i2;
        break label557;
        paramFragment.S = null;
      }
      i1 = paramInt1;
      if (paramFragment.j <= paramInt1) {
        break;
      }
      switch (paramFragment.j)
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
          if ((this.t) && (paramFragment.k != null))
          {
            localObject1 = paramFragment.k;
            paramFragment.k = null;
            ((View)localObject1).clearAnimation();
          }
          if (paramFragment.k == null) {
            break label1433;
          }
          paramFragment.l = paramInt1;
          i1 = 1;
          break;
          if (paramInt1 < 5)
          {
            if (a) {
              Log.v("FragmentManager", "movefrom RESUMED: " + paramFragment);
            }
            paramFragment.F();
            paramFragment.w = false;
          }
          if (paramInt1 < 4)
          {
            if (a) {
              Log.v("FragmentManager", "movefrom STARTED: " + paramFragment);
            }
            paramFragment.G();
          }
          if (paramInt1 < 3)
          {
            if (a) {
              Log.v("FragmentManager", "movefrom STOPPED: " + paramFragment);
            }
            paramFragment.H();
          }
        } while (paramInt1 >= 2);
        if (a) {
          Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + paramFragment);
        }
        if ((paramFragment.R != null) && (!this.o.isFinishing()) && (paramFragment.n == null)) {
          e(paramFragment);
        }
        paramFragment.I();
        if ((paramFragment.R != null) && (paramFragment.Q != null)) {
          if ((this.n <= 0) || (this.t)) {
            break label1568;
          }
        }
        for (localObject1 = a(paramFragment, paramInt2, false, paramInt3);; localObject1 = null)
        {
          if (localObject1 != null)
          {
            paramFragment.k = paramFragment.R;
            paramFragment.l = paramInt1;
            ((Animation)localObject1).setAnimationListener(new Animation.AnimationListener()
            {
              public void onAnimationEnd(Animation paramAnonymousAnimation)
              {
                if (paramFragment.k != null)
                {
                  paramFragment.k = null;
                  l.this.a(paramFragment, paramFragment.l, 0, 0, false);
                }
              }
              
              public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
              
              public void onAnimationStart(Animation paramAnonymousAnimation) {}
            });
            paramFragment.R.startAnimation((Animation)localObject1);
          }
          paramFragment.Q.removeView(paramFragment.R);
          paramFragment.Q = null;
          paramFragment.R = null;
          paramFragment.S = null;
          break label1070;
          if (a) {
            Log.v("FragmentManager", "movefrom CREATED: " + paramFragment);
          }
          if (!paramFragment.L) {
            paramFragment.J();
          }
          paramFragment.O = false;
          paramFragment.f();
          if (!paramFragment.O) {
            throw new ak("Fragment " + paramFragment + " did not call through to super.onDetach()");
          }
          i1 = paramInt1;
          if (paramBoolean) {
            break;
          }
          if (!paramFragment.L)
          {
            d(paramFragment);
            i1 = paramInt1;
            break;
          }
          paramFragment.C = null;
          paramFragment.B = null;
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
    if (!paramFragment.J)
    {
      if (this.g.contains(paramFragment)) {
        throw new IllegalStateException("Fragment already added: " + paramFragment);
      }
      this.g.add(paramFragment);
      paramFragment.u = true;
      paramFragment.v = false;
      if ((paramFragment.M) && (paramFragment.N)) {
        this.r = true;
      }
      if (paramBoolean) {
        b(paramFragment);
      }
    }
  }
  
  public void a(f paramf, i parami, Fragment paramFragment)
  {
    if (this.o != null) {
      throw new IllegalStateException("Already attached");
    }
    this.o = paramf;
    this.p = parami;
    this.q = paramFragment;
  }
  
  public void a(k paramk)
  {
    if (this.m == null) {
      this.m = new ArrayList();
    }
    this.m.add(paramk);
  }
  
  public void a(Runnable paramRunnable, boolean paramBoolean)
  {
    if (!paramBoolean) {
      v();
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
            ((Fragment)localObject).a(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
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
          localObject = (b)this.i.get(i1);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i1);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(((b)localObject).toString());
          ((b)localObject).a(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
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
            paramFileDescriptor = (b)this.k.get(i1);
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
    ((b)this.i.remove(paramInt1)).b(true);
    h();
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
            paramHandler = (b)this.i.get(i2);
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
              paramHandler = (b)this.i.get(paramInt2);
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
        paramString = (b)paramHandler.get(paramInt1);
        if (paramInt1 == paramInt2) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.b(bool);
          paramInt1 += 1;
          break;
        }
      }
      h();
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
          if (localFragment.c(paramMenu)) {
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
          if (localFragment.b(paramMenu, paramMenuInflater))
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
          paramMenu.A();
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
        if ((localFragment != null) && (localFragment.c(paramMenuItem))) {
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
    if (!paramFragment.I)
    {
      paramFragment.I = true;
      if (paramFragment.R != null)
      {
        Animation localAnimation = a(paramFragment, paramInt1, false, paramInt2);
        if (localAnimation != null) {
          paramFragment.R.startAnimation(localAnimation);
        }
        paramFragment.R.setVisibility(8);
      }
      if ((paramFragment.u) && (paramFragment.M) && (paramFragment.N)) {
        this.r = true;
      }
      paramFragment.d(true);
    }
  }
  
  void b(b paramb)
  {
    if (this.i == null) {
      this.i = new ArrayList();
    }
    this.i.add(paramb);
    h();
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
          localFragment.d(paramMenu);
        }
        i1 += 1;
      }
    }
  }
  
  public boolean b()
  {
    return g();
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
        if ((localFragment != null) && (localFragment.d(paramMenuItem))) {
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
  
  public int c()
  {
    if (this.i != null) {
      return this.i.size();
    }
    return 0;
  }
  
  void c(Fragment paramFragment)
  {
    if (paramFragment.o >= 0) {}
    for (;;)
    {
      return;
      if ((this.h == null) || (this.h.size() <= 0))
      {
        if (this.f == null) {
          this.f = new ArrayList();
        }
        paramFragment.a(this.f.size(), this.q);
        this.f.add(paramFragment);
      }
      while (a)
      {
        Log.v("FragmentManager", "Allocated fragment index " + paramFragment);
        return;
        paramFragment.a(((Integer)this.h.remove(this.h.size() - 1)).intValue(), this.q);
        this.f.set(paramFragment.o, paramFragment);
      }
    }
  }
  
  public void c(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (a) {
      Log.v("FragmentManager", "show: " + paramFragment);
    }
    if (paramFragment.I)
    {
      paramFragment.I = false;
      if (paramFragment.R != null)
      {
        Animation localAnimation = a(paramFragment, paramInt1, true, paramInt2);
        if (localAnimation != null) {
          paramFragment.R.startAnimation(localAnimation);
        }
        paramFragment.R.setVisibility(0);
      }
      if ((paramFragment.u) && (paramFragment.M) && (paramFragment.N)) {
        this.r = true;
      }
      paramFragment.d(false);
    }
  }
  
  public List d()
  {
    return this.f;
  }
  
  void d(Fragment paramFragment)
  {
    if (paramFragment.o < 0) {
      return;
    }
    if (a) {
      Log.v("FragmentManager", "Freeing fragment index " + paramFragment);
    }
    this.f.set(paramFragment.o, null);
    if (this.h == null) {
      this.h = new ArrayList();
    }
    this.h.add(Integer.valueOf(paramFragment.o));
    this.o.a(paramFragment.p);
    paramFragment.z();
  }
  
  public void d(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (a) {
      Log.v("FragmentManager", "detach: " + paramFragment);
    }
    if (!paramFragment.J)
    {
      paramFragment.J = true;
      if (paramFragment.u)
      {
        if (this.g != null)
        {
          if (a) {
            Log.v("FragmentManager", "remove from detach: " + paramFragment);
          }
          this.g.remove(paramFragment);
        }
        if ((paramFragment.M) && (paramFragment.N)) {
          this.r = true;
        }
        paramFragment.u = false;
        a(paramFragment, 1, paramInt1, paramInt2, false);
      }
    }
  }
  
  void e(Fragment paramFragment)
  {
    if (paramFragment.S == null) {
      return;
    }
    if (this.x == null) {
      this.x = new SparseArray();
    }
    for (;;)
    {
      paramFragment.S.saveHierarchyState(this.x);
      if (this.x.size() <= 0) {
        break;
      }
      paramFragment.n = this.x;
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
    if (paramFragment.J)
    {
      paramFragment.J = false;
      if (!paramFragment.u)
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
        paramFragment.u = true;
        if ((paramFragment.M) && (paramFragment.N)) {
          this.r = true;
        }
        a(paramFragment, this.n, paramInt1, paramInt2, false);
      }
    }
  }
  
  public boolean e()
  {
    v();
    b();
    return a(this.o.a, null, -1, 0);
  }
  
  Bundle f(Fragment paramFragment)
  {
    if (this.w == null) {
      this.w = new Bundle();
    }
    paramFragment.k(this.w);
    Object localObject2;
    if (!this.w.isEmpty())
    {
      localObject2 = this.w;
      this.w = null;
    }
    for (;;)
    {
      if (paramFragment.R != null) {
        e(paramFragment);
      }
      Object localObject1 = localObject2;
      if (paramFragment.n != null)
      {
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new Bundle();
        }
        ((Bundle)localObject1).putSparseParcelableArray("android:view_state", paramFragment.n);
      }
      localObject2 = localObject1;
      if (!paramFragment.U)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new Bundle();
        }
        ((Bundle)localObject2).putBoolean("android:user_visible_hint", paramFragment.U);
      }
      return (Bundle)localObject2;
      localObject2 = null;
    }
  }
  
  void f()
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
  
  public boolean g()
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
              if (localFragment.V != null) {
                i4 = i2 | localFragment.V.a();
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
      f();
    }
    label276:
    return bool;
  }
  
  void h()
  {
    if (this.m != null)
    {
      int i1 = 0;
      while (i1 < this.m.size())
      {
        ((k)this.m.get(i1)).e();
        i1 += 1;
      }
    }
  }
  
  ArrayList i()
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
          if (localFragment.K)
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            ((ArrayList)localObject2).add(localFragment);
            localFragment.L = true;
            if (localFragment.r == null) {
              break label164;
            }
          }
        }
        label164:
        for (int i2 = localFragment.r.o;; i2 = -1)
        {
          localFragment.s = i2;
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
    return (ArrayList)localObject2;
  }
  
  Parcelable j()
  {
    Object localObject3 = null;
    g();
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
      if (((Fragment)localObject1).o < 0) {
        a(new IllegalStateException("Failure saving state: active " + localObject1 + " has cleared index: " + ((Fragment)localObject1).o));
      }
      localObject2 = new FragmentState((Fragment)localObject1);
      arrayOfFragmentState[i2] = localObject2;
      if ((((Fragment)localObject1).j > 0) && (((FragmentState)localObject2).j == null))
      {
        ((FragmentState)localObject2).j = f((Fragment)localObject1);
        if (((Fragment)localObject1).r != null)
        {
          if (((Fragment)localObject1).r.o < 0) {
            a(new IllegalStateException("Failure saving state: " + localObject1 + " has target not in fragment manager: " + ((Fragment)localObject1).r));
          }
          if (((FragmentState)localObject2).j == null) {
            ((FragmentState)localObject2).j = new Bundle();
          }
          a(((FragmentState)localObject2).j, "android:target_state", ((Fragment)localObject1).r);
          if (((Fragment)localObject1).t != 0) {
            ((FragmentState)localObject2).j.putInt("android:target_req_state", ((Fragment)localObject1).t);
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
      ((FragmentState)localObject2).j = ((Fragment)localObject1).m;
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
            localObject2[i1] = ((Fragment)this.g.get(i1)).o;
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
            localObject3[i1] = new BackStackState(this, (b)this.i.get(i1));
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
  
  public void k()
  {
    this.s = false;
  }
  
  public void l()
  {
    this.s = false;
    a(1, false);
  }
  
  public void m()
  {
    this.s = false;
    a(2, false);
  }
  
  public void n()
  {
    this.s = false;
    a(4, false);
  }
  
  public void o()
  {
    this.s = false;
    a(5, false);
  }
  
  public void p()
  {
    a(4, false);
  }
  
  public void q()
  {
    this.s = true;
    a(3, false);
  }
  
  public void r()
  {
    a(2, false);
  }
  
  public void s()
  {
    a(1, false);
  }
  
  public void t()
  {
    this.t = true;
    g();
    a(0, false);
    this.o = null;
    this.p = null;
    this.q = null;
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
  
  public void u()
  {
    if (this.g != null)
    {
      int i1 = 0;
      while (i1 < this.g.size())
      {
        Fragment localFragment = (Fragment)this.g.get(i1);
        if (localFragment != null) {
          localFragment.E();
        }
        i1 += 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/app/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */