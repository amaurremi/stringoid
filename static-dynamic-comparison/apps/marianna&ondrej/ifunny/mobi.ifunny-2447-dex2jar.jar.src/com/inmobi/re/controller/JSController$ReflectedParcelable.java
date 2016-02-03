package com.inmobi.re.controller;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.inmobi.re.controller.util.NavigationStringEnum;
import com.inmobi.re.controller.util.TransitionStringEnum;

import java.lang.reflect.Field;

public class JSController$ReflectedParcelable
        implements Parcelable {
    public JSController$ReflectedParcelable() {
    }

    protected JSController$ReflectedParcelable(Parcel paramParcel) {
        Field[] arrayOfField = getClass().getDeclaredFields();
        int i = 0;
        for (; ; ) {
            try {
                if (i < arrayOfField.length) {
                    localField = arrayOfField[i];
                    Object localObject = localField.getType();
                    if (!((Class) localObject).isEnum()) {
                        continue;
                    }
                    localObject = ((Class) localObject).toString();
                    if (((String) localObject).equals("class com.mraid.NavigationStringEnum")) {
                        localField.set(this, NavigationStringEnum.fromString(paramParcel.readString()));
                    } else if (((String) localObject).equals("class com.mraid.TransitionStringEnum")) {
                        localField.set(this, TransitionStringEnum.fromString(paramParcel.readString()));
                    }
                }
            } catch (IllegalArgumentException paramParcel) {
                Field localField;
                paramParcel.printStackTrace();
                return;
                if (!(localField.get(this) instanceof Parcelable.Creator)) {
                    localField.set(this, paramParcel.readValue(null));
                }
            } catch (IllegalAccessException paramParcel) {
                paramParcel.printStackTrace();
                return;
            }
            i += 1;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        Field[] arrayOfField = getClass().getDeclaredFields();
        paramInt = 0;
        for (; ; ) {
            try {
                if (paramInt < arrayOfField.length) {
                    localObject1 = arrayOfField[paramInt];
                    Object localObject2 = ((Field) localObject1).getType();
                    if (!((Class) localObject2).isEnum()) {
                        continue;
                    }
                    localObject2 = ((Class) localObject2).toString();
                    if (((String) localObject2).equals("class com.mraid.NavigationStringEnum")) {
                        paramParcel.writeString(((NavigationStringEnum) ((Field) localObject1).get(this)).getText());
                    } else if (((String) localObject2).equals("class com.mraid.TransitionStringEnum")) {
                        paramParcel.writeString(((TransitionStringEnum) ((Field) localObject1).get(this)).getText());
                    }
                }
            } catch (IllegalArgumentException paramParcel) {
                paramParcel.printStackTrace();
                return;
                Object localObject1 = ((Field) localObject1).get(this);
                if (!(localObject1 instanceof Parcelable.Creator)) {
                    paramParcel.writeValue(localObject1);
                }
            } catch (IllegalAccessException paramParcel) {
                paramParcel.printStackTrace();
                return;
            }
            paramInt += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/controller/JSController$ReflectedParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */