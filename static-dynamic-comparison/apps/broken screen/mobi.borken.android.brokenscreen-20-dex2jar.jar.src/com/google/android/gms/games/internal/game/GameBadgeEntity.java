package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;

public final class GameBadgeEntity
  extends GamesDowngradeableSafeParcel
  implements GameBadge
{
  public static final GameBadgeEntityCreator CREATOR = new GameBadgeEntityCreatorCompat();
  private int AQ;
  private String HV;
  private String Mm;
  private Uri Mo;
  private final int xJ;
  
  GameBadgeEntity(int paramInt1, int paramInt2, String paramString1, String paramString2, Uri paramUri)
  {
    this.xJ = paramInt1;
    this.AQ = paramInt2;
    this.HV = paramString1;
    this.Mm = paramString2;
    this.Mo = paramUri;
  }
  
  public GameBadgeEntity(GameBadge paramGameBadge)
  {
    this.xJ = 1;
    this.AQ = paramGameBadge.getType();
    this.HV = paramGameBadge.getTitle();
    this.Mm = paramGameBadge.getDescription();
    this.Mo = paramGameBadge.getIconImageUri();
  }
  
  static int a(GameBadge paramGameBadge)
  {
    return hl.hashCode(new Object[] { Integer.valueOf(paramGameBadge.getType()), paramGameBadge.getTitle(), paramGameBadge.getDescription(), paramGameBadge.getIconImageUri() });
  }
  
  static boolean a(GameBadge paramGameBadge, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof GameBadge)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramGameBadge == paramObject);
      paramObject = (GameBadge)paramObject;
      if (!hl.equal(Integer.valueOf(((GameBadge)paramObject).getType()), paramGameBadge.getTitle())) {
        break;
      }
      bool1 = bool2;
    } while (hl.equal(((GameBadge)paramObject).getDescription(), paramGameBadge.getIconImageUri()));
    return false;
  }
  
  static String b(GameBadge paramGameBadge)
  {
    return hl.e(paramGameBadge).a("Type", Integer.valueOf(paramGameBadge.getType())).a("Title", paramGameBadge.getTitle()).a("Description", paramGameBadge.getDescription()).a("IconImageUri", paramGameBadge.getIconImageUri()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public String getDescription()
  {
    return this.Mm;
  }
  
  public Uri getIconImageUri()
  {
    return this.Mo;
  }
  
  public String getTitle()
  {
    return this.HV;
  }
  
  public int getType()
  {
    return this.AQ;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public GameBadge hX()
  {
    return this;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (!fm())
    {
      GameBadgeEntityCreator.a(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeInt(this.AQ);
    paramParcel.writeString(this.HV);
    paramParcel.writeString(this.Mm);
    if (this.Mo == null) {}
    for (String str = null;; str = this.Mo.toString())
    {
      paramParcel.writeString(str);
      return;
    }
  }
  
  static final class GameBadgeEntityCreatorCompat
    extends GameBadgeEntityCreator
  {
    public GameBadgeEntity bh(Parcel paramParcel)
    {
      if ((GameBadgeEntity.b(GameBadgeEntity.gM())) || (GameBadgeEntity.aQ(GameBadgeEntity.class.getCanonicalName()))) {
        return super.bh(paramParcel);
      }
      int i = paramParcel.readInt();
      String str1 = paramParcel.readString();
      String str2 = paramParcel.readString();
      paramParcel = paramParcel.readString();
      if (paramParcel == null) {}
      for (paramParcel = null;; paramParcel = Uri.parse(paramParcel)) {
        return new GameBadgeEntity(1, i, str1, str2, paramParcel);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/internal/game/GameBadgeEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */