package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import com.google.android.gms.internal.il;

public final class SnapshotMetadataEntity
  implements SafeParcelable, SnapshotMetadata
{
  public static final SnapshotMetadataEntityCreator CREATOR = new SnapshotMetadataEntityCreator();
  private final String HV;
  private final String Mm;
  private final String NH;
  private final GameEntity Rq;
  private final Uri Ue;
  private final PlayerEntity Ui;
  private final String Uj;
  private final long Uk;
  private final long Ul;
  private final float Um;
  private final String Un;
  private final int xJ;
  
  SnapshotMetadataEntity(int paramInt, GameEntity paramGameEntity, PlayerEntity paramPlayerEntity, String paramString1, Uri paramUri, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, float paramFloat, String paramString5)
  {
    this.xJ = paramInt;
    this.Rq = paramGameEntity;
    this.Ui = paramPlayerEntity;
    this.NH = paramString1;
    this.Ue = paramUri;
    this.Uj = paramString2;
    this.Um = paramFloat;
    this.HV = paramString3;
    this.Mm = paramString4;
    this.Uk = paramLong1;
    this.Ul = paramLong2;
    this.Un = paramString5;
  }
  
  public SnapshotMetadataEntity(SnapshotMetadata paramSnapshotMetadata)
  {
    this.xJ = 3;
    this.Rq = new GameEntity(paramSnapshotMetadata.getGame());
    this.Ui = new PlayerEntity(paramSnapshotMetadata.getOwner());
    this.NH = paramSnapshotMetadata.getSnapshotId();
    this.Ue = paramSnapshotMetadata.getCoverImageUri();
    this.Uj = paramSnapshotMetadata.getCoverImageUrl();
    this.Um = paramSnapshotMetadata.getCoverImageAspectRatio();
    this.HV = paramSnapshotMetadata.getTitle();
    this.Mm = paramSnapshotMetadata.getDescription();
    this.Uk = paramSnapshotMetadata.getLastModifiedTimestamp();
    this.Ul = paramSnapshotMetadata.getPlayedTime();
    this.Un = paramSnapshotMetadata.getUniqueName();
  }
  
  static int a(SnapshotMetadata paramSnapshotMetadata)
  {
    return hl.hashCode(new Object[] { paramSnapshotMetadata.getGame(), paramSnapshotMetadata.getOwner(), paramSnapshotMetadata.getSnapshotId(), paramSnapshotMetadata.getCoverImageUri(), Float.valueOf(paramSnapshotMetadata.getCoverImageAspectRatio()), paramSnapshotMetadata.getTitle(), paramSnapshotMetadata.getDescription(), Long.valueOf(paramSnapshotMetadata.getLastModifiedTimestamp()), Long.valueOf(paramSnapshotMetadata.getPlayedTime()), paramSnapshotMetadata.getUniqueName() });
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
      if ((!hl.equal(((SnapshotMetadata)paramObject).getGame(), paramSnapshotMetadata.getGame())) || (!hl.equal(((SnapshotMetadata)paramObject).getOwner(), paramSnapshotMetadata.getOwner())) || (!hl.equal(((SnapshotMetadata)paramObject).getSnapshotId(), paramSnapshotMetadata.getSnapshotId())) || (!hl.equal(((SnapshotMetadata)paramObject).getCoverImageUri(), paramSnapshotMetadata.getCoverImageUri())) || (!hl.equal(Float.valueOf(((SnapshotMetadata)paramObject).getCoverImageAspectRatio()), Float.valueOf(paramSnapshotMetadata.getCoverImageAspectRatio()))) || (!hl.equal(((SnapshotMetadata)paramObject).getTitle(), paramSnapshotMetadata.getTitle())) || (!hl.equal(((SnapshotMetadata)paramObject).getDescription(), paramSnapshotMetadata.getDescription())) || (!hl.equal(Long.valueOf(((SnapshotMetadata)paramObject).getLastModifiedTimestamp()), Long.valueOf(paramSnapshotMetadata.getLastModifiedTimestamp()))) || (!hl.equal(Long.valueOf(((SnapshotMetadata)paramObject).getPlayedTime()), Long.valueOf(paramSnapshotMetadata.getPlayedTime())))) {
        break;
      }
      bool1 = bool2;
    } while (hl.equal(((SnapshotMetadata)paramObject).getUniqueName(), paramSnapshotMetadata.getUniqueName()));
    return false;
  }
  
  static String b(SnapshotMetadata paramSnapshotMetadata)
  {
    return hl.e(paramSnapshotMetadata).a("Game", paramSnapshotMetadata.getGame()).a("Owner", paramSnapshotMetadata.getOwner()).a("SnapshotId", paramSnapshotMetadata.getSnapshotId()).a("CoverImageUri", paramSnapshotMetadata.getCoverImageUri()).a("CoverImageUrl", paramSnapshotMetadata.getCoverImageUrl()).a("CoverImageAspectRatio", Float.valueOf(paramSnapshotMetadata.getCoverImageAspectRatio())).a("Description", paramSnapshotMetadata.getDescription()).a("LastModifiedTimestamp", Long.valueOf(paramSnapshotMetadata.getLastModifiedTimestamp())).a("PlayedTime", Long.valueOf(paramSnapshotMetadata.getPlayedTime())).a("UniqueName", paramSnapshotMetadata.getUniqueName()).toString();
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
    return this.Um;
  }
  
  public Uri getCoverImageUri()
  {
    return this.Ue;
  }
  
  public String getCoverImageUrl()
  {
    return this.Uj;
  }
  
  public String getDescription()
  {
    return this.Mm;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    il.b(this.Mm, paramCharArrayBuffer);
  }
  
  public Game getGame()
  {
    return this.Rq;
  }
  
  public long getLastModifiedTimestamp()
  {
    return this.Uk;
  }
  
  public Player getOwner()
  {
    return this.Ui;
  }
  
  public long getPlayedTime()
  {
    return this.Ul;
  }
  
  public String getSnapshotId()
  {
    return this.NH;
  }
  
  public String getTitle()
  {
    return this.HV;
  }
  
  public String getUniqueName()
  {
    return this.Un;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/snapshot/SnapshotMetadataEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */