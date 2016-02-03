package mobi.beyondpod.services.player;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface IMediaPlaybackService
  extends IInterface
{
  public abstract boolean canChangePlaybackSpeed()
    throws RemoteException;
  
  public abstract long duration()
    throws RemoteException;
  
  public abstract float getCurrentPlaybackSpeed()
    throws RemoteException;
  
  public abstract int gettimetosleep()
    throws RemoteException;
  
  public abstract void gotosleepin(int paramInt)
    throws RemoteException;
  
  public abstract boolean isPlaying()
    throws RemoteException;
  
  public abstract void open(int paramInt)
    throws RemoteException;
  
  public abstract void pause()
    throws RemoteException;
  
  public abstract void play()
    throws RemoteException;
  
  public abstract int playerType()
    throws RemoteException;
  
  public abstract long position()
    throws RemoteException;
  
  public abstract long seek(long paramLong)
    throws RemoteException;
  
  public abstract void setPlaybackSpeed(float paramFloat1, float paramFloat2)
    throws RemoteException;
  
  public abstract void startAndFadeIn()
    throws RemoteException;
  
  public abstract void stop()
    throws RemoteException;
  
  public abstract boolean supportsSpeedAlteration()
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IMediaPlaybackService
  {
    private static final String DESCRIPTOR = "mobi.beyondpod.services.player.IMediaPlaybackService";
    static final int TRANSACTION_canChangePlaybackSpeed = 12;
    static final int TRANSACTION_duration = 7;
    static final int TRANSACTION_getCurrentPlaybackSpeed = 14;
    static final int TRANSACTION_gettimetosleep = 11;
    static final int TRANSACTION_gotosleepin = 10;
    static final int TRANSACTION_isPlaying = 2;
    static final int TRANSACTION_open = 1;
    static final int TRANSACTION_pause = 4;
    static final int TRANSACTION_play = 5;
    static final int TRANSACTION_playerType = 16;
    static final int TRANSACTION_position = 8;
    static final int TRANSACTION_seek = 9;
    static final int TRANSACTION_setPlaybackSpeed = 13;
    static final int TRANSACTION_startAndFadeIn = 6;
    static final int TRANSACTION_stop = 3;
    static final int TRANSACTION_supportsSpeedAlteration = 15;
    
    public Stub()
    {
      attachInterface(this, "mobi.beyondpod.services.player.IMediaPlaybackService");
    }
    
    public static IMediaPlaybackService asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("mobi.beyondpod.services.player.IMediaPlaybackService");
      if ((localIInterface != null) && ((localIInterface instanceof IMediaPlaybackService))) {
        return (IMediaPlaybackService)localIInterface;
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
      int i = 0;
      boolean bool;
      long l;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("mobi.beyondpod.services.player.IMediaPlaybackService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("mobi.beyondpod.services.player.IMediaPlaybackService");
        open(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("mobi.beyondpod.services.player.IMediaPlaybackService");
        bool = isPlaying();
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("mobi.beyondpod.services.player.IMediaPlaybackService");
        stop();
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("mobi.beyondpod.services.player.IMediaPlaybackService");
        pause();
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("mobi.beyondpod.services.player.IMediaPlaybackService");
        play();
        paramParcel2.writeNoException();
        return true;
      case 6: 
        paramParcel1.enforceInterface("mobi.beyondpod.services.player.IMediaPlaybackService");
        startAndFadeIn();
        paramParcel2.writeNoException();
        return true;
      case 7: 
        paramParcel1.enforceInterface("mobi.beyondpod.services.player.IMediaPlaybackService");
        l = duration();
        paramParcel2.writeNoException();
        paramParcel2.writeLong(l);
        return true;
      case 8: 
        paramParcel1.enforceInterface("mobi.beyondpod.services.player.IMediaPlaybackService");
        l = position();
        paramParcel2.writeNoException();
        paramParcel2.writeLong(l);
        return true;
      case 9: 
        paramParcel1.enforceInterface("mobi.beyondpod.services.player.IMediaPlaybackService");
        l = seek(paramParcel1.readLong());
        paramParcel2.writeNoException();
        paramParcel2.writeLong(l);
        return true;
      case 10: 
        paramParcel1.enforceInterface("mobi.beyondpod.services.player.IMediaPlaybackService");
        gotosleepin(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 11: 
        paramParcel1.enforceInterface("mobi.beyondpod.services.player.IMediaPlaybackService");
        paramInt1 = gettimetosleep();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 12: 
        paramParcel1.enforceInterface("mobi.beyondpod.services.player.IMediaPlaybackService");
        bool = canChangePlaybackSpeed();
        paramParcel2.writeNoException();
        paramInt1 = j;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 13: 
        paramParcel1.enforceInterface("mobi.beyondpod.services.player.IMediaPlaybackService");
        setPlaybackSpeed(paramParcel1.readFloat(), paramParcel1.readFloat());
        paramParcel2.writeNoException();
        return true;
      case 14: 
        paramParcel1.enforceInterface("mobi.beyondpod.services.player.IMediaPlaybackService");
        float f = getCurrentPlaybackSpeed();
        paramParcel2.writeNoException();
        paramParcel2.writeFloat(f);
        return true;
      case 15: 
        paramParcel1.enforceInterface("mobi.beyondpod.services.player.IMediaPlaybackService");
        bool = supportsSpeedAlteration();
        paramParcel2.writeNoException();
        paramInt1 = k;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      }
      paramParcel1.enforceInterface("mobi.beyondpod.services.player.IMediaPlaybackService");
      paramInt1 = playerType();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    
    private static class Proxy
      implements IMediaPlaybackService
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
      
      public boolean canChangePlaybackSpeed()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("mobi.beyondpod.services.player.IMediaPlaybackService");
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
      
      public long duration()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("mobi.beyondpod.services.player.IMediaPlaybackService");
          this.mRemote.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          long l = localParcel2.readLong();
          return l;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public float getCurrentPlaybackSpeed()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("mobi.beyondpod.services.player.IMediaPlaybackService");
          this.mRemote.transact(14, localParcel1, localParcel2, 0);
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
      
      public String getInterfaceDescriptor()
      {
        return "mobi.beyondpod.services.player.IMediaPlaybackService";
      }
      
      public int gettimetosleep()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("mobi.beyondpod.services.player.IMediaPlaybackService");
          this.mRemote.transact(11, localParcel1, localParcel2, 0);
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
      
      public void gotosleepin(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("mobi.beyondpod.services.player.IMediaPlaybackService");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(10, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean isPlaying()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("mobi.beyondpod.services.player.IMediaPlaybackService");
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
      
      public void open(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("mobi.beyondpod.services.player.IMediaPlaybackService");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void pause()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("mobi.beyondpod.services.player.IMediaPlaybackService");
          this.mRemote.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void play()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("mobi.beyondpod.services.player.IMediaPlaybackService");
          this.mRemote.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int playerType()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("mobi.beyondpod.services.player.IMediaPlaybackService");
          this.mRemote.transact(16, localParcel1, localParcel2, 0);
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
      
      public long position()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("mobi.beyondpod.services.player.IMediaPlaybackService");
          this.mRemote.transact(8, localParcel1, localParcel2, 0);
          localParcel2.readException();
          long l = localParcel2.readLong();
          return l;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public long seek(long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("mobi.beyondpod.services.player.IMediaPlaybackService");
          localParcel1.writeLong(paramLong);
          this.mRemote.transact(9, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramLong = localParcel2.readLong();
          return paramLong;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setPlaybackSpeed(float paramFloat1, float paramFloat2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("mobi.beyondpod.services.player.IMediaPlaybackService");
          localParcel1.writeFloat(paramFloat1);
          localParcel1.writeFloat(paramFloat2);
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
      
      public void startAndFadeIn()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("mobi.beyondpod.services.player.IMediaPlaybackService");
          this.mRemote.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void stop()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("mobi.beyondpod.services.player.IMediaPlaybackService");
          this.mRemote.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean supportsSpeedAlteration()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("mobi.beyondpod.services.player.IMediaPlaybackService");
          this.mRemote.transact(15, localParcel1, localParcel2, 0);
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
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/services/player/IMediaPlaybackService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */