package com.getjar.sdk.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.getjar.sdk.GetjarLicense.Scope;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;

public class LicensableProduct
  extends Product
  implements Parcelable
{
  public static final Parcelable.Creator<LicensableProduct> CREATOR = new Parcelable.Creator()
  {
    public LicensableProduct createFromParcel(Parcel paramAnonymousParcel)
    {
      return new LicensableProduct(paramAnonymousParcel, null);
    }
    
    public LicensableProduct[] newArray(int paramAnonymousInt)
    {
      return new LicensableProduct[paramAnonymousInt];
    }
  };
  private GetjarLicense.Scope licenseScope;
  
  private LicensableProduct(Parcel paramParcel)
  {
    super(paramParcel);
    this.licenseScope = GetjarLicense.Scope.valueOf(paramParcel.readString());
  }
  
  public LicensableProduct(String paramString1, String paramString2, String paramString3, long paramLong, GetjarLicense.Scope paramScope)
  {
    super(paramString1, paramString2, paramString3, paramLong);
    if (paramScope == null) {
      throw new IllegalArgumentException("licenseScope cannot be null");
    }
    this.licenseScope = paramScope;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public GetjarLicense.Scope getLicenseScope()
  {
    return this.licenseScope;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.licenseScope.name());
      return;
    }
    catch (Exception paramParcel)
    {
      Logger.e(Area.LICENSING.value() | Area.STORAGE.value(), paramParcel, "LicensableProduct: failed", new Object[0]);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/internal/LicensableProduct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */