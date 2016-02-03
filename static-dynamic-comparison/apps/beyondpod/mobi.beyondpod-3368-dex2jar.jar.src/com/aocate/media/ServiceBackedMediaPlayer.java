package com.aocate.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.RemoteException;
import android.util.Log;
import com.aocate.presto.service.IDeathCallback_0_8.Stub;
import com.aocate.presto.service.IOnBufferingUpdateListenerCallback_0_8.Stub;
import com.aocate.presto.service.IOnCompletionListenerCallback_0_8.Stub;
import com.aocate.presto.service.IOnErrorListenerCallback_0_8.Stub;
import com.aocate.presto.service.IOnInfoListenerCallback_0_8.Stub;
import com.aocate.presto.service.IOnPitchAdjustmentAvailableChangedListenerCallback_0_8.Stub;
import com.aocate.presto.service.IOnPreparedListenerCallback_0_8.Stub;
import com.aocate.presto.service.IOnSeekCompleteListenerCallback_0_8.Stub;
import com.aocate.presto.service.IOnSpeedAdjustmentAvailableChangedListenerCallback_0_8.Stub;
import com.aocate.presto.service.IPlayMedia_0_8;
import com.aocate.presto.service.IPlayMedia_0_8.Stub;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class ServiceBackedMediaPlayer
  extends MediaPlayerImpl
{
  static final String INTENT_NAME = "com.aocate.intent.PLAY_AUDIO_ADJUST_SPEED_0_8";
  private static final String SBMP_TAG = "AocateServiceBackedMediaPlayer";
  private boolean isErroring = false;
  private int mAudioStreamType = 3;
  private IOnBufferingUpdateListenerCallback_0_8.Stub mOnBufferingUpdateCallback = null;
  private IOnCompletionListenerCallback_0_8.Stub mOnCompletionCallback = null;
  private IOnErrorListenerCallback_0_8.Stub mOnErrorCallback = null;
  private IOnInfoListenerCallback_0_8.Stub mOnInfoCallback = null;
  private IOnPitchAdjustmentAvailableChangedListenerCallback_0_8.Stub mOnPitchAdjustmentAvailableChangedCallback = null;
  private IOnPreparedListenerCallback_0_8.Stub mOnPreparedCallback = null;
  private IOnSeekCompleteListenerCallback_0_8.Stub mOnSeekCompleteCallback = null;
  private IOnSpeedAdjustmentAvailableChangedListenerCallback_0_8.Stub mOnSpeedAdjustmentAvailableChangedCallback = null;
  private ServiceConnection mPlayMediaServiceConnection = null;
  private PowerManager.WakeLock mWakeLock = null;
  private int mWakeMode;
  private Intent playMediaServiceIntent = null;
  protected IPlayMedia_0_8 pmInterface = null;
  private ReentrantReadWriteLock pmLock = new ReentrantReadWriteLock();
  private ReentrantReadWriteLock.ReadLock pmReadLock;
  private ReentrantReadWriteLock.WriteLock pmWriteLock;
  private long sessionId = 0L;
  
  public ServiceBackedMediaPlayer(MediaPlayer paramMediaPlayer, Context paramContext, final ServiceConnection paramServiceConnection)
  {
    super(paramMediaPlayer, paramContext);
    Log.d("AocateServiceBackedMediaPlayer", "Instantiating ServiceBackedMediaPlayer 87");
    this.pmReadLock = this.pmLock.readLock();
    this.pmWriteLock = this.pmLock.writeLock();
    this.playMediaServiceIntent = new Intent("com.aocate.intent.PLAY_AUDIO_ADJUST_SPEED_0_8");
    this.mPlayMediaServiceConnection = new ServiceConnection()
    {
      public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        IPlayMedia_0_8 localIPlayMedia_0_8 = IPlayMedia_0_8.Stub.asInterface(paramAnonymousIBinder);
        Log.d("AocateServiceBackedMediaPlayer", "Setting up pmInterface 94");
        if (ServiceBackedMediaPlayer.this.sessionId == 0L) {}
        try
        {
          ServiceBackedMediaPlayer.this.sessionId = localIPlayMedia_0_8.startSession(new IDeathCallback_0_8.Stub() {});
          Log.d("AocateServiceBackedMediaPlayer", "Assigning pmInterface");
          ServiceBackedMediaPlayer.this.pmWriteLock.lock();
        }
        catch (RemoteException localRemoteException)
        {
          for (;;)
          {
            try
            {
              ServiceBackedMediaPlayer.this.setOnBufferingUpdateCallback(localIPlayMedia_0_8);
              ServiceBackedMediaPlayer.this.setOnCompletionCallback(localIPlayMedia_0_8);
              ServiceBackedMediaPlayer.this.setOnErrorCallback(localIPlayMedia_0_8);
              ServiceBackedMediaPlayer.this.setOnInfoCallback(localIPlayMedia_0_8);
              ServiceBackedMediaPlayer.this.setOnPitchAdjustmentAvailableChangedListener(localIPlayMedia_0_8);
              ServiceBackedMediaPlayer.this.setOnPreparedCallback(localIPlayMedia_0_8);
              ServiceBackedMediaPlayer.this.setOnSeekCompleteCallback(localIPlayMedia_0_8);
              ServiceBackedMediaPlayer.this.setOnSpeedAdjustmentAvailableChangedCallback(localIPlayMedia_0_8);
              ServiceBackedMediaPlayer.this.pmInterface = localIPlayMedia_0_8;
              ServiceBackedMediaPlayer.this.pmWriteLock.unlock();
              Log.d("AocateServiceBackedMediaPlayer", "Invoking onServiceConnected");
              return;
            }
            finally
            {
              ServiceBackedMediaPlayer.this.pmWriteLock.unlock();
            }
            localRemoteException = localRemoteException;
            localRemoteException.printStackTrace();
            ServiceBackedMediaPlayer.this.error(1, 0);
          }
        }
      }
      
      public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        Log.d("AocateServiceBackedMediaPlayer", "onServiceDisconnected 114");
        ServiceBackedMediaPlayer.this.pmWriteLock.lock();
        try
        {
          ServiceBackedMediaPlayer.this.pmInterface = null;
          ServiceBackedMediaPlayer.this.pmWriteLock.unlock();
          ServiceBackedMediaPlayer.this.sessionId = 0L;
          paramServiceConnection.onServiceDisconnected(paramAnonymousComponentName);
          return;
        }
        finally
        {
          ServiceBackedMediaPlayer.this.pmWriteLock.unlock();
        }
      }
    };
    Log.d("AocateServiceBackedMediaPlayer", "Connecting PlayMediaService 124");
    if (!ConnectPlayMediaService()) {
      error(1, 0);
    }
  }
  
  private boolean ConnectPlayMediaService()
  {
    Log.d("AocateServiceBackedMediaPlayer", "ConnectPlayMediaService()");
    if (MediaPlayer.isIntentAvailable(this.mContext, "com.aocate.intent.PLAY_AUDIO_ADJUST_SPEED_0_8"))
    {
      Log.d("AocateServiceBackedMediaPlayer", "com.aocate.intent.PLAY_AUDIO_ADJUST_SPEED_0_8 is available");
      if (this.pmInterface == null) {
        try
        {
          Log.d("AocateServiceBackedMediaPlayer", "Binding service");
          boolean bool = this.mContext.bindService(this.playMediaServiceIntent, this.mPlayMediaServiceConnection, 1);
          return bool;
        }
        catch (Exception localException)
        {
          return false;
        }
      }
      Log.d("AocateServiceBackedMediaPlayer", "Service already bound");
      return true;
    }
    Log.d("AocateServiceBackedMediaPlayer", "com.aocate.intent.PLAY_AUDIO_ADJUST_SPEED_0_8 is not available");
    return false;
  }
  
  private void setOnBufferingUpdateCallback(IPlayMedia_0_8 paramIPlayMedia_0_8)
  {
    try
    {
      if (this.mOnBufferingUpdateCallback == null) {
        this.mOnBufferingUpdateCallback = new IOnBufferingUpdateListenerCallback_0_8.Stub()
        {
          public void onBufferingUpdate(int paramAnonymousInt)
            throws RemoteException
          {
            ServiceBackedMediaPlayer.this.owningMediaPlayer.lock.lock();
            try
            {
              if ((ServiceBackedMediaPlayer.this.owningMediaPlayer.onBufferingUpdateListener != null) && (ServiceBackedMediaPlayer.this.owningMediaPlayer.mpi == ServiceBackedMediaPlayer.this)) {
                ServiceBackedMediaPlayer.this.owningMediaPlayer.onBufferingUpdateListener.onBufferingUpdate(ServiceBackedMediaPlayer.this.owningMediaPlayer, paramAnonymousInt);
              }
              return;
            }
            finally
            {
              ServiceBackedMediaPlayer.this.owningMediaPlayer.lock.unlock();
            }
          }
        };
      }
      paramIPlayMedia_0_8.registerOnBufferingUpdateCallback(this.sessionId, this.mOnBufferingUpdateCallback);
      return;
    }
    catch (RemoteException paramIPlayMedia_0_8)
    {
      paramIPlayMedia_0_8.printStackTrace();
      error(1, 0);
    }
  }
  
  private void setOnCompletionCallback(IPlayMedia_0_8 paramIPlayMedia_0_8)
  {
    try
    {
      if (this.mOnCompletionCallback == null) {
        this.mOnCompletionCallback = new IOnCompletionListenerCallback_0_8.Stub()
        {
          /* Error */
          public void onCompletion()
            throws RemoteException
          {
            // Byte code:
            //   0: aload_0
            //   1: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$3:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   4: getfield 26	com/aocate/media/ServiceBackedMediaPlayer:owningMediaPlayer	Lcom/aocate/media/MediaPlayer;
            //   7: getfield 32	com/aocate/media/MediaPlayer:lock	Ljava/util/concurrent/locks/ReentrantLock;
            //   10: invokevirtual 36	java/util/concurrent/locks/ReentrantLock:lock	()V
            //   13: ldc 38
            //   15: new 40	java/lang/StringBuilder
            //   18: dup
            //   19: ldc 42
            //   21: invokespecial 45	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
            //   24: aload_0
            //   25: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$3:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   28: getfield 26	com/aocate/media/ServiceBackedMediaPlayer:owningMediaPlayer	Lcom/aocate/media/MediaPlayer;
            //   31: getfield 49	com/aocate/media/MediaPlayer:onCompletionListener	Lcom/aocate/media/MediaPlayer$OnCompletionListener;
            //   34: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
            //   37: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   40: invokestatic 63	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
            //   43: pop
            //   44: ldc 38
            //   46: ldc 65
            //   48: invokestatic 63	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
            //   51: pop
            //   52: aload_0
            //   53: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$3:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   56: invokestatic 69	com/aocate/media/ServiceBackedMediaPlayer:access$11	(Lcom/aocate/media/ServiceBackedMediaPlayer;)Landroid/os/PowerManager$WakeLock;
            //   59: ifnull +99 -> 158
            //   62: aload_0
            //   63: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$3:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   66: invokestatic 69	com/aocate/media/ServiceBackedMediaPlayer:access$11	(Lcom/aocate/media/ServiceBackedMediaPlayer;)Landroid/os/PowerManager$WakeLock;
            //   69: invokevirtual 75	android/os/PowerManager$WakeLock:isHeld	()Z
            //   72: ifeq +86 -> 158
            //   75: aload_0
            //   76: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$3:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   79: invokestatic 69	com/aocate/media/ServiceBackedMediaPlayer:access$11	(Lcom/aocate/media/ServiceBackedMediaPlayer;)Landroid/os/PowerManager$WakeLock;
            //   82: invokevirtual 78	android/os/PowerManager$WakeLock:release	()V
            //   85: ldc 38
            //   87: ldc 80
            //   89: invokestatic 63	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
            //   92: pop
            //   93: aload_0
            //   94: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$3:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   97: getfield 26	com/aocate/media/ServiceBackedMediaPlayer:owningMediaPlayer	Lcom/aocate/media/MediaPlayer;
            //   100: getfield 49	com/aocate/media/MediaPlayer:onCompletionListener	Lcom/aocate/media/MediaPlayer$OnCompletionListener;
            //   103: ifnull +41 -> 144
            //   106: ldc 38
            //   108: ldc 82
            //   110: invokestatic 63	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
            //   113: pop
            //   114: aload_0
            //   115: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$3:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   118: getfield 26	com/aocate/media/ServiceBackedMediaPlayer:owningMediaPlayer	Lcom/aocate/media/MediaPlayer;
            //   121: getfield 49	com/aocate/media/MediaPlayer:onCompletionListener	Lcom/aocate/media/MediaPlayer$OnCompletionListener;
            //   124: aload_0
            //   125: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$3:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   128: getfield 26	com/aocate/media/ServiceBackedMediaPlayer:owningMediaPlayer	Lcom/aocate/media/MediaPlayer;
            //   131: invokeinterface 87 2 0
            //   136: ldc 38
            //   138: ldc 89
            //   140: invokestatic 63	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
            //   143: pop
            //   144: aload_0
            //   145: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$3:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   148: getfield 26	com/aocate/media/ServiceBackedMediaPlayer:owningMediaPlayer	Lcom/aocate/media/MediaPlayer;
            //   151: getfield 32	com/aocate/media/MediaPlayer:lock	Ljava/util/concurrent/locks/ReentrantLock;
            //   154: invokevirtual 92	java/util/concurrent/locks/ReentrantLock:unlock	()V
            //   157: return
            //   158: ldc 38
            //   160: ldc 94
            //   162: invokestatic 63	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
            //   165: pop
            //   166: goto -73 -> 93
            //   169: astore_1
            //   170: aload_0
            //   171: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$3:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   174: getfield 26	com/aocate/media/ServiceBackedMediaPlayer:owningMediaPlayer	Lcom/aocate/media/MediaPlayer;
            //   177: getfield 32	com/aocate/media/MediaPlayer:lock	Ljava/util/concurrent/locks/ReentrantLock;
            //   180: invokevirtual 92	java/util/concurrent/locks/ReentrantLock:unlock	()V
            //   183: aload_1
            //   184: athrow
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	185	0	this	3
            //   169	15	1	localObject	Object
            // Exception table:
            //   from	to	target	type
            //   13	93	169	finally
            //   93	144	169	finally
            //   158	166	169	finally
          }
        };
      }
      paramIPlayMedia_0_8.registerOnCompletionCallback(this.sessionId, this.mOnCompletionCallback);
      return;
    }
    catch (RemoteException paramIPlayMedia_0_8)
    {
      paramIPlayMedia_0_8.printStackTrace();
      error(1, 0);
    }
  }
  
  private void setOnErrorCallback(IPlayMedia_0_8 paramIPlayMedia_0_8)
  {
    try
    {
      if (this.mOnErrorCallback == null) {
        this.mOnErrorCallback = new IOnErrorListenerCallback_0_8.Stub()
        {
          public boolean onError(int paramAnonymousInt1, int paramAnonymousInt2)
            throws RemoteException
          {
            ServiceBackedMediaPlayer.this.owningMediaPlayer.lock.lock();
            try
            {
              if ((ServiceBackedMediaPlayer.this.mWakeLock != null) && (ServiceBackedMediaPlayer.this.mWakeLock.isHeld())) {
                ServiceBackedMediaPlayer.this.mWakeLock.release();
              }
              if (ServiceBackedMediaPlayer.this.owningMediaPlayer.onErrorListener != null)
              {
                boolean bool = ServiceBackedMediaPlayer.this.owningMediaPlayer.onErrorListener.onError(ServiceBackedMediaPlayer.this.owningMediaPlayer, paramAnonymousInt1, paramAnonymousInt2);
                return bool;
              }
              return false;
            }
            finally
            {
              ServiceBackedMediaPlayer.this.owningMediaPlayer.lock.unlock();
            }
          }
        };
      }
      paramIPlayMedia_0_8.registerOnErrorCallback(this.sessionId, this.mOnErrorCallback);
      return;
    }
    catch (RemoteException paramIPlayMedia_0_8)
    {
      paramIPlayMedia_0_8.printStackTrace();
      error(1, 0);
    }
  }
  
  private void setOnInfoCallback(IPlayMedia_0_8 paramIPlayMedia_0_8)
  {
    try
    {
      if (this.mOnInfoCallback == null) {
        this.mOnInfoCallback = new IOnInfoListenerCallback_0_8.Stub()
        {
          public boolean onInfo(int paramAnonymousInt1, int paramAnonymousInt2)
            throws RemoteException
          {
            ServiceBackedMediaPlayer.this.owningMediaPlayer.lock.lock();
            try
            {
              if ((ServiceBackedMediaPlayer.this.owningMediaPlayer.onInfoListener != null) && (ServiceBackedMediaPlayer.this.owningMediaPlayer.mpi == ServiceBackedMediaPlayer.this))
              {
                boolean bool = ServiceBackedMediaPlayer.this.owningMediaPlayer.onInfoListener.onInfo(ServiceBackedMediaPlayer.this.owningMediaPlayer, paramAnonymousInt1, paramAnonymousInt2);
                return bool;
              }
            }
            finally
            {
              ServiceBackedMediaPlayer.this.owningMediaPlayer.lock.unlock();
            }
            ServiceBackedMediaPlayer.this.owningMediaPlayer.lock.unlock();
            return false;
          }
        };
      }
      paramIPlayMedia_0_8.registerOnInfoCallback(this.sessionId, this.mOnInfoCallback);
      return;
    }
    catch (RemoteException paramIPlayMedia_0_8)
    {
      paramIPlayMedia_0_8.printStackTrace();
      error(1, 0);
    }
  }
  
  private void setOnPitchAdjustmentAvailableChangedListener(IPlayMedia_0_8 paramIPlayMedia_0_8)
  {
    try
    {
      if (this.mOnPitchAdjustmentAvailableChangedCallback == null) {
        this.mOnPitchAdjustmentAvailableChangedCallback = new IOnPitchAdjustmentAvailableChangedListenerCallback_0_8.Stub()
        {
          public void onPitchAdjustmentAvailableChanged(boolean paramAnonymousBoolean)
            throws RemoteException
          {
            ServiceBackedMediaPlayer.this.owningMediaPlayer.lock.lock();
            try
            {
              if (ServiceBackedMediaPlayer.this.owningMediaPlayer.onPitchAdjustmentAvailableChangedListener != null) {
                ServiceBackedMediaPlayer.this.owningMediaPlayer.onPitchAdjustmentAvailableChangedListener.onPitchAdjustmentAvailableChanged(ServiceBackedMediaPlayer.this.owningMediaPlayer, paramAnonymousBoolean);
              }
              return;
            }
            finally
            {
              ServiceBackedMediaPlayer.this.owningMediaPlayer.lock.unlock();
            }
          }
        };
      }
      paramIPlayMedia_0_8.registerOnPitchAdjustmentAvailableChangedCallback(this.sessionId, this.mOnPitchAdjustmentAvailableChangedCallback);
      return;
    }
    catch (RemoteException paramIPlayMedia_0_8)
    {
      paramIPlayMedia_0_8.printStackTrace();
      error(1, 0);
    }
  }
  
  private void setOnPreparedCallback(IPlayMedia_0_8 paramIPlayMedia_0_8)
  {
    try
    {
      if (this.mOnPreparedCallback == null) {
        this.mOnPreparedCallback = new IOnPreparedListenerCallback_0_8.Stub()
        {
          /* Error */
          public void onPrepared()
            throws RemoteException
          {
            // Byte code:
            //   0: aload_0
            //   1: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$7:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   4: getfield 26	com/aocate/media/ServiceBackedMediaPlayer:owningMediaPlayer	Lcom/aocate/media/MediaPlayer;
            //   7: getfield 32	com/aocate/media/MediaPlayer:lock	Ljava/util/concurrent/locks/ReentrantLock;
            //   10: invokevirtual 36	java/util/concurrent/locks/ReentrantLock:lock	()V
            //   13: ldc 38
            //   15: ldc 40
            //   17: invokestatic 46	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
            //   20: pop
            //   21: new 48	java/lang/StringBuilder
            //   24: dup
            //   25: ldc 50
            //   27: invokespecial 53	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
            //   30: astore_2
            //   31: aload_0
            //   32: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$7:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   35: getfield 26	com/aocate/media/ServiceBackedMediaPlayer:owningMediaPlayer	Lcom/aocate/media/MediaPlayer;
            //   38: getfield 57	com/aocate/media/MediaPlayer:onPreparedListener	Lcom/aocate/media/MediaPlayer$OnPreparedListener;
            //   41: ifnonnull +123 -> 164
            //   44: ldc 59
            //   46: astore_1
            //   47: ldc 38
            //   49: aload_2
            //   50: aload_1
            //   51: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   54: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   57: invokestatic 46	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
            //   60: pop
            //   61: new 48	java/lang/StringBuilder
            //   64: dup
            //   65: ldc 69
            //   67: invokespecial 53	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
            //   70: astore_2
            //   71: aload_0
            //   72: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$7:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   75: getfield 26	com/aocate/media/ServiceBackedMediaPlayer:owningMediaPlayer	Lcom/aocate/media/MediaPlayer;
            //   78: getfield 73	com/aocate/media/MediaPlayer:mpi	Lcom/aocate/media/MediaPlayerImpl;
            //   81: aload_0
            //   82: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$7:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   85: if_acmpne +85 -> 170
            //   88: ldc 75
            //   90: astore_1
            //   91: ldc 38
            //   93: aload_2
            //   94: aload_1
            //   95: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   98: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   101: invokestatic 46	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
            //   104: pop
            //   105: aload_0
            //   106: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$7:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   109: getfield 78	com/aocate/media/ServiceBackedMediaPlayer:lockMuteOnPreparedCount	Ljava/util/concurrent/locks/ReentrantLock;
            //   112: invokevirtual 36	java/util/concurrent/locks/ReentrantLock:lock	()V
            //   115: aload_0
            //   116: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$7:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   119: getfield 82	com/aocate/media/ServiceBackedMediaPlayer:muteOnPreparedCount	I
            //   122: ifle +54 -> 176
            //   125: aload_0
            //   126: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$7:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   129: astore_1
            //   130: aload_1
            //   131: aload_1
            //   132: getfield 82	com/aocate/media/ServiceBackedMediaPlayer:muteOnPreparedCount	I
            //   135: iconst_1
            //   136: isub
            //   137: putfield 82	com/aocate/media/ServiceBackedMediaPlayer:muteOnPreparedCount	I
            //   140: aload_0
            //   141: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$7:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   144: getfield 78	com/aocate/media/ServiceBackedMediaPlayer:lockMuteOnPreparedCount	Ljava/util/concurrent/locks/ReentrantLock;
            //   147: invokevirtual 85	java/util/concurrent/locks/ReentrantLock:unlock	()V
            //   150: aload_0
            //   151: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$7:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   154: getfield 26	com/aocate/media/ServiceBackedMediaPlayer:owningMediaPlayer	Lcom/aocate/media/MediaPlayer;
            //   157: getfield 32	com/aocate/media/MediaPlayer:lock	Ljava/util/concurrent/locks/ReentrantLock;
            //   160: invokevirtual 85	java/util/concurrent/locks/ReentrantLock:unlock	()V
            //   163: return
            //   164: ldc 87
            //   166: astore_1
            //   167: goto -120 -> 47
            //   170: ldc 89
            //   172: astore_1
            //   173: goto -82 -> 91
            //   176: aload_0
            //   177: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$7:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   180: iconst_0
            //   181: putfield 82	com/aocate/media/ServiceBackedMediaPlayer:muteOnPreparedCount	I
            //   184: aload_0
            //   185: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$7:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   188: getfield 26	com/aocate/media/ServiceBackedMediaPlayer:owningMediaPlayer	Lcom/aocate/media/MediaPlayer;
            //   191: getfield 57	com/aocate/media/MediaPlayer:onPreparedListener	Lcom/aocate/media/MediaPlayer$OnPreparedListener;
            //   194: ifnull -54 -> 140
            //   197: aload_0
            //   198: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$7:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   201: getfield 26	com/aocate/media/ServiceBackedMediaPlayer:owningMediaPlayer	Lcom/aocate/media/MediaPlayer;
            //   204: getfield 57	com/aocate/media/MediaPlayer:onPreparedListener	Lcom/aocate/media/MediaPlayer$OnPreparedListener;
            //   207: aload_0
            //   208: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$7:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   211: getfield 26	com/aocate/media/ServiceBackedMediaPlayer:owningMediaPlayer	Lcom/aocate/media/MediaPlayer;
            //   214: invokeinterface 94 2 0
            //   219: goto -79 -> 140
            //   222: astore_1
            //   223: aload_0
            //   224: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$7:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   227: getfield 78	com/aocate/media/ServiceBackedMediaPlayer:lockMuteOnPreparedCount	Ljava/util/concurrent/locks/ReentrantLock;
            //   230: invokevirtual 85	java/util/concurrent/locks/ReentrantLock:unlock	()V
            //   233: aload_1
            //   234: athrow
            //   235: astore_1
            //   236: aload_0
            //   237: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$7:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   240: getfield 26	com/aocate/media/ServiceBackedMediaPlayer:owningMediaPlayer	Lcom/aocate/media/MediaPlayer;
            //   243: getfield 32	com/aocate/media/MediaPlayer:lock	Ljava/util/concurrent/locks/ReentrantLock;
            //   246: invokevirtual 85	java/util/concurrent/locks/ReentrantLock:unlock	()V
            //   249: aload_1
            //   250: athrow
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	251	0	this	7
            //   46	127	1	localObject1	Object
            //   222	12	1	localObject2	Object
            //   235	15	1	localObject3	Object
            //   30	64	2	localStringBuilder	StringBuilder
            // Exception table:
            //   from	to	target	type
            //   115	140	222	finally
            //   176	219	222	finally
            //   21	44	235	finally
            //   47	88	235	finally
            //   91	115	235	finally
            //   140	150	235	finally
            //   223	235	235	finally
          }
        };
      }
      paramIPlayMedia_0_8.registerOnPreparedCallback(this.sessionId, this.mOnPreparedCallback);
      return;
    }
    catch (RemoteException paramIPlayMedia_0_8)
    {
      paramIPlayMedia_0_8.printStackTrace();
      error(1, 0);
    }
  }
  
  private void setOnSeekCompleteCallback(IPlayMedia_0_8 paramIPlayMedia_0_8)
  {
    try
    {
      if (this.mOnSeekCompleteCallback == null) {
        this.mOnSeekCompleteCallback = new IOnSeekCompleteListenerCallback_0_8.Stub()
        {
          /* Error */
          public void onSeekComplete()
            throws RemoteException
          {
            // Byte code:
            //   0: ldc 24
            //   2: ldc 26
            //   4: invokestatic 32	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
            //   7: pop
            //   8: aload_0
            //   9: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$8:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   12: getfield 36	com/aocate/media/ServiceBackedMediaPlayer:owningMediaPlayer	Lcom/aocate/media/MediaPlayer;
            //   15: getfield 42	com/aocate/media/MediaPlayer:lock	Ljava/util/concurrent/locks/ReentrantLock;
            //   18: invokevirtual 46	java/util/concurrent/locks/ReentrantLock:lock	()V
            //   21: aload_0
            //   22: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$8:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   25: getfield 50	com/aocate/media/ServiceBackedMediaPlayer:muteOnSeekCount	I
            //   28: ifle +65 -> 93
            //   31: ldc 24
            //   33: new 52	java/lang/StringBuilder
            //   36: dup
            //   37: ldc 54
            //   39: invokespecial 57	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
            //   42: aload_0
            //   43: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$8:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   46: getfield 50	com/aocate/media/ServiceBackedMediaPlayer:muteOnSeekCount	I
            //   49: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
            //   52: ldc 63
            //   54: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   57: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   60: invokestatic 32	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
            //   63: pop
            //   64: aload_0
            //   65: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$8:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   68: astore_1
            //   69: aload_1
            //   70: aload_1
            //   71: getfield 50	com/aocate/media/ServiceBackedMediaPlayer:muteOnSeekCount	I
            //   74: iconst_1
            //   75: isub
            //   76: putfield 50	com/aocate/media/ServiceBackedMediaPlayer:muteOnSeekCount	I
            //   79: aload_0
            //   80: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$8:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   83: getfield 36	com/aocate/media/ServiceBackedMediaPlayer:owningMediaPlayer	Lcom/aocate/media/MediaPlayer;
            //   86: getfield 42	com/aocate/media/MediaPlayer:lock	Ljava/util/concurrent/locks/ReentrantLock;
            //   89: invokevirtual 73	java/util/concurrent/locks/ReentrantLock:unlock	()V
            //   92: return
            //   93: aload_0
            //   94: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$8:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   97: iconst_0
            //   98: putfield 50	com/aocate/media/ServiceBackedMediaPlayer:muteOnSeekCount	I
            //   101: ldc 24
            //   103: ldc 75
            //   105: invokestatic 32	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
            //   108: pop
            //   109: aload_0
            //   110: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$8:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   113: getfield 36	com/aocate/media/ServiceBackedMediaPlayer:owningMediaPlayer	Lcom/aocate/media/MediaPlayer;
            //   116: getfield 79	com/aocate/media/MediaPlayer:onSeekCompleteListener	Lcom/aocate/media/MediaPlayer$OnSeekCompleteListener;
            //   119: ifnull -40 -> 79
            //   122: ldc 24
            //   124: ldc 81
            //   126: invokestatic 32	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
            //   129: pop
            //   130: aload_0
            //   131: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$8:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   134: getfield 36	com/aocate/media/ServiceBackedMediaPlayer:owningMediaPlayer	Lcom/aocate/media/MediaPlayer;
            //   137: getfield 79	com/aocate/media/MediaPlayer:onSeekCompleteListener	Lcom/aocate/media/MediaPlayer$OnSeekCompleteListener;
            //   140: aload_0
            //   141: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$8:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   144: getfield 36	com/aocate/media/ServiceBackedMediaPlayer:owningMediaPlayer	Lcom/aocate/media/MediaPlayer;
            //   147: invokeinterface 86 2 0
            //   152: goto -73 -> 79
            //   155: astore_1
            //   156: aload_0
            //   157: getfield 15	com/aocate/media/ServiceBackedMediaPlayer$8:this$0	Lcom/aocate/media/ServiceBackedMediaPlayer;
            //   160: getfield 36	com/aocate/media/ServiceBackedMediaPlayer:owningMediaPlayer	Lcom/aocate/media/MediaPlayer;
            //   163: getfield 42	com/aocate/media/MediaPlayer:lock	Ljava/util/concurrent/locks/ReentrantLock;
            //   166: invokevirtual 73	java/util/concurrent/locks/ReentrantLock:unlock	()V
            //   169: aload_1
            //   170: athrow
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	171	0	this	8
            //   68	3	1	localServiceBackedMediaPlayer	ServiceBackedMediaPlayer
            //   155	15	1	localObject	Object
            // Exception table:
            //   from	to	target	type
            //   21	79	155	finally
            //   93	152	155	finally
          }
        };
      }
      paramIPlayMedia_0_8.registerOnSeekCompleteCallback(this.sessionId, this.mOnSeekCompleteCallback);
      return;
    }
    catch (RemoteException paramIPlayMedia_0_8)
    {
      paramIPlayMedia_0_8.printStackTrace();
      error(1, 0);
    }
  }
  
  private void setOnSpeedAdjustmentAvailableChangedCallback(IPlayMedia_0_8 paramIPlayMedia_0_8)
  {
    try
    {
      Log.d("AocateServiceBackedMediaPlayer", "Setting the service of on speed adjustment available changed");
      if (this.mOnSpeedAdjustmentAvailableChangedCallback == null) {
        this.mOnSpeedAdjustmentAvailableChangedCallback = new IOnSpeedAdjustmentAvailableChangedListenerCallback_0_8.Stub()
        {
          public void onSpeedAdjustmentAvailableChanged(boolean paramAnonymousBoolean)
            throws RemoteException
          {
            ServiceBackedMediaPlayer.this.owningMediaPlayer.lock.lock();
            try
            {
              if (ServiceBackedMediaPlayer.this.owningMediaPlayer.onSpeedAdjustmentAvailableChangedListener != null) {
                ServiceBackedMediaPlayer.this.owningMediaPlayer.onSpeedAdjustmentAvailableChangedListener.onSpeedAdjustmentAvailableChanged(ServiceBackedMediaPlayer.this.owningMediaPlayer, paramAnonymousBoolean);
              }
              return;
            }
            finally
            {
              ServiceBackedMediaPlayer.this.owningMediaPlayer.lock.unlock();
            }
          }
        };
      }
      paramIPlayMedia_0_8.registerOnSpeedAdjustmentAvailableChangedCallback(this.sessionId, this.mOnSpeedAdjustmentAvailableChangedCallback);
      return;
    }
    catch (RemoteException paramIPlayMedia_0_8)
    {
      paramIPlayMedia_0_8.printStackTrace();
      error(1, 0);
    }
  }
  
  public boolean canSetPitch()
  {
    Log.d("AocateServiceBackedMediaPlayer", "canSetPitch() 155");
    if ((this.pmInterface == null) && (!ConnectPlayMediaService())) {
      error(1, 0);
    }
    this.pmReadLock.lock();
    try
    {
      IPlayMedia_0_8 localIPlayMedia_0_8 = this.pmInterface;
      if (localIPlayMedia_0_8 != null) {
        try
        {
          boolean bool = this.pmInterface.canSetPitch(this.sessionId);
          return bool;
        }
        catch (RemoteException localRemoteException)
        {
          localRemoteException.printStackTrace();
          error(1, 0);
        }
      }
      return false;
    }
    finally
    {
      this.pmReadLock.unlock();
    }
  }
  
  public boolean canSetSpeed()
  {
    Log.d("AocateServiceBackedMediaPlayer", "canSetSpeed() 180");
    if ((this.pmInterface == null) && (!ConnectPlayMediaService())) {
      error(1, 0);
    }
    this.pmReadLock.lock();
    try
    {
      IPlayMedia_0_8 localIPlayMedia_0_8 = this.pmInterface;
      if (localIPlayMedia_0_8 != null) {
        try
        {
          boolean bool = this.pmInterface.canSetSpeed(this.sessionId);
          return bool;
        }
        catch (RemoteException localRemoteException)
        {
          localRemoteException.printStackTrace();
          error(1, 0);
        }
      }
      return false;
    }
    finally
    {
      this.pmReadLock.unlock();
    }
  }
  
  void error(int paramInt1, int paramInt2)
  {
    this.owningMediaPlayer.lock.lock();
    Log.e("AocateServiceBackedMediaPlayer", "error(" + paramInt1 + ", " + paramInt2 + ")");
    try
    {
      if (!this.isErroring)
      {
        this.isErroring = true;
        this.owningMediaPlayer.state = MediaPlayer.State.ERROR;
        if (this.owningMediaPlayer.onErrorListener != null)
        {
          boolean bool = this.owningMediaPlayer.onErrorListener.onError(this.owningMediaPlayer, paramInt1, paramInt2);
          if (bool) {
            return;
          }
        }
        if (this.owningMediaPlayer.onCompletionListener != null) {
          this.owningMediaPlayer.onCompletionListener.onCompletion(this.owningMediaPlayer);
        }
      }
      return;
    }
    finally
    {
      this.isErroring = false;
      this.owningMediaPlayer.lock.unlock();
    }
  }
  
  protected void finalize()
    throws Throwable
  {
    this.owningMediaPlayer.lock.lock();
    try
    {
      Log.d("AocateServiceBackedMediaPlayer", "finalize() 224");
      release();
      return;
    }
    finally
    {
      this.owningMediaPlayer.lock.unlock();
    }
  }
  
  public float getCurrentPitchStepsAdjustment()
  {
    Log.d("AocateServiceBackedMediaPlayer", "getCurrentPitchStepsAdjustment() 240");
    if ((this.pmInterface == null) && (!ConnectPlayMediaService())) {
      error(1, 0);
    }
    this.pmReadLock.lock();
    try
    {
      IPlayMedia_0_8 localIPlayMedia_0_8 = this.pmInterface;
      if (localIPlayMedia_0_8 != null) {
        try
        {
          float f = this.pmInterface.getCurrentPitchStepsAdjustment(this.sessionId);
          return f;
        }
        catch (RemoteException localRemoteException)
        {
          localRemoteException.printStackTrace();
          error(1, 0);
        }
      }
      return 0.0F;
    }
    finally
    {
      this.pmReadLock.unlock();
    }
  }
  
  public int getCurrentPosition()
  {
    if ((this.pmInterface == null) && (!ConnectPlayMediaService())) {
      error(1, 0);
    }
    this.pmReadLock.lock();
    try
    {
      IPlayMedia_0_8 localIPlayMedia_0_8 = this.pmInterface;
      if (localIPlayMedia_0_8 != null) {
        try
        {
          int i = this.pmInterface.getCurrentPosition(this.sessionId);
          return i;
        }
        catch (RemoteException localRemoteException)
        {
          localRemoteException.printStackTrace();
          error(1, 0);
        }
      }
      return 0;
    }
    finally
    {
      this.pmReadLock.unlock();
    }
  }
  
  public float getCurrentSpeedMultiplier()
  {
    Log.d("AocateServiceBackedMediaPlayer", "getCurrentSpeedMultiplier() 286");
    if ((this.pmInterface == null) && (!ConnectPlayMediaService())) {
      error(1, 0);
    }
    this.pmReadLock.lock();
    try
    {
      IPlayMedia_0_8 localIPlayMedia_0_8 = this.pmInterface;
      if (localIPlayMedia_0_8 != null) {
        try
        {
          float f = this.pmInterface.getCurrentSpeedMultiplier(this.sessionId);
          return f;
        }
        catch (RemoteException localRemoteException)
        {
          localRemoteException.printStackTrace();
          error(1, 0);
        }
      }
      return 1.0F;
    }
    finally
    {
      this.pmReadLock.unlock();
    }
  }
  
  public int getDuration()
  {
    Log.d("AocateServiceBackedMediaPlayer", "getDuration() 311");
    if ((this.pmInterface == null) && (!ConnectPlayMediaService())) {
      error(1, 0);
    }
    this.pmReadLock.lock();
    try
    {
      IPlayMedia_0_8 localIPlayMedia_0_8 = this.pmInterface;
      if (localIPlayMedia_0_8 != null) {
        try
        {
          int i = this.pmInterface.getDuration(this.sessionId);
          return i;
        }
        catch (RemoteException localRemoteException)
        {
          localRemoteException.printStackTrace();
          error(1, 0);
        }
      }
      return 0;
    }
    finally
    {
      this.pmReadLock.unlock();
    }
  }
  
  public float getMaxSpeedMultiplier()
  {
    Log.d("AocateServiceBackedMediaPlayer", "getMaxSpeedMultiplier() 332");
    if ((this.pmInterface == null) && (!ConnectPlayMediaService())) {
      error(1, 0);
    }
    this.pmReadLock.lock();
    try
    {
      IPlayMedia_0_8 localIPlayMedia_0_8 = this.pmInterface;
      if (localIPlayMedia_0_8 != null) {
        try
        {
          float f = this.pmInterface.getMaxSpeedMultiplier(this.sessionId);
          return f;
        }
        catch (RemoteException localRemoteException)
        {
          localRemoteException.printStackTrace();
          error(1, 0);
        }
      }
      return 1.0F;
    }
    finally
    {
      this.pmReadLock.unlock();
    }
  }
  
  public float getMinSpeedMultiplier()
  {
    Log.d("AocateServiceBackedMediaPlayer", "getMinSpeedMultiplier() 357");
    if ((this.pmInterface == null) && (!ConnectPlayMediaService())) {
      error(1, 0);
    }
    this.pmReadLock.lock();
    try
    {
      IPlayMedia_0_8 localIPlayMedia_0_8 = this.pmInterface;
      if (localIPlayMedia_0_8 != null) {
        try
        {
          float f = this.pmInterface.getMinSpeedMultiplier(this.sessionId);
          return f;
        }
        catch (RemoteException localRemoteException)
        {
          localRemoteException.printStackTrace();
          error(1, 0);
        }
      }
      return 1.0F;
    }
    finally
    {
      this.pmReadLock.unlock();
    }
  }
  
  public int getServiceVersionCode()
  {
    Log.d("AocateServiceBackedMediaPlayer", "getVersionCode");
    if ((this.pmInterface == null) && (!ConnectPlayMediaService())) {
      error(1, 0);
    }
    this.pmReadLock.lock();
    try
    {
      int i = this.pmInterface.getVersionCode();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
      error(1, 0);
      return 0;
    }
    finally
    {
      this.pmReadLock.unlock();
    }
  }
  
  public String getServiceVersionName()
  {
    Log.d("AocateServiceBackedMediaPlayer", "getVersionName");
    if ((this.pmInterface == null) && (!ConnectPlayMediaService())) {
      error(1, 0);
    }
    this.pmReadLock.lock();
    try
    {
      Object localObject1 = this.pmInterface;
      if (localObject1 != null) {
        try
        {
          localObject1 = this.pmInterface.getVersionName();
          return (String)localObject1;
        }
        catch (RemoteException localRemoteException)
        {
          localRemoteException.printStackTrace();
          error(1, 0);
        }
      }
      return "";
    }
    finally
    {
      this.pmReadLock.unlock();
    }
  }
  
  public boolean isConnected()
  {
    return this.pmInterface != null;
  }
  
  public boolean isLooping()
  {
    Log.d("AocateServiceBackedMediaPlayer", "isLooping() 382");
    if ((this.pmInterface == null) && (!ConnectPlayMediaService())) {
      error(1, 0);
    }
    this.pmReadLock.lock();
    try
    {
      IPlayMedia_0_8 localIPlayMedia_0_8 = this.pmInterface;
      if (localIPlayMedia_0_8 != null) {
        try
        {
          boolean bool = this.pmInterface.isLooping(this.sessionId);
          return bool;
        }
        catch (RemoteException localRemoteException)
        {
          localRemoteException.printStackTrace();
          error(1, 0);
        }
      }
      return false;
    }
    finally
    {
      this.pmReadLock.unlock();
    }
  }
  
  public boolean isPlaying()
  {
    if ((this.pmInterface == null) && (!ConnectPlayMediaService())) {
      error(1, 0);
    }
    this.pmReadLock.lock();
    try
    {
      IPlayMedia_0_8 localIPlayMedia_0_8 = this.pmInterface;
      if (localIPlayMedia_0_8 != null) {
        try
        {
          boolean bool = this.pmInterface.isPlaying(this.sessionId);
          return bool;
        }
        catch (RemoteException localRemoteException)
        {
          localRemoteException.printStackTrace();
          error(1, 0);
        }
      }
      return false;
    }
    finally
    {
      this.pmReadLock.unlock();
    }
  }
  
  /* Error */
  public void pause()
  {
    // Byte code:
    //   0: ldc 31
    //   2: ldc_w 417
    //   5: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   8: pop
    //   9: aload_0
    //   10: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   13: ifnonnull +16 -> 29
    //   16: aload_0
    //   17: invokespecial 144	com/aocate/media/ServiceBackedMediaPlayer:ConnectPlayMediaService	()Z
    //   20: ifne +9 -> 29
    //   23: aload_0
    //   24: iconst_1
    //   25: iconst_0
    //   26: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   29: aload_0
    //   30: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   33: invokevirtual 278	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   36: aload_0
    //   37: getfield 94	com/aocate/media/ServiceBackedMediaPlayer:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   40: ifnull +20 -> 60
    //   43: aload_0
    //   44: getfield 94	com/aocate/media/ServiceBackedMediaPlayer:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   47: invokevirtual 422	android/os/PowerManager$WakeLock:isHeld	()Z
    //   50: ifeq +10 -> 60
    //   53: aload_0
    //   54: getfield 94	com/aocate/media/ServiceBackedMediaPlayer:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   57: invokevirtual 423	android/os/PowerManager$WakeLock:release	()V
    //   60: aload_0
    //   61: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   64: astore_1
    //   65: aload_1
    //   66: ifnull +16 -> 82
    //   69: aload_0
    //   70: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   73: aload_0
    //   74: getfield 81	com/aocate/media/ServiceBackedMediaPlayer:sessionId	J
    //   77: invokeinterface 426 3 0
    //   82: aload_0
    //   83: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   86: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   89: return
    //   90: astore_1
    //   91: aload_1
    //   92: invokevirtual 233	android/os/RemoteException:printStackTrace	()V
    //   95: aload_0
    //   96: iconst_1
    //   97: iconst_0
    //   98: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   101: goto -19 -> 82
    //   104: astore_1
    //   105: aload_0
    //   106: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   109: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   112: aload_1
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	ServiceBackedMediaPlayer
    //   64	2	1	localIPlayMedia_0_8	IPlayMedia_0_8
    //   90	2	1	localRemoteException	RemoteException
    //   104	9	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   69	82	90	android/os/RemoteException
    //   36	60	104	finally
    //   60	65	104	finally
    //   69	82	104	finally
    //   91	101	104	finally
  }
  
  /* Error */
  public void prepare()
    throws java.lang.IllegalStateException, java.io.IOException
  {
    // Byte code:
    //   0: ldc 31
    //   2: ldc_w 433
    //   5: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   8: pop
    //   9: new 301	java/lang/StringBuilder
    //   12: dup
    //   13: ldc_w 435
    //   16: invokespecial 304	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   19: astore_2
    //   20: aload_0
    //   21: getfield 106	com/aocate/media/ServiceBackedMediaPlayer:mOnPreparedCallback	Lcom/aocate/presto/service/IOnPreparedListenerCallback_0_8$Stub;
    //   24: ifnonnull +177 -> 201
    //   27: ldc_w 437
    //   30: astore_1
    //   31: ldc 31
    //   33: aload_2
    //   34: aload_1
    //   35: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   44: pop
    //   45: aload_0
    //   46: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   49: ifnonnull +34 -> 83
    //   52: ldc 31
    //   54: ldc_w 439
    //   57: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   60: pop
    //   61: aload_0
    //   62: invokespecial 144	com/aocate/media/ServiceBackedMediaPlayer:ConnectPlayMediaService	()Z
    //   65: ifne +18 -> 83
    //   68: ldc 31
    //   70: ldc_w 441
    //   73: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   76: pop
    //   77: aload_0
    //   78: iconst_1
    //   79: iconst_0
    //   80: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   83: aload_0
    //   84: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   87: invokevirtual 278	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   90: aload_0
    //   91: getfield 94	com/aocate/media/ServiceBackedMediaPlayer:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   94: ifnull +20 -> 114
    //   97: aload_0
    //   98: getfield 94	com/aocate/media/ServiceBackedMediaPlayer:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   101: invokevirtual 422	android/os/PowerManager$WakeLock:isHeld	()Z
    //   104: ifeq +10 -> 114
    //   107: aload_0
    //   108: getfield 94	com/aocate/media/ServiceBackedMediaPlayer:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   111: invokevirtual 423	android/os/PowerManager$WakeLock:release	()V
    //   114: aload_0
    //   115: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   118: ifnull +66 -> 184
    //   121: ldc 31
    //   123: ldc_w 443
    //   126: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   129: pop
    //   130: ldc 31
    //   132: new 301	java/lang/StringBuilder
    //   135: dup
    //   136: ldc_w 445
    //   139: invokespecial 304	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   142: aload_0
    //   143: getfield 81	com/aocate/media/ServiceBackedMediaPlayer:sessionId	J
    //   146: invokevirtual 448	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   149: ldc_w 315
    //   152: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   161: pop
    //   162: aload_0
    //   163: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   166: aload_0
    //   167: getfield 81	com/aocate/media/ServiceBackedMediaPlayer:sessionId	J
    //   170: invokeinterface 450 3 0
    //   175: ldc 31
    //   177: ldc_w 452
    //   180: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   183: pop
    //   184: aload_0
    //   185: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   188: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   191: ldc 31
    //   193: ldc_w 454
    //   196: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   199: pop
    //   200: return
    //   201: ldc_w 456
    //   204: astore_1
    //   205: goto -174 -> 31
    //   208: astore_1
    //   209: ldc 31
    //   211: ldc_w 458
    //   214: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   217: pop
    //   218: aload_1
    //   219: invokevirtual 233	android/os/RemoteException:printStackTrace	()V
    //   222: aload_0
    //   223: iconst_1
    //   224: iconst_0
    //   225: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   228: goto -44 -> 184
    //   231: astore_1
    //   232: aload_0
    //   233: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   236: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   239: aload_1
    //   240: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	ServiceBackedMediaPlayer
    //   30	175	1	str	String
    //   208	11	1	localRemoteException	RemoteException
    //   231	9	1	localObject	Object
    //   19	15	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   130	184	208	android/os/RemoteException
    //   90	114	231	finally
    //   114	130	231	finally
    //   130	184	231	finally
    //   209	228	231	finally
  }
  
  /* Error */
  public void prepareAsync()
  {
    // Byte code:
    //   0: ldc 31
    //   2: ldc_w 461
    //   5: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   8: pop
    //   9: aload_0
    //   10: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   13: ifnonnull +16 -> 29
    //   16: aload_0
    //   17: invokespecial 144	com/aocate/media/ServiceBackedMediaPlayer:ConnectPlayMediaService	()Z
    //   20: ifne +9 -> 29
    //   23: aload_0
    //   24: iconst_1
    //   25: iconst_0
    //   26: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   29: aload_0
    //   30: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   33: invokevirtual 278	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   36: aload_0
    //   37: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   40: astore_1
    //   41: aload_1
    //   42: ifnull +16 -> 58
    //   45: aload_0
    //   46: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   49: aload_0
    //   50: getfield 81	com/aocate/media/ServiceBackedMediaPlayer:sessionId	J
    //   53: invokeinterface 463 3 0
    //   58: aload_0
    //   59: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   62: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   65: return
    //   66: astore_1
    //   67: aload_1
    //   68: invokevirtual 233	android/os/RemoteException:printStackTrace	()V
    //   71: aload_0
    //   72: iconst_1
    //   73: iconst_0
    //   74: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   77: goto -19 -> 58
    //   80: astore_1
    //   81: aload_0
    //   82: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   85: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	ServiceBackedMediaPlayer
    //   40	2	1	localIPlayMedia_0_8	IPlayMedia_0_8
    //   66	2	1	localRemoteException	RemoteException
    //   80	9	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   45	58	66	android/os/RemoteException
    //   36	41	80	finally
    //   45	58	80	finally
    //   67	77	80	finally
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: ldc 31
    //   2: ldc_w 465
    //   5: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   8: pop
    //   9: aload_0
    //   10: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   13: ifnonnull +16 -> 29
    //   16: aload_0
    //   17: invokespecial 144	com/aocate/media/ServiceBackedMediaPlayer:ConnectPlayMediaService	()Z
    //   20: ifne +9 -> 29
    //   23: aload_0
    //   24: iconst_1
    //   25: iconst_0
    //   26: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   29: aload_0
    //   30: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   33: invokevirtual 278	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   36: aload_0
    //   37: getfield 94	com/aocate/media/ServiceBackedMediaPlayer:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   40: ifnull +20 -> 60
    //   43: aload_0
    //   44: getfield 94	com/aocate/media/ServiceBackedMediaPlayer:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   47: invokevirtual 422	android/os/PowerManager$WakeLock:isHeld	()Z
    //   50: ifeq +10 -> 60
    //   53: aload_0
    //   54: getfield 94	com/aocate/media/ServiceBackedMediaPlayer:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   57: invokevirtual 423	android/os/PowerManager$WakeLock:release	()V
    //   60: aload_0
    //   61: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   64: ifnull +55 -> 119
    //   67: ldc 31
    //   69: ldc_w 467
    //   72: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   75: pop
    //   76: aload_0
    //   77: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   80: aload_0
    //   81: getfield 81	com/aocate/media/ServiceBackedMediaPlayer:sessionId	J
    //   84: invokeinterface 469 3 0
    //   89: aload_0
    //   90: getfield 157	com/aocate/media/ServiceBackedMediaPlayer:mContext	Landroid/content/Context;
    //   93: aload_0
    //   94: getfield 75	com/aocate/media/ServiceBackedMediaPlayer:mPlayMediaServiceConnection	Landroid/content/ServiceConnection;
    //   97: invokevirtual 473	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   100: aload_0
    //   101: aload_0
    //   102: getfield 157	com/aocate/media/ServiceBackedMediaPlayer:mContext	Landroid/content/Context;
    //   105: iconst_0
    //   106: invokevirtual 477	com/aocate/media/ServiceBackedMediaPlayer:setWakeMode	(Landroid/content/Context;I)V
    //   109: aload_0
    //   110: aconst_null
    //   111: putfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   114: aload_0
    //   115: lconst_0
    //   116: putfield 81	com/aocate/media/ServiceBackedMediaPlayer:sessionId	J
    //   119: aload_0
    //   120: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   123: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   126: aload_0
    //   127: getfield 94	com/aocate/media/ServiceBackedMediaPlayer:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   130: ifnull +29 -> 159
    //   133: aload_0
    //   134: getfield 94	com/aocate/media/ServiceBackedMediaPlayer:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   137: invokevirtual 422	android/os/PowerManager$WakeLock:isHeld	()Z
    //   140: ifeq +19 -> 159
    //   143: ldc 31
    //   145: ldc_w 479
    //   148: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   151: pop
    //   152: aload_0
    //   153: getfield 94	com/aocate/media/ServiceBackedMediaPlayer:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   156: invokevirtual 423	android/os/PowerManager$WakeLock:release	()V
    //   159: return
    //   160: astore_1
    //   161: aload_1
    //   162: invokevirtual 233	android/os/RemoteException:printStackTrace	()V
    //   165: aload_0
    //   166: iconst_1
    //   167: iconst_0
    //   168: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   171: goto -82 -> 89
    //   174: astore_1
    //   175: aload_0
    //   176: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   179: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   182: aload_1
    //   183: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	ServiceBackedMediaPlayer
    //   160	2	1	localRemoteException	RemoteException
    //   174	9	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   76	89	160	android/os/RemoteException
    //   36	60	174	finally
    //   60	76	174	finally
    //   76	89	174	finally
    //   89	119	174	finally
    //   161	171	174	finally
  }
  
  /* Error */
  public void reset()
  {
    // Byte code:
    //   0: ldc 31
    //   2: ldc_w 482
    //   5: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   8: pop
    //   9: aload_0
    //   10: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   13: ifnonnull +16 -> 29
    //   16: aload_0
    //   17: invokespecial 144	com/aocate/media/ServiceBackedMediaPlayer:ConnectPlayMediaService	()Z
    //   20: ifne +9 -> 29
    //   23: aload_0
    //   24: iconst_1
    //   25: iconst_0
    //   26: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   29: aload_0
    //   30: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   33: invokevirtual 278	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   36: aload_0
    //   37: getfield 94	com/aocate/media/ServiceBackedMediaPlayer:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   40: ifnull +20 -> 60
    //   43: aload_0
    //   44: getfield 94	com/aocate/media/ServiceBackedMediaPlayer:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   47: invokevirtual 422	android/os/PowerManager$WakeLock:isHeld	()Z
    //   50: ifeq +10 -> 60
    //   53: aload_0
    //   54: getfield 94	com/aocate/media/ServiceBackedMediaPlayer:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   57: invokevirtual 423	android/os/PowerManager$WakeLock:release	()V
    //   60: aload_0
    //   61: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   64: astore_1
    //   65: aload_1
    //   66: ifnull +16 -> 82
    //   69: aload_0
    //   70: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   73: aload_0
    //   74: getfield 81	com/aocate/media/ServiceBackedMediaPlayer:sessionId	J
    //   77: invokeinterface 484 3 0
    //   82: aload_0
    //   83: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   86: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   89: return
    //   90: astore_1
    //   91: aload_1
    //   92: invokevirtual 233	android/os/RemoteException:printStackTrace	()V
    //   95: aload_0
    //   96: iconst_1
    //   97: iconst_0
    //   98: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   101: goto -19 -> 82
    //   104: astore_1
    //   105: aload_0
    //   106: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   109: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   112: aload_1
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	ServiceBackedMediaPlayer
    //   64	2	1	localIPlayMedia_0_8	IPlayMedia_0_8
    //   90	2	1	localRemoteException	RemoteException
    //   104	9	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   69	82	90	android/os/RemoteException
    //   36	60	104	finally
    //   60	65	104	finally
    //   69	82	104	finally
    //   91	101	104	finally
  }
  
  /* Error */
  public void seekTo(int paramInt)
    throws java.lang.IllegalStateException
  {
    // Byte code:
    //   0: ldc 31
    //   2: new 301	java/lang/StringBuilder
    //   5: dup
    //   6: ldc_w 488
    //   9: invokespecial 304	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   12: iload_1
    //   13: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16: ldc_w 315
    //   19: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   28: pop
    //   29: aload_0
    //   30: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   33: ifnonnull +16 -> 49
    //   36: aload_0
    //   37: invokespecial 144	com/aocate/media/ServiceBackedMediaPlayer:ConnectPlayMediaService	()Z
    //   40: ifne +9 -> 49
    //   43: aload_0
    //   44: iconst_1
    //   45: iconst_0
    //   46: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   49: aload_0
    //   50: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   53: invokevirtual 278	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   56: aload_0
    //   57: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   60: astore_2
    //   61: aload_2
    //   62: ifnull +17 -> 79
    //   65: aload_0
    //   66: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   69: aload_0
    //   70: getfield 81	com/aocate/media/ServiceBackedMediaPlayer:sessionId	J
    //   73: iload_1
    //   74: invokeinterface 491 4 0
    //   79: aload_0
    //   80: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   83: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   86: return
    //   87: astore_2
    //   88: aload_2
    //   89: invokevirtual 233	android/os/RemoteException:printStackTrace	()V
    //   92: aload_0
    //   93: iconst_1
    //   94: iconst_0
    //   95: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   98: goto -19 -> 79
    //   101: astore_2
    //   102: aload_0
    //   103: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   106: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   109: aload_2
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	ServiceBackedMediaPlayer
    //   0	111	1	paramInt	int
    //   60	2	2	localIPlayMedia_0_8	IPlayMedia_0_8
    //   87	2	2	localRemoteException	RemoteException
    //   101	9	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   65	79	87	android/os/RemoteException
    //   56	61	101	finally
    //   65	79	101	finally
    //   88	98	101	finally
  }
  
  /* Error */
  public void setAudioStreamType(int paramInt)
  {
    // Byte code:
    //   0: ldc 31
    //   2: new 301	java/lang/StringBuilder
    //   5: dup
    //   6: ldc_w 494
    //   9: invokespecial 304	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   12: iload_1
    //   13: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16: ldc_w 315
    //   19: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   28: pop
    //   29: aload_0
    //   30: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   33: ifnonnull +16 -> 49
    //   36: aload_0
    //   37: invokespecial 144	com/aocate/media/ServiceBackedMediaPlayer:ConnectPlayMediaService	()Z
    //   40: ifne +9 -> 49
    //   43: aload_0
    //   44: iconst_1
    //   45: iconst_0
    //   46: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   49: aload_0
    //   50: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   53: invokevirtual 278	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   56: aload_0
    //   57: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   60: astore_2
    //   61: aload_2
    //   62: ifnull +20 -> 82
    //   65: aload_0
    //   66: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   69: aload_0
    //   70: getfield 81	com/aocate/media/ServiceBackedMediaPlayer:sessionId	J
    //   73: aload_0
    //   74: getfield 85	com/aocate/media/ServiceBackedMediaPlayer:mAudioStreamType	I
    //   77: invokeinterface 496 4 0
    //   82: aload_0
    //   83: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   86: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   89: return
    //   90: astore_2
    //   91: aload_2
    //   92: invokevirtual 233	android/os/RemoteException:printStackTrace	()V
    //   95: aload_0
    //   96: iconst_1
    //   97: iconst_0
    //   98: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   101: goto -19 -> 82
    //   104: astore_2
    //   105: aload_0
    //   106: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   109: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   112: aload_2
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	ServiceBackedMediaPlayer
    //   0	114	1	paramInt	int
    //   60	2	2	localIPlayMedia_0_8	IPlayMedia_0_8
    //   90	2	2	localRemoteException	RemoteException
    //   104	9	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   65	82	90	android/os/RemoteException
    //   56	61	104	finally
    //   65	82	104	finally
    //   91	101	104	finally
  }
  
  /* Error */
  public void setDataSource(Context paramContext, android.net.Uri paramUri)
    throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.io.IOException
  {
    // Byte code:
    //   0: ldc 31
    //   2: ldc_w 502
    //   5: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   8: pop
    //   9: aload_0
    //   10: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   13: ifnonnull +16 -> 29
    //   16: aload_0
    //   17: invokespecial 144	com/aocate/media/ServiceBackedMediaPlayer:ConnectPlayMediaService	()Z
    //   20: ifne +9 -> 29
    //   23: aload_0
    //   24: iconst_1
    //   25: iconst_0
    //   26: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   29: aload_0
    //   30: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   33: invokevirtual 278	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   36: aload_0
    //   37: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   40: astore_1
    //   41: aload_1
    //   42: ifnull +17 -> 59
    //   45: aload_0
    //   46: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   49: aload_0
    //   50: getfield 81	com/aocate/media/ServiceBackedMediaPlayer:sessionId	J
    //   53: aload_2
    //   54: invokeinterface 506 4 0
    //   59: aload_0
    //   60: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   63: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   66: return
    //   67: astore_1
    //   68: aload_1
    //   69: invokevirtual 233	android/os/RemoteException:printStackTrace	()V
    //   72: aload_0
    //   73: iconst_1
    //   74: iconst_0
    //   75: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   78: goto -19 -> 59
    //   81: astore_1
    //   82: aload_0
    //   83: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   86: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	ServiceBackedMediaPlayer
    //   0	91	1	paramContext	Context
    //   0	91	2	paramUri	android.net.Uri
    // Exception table:
    //   from	to	target	type
    //   45	59	67	android/os/RemoteException
    //   36	41	81	finally
    //   45	59	81	finally
    //   68	78	81	finally
  }
  
  /* Error */
  public void setDataSource(String paramString)
    throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.io.IOException
  {
    // Byte code:
    //   0: ldc 31
    //   2: ldc_w 508
    //   5: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   8: pop
    //   9: aload_0
    //   10: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   13: ifnonnull +16 -> 29
    //   16: aload_0
    //   17: invokespecial 144	com/aocate/media/ServiceBackedMediaPlayer:ConnectPlayMediaService	()Z
    //   20: ifne +9 -> 29
    //   23: aload_0
    //   24: iconst_1
    //   25: iconst_0
    //   26: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   29: aload_0
    //   30: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   33: invokevirtual 278	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   36: aload_0
    //   37: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   40: ifnonnull +17 -> 57
    //   43: aload_0
    //   44: iconst_1
    //   45: iconst_0
    //   46: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   49: aload_0
    //   50: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   53: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   56: return
    //   57: aload_0
    //   58: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   61: aload_0
    //   62: getfield 81	com/aocate/media/ServiceBackedMediaPlayer:sessionId	J
    //   65: aload_1
    //   66: invokeinterface 512 4 0
    //   71: goto -22 -> 49
    //   74: astore_1
    //   75: aload_1
    //   76: invokevirtual 233	android/os/RemoteException:printStackTrace	()V
    //   79: aload_0
    //   80: iconst_1
    //   81: iconst_0
    //   82: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   85: goto -36 -> 49
    //   88: astore_1
    //   89: aload_0
    //   90: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   93: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   96: aload_1
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	ServiceBackedMediaPlayer
    //   0	98	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   57	71	74	android/os/RemoteException
    //   36	49	88	finally
    //   57	71	88	finally
    //   75	85	88	finally
  }
  
  /* Error */
  public void setEnableSpeedAdjustment(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 31
    //   2: ldc_w 516
    //   5: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   8: pop
    //   9: aload_0
    //   10: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   13: ifnonnull +16 -> 29
    //   16: aload_0
    //   17: invokespecial 144	com/aocate/media/ServiceBackedMediaPlayer:ConnectPlayMediaService	()Z
    //   20: ifne +9 -> 29
    //   23: aload_0
    //   24: iconst_1
    //   25: iconst_0
    //   26: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   29: aload_0
    //   30: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   33: invokevirtual 278	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   36: aload_0
    //   37: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   40: astore_2
    //   41: aload_2
    //   42: ifnull +17 -> 59
    //   45: aload_0
    //   46: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   49: aload_0
    //   50: getfield 81	com/aocate/media/ServiceBackedMediaPlayer:sessionId	J
    //   53: iload_1
    //   54: invokeinterface 519 4 0
    //   59: aload_0
    //   60: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   63: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   66: return
    //   67: astore_2
    //   68: aload_2
    //   69: invokevirtual 233	android/os/RemoteException:printStackTrace	()V
    //   72: aload_0
    //   73: iconst_1
    //   74: iconst_0
    //   75: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   78: goto -19 -> 59
    //   81: astore_2
    //   82: aload_0
    //   83: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   86: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   89: aload_2
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	ServiceBackedMediaPlayer
    //   0	91	1	paramBoolean	boolean
    //   40	2	2	localIPlayMedia_0_8	IPlayMedia_0_8
    //   67	2	2	localRemoteException	RemoteException
    //   81	9	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   45	59	67	android/os/RemoteException
    //   36	41	81	finally
    //   45	59	81	finally
    //   68	78	81	finally
  }
  
  /* Error */
  public void setLooping(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 31
    //   2: new 301	java/lang/StringBuilder
    //   5: dup
    //   6: ldc_w 522
    //   9: invokespecial 304	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   12: iload_1
    //   13: invokevirtual 525	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   16: ldc_w 315
    //   19: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   28: pop
    //   29: aload_0
    //   30: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   33: ifnonnull +16 -> 49
    //   36: aload_0
    //   37: invokespecial 144	com/aocate/media/ServiceBackedMediaPlayer:ConnectPlayMediaService	()Z
    //   40: ifne +9 -> 49
    //   43: aload_0
    //   44: iconst_1
    //   45: iconst_0
    //   46: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   49: aload_0
    //   50: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   53: invokevirtual 278	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   56: aload_0
    //   57: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   60: astore_2
    //   61: aload_2
    //   62: ifnull +17 -> 79
    //   65: aload_0
    //   66: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   69: aload_0
    //   70: getfield 81	com/aocate/media/ServiceBackedMediaPlayer:sessionId	J
    //   73: iload_1
    //   74: invokeinterface 527 4 0
    //   79: aload_0
    //   80: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   83: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   86: return
    //   87: astore_2
    //   88: aload_2
    //   89: invokevirtual 233	android/os/RemoteException:printStackTrace	()V
    //   92: aload_0
    //   93: iconst_1
    //   94: iconst_0
    //   95: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   98: goto -19 -> 79
    //   101: astore_2
    //   102: aload_0
    //   103: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   106: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   109: aload_2
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	ServiceBackedMediaPlayer
    //   0	111	1	paramBoolean	boolean
    //   60	2	2	localIPlayMedia_0_8	IPlayMedia_0_8
    //   87	2	2	localRemoteException	RemoteException
    //   101	9	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   65	79	87	android/os/RemoteException
    //   56	61	101	finally
    //   65	79	101	finally
    //   88	98	101	finally
  }
  
  /* Error */
  public void setPitchStepsAdjustment(float paramFloat)
  {
    // Byte code:
    //   0: ldc 31
    //   2: new 301	java/lang/StringBuilder
    //   5: dup
    //   6: ldc_w 531
    //   9: invokespecial 304	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   12: fload_1
    //   13: invokevirtual 534	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   16: ldc_w 315
    //   19: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   28: pop
    //   29: aload_0
    //   30: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   33: ifnonnull +16 -> 49
    //   36: aload_0
    //   37: invokespecial 144	com/aocate/media/ServiceBackedMediaPlayer:ConnectPlayMediaService	()Z
    //   40: ifne +9 -> 49
    //   43: aload_0
    //   44: iconst_1
    //   45: iconst_0
    //   46: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   49: aload_0
    //   50: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   53: invokevirtual 278	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   56: aload_0
    //   57: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   60: astore_2
    //   61: aload_2
    //   62: ifnull +17 -> 79
    //   65: aload_0
    //   66: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   69: aload_0
    //   70: getfield 81	com/aocate/media/ServiceBackedMediaPlayer:sessionId	J
    //   73: fload_1
    //   74: invokeinterface 537 4 0
    //   79: aload_0
    //   80: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   83: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   86: return
    //   87: astore_2
    //   88: aload_2
    //   89: invokevirtual 233	android/os/RemoteException:printStackTrace	()V
    //   92: aload_0
    //   93: iconst_1
    //   94: iconst_0
    //   95: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   98: goto -19 -> 79
    //   101: astore_2
    //   102: aload_0
    //   103: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   106: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   109: aload_2
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	ServiceBackedMediaPlayer
    //   0	111	1	paramFloat	float
    //   60	2	2	localIPlayMedia_0_8	IPlayMedia_0_8
    //   87	2	2	localRemoteException	RemoteException
    //   101	9	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   65	79	87	android/os/RemoteException
    //   56	61	101	finally
    //   65	79	101	finally
    //   88	98	101	finally
  }
  
  /* Error */
  public void setPlaybackPitch(float paramFloat)
  {
    // Byte code:
    //   0: ldc 31
    //   2: new 301	java/lang/StringBuilder
    //   5: dup
    //   6: ldc_w 540
    //   9: invokespecial 304	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   12: fload_1
    //   13: invokevirtual 534	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   16: ldc_w 315
    //   19: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   28: pop
    //   29: aload_0
    //   30: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   33: ifnonnull +16 -> 49
    //   36: aload_0
    //   37: invokespecial 144	com/aocate/media/ServiceBackedMediaPlayer:ConnectPlayMediaService	()Z
    //   40: ifne +9 -> 49
    //   43: aload_0
    //   44: iconst_1
    //   45: iconst_0
    //   46: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   49: aload_0
    //   50: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   53: invokevirtual 278	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   56: aload_0
    //   57: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   60: astore_2
    //   61: aload_2
    //   62: ifnull +17 -> 79
    //   65: aload_0
    //   66: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   69: aload_0
    //   70: getfield 81	com/aocate/media/ServiceBackedMediaPlayer:sessionId	J
    //   73: fload_1
    //   74: invokeinterface 542 4 0
    //   79: aload_0
    //   80: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   83: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   86: return
    //   87: astore_2
    //   88: aload_2
    //   89: invokevirtual 233	android/os/RemoteException:printStackTrace	()V
    //   92: aload_0
    //   93: iconst_1
    //   94: iconst_0
    //   95: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   98: goto -19 -> 79
    //   101: astore_2
    //   102: aload_0
    //   103: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   106: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   109: aload_2
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	ServiceBackedMediaPlayer
    //   0	111	1	paramFloat	float
    //   60	2	2	localIPlayMedia_0_8	IPlayMedia_0_8
    //   87	2	2	localRemoteException	RemoteException
    //   101	9	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   65	79	87	android/os/RemoteException
    //   56	61	101	finally
    //   65	79	101	finally
    //   88	98	101	finally
  }
  
  /* Error */
  public void setPlaybackSpeed(float paramFloat)
  {
    // Byte code:
    //   0: ldc 31
    //   2: new 301	java/lang/StringBuilder
    //   5: dup
    //   6: ldc_w 545
    //   9: invokespecial 304	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   12: fload_1
    //   13: invokevirtual 534	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   16: ldc_w 315
    //   19: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   28: pop
    //   29: aload_0
    //   30: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   33: ifnonnull +16 -> 49
    //   36: aload_0
    //   37: invokespecial 144	com/aocate/media/ServiceBackedMediaPlayer:ConnectPlayMediaService	()Z
    //   40: ifne +9 -> 49
    //   43: aload_0
    //   44: iconst_1
    //   45: iconst_0
    //   46: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   49: aload_0
    //   50: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   53: invokevirtual 278	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   56: aload_0
    //   57: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   60: astore_2
    //   61: aload_2
    //   62: ifnull +17 -> 79
    //   65: aload_0
    //   66: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   69: aload_0
    //   70: getfield 81	com/aocate/media/ServiceBackedMediaPlayer:sessionId	J
    //   73: fload_1
    //   74: invokeinterface 547 4 0
    //   79: aload_0
    //   80: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   83: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   86: return
    //   87: astore_2
    //   88: aload_2
    //   89: invokevirtual 233	android/os/RemoteException:printStackTrace	()V
    //   92: aload_0
    //   93: iconst_1
    //   94: iconst_0
    //   95: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   98: goto -19 -> 79
    //   101: astore_2
    //   102: aload_0
    //   103: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   106: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   109: aload_2
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	ServiceBackedMediaPlayer
    //   0	111	1	paramFloat	float
    //   60	2	2	localIPlayMedia_0_8	IPlayMedia_0_8
    //   87	2	2	localRemoteException	RemoteException
    //   101	9	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   65	79	87	android/os/RemoteException
    //   56	61	101	finally
    //   65	79	101	finally
    //   88	98	101	finally
  }
  
  /* Error */
  public void setSpeedAdjustmentAlgorithm(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   4: ifnonnull +16 -> 20
    //   7: aload_0
    //   8: invokespecial 144	com/aocate/media/ServiceBackedMediaPlayer:ConnectPlayMediaService	()Z
    //   11: ifne +9 -> 20
    //   14: aload_0
    //   15: iconst_1
    //   16: iconst_0
    //   17: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   20: aload_0
    //   21: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   24: invokevirtual 278	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   27: aload_0
    //   28: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   31: astore_2
    //   32: aload_2
    //   33: ifnull +17 -> 50
    //   36: aload_0
    //   37: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   40: aload_0
    //   41: getfield 81	com/aocate/media/ServiceBackedMediaPlayer:sessionId	J
    //   44: iload_1
    //   45: invokeinterface 550 4 0
    //   50: aload_0
    //   51: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   54: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   57: return
    //   58: astore_2
    //   59: aload_2
    //   60: invokevirtual 233	android/os/RemoteException:printStackTrace	()V
    //   63: aload_0
    //   64: iconst_1
    //   65: iconst_0
    //   66: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   69: goto -19 -> 50
    //   72: astore_2
    //   73: aload_0
    //   74: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   77: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   80: aload_2
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	ServiceBackedMediaPlayer
    //   0	82	1	paramInt	int
    //   31	2	2	localIPlayMedia_0_8	IPlayMedia_0_8
    //   58	2	2	localRemoteException	RemoteException
    //   72	9	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   36	50	58	android/os/RemoteException
    //   27	32	72	finally
    //   36	50	72	finally
    //   59	69	72	finally
  }
  
  /* Error */
  public void setVolume(float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: ldc 31
    //   2: new 301	java/lang/StringBuilder
    //   5: dup
    //   6: ldc_w 554
    //   9: invokespecial 304	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   12: fload_1
    //   13: invokevirtual 534	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   16: ldc_w 310
    //   19: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: fload_2
    //   23: invokevirtual 534	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   26: ldc_w 315
    //   29: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   38: pop
    //   39: aload_0
    //   40: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   43: ifnonnull +16 -> 59
    //   46: aload_0
    //   47: invokespecial 144	com/aocate/media/ServiceBackedMediaPlayer:ConnectPlayMediaService	()Z
    //   50: ifne +9 -> 59
    //   53: aload_0
    //   54: iconst_1
    //   55: iconst_0
    //   56: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   59: aload_0
    //   60: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   63: invokevirtual 278	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   66: aload_0
    //   67: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   70: astore_3
    //   71: aload_3
    //   72: ifnull +18 -> 90
    //   75: aload_0
    //   76: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   79: aload_0
    //   80: getfield 81	com/aocate/media/ServiceBackedMediaPlayer:sessionId	J
    //   83: fload_1
    //   84: fload_2
    //   85: invokeinterface 557 5 0
    //   90: aload_0
    //   91: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   94: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   97: return
    //   98: astore_3
    //   99: aload_3
    //   100: invokevirtual 233	android/os/RemoteException:printStackTrace	()V
    //   103: aload_0
    //   104: iconst_1
    //   105: iconst_0
    //   106: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   109: goto -19 -> 90
    //   112: astore_3
    //   113: aload_0
    //   114: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   117: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   120: aload_3
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	ServiceBackedMediaPlayer
    //   0	122	1	paramFloat1	float
    //   0	122	2	paramFloat2	float
    //   70	2	3	localIPlayMedia_0_8	IPlayMedia_0_8
    //   98	2	3	localRemoteException	RemoteException
    //   112	9	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   75	90	98	android/os/RemoteException
    //   66	71	112	finally
    //   75	90	112	finally
    //   99	109	112	finally
  }
  
  public void setWakeMode(Context paramContext, int paramInt)
  {
    Log.d("AocateServiceBackedMediaPlayer", "setWakeMode(context, " + paramInt + ")");
    if ((this.mWakeLock != null) && (this.mWakeLock.isHeld())) {
      this.mWakeLock.release();
    }
    this.mWakeMode = paramInt;
    if (paramInt != 0)
    {
      if (this.mWakeLock == null) {
        this.mWakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(paramInt, getClass().getName());
      }
      if (isPlaying()) {
        this.mWakeLock.acquire();
      }
    }
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: ldc 31
    //   2: ldc_w 592
    //   5: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   8: pop
    //   9: aload_0
    //   10: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   13: ifnonnull +16 -> 29
    //   16: aload_0
    //   17: invokespecial 144	com/aocate/media/ServiceBackedMediaPlayer:ConnectPlayMediaService	()Z
    //   20: ifne +9 -> 29
    //   23: aload_0
    //   24: iconst_1
    //   25: iconst_0
    //   26: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   29: aload_0
    //   30: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   33: invokevirtual 278	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   36: aload_0
    //   37: getfield 94	com/aocate/media/ServiceBackedMediaPlayer:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   40: ifnull +34 -> 74
    //   43: aload_0
    //   44: getfield 561	com/aocate/media/ServiceBackedMediaPlayer:mWakeMode	I
    //   47: ifne +57 -> 104
    //   50: aload_0
    //   51: getfield 94	com/aocate/media/ServiceBackedMediaPlayer:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   54: ifnull +20 -> 74
    //   57: aload_0
    //   58: getfield 94	com/aocate/media/ServiceBackedMediaPlayer:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   61: invokevirtual 422	android/os/PowerManager$WakeLock:isHeld	()Z
    //   64: ifeq +10 -> 74
    //   67: aload_0
    //   68: getfield 94	com/aocate/media/ServiceBackedMediaPlayer:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   71: invokevirtual 423	android/os/PowerManager$WakeLock:release	()V
    //   74: aload_0
    //   75: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   78: astore_1
    //   79: aload_1
    //   80: ifnull +16 -> 96
    //   83: aload_0
    //   84: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   87: aload_0
    //   88: getfield 81	com/aocate/media/ServiceBackedMediaPlayer:sessionId	J
    //   91: invokeinterface 594 3 0
    //   96: aload_0
    //   97: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   100: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   103: return
    //   104: aload_0
    //   105: getfield 94	com/aocate/media/ServiceBackedMediaPlayer:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   108: invokevirtual 589	android/os/PowerManager$WakeLock:acquire	()V
    //   111: goto -37 -> 74
    //   114: astore_1
    //   115: aload_0
    //   116: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   119: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   122: aload_1
    //   123: athrow
    //   124: astore_1
    //   125: aload_1
    //   126: invokevirtual 233	android/os/RemoteException:printStackTrace	()V
    //   129: aload_0
    //   130: iconst_1
    //   131: iconst_0
    //   132: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   135: goto -39 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	ServiceBackedMediaPlayer
    //   78	2	1	localIPlayMedia_0_8	IPlayMedia_0_8
    //   114	9	1	localObject	Object
    //   124	2	1	localRemoteException	RemoteException
    // Exception table:
    //   from	to	target	type
    //   36	74	114	finally
    //   74	79	114	finally
    //   83	96	114	finally
    //   104	111	114	finally
    //   125	135	114	finally
    //   83	96	124	android/os/RemoteException
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: ldc 31
    //   2: ldc_w 597
    //   5: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   8: pop
    //   9: aload_0
    //   10: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   13: ifnonnull +16 -> 29
    //   16: aload_0
    //   17: invokespecial 144	com/aocate/media/ServiceBackedMediaPlayer:ConnectPlayMediaService	()Z
    //   20: ifne +9 -> 29
    //   23: aload_0
    //   24: iconst_1
    //   25: iconst_0
    //   26: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   29: aload_0
    //   30: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   33: invokevirtual 278	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   36: aload_0
    //   37: getfield 94	com/aocate/media/ServiceBackedMediaPlayer:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   40: ifnull +20 -> 60
    //   43: aload_0
    //   44: getfield 94	com/aocate/media/ServiceBackedMediaPlayer:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   47: invokevirtual 422	android/os/PowerManager$WakeLock:isHeld	()Z
    //   50: ifeq +10 -> 60
    //   53: aload_0
    //   54: getfield 94	com/aocate/media/ServiceBackedMediaPlayer:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   57: invokevirtual 423	android/os/PowerManager$WakeLock:release	()V
    //   60: aload_0
    //   61: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   64: astore_1
    //   65: aload_1
    //   66: ifnull +16 -> 82
    //   69: aload_0
    //   70: getfield 77	com/aocate/media/ServiceBackedMediaPlayer:pmInterface	Lcom/aocate/presto/service/IPlayMedia_0_8;
    //   73: aload_0
    //   74: getfield 81	com/aocate/media/ServiceBackedMediaPlayer:sessionId	J
    //   77: invokeinterface 599 3 0
    //   82: aload_0
    //   83: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   86: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   89: return
    //   90: astore_1
    //   91: aload_1
    //   92: invokevirtual 233	android/os/RemoteException:printStackTrace	()V
    //   95: aload_0
    //   96: iconst_1
    //   97: iconst_0
    //   98: invokevirtual 148	com/aocate/media/ServiceBackedMediaPlayer:error	(II)V
    //   101: goto -19 -> 82
    //   104: astore_1
    //   105: aload_0
    //   106: getfield 124	com/aocate/media/ServiceBackedMediaPlayer:pmReadLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   109: invokevirtual 284	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   112: aload_1
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	ServiceBackedMediaPlayer
    //   64	2	1	localIPlayMedia_0_8	IPlayMedia_0_8
    //   90	2	1	localRemoteException	RemoteException
    //   104	9	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   69	82	90	android/os/RemoteException
    //   36	60	104	finally
    //   60	65	104	finally
    //   69	82	104	finally
    //   91	101	104	finally
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/aocate/media/ServiceBackedMediaPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */