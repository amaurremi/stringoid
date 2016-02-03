package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.internal.GamesLog;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import com.google.android.gms.internal.hn;
import com.google.android.gms.internal.il;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

public final class SnapshotEntity
  implements SafeParcelable, Snapshot
{
  public static final SnapshotEntityCreator CREATOR = new SnapshotEntityCreator();
  private static final Object Ub = new Object();
  private Contents HD;
  private final SnapshotMetadataEntity Uc;
  private final int xJ;
  
  SnapshotEntity(int paramInt, SnapshotMetadata paramSnapshotMetadata, Contents paramContents)
  {
    this.xJ = paramInt;
    this.Uc = new SnapshotMetadataEntity(paramSnapshotMetadata);
    this.HD = paramContents;
  }
  
  public SnapshotEntity(SnapshotMetadata paramSnapshotMetadata, Contents paramContents)
  {
    this(1, paramSnapshotMetadata, paramContents);
  }
  
  private boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    hn.b(this.HD, "Must provide a previously opened Snapshot");
    synchronized (Ub)
    {
      Object localObject2 = new FileOutputStream(this.HD.getParcelFileDescriptor().getFileDescriptor());
      BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream((OutputStream)localObject2);
      try
      {
        localObject2 = ((FileOutputStream)localObject2).getChannel();
        ((FileChannel)localObject2).position(paramInt1);
        localBufferedOutputStream.write(paramArrayOfByte, paramInt2, paramInt3);
        if (paramBoolean) {
          ((FileChannel)localObject2).truncate(paramArrayOfByte.length);
        }
        localBufferedOutputStream.flush();
        return true;
      }
      catch (IOException paramArrayOfByte)
      {
        GamesLog.a("Snapshot", "Failed to write snapshot data", paramArrayOfByte);
        return false;
      }
    }
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
      if (!hl.equal(((Snapshot)paramObject).getMetadata(), paramSnapshot.getMetadata())) {
        break;
      }
      bool1 = bool2;
    } while (hl.equal(((Snapshot)paramObject).getContents(), paramSnapshot.getContents()));
    return false;
  }
  
  static int b(Snapshot paramSnapshot)
  {
    return hl.hashCode(new Object[] { paramSnapshot.getMetadata(), paramSnapshot.getContents() });
  }
  
  static String c(Snapshot paramSnapshot)
  {
    hl.a locala = hl.e(paramSnapshot).a("Metadata", paramSnapshot.getMetadata());
    if (paramSnapshot.getContents() != null) {}
    for (boolean bool = true;; bool = false) {
      return locala.a("HasContents", Boolean.valueOf(bool)).toString();
    }
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
    return this.HD;
  }
  
  public SnapshotMetadata getMetadata()
  {
    return this.Uc;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    return b(this);
  }
  
  public void iH()
  {
    this.HD.close();
    this.HD = null;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public boolean modifyBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    return a(paramInt1, paramArrayOfByte, paramInt2, paramArrayOfByte.length, false);
  }
  
  public byte[] readFully()
  {
    hn.b(this.HD, "Must provide a previously opened Snapshot");
    synchronized (Ub)
    {
      FileInputStream localFileInputStream = new FileInputStream(this.HD.getParcelFileDescriptor().getFileDescriptor());
      Object localObject2 = new BufferedInputStream(localFileInputStream);
      try
      {
        localFileInputStream.getChannel().position(0L);
        localObject2 = il.a((InputStream)localObject2, false);
        return (byte[])localObject2;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          GamesLog.a("Snapshot", "Failed to read snapshot data", localIOException);
        }
      }
    }
  }
  
  public String toString()
  {
    return c(this);
  }
  
  public boolean writeBytes(byte[] paramArrayOfByte)
  {
    return a(0, paramArrayOfByte, 0, paramArrayOfByte.length, true);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    SnapshotEntityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/snapshot/SnapshotEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */