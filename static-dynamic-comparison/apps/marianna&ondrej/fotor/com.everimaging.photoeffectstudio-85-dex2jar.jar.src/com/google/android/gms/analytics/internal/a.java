package com.google.android.gms.analytics.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

import java.util.List;
import java.util.Map;

public abstract interface a
        extends IInterface {
    public abstract void a()
            throws RemoteException;

    public abstract void a(Map paramMap, long paramLong, String paramString, List<Command> paramList)
            throws RemoteException;

    public static abstract class a
            extends Binder
            implements a {
        public static a a(IBinder paramIBinder) {
            if (paramIBinder == null) {
                return null;
            }
            IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
            if ((localIInterface != null) && ((localIInterface instanceof a))) {
                return (a) localIInterface;
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
                    a(paramParcel1.readHashMap(getClass().getClassLoader()), paramParcel1.readLong(), paramParcel1.readString(), paramParcel1.createTypedArrayList(Command.CREATOR));
                    paramParcel2.writeNoException();
                    return true;
            }
            paramParcel1.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
            a();
            paramParcel2.writeNoException();
            return true;
        }

        private static class a
                implements a {
            private IBinder a;

            a(IBinder paramIBinder) {
                this.a = paramIBinder;
            }

            public void a()
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
                    this.a.transact(2, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public void a(Map paramMap, long paramLong, String paramString, List<Command> paramList)
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
                    localParcel1.writeMap(paramMap);
                    localParcel1.writeLong(paramLong);
                    localParcel1.writeString(paramString);
                    localParcel1.writeTypedList(paramList);
                    this.a.transact(1, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public IBinder asBinder() {
                return this.a;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/google/android/gms/analytics/internal/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */