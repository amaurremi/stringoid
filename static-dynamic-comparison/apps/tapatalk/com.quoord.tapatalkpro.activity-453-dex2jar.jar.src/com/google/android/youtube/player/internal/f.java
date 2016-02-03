package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface f
        extends IInterface {
    public abstract void a()
            throws RemoteException;

    public abstract void a(int paramInt)
            throws RemoteException;

    public abstract void a(boolean paramBoolean)
            throws RemoteException;

    public abstract void b()
            throws RemoteException;

    public abstract void c()
            throws RemoteException;

    public static abstract class a
            extends Binder
            implements f {
        public a() {
            attachInterface(this, "com.google.android.youtube.player.internal.IPlaybackEventListener");
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
                    paramParcel2.writeString("com.google.android.youtube.player.internal.IPlaybackEventListener");
                    return true;
                case 1:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IPlaybackEventListener");
                    a();
                    paramParcel2.writeNoException();
                    return true;
                case 2:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IPlaybackEventListener");
                    b();
                    paramParcel2.writeNoException();
                    return true;
                case 3:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IPlaybackEventListener");
                    c();
                    paramParcel2.writeNoException();
                    return true;
                case 4:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IPlaybackEventListener");
                    if (paramParcel1.readInt() != 0) {
                    }
                    for (boolean bool = true; ; bool = false) {
                        a(bool);
                        paramParcel2.writeNoException();
                        return true;
                    }
            }
            paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IPlaybackEventListener");
            a(paramParcel1.readInt());
            paramParcel2.writeNoException();
            return true;
        }

        private static final class a
                implements f {
            private IBinder a;

            a(IBinder paramIBinder) {
                this.a = paramIBinder;
            }

            public final void a()
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IPlaybackEventListener");
                    this.a.transact(1, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final void a(int paramInt)
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IPlaybackEventListener");
                    localParcel1.writeInt(paramInt);
                    this.a.transact(5, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final void a(boolean paramBoolean)
                    throws RemoteException {
                int i = 0;
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IPlaybackEventListener");
                    if (paramBoolean) {
                        i = 1;
                    }
                    localParcel1.writeInt(i);
                    this.a.transact(4, localParcel1, localParcel2, 0);
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
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IPlaybackEventListener");
                    this.a.transact(2, localParcel1, localParcel2, 0);
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
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IPlaybackEventListener");
                    this.a.transact(3, localParcel1, localParcel2, 0);
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/youtube/player/internal/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */