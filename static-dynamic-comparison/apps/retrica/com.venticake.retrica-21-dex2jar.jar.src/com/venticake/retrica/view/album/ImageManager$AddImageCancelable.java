package com.venticake.retrica.view.album;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;

class ImageManager$AddImageCancelable
  extends BaseCancelable<Void>
{
  private final ContentResolver mCr;
  private final byte[] mJpegData;
  private final Uri mUri;
  
  public ImageManager$AddImageCancelable(Uri paramUri, ContentResolver paramContentResolver, int paramInt, Bitmap paramBitmap, byte[] paramArrayOfByte)
  {
    if (((paramBitmap == null) && (paramArrayOfByte == null)) || (paramUri == null)) {
      throw new IllegalArgumentException("source cannot be null");
    }
    this.mUri = paramUri;
    this.mCr = paramContentResolver;
    this.mJpegData = paramArrayOfByte;
  }
  
  /* Error */
  protected Void execute()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 27	com/venticake/retrica/view/album/ImageManager$AddImageCancelable:mCr	Landroid/content/ContentResolver;
    //   4: aload_0
    //   5: getfield 25	com/venticake/retrica/view/album/ImageManager$AddImageCancelable:mUri	Landroid/net/Uri;
    //   8: iconst_2
    //   9: anewarray 41	java/lang/String
    //   12: dup
    //   13: iconst_0
    //   14: ldc 43
    //   16: aastore
    //   17: dup
    //   18: iconst_1
    //   19: ldc 45
    //   21: aastore
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: invokevirtual 51	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   28: astore_1
    //   29: aload_1
    //   30: iconst_0
    //   31: invokeinterface 57 2 0
    //   36: pop
    //   37: aload_1
    //   38: invokeinterface 60 1 0
    //   43: new 62	android/content/ContentValues
    //   46: dup
    //   47: invokespecial 63	android/content/ContentValues:<init>	()V
    //   50: astore_1
    //   51: aload_1
    //   52: ldc 45
    //   54: iconst_0
    //   55: invokestatic 69	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   58: invokevirtual 73	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   61: aload_0
    //   62: getfield 27	com/venticake/retrica/view/album/ImageManager$AddImageCancelable:mCr	Landroid/content/ContentResolver;
    //   65: aload_0
    //   66: getfield 25	com/venticake/retrica/view/album/ImageManager$AddImageCancelable:mUri	Landroid/net/Uri;
    //   69: aload_1
    //   70: aconst_null
    //   71: aconst_null
    //   72: invokevirtual 77	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   75: pop
    //   76: aload_0
    //   77: getfield 27	com/venticake/retrica/view/album/ImageManager$AddImageCancelable:mCr	Landroid/content/ContentResolver;
    //   80: aload_0
    //   81: getfield 25	com/venticake/retrica/view/album/ImageManager$AddImageCancelable:mUri	Landroid/net/Uri;
    //   84: invokevirtual 81	android/content/ContentResolver:openOutputStream	(Landroid/net/Uri;)Ljava/io/OutputStream;
    //   87: astore_2
    //   88: aload_2
    //   89: ifnull +13 -> 102
    //   92: aload_2
    //   93: astore_1
    //   94: aload_2
    //   95: aload_0
    //   96: getfield 29	com/venticake/retrica/view/album/ImageManager$AddImageCancelable:mJpegData	[B
    //   99: invokevirtual 87	java/io/OutputStream:write	([B)V
    //   102: aload_2
    //   103: invokestatic 93	com/venticake/retrica/view/album/Util:closeSilently	(Ljava/io/Closeable;)V
    //   106: aconst_null
    //   107: areturn
    //   108: astore_2
    //   109: aload_1
    //   110: invokeinterface 60 1 0
    //   115: aload_2
    //   116: athrow
    //   117: astore_1
    //   118: aload_0
    //   119: getfield 27	com/venticake/retrica/view/album/ImageManager$AddImageCancelable:mCr	Landroid/content/ContentResolver;
    //   122: aload_0
    //   123: getfield 25	com/venticake/retrica/view/album/ImageManager$AddImageCancelable:mUri	Landroid/net/Uri;
    //   126: aconst_null
    //   127: aconst_null
    //   128: invokevirtual 97	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    //   131: pop
    //   132: aload_1
    //   133: athrow
    //   134: astore_3
    //   135: aconst_null
    //   136: astore_2
    //   137: aload_2
    //   138: astore_1
    //   139: ldc 99
    //   141: new 101	java/lang/StringBuilder
    //   144: dup
    //   145: ldc 103
    //   147: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   150: aload_0
    //   151: getfield 25	com/venticake/retrica/view/album/ImageManager$AddImageCancelable:mUri	Landroid/net/Uri;
    //   154: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: aload_3
    //   161: invokestatic 118	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   164: pop
    //   165: aload_2
    //   166: invokestatic 93	com/venticake/retrica/view/album/Util:closeSilently	(Ljava/io/Closeable;)V
    //   169: aconst_null
    //   170: areturn
    //   171: aload_1
    //   172: invokestatic 93	com/venticake/retrica/view/album/Util:closeSilently	(Ljava/io/Closeable;)V
    //   175: aload_2
    //   176: athrow
    //   177: astore_2
    //   178: goto -46 -> 132
    //   181: astore_2
    //   182: goto -11 -> 171
    //   185: astore_3
    //   186: goto -49 -> 137
    //   189: astore_2
    //   190: aconst_null
    //   191: astore_1
    //   192: goto -21 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	AddImageCancelable
    //   28	82	1	localObject1	Object
    //   117	16	1	localObject2	Object
    //   138	54	1	localObject3	Object
    //   87	16	2	localOutputStream	java.io.OutputStream
    //   108	8	2	localObject4	Object
    //   136	40	2	localCloseable	java.io.Closeable
    //   177	1	2	localThrowable	Throwable
    //   181	1	2	localObject5	Object
    //   189	1	2	localObject6	Object
    //   134	27	3	localIOException1	java.io.IOException
    //   185	1	3	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   29	37	108	finally
    //   0	29	117	finally
    //   37	76	117	finally
    //   102	106	117	finally
    //   109	117	117	finally
    //   165	169	117	finally
    //   171	177	117	finally
    //   76	88	134	java/io/IOException
    //   118	132	177	java/lang/Throwable
    //   94	102	181	finally
    //   139	165	181	finally
    //   94	102	185	java/io/IOException
    //   76	88	189	finally
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/ImageManager$AddImageCancelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */