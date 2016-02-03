package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import java.io.IOException;

public final class SnapshotEntity
  implements SafeParcelable, Snapshot
{
  public static final SnapshotEntityCreator CREATOR = new SnapshotEntityCreator();
  private final int BR;
  private final SnapshotMetadataEntity acW;
  private final SnapshotContents acX;
  
  SnapshotEntity(int paramInt, SnapshotMetadata paramSnapshotMetadata, SnapshotContents paramSnapshotContents)
  {
    this.BR = paramInt;
    this.acW = new SnapshotMetadataEntity(paramSnapshotMetadata);
    this.acX = paramSnapshotContents;
  }
  
  public SnapshotEntity(SnapshotMetadata paramSnapshotMetadata, SnapshotContents paramSnapshotContents)
  {
    this(2, paramSnapshotMetadata, paramSnapshotContents);
  }
  
  static boolean a(Snapshot paramSnapshot, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof Snapshot)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramSnapshot == paramObject);
      paramObject = (Snapshot)paramObject;
      if (!m.equal(((Snapshot)paramObject).getMetadata(), paramSnapshot.getMetadata())) {
        break;
      }
      bool1 = bool2;
    } while (m.equal(((Snapshot)paramObject).getSnapshotContents(), paramSnapshot.getSnapshotContents()));
    return false;
  }
  
  static int b(Snapshot paramSnapshot)
  {
    return m.hashCode(new Object[] { paramSnapshot.getMetadata(), paramSnapshot.getSnapshotContents() });
  }
  
  static String c(Snapshot paramSnapshot)
  {
    m.a locala = m.h(paramSnapshot).a("Metadata", paramSnapshot.getMetadata());
    if (paramSnapshot.getSnapshotContents() != null) {}
    for (boolean bool = true;; bool = false) {
      return locala.a("HasContents", Boolean.valueOf(bool)).toString();
    }
  }
  
  private boolean isClosed()
  {
    return this.acX.isClosed();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public Snapshot freeze()
  {
    return this;
  }
  
  public Contents getContents()
  {
    if (isClosed()) {
      return null;
    }
    return this.acX.getContents();
  }
  
  public SnapshotMetadata getMetadata()
  {
    return this.acW;
  }
  
  public SnapshotContents getSnapshotContents()
  {
    if (isClosed()) {
      return null;
    }
    return this.acX;
  }
  
  public int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return b(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public boolean modifyBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    return this.acX.modifyBytes(paramInt1, paramArrayOfByte, paramInt2, paramInt3);
  }
  
  public byte[] readFully()
  {
    try
    {
      byte[] arrayOfByte = this.acX.readFully();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException);
    }
  }
  
  public String toString()
  {
    return c(this);
  }
  
  public boolean writeBytes(byte[] paramArrayOfByte)
  {
    return this.acX.writeBytes(paramArrayOfByte);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    SnapshotEntityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/snapshot/SnapshotEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */