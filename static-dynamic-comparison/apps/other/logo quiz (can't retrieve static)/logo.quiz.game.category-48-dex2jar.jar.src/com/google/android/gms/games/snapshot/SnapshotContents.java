package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.internal.GamesLog;
import com.google.android.gms.internal.jy;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

public final class SnapshotContents
  implements SafeParcelable
{
  public static final SnapshotContentsCreator CREATOR = new SnapshotContentsCreator();
  private static final Object acV = new Object();
  private final int BR;
  private Contents Op;
  
  SnapshotContents(int paramInt, Contents paramContents)
  {
    this.BR = paramInt;
    this.Op = paramContents;
  }
  
  public SnapshotContents(Contents paramContents)
  {
    this(1, paramContents);
  }
  
  private boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (!isClosed()) {}
    for (boolean bool = true;; bool = false)
    {
      n.a(bool, "Must provide a previously opened SnapshotContents");
      synchronized (acV)
      {
        Object localObject2 = new FileOutputStream(this.Op.getParcelFileDescriptor().getFileDescriptor());
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
          GamesLog.a("SnapshotContents", "Failed to write snapshot data", paramArrayOfByte);
          return false;
        }
      }
    }
  }
  
  public void close()
  {
    this.Op.hJ();
    this.Op = null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Contents getContents()
  {
    return this.Op;
  }
  
  public ParcelFileDescriptor getParcelFileDescriptor()
  {
    if (!isClosed()) {}
    for (boolean bool = true;; bool = false)
    {
      n.a(bool, "Cannot mutate closed contents!");
      return this.Op.getParcelFileDescriptor();
    }
  }
  
  public int getVersionCode()
  {
    return this.BR;
  }
  
  public boolean isClosed()
  {
    return this.Op == null;
  }
  
  public boolean modifyBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    return a(paramInt1, paramArrayOfByte, paramInt2, paramArrayOfByte.length, false);
  }
  
  public byte[] readFully()
    throws IOException
  {
    boolean bool = false;
    if (!isClosed()) {
      bool = true;
    }
    n.a(bool, "Must provide a previously opened Snapshot");
    synchronized (acV)
    {
      FileInputStream localFileInputStream = new FileInputStream(this.Op.getParcelFileDescriptor().getFileDescriptor());
      Object localObject3 = new BufferedInputStream(localFileInputStream);
      try
      {
        localFileInputStream.getChannel().position(0L);
        localObject3 = jy.a((InputStream)localObject3, false);
        localFileInputStream.getChannel().position(0L);
        return (byte[])localObject3;
      }
      catch (IOException localIOException)
      {
        GamesLog.b("SnapshotContents", "Failed to read snapshot data", localIOException);
        throw localIOException;
      }
    }
  }
  
  public boolean writeBytes(byte[] paramArrayOfByte)
  {
    return a(0, paramArrayOfByte, 0, paramArrayOfByte.length, true);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    SnapshotContentsCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/snapshot/SnapshotContents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */