package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.jv;

public final class SnapshotMetadataEntity
  implements SafeParcelable, SnapshotMetadata
{
  public static final SnapshotMetadataEntityCreator CREATOR = new SnapshotMetadataEntityCreator();
  private final int BR;
  private final String No;
  private final String Tg;
  private final String Wx;
  private final GameEntity aan;
  private final Uri acZ;
  private final PlayerEntity add;
  private final String ade;
  private final long adf;
  private final long adg;
  private final float adh;
  private final String adi;
  
  SnapshotMetadataEntity(int paramInt, GameEntity paramGameEntity, PlayerEntity paramPlayerEntity, String paramString1, Uri paramUri, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, float paramFloat, String paramString5)
  {
    this.BR = paramInt;
    this.aan = paramGameEntity;
    this.add = paramPlayerEntity;
    this.Wx = paramString1;
    this.acZ = paramUri;
    this.ade = paramString2;
    this.adh = paramFloat;
    this.No = paramString3;
    this.Tg = paramString4;
    this.adf = paramLong1;
    this.adg = paramLong2;
    this.adi = paramString5;
  }
  
  public SnapshotMetadataEntity(SnapshotMetadata paramSnapshotMetadata)
  {
    this.BR = 3;
    this.aan = new GameEntity(paramSnapshotMetadata.getGame());
    this.add = new PlayerEntity(paramSnapshotMetadata.getOwner());
    this.Wx = paramSnapshotMetadata.getSnapshotId();
    this.acZ = paramSnapshotMetadata.getCoverImageUri();
    this.ade = paramSnapshotMetadata.getCoverImageUrl();
    this.adh = paramSnapshotMetadata.getCoverImageAspectRatio();
    this.No = paramSnapshotMetadata.getTitle();
    this.Tg = paramSnapshotMetadata.getDescription();
    this.adf = paramSnapshotMetadata.getLastModifiedTimestamp();
    this.adg = paramSnapshotMetadata.getPlayedTime();
    this.adi = paramSnapshotMetadata.getUniqueName();
  }
  
  static int a(SnapshotMetadata paramSnapshotMetadata)
  {
    return m.hashCode(new Object[] { paramSnapshotMetadata.getGame(), paramSnapshotMetadata.getOwner(), paramSnapshotMetadata.getSnapshotId(), paramSnapshotMetadata.getCoverImageUri(), Float.valueOf(paramSnapshotMetadata.getCoverImageAspectRatio()), paramSnapshotMetadata.getTitle(), paramSnapshotMetadata.getDescription(), Long.valueOf(paramSnapshotMetadata.getLastModifiedTimestamp()), Long.valueOf(paramSnapshotMetadata.getPlayedTime()), paramSnapshotMetadata.getUniqueName() });
  }
  
  static boolean a(SnapshotMetadata paramSnapshotMetadata, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof SnapshotMetadata)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramSnapshotMetadata == paramObject);
      paramObject = (SnapshotMetadata)paramObject;
      if ((!m.equal(((SnapshotMetadata)paramObject).getGame(), paramSnapshotMetadata.getGame())) || (!m.equal(((SnapshotMetadata)paramObject).getOwner(), paramSnapshotMetadata.getOwner())) || (!m.equal(((SnapshotMetadata)paramObject).getSnapshotId(), paramSnapshotMetadata.getSnapshotId())) || (!m.equal(((SnapshotMetadata)paramObject).getCoverImageUri(), paramSnapshotMetadata.getCoverImageUri())) || (!m.equal(Float.valueOf(((SnapshotMetadata)paramObject).getCoverImageAspectRatio()), Float.valueOf(paramSnapshotMetadata.getCoverImageAspectRatio()))) || (!m.equal(((SnapshotMetadata)paramObject).getTitle(), paramSnapshotMetadata.getTitle())) || (!m.equal(((SnapshotMetadata)paramObject).getDescription(), paramSnapshotMetadata.getDescription())) || (!m.equal(Long.valueOf(((SnapshotMetadata)paramObject).getLastModifiedTimestamp()), Long.valueOf(paramSnapshotMetadata.getLastModifiedTimestamp()))) || (!m.equal(Long.valueOf(((SnapshotMetadata)paramObject).getPlayedTime()), Long.valueOf(paramSnapshotMetadata.getPlayedTime())))) {
        break;
      }
      bool1 = bool2;
    } while (m.equal(((SnapshotMetadata)paramObject).getUniqueName(), paramSnapshotMetadata.getUniqueName()));
    return false;
  }
  
  static String b(SnapshotMetadata paramSnapshotMetadata)
  {
    return m.h(paramSnapshotMetadata).a("Game", paramSnapshotMetadata.getGame()).a("Owner", paramSnapshotMetadata.getOwner()).a("SnapshotId", paramSnapshotMetadata.getSnapshotId()).a("CoverImageUri", paramSnapshotMetadata.getCoverImageUri()).a("CoverImageUrl", paramSnapshotMetadata.getCoverImageUrl()).a("CoverImageAspectRatio", Float.valueOf(paramSnapshotMetadata.getCoverImageAspectRatio())).a("Description", paramSnapshotMetadata.getDescription()).a("LastModifiedTimestamp", Long.valueOf(paramSnapshotMetadata.getLastModifiedTimestamp())).a("PlayedTime", Long.valueOf(paramSnapshotMetadata.getPlayedTime())).a("UniqueName", paramSnapshotMetadata.getUniqueName()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public SnapshotMetadata freeze()
  {
    return this;
  }
  
  public float getCoverImageAspectRatio()
  {
    return this.adh;
  }
  
  public Uri getCoverImageUri()
  {
    return this.acZ;
  }
  
  public String getCoverImageUrl()
  {
    return this.ade;
  }
  
  public String getDescription()
  {
    return this.Tg;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    jv.b(this.Tg, paramCharArrayBuffer);
  }
  
  public Game getGame()
  {
    return this.aan;
  }
  
  public long getLastModifiedTimestamp()
  {
    return this.adf;
  }
  
  public Player getOwner()
  {
    return this.add;
  }
  
  public long getPlayedTime()
  {
    return this.adg;
  }
  
  public String getSnapshotId()
  {
    return this.Wx;
  }
  
  public String getTitle()
  {
    return this.No;
  }
  
  public String getUniqueName()
  {
    return this.adi;
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
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    SnapshotMetadataEntityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/snapshot/SnapshotMetadataEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */