package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface db
        extends IInterface {
    public abstract cz b(cx paramcx)
            throws RemoteException;

    public static abstract class a
            extends Binder
            implements db {
        public a() {
            attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
        }

        public static db s(IBinder paramIBinder) {
            if (paramIBinder == null) {
                return null;
            }
            IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
            if ((localIInterface != null) && ((localIInterface instanceof db))) {
                return (db) localIInterface;
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
                    paramParcel2.writeString("com.google.android.gms.ads.internal.request.IAdRequestService");
                    return true;
            }
            paramParcel1.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
            if (paramParcel1.readInt() != 0) {
                paramParcel1 = cx.CREATOR.f(paramParcel1);
                paramParcel1 = b(paramParcel1);
                paramParcel2.writeNoException();
                if (paramParcel1 == null) {
                    break label99;
                }
                paramParcel2.writeInt(1);
                paramParcel1.writeToParcel(paramParcel2, 1);
            }
            for (; ; ) {
                return true;
                paramParcel1 = null;
                break;
                label99:
                paramParcel2.writeInt(0);
            }
        }

        private static class a
                implements db {
            private IBinder kn;

            a(IBinder paramIBinder) {
                this.kn = paramIBinder;
            }

            public IBinder asBinder() {
                return this.kn;
            }

            public cz b(cx paramcx)
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                for (; ; ) {
                    try {
                        localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
                        if (paramcx != null) {
                            localParcel1.writeInt(1);
                            paramcx.writeToParcel(localParcel1, 0);
                            this.kn.transact(1, localParcel1, localParcel2, 0);
                            localParcel2.readException();
                            if (localParcel2.readInt() != 0) {
                                paramcx = cz.CREATOR.g(localParcel2);
                                return paramcx;
                            }
                        } else {
                            localParcel1.writeInt(0);
                            continue;
                        }
                        paramcx = null;
                    } finally {
                        localParcel2.recycle();
                        localParcel1.recycle();
                    }
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/db.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */