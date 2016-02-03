package com.vungle.publisher;

final class dg
  implements Runnable
{
  final dn a;
  private final di b;
  
  dg(di paramdi)
  {
    this.b = paramdi;
    this.a = new dn();
  }
  
  public final void run()
  {
    dm localdm = this.a.a();
    if (localdm == null) {
      throw new IllegalStateException("No pending post available");
    }
    this.b.a(localdm);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/dg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */