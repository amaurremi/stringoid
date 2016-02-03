package android.support.v4.app;

import android.support.v4.c.d;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

final class b
  extends n
  implements Runnable
{
  final l a;
  c b;
  c c;
  int d;
  int e;
  int f;
  int g;
  int h;
  int i;
  int j;
  boolean k;
  boolean l = true;
  String m;
  boolean n;
  int o = -1;
  int p;
  CharSequence q;
  int r;
  CharSequence s;
  
  public b(l paraml)
  {
    this.a = paraml;
  }
  
  private void a(int paramInt1, Fragment paramFragment, String paramString, int paramInt2)
  {
    paramFragment.B = this.a;
    if (paramString != null)
    {
      if ((paramFragment.H != null) && (!paramString.equals(paramFragment.H))) {
        throw new IllegalStateException("Can't change tag of fragment " + paramFragment + ": was " + paramFragment.H + " now " + paramString);
      }
      paramFragment.H = paramString;
    }
    if (paramInt1 != 0)
    {
      if ((paramFragment.F != 0) && (paramFragment.F != paramInt1)) {
        throw new IllegalStateException("Can't change container ID of fragment " + paramFragment + ": was " + paramFragment.F + " now " + paramInt1);
      }
      paramFragment.F = paramInt1;
      paramFragment.G = paramInt1;
    }
    paramString = new c();
    paramString.c = paramInt2;
    paramString.d = paramFragment;
    a(paramString);
  }
  
  public int a()
  {
    return a(false);
  }
  
  int a(boolean paramBoolean)
  {
    if (this.n) {
      throw new IllegalStateException("commit already called");
    }
    if (l.a)
    {
      Log.v("FragmentManager", "Commit: " + this);
      a("  ", null, new PrintWriter(new d("FragmentManager")), null);
    }
    this.n = true;
    if (this.k) {}
    for (this.o = this.a.a(this);; this.o = -1)
    {
      this.a.a(this, paramBoolean);
      return this.o;
    }
  }
  
  public n a(int paramInt)
  {
    this.i = paramInt;
    return this;
  }
  
  public n a(int paramInt, Fragment paramFragment, String paramString)
  {
    a(paramInt, paramFragment, paramString, 1);
    return this;
  }
  
  public n a(Fragment paramFragment)
  {
    c localc = new c();
    localc.c = 3;
    localc.d = paramFragment;
    a(localc);
    return this;
  }
  
  public n a(Fragment paramFragment, String paramString)
  {
    a(0, paramFragment, paramString, 1);
    return this;
  }
  
  public n a(String paramString)
  {
    if (!this.l) {
      throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }
    this.k = true;
    this.m = paramString;
    return this;
  }
  
  void a(c paramc)
  {
    if (this.b == null)
    {
      this.c = paramc;
      this.b = paramc;
    }
    for (;;)
    {
      paramc.e = this.e;
      paramc.f = this.f;
      paramc.g = this.g;
      paramc.h = this.h;
      this.d += 1;
      return;
      paramc.b = this.c;
      this.c.a = paramc;
      this.c = paramc;
    }
  }
  
  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    a(paramString, paramPrintWriter, true);
  }
  
  public void a(String paramString, PrintWriter paramPrintWriter, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mName=");
      paramPrintWriter.print(this.m);
      paramPrintWriter.print(" mIndex=");
      paramPrintWriter.print(this.o);
      paramPrintWriter.print(" mCommitted=");
      paramPrintWriter.println(this.n);
      if (this.i != 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mTransition=#");
        paramPrintWriter.print(Integer.toHexString(this.i));
        paramPrintWriter.print(" mTransitionStyle=#");
        paramPrintWriter.println(Integer.toHexString(this.j));
      }
      if ((this.e != 0) || (this.f != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.e));
        paramPrintWriter.print(" mExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.f));
      }
      if ((this.g != 0) || (this.h != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mPopEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.g));
        paramPrintWriter.print(" mPopExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.h));
      }
      if ((this.p != 0) || (this.q != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.p));
        paramPrintWriter.print(" mBreadCrumbTitleText=");
        paramPrintWriter.println(this.q);
      }
      if ((this.r != 0) || (this.s != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbShortTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.r));
        paramPrintWriter.print(" mBreadCrumbShortTitleText=");
        paramPrintWriter.println(this.s);
      }
    }
    if (this.b != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Operations:");
      String str2 = paramString + "    ";
      c localc = this.b;
      int i1 = 0;
      while (localc != null)
      {
        String str1;
        int i2;
        switch (localc.c)
        {
        default: 
          str1 = "cmd=" + localc.c;
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  Op #");
          paramPrintWriter.print(i1);
          paramPrintWriter.print(": ");
          paramPrintWriter.print(str1);
          paramPrintWriter.print(" ");
          paramPrintWriter.println(localc.d);
          if (paramBoolean)
          {
            if ((localc.e != 0) || (localc.f != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("enterAnim=#");
              paramPrintWriter.print(Integer.toHexString(localc.e));
              paramPrintWriter.print(" exitAnim=#");
              paramPrintWriter.println(Integer.toHexString(localc.f));
            }
            if ((localc.g != 0) || (localc.h != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("popEnterAnim=#");
              paramPrintWriter.print(Integer.toHexString(localc.g));
              paramPrintWriter.print(" popExitAnim=#");
              paramPrintWriter.println(Integer.toHexString(localc.h));
            }
          }
          if ((localc.i == null) || (localc.i.size() <= 0)) {
            break label786;
          }
          i2 = 0;
          label621:
          if (i2 >= localc.i.size()) {
            break label786;
          }
          paramPrintWriter.print(str2);
          if (localc.i.size() == 1) {
            paramPrintWriter.print("Removed: ");
          }
          break;
        }
        for (;;)
        {
          paramPrintWriter.println(localc.i.get(i2));
          i2 += 1;
          break label621;
          str1 = "NULL";
          break;
          str1 = "ADD";
          break;
          str1 = "REPLACE";
          break;
          str1 = "REMOVE";
          break;
          str1 = "HIDE";
          break;
          str1 = "SHOW";
          break;
          str1 = "DETACH";
          break;
          str1 = "ATTACH";
          break;
          if (i2 == 0) {
            paramPrintWriter.println("Removed:");
          }
          paramPrintWriter.print(str2);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i2);
          paramPrintWriter.print(": ");
        }
        label786:
        localc = localc.a;
        i1 += 1;
      }
    }
  }
  
  public int b()
  {
    return a(true);
  }
  
  public n b(Fragment paramFragment)
  {
    c localc = new c();
    localc.c = 6;
    localc.d = paramFragment;
    a(localc);
    return this;
  }
  
  void b(int paramInt)
  {
    if (!this.k) {}
    for (;;)
    {
      return;
      if (l.a) {
        Log.v("FragmentManager", "Bump nesting in " + this + " by " + paramInt);
      }
      for (c localc = this.b; localc != null; localc = localc.a)
      {
        Fragment localFragment;
        if (localc.d != null)
        {
          localFragment = localc.d;
          localFragment.A += paramInt;
          if (l.a) {
            Log.v("FragmentManager", "Bump nesting of " + localc.d + " to " + localc.d.A);
          }
        }
        if (localc.i != null)
        {
          int i1 = localc.i.size() - 1;
          while (i1 >= 0)
          {
            localFragment = (Fragment)localc.i.get(i1);
            localFragment.A += paramInt;
            if (l.a) {
              Log.v("FragmentManager", "Bump nesting of " + localFragment + " to " + localFragment.A);
            }
            i1 -= 1;
          }
        }
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (l.a)
    {
      Log.v("FragmentManager", "popFromBackStack: " + this);
      a("  ", null, new PrintWriter(new d("FragmentManager")), null);
    }
    b(-1);
    c localc = this.c;
    if (localc != null)
    {
      Fragment localFragment;
      switch (localc.c)
      {
      default: 
        throw new IllegalArgumentException("Unknown cmd: " + localc.c);
      case 1: 
        localFragment = localc.d;
        localFragment.P = localc.h;
        this.a.a(localFragment, l.c(this.i), this.j);
      }
      for (;;)
      {
        localc = localc.b;
        break;
        localFragment = localc.d;
        if (localFragment != null)
        {
          localFragment.P = localc.h;
          this.a.a(localFragment, l.c(this.i), this.j);
        }
        if (localc.i != null)
        {
          int i1 = 0;
          while (i1 < localc.i.size())
          {
            localFragment = (Fragment)localc.i.get(i1);
            localFragment.P = localc.g;
            this.a.a(localFragment, false);
            i1 += 1;
          }
          localFragment = localc.d;
          localFragment.P = localc.g;
          this.a.a(localFragment, false);
          continue;
          localFragment = localc.d;
          localFragment.P = localc.g;
          this.a.c(localFragment, l.c(this.i), this.j);
          continue;
          localFragment = localc.d;
          localFragment.P = localc.h;
          this.a.b(localFragment, l.c(this.i), this.j);
          continue;
          localFragment = localc.d;
          localFragment.P = localc.g;
          this.a.e(localFragment, l.c(this.i), this.j);
          continue;
          localFragment = localc.d;
          localFragment.P = localc.g;
          this.a.d(localFragment, l.c(this.i), this.j);
        }
      }
    }
    if (paramBoolean) {
      this.a.a(this.a.n, l.c(this.i), this.j, true);
    }
    if (this.o >= 0)
    {
      this.a.b(this.o);
      this.o = -1;
    }
  }
  
  public n c(Fragment paramFragment)
  {
    c localc = new c();
    localc.c = 7;
    localc.d = paramFragment;
    a(localc);
    return this;
  }
  
  public String c()
  {
    return this.m;
  }
  
  public void run()
  {
    if (l.a) {
      Log.v("FragmentManager", "Run: " + this);
    }
    if ((this.k) && (this.o < 0)) {
      throw new IllegalStateException("addToBackStack() called after commit()");
    }
    b(1);
    c localc = this.b;
    if (localc != null)
    {
      Object localObject1;
      switch (localc.c)
      {
      default: 
        throw new IllegalArgumentException("Unknown cmd: " + localc.c);
      case 1: 
        localObject1 = localc.d;
        ((Fragment)localObject1).P = localc.e;
        this.a.a((Fragment)localObject1, false);
      }
      for (;;)
      {
        localc = localc.a;
        break;
        localObject1 = localc.d;
        Object localObject2;
        if (this.a.g != null)
        {
          int i1 = 0;
          localObject2 = localObject1;
          if (i1 < this.a.g.size())
          {
            Fragment localFragment = (Fragment)this.a.g.get(i1);
            if (l.a) {
              Log.v("FragmentManager", "OP_REPLACE: adding=" + localObject1 + " old=" + localFragment);
            }
            if (localObject1 != null)
            {
              localObject2 = localObject1;
              if (localFragment.G != ((Fragment)localObject1).G) {}
            }
            else
            {
              if (localFragment != localObject1) {
                break label313;
              }
              localObject2 = null;
              localc.d = null;
            }
            for (;;)
            {
              i1 += 1;
              localObject1 = localObject2;
              break;
              label313:
              if (localc.i == null) {
                localc.i = new ArrayList();
              }
              localc.i.add(localFragment);
              localFragment.P = localc.f;
              if (this.k)
              {
                localFragment.A += 1;
                if (l.a) {
                  Log.v("FragmentManager", "Bump nesting of " + localFragment + " to " + localFragment.A);
                }
              }
              this.a.a(localFragment, this.i, this.j);
              localObject2 = localObject1;
            }
          }
        }
        else
        {
          localObject2 = localObject1;
        }
        if (localObject2 != null)
        {
          ((Fragment)localObject2).P = localc.e;
          this.a.a((Fragment)localObject2, false);
          continue;
          localObject1 = localc.d;
          ((Fragment)localObject1).P = localc.f;
          this.a.a((Fragment)localObject1, this.i, this.j);
          continue;
          localObject1 = localc.d;
          ((Fragment)localObject1).P = localc.f;
          this.a.b((Fragment)localObject1, this.i, this.j);
          continue;
          localObject1 = localc.d;
          ((Fragment)localObject1).P = localc.e;
          this.a.c((Fragment)localObject1, this.i, this.j);
          continue;
          localObject1 = localc.d;
          ((Fragment)localObject1).P = localc.f;
          this.a.d((Fragment)localObject1, this.i, this.j);
          continue;
          localObject1 = localc.d;
          ((Fragment)localObject1).P = localc.e;
          this.a.e((Fragment)localObject1, this.i, this.j);
        }
      }
    }
    this.a.a(this.a.n, this.i, this.j, true);
    if (this.k) {
      this.a.b(this);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("BackStackEntry{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    if (this.o >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(this.o);
    }
    if (this.m != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.m);
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/app/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */