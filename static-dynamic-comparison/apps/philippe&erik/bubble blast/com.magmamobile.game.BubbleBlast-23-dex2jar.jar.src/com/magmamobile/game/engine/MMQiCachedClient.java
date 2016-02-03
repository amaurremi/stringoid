package com.magmamobile.game.engine;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public final class MMQiCachedClient
{
  private byte[] data;
  private long date;
  private Handler handler;
  private OnEventListener listener;
  private boolean once;
  
  public MMQiCachedClient(OnEventListener paramOnEventListener)
  {
    this.listener = paramOnEventListener;
    this.handler = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        MMQiCachedClient.this.once = false;
        if (MMQiCachedClient.this.listener != null) {
          MMQiCachedClient.this.listener.onRequest(MMQiCachedClient.this, MMQiCachedClient.this.data);
        }
      }
    };
  }
  
  private boolean getCache(String paramString)
    throws Exception
  {
    Object localObject = getFile(paramString);
    if ((((File)localObject).exists()) && (((File)localObject).canRead()))
    {
      this.date = ((File)localObject).lastModified();
      paramString = new FileInputStream((File)localObject);
      localObject = new byte[(int)((File)localObject).length()];
      paramString.read((byte[])localObject);
      paramString.close();
      this.data = ((byte[])localObject);
      return true;
    }
    return false;
  }
  
  private File getFile(String paramString)
  {
    if (Environment.getExternalStorageDirectory().canWrite()) {}
    for (File localFile = Environment.getExternalStorageDirectory();; localFile = Game.getContext().getCacheDir()) {
      return new File(localFile.getPath().concat("/").concat(paramString + ".dat"));
    }
  }
  
  private void sendRequest(String paramString1, int paramInt, String paramString2)
  {
    try
    {
      getCache(paramString2);
      Object localObject = new Socket();
      ((Socket)localObject).connect(new InetSocketAddress(paramString1, paramInt));
      if (((Socket)localObject).isConnected())
      {
        ((Socket)localObject).getOutputStream().write((paramString2 + "/" + this.date).getBytes());
        paramString1 = ((Socket)localObject).getInputStream();
        localObject = new ByteArrayOutputStream();
        byte[] arrayOfByte = new byte['က'];
        for (;;)
        {
          paramInt = paramString1.read(arrayOfByte);
          if (paramInt < 0)
          {
            paramString1.close();
            ((ByteArrayOutputStream)localObject).close();
            paramString1 = ((ByteArrayOutputStream)localObject).toByteArray();
            if (paramString1.length <= 0) {
              break;
            }
            this.data = paramString1;
            setCache(paramString2);
            return;
          }
          ((ByteArrayOutputStream)localObject).write(arrayOfByte, 0, paramInt);
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
  
  private boolean setCache(String paramString)
    throws Exception
  {
    Debug.e("set cache");
    paramString = new FileOutputStream(getFile(paramString));
    paramString.write(this.data);
    paramString.flush();
    paramString.close();
    return true;
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
        MMQiCachedClient.this.sendRequest(paramString1, paramInt, paramString2);
        MMQiCachedClient.this.handler.sendEmptyMessage(0);
      }
    }.start();
  }
  
  public void sendSyncRequest(String paramString1, int paramInt, String paramString2)
  {
    sendRequest(paramString1, paramInt, paramString2);
  }
  
  public static abstract interface OnEventListener
  {
    public abstract void onRequest(MMQiCachedClient paramMMQiCachedClient, byte[] paramArrayOfByte);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/MMQiCachedClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */