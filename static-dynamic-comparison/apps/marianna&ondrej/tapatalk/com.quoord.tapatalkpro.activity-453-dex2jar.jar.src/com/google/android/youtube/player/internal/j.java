package com.google.android.youtube.player.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface j
        extends IInterface {
    public abstract void a(Bitmap paramBitmap, String paramString, boolean paramBoolean1, boolean paramBoolean2)
            throws RemoteException;

    public abstract void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
            throws RemoteException;

    public static abstract class a
            extends Binder
            implements j {
        public a() {
            attachInterface(this, "com.google.android.youtube.player.internal.IThumbnailLoaderClient");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
                throws RemoteException {
            boolean bool3 = false;
            boolean bool2 = false;
            switch (paramInt1) {
                default:
                    return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
                case 1598968902:
                    paramParcel2.writeString("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
                    return true;
                case 1:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
                    String str;
                    if (paramParcel1.readInt() != 0) {
                        localObject = (Bitmap) Bitmap.CREATOR.createFromParcel(paramParcel1);
                        str = paramParcel1.readString();
                        if (paramParcel1.readInt() == 0) {
                            break label135;
                        }
                    }
                    label135:
                    for (bool1 = true; ; bool1 = false) {
                        if (paramParcel1.readInt() != 0) {
                            bool2 = true;
                        }
                        a((Bitmap) localObject, str, bool1, bool2);
                        paramParcel2.writeNoException();
                        return true;
                        localObject = null;
                        break;
                    }
            }
            paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
            Object localObject = paramParcel1.readString();
            if (paramParcel1.readInt() != 0) {
            }
            for (boolean bool1 = true; ; bool1 = false) {
                bool2 = bool3;
                if (paramParcel1.readInt() != 0) {
                    bool2 = true;
                }
                a((String) localObject, bool1, bool2);
                paramParcel2.writeNoException();
                return true;
            }
        }

        private static final class a
                implements j {
            private IBinder a;

            a(IBinder paramIBinder) {
                this.a = paramIBinder;
            }

            public final void a(Bitmap paramBitmap, String paramString, boolean paramBoolean1, boolean paramBoolean2)
                    throws RemoteException {
                int j = 1;
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                for (; ; ) {
                    try {
                        localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
                        if (paramBitmap != null) {
                            localParcel1.writeInt(1);
                            paramBitmap.writeToParcel(localParcel1, 0);
                            localParcel1.writeString(paramString);
                            if (paramBoolean1) {
                                i = 1;
                                localParcel1.writeInt(i);
                                if (!paramBoolean2) {
                                    break label133;
                                }
                                i = j;
                                localParcel1.writeInt(i);
                                this.a.transact(1, localParcel1, localParcel2, 0);
                                localParcel2.readException();
                            }
                        } else {
                            localParcel1.writeInt(0);
                            continue;
                        }
                        i = 0;
                    } finally {
                        localParcel2.recycle();
                        localParcel1.recycle();
                    }
                    continue;
                    label133:
                    int i = 0;
                }
            }

            /* Error */
            public final void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
                    throws RemoteException {
                // Byte code:
                //   0: iconst_1
                //   1: istore 5
                //   3: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
                //   6: astore 6
                //   8: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
                //   11: astore 7
                //   13: aload 6
                //   15: ldc 29
                //   17: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
                //   20: aload 6
                //   22: aload_1
                //   23: invokevirtual 46	android/os/Parcel:writeString	(Ljava/lang/String;)V
                //   26: iload_2
                //   27: ifeq +60 -> 87
                //   30: iconst_1
                //   31: istore 4
                //   33: aload 6
                //   35: iload 4
                //   37: invokevirtual 37	android/os/Parcel:writeInt	(I)V
                //   40: iload_3
                //   41: ifeq +52 -> 93
                //   44: iload 5
                //   46: istore 4
                //   48: aload 6
                //   50: iload 4
                //   52: invokevirtual 37	android/os/Parcel:writeInt	(I)V
                //   55: aload_0
                //   56: getfield 17	com/google/android/youtube/player/internal/j$a$a:a	Landroid/os/IBinder;
                //   59: iconst_2
                //   60: aload 6
                //   62: aload 7
                //   64: iconst_0
                //   65: invokeinterface 52 5 0
                //   70: pop
                //   71: aload 7
                //   73: invokevirtual 55	android/os/Parcel:readException	()V
                //   76: aload 7
                //   78: invokevirtual 58	android/os/Parcel:recycle	()V
                //   81: aload 6
                //   83: invokevirtual 58	android/os/Parcel:recycle	()V
                //   86: return
                //   87: iconst_0
                //   88: istore 4
                //   90: goto -57 -> 33
                //   93: iconst_0
                //   94: istore 4
                //   96: goto -48 -> 48
                //   99: astore_1
                //   100: aload 7
                //   102: invokevirtual 58	android/os/Parcel:recycle	()V
                //   105: aload 6
                //   107: invokevirtual 58	android/os/Parcel:recycle	()V
                //   110: aload_1
                //   111: athrow
                // Local variable table:
                //   start	length	slot	name	signature
                //   0	112	0	this	a
                //   0	112	1	paramString	String
                //   0	112	2	paramBoolean1	boolean
                //   0	112	3	paramBoolean2	boolean
                //   31	64	4	i	int
                //   1	44	5	j	int
                //   6	100	6	localParcel1	Parcel
                //   11	90	7	localParcel2	Parcel
                // Exception table:
                //   from	to	target	type
                //   13	26	99	finally
                //   33	40	99	finally
                //   48	76	99	finally
            }

            public final IBinder asBinder() {
                return this.a;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/youtube/player/internal/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */