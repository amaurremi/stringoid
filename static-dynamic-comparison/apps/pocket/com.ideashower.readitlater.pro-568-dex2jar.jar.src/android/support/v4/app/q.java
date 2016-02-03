package android.support.v4.app;

import android.support.v4.c.c;
import android.support.v4.c.m;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class q
  extends o
{
  static boolean a = false;
  final m b = new m();
  final m c = new m();
  final String d;
  f e;
  boolean f;
  boolean g;
  
  q(String paramString, f paramf, boolean paramBoolean)
  {
    this.d = paramString;
    this.e = paramf;
    this.f = paramBoolean;
  }
  
  void a(f paramf)
  {
    this.e = paramf;
  }
  
  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int j = 0;
    String str;
    int i;
    r localr;
    if (this.b.b() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Active Loaders:");
      str = paramString + "    ";
      i = 0;
      while (i < this.b.b())
      {
        localr = (r)this.b.b(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.b.a(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(localr.toString());
        localr.a(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        i += 1;
      }
    }
    if (this.c.b() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Inactive Loaders:");
      str = paramString + "    ";
      i = j;
      while (i < this.c.b())
      {
        localr = (r)this.c.b(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.c.a(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(localr.toString());
        localr.a(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        i += 1;
      }
    }
  }
  
  public boolean a()
  {
    int j = this.b.b();
    int i = 0;
    boolean bool2 = false;
    if (i < j)
    {
      r localr = (r)this.b.b(i);
      if ((localr.h) && (!localr.f)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        bool2 |= bool1;
        i += 1;
        break;
      }
    }
    return bool2;
  }
  
  void b()
  {
    if (a) {
      Log.v("LoaderManager", "Starting in " + this);
    }
    if (this.f)
    {
      RuntimeException localRuntimeException = new RuntimeException("here");
      localRuntimeException.fillInStackTrace();
      Log.w("LoaderManager", "Called doStart when already started: " + this, localRuntimeException);
    }
    for (;;)
    {
      return;
      this.f = true;
      int i = this.b.b() - 1;
      while (i >= 0)
      {
        ((r)this.b.b(i)).a();
        i -= 1;
      }
    }
  }
  
  void c()
  {
    if (a) {
      Log.v("LoaderManager", "Stopping in " + this);
    }
    if (!this.f)
    {
      RuntimeException localRuntimeException = new RuntimeException("here");
      localRuntimeException.fillInStackTrace();
      Log.w("LoaderManager", "Called doStop when not started: " + this, localRuntimeException);
      return;
    }
    int i = this.b.b() - 1;
    while (i >= 0)
    {
      ((r)this.b.b(i)).e();
      i -= 1;
    }
    this.f = false;
  }
  
  void d()
  {
    if (a) {
      Log.v("LoaderManager", "Retaining in " + this);
    }
    if (!this.f)
    {
      RuntimeException localRuntimeException = new RuntimeException("here");
      localRuntimeException.fillInStackTrace();
      Log.w("LoaderManager", "Called doRetain when not started: " + this, localRuntimeException);
    }
    for (;;)
    {
      return;
      this.g = true;
      this.f = false;
      int i = this.b.b() - 1;
      while (i >= 0)
      {
        ((r)this.b.b(i)).b();
        i -= 1;
      }
    }
  }
  
  void e()
  {
    if (this.g)
    {
      if (a) {
        Log.v("LoaderManager", "Finished Retaining in " + this);
      }
      this.g = false;
      int i = this.b.b() - 1;
      while (i >= 0)
      {
        ((r)this.b.b(i)).c();
        i -= 1;
      }
    }
  }
  
  void f()
  {
    int i = this.b.b() - 1;
    while (i >= 0)
    {
      ((r)this.b.b(i)).k = true;
      i -= 1;
    }
  }
  
  void g()
  {
    int i = this.b.b() - 1;
    while (i >= 0)
    {
      ((r)this.b.b(i)).d();
      i -= 1;
    }
  }
  
  void h()
  {
    if (!this.g)
    {
      if (a) {
        Log.v("LoaderManager", "Destroying Active in " + this);
      }
      i = this.b.b() - 1;
      while (i >= 0)
      {
        ((r)this.b.b(i)).f();
        i -= 1;
      }
      this.b.c();
    }
    if (a) {
      Log.v("LoaderManager", "Destroying Inactive in " + this);
    }
    int i = this.c.b() - 1;
    while (i >= 0)
    {
      ((r)this.c.b(i)).f();
      i -= 1;
    }
    this.c.c();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("LoaderManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    c.a(this.e, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/app/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */