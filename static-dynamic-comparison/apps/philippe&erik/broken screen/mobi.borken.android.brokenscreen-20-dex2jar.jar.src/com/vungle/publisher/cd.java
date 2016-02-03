package com.vungle.publisher;

import android.content.Intent;
import com.vungle.publisher.log.Logger;
import com.vungle.publisher.net.http.HttpTransaction;
import com.vungle.publisher.net.http.HttpTransaction.a;
import javax.inject.Inject;

public final class cd
  extends ca
  implements HttpTransaction.a
{
  br f;
  
  public cd(String paramString, int paramInt1, int paramInt2)
  {
    super(paramString, paramInt1, paramInt2);
  }
  
  private Runnable b(HttpTransaction paramHttpTransaction)
  {
    Logger.d("VungleService", this.a + " creating runnable: " + paramHttpTransaction);
    return new cf(this.a, paramHttpTransaction, this);
  }
  
  protected final Runnable a(Intent paramIntent)
    throws IllegalArgumentException
  {
    paramIntent = (HttpTransaction)paramIntent.getParcelableExtra("transaction");
    if (paramIntent == null) {
      throw new IllegalArgumentException("no HTTP transaction in intent");
    }
    return b(paramIntent);
  }
  
  public final void a(HttpTransaction paramHttpTransaction)
  {
    a(b(paramHttpTransaction), 1);
  }
  
  public final void a(HttpTransaction paramHttpTransaction, int paramInt)
  {
    a(b(paramHttpTransaction), paramInt);
  }
  
  public final void a(Thread paramThread, Runnable paramRunnable, int paramInt1, int paramInt2)
  {
    super.a(paramThread, paramRunnable, paramInt1, paramInt2);
    if ((paramRunnable != null) && ((paramRunnable instanceof bs))) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        this.f.d();
      }
      return;
    }
  }
  
  public static class a
  {
    @Inject
    public br a;
    
    public final cd a(String paramString, int paramInt1, int paramInt2, ce.a... paramVarArgs)
    {
      paramString = new cd(paramString, paramInt1, paramInt2);
      paramString.a(paramVarArgs);
      paramString.f = this.a;
      return paramString;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */