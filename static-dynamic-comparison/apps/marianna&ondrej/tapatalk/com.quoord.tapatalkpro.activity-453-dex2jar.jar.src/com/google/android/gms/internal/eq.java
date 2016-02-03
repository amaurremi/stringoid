package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.cast.ApplicationMetadata;

public abstract interface eq
        extends IInterface {
    public abstract void A(int paramInt)
            throws RemoteException;

    public abstract void B(int paramInt)
            throws RemoteException;

    public abstract void C(int paramInt)
            throws RemoteException;

    public abstract void a(ApplicationMetadata paramApplicationMetadata, String paramString1, String paramString2, boolean paramBoolean)
            throws RemoteException;

    public abstract void a(String paramString, long paramLong)
            throws RemoteException;

    public abstract void a(String paramString, long paramLong, int paramInt)
            throws RemoteException;

    public abstract void b(String paramString, double paramDouble, boolean paramBoolean)
            throws RemoteException;

    public abstract void b(String paramString, byte[] paramArrayOfByte)
            throws RemoteException;

    public abstract void d(String paramString1, String paramString2)
            throws RemoteException;

    public abstract void onApplicationDisconnected(int paramInt)
            throws RemoteException;

    public abstract void z(int paramInt)
            throws RemoteException;

    public static abstract class a
            extends Binder
            implements eq {
        public a() {
            attachInterface(this, "com.google.android.gms.cast.internal.ICastDeviceControllerListener");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
                throws RemoteException {
            boolean bool2 = false;
            boolean bool1 = false;
            switch (paramInt1) {
                default:
                    return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
                case 1598968902:
                    paramParcel2.writeString("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    return true;
                case 1:
                    paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    z(paramParcel1.readInt());
                    return true;
                case 2:
                    paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    if (paramParcel1.readInt() != 0) {
                    }
                    for (paramParcel2 = (ApplicationMetadata) ApplicationMetadata.CREATOR.createFromParcel(paramParcel1); ; paramParcel2 = null) {
                        String str1 = paramParcel1.readString();
                        String str2 = paramParcel1.readString();
                        if (paramParcel1.readInt() != 0) {
                            bool1 = true;
                        }
                        a(paramParcel2, str1, str2, bool1);
                        return true;
                    }
                case 3:
                    paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    A(paramParcel1.readInt());
                    return true;
                case 4:
                    paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    paramParcel2 = paramParcel1.readString();
                    double d = paramParcel1.readDouble();
                    bool1 = bool2;
                    if (paramParcel1.readInt() != 0) {
                        bool1 = true;
                    }
                    b(paramParcel2, d, bool1);
                    return true;
                case 5:
                    paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    d(paramParcel1.readString(), paramParcel1.readString());
                    return true;
                case 6:
                    paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    b(paramParcel1.readString(), paramParcel1.createByteArray());
                    return true;
                case 7:
                    paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    C(paramParcel1.readInt());
                    return true;
                case 8:
                    paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    B(paramParcel1.readInt());
                    return true;
                case 9:
                    paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    onApplicationDisconnected(paramParcel1.readInt());
                    return true;
                case 10:
                    paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    a(paramParcel1.readString(), paramParcel1.readLong(), paramParcel1.readInt());
                    return true;
            }
            paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
            a(paramParcel1.readString(), paramParcel1.readLong());
            return true;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/eq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */