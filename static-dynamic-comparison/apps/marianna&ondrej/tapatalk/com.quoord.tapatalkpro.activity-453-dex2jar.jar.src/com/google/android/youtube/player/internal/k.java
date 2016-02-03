package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface k
        extends IInterface {
    public abstract void a()
            throws RemoteException;

    public abstract void a(String paramString)
            throws RemoteException;

    public abstract void a(String paramString, int paramInt)
            throws RemoteException;

    public abstract void b()
            throws RemoteException;

    public abstract void c()
            throws RemoteException;

    public abstract void d()
            throws RemoteException;

    public static abstract class a
            extends Binder
            implements k {
        public static k a(IBinder paramIBinder) {
            if (paramIBinder == null) {
                return null;
            }
            IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService");
            if ((localIInterface != null) && ((localIInterface instanceof k))) {
                return (k) localIInterface;
            }
            return new a(paramIBinder);
        }

        public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
                throws RemoteException {
            switch (paramInt1) {
                default:
                    return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
                case 1598968902:
                    paramParcel2.writeString("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    return true;
                case 1:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    a(paramParcel1.readString());
                    paramParcel2.writeNoException();
                    return true;
                case 2:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    a(paramParcel1.readString(), paramParcel1.readInt());
                    paramParcel2.writeNoException();
                    return true;
                case 3:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    a();
                    paramParcel2.writeNoException();
                    return true;
                case 4:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    b();
                    paramParcel2.writeNoException();
                    return true;
                case 5:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    c();
                    paramParcel2.writeNoException();
                    return true;
            }
            paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService");
            d();
            paramParcel2.writeNoException();
            return true;
        }

        private static final class a
                implements k {
            private IBinder a;

            a(IBinder paramIBinder) {
                this.a = paramIBinder;
            }

            public final void a()
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    this.a.transact(3, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final void a(String paramString)
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    localParcel1.writeString(paramString);
                    this.a.transact(1, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final void a(String paramString, int paramInt)
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    localParcel1.writeString(paramString);
                    localParcel1.writeInt(paramInt);
                    this.a.transact(2, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final IBinder asBinder() {
                return this.a;
            }

            public final void b()
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    this.a.transact(4, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final void c()
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    this.a.transact(5, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final void d()
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    this.a.transact(6, localParcel1, localParcel2, 0);
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/youtube/player/internal/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */