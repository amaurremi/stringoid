package com.magmamobile.game.engine;

import android.os.Handler;
import android.os.Message;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public final class MMQiClient
{
  private byte[] data;
  private Handler handler;
  private OnEventListener listener;
  private boolean once;
  
  public MMQiClient(OnEventListener paramOnEventListener)
  {
    this.listener = paramOnEventListener;
    this.handler = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        MMQiClient.this.once = false;
        if (MMQiClient.this.listener != null) {
          MMQiClient.this.listener.onRequest(MMQiClient.this, MMQiClient.this.data);
        }
      }
    };
  }
  
  private void sendRequest(String paramString1, int paramInt, String paramString2)
  {
    try
    {
      Object localObject = new Socket();
      ((Socket)localObject).connect(new InetSocketAddress(paramString1, paramInt));
      if (((Socket)localObject).isConnected())
      {
        ((Socket)localObject).getOutputStream().write(paramString2.getBytes());
        paramString1 = ((Socket)localObject).getInputStream();
        paramString2 = new ByteArrayOutputStream();
        localObject = new byte['က'];
        for (;;)
        {
          paramInt = paramString1.read((byte[])localObject);
          if (paramInt < 0)
          {
            paramString1.close();
            paramString2.close();
            this.data = paramString2.toByteArray();
            return;
          }
          paramString2.write((byte[])localObject, 0, paramInt);
        }
      }
      return;
    }
    catch (SocketException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public byte[] getData()
  {
    return this.data;
  }
  
  public void sendAsyncRequest(final String paramString1, final int paramInt, final String paramString2)
  {
    if (this.once)
    {
      this.handler.sendEmptyMessage(0);
      return;
    }
    this.once = true;
    this.data = null;
    new Thread()
    {
      public void run()
      {
        MMQiClient.this.sendRequest(paramString1, paramInt, paramString2);
        MMQiClient.this.handler.sendEmptyMessage(0);
      }
    }.start();
  }
  
  public void sendSyncRequest(String paramString1, int paramInt, String paramString2)
  {
    sendRequest(paramString1, paramInt, paramString2);
  }
  
  public static abstract interface OnEventListener
  {
    public abstract void onRequest(MMQiClient paramMMQiClient, byte[] paramArrayOfByte);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/MMQiClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */