package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface gz
        extends IInterface {
    public abstract void onAddGeofencesResult(int paramInt, String[] paramArrayOfString)
            throws RemoteException;

    public abstract void onRemoveGeofencesByPendingIntentResult(int paramInt, PendingIntent paramPendingIntent)
            throws RemoteException;

    public abstract void onRemoveGeofencesByRequestIdsResult(int paramInt, String[] paramArrayOfString)
            throws RemoteException;

    public static abstract class a
            extends Binder
            implements gz {
        public a() {
            attachInterface(this, "com.google.android.gms.location.internal.IGeofencerCallbacks");
        }

        public static gz V(IBinder paramIBinder) {
            if (paramIBinder == null) {
                return null;
            }
            IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
            if ((localIInterface != null) && ((localIInterface instanceof gz))) {
                return (gz) localIInterface;
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
                    paramParcel2.writeString("com.google.android.gms.location.internal.IGeofencerCallbacks");
                    return true;
                case 1:
                    paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
                    onAddGeofencesResult(paramParcel1.readInt(), paramParcel1.createStringArray());
                    paramParcel2.writeNoException();
                    return true;
                case 2:
                    paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
                    onRemoveGeofencesByRequestIdsResult(paramParcel1.readInt(), paramParcel1.createStringArray());
                    paramParcel2.writeNoException();
                    return true;
            }
            paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
            paramInt1 = paramParcel1.readInt();
            if (paramParcel1.readInt() != 0) {
            }
            for (paramParcel1 = (PendingIntent) PendingIntent.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null) {
                onRemoveGeofencesByPendingIntentResult(paramInt1, paramParcel1);
                paramParcel2.writeNoException();
                return true;
            }
        }

        private static class a
                implements gz {
            private IBinder kn;

            a(IBinder paramIBinder) {
                this.kn = paramIBinder;
            }

            public IBinder asBinder() {
                return this.kn;
            }

            public void onAddGeofencesResult(int paramInt, String[] paramArrayOfString)
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
                    localParcel1.writeInt(paramInt);
                    localParcel1.writeStringArray(paramArrayOfString);
                    this.kn.transact(1, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            /* Error */
            public void onRemoveGeofencesByPendingIntentResult(int paramInt, PendingIntent paramPendingIntent)
                    throws RemoteException {
                // Byte code:
                //   0: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
                //   3: astore_3
                //   4: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
                //   7: astore 4
                //   9: aload_3
                //   10: ldc 33
                //   12: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
                //   15: aload_3
                //   16: iload_1
                //   17: invokevirtual 41	android/os/Parcel:writeInt	(I)V
                //   20: aload_2
                //   21: ifnull +44 -> 65
                //   24: aload_3
                //   25: iconst_1
                //   26: invokevirtual 41	android/os/Parcel:writeInt	(I)V
                //   29: aload_2
                //   30: aload_3
                //   31: iconst_0
                //   32: invokevirtual 66	android/app/PendingIntent:writeToParcel	(Landroid/os/Parcel;I)V
                //   35: aload_0
                //   36: getfield 18	com/google/android/gms/internal/gz$a$a:kn	Landroid/os/IBinder;
                //   39: iconst_3
                //   40: aload_3
                //   41: aload 4
                //   43: iconst_0
                //   44: invokeinterface 51 5 0
                //   49: pop
                //   50: aload 4
                //   52: invokevirtual 54	android/os/Parcel:readException	()V
                //   55: aload 4
                //   57: invokevirtual 57	android/os/Parcel:recycle	()V
                //   60: aload_3
                //   61: invokevirtual 57	android/os/Parcel:recycle	()V
                //   64: return
                //   65: aload_3
                //   66: iconst_0
                //   67: invokevirtual 41	android/os/Parcel:writeInt	(I)V
                //   70: goto -35 -> 35
                //   73: astore_2
                //   74: aload 4
                //   76: invokevirtual 57	android/os/Parcel:recycle	()V
                //   79: aload_3
                //   80: invokevirtual 57	android/os/Parcel:recycle	()V
                //   83: aload_2
                //   84: athrow
                // Local variable table:
                //   start	length	slot	name	signature
                //   0	85	0	this	a
                //   0	85	1	paramInt	int
                //   0	85	2	paramPendingIntent	PendingIntent
                //   3	77	3	localParcel1	Parcel
                //   7	68	4	localParcel2	Parcel
                // Exception table:
                //   from	to	target	type
                //   9	20	73	finally
                //   24	35	73	finally
                //   35	55	73	finally
                //   65	70	73	finally
            }

            public void onRemoveGeofencesByRequestIdsResult(int paramInt, String[] paramArrayOfString)
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
                    localParcel1.writeInt(paramInt);
                    localParcel1.writeStringArray(paramArrayOfString);
                    this.kn.transact(2, localParcel1, localParcel2, 0);
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/gz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */