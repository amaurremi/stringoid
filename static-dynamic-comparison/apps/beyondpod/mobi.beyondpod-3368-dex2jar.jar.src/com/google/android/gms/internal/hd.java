package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

public final class hd
  extends gr
  implements SafeParcelable
{
  public static final he CREATOR = new he();
  private final Bundle AM;
  private final hf AN;
  private final LatLng AO;
  private final float AP;
  private final LatLngBounds AQ;
  private final String AR;
  private final Uri AS;
  private final boolean AT;
  private final float AU;
  private final int AV;
  private final long AW;
  private final List<gx> AX;
  private final Map<gx, String> AY;
  private final TimeZone AZ;
  private Locale Ba;
  private hh Bb;
  final int kg;
  private final String uS;
  
  hd(int paramInt1, String paramString1, List<gx> paramList, Bundle paramBundle, hf paramhf, LatLng paramLatLng, float paramFloat1, LatLngBounds paramLatLngBounds, String paramString2, Uri paramUri, boolean paramBoolean, float paramFloat2, int paramInt2, long paramLong)
  {
    this.kg = paramInt1;
    this.uS = paramString1;
    this.AX = Collections.unmodifiableList(paramList);
    this.AM = paramBundle;
    this.AN = paramhf;
    this.AO = paramLatLng;
    this.AP = paramFloat1;
    this.AQ = paramLatLngBounds;
    this.AR = paramString2;
    this.AS = paramUri;
    this.AT = paramBoolean;
    this.AU = paramFloat2;
    this.AV = paramInt2;
    this.AW = paramLong;
    paramString1 = new HashMap();
    paramList = paramBundle.keySet().iterator();
    while (paramList.hasNext())
    {
      paramhf = (String)paramList.next();
      paramString1.put(gx.aq(paramhf), paramBundle.getString(paramhf));
    }
    this.AY = Collections.unmodifiableMap(paramString1);
    this.AZ = TimeZone.getTimeZone(this.AR);
    this.Ba = null;
    this.Bb = null;
  }
  
  private void ar(String paramString)
  {
    if (this.Bb != null) {
      this.Bb.a(new hd.a.a(this.uS, paramString));
    }
  }
  
  public List<gx> dW()
  {
    ar("getTypes");
    return this.AX;
  }
  
  public LatLng dX()
  {
    ar("getLatLng");
    return this.AO;
  }
  
  public float dY()
  {
    ar("getLevelNumber");
    return this.AP;
  }
  
  public LatLngBounds dZ()
  {
    ar("getViewport");
    return this.AQ;
  }
  
  public int describeContents()
  {
    he localhe = CREATOR;
    return 0;
  }
  
  public Uri ea()
  {
    ar("getWebsiteUri");
    return this.AS;
  }
  
  public boolean eb()
  {
    ar("isPermanentlyClosed");
    return this.AT;
  }
  
  public int ec()
  {
    ar("getPriceLevel");
    return this.AV;
  }
  
  public long ed()
  {
    return this.AW;
  }
  
  public Bundle ee()
  {
    return this.AM;
  }
  
  public hf ef()
  {
    return this.AN;
  }
  
  public String eg()
  {
    return this.AR;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof hd)) {
        return false;
      }
      paramObject = (hd)paramObject;
    } while ((this.uS.equals(((hd)paramObject).uS)) && (ee.equal(this.Ba, ((hd)paramObject).Ba)) && (this.AW == ((hd)paramObject).AW));
    return false;
  }
  
  public String getId()
  {
    ar("getId");
    return this.uS;
  }
  
  public float getRating()
  {
    ar("getRating");
    return this.AU;
  }
  
  public int hashCode()
  {
    return ee.hashCode(new Object[] { this.uS, this.Ba, Long.valueOf(this.AW) });
  }
  
  public String toString()
  {
    return ee.e(this).a("id", this.uS).a("localization", this.AN).a("locale", this.Ba).a("latlng", this.AO).a("levelNumber", Float.valueOf(this.AP)).a("viewport", this.AQ).a("timeZone", this.AR).a("websiteUri", this.AS).a("isPermanentlyClosed", Boolean.valueOf(this.AT)).a("priceLevel", Integer.valueOf(this.AV)).a("timestampSecs", Long.valueOf(this.AW)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    he localhe = CREATOR;
    he.a(this, paramParcel, paramInt);
  }
  
  public static final class a
    implements SafeParcelable
  {
    public static final ha CREATOR = new ha();
    private final String Bc;
    private final String Bd;
    private final int Be;
    final int kg;
    private final String mTag;
    
    a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
    {
      this.kg = paramInt1;
      this.Bc = paramString1;
      this.mTag = paramString2;
      this.Bd = paramString3;
      this.Be = paramInt2;
    }
    
    public int describeContents()
    {
      ha localha = CREATOR;
      return 0;
    }
    
    public String eh()
    {
      return this.Bc;
    }
    
    public String ei()
    {
      return this.Bd;
    }
    
    public int ej()
    {
      return this.Be;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof a)) {
          return false;
        }
        paramObject = (a)paramObject;
      } while ((this.Bc.equals(((a)paramObject).Bc)) && (ee.equal(this.mTag, ((a)paramObject).mTag)));
      return false;
    }
    
    public String getTag()
    {
      return this.mTag;
    }
    
    public int hashCode()
    {
      return ee.hashCode(new Object[] { this.Bc, this.mTag, this.Bd, Integer.valueOf(this.Be) });
    }
    
    public String toString()
    {
      return ee.e(this).a("placeId", this.Bc).a("tag", this.mTag).a("callingAppPackageName", this.Bd).a("callingAppVersionCode", Integer.valueOf(this.Be)).toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      ha localha = CREATOR;
      ha.a(this, paramParcel, paramInt);
    }
    
    public static class a
    {
      private final String Bc;
      private String Bd;
      private int Be;
      private final String mTag;
      
      public a(String paramString1, String paramString2)
      {
        this.Bc = paramString1;
        this.mTag = paramString2;
      }
      
      public a as(String paramString)
      {
        this.Bd = paramString;
        return this;
      }
      
      public a bd(int paramInt)
      {
        this.Be = paramInt;
        return this;
      }
      
      public hd.a ek()
      {
        return new hd.a(0, this.Bc, this.mTag, this.Bd, this.Be);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/hd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */