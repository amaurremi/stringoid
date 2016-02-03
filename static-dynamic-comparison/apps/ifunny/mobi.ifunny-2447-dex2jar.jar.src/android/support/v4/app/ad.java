package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class ad
        extends Binder
        implements ac {
    public static ac a(IBinder paramIBinder) {
        if (paramIBinder == null) {
            return null;
        }
        IInterface localIInterface = paramIBinder.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
        if ((localIInterface != null) && ((localIInterface instanceof ac))) {
            return (ac) localIInterface;
        }
        return new ae(paramIBinder);
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) {
        switch (paramInt1) {
            default:
                return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
            case 1598968902:
                paramParcel2.writeString("android.support.v4.app.INotificationSideChannel");
                return true;
            case 1:
                paramParcel1.enforceInterface("android.support.v4.app.INotificationSideChannel");
                paramParcel2 = paramParcel1.readString();
                paramInt1 = paramParcel1.readInt();
                String str = paramParcel1.readString();
                if (paramParcel1.readInt() != 0) {
                }
                for (paramParcel1 = (Notification) Notification.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null) {
                    a(paramParcel2, paramInt1, str, paramParcel1);
                    return true;
                }
            case 2:
                paramParcel1.enforceInterface("android.support.v4.app.INotificationSideChannel");
                a(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readString());
                return true;
        }
        paramParcel1.enforceInterface("android.support.v4.app.INotificationSideChannel");
        a(paramParcel1.readString());
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */