package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface i
        extends IInterface {
    public abstract void a(c paramc, int paramInt, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
            throws RemoteException;

    public static abstract class a
            extends Binder
            implements i {
        public static i a(IBinder paramIBinder) {
            if (paramIBinder == null) {
                return null;
            }
            IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.youtube.player.internal.IServiceBroker");
            if ((localIInterface != null) && ((localIInterface instanceof i))) {
                return (i) localIInterface;
            }
            return new a(paramIBinder);
        }

        public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
                throws RemoteException {
            Bundle localBundle = null;
            switch (paramInt1) {
                default:
                    return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
                case 1598968902:
                    paramParcel2.writeString("com.google.android.youtube.player.internal.IServiceBroker");
                    return true;
            }
            paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IServiceBroker");
            Object localObject1 = paramParcel1.readStrongBinder();
            if (localObject1 == null) {
                localObject1 = null;
            }
            for (; ; ) {
                paramInt1 = paramParcel1.readInt();
                Object localObject2 = paramParcel1.readString();
                String str1 = paramParcel1.readString();
                String str2 = paramParcel1.readString();
                if (paramParcel1.readInt() != 0) {
                    localBundle = (Bundle) Bundle.CREATOR.createFromParcel(paramParcel1);
                }
                a((c) localObject1, paramInt1, (String) localObject2, str1, str2, localBundle);
                paramParcel2.writeNoException();
                return true;
                localObject2 = ((IBinder) localObject1).queryLocalInterface("com.google.android.youtube.player.internal.IConnectionCallbacks");
                if ((localObject2 != null) && ((localObject2 instanceof c))) {
                    localObject1 = (c) localObject2;
                } else {
                    localObject1 = new c.a.a((IBinder) localObject1);
                }
            }
        }

        private static final class a
                implements i {
            private IBinder a;

            a(IBinder paramIBinder) {
                this.a = paramIBinder;
            }

            /* Error */
            public final void a(c paramc, int paramInt, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
                    throws RemoteException {
                // Byte code:
                //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
                //   3: astore 7
                //   5: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
                //   8: astore 8
                //   10: aload 7
                //   12: ldc 29
                //   14: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
                //   17: aload_1
                //   18: ifnull +93 -> 111
                //   21: aload_1
                //   22: invokeinterface 39 1 0
                //   27: astore_1
                //   28: aload 7
                //   30: aload_1
                //   31: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
                //   34: aload 7
                //   36: iload_2
                //   37: invokevirtual 46	android/os/Parcel:writeInt	(I)V
                //   40: aload 7
                //   42: aload_3
                //   43: invokevirtual 49	android/os/Parcel:writeString	(Ljava/lang/String;)V
                //   46: aload 7
                //   48: aload 4
                //   50: invokevirtual 49	android/os/Parcel:writeString	(Ljava/lang/String;)V
                //   53: aload 7
                //   55: aload 5
                //   57: invokevirtual 49	android/os/Parcel:writeString	(Ljava/lang/String;)V
                //   60: aload 6
                //   62: ifnull +54 -> 116
                //   65: aload 7
                //   67: iconst_1
                //   68: invokevirtual 46	android/os/Parcel:writeInt	(I)V
                //   71: aload 6
                //   73: aload 7
                //   75: iconst_0
                //   76: invokevirtual 55	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
                //   79: aload_0
                //   80: getfield 17	com/google/android/youtube/player/internal/i$a$a:a	Landroid/os/IBinder;
                //   83: iconst_1
                //   84: aload 7
                //   86: aload 8
                //   88: iconst_0
                //   89: invokeinterface 61 5 0
                //   94: pop
                //   95: aload 8
                //   97: invokevirtual 64	android/os/Parcel:readException	()V
                //   100: aload 8
                //   102: invokevirtual 67	android/os/Parcel:recycle	()V
                //   105: aload 7
                //   107: invokevirtual 67	android/os/Parcel:recycle	()V
                //   110: return
                //   111: aconst_null
                //   112: astore_1
                //   113: goto -85 -> 28
                //   116: aload 7
                //   118: iconst_0
                //   119: invokevirtual 46	android/os/Parcel:writeInt	(I)V
                //   122: goto -43 -> 79
                //   125: astore_1
                //   126: aload 8
                //   128: invokevirtual 67	android/os/Parcel:recycle	()V
                //   131: aload 7
                //   133: invokevirtual 67	android/os/Parcel:recycle	()V
                //   136: aload_1
                //   137: athrow
                // Local variable table:
                //   start	length	slot	name	signature
                //   0	138	0	this	a
                //   0	138	1	paramc	c
                //   0	138	2	paramInt	int
                //   0	138	3	paramString1	String
                //   0	138	4	paramString2	String
                //   0	138	5	paramString3	String
                //   0	138	6	paramBundle	Bundle
                //   3	129	7	localParcel1	Parcel
                //   8	119	8	localParcel2	Parcel
                // Exception table:
                //   from	to	target	type
                //   10	17	125	finally
                //   21	28	125	finally
                //   28	60	125	finally
                //   65	79	125	finally
                //   79	100	125	finally
                //   116	122	125	finally
            }

            public final IBinder asBinder() {
                return this.a;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/youtube/player/internal/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */