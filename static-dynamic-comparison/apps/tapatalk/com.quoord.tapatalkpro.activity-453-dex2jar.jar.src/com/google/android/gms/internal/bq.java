package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface bq
        extends IInterface {
    public abstract br m(String paramString)
            throws RemoteException;

    public static abstract class a
            extends Binder
            implements bq {
        public a() {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        }

        public static bq i(IBinder paramIBinder) {
            if (paramIBinder == null) {
                return null;
            }
            IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            if ((localIInterface != null) && ((localIInterface instanceof bq))) {
                return (bq) localIInterface;
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
                    paramParcel2.writeString("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    return true;
            }
            paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            paramParcel1 = m(paramParcel1.readString());
            paramParcel2.writeNoException();
            if (paramParcel1 != null) {
            }
            for (paramParcel1 = paramParcel1.asBinder(); ; paramParcel1 = null) {
                paramParcel2.writeStrongBinder(paramParcel1);
                return true;
            }
        }

        private static class a
                implements bq {
            private IBinder kn;

            a(IBinder paramIBinder) {
                this.kn = paramIBinder;
            }

            public IBinder asBinder() {
                return this.kn;
            }

            public br m(String paramString)
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    localParcel1.writeString(paramString);
                    this.kn.transact(1, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    paramString = br.a.j(localParcel2.readStrongBinder());
                    return paramString;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */