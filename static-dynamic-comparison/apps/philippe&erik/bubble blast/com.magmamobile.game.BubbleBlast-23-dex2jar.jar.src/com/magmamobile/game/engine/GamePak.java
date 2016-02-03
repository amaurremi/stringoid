package com.magmamobile.game.engine;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.SoundPool;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

public final class GamePak
{
  private static final String ASSET = "K.WAV";
  private static final String FIELD1 = "OFFSETS";
  private static final String FIELD2 = "SIZES";
  private static final String FILE = ".K";
  private static String _asset;
  protected static Object[] _cache;
  private static String _defaultAsset;
  private static int[] _defaultOffsets;
  private static int[] _defaultSizes;
  private static int[] _offsets;
  private static int[] _sizes;
  private static Class<?> k;
  
  public static String getAssetName(int paramInt)
  {
    if (useDefault(paramInt)) {
      return _defaultAsset;
    }
    return _asset;
  }
  
  public static Bitmap getBitmap(int paramInt)
  {
    return BitmapFactory.decodeByteArray(getBytes(paramInt), 0, getSize(paramInt));
  }
  
  public static Bitmap getBitmap(int paramInt, BitmapFactory.Options paramOptions)
  {
    return BitmapFactory.decodeByteArray(getBytes(paramInt), 0, getSize(paramInt), paramOptions);
  }
  
  public static byte[] getBytes(int paramInt)
  {
    try
    {
      InputStream localInputStream = getStream(paramInt);
      byte[] arrayOfByte = new byte[getSize(paramInt)];
      localInputStream.read(arrayOfByte);
      localInputStream.close();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public static String getKname(int paramInt)
  {
    // Byte code:
    //   0: invokestatic 97	com/magmamobile/game/engine/Game:getContext	()Lcom/magmamobile/game/engine/GameActivity;
    //   3: invokevirtual 103	com/magmamobile/game/engine/GameActivity:getPackageName	()Ljava/lang/String;
    //   6: ldc 17
    //   8: invokevirtual 109	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   11: invokestatic 115	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   14: invokevirtual 119	java/lang/Class:getDeclaredFields	()[Ljava/lang/reflect/Field;
    //   17: astore_3
    //   18: aload_3
    //   19: arraylength
    //   20: istore_2
    //   21: iconst_0
    //   22: istore_1
    //   23: goto +54 -> 77
    //   26: aload_3
    //   27: iload_1
    //   28: aaload
    //   29: astore 4
    //   31: aload 4
    //   33: iconst_1
    //   34: invokevirtual 125	java/lang/reflect/Field:setAccessible	(Z)V
    //   37: aload 4
    //   39: aconst_null
    //   40: invokevirtual 129	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   43: iload_0
    //   44: if_icmpne +15 -> 59
    //   47: aload 4
    //   49: invokevirtual 132	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   52: astore 4
    //   54: aload 4
    //   56: areturn
    //   57: astore 4
    //   59: iload_1
    //   60: iconst_1
    //   61: iadd
    //   62: istore_1
    //   63: goto +14 -> 77
    //   66: astore_3
    //   67: aconst_null
    //   68: areturn
    //   69: astore_3
    //   70: aconst_null
    //   71: areturn
    //   72: astore 4
    //   74: goto -15 -> 59
    //   77: iload_1
    //   78: iload_2
    //   79: if_icmplt -53 -> 26
    //   82: aconst_null
    //   83: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	paramInt	int
    //   22	58	1	i	int
    //   20	60	2	j	int
    //   17	10	3	arrayOfField	Field[]
    //   66	1	3	localClassNotFoundException	ClassNotFoundException
    //   69	1	3	localSecurityException	SecurityException
    //   29	26	4	localObject	Object
    //   57	1	4	localIllegalAccessException	IllegalAccessException
    //   72	1	4	localIllegalArgumentException	IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   37	54	57	java/lang/IllegalAccessException
    //   0	21	66	java/lang/ClassNotFoundException
    //   31	37	66	java/lang/ClassNotFoundException
    //   37	54	66	java/lang/ClassNotFoundException
    //   0	21	69	java/lang/SecurityException
    //   31	37	69	java/lang/SecurityException
    //   37	54	69	java/lang/SecurityException
    //   37	54	72	java/lang/IllegalArgumentException
  }
  
  public static int getKvalue(String paramString)
  {
    try
    {
      int i = Integer.valueOf(((Number)k.getField(paramString).get(k)).intValue()).intValue();
      return i;
    }
    catch (Exception paramString) {}
    return -1;
  }
  
  public static int getOffset(int paramInt)
  {
    if (useDefault(paramInt)) {
      return _defaultOffsets[paramInt];
    }
    return _offsets[paramInt];
  }
  
  public static int getSize(int paramInt)
  {
    if (useDefault(paramInt)) {
      return _defaultSizes[paramInt];
    }
    return _sizes[paramInt];
  }
  
  public static int getSound(SoundPool paramSoundPool, int paramInt)
  {
    try
    {
      AssetFileDescriptor localAssetFileDescriptor = Game.getContext().getAssets().openFd(getAssetName(paramInt));
      paramInt = paramSoundPool.load(localAssetFileDescriptor.getFileDescriptor(), localAssetFileDescriptor.getStartOffset() + getOffset(paramInt), getSize(paramInt), 1);
      return paramInt;
    }
    catch (IOException paramSoundPool)
    {
      throw new RuntimeException();
    }
  }
  
  public static InputStream getStream(int paramInt)
    throws IOException
  {
    InputStream localInputStream = Game.getContext().getAssets().open(getAssetName(paramInt));
    localInputStream.skip(getOffset(paramInt));
    return localInputStream;
  }
  
  public static InputStreamEx getStreamEx(int paramInt)
    throws IOException
  {
    return new InputStreamEx(getStream(paramInt));
  }
  
  public static InputStreamEx getStreamEx(int paramInt1, int paramInt2)
    throws IOException
  {
    return new InputStreamEx(getStream(paramInt1), paramInt2);
  }
  
  public static String getText(int paramInt)
  {
    try
    {
      Object localObject = getStream(paramInt);
      byte[] arrayOfByte = new byte[getSize(paramInt)];
      ((InputStream)localObject).read(arrayOfByte);
      ((InputStream)localObject).close();
      localObject = new String(arrayOfByte, "utf-8");
      return (String)localObject;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException();
    }
  }
  
  public static void initialize(String paramString)
  {
    try
    {
      k = Class.forName(Game.getContext().getPackageName().concat(".K"));
      _defaultOffsets = (int[])k.getField("OFFSETS").get(k);
      _defaultSizes = (int[])k.getField("SIZES").get(k);
      _defaultAsset = "K.WAV";
      _cache = new Object[_defaultOffsets.length];
      setPack(paramString);
      return;
    }
    catch (Exception paramString)
    {
      throw new RuntimeException("K not found");
    }
  }
  
  public static void setPack(String paramString)
  {
    try
    {
      Class localClass = Class.forName(Game.getContext().getPackageName().concat(".K").concat(paramString));
      _offsets = (int[])localClass.getField("OFFSETS").get(localClass);
      _sizes = (int[])localClass.getField("SIZES").get(localClass);
      _asset = "K".concat(paramString).concat(".WAV");
      return;
    }
    catch (Exception paramString)
    {
      throw new RuntimeException("K.WAV not found");
    }
  }
  
  public static void terminate() {}
  
  public static boolean useDefault(int paramInt)
  {
    return _sizes[paramInt] == 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/GamePak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */