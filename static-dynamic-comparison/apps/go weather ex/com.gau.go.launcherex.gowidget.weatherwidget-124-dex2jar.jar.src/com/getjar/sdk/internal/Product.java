package com.getjar.sdk.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.getjar.sdk.utilities.StringUtility;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class Product
  implements Parcelable
{
  public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator()
  {
    public Product createFromParcel(Parcel paramAnonymousParcel)
    {
      return new Product(paramAnonymousParcel);
    }
    
    public Product[] newArray(int paramAnonymousInt)
    {
      return new Product[paramAnonymousInt];
    }
  };
  public static final Pattern ITEM_ID_PATTERN = Pattern.compile("[\\w\\-_\\.]{1,100}");
  public static final String ITEM_ID_REGEX = "[\\w\\-_\\.]{1,100}";
  protected long mProductAmount;
  protected String mProductDescription = "";
  protected String mProductId = "";
  protected String mProductName = "";
  
  protected Product(Parcel paramParcel)
  {
    this.mProductId = paramParcel.readString();
    this.mProductName = paramParcel.readString();
    this.mProductDescription = paramParcel.readString();
    this.mProductAmount = paramParcel.readLong();
  }
  
  protected Product(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    validateProductId(paramString1);
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException(String.format(Locale.US, "product '%s' needs a name", new Object[] { paramString1 }));
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException(String.format(Locale.US, "product '%s' needs an amount greater than or equal to zero", new Object[] { paramString1 }));
    }
    this.mProductId = paramString1;
    this.mProductName = paramString2;
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    this.mProductDescription = paramString1;
    this.mProductAmount = paramLong;
  }
  
  public static void validateProductId(String paramString)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'theProductId' cannot be NULL or empty");
    }
    if (!ITEM_ID_PATTERN.matcher(paramString).matches()) {
      throw new IllegalArgumentException(String.format(Locale.US, "'theProductId' is too long or contains invalid characters. Product IDs must match the RegEx pattern '%1$s'.", new Object[] { "[\\w\\-_\\.]{1,100}" }));
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public long getAmount()
  {
    return this.mProductAmount;
  }
  
  public String getProductDescription()
  {
    return this.mProductDescription;
  }
  
  public String getProductId()
  {
    return this.mProductId;
  }
  
  public String getProductName()
  {
    return this.mProductName;
  }
  
  public JSONObject toJSONObject()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("amount", this.mProductAmount);
    localJSONObject.put("product_id", this.mProductId);
    localJSONObject.put("product_description", this.mProductDescription);
    localJSONObject.put("product_name", this.mProductName);
    return localJSONObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mProductId);
    paramParcel.writeString(this.mProductName);
    paramParcel.writeString(this.mProductDescription);
    paramParcel.writeLong(this.mProductAmount);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/internal/Product.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */