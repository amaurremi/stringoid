package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hl;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebImage
  implements SafeParcelable
{
  public static final Parcelable.Creator<WebImage> CREATOR = new b();
  private final Uri Fr;
  private final int ks;
  private final int kt;
  private final int xJ;
  
  WebImage(int paramInt1, Uri paramUri, int paramInt2, int paramInt3)
  {
    this.xJ = paramInt1;
    this.Fr = paramUri;
    this.ks = paramInt2;
    this.kt = paramInt3;
  }
  
  public WebImage(Uri paramUri)
    throws IllegalArgumentException
  {
    this(paramUri, 0, 0);
  }
  
  public WebImage(Uri paramUri, int paramInt1, int paramInt2)
    throws IllegalArgumentException
  {
    this(1, paramUri, paramInt1, paramInt2);
    if (paramUri == null) {
      throw new IllegalArgumentException("url cannot be null");
    }
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      throw new IllegalArgumentException("width and height must not be negative");
    }
  }
  
  public WebImage(JSONObject paramJSONObject)
    throws IllegalArgumentException
  {
    this(c(paramJSONObject), paramJSONObject.optInt("width", 0), paramJSONObject.optInt("height", 0));
  }
  
  private static Uri c(JSONObject paramJSONObject)
  {
    Uri localUri = null;
    if (paramJSONObject.has("url")) {}
    try
    {
      localUri = Uri.parse(paramJSONObject.getString("url"));
      return localUri;
    }
    catch (JSONException paramJSONObject) {}
    return null;
  }
  
  public JSONObject dU()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("url", this.Fr.toString());
      localJSONObject.put("width", this.ks);
      localJSONObject.put("height", this.kt);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof WebImage))) {
        return false;
      }
      paramObject = (WebImage)paramObject;
    } while ((hl.equal(this.Fr, ((WebImage)paramObject).Fr)) && (this.ks == ((WebImage)paramObject).ks) && (this.kt == ((WebImage)paramObject).kt));
    return false;
  }
  
  public int getHeight()
  {
    return this.kt;
  }
  
  public Uri getUrl()
  {
    return this.Fr;
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public int getWidth()
  {
    return this.ks;
  }
  
  public int hashCode()
  {
    return hl.hashCode(new Object[] { this.Fr, Integer.valueOf(this.ks), Integer.valueOf(this.kt) });
  }
  
  public String toString()
  {
    return String.format("Image %dx%d %s", new Object[] { Integer.valueOf(this.ks), Integer.valueOf(this.kt), this.Fr.toString() });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/common/images/WebImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */