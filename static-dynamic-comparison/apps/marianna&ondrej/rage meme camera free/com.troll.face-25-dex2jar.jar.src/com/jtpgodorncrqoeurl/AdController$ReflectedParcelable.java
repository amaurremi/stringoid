package com.jtpgodorncrqoeurl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.lang.reflect.Field;

public class AdController$ReflectedParcelable
  implements Parcelable
{
  public AdController$ReflectedParcelable() {}
  
  protected AdController$ReflectedParcelable(Parcel paramParcel)
  {
    Field[] arrayOfField = getClass().getDeclaredFields();
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < arrayOfField.length)
        {
          localField = arrayOfField[i];
          Object localObject = localField.getType();
          if (!((Class)localObject).isEnum()) {
            continue;
          }
          localObject = ((Class)localObject).toString();
          if (((String)localObject).equals("class com.jtpgodorncrqoeurl.AdNavigationStringEnum")) {
            localField.set(this, AdNavigationStringEnum.fromString(paramParcel.readString()));
          } else if (((String)localObject).equals("class com.jtpgodorncrqoeurl.AdTransitionStringEnum")) {
            localField.set(this, AdTransitionStringEnum.fromString(paramParcel.readString()));
          }
        }
      }
      catch (IllegalArgumentException paramParcel)
      {
        Field localField;
        AdLog.printStackTrace("LBAdController", paramParcel);
        return;
        if (!(localField.get(this) instanceof Parcelable.Creator)) {
          localField.set(this, paramParcel.readValue(null));
        }
      }
      catch (IllegalAccessException paramParcel)
      {
        AdLog.printStackTrace("LBAdController", paramParcel);
        return;
      }
      i += 1;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Field[] arrayOfField = getClass().getDeclaredFields();
    paramInt = 0;
    for (;;)
    {
      try
      {
        if (paramInt < arrayOfField.length)
        {
          localObject1 = arrayOfField[paramInt];
          Object localObject2 = ((Field)localObject1).getType();
          if (!((Class)localObject2).isEnum()) {
            continue;
          }
          localObject2 = ((Class)localObject2).toString();
          if (((String)localObject2).equals("class com.jtpgodorncrqoeurl.AdNavigationStringEnum")) {
            paramParcel.writeString(((AdNavigationStringEnum)((Field)localObject1).get(this)).getText());
          } else if (((String)localObject2).equals("class com.jtpgodorncrqoeurl.AdTransitionStringEnum")) {
            paramParcel.writeString(((AdTransitionStringEnum)((Field)localObject1).get(this)).getText());
          }
        }
      }
      catch (IllegalArgumentException paramParcel)
      {
        AdLog.printStackTrace("LBAdController", paramParcel);
        return;
        Object localObject1 = ((Field)localObject1).get(this);
        if (!(localObject1 instanceof Parcelable.Creator)) {
          paramParcel.writeValue(localObject1);
        }
      }
      catch (IllegalAccessException paramParcel)
      {
        AdLog.printStackTrace("LBAdController", paramParcel);
        return;
      }
      paramInt += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/AdController$ReflectedParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */