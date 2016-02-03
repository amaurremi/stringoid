package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface l
        extends IInterface {
    public abstract IBinder a()
            throws RemoteException;

    public abstract k a(j paramj)
            throws RemoteException;

    public abstract void a(boolean paramBoolean)
            throws RemoteException;

    public static abstract class a
            extends Binder
            implements l {
        public static l a(IBinder paramIBinder) {
            if (paramIBinder == null) {
                return null;
            }
            IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.youtube.player.internal.IYouTubeService");
            if ((localIInterface != null) && ((localIInterface instanceof l))) {
                return (l) localIInterface;
            }
            return new a(paramIBinder);
        }

        public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
                throws RemoteException {
            Object localObject1 = null;
            switch (paramInt1) {
                default:
                    return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
                case 1598968902:
                    paramParcel2.writeString("com.google.android.youtube.player.internal.IYouTubeService");
                    return true;
                case 1:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IYouTubeService");
                    paramParcel1 = a();
                    paramParcel2.writeNoException();
                    paramParcel2.writeStrongBinder(paramParcel1);
                    return true;
                case 2:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IYouTubeService");
                    paramParcel1 = paramParcel1.readStrongBinder();
                    if (paramParcel1 == null) {
                        paramParcel1 = null;
                    }
                    for (; ; ) {
                        Object localObject2 = a(paramParcel1);
                        paramParcel2.writeNoException();
                        paramParcel1 = (Parcel) localObject1;
                        if (localObject2 != null) {
                            paramParcel1 = ((k) localObject2).asBinder();
                        }
                        paramParcel2.writeStrongBinder(paramParcel1);
                        return true;
                        localObject2 = paramParcel1.queryLocalInterface("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
                        if ((localObject2 != null) && ((localObject2 instanceof j))) {
                            paramParcel1 = (j) localObject2;
                        } else {
                            paramParcel1 = new j.a.a(paramParcel1);
                        }
                    }
            }
            paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IYouTubeService");
            if (paramParcel1.readInt() != 0) {
            }
            for (boolean bool = true; ; bool = false) {
                a(bool);
                paramParcel2.writeNoException();
                return true;
            }
        }

        private static final class a
                implements l {
            private IBinder a;

            a(IBinder paramIBinder) {
                this.a = paramIBinder;
            }

            public final IBinder a()
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IYouTubeService");
                    this.a.transact(1, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    IBinder localIBinder = localParcel2.readStrongBinder();
                    return localIBinder;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            /* Error */
            public final k a(j paramj)
                    throws RemoteException {
                // Byte code:
                //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
                //   3: astore_2
                //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
                //   7: astore_3
                //   8: aload_2
                //   9: ldc 29
                //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
                //   14: aload_1
                //   15: ifnull +51 -> 66
                //   18: aload_1
                //   19: invokeinterface 55 1 0
                //   24: astore_1
                //   25: aload_2
                //   26: aload_1
                //   27: invokevirtual 58	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
                //   30: aload_0
                //   31: getfield 17	com/google/android/youtube/player/internal/l$a$a:a	Landroid/os/IBinder;
                //   34: iconst_2
                //   35: aload_2
                //   36: aload_3
                //   37: iconst_0
                //   38: invokeinterface 39 5 0
                //   43: pop
                //   44: aload_3
                //   45: invokevirtual 42	android/os/Parcel:readException	()V
                //   48: aload_3
                //   49: invokevirtual 45	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
                //   52: invokestatic 63	com/google/android/youtube/player/internal/k$a:a	(Landroid/os/IBinder;)Lcom/google/android/youtube/player/internal/k;
                //   55: astore_1
                //   56: aload_3
                //   57: invokevirtual 48	android/os/Parcel:recycle	()V
                //   60: aload_2
                //   61: invokevirtual 48	android/os/Parcel:recycle	()V
                //   64: aload_1
                //   65: areturn
                //   66: aconst_null
                //   67: astore_1
                //   68: goto -43 -> 25
                //   71: astore_1
                //   72: aload_3
                //   73: invokevirtual 48	android/os/Parcel:recycle	()V
                //   76: aload_2
                //   77: invokevirtual 48	android/os/Parcel:recycle	()V
                //   80: aload_1
                //   81: athrow
                // Local variable table:
                //   start	length	slot	name	signature
                //   0	82	0	this	a
                //   0	82	1	paramj	j
                //   3	74	2	localParcel1	Parcel
                //   7	66	3	localParcel2	Parcel
                // Exception table:
                //   from	to	target	type
                //   8	14	71	finally
                //   18	25	71	finally
                //   25	56	71	finally
            }

            public final void a(boolean paramBoolean)
                    throws RemoteException {
                int i = 0;
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IYouTubeService");
                    if (paramBoolean) {
                        i = 1;
                    }
                    localParcel1.writeInt(i);
                    this.a.transact(3, localParcel1, localParcel2, 0);
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
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/youtube/player/internal/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */