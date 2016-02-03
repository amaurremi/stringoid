package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface hq
  extends IInterface
{
  public abstract void cancelClick()
    throws RemoteException;
  
  public abstract PendingIntent getResolution()
    throws RemoteException;
  
  public abstract void reinitialize()
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements hq
  {
    public static hq aw(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusOneDelegate");
      if ((localIInterface != null) && ((localIInterface instanceof hq))) {
        return (hq)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.plus.internal.IPlusOneDelegate");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusOneDelegate");
        paramParcel1 = getResolution();
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusOneDelegate");
        cancelClick();
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusOneDelegate");
      reinitialize();
      paramParcel2.writeNoException();
      return true;
    }
    
    private static class a
      implements hq
    {
      private IBinder dU;
      
      a(IBinder paramIBinder)
      {
        this.dU = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.dU;
      }
      
      public void cancelClick()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusOneDelegate");
          this.dU.transact(2, localParcel1, localParcel2, 0);
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
      public PendingIntent getResolution()
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 32
        //   11: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 18	com/google/android/gms/internal/hq$a$a:dU	Landroid/os/IBinder;
        //   18: iconst_1
        //   19: aload_2
        //   20: aload_3
        //   21: iconst_0
        //   22: invokeinterface 42 5 0
        //   27: pop
        //   28: aload_3
        //   29: invokevirtual 45	android/os/Parcel:readException	()V
        //   32: aload_3
        //   33: invokevirtual 55	android/os/Parcel:readInt	()I
        //   36: ifeq +26 -> 62
        //   39: getstatic 61	android/app/PendingIntent:CREATOR	Landroid/os/Parcelable$Creator;
        //   42: aload_3
        //   43: invokeinterface 67 2 0
        //   48: checkcast 57	android/app/PendingIntent
        //   51: astore_1
        //   52: aload_3
        //   53: invokevirtual 48	android/os/Parcel:recycle	()V
        //   56: aload_2
        //   57: invokevirtual 48	android/os/Parcel:recycle	()V
        //   60: aload_1
        //   61: areturn
        //   62: aconst_null
        //   63: astore_1
        //   64: goto -12 -> 52
        //   67: astore_1
        //   68: aload_3
        //   69: invokevirtual 48	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 48	android/os/Parcel:recycle	()V
        //   76: aload_1
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	a
        //   51	13	1	localPendingIntent	PendingIntent
        //   67	10	1	localObject	Object
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	52	67	finally
      }
      
      public void reinitialize()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusOneDelegate");
          this.dU.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/hq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */