package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

import java.util.List;
import java.util.Map;

public abstract interface eg
        extends IInterface {
    public abstract void a(Map paramMap, long paramLong, String paramString, List<ef> paramList)
            throws RemoteException;

    public abstract void bR()
            throws RemoteException;

    public abstract String getVersion()
            throws RemoteException;

    public static abstract class a
            extends Binder
            implements eg {
        public static eg t(IBinder paramIBinder) {
            if (paramIBinder == null) {
                return null;
            }
            IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
            if ((localIInterface != null) && ((localIInterface instanceof eg))) {
                return (eg) localIInterface;
            }
            return new a(paramIBinder);
        }

        public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
                throws RemoteException {
            switch (paramInt1) {
                default:
                    return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
                case 1598968902:
                    paramParcel2.writeString("com.google.android.gms.analytics.internal.IAnalyticsService");
                    return true;
                case 1:
                    paramParcel1.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
                    a(paramParcel1.readHashMap(getClass().getClassLoader()), paramParcel1.readLong(), paramParcel1.readString(), paramParcel1.createTypedArrayList(ef.CREATOR));
                    paramParcel2.writeNoException();
                    return true;
                case 2:
                    paramParcel1.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
                    bR();
                    paramParcel2.writeNoException();
                    return true;
            }
            paramParcel1.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
            paramParcel1 = getVersion();
            paramParcel2.writeNoException();
            paramParcel2.writeString(paramParcel1);
            return true;
        }

        private static class a
                implements eg {
            private IBinder kn;

            a(IBinder paramIBinder) {
                this.kn = paramIBinder;
            }

            public void a(Map paramMap, long paramLong, String paramString, List<ef> paramList)
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
                    localParcel1.writeMap(paramMap);
                    localParcel1.writeLong(paramLong);
                    localParcel1.writeString(paramString);
                    localParcel1.writeTypedList(paramList);
                    this.kn.transact(1, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kn;
            }

            public void bR()
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
                    this.kn.transact(2, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public String getVersion()
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
                    this.kn.transact(3, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    String str = localParcel2.readString();
                    return str;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/eg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */