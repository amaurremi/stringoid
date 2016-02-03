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

public final class hx
  extends er
  implements SafeParcelable
{
  public static final fc PJ = new fc();
  private final String Gi;
  private final Bundle PK;
  private final hz PL;
  private final LatLng PM;
  private final float PN;
  private final LatLngBounds PO;
  private final String PP;
  private final Uri PQ;
  private final boolean PR;
  private final float PS;
  private final int PT;
  private final long PU;
  private final List<ht> PV;
  private final Map<ht, String> PW;
  private final TimeZone PX;
  private Locale PY;
  private fi PZ;
  final int qh;
  
  hx(int paramInt1, String paramString1, List<ht> paramList, Bundle paramBundle, hz paramhz, LatLng paramLatLng, float paramFloat1, LatLngBounds paramLatLngBounds, String paramString2, Uri paramUri, boolean paramBoolean, float paramFloat2, int paramInt2, long paramLong)
  {
    this.qh = paramInt1;
    this.Gi = paramString1;
    this.PV = Collections.unmodifiableList(paramList);
    this.PK = paramBundle;
    this.PL = paramhz;
    this.PM = paramLatLng;
    this.PN = paramFloat1;
    this.PO = paramLatLngBounds;
    this.PP = paramString2;
    this.PQ = paramUri;
    this.PR = paramBoolean;
    this.PS = paramFloat2;
    this.PT = paramInt2;
    this.PU = paramLong;
    paramString1 = new HashMap();
    paramList = paramBundle.keySet().iterator();
    while (paramList.hasNext())
    {
      paramhz = (String)paramList.next();
      paramString1.put(ht.aY(paramhz), paramBundle.getString(paramhz));
    }
    this.PW = Collections.unmodifiableMap(paramString1);
    this.PX = TimeZone.getTimeZone(this.PP);
    this.PY = null;
    this.PZ = null;
  }
  
  private void aZ(String paramString)
  {
    if (this.PZ != null) {
      this.PZ.a(new hx.a.a(this.Gi, paramString));
    }
  }
  
  public int describeContents()
  {
    fc localfc = PJ;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof hx)) {
        return false;
      }
      paramObject = (hx)paramObject;
    } while ((this.Gi.equals(((hx)paramObject).Gi)) && (cz.b(this.PY, ((hx)paramObject).PY)) && (this.PU == ((hx)paramObject).PU));
    return false;
  }
  
  public String getId()
  {
    aZ("getId");
    return this.Gi;
  }
  
  public float getRating()
  {
    aZ("getRating");
    return this.PS;
  }
  
  public int hashCode()
  {
    return cz.hashCode(new Object[] { this.Gi, this.PY, Long.valueOf(this.PU) });
  }
  
  public Bundle rA()
  {
    return this.PK;
  }
  
  public hz rB()
  {
    return this.PL;
  }
  
  public String rC()
  {
    return this.PP;
  }
  
  public List<ht> rs()
  {
    aZ("getTypes");
    return this.PV;
  }
  
  public LatLng rt()
  {
    aZ("getLatLng");
    return this.PM;
  }
  
  public float ru()
  {
    aZ("getLevelNumber");
    return this.PN;
  }
  
  public LatLngBounds rv()
  {
    aZ("getViewport");
    return this.PO;
  }
  
  public Uri rw()
  {
    aZ("getWebsiteUri");
    return this.PQ;
  }
  
  public boolean rx()
  {
    aZ("isPermanentlyClosed");
    return this.PR;
  }
  
  public int ry()
  {
    aZ("getPriceLevel");
    return this.PT;
  }
  
  public long rz()
  {
    return this.PU;
  }
  
  public String toString()
  {
    return cz.M(this).a("id", this.Gi).a("localization", this.PL).a("locale", this.PY).a("latlng", this.PM).a("levelNumber", Float.valueOf(this.PN)).a("viewport", this.PO).a("timeZone", this.PP).a("websiteUri", this.PQ).a("isPermanentlyClosed", Boolean.valueOf(this.PR)).a("priceLevel", Integer.valueOf(this.PT)).a("timestampSecs", Long.valueOf(this.PU)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    fc localfc = PJ;
    fc.a(this, paramParcel, paramInt);
  }
  
  public static final class a
    implements SafeParcelable
  {
    public static final fa Qa = new fa();
    private final String Nh;
    private final String Qb;
    private final int Qc;
    private final String mTag;
    final int qh;
    
    a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
    {
      this.qh = paramInt1;
      this.Nh = paramString1;
      this.mTag = paramString2;
      this.Qb = paramString3;
      this.Qc = paramInt2;
    }
    
    public int describeContents()
    {
      fa localfa = Qa;
      return 0;
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
      } while ((this.Nh.equals(((a)paramObject).Nh)) && (cz.b(this.mTag, ((a)paramObject).mTag)));
      return false;
    }
    
    public String getTag()
    {
      return this.mTag;
    }
    
    public int hashCode()
    {
      return cz.hashCode(new Object[] { this.Nh, this.mTag, this.Qb, Integer.valueOf(this.Qc) });
    }
    
    public String rD()
    {
      return this.Qb;
    }
    
    public int rE()
    {
      return this.Qc;
    }
    
    public String rp()
    {
      return this.Nh;
    }
    
    public String toString()
    {
      return cz.M(this).a("placeId", this.Nh).a("tag", this.mTag).a("callingAppPackageName", this.Qb).a("callingAppVersionCode", Integer.valueOf(this.Qc)).toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      fa localfa = Qa;
      fa.a(this, paramParcel, paramInt);
    }
    
    public static class a
    {
      private final String Nh;
      private String Qb;
      private int Qc;
      private final String mTag;
      
      public a(String paramString1, String paramString2)
      {
        this.Nh = paramString1;
        this.mTag = paramString2;
      }
      
      public a ba(String paramString)
      {
        this.Qb = paramString;
        return this;
      }
      
      public a db(int paramInt)
      {
        this.Qc = paramInt;
        return this;
      }
      
      public hx.a rF()
      {
        return new hx.a(0, this.Nh, this.mTag, this.Qb, this.Qc);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/hx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */