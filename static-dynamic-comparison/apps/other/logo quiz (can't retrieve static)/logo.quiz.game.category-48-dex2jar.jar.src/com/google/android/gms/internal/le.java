package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.BleDevicesResult;

public abstract interface le
  extends IInterface
{
  public abstract void a(BleDevicesResult paramBleDevicesResult)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements le
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
    }
    
    public static le ax(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
      if ((localIInterface != null) && ((localIInterface instanceof le))) {
        return (le)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (BleDevicesResult)BleDevicesResult.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    }
    
    private static class a
      implements le
    {
      private IBinder lb;
      
      a(IBinder paramIBinder)
      {
        this.lb = paramIBinder;
      }
      
      /* Error */
      public void a(BleDevicesResult paramBleDevicesResult)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +41 -> 56
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 44	com/google/android/gms/fitness/result/BleDevicesResult:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/internal/le$a$a:lb	Landroid/os/IBinder;
        //   33: iconst_1
        //   34: aload_2
        //   35: aload_3
        //   36: iconst_0
        //   37: invokeinterface 50 5 0
        //   42: pop
        //   43: aload_3
        //   44: invokevirtual 53	android/os/Parcel:readException	()V
        //   47: aload_3
        //   48: invokevirtual 56	android/os/Parcel:recycle	()V
        //   51: aload_2
        //   52: invokevirtual 56	android/os/Parcel:recycle	()V
        //   55: return
        //   56: aload_2
        //   57: iconst_0
        //   58: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   61: goto -32 -> 29
        //   64: astore_1
        //   65: aload_3
        //   66: invokevirtual 56	android/os/Parcel:recycle	()V
        //   69: aload_2
        //   70: invokevirtual 56	android/os/Parcel:recycle	()V
        //   73: aload_1
        //   74: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	75	0	this	a
        //   0	75	1	paramBleDevicesResult	BleDevicesResult
        //   3	67	2	localParcel1	Parcel
        //   7	59	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	64	finally
        //   18	29	64	finally
        //   29	47	64	finally
        //   56	61	64	finally
      }
      
      public IBinder asBinder()
      {
        return this.lb;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/le.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */