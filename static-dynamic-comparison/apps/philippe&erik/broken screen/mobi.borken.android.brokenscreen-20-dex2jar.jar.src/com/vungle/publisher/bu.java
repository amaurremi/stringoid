package com.vungle.publisher;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.vungle.publisher.inject.annotations.VungleServiceClass;
import com.vungle.publisher.log.Logger;
import com.vungle.publisher.net.http.HttpRequest;
import com.vungle.publisher.net.http.HttpTransaction;
import javax.inject.Inject;

public abstract class bu
{
  @Inject
  public Context b;
  @VungleServiceClass
  @Inject
  public Class c;
  
  public abstract String a();
  
  public final void a(HttpTransaction paramHttpTransaction)
  {
    Logger.d(b(), "sending " + paramHttpTransaction);
    Intent localIntent = new Intent(a(), Uri.parse(paramHttpTransaction.a.b), this.b, this.c);
    localIntent.putExtra("transaction", paramHttpTransaction);
    this.b.startService(localIntent);
  }
  
  public String b()
  {
    return "VungleNetwork";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */