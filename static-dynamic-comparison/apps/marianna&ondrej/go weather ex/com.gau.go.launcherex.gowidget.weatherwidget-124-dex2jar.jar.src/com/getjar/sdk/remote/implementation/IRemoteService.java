package com.getjar.sdk.remote.implementation;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface IRemoteService
  extends IInterface
{
  public abstract Bundle getInterstitialIntent(String paramString1, String paramString2)
    throws RemoteException;
  
  public abstract Bundle getLicense(String paramString)
    throws RemoteException;
  
  public abstract Bundle getPurchaseIntent(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4)
    throws RemoteException;
  
  public abstract Bundle prepareAd(String paramString)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IRemoteService
  {
    private static final String DESCRIPTOR = "com.getjar.sdk.remote.implementation.IRemoteService";
    static final int TRANSACTION_getInterstitialIntent = 2;
    static final int TRANSACTION_getLicense = 4;
    static final int TRANSACTION_getPurchaseIntent = 3;
    static final int TRANSACTION_prepareAd = 1;
    
    public Stub()
    {
      attachInterface(this, "com.getjar.sdk.remote.implementation.IRemoteService");
    }
    
    public static IRemoteService asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.getjar.sdk.remote.implementation.IRemoteService");
      if ((localIInterface != null) && ((localIInterface instanceof IRemoteService))) {
        return (IRemoteService)localIInterface;
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
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.getjar.sdk.remote.implementation.IRemoteService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.getjar.sdk.remote.implementation.IRemoteService");
        paramParcel1 = prepareAd(paramParcel1.readString());
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        for (;;)
        {
          return true;
          paramParcel2.writeInt(0);
        }
      case 2: 
        paramParcel1.enforceInterface("com.getjar.sdk.remote.implementation.IRemoteService");
        paramParcel1 = getInterstitialIntent(paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        for (;;)
        {
          return true;
          paramParcel2.writeInt(0);
        }
      case 3: 
        paramParcel1.enforceInterface("com.getjar.sdk.remote.implementation.IRemoteService");
        paramParcel1 = getPurchaseIntent(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readLong(), paramParcel1.readString());
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        for (;;)
        {
          return true;
          paramParcel2.writeInt(0);
        }
      }
      paramParcel1.enforceInterface("com.getjar.sdk.remote.implementation.IRemoteService");
      paramParcel1 = getLicense(paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        paramParcel2.writeInt(0);
      }
    }
    
    private static class Proxy
      implements IRemoteService
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
      
      public String getInterfaceDescriptor()
      {
        return "com.getjar.sdk.remote.implementation.IRemoteService";
      }
      
      /* Error */
      public Bundle getInterstitialIntent(String paramString1, String paramString2)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 26
        //   12: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_3
        //   16: aload_1
        //   17: invokevirtual 43	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   20: aload_3
        //   21: aload_2
        //   22: invokevirtual 43	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   25: aload_0
        //   26: getfield 19	com/getjar/sdk/remote/implementation/IRemoteService$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   29: iconst_2
        //   30: aload_3
        //   31: aload 4
        //   33: iconst_0
        //   34: invokeinterface 49 5 0
        //   39: pop
        //   40: aload 4
        //   42: invokevirtual 52	android/os/Parcel:readException	()V
        //   45: aload 4
        //   47: invokevirtual 56	android/os/Parcel:readInt	()I
        //   50: ifeq +28 -> 78
        //   53: getstatic 62	android/os/Bundle:CREATOR	Landroid/os/Parcelable$Creator;
        //   56: aload 4
        //   58: invokeinterface 68 2 0
        //   63: checkcast 58	android/os/Bundle
        //   66: astore_1
        //   67: aload 4
        //   69: invokevirtual 71	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 71	android/os/Parcel:recycle	()V
        //   76: aload_1
        //   77: areturn
        //   78: aconst_null
        //   79: astore_1
        //   80: goto -13 -> 67
        //   83: astore_1
        //   84: aload 4
        //   86: invokevirtual 71	android/os/Parcel:recycle	()V
        //   89: aload_3
        //   90: invokevirtual 71	android/os/Parcel:recycle	()V
        //   93: aload_1
        //   94: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	95	0	this	Proxy
        //   0	95	1	paramString1	String
        //   0	95	2	paramString2	String
        //   3	87	3	localParcel1	Parcel
        //   7	78	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	67	83	finally
      }
      
      /* Error */
      public Bundle getLicense(String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 26
        //   11: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_2
        //   15: aload_1
        //   16: invokevirtual 43	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   19: aload_0
        //   20: getfield 19	com/getjar/sdk/remote/implementation/IRemoteService$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   23: iconst_4
        //   24: aload_2
        //   25: aload_3
        //   26: iconst_0
        //   27: invokeinterface 49 5 0
        //   32: pop
        //   33: aload_3
        //   34: invokevirtual 52	android/os/Parcel:readException	()V
        //   37: aload_3
        //   38: invokevirtual 56	android/os/Parcel:readInt	()I
        //   41: ifeq +26 -> 67
        //   44: getstatic 62	android/os/Bundle:CREATOR	Landroid/os/Parcelable$Creator;
        //   47: aload_3
        //   48: invokeinterface 68 2 0
        //   53: checkcast 58	android/os/Bundle
        //   56: astore_1
        //   57: aload_3
        //   58: invokevirtual 71	android/os/Parcel:recycle	()V
        //   61: aload_2
        //   62: invokevirtual 71	android/os/Parcel:recycle	()V
        //   65: aload_1
        //   66: areturn
        //   67: aconst_null
        //   68: astore_1
        //   69: goto -12 -> 57
        //   72: astore_1
        //   73: aload_3
        //   74: invokevirtual 71	android/os/Parcel:recycle	()V
        //   77: aload_2
        //   78: invokevirtual 71	android/os/Parcel:recycle	()V
        //   81: aload_1
        //   82: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	83	0	this	Proxy
        //   0	83	1	paramString	String
        //   3	75	2	localParcel1	Parcel
        //   7	67	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	57	72	finally
      }
      
      /* Error */
      public Bundle getPurchaseIntent(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 7
        //   5: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 8
        //   10: aload 7
        //   12: ldc 26
        //   14: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 7
        //   19: aload_1
        //   20: invokevirtual 43	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   23: aload 7
        //   25: aload_2
        //   26: invokevirtual 43	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   29: aload 7
        //   31: aload_3
        //   32: invokevirtual 43	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   35: aload 7
        //   37: lload 4
        //   39: invokevirtual 80	android/os/Parcel:writeLong	(J)V
        //   42: aload 7
        //   44: aload 6
        //   46: invokevirtual 43	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   49: aload_0
        //   50: getfield 19	com/getjar/sdk/remote/implementation/IRemoteService$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   53: iconst_3
        //   54: aload 7
        //   56: aload 8
        //   58: iconst_0
        //   59: invokeinterface 49 5 0
        //   64: pop
        //   65: aload 8
        //   67: invokevirtual 52	android/os/Parcel:readException	()V
        //   70: aload 8
        //   72: invokevirtual 56	android/os/Parcel:readInt	()I
        //   75: ifeq +29 -> 104
        //   78: getstatic 62	android/os/Bundle:CREATOR	Landroid/os/Parcelable$Creator;
        //   81: aload 8
        //   83: invokeinterface 68 2 0
        //   88: checkcast 58	android/os/Bundle
        //   91: astore_1
        //   92: aload 8
        //   94: invokevirtual 71	android/os/Parcel:recycle	()V
        //   97: aload 7
        //   99: invokevirtual 71	android/os/Parcel:recycle	()V
        //   102: aload_1
        //   103: areturn
        //   104: aconst_null
        //   105: astore_1
        //   106: goto -14 -> 92
        //   109: astore_1
        //   110: aload 8
        //   112: invokevirtual 71	android/os/Parcel:recycle	()V
        //   115: aload 7
        //   117: invokevirtual 71	android/os/Parcel:recycle	()V
        //   120: aload_1
        //   121: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	122	0	this	Proxy
        //   0	122	1	paramString1	String
        //   0	122	2	paramString2	String
        //   0	122	3	paramString3	String
        //   0	122	4	paramLong	long
        //   0	122	6	paramString4	String
        //   3	113	7	localParcel1	Parcel
        //   8	103	8	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	92	109	finally
      }
      
      /* Error */
      public Bundle prepareAd(String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 26
        //   11: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_2
        //   15: aload_1
        //   16: invokevirtual 43	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   19: aload_0
        //   20: getfield 19	com/getjar/sdk/remote/implementation/IRemoteService$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   23: iconst_1
        //   24: aload_2
        //   25: aload_3
        //   26: iconst_0
        //   27: invokeinterface 49 5 0
        //   32: pop
        //   33: aload_3
        //   34: invokevirtual 52	android/os/Parcel:readException	()V
        //   37: aload_3
        //   38: invokevirtual 56	android/os/Parcel:readInt	()I
        //   41: ifeq +26 -> 67
        //   44: getstatic 62	android/os/Bundle:CREATOR	Landroid/os/Parcelable$Creator;
        //   47: aload_3
        //   48: invokeinterface 68 2 0
        //   53: checkcast 58	android/os/Bundle
        //   56: astore_1
        //   57: aload_3
        //   58: invokevirtual 71	android/os/Parcel:recycle	()V
        //   61: aload_2
        //   62: invokevirtual 71	android/os/Parcel:recycle	()V
        //   65: aload_1
        //   66: areturn
        //   67: aconst_null
        //   68: astore_1
        //   69: goto -12 -> 57
        //   72: astore_1
        //   73: aload_3
        //   74: invokevirtual 71	android/os/Parcel:recycle	()V
        //   77: aload_2
        //   78: invokevirtual 71	android/os/Parcel:recycle	()V
        //   81: aload_1
        //   82: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	83	0	this	Proxy
        //   0	83	1	paramString	String
        //   3	75	2	localParcel1	Parcel
        //   7	67	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	57	72	finally
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/remote/implementation/IRemoteService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */