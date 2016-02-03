package com.google.android.gms.internal;

import android.content.Context;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

public class id
  implements SafeParcelable
{
  public static final fj Qt = new fj();
  public final String Qu;
  public final String Qv;
  public final int versionCode;
  
  public id(int paramInt, String paramString1, String paramString2)
  {
    this.versionCode = paramInt;
    this.Qu = paramString1;
    this.Qv = paramString2;
  }
  
  public id(Context paramContext, Locale paramLocale)
  {
    this.versionCode = 0;
    this.Qu = paramContext.getPackageName();
    this.Qv = paramLocale.toString();
  }
  
  public int describeContents()
  {
    fj localfj = Qt;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof id))) {
        return false;
      }
      paramObject = (id)paramObject;
    } while ((this.Qv.equals(((id)paramObject).Qv)) && (this.Qu.equals(((id)paramObject).Qu)));
    return false;
  }
  
  public int hashCode()
  {
    return cz.hashCode(new Object[] { this.Qu, this.Qv });
  }
  
  public String toString()
  {
    return cz.M(this).a("clientPackageName", this.Qu).a("locale", this.Qv).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    fj localfj = Qt;
    fj.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/id.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */