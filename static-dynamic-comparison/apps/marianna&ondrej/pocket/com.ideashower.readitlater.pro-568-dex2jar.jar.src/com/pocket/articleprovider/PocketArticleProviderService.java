package com.pocket.articleprovider;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

public class PocketArticleProviderService
  extends Service
  implements k
{
  final Messenger a = new Messenger(new l(this));
  Messenger b;
  
  public boolean a(String paramString)
  {
    return a(("J" + paramString).getBytes());
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    boolean bool = false;
    Message localMessage;
    if (this.b != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putByteArray("data", paramArrayOfByte);
      localMessage = Message.obtain(null, 3);
      localMessage.setData(localBundle);
    }
    try
    {
      this.b.send(localMessage);
      int i = paramArrayOfByte.length;
      if (i > 20000) {}
      bool = true;
      return bool;
    }
    catch (RemoteException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return false;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    m.a(this, this);
    return this.a.getBinder();
  }
  
  public void onDestroy()
  {
    m.a(this).g();
    super.onDestroy();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/articleprovider/PocketArticleProviderService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */