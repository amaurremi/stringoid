package android.support.v4.a;

import android.support.v4.d.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class j<D>
{
  int a;
  k<D> b;
  boolean c;
  boolean d;
  boolean e;
  boolean f;
  boolean g;
  
  public String a(D paramD)
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    c.a(paramD, localStringBuilder);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public final void a()
  {
    this.c = true;
    this.e = false;
    this.d = false;
    b();
  }
  
  public void a(int paramInt, k<D> paramk)
  {
    if (this.b != null) {
      throw new IllegalStateException("There is already a listener registered");
    }
    this.b = paramk;
    this.a = paramInt;
  }
  
  public void a(k<D> paramk)
  {
    if (this.b == null) {
      throw new IllegalStateException("No listener register");
    }
    if (this.b != paramk) {
      throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    }
    this.b = null;
  }
  
  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mId=");
    paramPrintWriter.print(this.a);
    paramPrintWriter.print(" mListener=");
    paramPrintWriter.println(this.b);
    if ((this.c) || (this.f) || (this.g))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStarted=");
      paramPrintWriter.print(this.c);
      paramPrintWriter.print(" mContentChanged=");
      paramPrintWriter.print(this.f);
      paramPrintWriter.print(" mProcessingChange=");
      paramPrintWriter.println(this.g);
    }
    if ((this.d) || (this.e))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAbandoned=");
      paramPrintWriter.print(this.d);
      paramPrintWriter.print(" mReset=");
      paramPrintWriter.println(this.e);
    }
  }
  
  protected void b() {}
  
  public void c()
  {
    this.c = false;
    d();
  }
  
  protected void d() {}
  
  public void e()
  {
    f();
    this.e = true;
    this.c = false;
    this.d = false;
    this.f = false;
    this.g = false;
  }
  
  protected void f() {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    c.a(this, localStringBuilder);
    localStringBuilder.append(" id=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v4/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */