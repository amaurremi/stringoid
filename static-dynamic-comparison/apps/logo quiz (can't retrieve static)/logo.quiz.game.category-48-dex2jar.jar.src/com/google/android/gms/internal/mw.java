package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

public class mw
  implements SafeParcelable
{
  public static final mx CREATOR = new mx();
  public final String Dv;
  public final String ahY;
  public final String ahZ;
  public final int versionCode;
  
  public mw(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.versionCode = paramInt;
    this.ahY = paramString1;
    this.ahZ = paramString2;
    this.Dv = paramString3;
  }
  
  public mw(String paramString1, Locale paramLocale, String paramString2)
  {
    this.versionCode = 0;
    this.ahY = paramString1;
    this.ahZ = paramLocale.toString();
    this.Dv = paramString2;
  }
  
  public int describeContents()
  {
    mx localmx = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof mw))) {
        return false;
      }
      paramObject = (mw)paramObject;
    } while ((this.ahZ.equals(((mw)paramObject).ahZ)) && (this.ahY.equals(((mw)paramObject).ahY)) && (m.equal(this.Dv, ((mw)paramObject).Dv)));
    return false;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { this.ahY, this.ahZ, this.Dv });
  }
  
  public String toString()
  {
    return m.h(this).a("clientPackageName", this.ahY).a("locale", this.ahZ).a("accountName", this.Dv).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    mx localmx = CREATOR;
    mx.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/mw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */