package com.vungle.sdk.a.a;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.vungle.sdk.VungleIntentService;
import com.vungle.sdk.VungleIntentService.a;
import com.vungle.sdk.a.a;

public final class h
  extends VungleIntentService.a
  implements r
{
  private static final String c = VungleIntentService.a;
  
  public h(VungleIntentService paramVungleIntentService)
  {
    super(paramVungleIntentService, "Http");
  }
  
  private Message b(g paramg)
  {
    Message localMessage = this.b.obtainMessage(1);
    localMessage.obj = paramg;
    return localMessage;
  }
  
  protected final void a(Intent paramIntent)
  {
    paramIntent = (g)paramIntent.getParcelableExtra("httpRequest");
    if (paramIntent == null)
    {
      paramIntent = c;
      return;
    }
    String str = c;
    new StringBuilder("Queuing ").append(paramIntent);
    this.b.sendMessage(b(paramIntent));
  }
  
  protected final void a(Message paramMessage)
  {
    paramMessage = (g)paramMessage.obj;
    if (paramMessage == null) {
      paramMessage = c;
    }
    Object localObject1;
    Object localObject2;
    do
    {
      return;
      a.a().b();
      localObject1 = c;
      new StringBuilder("Sending ").append(paramMessage);
      e.a();
      localObject1 = e.a(paramMessage);
      localObject2 = c;
      new StringBuilder("Received ").append(paramMessage);
      localObject2 = paramMessage.j();
    } while (localObject2 == null);
    ((j)localObject2).a(paramMessage, (i)localObject1, this);
  }
  
  public final void a(g paramg)
  {
    this.b.sendMessage(b(paramg));
  }
  
  public final void a(g paramg, long paramLong)
  {
    this.b.sendMessageDelayed(b(paramg), paramLong);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/a/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */