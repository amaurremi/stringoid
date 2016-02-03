package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.e;

public final class d
  extends e
  implements Player
{
  private final a vB;
  
  public d(DataHolder paramDataHolder, int paramInt)
  {
    this(paramDataHolder, paramInt, null);
  }
  
  public d(DataHolder paramDataHolder, int paramInt, String paramString)
  {
    super(paramDataHolder, paramInt);
    this.vB = new a(paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return PlayerEntity.a(this, paramObject);
  }
  
  public String getDisplayName()
  {
    return getString(this.vB.vD);
  }
  
  public int hashCode()
  {
    return PlayerEntity.a(this);
  }
  
  public Uri nC()
  {
    return ap(this.vB.vE);
  }
  
  public String nD()
  {
    return getString(this.vB.vF);
  }
  
  public Uri nE()
  {
    return ap(this.vB.vG);
  }
  
  public String nF()
  {
    return getString(this.vB.vH);
  }
  
  public String nS()
  {
    return getString(this.vB.vC);
  }
  
  public long nT()
  {
    return getLong(this.vB.vI);
  }
  
  public long nU()
  {
    if (!ao(this.vB.vK)) {
      return -1L;
    }
    return getLong(this.vB.vK);
  }
  
  public int nV()
  {
    return getInteger(this.vB.vJ);
  }
  
  public Player nW()
  {
    return new PlayerEntity(this);
  }
  
  public String toString()
  {
    return PlayerEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((PlayerEntity)nW()).writeToParcel(paramParcel, paramInt);
  }
  
  private static final class a
  {
    public final String vC;
    public final String vD;
    public final String vE;
    public final String vF;
    public final String vG;
    public final String vH;
    public final String vI;
    public final String vJ;
    public final String vK;
    
    public a(String paramString)
    {
      if (TextUtils.isEmpty(paramString))
      {
        this.vC = "external_player_id";
        this.vD = "profile_name";
        this.vE = "profile_icon_image_uri";
        this.vF = "profile_icon_image_url";
        this.vG = "profile_hi_res_image_uri";
        this.vH = "profile_hi_res_image_url";
        this.vI = "last_updated";
        this.vJ = "is_in_circles";
        this.vK = "played_with_timestamp";
        return;
      }
      this.vC = (paramString + "external_player_id");
      this.vD = (paramString + "profile_name");
      this.vE = (paramString + "profile_icon_image_uri");
      this.vF = (paramString + "profile_icon_image_url");
      this.vG = (paramString + "profile_hi_res_image_uri");
      this.vH = (paramString + "profile_hi_res_image_url");
      this.vI = (paramString + "last_updated");
      this.vJ = (paramString + "is_in_circles");
      this.vK = (paramString + "played_with_timestamp");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/games/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */