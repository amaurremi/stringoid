package com.pocket.articleprovider;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

final class l
  extends Handler
{
  l(PocketArticleProviderService paramPocketArticleProviderService) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 3: 
    default: 
      super.handleMessage(paramMessage);
      return;
    case 1: 
      this.a.b = paramMessage.replyTo;
      return;
    case 2: 
      paramMessage = paramMessage.getData().getByteArray("data");
      m.a(this.a.getApplicationContext()).a(new String(paramMessage));
      return;
    }
    m.a(this.a.getApplicationContext()).g();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/articleprovider/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */