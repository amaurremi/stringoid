package com.venticake.retrica.view.album;

import android.graphics.Bitmap;
import android.net.Uri;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class Utils
{
  private static long[] CRCTable = new long['Ā'];
  private static final long INITIALCRC = -1L;
  private static final long POLY64REV = -7661587058870466123L;
  private static boolean init = false;
  
  public static void Copy(File paramFile1, File paramFile2)
  {
    paramFile1 = new FileInputStream(paramFile1);
    paramFile2 = new FileOutputStream(paramFile2);
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int i = paramFile1.read(arrayOfByte);
      if (i <= 0)
      {
        paramFile1.close();
        paramFile2.close();
        return;
      }
      paramFile2.write(arrayOfByte, 0, i);
    }
  }
  
  public static final String Crc64(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    long l = Crc64Long(paramString);
    int i = (int)l;
    return Integer.toHexString((int)(l >> 32) & 0xFFFFFFFF) + Integer.toHexString(i & 0xFFFFFFFF);
  }
  
  public static final long Crc64Long(String paramString)
  {
    int k = 0;
    long l2;
    if ((paramString == null) || (paramString.length() == 0))
    {
      l2 = 0L;
      return l2;
    }
    int i;
    if (!init) {
      i = 0;
    }
    int j;
    for (;;)
    {
      if (i >= 256)
      {
        init = true;
        j = paramString.length();
        l1 = -1L;
        i = k;
        for (;;)
        {
          l2 = l1;
          if (i >= j) {
            break;
          }
          k = paramString.charAt(i);
          l2 = CRCTable[((k ^ (int)l1) & 0xFF)];
          i += 1;
          l1 = l2 ^ l1 >> 8;
        }
      }
      l1 = i;
      j = 0;
      if (j < 8) {
        break label123;
      }
      CRCTable[i] = l1;
      i += 1;
    }
    label123:
    if (((int)l1 & 0x1) != 0) {}
    for (long l1 = l1 >> 1 ^ 0x95AC9329AC4BC9B5;; l1 >>= 1)
    {
      j += 1;
      break;
    }
  }
  
  public static String getBucketNameFromUri(Uri paramUri)
  {
    String str = "";
    Object localObject;
    if ("" != null)
    {
      localObject = str;
      if ("".length() != 0) {}
    }
    else
    {
      localObject = paramUri.getPathSegments();
      paramUri = str;
      if (((List)localObject).size() > 1) {
        paramUri = (String)((List)localObject).get(((List)localObject).size() - 2);
      }
      localObject = paramUri;
      if (paramUri == null) {
        localObject = "";
      }
    }
    return (String)localObject;
  }
  
  public static final String readUTF(DataInputStream paramDataInputStream)
  {
    String str = paramDataInputStream.readUTF();
    paramDataInputStream = str;
    if (str.length() == 0) {
      paramDataInputStream = null;
    }
    return paramDataInputStream;
  }
  
  public static final Bitmap resizeBitmap(Bitmap paramBitmap, int paramInt)
  {
    int j = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    int i = 0;
    if (j > k)
    {
      if (j <= paramInt) {
        break label77;
      }
      k = paramInt * k / j;
      i = 1;
      j = paramInt;
    }
    for (;;)
    {
      Bitmap localBitmap = paramBitmap;
      if (i != 0) {
        localBitmap = Bitmap.createScaledBitmap(paramBitmap, j, k, true);
      }
      return localBitmap;
      if (k > paramInt)
      {
        j = paramInt * j / k;
        i = 1;
        k = paramInt;
      }
      else
      {
        label77:
        j = paramInt;
        k = paramInt;
      }
    }
  }
  
  public static final void writeUTF(DataOutputStream paramDataOutputStream, String paramString)
  {
    if (paramString == null)
    {
      paramDataOutputStream.writeUTF(new String());
      return;
    }
    paramDataOutputStream.writeUTF(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */