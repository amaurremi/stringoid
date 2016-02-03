package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.DataHolderCreator;

public abstract interface ej
        extends IInterface {
    public abstract void a(int paramInt, DataHolder paramDataHolder)
            throws RemoteException;

    public abstract void a(DataHolder paramDataHolder)
            throws RemoteException;

    public abstract void b(int paramInt1, int paramInt2)
            throws RemoteException;

    public abstract void du()
            throws RemoteException;

    public abstract void v(int paramInt)
            throws RemoteException;

    public static abstract class a
            extends Binder
            implements ej {
        public a() {
            attachInterface(this, "com.google.android.gms.appstate.internal.IAppStateCallbacks");
        }

        public static ej v(IBinder paramIBinder) {
            if (paramIBinder == null) {
                return null;
            }
            IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
            if ((localIInterface != null) && ((localIInterface instanceof ej))) {
                return (ej) localIInterface;
            }
            return new a(paramIBinder);
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
                throws RemoteException {
            Object localObject2 = null;
            Object localObject1 = null;
            switch (paramInt1) {
                default:
                    return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
                case 1598968902:
                    paramParcel2.writeString("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                    return true;
                case 5001:
                    paramParcel1.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                    paramInt1 = paramParcel1.readInt();
                    if (paramParcel1.readInt() != 0) {
                        localObject1 = DataHolder.CREATOR.createFromParcel(paramParcel1);
                    }
                    a(paramInt1, (DataHolder) localObject1);
                    paramParcel2.writeNoException();
                    return true;
                case 5002:
                    paramParcel1.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                    localObject1 = localObject2;
                    if (paramParcel1.readInt() != 0) {
                        localObject1 = DataHolder.CREATOR.createFromParcel(paramParcel1);
                    }
                    a((DataHolder) localObject1);
                    paramParcel2.writeNoException();
                    return true;
                case 5003:
                    paramParcel1.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                    b(paramParcel1.readInt(), paramParcel1.readInt());
                    paramParcel2.writeNoException();
                    return true;
                case 5004:
                    paramParcel1.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                    du();
                    paramParcel2.writeNoException();
                    return true;
            }
            paramParcel1.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
            v(paramParcel1.readInt());
            paramParcel2.writeNoException();
            return true;
        }

        private static class a
                implements ej {
            private IBinder kn;

            a(IBinder paramIBinder) {
                this.kn = paramIBinder;
            }

            /* Error */
            public void a(int paramInt, DataHolder paramDataHolder)
                    throws RemoteException {
                // Byte code:
                //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
                //   3: astore_3
                //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
                //   7: astore 4
                //   9: aload_3
                //   10: ldc 30
                //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
                //   15: aload_3
                //   16: iload_1
                //   17: invokevirtual 38	android/os/Parcel:writeInt	(I)V
                //   20: aload_2
                //   21: ifnull +46 -> 67
                //   24: aload_3
                //   25: iconst_1
                //   26: invokevirtual 38	android/os/Parcel:writeInt	(I)V
                //   29: aload_2
                //   30: aload_3
                //   31: iconst_0
                //   32: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
                //   35: aload_0
                //   36: getfield 18	com/google/android/gms/internal/ej$a$a:kn	Landroid/os/IBinder;
                //   39: sipush 5001
                //   42: aload_3
                //   43: aload 4
                //   45: iconst_0
                //   46: invokeinterface 50 5 0
                //   51: pop
                //   52: aload 4
                //   54: invokevirtual 53	android/os/Parcel:readException	()V
                //   57: aload 4
                //   59: invokevirtual 56	android/os/Parcel:recycle	()V
                //   62: aload_3
                //   63: invokevirtual 56	android/os/Parcel:recycle	()V
                //   66: return
                //   67: aload_3
                //   68: iconst_0
                //   69: invokevirtual 38	android/os/Parcel:writeInt	(I)V
                //   72: goto -37 -> 35
                //   75: astore_2
                //   76: aload 4
                //   78: invokevirtual 56	android/os/Parcel:recycle	()V
                //   81: aload_3
                //   82: invokevirtual 56	android/os/Parcel:recycle	()V
                //   85: aload_2
                //   86: athrow
                // Local variable table:
                //   start	length	slot	name	signature
                //   0	87	0	this	a
                //   0	87	1	paramInt	int
                //   0	87	2	paramDataHolder	DataHolder
                //   3	79	3	localParcel1	Parcel
                //   7	70	4	localParcel2	Parcel
                // Exception table:
                //   from	to	target	type
                //   9	20	75	finally
                //   24	35	75	finally
                //   35	57	75	finally
                //   67	72	75	finally
            }

            /* Error */
            public void a(DataHolder paramDataHolder)
                    throws RemoteException {
                // Byte code:
                //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
                //   3: astore_2
                //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
                //   7: astore_3
                //   8: aload_2
                //   9: ldc 30
                //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
                //   14: aload_1
                //   15: ifnull +43 -> 58
                //   18: aload_2
                //   19: iconst_1
                //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
                //   23: aload_1
                //   24: aload_2
                //   25: iconst_0
                //   26: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
                //   29: aload_0
                //   30: getfield 18	com/google/android/gms/internal/ej$a$a:kn	Landroid/os/IBinder;
                //   33: sipush 5002
                //   36: aload_2
                //   37: aload_3
                //   38: iconst_0
                //   39: invokeinterface 50 5 0
                //   44: pop
                //   45: aload_3
                //   46: invokevirtual 53	android/os/Parcel:readException	()V
                //   49: aload_3
                //   50: invokevirtual 56	android/os/Parcel:recycle	()V
                //   53: aload_2
                //   54: invokevirtual 56	android/os/Parcel:recycle	()V
                //   57: return
                //   58: aload_2
                //   59: iconst_0
                //   60: invokevirtual 38	android/os/Parcel:writeInt	(I)V
                //   63: goto -34 -> 29
                //   66: astore_1
                //   67: aload_3
                //   68: invokevirtual 56	android/os/Parcel:recycle	()V
                //   71: aload_2
                //   72: invokevirtual 56	android/os/Parcel:recycle	()V
                //   75: aload_1
                //   76: athrow
                // Local variable table:
                //   start	length	slot	name	signature
                //   0	77	0	this	a
                //   0	77	1	paramDataHolder	DataHolder
                //   3	69	2	localParcel1	Parcel
                //   7	61	3	localParcel2	Parcel
                // Exception table:
                //   from	to	target	type
                //   8	14	66	finally
                //   18	29	66	finally
                //   29	49	66	finally
                //   58	63	66	finally
            }

            public IBinder asBinder() {
                return this.kn;
            }

            public void b(int paramInt1, int paramInt2)
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                    localParcel1.writeInt(paramInt1);
                    localParcel1.writeInt(paramInt2);
                    this.kn.transact(5003, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public void du()
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                    this.kn.transact(5004, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public void v(int paramInt)
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                    localParcel1.writeInt(paramInt);
                    this.kn.transact(5005, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/ej.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */