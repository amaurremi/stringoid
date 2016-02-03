package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

public final class GameBadgeEntity
  extends GamesDowngradeableSafeParcel
  implements GameBadge
{
  public static final GameBadgeEntityCreator CREATOR = new GameBadgeEntityCreatorCompat();
  private final int BR;
  private int FD;
  private String No;
  private String Tg;
  private Uri UW;
  
  GameBadgeEntity(int paramInt1, int paramInt2, String paramString1, String paramString2, Uri paramUri)
  {
    this.BR = paramInt1;
    this.FD = paramInt2;
    this.No = paramString1;
    this.Tg = paramString2;
    this.UW = paramUri;
  }
  
  public GameBadgeEntity(GameBadge paramGameBadge)
  {
    this.BR = 1;
    this.FD = paramGameBadge.getType();
    this.No = paramGameBadge.getTitle();
    this.Tg = paramGameBadge.getDescription();
    this.UW = paramGameBadge.getIconImageUri();
  }
  
  static int a(GameBadge paramGameBadge)
  {
    return m.hashCode(new Object[] { Integer.valueOf(paramGameBadge.getType()), paramGameBadge.getTitle(), paramGameBadge.getDescription(), paramGameBadge.getIconImageUri() });
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
      if (!m.equal(Integer.valueOf(((GameBadge)paramObject).getType()), paramGameBadge.getTitle())) {
        break;
      }
      bool1 = bool2;
    } while (m.equal(((GameBadge)paramObject).getDescription(), paramGameBadge.getIconImageUri()));
    return false;
  }
  
  static String b(GameBadge paramGameBadge)
  {
    return m.h(paramGameBadge).a("Type", Integer.valueOf(paramGameBadge.getType())).a("Title", paramGameBadge.getTitle()).a("Description", paramGameBadge.getDescription()).a("IconImageUri", paramGameBadge.getIconImageUri()).toString();
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
    return this.Tg;
  }
  
  public Uri getIconImageUri()
  {
    return this.UW;
  }
  
  public String getTitle()
  {
    return this.No;
  }
  
  public int getType()
  {
    return this.FD;
  }
  
  public int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public GameBadge la()
  {
    return this;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (!gQ())
    {
      GameBadgeEntityCreator.a(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeInt(this.FD);
    paramParcel.writeString(this.No);
    paramParcel.writeString(this.Tg);
    if (this.UW == null) {}
    for (String str = null;; str = this.UW.toString())
    {
      paramParcel.writeString(str);
      return;
    }
  }
  
  static final class GameBadgeEntityCreatorCompat
    extends GameBadgeEntityCreator
  {
    public GameBadgeEntity ch(Parcel paramParcel)
    {
      if ((GameBadgeEntity.b(GameBadgeEntity.jQ())) || (GameBadgeEntity.bt(GameBadgeEntity.class.getCanonicalName()))) {
        return super.ch(paramParcel);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/internal/game/GameBadgeEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */