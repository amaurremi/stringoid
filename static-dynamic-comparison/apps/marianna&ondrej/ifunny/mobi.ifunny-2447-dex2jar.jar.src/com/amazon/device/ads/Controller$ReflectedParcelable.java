package com.amazon.device.ads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import java.lang.reflect.Field;

public class Controller$ReflectedParcelable
        implements Parcelable {
    public static final Parcelable.Creator<ReflectedParcelable> CREATOR = new cw();

    public Controller$ReflectedParcelable() {
    }

    protected Controller$ReflectedParcelable(Parcel paramParcel) {
        Field[] arrayOfField = getClass().getDeclaredFields();
        int j = arrayOfField.length;
        int i = 0;
        for (; ; ) {
            if (i < j) {
                Field localField = arrayOfField[i];
                try {
                    if (!(localField.get(this) instanceof Parcelable.Creator)) {
                        localField.set(this, paramParcel.readValue(null));
                    }
                    i += 1;
                } catch (IllegalAccessException localIllegalAccessException) {
                    for (; ; ) {
                        dv.b(Controller.a(), "Error: Could not create object from parcel: %s", new Object[]{localIllegalAccessException.getMessage()});
                    }
                } catch (IllegalArgumentException localIllegalArgumentException) {
                    for (; ; ) {
                        dv.b(Controller.a(), "Error: Could not create object from parcel: %s", new Object[]{localIllegalArgumentException.getMessage()});
                    }
                }
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        Field[] arrayOfField = getClass().getDeclaredFields();
        int i = arrayOfField.length;
        paramInt = 0;
        for (; ; ) {
            if (paramInt < i) {
                Object localObject = arrayOfField[paramInt];
                try {
                    localObject = ((Field) localObject).get(this);
                    if (!(localObject instanceof Parcelable.Creator)) {
                        paramParcel.writeValue(localObject);
                    }
                    paramInt += 1;
                } catch (IllegalAccessException localIllegalAccessException) {
                    for (; ; ) {
                        dv.b(Controller.a(), "Error: Could not write to parcel: %s", new Object[]{localIllegalAccessException.getMessage()});
                    }
                } catch (IllegalArgumentException localIllegalArgumentException) {
                    for (; ; ) {
                        dv.b(Controller.a(), "Error: Could not write to parcel: %s", new Object[]{localIllegalArgumentException.getMessage()});
                    }
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/Controller$ReflectedParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */