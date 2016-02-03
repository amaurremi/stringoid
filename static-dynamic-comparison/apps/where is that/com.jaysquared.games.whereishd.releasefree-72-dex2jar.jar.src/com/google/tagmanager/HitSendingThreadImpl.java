package com.google.tagmanager;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

class HitSendingThreadImpl
  extends Thread
  implements HitSendingThread
{
  private static HitSendingThreadImpl sInstance;
  private volatile boolean mClosed = false;
  private final Context mContext;
  private volatile boolean mDisabled = false;
  private volatile HitStore mUrlStore;
  private final LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue();
  
  private HitSendingThreadImpl(Context paramContext)
  {
    super("GAThread");
    if (paramContext != null) {}
    for (this.mContext = paramContext.getApplicationContext();; this.mContext = paramContext)
    {
      start();
      return;
    }
  }
  
  @VisibleForTesting
  HitSendingThreadImpl(Context paramContext, HitStore paramHitStore)
  {
    super("GAThread");
    if (paramContext != null) {}
    for (this.mContext = paramContext.getApplicationContext();; this.mContext = paramContext)
    {
      this.mUrlStore = paramHitStore;
      start();
      return;
    }
  }
  
  static HitSendingThreadImpl getInstance(Context paramContext)
  {
    if (sInstance == null) {
      sInstance = new HitSendingThreadImpl(paramContext);
    }
    return sInstance;
  }
  
  private String printStackTrace(Throwable paramThrowable)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    paramThrowable.printStackTrace(localPrintStream);
    localPrintStream.flush();
    return new String(localByteArrayOutputStream.toByteArray());
  }
  
  @VisibleForTesting
  void close()
  {
    this.mClosed = true;
    interrupt();
  }
  
  @VisibleForTesting
  int getQueueSize()
  {
    return this.queue.size();
  }
  
  @VisibleForTesting
  HitStore getStore()
  {
    return this.mUrlStore;
  }
  
  @VisibleForTesting
  boolean isDisabled()
  {
    return this.mDisabled;
  }
  
  public void queueToThread(Runnable paramRunnable)
  {
    this.queue.add(paramRunnable);
  }
  
  public void run()
  {
    while (!this.mClosed) {
      try
      {
        Runnable localRunnable = (Runnable)this.queue.take();
        if (!this.mDisabled) {
          localRunnable.run();
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        Log.i(localInterruptedException.toString());
      }
      catch (Throwable localThrowable)
      {
        Log.e("Error on GAThread: " + printStackTrace(localThrowable));
        Log.e("Google Analytics is shutting down.");
        this.mDisabled = true;
      }
    }
  }
  
  public void sendHit(String paramString)
  {
    sendHit(paramString, System.currentTimeMillis());
  }
  
  @VisibleForTesting
  void sendHit(String paramString, final long paramLong)
  {
    queueToThread(new Runnable()
    {
      public void run()
      {
        if (HitSendingThreadImpl.this.mUrlStore == null)
        {
          ServiceManagerImpl localServiceManagerImpl = ServiceManagerImpl.getInstance();
          localServiceManagerImpl.initialize(HitSendingThreadImpl.this.mContext, jdField_this);
          HitSendingThreadImpl.access$002(HitSendingThreadImpl.this, localServiceManagerImpl.getStore());
        }
        HitSendingThreadImpl.this.mUrlStore.putHit(paramLong, this.val$url);
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/HitSendingThreadImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */