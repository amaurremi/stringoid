package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;

public abstract interface is
  extends IInterface
{
  public abstract void a(Bundle paramBundle, it paramit)
    throws RemoteException;
  
  public abstract void a(FullWalletRequest paramFullWalletRequest, Bundle paramBundle, it paramit)
    throws RemoteException;
  
  public abstract void a(MaskedWalletRequest paramMaskedWalletRequest, Bundle paramBundle, it paramit)
    throws RemoteException;
  
  public abstract void a(NotifyTransactionStatusRequest paramNotifyTransactionStatusRequest, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void a(String paramString1, String paramString2, Bundle paramBundle, it paramit)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements is
  {
    public static is az(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IOwService");
      if ((localIInterface != null) && ((localIInterface instanceof is))) {
        return (is)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      Object localObject;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.wallet.internal.IOwService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
        if (paramParcel1.readInt() != 0)
        {
          paramParcel2 = (MaskedWalletRequest)MaskedWalletRequest.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label146;
          }
        }
        for (localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; localObject = null)
        {
          a(paramParcel2, (Bundle)localObject, it.a.aA(paramParcel1.readStrongBinder()));
          return true;
          paramParcel2 = null;
          break;
        }
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
        if (paramParcel1.readInt() != 0)
        {
          paramParcel2 = (FullWalletRequest)FullWalletRequest.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label220;
          }
        }
        for (localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; localObject = null)
        {
          a(paramParcel2, (Bundle)localObject, it.a.aA(paramParcel1.readStrongBinder()));
          return true;
          paramParcel2 = null;
          break;
        }
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
        localObject = paramParcel1.readString();
        String str = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel2 = null)
        {
          a((String)localObject, str, paramParcel2, it.a.aA(paramParcel1.readStrongBinder()));
          return true;
        }
      case 4: 
        label146:
        label220:
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
        if (paramParcel1.readInt() != 0)
        {
          paramParcel2 = (NotifyTransactionStatusRequest)NotifyTransactionStatusRequest.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label346;
          }
        }
        label346:
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          a(paramParcel2, paramParcel1);
          return true;
          paramParcel2 = null;
          break;
        }
      }
      paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel2 = null)
      {
        a(paramParcel2, it.a.aA(paramParcel1.readStrongBinder()));
        return true;
      }
    }
    
    private static class a
      implements is
    {
      private IBinder dU;
      
      a(IBinder paramIBinder)
      {
        this.dU = paramIBinder;
      }
      
      /* Error */
      public void a(Bundle paramBundle, it paramit)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   5: astore 4
        //   7: aload 4
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +56 -> 71
        //   18: aload 4
        //   20: iconst_1
        //   21: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload 4
        //   27: iconst_0
        //   28: invokevirtual 44	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   31: aload_3
        //   32: astore_1
        //   33: aload_2
        //   34: ifnull +10 -> 44
        //   37: aload_2
        //   38: invokeinterface 50 1 0
        //   43: astore_1
        //   44: aload 4
        //   46: aload_1
        //   47: invokevirtual 53	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   50: aload_0
        //   51: getfield 18	com/google/android/gms/internal/is$a$a:dU	Landroid/os/IBinder;
        //   54: iconst_5
        //   55: aload 4
        //   57: aconst_null
        //   58: iconst_1
        //   59: invokeinterface 59 5 0
        //   64: pop
        //   65: aload 4
        //   67: invokevirtual 62	android/os/Parcel:recycle	()V
        //   70: return
        //   71: aload 4
        //   73: iconst_0
        //   74: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   77: goto -46 -> 31
        //   80: astore_1
        //   81: aload 4
        //   83: invokevirtual 62	android/os/Parcel:recycle	()V
        //   86: aload_1
        //   87: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	88	0	this	a
        //   0	88	1	paramBundle	Bundle
        //   0	88	2	paramit	it
        //   1	31	3	localObject	Object
        //   5	77	4	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   7	14	80	finally
        //   18	31	80	finally
        //   37	44	80	finally
        //   44	65	80	finally
        //   71	77	80	finally
      }
      
      public void a(FullWalletRequest paramFullWalletRequest, Bundle paramBundle, it paramit)
        throws RemoteException
      {
        Object localObject = null;
        Parcel localParcel = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
            if (paramFullWalletRequest != null)
            {
              localParcel.writeInt(1);
              paramFullWalletRequest.writeToParcel(localParcel, 0);
              if (paramBundle != null)
              {
                localParcel.writeInt(1);
                paramBundle.writeToParcel(localParcel, 0);
                paramFullWalletRequest = (FullWalletRequest)localObject;
                if (paramit != null) {
                  paramFullWalletRequest = paramit.asBinder();
                }
                localParcel.writeStrongBinder(paramFullWalletRequest);
                this.dU.transact(2, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
            localParcel.writeInt(0);
          }
          finally
          {
            localParcel.recycle();
          }
        }
      }
      
      public void a(MaskedWalletRequest paramMaskedWalletRequest, Bundle paramBundle, it paramit)
        throws RemoteException
      {
        Object localObject = null;
        Parcel localParcel = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
            if (paramMaskedWalletRequest != null)
            {
              localParcel.writeInt(1);
              paramMaskedWalletRequest.writeToParcel(localParcel, 0);
              if (paramBundle != null)
              {
                localParcel.writeInt(1);
                paramBundle.writeToParcel(localParcel, 0);
                paramMaskedWalletRequest = (MaskedWalletRequest)localObject;
                if (paramit != null) {
                  paramMaskedWalletRequest = paramit.asBinder();
                }
                localParcel.writeStrongBinder(paramMaskedWalletRequest);
                this.dU.transact(1, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
            localParcel.writeInt(0);
          }
          finally
          {
            localParcel.recycle();
          }
        }
      }
      
      public void a(NotifyTransactionStatusRequest paramNotifyTransactionStatusRequest, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
            if (paramNotifyTransactionStatusRequest != null)
            {
              localParcel.writeInt(1);
              paramNotifyTransactionStatusRequest.writeToParcel(localParcel, 0);
              if (paramBundle != null)
              {
                localParcel.writeInt(1);
                paramBundle.writeToParcel(localParcel, 0);
                this.dU.transact(4, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
            localParcel.writeInt(0);
          }
          finally
          {
            localParcel.recycle();
          }
        }
      }
      
      /* Error */
      public void a(String paramString1, String paramString2, Bundle paramBundle, it paramit)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 5
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 6
        //   8: aload 6
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload 6
        //   17: aload_1
        //   18: invokevirtual 79	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   21: aload 6
        //   23: aload_2
        //   24: invokevirtual 79	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   27: aload_3
        //   28: ifnull +59 -> 87
        //   31: aload 6
        //   33: iconst_1
        //   34: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   37: aload_3
        //   38: aload 6
        //   40: iconst_0
        //   41: invokevirtual 44	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   44: aload 5
        //   46: astore_1
        //   47: aload 4
        //   49: ifnull +11 -> 60
        //   52: aload 4
        //   54: invokeinterface 50 1 0
        //   59: astore_1
        //   60: aload 6
        //   62: aload_1
        //   63: invokevirtual 53	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   66: aload_0
        //   67: getfield 18	com/google/android/gms/internal/is$a$a:dU	Landroid/os/IBinder;
        //   70: iconst_3
        //   71: aload 6
        //   73: aconst_null
        //   74: iconst_1
        //   75: invokeinterface 59 5 0
        //   80: pop
        //   81: aload 6
        //   83: invokevirtual 62	android/os/Parcel:recycle	()V
        //   86: return
        //   87: aload 6
        //   89: iconst_0
        //   90: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   93: goto -49 -> 44
        //   96: astore_1
        //   97: aload 6
        //   99: invokevirtual 62	android/os/Parcel:recycle	()V
        //   102: aload_1
        //   103: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	104	0	this	a
        //   0	104	1	paramString1	String
        //   0	104	2	paramString2	String
        //   0	104	3	paramBundle	Bundle
        //   0	104	4	paramit	it
        //   1	44	5	localObject	Object
        //   6	92	6	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	27	96	finally
        //   31	44	96	finally
        //   52	60	96	finally
        //   60	81	96	finally
        //   87	93	96	finally
      }
      
      public IBinder asBinder()
      {
        return this.dU;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/is.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */