package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface e
        extends IInterface {
    public abstract void a(boolean paramBoolean)
            throws RemoteException;

    public static abstract class a
            extends Binder
            implements e {
        public a() {
            attachInterface(this, "com.google.android.youtube.player.internal.IOnFullscreenListener");
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
                    paramParcel2.writeString("com.google.android.youtube.player.internal.IOnFullscreenListener");
                    return true;
            }
            paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IOnFullscreenListener");
            if (paramParcel1.readInt() != 0) {
            }
            for (boolean bool = true; ; bool = false) {
                a(bool);
                paramParcel2.writeNoException();
                return true;
            }
        }

        private static final class a
                implements e {
            private IBinder a;

            a(IBinder paramIBinder) {
                this.a = paramIBinder;
            }

            /* Error */
            public final void a(boolean paramBoolean)
                    throws RemoteException {
                // Byte code:
                //   0: iconst_1
                //   1: istore_2
                //   2: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
                //   5: astore_3
                //   6: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
                //   9: astore 4
                //   11: aload_3
                //   12: ldc 29
                //   14: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
                //   17: iload_1
                //   18: ifeq +38 -> 56
                //   21: aload_3
                //   22: iload_2
                //   23: invokevirtual 37	android/os/Parcel:writeInt	(I)V
                //   26: aload_0
                //   27: getfield 17	com/google/android/youtube/player/internal/e$a$a:a	Landroid/os/IBinder;
                //   30: iconst_1
                //   31: aload_3
                //   32: aload 4
                //   34: iconst_0
                //   35: invokeinterface 43 5 0
                //   40: pop
                //   41: aload 4
                //   43: invokevirtual 46	android/os/Parcel:readException	()V
                //   46: aload 4
                //   48: invokevirtual 49	android/os/Parcel:recycle	()V
                //   51: aload_3
                //   52: invokevirtual 49	android/os/Parcel:recycle	()V
                //   55: return
                //   56: iconst_0
                //   57: istore_2
                //   58: goto -37 -> 21
                //   61: astore 5
                //   63: aload 4
                //   65: invokevirtual 49	android/os/Parcel:recycle	()V
                //   68: aload_3
                //   69: invokevirtual 49	android/os/Parcel:recycle	()V
                //   72: aload 5
                //   74: athrow
                // Local variable table:
                //   start	length	slot	name	signature
                //   0	75	0	this	a
                //   0	75	1	paramBoolean	boolean
                //   1	57	2	i	int
                //   5	64	3	localParcel1	Parcel
                //   9	55	4	localParcel2	Parcel
                //   61	12	5	localObject	Object
                // Exception table:
                //   from	to	target	type
                //   11	17	61	finally
                //   21	46	61	finally
            }

            public final IBinder asBinder() {
                return this.a;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/youtube/player/internal/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */