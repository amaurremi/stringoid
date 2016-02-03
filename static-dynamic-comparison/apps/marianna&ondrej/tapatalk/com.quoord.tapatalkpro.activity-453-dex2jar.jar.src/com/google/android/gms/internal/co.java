package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface co
        extends IInterface {
    public abstract void a(cn paramcn)
            throws RemoteException;

    public static abstract class a
            extends Binder
            implements co {
        public a() {
            attachInterface(this, "com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
        }

        public static co p(IBinder paramIBinder) {
            if (paramIBinder == null) {
                return null;
            }
            IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
            if ((localIInterface != null) && ((localIInterface instanceof co))) {
                return (co) localIInterface;
            }
            return new a(paramIBinder);
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
                throws RemoteException {
            switch (paramInt1) {
                default:
                    return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
                case 1598968902:
                    paramParcel2.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
                    return true;
            }
            paramParcel1.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
            a(cn.a.o(paramParcel1.readStrongBinder()));
            paramParcel2.writeNoException();
            return true;
        }

        private static class a
                implements co {
            private IBinder kn;

            a(IBinder paramIBinder) {
                this.kn = paramIBinder;
            }

            /* Error */
            public void a(cn paramcn)
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
                //   15: ifnull +42 -> 57
                //   18: aload_1
                //   19: invokeinterface 40 1 0
                //   24: astore_1
                //   25: aload_2
                //   26: aload_1
                //   27: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
                //   30: aload_0
                //   31: getfield 18	com/google/android/gms/internal/co$a$a:kn	Landroid/os/IBinder;
                //   34: iconst_1
                //   35: aload_2
                //   36: aload_3
                //   37: iconst_0
                //   38: invokeinterface 49 5 0
                //   43: pop
                //   44: aload_3
                //   45: invokevirtual 52	android/os/Parcel:readException	()V
                //   48: aload_3
                //   49: invokevirtual 55	android/os/Parcel:recycle	()V
                //   52: aload_2
                //   53: invokevirtual 55	android/os/Parcel:recycle	()V
                //   56: return
                //   57: aconst_null
                //   58: astore_1
                //   59: goto -34 -> 25
                //   62: astore_1
                //   63: aload_3
                //   64: invokevirtual 55	android/os/Parcel:recycle	()V
                //   67: aload_2
                //   68: invokevirtual 55	android/os/Parcel:recycle	()V
                //   71: aload_1
                //   72: athrow
                // Local variable table:
                //   start	length	slot	name	signature
                //   0	73	0	this	a
                //   0	73	1	paramcn	cn
                //   3	65	2	localParcel1	Parcel
                //   7	57	3	localParcel2	Parcel
                // Exception table:
                //   from	to	target	type
                //   8	14	62	finally
                //   18	25	62	finally
                //   25	48	62	finally
            }

            public IBinder asBinder() {
                return this.kn;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/co.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */