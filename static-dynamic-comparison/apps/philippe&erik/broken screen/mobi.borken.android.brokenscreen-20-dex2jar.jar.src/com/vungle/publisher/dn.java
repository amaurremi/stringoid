package com.vungle.publisher;

final class dn
{
  private dm a;
  private dm b;
  
  final dm a()
  {
    try
    {
      dm localdm = this.a;
      if (this.a != null)
      {
        this.a = this.a.c;
        if (this.a == null) {
          this.b = null;
        }
      }
      return localdm;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  final void a(dm paramdm)
  {
    if (paramdm == null) {
      try
      {
        throw new NullPointerException("null cannot be enqueued");
      }
      finally {}
    }
    if (this.b != null)
    {
      this.b.c = paramdm;
      this.b = paramdm;
    }
    for (;;)
    {
      notifyAll();
      return;
      if (this.a != null) {
        break;
      }
      this.b = paramdm;
      this.a = paramdm;
    }
    throw new IllegalStateException("Head present, but no tail");
  }
  
  final dm b()
    throws InterruptedException
  {
    try
    {
      if (this.a == null) {
        wait(1000L);
      }
      dm localdm = a();
      return localdm;
    }
    finally {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/dn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */