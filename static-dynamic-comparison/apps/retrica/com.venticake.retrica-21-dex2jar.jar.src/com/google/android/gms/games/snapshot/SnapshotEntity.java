package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.internal.GamesLog;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hk.a;
import com.google.android.gms.internal.hm;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

public final class SnapshotEntity
  implements SafeParcelable, Snapshot
{
  public static final SnapshotEntityCreator CREATOR = new SnapshotEntityCreator();
  private static final Object Ue = new Object();
  private Contents HG;
  private final SnapshotMetadataEntity Uf;
  private final int xM;
  
  SnapshotEntity(int paramInt, SnapshotMetadata paramSnapshotMetadata, Contents paramContents)
  {
    this.xM = paramInt;
    this.Uf = new SnapshotMetadataEntity(paramSnapshotMetadata);
    this.HG = paramContents;
  }
  
  public SnapshotEntity(SnapshotMetadata paramSnapshotMetadata, Contents paramContents)
  {
    this(1, paramSnapshotMetadata, paramContents);
  }
  
  private boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    hm.b(this.HG, "Must provide a previously opened Snapshot");
    synchronized (Ue)
    {
      Object localObject2 = new FileOutputStream(this.HG.getParcelFileDescriptor().getFileDescriptor());
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
      if (!hk.equal(((Snapshot)paramObject).getMetadata(), paramSnapshot.getMetadata())) {
        break;
      }
      bool1 = bool2;
    } while (hk.equal(((Snapshot)paramObject).getContents(), paramSnapshot.getContents()));
    return false;
  }
  
  static int b(Snapshot paramSnapshot)
  {
    return hk.hashCode(new Object[] { paramSnapshot.getMetadata(), paramSnapshot.getContents() });
  }
  
  static String c(Snapshot paramSnapshot)
  {
    hk.a locala = hk.e(paramSnapshot).a("Metadata", paramSnapshot.getMetadata());
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
    return this.HG;
  }
  
  public SnapshotMetadata getMetadata()
  {
    return this.Uf;
  }
  
  public int getVersionCode()
  {
    return this.xM;
  }
  
  public int hashCode()
  {
    return b(this);
  }
  
  public void iM()
  {
    this.HG.close();
    this.HG = null;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public boolean modifyBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    return a(paramInt1, paramArrayOfByte, paramInt2, paramArrayOfByte.length, false);
  }
  
  /* Error */
  public byte[] readFully()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	com/google/android/gms/games/snapshot/SnapshotEntity:HG	Lcom/google/android/gms/drive/Contents;
    //   4: ldc 52
    //   6: invokestatic 58	com/google/android/gms/internal/hm:b	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   9: pop
    //   10: getstatic 25	com/google/android/gms/games/snapshot/SnapshotEntity:Ue	Ljava/lang/Object;
    //   13: astore_1
    //   14: aload_1
    //   15: monitorenter
    //   16: new 184	java/io/FileInputStream
    //   19: dup
    //   20: aload_0
    //   21: getfield 43	com/google/android/gms/games/snapshot/SnapshotEntity:HG	Lcom/google/android/gms/drive/Contents;
    //   24: invokevirtual 66	com/google/android/gms/drive/Contents:getParcelFileDescriptor	()Landroid/os/ParcelFileDescriptor;
    //   27: invokevirtual 72	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   30: invokespecial 185	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   33: astore_2
    //   34: new 187	java/io/BufferedInputStream
    //   37: dup
    //   38: aload_2
    //   39: invokespecial 190	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   42: astore_3
    //   43: aload_2
    //   44: invokevirtual 191	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   47: lconst_0
    //   48: invokevirtual 90	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   51: pop
    //   52: aload_3
    //   53: iconst_0
    //   54: invokestatic 196	com/google/android/gms/internal/ik:a	(Ljava/io/InputStream;Z)[B
    //   57: astore_3
    //   58: aload_2
    //   59: invokevirtual 191	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   62: lconst_0
    //   63: invokevirtual 90	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   66: pop
    //   67: aload_1
    //   68: monitorexit
    //   69: aload_3
    //   70: areturn
    //   71: astore 4
    //   73: ldc 104
    //   75: ldc -58
    //   77: aload 4
    //   79: invokestatic 111	com/google/android/gms/games/internal/GamesLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   82: goto -30 -> 52
    //   85: astore_2
    //   86: aload_1
    //   87: monitorexit
    //   88: aload_2
    //   89: athrow
    //   90: astore_2
    //   91: new 200	java/lang/RuntimeException
    //   94: dup
    //   95: aload_2
    //   96: invokespecial 203	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	SnapshotEntity
    //   13	74	1	localObject1	Object
    //   33	26	2	localFileInputStream	java.io.FileInputStream
    //   85	4	2	localObject2	Object
    //   90	6	2	localIOException1	IOException
    //   42	28	3	localObject3	Object
    //   71	7	4	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   43	52	71	java/io/IOException
    //   16	43	85	finally
    //   43	52	85	finally
    //   52	67	85	finally
    //   67	69	85	finally
    //   73	82	85	finally
    //   86	88	85	finally
    //   91	100	85	finally
    //   52	67	90	java/io/IOException
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/snapshot/SnapshotEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */