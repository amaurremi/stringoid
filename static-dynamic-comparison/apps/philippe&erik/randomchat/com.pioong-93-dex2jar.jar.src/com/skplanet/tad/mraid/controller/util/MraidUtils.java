package com.skplanet.tad.mraid.controller.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.skplanet.tad.AdView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class MraidUtils
{
  public static final String GALLERY_DIRECTORY = "TadGallery";
  public static final String MRAID_JS_PATH = "/android_asset/tad_mraid.js";
  public static final String TAD_JS_PATH = "/android_asset/tad.js";
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public static Drawable GetDrawable(Context paramContext, String paramString)
  {
    try
    {
      paramContext = Drawable.createFromStream(paramContext.getAssets().open(paramString), null);
      return paramContext;
    }
    catch (IOException paramContext) {}
    return null;
  }
  
  public static StateListDrawable GetSelector(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = GetDrawable(paramContext, paramString1);
    localStateListDrawable.addState(new int[] { -16842919, 16842910 }, localDrawable);
    if (paramString2 != null)
    {
      paramString2 = GetDrawable(paramContext, paramString2);
      localStateListDrawable.addState(new int[] { 16842919, 16842910 }, paramString2);
    }
    if (paramString3 != null)
    {
      paramContext = GetDrawable(paramContext, paramString3);
      localStateListDrawable.addState(new int[] { -16842910 }, paramContext);
      return localStateListDrawable;
    }
    paramContext = GetDrawable(paramContext, paramString1);
    localStateListDrawable.addState(new int[] { -16842910 }, paramContext);
    return localStateListDrawable;
  }
  
  public static String asHex(MessageDigest paramMessageDigest)
  {
    int j = 0;
    paramMessageDigest = paramMessageDigest.digest();
    char[] arrayOfChar = new char[paramMessageDigest.length * 2];
    int i = 0;
    for (;;)
    {
      if (i >= paramMessageDigest.length) {
        return new String(arrayOfChar);
      }
      int k = j + 1;
      arrayOfChar[j] = a[(paramMessageDigest[i] >>> 4 & 0xF)];
      j = k + 1;
      arrayOfChar[k] = a[(paramMessageDigest[i] & 0xF)];
      i += 1;
    }
  }
  
  public static Bitmap bitmapFromJar(String paramString)
  {
    try
    {
      paramString = BitmapFactory.decodeStream(AdView.class.getResourceAsStream(paramString));
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String byteToHex(byte paramByte)
  {
    char[] arrayOfChar = new char[16];
    char[] tmp6_5 = arrayOfChar;
    tmp6_5[0] = 48;
    char[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 49;
    char[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 50;
    char[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 51;
    char[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 52;
    char[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 53;
    char[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 54;
    char[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 55;
    char[] tmp48_42 = tmp42_36;
    tmp48_42[8] = 56;
    char[] tmp54_48 = tmp48_42;
    tmp54_48[9] = 57;
    char[] tmp60_54 = tmp54_48;
    tmp60_54[10] = 97;
    char[] tmp66_60 = tmp60_54;
    tmp66_60[11] = 98;
    char[] tmp72_66 = tmp66_60;
    tmp72_66[12] = 99;
    char[] tmp78_72 = tmp72_66;
    tmp78_72[13] = 100;
    char[] tmp84_78 = tmp78_72;
    tmp84_78[14] = 101;
    char[] tmp90_84 = tmp84_78;
    tmp90_84[15] = 102;
    tmp90_84;
    return new String(new char[] { arrayOfChar[(paramByte >> 4 & 0xF)], arrayOfChar[(paramByte & 0xF)] });
  }
  
  public static String convert(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        paramString = paramString.getBytes();
        StringBuffer localStringBuffer = new StringBuffer();
        i = 0;
        if (i >= paramString.length) {
          return new String(localStringBuffer.toString().getBytes(), "ISO-8859-1");
        }
        if ((paramString[i] & 0x80) > 0) {
          localStringBuffer.append("%" + byteToHex(paramString[i]));
        } else {
          localStringBuffer.append((char)paramString[i]);
        }
      }
      catch (Exception paramString)
      {
        return null;
      }
      i += 1;
    }
  }
  
  public static boolean deleteDirectory(File paramFile)
  {
    File[] arrayOfFile;
    int i;
    if (paramFile.exists())
    {
      arrayOfFile = paramFile.listFiles();
      i = 0;
      if (i < arrayOfFile.length) {}
    }
    else
    {
      return paramFile.delete();
    }
    if (arrayOfFile[i].isDirectory()) {
      deleteDirectory(arrayOfFile[i]);
    }
    for (;;)
    {
      i += 1;
      break;
      arrayOfFile[i].delete();
    }
  }
  
  public static String getAssetName(String paramString)
  {
    int i = paramString.lastIndexOf(File.separatorChar);
    String str = paramString;
    if (i >= 0) {
      str = paramString.substring(i + 1);
    }
    return str;
  }
  
  public static String getDirFromPath(String paramString)
  {
    int i = paramString.lastIndexOf(File.separatorChar);
    String str = "/";
    if (i >= 0) {
      str = paramString.substring(0, i);
    }
    return str;
  }
  
  public static String getHttpContent(String paramString)
    throws Exception
  {
    paramString = getHttpEntity(paramString).getContent();
    byte[] arrayOfByte = new byte['Ѐ'];
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (;;)
    {
      int i = paramString.read(arrayOfByte);
      if (i <= 0) {
        return localByteArrayOutputStream.toString();
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  public static HttpEntity getHttpEntity(String paramString)
  {
    try
    {
      paramString = new DefaultHttpClient().execute(new HttpGet(paramString)).getEntity();
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String writeToDisk(InputStream paramInputStream, File paramFile)
    throws IllegalStateException, IOException
  {
    byte[] arrayOfByte = new byte['Ѐ'];
    FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i <= 0)
      {
        localFileOutputStream.flush();
        localFileOutputStream.close();
        return paramFile.getAbsolutePath();
      }
      localFileOutputStream.write(arrayOfByte, 0, i);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/mraid/controller/util/MraidUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */