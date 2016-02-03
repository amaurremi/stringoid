package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.b;

public final class d
  extends b
  implements Player
{
  private final a tG;
  
  public d(DataHolder paramDataHolder, int paramInt)
  {
    this(paramDataHolder, paramInt, null);
  }
  
  public d(DataHolder paramDataHolder, int paramInt, String paramString)
  {
    super(paramDataHolder, paramInt);
    this.tG = new a(paramString);
  }
  
  public int db()
  {
    return getInteger(this.tG.tM);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return PlayerEntity.a(this, paramObject);
  }
  
  public Player freeze()
  {
    return new PlayerEntity(this);
  }
  
  public String getDisplayName()
  {
    return getString(this.tG.tI);
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    a(this.tG.tI, paramCharArrayBuffer);
  }
  
  public Uri getHiResImageUri()
  {
    return L(this.tG.tK);
  }
  
  public Uri getIconImageUri()
  {
    return L(this.tG.tJ);
  }
  
  public long getLastPlayedWithTimestamp()
  {
    if (!hasColumn(this.tG.tN)) {
      return -1L;
    }
    return getLong(this.tG.tN);
  }
  
  public String getPlayerId()
  {
    return getString(this.tG.tH);
  }
  
  public long getRetrievedTimestamp()
  {
    return getLong(this.tG.tL);
  }
  
  public boolean hasHiResImage()
  {
    return getHiResImageUri() != null;
  }
  
  public boolean hasIconImage()
  {
    return getIconImageUri() != null;
  }
  
  public int hashCode()
  {
    return PlayerEntity.a(this);
  }
  
  public String toString()
  {
    return PlayerEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((PlayerEntity)freeze()).writeToParcel(paramParcel, paramInt);
  }
  
  private static final class a
  {
    public final String tH;
    public final String tI;
    public final String tJ;
    public final String tK;
    public final String tL;
    public final String tM;
    public final String tN;
    
    public a(String paramString)
    {
      if (TextUtils.isEmpty(paramString))
      {
        this.tH = "external_player_id";
        this.tI = "profile_name";
        this.tJ = "profile_icon_image_uri";
        this.tK = "profile_hi_res_image_uri";
        this.tL = "last_updated";
        this.tM = "is_in_circles";
        this.tN = "played_with_timestamp";
        return;
      }
      this.tH = (paramString + "external_player_id");
      this.tI = (paramString + "profile_name");
      this.tJ = (paramString + "profile_icon_image_uri");
      this.tK = (paramString + "profile_hi_res_image_uri");
      this.tL = (paramString + "last_updated");
      this.tM = (paramString + "is_in_circles");
      this.tN = (paramString + "played_with_timestamp");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/games/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */