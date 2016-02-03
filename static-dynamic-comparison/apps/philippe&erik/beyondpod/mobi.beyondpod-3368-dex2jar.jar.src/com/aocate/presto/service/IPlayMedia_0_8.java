package com.aocate.presto.service;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface IPlayMedia_0_8
  extends IInterface
{
  public abstract boolean canSetPitch(long paramLong)
    throws RemoteException;
  
  public abstract boolean canSetSpeed(long paramLong)
    throws RemoteException;
  
  public abstract float getCurrentPitchStepsAdjustment(long paramLong)
    throws RemoteException;
  
  public abstract int getCurrentPosition(long paramLong)
    throws RemoteException;
  
  public abstract float getCurrentSpeedMultiplier(long paramLong)
    throws RemoteException;
  
  public abstract int getDuration(long paramLong)
    throws RemoteException;
  
  public abstract float getMaxSpeedMultiplier(long paramLong)
    throws RemoteException;
  
  public abstract float getMinSpeedMultiplier(long paramLong)
    throws RemoteException;
  
  public abstract int getVersionCode()
    throws RemoteException;
  
  public abstract String getVersionName()
    throws RemoteException;
  
  public abstract boolean isLooping(long paramLong)
    throws RemoteException;
  
  public abstract boolean isPlaying(long paramLong)
    throws RemoteException;
  
  public abstract void pause(long paramLong)
    throws RemoteException;
  
  public abstract void prepare(long paramLong)
    throws RemoteException;
  
  public abstract void prepareAsync(long paramLong)
    throws RemoteException;
  
  public abstract void registerOnBufferingUpdateCallback(long paramLong, IOnBufferingUpdateListenerCallback_0_8 paramIOnBufferingUpdateListenerCallback_0_8)
    throws RemoteException;
  
  public abstract void registerOnCompletionCallback(long paramLong, IOnCompletionListenerCallback_0_8 paramIOnCompletionListenerCallback_0_8)
    throws RemoteException;
  
  public abstract void registerOnErrorCallback(long paramLong, IOnErrorListenerCallback_0_8 paramIOnErrorListenerCallback_0_8)
    throws RemoteException;
  
  public abstract void registerOnInfoCallback(long paramLong, IOnInfoListenerCallback_0_8 paramIOnInfoListenerCallback_0_8)
    throws RemoteException;
  
  public abstract void registerOnPitchAdjustmentAvailableChangedCallback(long paramLong, IOnPitchAdjustmentAvailableChangedListenerCallback_0_8 paramIOnPitchAdjustmentAvailableChangedListenerCallback_0_8)
    throws RemoteException;
  
  public abstract void registerOnPreparedCallback(long paramLong, IOnPreparedListenerCallback_0_8 paramIOnPreparedListenerCallback_0_8)
    throws RemoteException;
  
  public abstract void registerOnSeekCompleteCallback(long paramLong, IOnSeekCompleteListenerCallback_0_8 paramIOnSeekCompleteListenerCallback_0_8)
    throws RemoteException;
  
  public abstract void registerOnSpeedAdjustmentAvailableChangedCallback(long paramLong, IOnSpeedAdjustmentAvailableChangedListenerCallback_0_8 paramIOnSpeedAdjustmentAvailableChangedListenerCallback_0_8)
    throws RemoteException;
  
  public abstract void release(long paramLong)
    throws RemoteException;
  
  public abstract void reset(long paramLong)
    throws RemoteException;
  
  public abstract void seekTo(long paramLong, int paramInt)
    throws RemoteException;
  
  public abstract void setAudioStreamType(long paramLong, int paramInt)
    throws RemoteException;
  
  public abstract void setDataSourceString(long paramLong, String paramString)
    throws RemoteException;
  
  public abstract void setDataSourceUri(long paramLong, Uri paramUri)
    throws RemoteException;
  
  public abstract void setEnableSpeedAdjustment(long paramLong, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setLooping(long paramLong, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setPitchStepsAdjustment(long paramLong, float paramFloat)
    throws RemoteException;
  
  public abstract void setPlaybackPitch(long paramLong, float paramFloat)
    throws RemoteException;
  
  public abstract void setPlaybackSpeed(long paramLong, float paramFloat)
    throws RemoteException;
  
  public abstract void setSpeedAdjustmentAlgorithm(long paramLong, int paramInt)
    throws RemoteException;
  
  public abstract void setVolume(long paramLong, float paramFloat1, float paramFloat2)
    throws RemoteException;
  
  public abstract void start(long paramLong)
    throws RemoteException;
  
  public abstract long startSession(IDeathCallback_0_8 paramIDeathCallback_0_8)
    throws RemoteException;
  
  public abstract void stop(long paramLong)
    throws RemoteException;
  
  public abstract void unregisterOnBufferingUpdateCallback(long paramLong, IOnBufferingUpdateListenerCallback_0_8 paramIOnBufferingUpdateListenerCallback_0_8)
    throws RemoteException;
  
  public abstract void unregisterOnCompletionCallback(long paramLong, IOnCompletionListenerCallback_0_8 paramIOnCompletionListenerCallback_0_8)
    throws RemoteException;
  
  public abstract void unregisterOnErrorCallback(long paramLong, IOnErrorListenerCallback_0_8 paramIOnErrorListenerCallback_0_8)
    throws RemoteException;
  
  public abstract void unregisterOnInfoCallback(long paramLong, IOnInfoListenerCallback_0_8 paramIOnInfoListenerCallback_0_8)
    throws RemoteException;
  
  public abstract void unregisterOnPitchAdjustmentAvailableChangedCallback(long paramLong, IOnPitchAdjustmentAvailableChangedListenerCallback_0_8 paramIOnPitchAdjustmentAvailableChangedListenerCallback_0_8)
    throws RemoteException;
  
  public abstract void unregisterOnPreparedCallback(long paramLong, IOnPreparedListenerCallback_0_8 paramIOnPreparedListenerCallback_0_8)
    throws RemoteException;
  
  public abstract void unregisterOnSeekCompleteCallback(long paramLong, IOnSeekCompleteListenerCallback_0_8 paramIOnSeekCompleteListenerCallback_0_8)
    throws RemoteException;
  
  public abstract void unregisterOnSpeedAdjustmentAvailableChangedCallback(long paramLong, IOnSpeedAdjustmentAvailableChangedListenerCallback_0_8 paramIOnSpeedAdjustmentAvailableChangedListenerCallback_0_8)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IPlayMedia_0_8
  {
    private static final String DESCRIPTOR = "com.aocate.presto.service.IPlayMedia_0_8";
    static final int TRANSACTION_canSetPitch = 1;
    static final int TRANSACTION_canSetSpeed = 2;
    static final int TRANSACTION_getCurrentPitchStepsAdjustment = 3;
    static final int TRANSACTION_getCurrentPosition = 4;
    static final int TRANSACTION_getCurrentSpeedMultiplier = 5;
    static final int TRANSACTION_getDuration = 6;
    static final int TRANSACTION_getMaxSpeedMultiplier = 7;
    static final int TRANSACTION_getMinSpeedMultiplier = 8;
    static final int TRANSACTION_getVersionCode = 9;
    static final int TRANSACTION_getVersionName = 10;
    static final int TRANSACTION_isLooping = 11;
    static final int TRANSACTION_isPlaying = 12;
    static final int TRANSACTION_pause = 13;
    static final int TRANSACTION_prepare = 14;
    static final int TRANSACTION_prepareAsync = 15;
    static final int TRANSACTION_registerOnBufferingUpdateCallback = 16;
    static final int TRANSACTION_registerOnCompletionCallback = 17;
    static final int TRANSACTION_registerOnErrorCallback = 18;
    static final int TRANSACTION_registerOnInfoCallback = 19;
    static final int TRANSACTION_registerOnPitchAdjustmentAvailableChangedCallback = 20;
    static final int TRANSACTION_registerOnPreparedCallback = 21;
    static final int TRANSACTION_registerOnSeekCompleteCallback = 22;
    static final int TRANSACTION_registerOnSpeedAdjustmentAvailableChangedCallback = 23;
    static final int TRANSACTION_release = 24;
    static final int TRANSACTION_reset = 25;
    static final int TRANSACTION_seekTo = 26;
    static final int TRANSACTION_setAudioStreamType = 27;
    static final int TRANSACTION_setDataSourceString = 28;
    static final int TRANSACTION_setDataSourceUri = 29;
    static final int TRANSACTION_setEnableSpeedAdjustment = 30;
    static final int TRANSACTION_setLooping = 31;
    static final int TRANSACTION_setPitchStepsAdjustment = 32;
    static final int TRANSACTION_setPlaybackPitch = 33;
    static final int TRANSACTION_setPlaybackSpeed = 34;
    static final int TRANSACTION_setSpeedAdjustmentAlgorithm = 35;
    static final int TRANSACTION_setVolume = 36;
    static final int TRANSACTION_start = 37;
    static final int TRANSACTION_startSession = 38;
    static final int TRANSACTION_stop = 39;
    static final int TRANSACTION_unregisterOnBufferingUpdateCallback = 40;
    static final int TRANSACTION_unregisterOnCompletionCallback = 41;
    static final int TRANSACTION_unregisterOnErrorCallback = 42;
    static final int TRANSACTION_unregisterOnInfoCallback = 43;
    static final int TRANSACTION_unregisterOnPitchAdjustmentAvailableChangedCallback = 44;
    static final int TRANSACTION_unregisterOnPreparedCallback = 45;
    static final int TRANSACTION_unregisterOnSeekCompleteCallback = 46;
    static final int TRANSACTION_unregisterOnSpeedAdjustmentAvailableChangedCallback = 47;
    
    public Stub()
    {
      attachInterface(this, "com.aocate.presto.service.IPlayMedia_0_8");
    }
    
    public static IPlayMedia_0_8 asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.aocate.presto.service.IPlayMedia_0_8");
      if ((localIInterface != null) && ((localIInterface instanceof IPlayMedia_0_8))) {
        return (IPlayMedia_0_8)localIInterface;
      }
      return new Proxy(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      int j = 0;
      int k = 0;
      int m = 0;
      int i = 0;
      boolean bool;
      float f;
      long l;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.aocate.presto.service.IPlayMedia_0_8");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        bool = canSetPitch(paramParcel1.readLong());
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        bool = canSetSpeed(paramParcel1.readLong());
        paramParcel2.writeNoException();
        paramInt1 = j;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        f = getCurrentPitchStepsAdjustment(paramParcel1.readLong());
        paramParcel2.writeNoException();
        paramParcel2.writeFloat(f);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        paramInt1 = getCurrentPosition(paramParcel1.readLong());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        f = getCurrentSpeedMultiplier(paramParcel1.readLong());
        paramParcel2.writeNoException();
        paramParcel2.writeFloat(f);
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        paramInt1 = getDuration(paramParcel1.readLong());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        f = getMaxSpeedMultiplier(paramParcel1.readLong());
        paramParcel2.writeNoException();
        paramParcel2.writeFloat(f);
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        f = getMinSpeedMultiplier(paramParcel1.readLong());
        paramParcel2.writeNoException();
        paramParcel2.writeFloat(f);
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        paramInt1 = getVersionCode();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        paramParcel1 = getVersionName();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        bool = isLooping(paramParcel1.readLong());
        paramParcel2.writeNoException();
        paramInt1 = k;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        bool = isPlaying(paramParcel1.readLong());
        paramParcel2.writeNoException();
        paramInt1 = m;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        pause(paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 14: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        prepare(paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        prepareAsync(paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        registerOnBufferingUpdateCallback(paramParcel1.readLong(), IOnBufferingUpdateListenerCallback_0_8.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 17: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        registerOnCompletionCallback(paramParcel1.readLong(), IOnCompletionListenerCallback_0_8.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 18: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        registerOnErrorCallback(paramParcel1.readLong(), IOnErrorListenerCallback_0_8.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 19: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        registerOnInfoCallback(paramParcel1.readLong(), IOnInfoListenerCallback_0_8.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 20: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        registerOnPitchAdjustmentAvailableChangedCallback(paramParcel1.readLong(), IOnPitchAdjustmentAvailableChangedListenerCallback_0_8.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 21: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        registerOnPreparedCallback(paramParcel1.readLong(), IOnPreparedListenerCallback_0_8.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 22: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        registerOnSeekCompleteCallback(paramParcel1.readLong(), IOnSeekCompleteListenerCallback_0_8.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 23: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        registerOnSpeedAdjustmentAvailableChangedCallback(paramParcel1.readLong(), IOnSpeedAdjustmentAvailableChangedListenerCallback_0_8.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 24: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        release(paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 25: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        reset(paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 26: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        seekTo(paramParcel1.readLong(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 27: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        setAudioStreamType(paramParcel1.readLong(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 28: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        setDataSourceString(paramParcel1.readLong(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 29: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        l = paramParcel1.readLong();
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          setDataSourceUri(l, paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 30: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        l = paramParcel1.readLong();
        if (paramParcel1.readInt() != 0) {}
        for (bool = true;; bool = false)
        {
          setEnableSpeedAdjustment(l, bool);
          paramParcel2.writeNoException();
          return true;
        }
      case 31: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        l = paramParcel1.readLong();
        if (paramParcel1.readInt() != 0) {}
        for (bool = true;; bool = false)
        {
          setLooping(l, bool);
          paramParcel2.writeNoException();
          return true;
        }
      case 32: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        setPitchStepsAdjustment(paramParcel1.readLong(), paramParcel1.readFloat());
        paramParcel2.writeNoException();
        return true;
      case 33: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        setPlaybackPitch(paramParcel1.readLong(), paramParcel1.readFloat());
        paramParcel2.writeNoException();
        return true;
      case 34: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        setPlaybackSpeed(paramParcel1.readLong(), paramParcel1.readFloat());
        paramParcel2.writeNoException();
        return true;
      case 35: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        setSpeedAdjustmentAlgorithm(paramParcel1.readLong(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 36: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        setVolume(paramParcel1.readLong(), paramParcel1.readFloat(), paramParcel1.readFloat());
        paramParcel2.writeNoException();
        return true;
      case 37: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        start(paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 38: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        l = startSession(IDeathCallback_0_8.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeLong(l);
        return true;
      case 39: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        stop(paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 40: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        unregisterOnBufferingUpdateCallback(paramParcel1.readLong(), IOnBufferingUpdateListenerCallback_0_8.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 41: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        unregisterOnCompletionCallback(paramParcel1.readLong(), IOnCompletionListenerCallback_0_8.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 42: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        unregisterOnErrorCallback(paramParcel1.readLong(), IOnErrorListenerCallback_0_8.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 43: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        unregisterOnInfoCallback(paramParcel1.readLong(), IOnInfoListenerCallback_0_8.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 44: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        unregisterOnPitchAdjustmentAvailableChangedCallback(paramParcel1.readLong(), IOnPitchAdjustmentAvailableChangedListenerCallback_0_8.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 45: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        unregisterOnPreparedCallback(paramParcel1.readLong(), IOnPreparedListenerCallback_0_8.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 46: 
        paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
        unregisterOnSeekCompleteCallback(paramParcel1.readLong(), IOnSeekCompleteListenerCallback_0_8.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.aocate.presto.service.IPlayMedia_0_8");
      unregisterOnSpeedAdjustmentAvailableChangedCallback(paramParcel1.readLong(), IOnSpeedAdjustmentAvailableChangedListenerCallback_0_8.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
    
    private static class Proxy
      implements IPlayMedia_0_8
    {
      private IBinder mRemote;
      
      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      /* Error */
      public boolean canSetPitch(long paramLong)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 4
        //   3: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 6
        //   13: aload 5
        //   15: ldc 34
        //   17: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload 5
        //   22: lload_1
        //   23: invokevirtual 42	android/os/Parcel:writeLong	(J)V
        //   26: aload_0
        //   27: getfield 19	com/aocate/presto/service/IPlayMedia_0_8$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   30: iconst_1
        //   31: aload 5
        //   33: aload 6
        //   35: iconst_0
        //   36: invokeinterface 48 5 0
        //   41: pop
        //   42: aload 6
        //   44: invokevirtual 51	android/os/Parcel:readException	()V
        //   47: aload 6
        //   49: invokevirtual 55	android/os/Parcel:readInt	()I
        //   52: istore_3
        //   53: iload_3
        //   54: ifeq +16 -> 70
        //   57: aload 6
        //   59: invokevirtual 58	android/os/Parcel:recycle	()V
        //   62: aload 5
        //   64: invokevirtual 58	android/os/Parcel:recycle	()V
        //   67: iload 4
        //   69: ireturn
        //   70: iconst_0
        //   71: istore 4
        //   73: goto -16 -> 57
        //   76: astore 7
        //   78: aload 6
        //   80: invokevirtual 58	android/os/Parcel:recycle	()V
        //   83: aload 5
        //   85: invokevirtual 58	android/os/Parcel:recycle	()V
        //   88: aload 7
        //   90: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	91	0	this	Proxy
        //   0	91	1	paramLong	long
        //   52	2	3	i	int
        //   1	71	4	bool	boolean
        //   6	78	5	localParcel1	Parcel
        //   11	68	6	localParcel2	Parcel
        //   76	13	7	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   13	53	76	finally
      }
      
      public boolean canSetSpeed(long paramLong)
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.aocate.presto.service.IPlayMedia_0_8");
          localParcel1.writeLong(paramLong);
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public float getCurrentPitchStepsAdjustment(long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.aocate.presto.service.IPlayMedia_0_8");
          localParcel1.writeLong(paramLong);
          this.mRemote.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          float f = localParcel2.readFloat();
          return f;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int getCurrentPosition(long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.aocate.presto.service.IPlayMedia_0_8");
          localParcel1.writeLong(paramLong);
          this.mRemote.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public float getCurrentSpeedMultiplier(long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.aocate.presto.service.IPlayMedia_0_8");
          localParcel1.writeLong(paramLong);
          this.mRemote.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          float f = localParcel2.readFloat();
          return f;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int getDuration(long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.aocate.presto.service.IPlayMedia_0_8");
          localParcel1.writeLong(paramLong);
          this.mRemote.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public String getInterfaceDescriptor()
      {
        return "com.aocate.presto.service.IPlayMedia_0_8";
      }
      
      public float getMaxSpeedMultiplier(long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.aocate.presto.service.IPlayMedia_0_8");
          localParcel1.writeLong(paramLong);
          this.mRemote.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          float f = localParcel2.readFloat();
          return f;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public float getMinSpeedMultiplier(long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.aocate.presto.service.IPlayMedia_0_8");
          localParcel1.writeLong(paramLong);
          this.mRemote.transact(8, localParcel1, localParcel2, 0);
          localParcel2.readException();
          float f = localParcel2.readFloat();
          return f;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int getVersionCode()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.aocate.presto.service.IPlayMedia_0_8");
          this.mRemote.transact(9, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public String getVersionName()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.aocate.presto.service.IPlayMedia_0_8");
          this.mRemote.transact(10, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean isLooping(long paramLong)
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.aocate.presto.service.IPlayMedia_0_8");
          localParcel1.writeLong(paramLong);
          this.mRemote.transact(11, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean isPlaying(long paramLong)
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.aocate.presto.service.IPlayMedia_0_8");
          localParcel1.writeLong(paramLong);
          this.mRemote.transact(12, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void pause(long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.aocate.presto.service.IPlayMedia_0_8");
          localParcel1.writeLong(paramLong);
          this.mRemote.transact(13, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void prepare(long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.aocate.presto.service.IPlayMedia_0_8");
          localParcel1.writeLong(paramLong);
          this.mRemote.transact(14, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void prepareAsync(long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.aocate.presto.service.IPlayMedia_0_8");
          localParcel1.writeLong(paramLong);
          this.mRemote.transact(15, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public void registerOnBufferingUpdateCallback(long paramLong, IOnBufferingUpdateListenerCallback_0_8 paramIOnBufferingUpdateListenerCallback_0_8)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 34
        //   14: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 4
        //   19: lload_1
        //   20: invokevirtual 42	android/os/Parcel:writeLong	(J)V
        //   23: aload_3
        //   24: ifnull +49 -> 73
        //   27: aload_3
        //   28: invokeinterface 90 1 0
        //   33: astore_3
        //   34: aload 4
        //   36: aload_3
        //   37: invokevirtual 93	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   40: aload_0
        //   41: getfield 19	com/aocate/presto/service/IPlayMedia_0_8$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   44: bipush 16
        //   46: aload 4
        //   48: aload 5
        //   50: iconst_0
        //   51: invokeinterface 48 5 0
        //   56: pop
        //   57: aload 5
        //   59: invokevirtual 51	android/os/Parcel:readException	()V
        //   62: aload 5
        //   64: invokevirtual 58	android/os/Parcel:recycle	()V
        //   67: aload 4
        //   69: invokevirtual 58	android/os/Parcel:recycle	()V
        //   72: return
        //   73: aconst_null
        //   74: astore_3
        //   75: goto -41 -> 34
        //   78: astore_3
        //   79: aload 5
        //   81: invokevirtual 58	android/os/Parcel:recycle	()V
        //   84: aload 4
        //   86: invokevirtual 58	android/os/Parcel:recycle	()V
        //   89: aload_3
        //   90: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	91	0	this	Proxy
        //   0	91	1	paramLong	long
        //   0	91	3	paramIOnBufferingUpdateListenerCallback_0_8	IOnBufferingUpdateListenerCallback_0_8
        //   3	82	4	localParcel1	Parcel
        //   8	72	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	23	78	finally
        //   27	34	78	finally
        //   34	62	78	finally
      }
      
      /* Error */
      public void registerOnCompletionCallback(long paramLong, IOnCompletionListenerCallback_0_8 paramIOnCompletionListenerCallback_0_8)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 34
        //   14: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 4
        //   19: lload_1
        //   20: invokevirtual 42	android/os/Parcel:writeLong	(J)V
        //   23: aload_3
        //   24: ifnull +49 -> 73
        //   27: aload_3
        //   28: invokeinterface 98 1 0
        //   33: astore_3
        //   34: aload 4
        //   36: aload_3
        //   37: invokevirtual 93	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   40: aload_0
        //   41: getfield 19	com/aocate/presto/service/IPlayMedia_0_8$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   44: bipush 17
        //   46: aload 4
        //   48: aload 5
        //   50: iconst_0
        //   51: invokeinterface 48 5 0
        //   56: pop
        //   57: aload 5
        //   59: invokevirtual 51	android/os/Parcel:readException	()V
        //   62: aload 5
        //   64: invokevirtual 58	android/os/Parcel:recycle	()V
        //   67: aload 4
        //   69: invokevirtual 58	android/os/Parcel:recycle	()V
        //   72: return
        //   73: aconst_null
        //   74: astore_3
        //   75: goto -41 -> 34
        //   78: astore_3
        //   79: aload 5
        //   81: invokevirtual 58	android/os/Parcel:recycle	()V
        //   84: aload 4
        //   86: invokevirtual 58	android/os/Parcel:recycle	()V
        //   89: aload_3
        //   90: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	91	0	this	Proxy
        //   0	91	1	paramLong	long
        //   0	91	3	paramIOnCompletionListenerCallback_0_8	IOnCompletionListenerCallback_0_8
        //   3	82	4	localParcel1	Parcel
        //   8	72	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	23	78	finally
        //   27	34	78	finally
        //   34	62	78	finally
      }
      
      /* Error */
      public void registerOnErrorCallback(long paramLong, IOnErrorListenerCallback_0_8 paramIOnErrorListenerCallback_0_8)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 34
        //   14: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 4
        //   19: lload_1
        //   20: invokevirtual 42	android/os/Parcel:writeLong	(J)V
        //   23: aload_3
        //   24: ifnull +49 -> 73
        //   27: aload_3
        //   28: invokeinterface 103 1 0
        //   33: astore_3
        //   34: aload 4
        //   36: aload_3
        //   37: invokevirtual 93	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   40: aload_0
        //   41: getfield 19	com/aocate/presto/service/IPlayMedia_0_8$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   44: bipush 18
        //   46: aload 4
        //   48: aload 5
        //   50: iconst_0
        //   51: invokeinterface 48 5 0
        //   56: pop
        //   57: aload 5
        //   59: invokevirtual 51	android/os/Parcel:readException	()V
        //   62: aload 5
        //   64: invokevirtual 58	android/os/Parcel:recycle	()V
        //   67: aload 4
        //   69: invokevirtual 58	android/os/Parcel:recycle	()V
        //   72: return
        //   73: aconst_null
        //   74: astore_3
        //   75: goto -41 -> 34
        //   78: astore_3
        //   79: aload 5
        //   81: invokevirtual 58	android/os/Parcel:recycle	()V
        //   84: aload 4
        //   86: invokevirtual 58	android/os/Parcel:recycle	()V
        //   89: aload_3
        //   90: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	91	0	this	Proxy
        //   0	91	1	paramLong	long
        //   0	91	3	paramIOnErrorListenerCallback_0_8	IOnErrorListenerCallback_0_8
        //   3	82	4	localParcel1	Parcel
        //   8	72	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	23	78	finally
        //   27	34	78	finally
        //   34	62	78	finally
      }
      
      /* Error */
      public void registerOnInfoCallback(long paramLong, IOnInfoListenerCallback_0_8 paramIOnInfoListenerCallback_0_8)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 34
        //   14: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 4
        //   19: lload_1
        //   20: invokevirtual 42	android/os/Parcel:writeLong	(J)V
        //   23: aload_3
        //   24: ifnull +49 -> 73
        //   27: aload_3
        //   28: invokeinterface 108 1 0
        //   33: astore_3
        //   34: aload 4
        //   36: aload_3
        //   37: invokevirtual 93	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   40: aload_0
        //   41: getfield 19	com/aocate/presto/service/IPlayMedia_0_8$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   44: bipush 19
        //   46: aload 4
        //   48: aload 5
        //   50: iconst_0
        //   51: invokeinterface 48 5 0
        //   56: pop
        //   57: aload 5
        //   59: invokevirtual 51	android/os/Parcel:readException	()V
        //   62: aload 5
        //   64: invokevirtual 58	android/os/Parcel:recycle	()V
        //   67: aload 4
        //   69: invokevirtual 58	android/os/Parcel:recycle	()V
        //   72: return
        //   73: aconst_null
        //   74: astore_3
        //   75: goto -41 -> 34
        //   78: astore_3
        //   79: aload 5
        //   81: invokevirtual 58	android/os/Parcel:recycle	()V
        //   84: aload 4
        //   86: invokevirtual 58	android/os/Parcel:recycle	()V
        //   89: aload_3
        //   90: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	91	0	this	Proxy
        //   0	91	1	paramLong	long
        //   0	91	3	paramIOnInfoListenerCallback_0_8	IOnInfoListenerCallback_0_8
        //   3	82	4	localParcel1	Parcel
        //   8	72	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	23	78	finally
        //   27	34	78	finally
        //   34	62	78	finally
      }
      
      /* Error */
      public void registerOnPitchAdjustmentAvailableChangedCallback(long paramLong, IOnPitchAdjustmentAvailableChangedListenerCallback_0_8 paramIOnPitchAdjustmentAvailableChangedListenerCallback_0_8)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 34
        //   14: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 4
        //   19: lload_1
        //   20: invokevirtual 42	android/os/Parcel:writeLong	(J)V
        //   23: aload_3
        //   24: ifnull +49 -> 73
        //   27: aload_3
        //   28: invokeinterface 113 1 0
        //   33: astore_3
        //   34: aload 4
        //   36: aload_3
        //   37: invokevirtual 93	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   40: aload_0
        //   41: getfield 19	com/aocate/presto/service/IPlayMedia_0_8$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   44: bipush 20
        //   46: aload 4
        //   48: aload 5
        //   50: iconst_0
        //   51: invokeinterface 48 5 0
        //   56: pop
        //   57: aload 5
        //   59: invokevirtual 51	android/os/Parcel:readException	()V
        //   62: aload 5
        //   64: invokevirtual 58	android/os/Parcel:recycle	()V
        //   67: aload 4
        //   69: invokevirtual 58	android/os/Parcel:recycle	()V
        //   72: return
        //   73: aconst_null
        //   74: astore_3
        //   75: goto -41 -> 34
        //   78: astore_3
        //   79: aload 5
        //   81: invokevirtual 58	android/os/Parcel:recycle	()V
        //   84: aload 4
        //   86: invokevirtual 58	android/os/Parcel:recycle	()V
        //   89: aload_3
        //   90: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	91	0	this	Proxy
        //   0	91	1	paramLong	long
        //   0	91	3	paramIOnPitchAdjustmentAvailableChangedListenerCallback_0_8	IOnPitchAdjustmentAvailableChangedListenerCallback_0_8
        //   3	82	4	localParcel1	Parcel
        //   8	72	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	23	78	finally
        //   27	34	78	finally
        //   34	62	78	finally
      }
      
      /* Error */
      public void registerOnPreparedCallback(long paramLong, IOnPreparedListenerCallback_0_8 paramIOnPreparedListenerCallback_0_8)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 34
        //   14: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 4
        //   19: lload_1
        //   20: invokevirtual 42	android/os/Parcel:writeLong	(J)V
        //   23: aload_3
        //   24: ifnull +49 -> 73
        //   27: aload_3
        //   28: invokeinterface 118 1 0
        //   33: astore_3
        //   34: aload 4
        //   36: aload_3
        //   37: invokevirtual 93	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   40: aload_0
        //   41: getfield 19	com/aocate/presto/service/IPlayMedia_0_8$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   44: bipush 21
        //   46: aload 4
        //   48: aload 5
        //   50: iconst_0
        //   51: invokeinterface 48 5 0
        //   56: pop
        //   57: aload 5
        //   59: invokevirtual 51	android/os/Parcel:readException	()V
        //   62: aload 5
        //   64: invokevirtual 58	android/os/Parcel:recycle	()V
        //   67: aload 4
        //   69: invokevirtual 58	android/os/Parcel:recycle	()V
        //   72: return
        //   73: aconst_null
        //   74: astore_3
        //   75: goto -41 -> 34
        //   78: astore_3
        //   79: aload 5
        //   81: invokevirtual 58	android/os/Parcel:recycle	()V
        //   84: aload 4
        //   86: invokevirtual 58	android/os/Parcel:recycle	()V
        //   89: aload_3
        //   90: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	91	0	this	Proxy
        //   0	91	1	paramLong	long
        //   0	91	3	paramIOnPreparedListenerCallback_0_8	IOnPreparedListenerCallback_0_8
        //   3	82	4	localParcel1	Parcel
        //   8	72	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	23	78	finally
        //   27	34	78	finally
        //   34	62	78	finally
      }
      
      /* Error */
      public void registerOnSeekCompleteCallback(long paramLong, IOnSeekCompleteListenerCallback_0_8 paramIOnSeekCompleteListenerCallback_0_8)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 34
        //   14: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 4
        //   19: lload_1
        //   20: invokevirtual 42	android/os/Parcel:writeLong	(J)V
        //   23: aload_3
        //   24: ifnull +49 -> 73
        //   27: aload_3
        //   28: invokeinterface 123 1 0
        //   33: astore_3
        //   34: aload 4
        //   36: aload_3
        //   37: invokevirtual 93	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   40: aload_0
        //   41: getfield 19	com/aocate/presto/service/IPlayMedia_0_8$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   44: bipush 22
        //   46: aload 4
        //   48: aload 5
        //   50: iconst_0
        //   51: invokeinterface 48 5 0
        //   56: pop
        //   57: aload 5
        //   59: invokevirtual 51	android/os/Parcel:readException	()V
        //   62: aload 5
        //   64: invokevirtual 58	android/os/Parcel:recycle	()V
        //   67: aload 4
        //   69: invokevirtual 58	android/os/Parcel:recycle	()V
        //   72: return
        //   73: aconst_null
        //   74: astore_3
        //   75: goto -41 -> 34
        //   78: astore_3
        //   79: aload 5
        //   81: invokevirtual 58	android/os/Parcel:recycle	()V
        //   84: aload 4
        //   86: invokevirtual 58	android/os/Parcel:recycle	()V
        //   89: aload_3
        //   90: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	91	0	this	Proxy
        //   0	91	1	paramLong	long
        //   0	91	3	paramIOnSeekCompleteListenerCallback_0_8	IOnSeekCompleteListenerCallback_0_8
        //   3	82	4	localParcel1	Parcel
        //   8	72	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	23	78	finally
        //   27	34	78	finally
        //   34	62	78	finally
      }
      
      /* Error */
      public void registerOnSpeedAdjustmentAvailableChangedCallback(long paramLong, IOnSpeedAdjustmentAvailableChangedListenerCallback_0_8 paramIOnSpeedAdjustmentAvailableChangedListenerCallback_0_8)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 34
        //   14: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 4
        //   19: lload_1
        //   20: invokevirtual 42	android/os/Parcel:writeLong	(J)V
        //   23: aload_3
        //   24: ifnull +49 -> 73
        //   27: aload_3
        //   28: invokeinterface 128 1 0
        //   33: astore_3
        //   34: aload 4
        //   36: aload_3
        //   37: invokevirtual 93	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   40: aload_0
        //   41: getfield 19	com/aocate/presto/service/IPlayMedia_0_8$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   44: bipush 23
        //   46: aload 4
        //   48: aload 5
        //   50: iconst_0
        //   51: invokeinterface 48 5 0
        //   56: pop
        //   57: aload 5
        //   59: invokevirtual 51	android/os/Parcel:readException	()V
        //   62: aload 5
        //   64: invokevirtual 58	android/os/Parcel:recycle	()V
        //   67: aload 4
        //   69: invokevirtual 58	android/os/Parcel:recycle	()V
        //   72: return
        //   73: aconst_null
        //   74: astore_3
        //   75: goto -41 -> 34
        //   78: astore_3
        //   79: aload 5
        //   81: invokevirtual 58	android/os/Parcel:recycle	()V
        //   84: aload 4
        //   86: invokevirtual 58	android/os/Parcel:recycle	()V
        //   89: aload_3
        //   90: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	91	0	this	Proxy
        //   0	91	1	paramLong	long
        //   0	91	3	paramIOnSpeedAdjustmentAvailableChangedListenerCallback_0_8	IOnSpeedAdjustmentAvailableChangedListenerCallback_0_8
        //   3	82	4	localParcel1	Parcel
        //   8	72	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	23	78	finally
        //   27	34	78	finally
        //   34	62	78	finally
      }
      
      public void release(long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.aocate.presto.service.IPlayMedia_0_8");
          localParcel1.writeLong(paramLong);
          this.mRemote.transact(24, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void reset(long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.aocate.presto.service.IPlayMedia_0_8");
          localParcel1.writeLong(paramLong);
          this.mRemote.transact(25, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void seekTo(long paramLong, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.aocate.presto.service.IPlayMedia_0_8");
          localParcel1.writeLong(paramLong);
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(26, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setAudioStreamType(long paramLong, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.aocate.presto.service.IPlayMedia_0_8");
          localParcel1.writeLong(paramLong);
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(27, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setDataSourceString(long paramLong, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.aocate.presto.service.IPlayMedia_0_8");
          localParcel1.writeLong(paramLong);
          localParcel1.writeString(paramString);
          this.mRemote.transact(28, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public void setDataSourceUri(long paramLong, Uri paramUri)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 34
        //   14: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 4
        //   19: lload_1
        //   20: invokevirtual 42	android/os/Parcel:writeLong	(J)V
        //   23: aload_3
        //   24: ifnull +49 -> 73
        //   27: aload 4
        //   29: iconst_1
        //   30: invokevirtual 136	android/os/Parcel:writeInt	(I)V
        //   33: aload_3
        //   34: aload 4
        //   36: iconst_0
        //   37: invokevirtual 150	android/net/Uri:writeToParcel	(Landroid/os/Parcel;I)V
        //   40: aload_0
        //   41: getfield 19	com/aocate/presto/service/IPlayMedia_0_8$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   44: bipush 29
        //   46: aload 4
        //   48: aload 5
        //   50: iconst_0
        //   51: invokeinterface 48 5 0
        //   56: pop
        //   57: aload 5
        //   59: invokevirtual 51	android/os/Parcel:readException	()V
        //   62: aload 5
        //   64: invokevirtual 58	android/os/Parcel:recycle	()V
        //   67: aload 4
        //   69: invokevirtual 58	android/os/Parcel:recycle	()V
        //   72: return
        //   73: aload 4
        //   75: iconst_0
        //   76: invokevirtual 136	android/os/Parcel:writeInt	(I)V
        //   79: goto -39 -> 40
        //   82: astore_3
        //   83: aload 5
        //   85: invokevirtual 58	android/os/Parcel:recycle	()V
        //   88: aload 4
        //   90: invokevirtual 58	android/os/Parcel:recycle	()V
        //   93: aload_3
        //   94: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	95	0	this	Proxy
        //   0	95	1	paramLong	long
        //   0	95	3	paramUri	Uri
        //   3	86	4	localParcel1	Parcel
        //   8	76	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	23	82	finally
        //   27	40	82	finally
        //   40	62	82	finally
        //   73	79	82	finally
      }
      
      public void setEnableSpeedAdjustment(long paramLong, boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.aocate.presto.service.IPlayMedia_0_8");
          localParcel1.writeLong(paramLong);
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.mRemote.transact(30, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setLooping(long paramLong, boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.aocate.presto.service.IPlayMedia_0_8");
          localParcel1.writeLong(paramLong);
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.mRemote.transact(31, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setPitchStepsAdjustment(long paramLong, float paramFloat)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.aocate.presto.service.IPlayMedia_0_8");
          localParcel1.writeLong(paramLong);
          localParcel1.writeFloat(paramFloat);
          this.mRemote.transact(32, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setPlaybackPitch(long paramLong, float paramFloat)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.aocate.presto.service.IPlayMedia_0_8");
          localParcel1.writeLong(paramLong);
          localParcel1.writeFloat(paramFloat);
          this.mRemote.transact(33, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setPlaybackSpeed(long paramLong, float paramFloat)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.aocate.presto.service.IPlayMedia_0_8");
          localParcel1.writeLong(paramLong);
          localParcel1.writeFloat(paramFloat);
          this.mRemote.transact(34, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setSpeedAdjustmentAlgorithm(long paramLong, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.aocate.presto.service.IPlayMedia_0_8");
          localParcel1.writeLong(paramLong);
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(35, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setVolume(long paramLong, float paramFloat1, float paramFloat2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.aocate.presto.service.IPlayMedia_0_8");
          localParcel1.writeLong(paramLong);
          localParcel1.writeFloat(paramFloat1);
          localParcel1.writeFloat(paramFloat2);
          this.mRemote.transact(36, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void start(long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.aocate.presto.service.IPlayMedia_0_8");
          localParcel1.writeLong(paramLong);
          this.mRemote.transact(37, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public long startSession(IDeathCallback_0_8 paramIDeathCallback_0_8)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 34
        //   14: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +56 -> 74
        //   21: aload_1
        //   22: invokeinterface 170 1 0
        //   27: astore_1
        //   28: aload 4
        //   30: aload_1
        //   31: invokevirtual 93	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   34: aload_0
        //   35: getfield 19	com/aocate/presto/service/IPlayMedia_0_8$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   38: bipush 38
        //   40: aload 4
        //   42: aload 5
        //   44: iconst_0
        //   45: invokeinterface 48 5 0
        //   50: pop
        //   51: aload 5
        //   53: invokevirtual 51	android/os/Parcel:readException	()V
        //   56: aload 5
        //   58: invokevirtual 174	android/os/Parcel:readLong	()J
        //   61: lstore_2
        //   62: aload 5
        //   64: invokevirtual 58	android/os/Parcel:recycle	()V
        //   67: aload 4
        //   69: invokevirtual 58	android/os/Parcel:recycle	()V
        //   72: lload_2
        //   73: lreturn
        //   74: aconst_null
        //   75: astore_1
        //   76: goto -48 -> 28
        //   79: astore_1
        //   80: aload 5
        //   82: invokevirtual 58	android/os/Parcel:recycle	()V
        //   85: aload 4
        //   87: invokevirtual 58	android/os/Parcel:recycle	()V
        //   90: aload_1
        //   91: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	92	0	this	Proxy
        //   0	92	1	paramIDeathCallback_0_8	IDeathCallback_0_8
        //   61	12	2	l	long
        //   3	83	4	localParcel1	Parcel
        //   8	73	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	17	79	finally
        //   21	28	79	finally
        //   28	62	79	finally
      }
      
      public void stop(long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.aocate.presto.service.IPlayMedia_0_8");
          localParcel1.writeLong(paramLong);
          this.mRemote.transact(39, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public void unregisterOnBufferingUpdateCallback(long paramLong, IOnBufferingUpdateListenerCallback_0_8 paramIOnBufferingUpdateListenerCallback_0_8)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 34
        //   14: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 4
        //   19: lload_1
        //   20: invokevirtual 42	android/os/Parcel:writeLong	(J)V
        //   23: aload_3
        //   24: ifnull +49 -> 73
        //   27: aload_3
        //   28: invokeinterface 90 1 0
        //   33: astore_3
        //   34: aload 4
        //   36: aload_3
        //   37: invokevirtual 93	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   40: aload_0
        //   41: getfield 19	com/aocate/presto/service/IPlayMedia_0_8$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   44: bipush 40
        //   46: aload 4
        //   48: aload 5
        //   50: iconst_0
        //   51: invokeinterface 48 5 0
        //   56: pop
        //   57: aload 5
        //   59: invokevirtual 51	android/os/Parcel:readException	()V
        //   62: aload 5
        //   64: invokevirtual 58	android/os/Parcel:recycle	()V
        //   67: aload 4
        //   69: invokevirtual 58	android/os/Parcel:recycle	()V
        //   72: return
        //   73: aconst_null
        //   74: astore_3
        //   75: goto -41 -> 34
        //   78: astore_3
        //   79: aload 5
        //   81: invokevirtual 58	android/os/Parcel:recycle	()V
        //   84: aload 4
        //   86: invokevirtual 58	android/os/Parcel:recycle	()V
        //   89: aload_3
        //   90: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	91	0	this	Proxy
        //   0	91	1	paramLong	long
        //   0	91	3	paramIOnBufferingUpdateListenerCallback_0_8	IOnBufferingUpdateListenerCallback_0_8
        //   3	82	4	localParcel1	Parcel
        //   8	72	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	23	78	finally
        //   27	34	78	finally
        //   34	62	78	finally
      }
      
      /* Error */
      public void unregisterOnCompletionCallback(long paramLong, IOnCompletionListenerCallback_0_8 paramIOnCompletionListenerCallback_0_8)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 34
        //   14: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 4
        //   19: lload_1
        //   20: invokevirtual 42	android/os/Parcel:writeLong	(J)V
        //   23: aload_3
        //   24: ifnull +49 -> 73
        //   27: aload_3
        //   28: invokeinterface 98 1 0
        //   33: astore_3
        //   34: aload 4
        //   36: aload_3
        //   37: invokevirtual 93	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   40: aload_0
        //   41: getfield 19	com/aocate/presto/service/IPlayMedia_0_8$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   44: bipush 41
        //   46: aload 4
        //   48: aload 5
        //   50: iconst_0
        //   51: invokeinterface 48 5 0
        //   56: pop
        //   57: aload 5
        //   59: invokevirtual 51	android/os/Parcel:readException	()V
        //   62: aload 5
        //   64: invokevirtual 58	android/os/Parcel:recycle	()V
        //   67: aload 4
        //   69: invokevirtual 58	android/os/Parcel:recycle	()V
        //   72: return
        //   73: aconst_null
        //   74: astore_3
        //   75: goto -41 -> 34
        //   78: astore_3
        //   79: aload 5
        //   81: invokevirtual 58	android/os/Parcel:recycle	()V
        //   84: aload 4
        //   86: invokevirtual 58	android/os/Parcel:recycle	()V
        //   89: aload_3
        //   90: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	91	0	this	Proxy
        //   0	91	1	paramLong	long
        //   0	91	3	paramIOnCompletionListenerCallback_0_8	IOnCompletionListenerCallback_0_8
        //   3	82	4	localParcel1	Parcel
        //   8	72	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	23	78	finally
        //   27	34	78	finally
        //   34	62	78	finally
      }
      
      /* Error */
      public void unregisterOnErrorCallback(long paramLong, IOnErrorListenerCallback_0_8 paramIOnErrorListenerCallback_0_8)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 34
        //   14: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 4
        //   19: lload_1
        //   20: invokevirtual 42	android/os/Parcel:writeLong	(J)V
        //   23: aload_3
        //   24: ifnull +49 -> 73
        //   27: aload_3
        //   28: invokeinterface 103 1 0
        //   33: astore_3
        //   34: aload 4
        //   36: aload_3
        //   37: invokevirtual 93	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   40: aload_0
        //   41: getfield 19	com/aocate/presto/service/IPlayMedia_0_8$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   44: bipush 42
        //   46: aload 4
        //   48: aload 5
        //   50: iconst_0
        //   51: invokeinterface 48 5 0
        //   56: pop
        //   57: aload 5
        //   59: invokevirtual 51	android/os/Parcel:readException	()V
        //   62: aload 5
        //   64: invokevirtual 58	android/os/Parcel:recycle	()V
        //   67: aload 4
        //   69: invokevirtual 58	android/os/Parcel:recycle	()V
        //   72: return
        //   73: aconst_null
        //   74: astore_3
        //   75: goto -41 -> 34
        //   78: astore_3
        //   79: aload 5
        //   81: invokevirtual 58	android/os/Parcel:recycle	()V
        //   84: aload 4
        //   86: invokevirtual 58	android/os/Parcel:recycle	()V
        //   89: aload_3
        //   90: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	91	0	this	Proxy
        //   0	91	1	paramLong	long
        //   0	91	3	paramIOnErrorListenerCallback_0_8	IOnErrorListenerCallback_0_8
        //   3	82	4	localParcel1	Parcel
        //   8	72	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	23	78	finally
        //   27	34	78	finally
        //   34	62	78	finally
      }
      
      /* Error */
      public void unregisterOnInfoCallback(long paramLong, IOnInfoListenerCallback_0_8 paramIOnInfoListenerCallback_0_8)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 34
        //   14: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 4
        //   19: lload_1
        //   20: invokevirtual 42	android/os/Parcel:writeLong	(J)V
        //   23: aload_3
        //   24: ifnull +49 -> 73
        //   27: aload_3
        //   28: invokeinterface 108 1 0
        //   33: astore_3
        //   34: aload 4
        //   36: aload_3
        //   37: invokevirtual 93	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   40: aload_0
        //   41: getfield 19	com/aocate/presto/service/IPlayMedia_0_8$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   44: bipush 43
        //   46: aload 4
        //   48: aload 5
        //   50: iconst_0
        //   51: invokeinterface 48 5 0
        //   56: pop
        //   57: aload 5
        //   59: invokevirtual 51	android/os/Parcel:readException	()V
        //   62: aload 5
        //   64: invokevirtual 58	android/os/Parcel:recycle	()V
        //   67: aload 4
        //   69: invokevirtual 58	android/os/Parcel:recycle	()V
        //   72: return
        //   73: aconst_null
        //   74: astore_3
        //   75: goto -41 -> 34
        //   78: astore_3
        //   79: aload 5
        //   81: invokevirtual 58	android/os/Parcel:recycle	()V
        //   84: aload 4
        //   86: invokevirtual 58	android/os/Parcel:recycle	()V
        //   89: aload_3
        //   90: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	91	0	this	Proxy
        //   0	91	1	paramLong	long
        //   0	91	3	paramIOnInfoListenerCallback_0_8	IOnInfoListenerCallback_0_8
        //   3	82	4	localParcel1	Parcel
        //   8	72	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	23	78	finally
        //   27	34	78	finally
        //   34	62	78	finally
      }
      
      /* Error */
      public void unregisterOnPitchAdjustmentAvailableChangedCallback(long paramLong, IOnPitchAdjustmentAvailableChangedListenerCallback_0_8 paramIOnPitchAdjustmentAvailableChangedListenerCallback_0_8)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 34
        //   14: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 4
        //   19: lload_1
        //   20: invokevirtual 42	android/os/Parcel:writeLong	(J)V
        //   23: aload_3
        //   24: ifnull +49 -> 73
        //   27: aload_3
        //   28: invokeinterface 113 1 0
        //   33: astore_3
        //   34: aload 4
        //   36: aload_3
        //   37: invokevirtual 93	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   40: aload_0
        //   41: getfield 19	com/aocate/presto/service/IPlayMedia_0_8$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   44: bipush 44
        //   46: aload 4
        //   48: aload 5
        //   50: iconst_0
        //   51: invokeinterface 48 5 0
        //   56: pop
        //   57: aload 5
        //   59: invokevirtual 51	android/os/Parcel:readException	()V
        //   62: aload 5
        //   64: invokevirtual 58	android/os/Parcel:recycle	()V
        //   67: aload 4
        //   69: invokevirtual 58	android/os/Parcel:recycle	()V
        //   72: return
        //   73: aconst_null
        //   74: astore_3
        //   75: goto -41 -> 34
        //   78: astore_3
        //   79: aload 5
        //   81: invokevirtual 58	android/os/Parcel:recycle	()V
        //   84: aload 4
        //   86: invokevirtual 58	android/os/Parcel:recycle	()V
        //   89: aload_3
        //   90: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	91	0	this	Proxy
        //   0	91	1	paramLong	long
        //   0	91	3	paramIOnPitchAdjustmentAvailableChangedListenerCallback_0_8	IOnPitchAdjustmentAvailableChangedListenerCallback_0_8
        //   3	82	4	localParcel1	Parcel
        //   8	72	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	23	78	finally
        //   27	34	78	finally
        //   34	62	78	finally
      }
      
      /* Error */
      public void unregisterOnPreparedCallback(long paramLong, IOnPreparedListenerCallback_0_8 paramIOnPreparedListenerCallback_0_8)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 34
        //   14: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 4
        //   19: lload_1
        //   20: invokevirtual 42	android/os/Parcel:writeLong	(J)V
        //   23: aload_3
        //   24: ifnull +49 -> 73
        //   27: aload_3
        //   28: invokeinterface 118 1 0
        //   33: astore_3
        //   34: aload 4
        //   36: aload_3
        //   37: invokevirtual 93	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   40: aload_0
        //   41: getfield 19	com/aocate/presto/service/IPlayMedia_0_8$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   44: bipush 45
        //   46: aload 4
        //   48: aload 5
        //   50: iconst_0
        //   51: invokeinterface 48 5 0
        //   56: pop
        //   57: aload 5
        //   59: invokevirtual 51	android/os/Parcel:readException	()V
        //   62: aload 5
        //   64: invokevirtual 58	android/os/Parcel:recycle	()V
        //   67: aload 4
        //   69: invokevirtual 58	android/os/Parcel:recycle	()V
        //   72: return
        //   73: aconst_null
        //   74: astore_3
        //   75: goto -41 -> 34
        //   78: astore_3
        //   79: aload 5
        //   81: invokevirtual 58	android/os/Parcel:recycle	()V
        //   84: aload 4
        //   86: invokevirtual 58	android/os/Parcel:recycle	()V
        //   89: aload_3
        //   90: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	91	0	this	Proxy
        //   0	91	1	paramLong	long
        //   0	91	3	paramIOnPreparedListenerCallback_0_8	IOnPreparedListenerCallback_0_8
        //   3	82	4	localParcel1	Parcel
        //   8	72	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	23	78	finally
        //   27	34	78	finally
        //   34	62	78	finally
      }
      
      /* Error */
      public void unregisterOnSeekCompleteCallback(long paramLong, IOnSeekCompleteListenerCallback_0_8 paramIOnSeekCompleteListenerCallback_0_8)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 34
        //   14: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 4
        //   19: lload_1
        //   20: invokevirtual 42	android/os/Parcel:writeLong	(J)V
        //   23: aload_3
        //   24: ifnull +49 -> 73
        //   27: aload_3
        //   28: invokeinterface 123 1 0
        //   33: astore_3
        //   34: aload 4
        //   36: aload_3
        //   37: invokevirtual 93	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   40: aload_0
        //   41: getfield 19	com/aocate/presto/service/IPlayMedia_0_8$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   44: bipush 46
        //   46: aload 4
        //   48: aload 5
        //   50: iconst_0
        //   51: invokeinterface 48 5 0
        //   56: pop
        //   57: aload 5
        //   59: invokevirtual 51	android/os/Parcel:readException	()V
        //   62: aload 5
        //   64: invokevirtual 58	android/os/Parcel:recycle	()V
        //   67: aload 4
        //   69: invokevirtual 58	android/os/Parcel:recycle	()V
        //   72: return
        //   73: aconst_null
        //   74: astore_3
        //   75: goto -41 -> 34
        //   78: astore_3
        //   79: aload 5
        //   81: invokevirtual 58	android/os/Parcel:recycle	()V
        //   84: aload 4
        //   86: invokevirtual 58	android/os/Parcel:recycle	()V
        //   89: aload_3
        //   90: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	91	0	this	Proxy
        //   0	91	1	paramLong	long
        //   0	91	3	paramIOnSeekCompleteListenerCallback_0_8	IOnSeekCompleteListenerCallback_0_8
        //   3	82	4	localParcel1	Parcel
        //   8	72	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	23	78	finally
        //   27	34	78	finally
        //   34	62	78	finally
      }
      
      /* Error */
      public void unregisterOnSpeedAdjustmentAvailableChangedCallback(long paramLong, IOnSpeedAdjustmentAvailableChangedListenerCallback_0_8 paramIOnSpeedAdjustmentAvailableChangedListenerCallback_0_8)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 34
        //   14: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 4
        //   19: lload_1
        //   20: invokevirtual 42	android/os/Parcel:writeLong	(J)V
        //   23: aload_3
        //   24: ifnull +49 -> 73
        //   27: aload_3
        //   28: invokeinterface 128 1 0
        //   33: astore_3
        //   34: aload 4
        //   36: aload_3
        //   37: invokevirtual 93	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   40: aload_0
        //   41: getfield 19	com/aocate/presto/service/IPlayMedia_0_8$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   44: bipush 47
        //   46: aload 4
        //   48: aload 5
        //   50: iconst_0
        //   51: invokeinterface 48 5 0
        //   56: pop
        //   57: aload 5
        //   59: invokevirtual 51	android/os/Parcel:readException	()V
        //   62: aload 5
        //   64: invokevirtual 58	android/os/Parcel:recycle	()V
        //   67: aload 4
        //   69: invokevirtual 58	android/os/Parcel:recycle	()V
        //   72: return
        //   73: aconst_null
        //   74: astore_3
        //   75: goto -41 -> 34
        //   78: astore_3
        //   79: aload 5
        //   81: invokevirtual 58	android/os/Parcel:recycle	()V
        //   84: aload 4
        //   86: invokevirtual 58	android/os/Parcel:recycle	()V
        //   89: aload_3
        //   90: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	91	0	this	Proxy
        //   0	91	1	paramLong	long
        //   0	91	3	paramIOnSpeedAdjustmentAvailableChangedListenerCallback_0_8	IOnSpeedAdjustmentAvailableChangedListenerCallback_0_8
        //   3	82	4	localParcel1	Parcel
        //   8	72	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	23	78	finally
        //   27	34	78	finally
        //   34	62	78	finally
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/aocate/presto/service/IPlayMedia_0_8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */