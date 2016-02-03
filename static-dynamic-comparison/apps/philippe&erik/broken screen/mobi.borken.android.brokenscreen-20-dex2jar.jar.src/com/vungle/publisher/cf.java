package com.vungle.publisher;

import com.vungle.publisher.log.Logger;
import com.vungle.publisher.net.http.HttpTransaction;
import com.vungle.publisher.net.http.HttpTransaction.a;

final class cf
  implements bs, Runnable
{
  private final String a;
  private final HttpTransaction b;
  private final HttpTransaction.a c;
  
  cf(String paramString, HttpTransaction paramHttpTransaction, HttpTransaction.a parama)
  {
    this.a = paramString;
    this.b = paramHttpTransaction;
    this.c = parama;
  }
  
  public final void run()
  {
    try
    {
      Logger.d("VungleService", this.a + " executing " + this.b);
      this.b.a(this.c);
      return;
    }
    catch (Exception localException)
    {
      Logger.e("VungleService", this.a + " error processing transaction: " + this.b, localException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */