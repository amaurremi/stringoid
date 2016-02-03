package com.pocket.billing.google;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.pocket.billing.d;
import org.json.JSONObject;

public class GooglePremiumProduct
  extends d
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
  {
    public GooglePremiumProduct a(Parcel paramAnonymousParcel)
    {
      return new GooglePremiumProduct(paramAnonymousParcel);
    }
    
    public GooglePremiumProduct[] a(int paramAnonymousInt)
    {
      return new GooglePremiumProduct[paramAnonymousInt];
    }
  };
  private final String a;
  private final String b;
  private final String c;
  private final String d;
  private final String e;
  private String f;
  
  public GooglePremiumProduct(Parcel paramParcel)
  {
    this(paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString());
    b(paramParcel.readString());
  }
  
  private GooglePremiumProduct(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    super(paramString4, paramString7, paramString8);
    this.d = paramString5;
    this.e = paramString6;
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  protected static GooglePremiumProduct a(String paramString)
  {
    JSONObject localJSONObject = new JSONObject(paramString);
    return new GooglePremiumProduct(paramString, localJSONObject.optString("productId"), localJSONObject.optString("type"), localJSONObject.optString("price"), localJSONObject.optString("price_amount_micros"), localJSONObject.optString("price_currency_code"), localJSONObject.optString("title"), localJSONObject.optString("description"));
  }
  
  public void b(String paramString)
  {
    this.f = paramString;
  }
  
  public boolean d()
  {
    return this.f != null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    return this.f;
  }
  
  public String f()
  {
    return this.b;
  }
  
  public String g()
  {
    return this.c;
  }
  
  public String h()
  {
    return this.d;
  }
  
  public String i()
  {
    return this.e;
  }
  
  public String j()
  {
    return this.a;
  }
  
  public String toString()
  {
    return this.a;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(a());
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(b());
    paramParcel.writeString(c());
    paramParcel.writeString(this.f);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/billing/google/GooglePremiumProduct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */