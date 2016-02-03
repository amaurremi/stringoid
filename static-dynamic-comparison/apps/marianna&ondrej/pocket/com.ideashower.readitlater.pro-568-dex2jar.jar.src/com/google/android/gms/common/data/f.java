package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class f
  extends a
{
  private static final String[] b = { "data" };
  private final Parcelable.Creator c;
  
  public f(d paramd, Parcelable.Creator paramCreator)
  {
    super(paramd);
    this.c = paramCreator;
  }
  
  public SafeParcelable b(int paramInt)
  {
    Object localObject = this.a.e("data", paramInt, 0);
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall((byte[])localObject, 0, localObject.length);
    localParcel.setDataPosition(0);
    localObject = (SafeParcelable)this.c.createFromParcel(localParcel);
    localParcel.recycle();
    return (SafeParcelable)localObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/common/data/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */