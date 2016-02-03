package com.scoreloop.client.android.core.utils;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class Base64
{
  private static final byte[] b;
  private static final byte[] c;
  private static final byte[] d;
  private static final byte[] e;
  private static final byte[] f;
  private static final byte[] g;
  
  static
  {
    if (!Base64.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      b = new byte[] { 45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122 };
      c = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 };
      d = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
      e = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 };
      f = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
      g = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 };
      return;
    }
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    try
    {
      paramArrayOfByte = a(paramArrayOfByte, 0, paramArrayOfByte.length, 0);
      if ((!a) && (paramArrayOfByte == null)) {
        throw new AssertionError();
      }
    }
    catch (IOException localIOException)
    {
      do
      {
        paramArrayOfByte = (byte[])localObject;
      } while (a);
      throw new AssertionError(localIOException.getMessage());
    }
    return paramArrayOfByte;
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    paramArrayOfByte = b(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    try
    {
      String str = new String(paramArrayOfByte, "US-ASCII");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return new String(paramArrayOfByte);
  }
  
  private static byte[] a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4)
  {
    int j = 0;
    byte[] arrayOfByte = b(paramInt4);
    if (paramInt2 > 0)
    {
      paramInt4 = paramArrayOfByte1[paramInt1] << 24 >>> 8;
      label25:
      if (paramInt2 <= 1) {
        break label104;
      }
    }
    label104:
    for (int i = paramArrayOfByte1[(paramInt1 + 1)] << 24 >>> 16;; i = 0)
    {
      if (paramInt2 > 2) {
        j = paramArrayOfByte1[(paramInt1 + 2)] << 24 >>> 24;
      }
      paramInt1 = j | i | paramInt4;
      switch (paramInt2)
      {
      default: 
        return paramArrayOfByte2;
        paramInt4 = 0;
        break label25;
      }
    }
    paramArrayOfByte2[paramInt3] = arrayOfByte[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = arrayOfByte[(paramInt1 >>> 6 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 3)] = arrayOfByte[(paramInt1 & 0x3F)];
    return paramArrayOfByte2;
    paramArrayOfByte2[paramInt3] = arrayOfByte[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = arrayOfByte[(paramInt1 >>> 6 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 3)] = 61;
    return paramArrayOfByte2;
    paramArrayOfByte2[paramInt3] = arrayOfByte[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = 61;
    paramArrayOfByte2[(paramInt3 + 3)] = 61;
    return paramArrayOfByte2;
  }
  
  private static int b(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    if (paramArrayOfByte1 == null) {
      throw new NullPointerException("Source array was null.");
    }
    if (paramArrayOfByte2 == null) {
      throw new NullPointerException("Destination array was null.");
    }
    if ((paramInt1 < 0) || (paramInt1 + 3 >= paramArrayOfByte1.length)) {
      throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", new Object[] { Integer.valueOf(paramArrayOfByte1.length), Integer.valueOf(paramInt1) }));
    }
    if ((paramInt2 < 0) || (paramInt2 + 2 >= paramArrayOfByte2.length)) {
      throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", new Object[] { Integer.valueOf(paramArrayOfByte2.length), Integer.valueOf(paramInt2) }));
    }
    byte[] arrayOfByte = c(paramInt3);
    if (paramArrayOfByte1[(paramInt1 + 2)] == 61)
    {
      paramArrayOfByte2[paramInt2] = ((byte)(((arrayOfByte[paramArrayOfByte1[paramInt1]] & 0xFF) << 18 | (arrayOfByte[paramArrayOfByte1[(paramInt1 + 1)]] & 0xFF) << 12) >>> 16));
      return 1;
    }
    if (paramArrayOfByte1[(paramInt1 + 3)] == 61)
    {
      paramInt1 = (arrayOfByte[paramArrayOfByte1[paramInt1]] & 0xFF) << 18 | (arrayOfByte[paramArrayOfByte1[(paramInt1 + 1)]] & 0xFF) << 12 | (arrayOfByte[paramArrayOfByte1[(paramInt1 + 2)]] & 0xFF) << 6;
      paramArrayOfByte2[paramInt2] = ((byte)(paramInt1 >>> 16));
      paramArrayOfByte2[(paramInt2 + 1)] = ((byte)(paramInt1 >>> 8));
      return 2;
    }
    paramInt1 = (arrayOfByte[paramArrayOfByte1[paramInt1]] & 0xFF) << 18 | (arrayOfByte[paramArrayOfByte1[(paramInt1 + 1)]] & 0xFF) << 12 | (arrayOfByte[paramArrayOfByte1[(paramInt1 + 2)]] & 0xFF) << 6 | arrayOfByte[paramArrayOfByte1[(paramInt1 + 3)]] & 0xFF;
    paramArrayOfByte2[paramInt2] = ((byte)(paramInt1 >> 16));
    paramArrayOfByte2[(paramInt2 + 1)] = ((byte)(paramInt1 >> 8));
    paramArrayOfByte2[(paramInt2 + 2)] = ((byte)paramInt1);
    return 3;
  }
  
  private static final byte[] b(int paramInt)
  {
    if ((paramInt & 0x10) == 16) {
      return f;
    }
    if ((paramInt & 0x20) == 32) {
      return b;
    }
    return d;
  }
  
  /* Error */
  public static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 14
    //   3: aconst_null
    //   4: astore 13
    //   6: aload_0
    //   7: ifnonnull +13 -> 20
    //   10: new 207	java/lang/NullPointerException
    //   13: dup
    //   14: ldc -21
    //   16: invokespecial 212	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   19: athrow
    //   20: iload_1
    //   21: ifge +30 -> 51
    //   24: new 216	java/lang/IllegalArgumentException
    //   27: dup
    //   28: new 237	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   35: ldc -16
    //   37: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload_1
    //   41: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokespecial 229	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   50: athrow
    //   51: iload_2
    //   52: ifge +30 -> 82
    //   55: new 216	java/lang/IllegalArgumentException
    //   58: dup
    //   59: new 237	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   66: ldc -4
    //   68: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: iload_2
    //   72: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   75: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokespecial 229	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   81: athrow
    //   82: iload_1
    //   83: iload_2
    //   84: iadd
    //   85: aload_0
    //   86: arraylength
    //   87: if_icmple +42 -> 129
    //   90: new 216	java/lang/IllegalArgumentException
    //   93: dup
    //   94: ldc -2
    //   96: iconst_3
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: iload_1
    //   103: invokestatic 224	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   106: aastore
    //   107: dup
    //   108: iconst_1
    //   109: iload_2
    //   110: invokestatic 224	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   113: aastore
    //   114: dup
    //   115: iconst_2
    //   116: aload_0
    //   117: arraylength
    //   118: invokestatic 224	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   121: aastore
    //   122: invokestatic 228	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   125: invokespecial 229	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   128: athrow
    //   129: iload_3
    //   130: iconst_2
    //   131: iand
    //   132: ifeq +116 -> 248
    //   135: new 256	java/io/ByteArrayOutputStream
    //   138: dup
    //   139: invokespecial 257	java/io/ByteArrayOutputStream:<init>	()V
    //   142: astore 10
    //   144: new 6	com/scoreloop/client/android/core/utils/Base64$a
    //   147: dup
    //   148: aload 10
    //   150: iload_3
    //   151: iconst_1
    //   152: ior
    //   153: invokespecial 260	com/scoreloop/client/android/core/utils/Base64$a:<init>	(Ljava/io/OutputStream;I)V
    //   156: astore 12
    //   158: new 262	java/util/zip/GZIPOutputStream
    //   161: dup
    //   162: aload 12
    //   164: invokespecial 265	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   167: astore 11
    //   169: aload 11
    //   171: aload_0
    //   172: iload_1
    //   173: iload_2
    //   174: invokevirtual 269	java/util/zip/GZIPOutputStream:write	([BII)V
    //   177: aload 11
    //   179: invokevirtual 272	java/util/zip/GZIPOutputStream:close	()V
    //   182: aload 11
    //   184: invokevirtual 272	java/util/zip/GZIPOutputStream:close	()V
    //   187: aload 12
    //   189: invokevirtual 273	com/scoreloop/client/android/core/utils/Base64$a:close	()V
    //   192: aload 10
    //   194: invokevirtual 274	java/io/ByteArrayOutputStream:close	()V
    //   197: aload 10
    //   199: invokevirtual 278	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   202: astore_0
    //   203: aload_0
    //   204: areturn
    //   205: astore 11
    //   207: aconst_null
    //   208: astore 10
    //   210: aconst_null
    //   211: astore_0
    //   212: aload 13
    //   214: astore 12
    //   216: aload 11
    //   218: athrow
    //   219: astore 14
    //   221: aload_0
    //   222: astore 13
    //   224: aload 10
    //   226: astore 11
    //   228: aload 14
    //   230: astore_0
    //   231: aload 12
    //   233: invokevirtual 272	java/util/zip/GZIPOutputStream:close	()V
    //   236: aload 11
    //   238: invokevirtual 273	com/scoreloop/client/android/core/utils/Base64$a:close	()V
    //   241: aload 13
    //   243: invokevirtual 274	java/io/ByteArrayOutputStream:close	()V
    //   246: aload_0
    //   247: athrow
    //   248: iload_3
    //   249: bipush 8
    //   251: iand
    //   252: ifeq +153 -> 405
    //   255: iconst_1
    //   256: istore 6
    //   258: iload_2
    //   259: iconst_3
    //   260: idiv
    //   261: istore 5
    //   263: iload_2
    //   264: iconst_3
    //   265: irem
    //   266: ifle +145 -> 411
    //   269: iconst_4
    //   270: istore 4
    //   272: iload 4
    //   274: iload 5
    //   276: iconst_4
    //   277: imul
    //   278: iadd
    //   279: istore 5
    //   281: iload 5
    //   283: istore 4
    //   285: iload 6
    //   287: ifeq +13 -> 300
    //   290: iload 5
    //   292: iload 5
    //   294: bipush 76
    //   296: idiv
    //   297: iadd
    //   298: istore 4
    //   300: iload 4
    //   302: newarray <illegal type>
    //   304: astore 10
    //   306: iconst_0
    //   307: istore 5
    //   309: iconst_0
    //   310: istore 4
    //   312: iconst_0
    //   313: istore 7
    //   315: iload 7
    //   317: iload_2
    //   318: iconst_2
    //   319: isub
    //   320: if_icmpge +97 -> 417
    //   323: aload_0
    //   324: iload 7
    //   326: iload_1
    //   327: iadd
    //   328: iconst_3
    //   329: aload 10
    //   331: iload 4
    //   333: iload_3
    //   334: invokestatic 280	com/scoreloop/client/android/core/utils/Base64:a	([BII[BII)[B
    //   337: pop
    //   338: iload 5
    //   340: iconst_4
    //   341: iadd
    //   342: istore 9
    //   344: iload 9
    //   346: istore 5
    //   348: iload 4
    //   350: istore 8
    //   352: iload 6
    //   354: ifeq +36 -> 390
    //   357: iload 9
    //   359: istore 5
    //   361: iload 4
    //   363: istore 8
    //   365: iload 9
    //   367: bipush 76
    //   369: if_icmplt +21 -> 390
    //   372: aload 10
    //   374: iload 4
    //   376: iconst_4
    //   377: iadd
    //   378: bipush 10
    //   380: bastore
    //   381: iload 4
    //   383: iconst_1
    //   384: iadd
    //   385: istore 8
    //   387: iconst_0
    //   388: istore 5
    //   390: iload 8
    //   392: iconst_4
    //   393: iadd
    //   394: istore 4
    //   396: iload 7
    //   398: iconst_3
    //   399: iadd
    //   400: istore 7
    //   402: goto -87 -> 315
    //   405: iconst_0
    //   406: istore 6
    //   408: goto -150 -> 258
    //   411: iconst_0
    //   412: istore 4
    //   414: goto -142 -> 272
    //   417: iload 4
    //   419: istore 5
    //   421: iload 7
    //   423: iload_2
    //   424: if_icmpge +27 -> 451
    //   427: aload_0
    //   428: iload 7
    //   430: iload_1
    //   431: iadd
    //   432: iload_2
    //   433: iload 7
    //   435: isub
    //   436: aload 10
    //   438: iload 4
    //   440: iload_3
    //   441: invokestatic 280	com/scoreloop/client/android/core/utils/Base64:a	([BII[BII)[B
    //   444: pop
    //   445: iload 4
    //   447: iconst_4
    //   448: iadd
    //   449: istore 5
    //   451: aload 10
    //   453: astore_0
    //   454: iload 5
    //   456: aload 10
    //   458: arraylength
    //   459: iconst_1
    //   460: isub
    //   461: if_icmpgt -258 -> 203
    //   464: iload 5
    //   466: newarray <illegal type>
    //   468: astore_0
    //   469: aload 10
    //   471: iconst_0
    //   472: aload_0
    //   473: iconst_0
    //   474: iload 5
    //   476: invokestatic 286	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   479: aload_0
    //   480: areturn
    //   481: astore_0
    //   482: goto -295 -> 187
    //   485: astore_0
    //   486: goto -294 -> 192
    //   489: astore_0
    //   490: goto -293 -> 197
    //   493: astore 10
    //   495: goto -259 -> 236
    //   498: astore 10
    //   500: goto -259 -> 241
    //   503: astore 10
    //   505: goto -259 -> 246
    //   508: astore_0
    //   509: aconst_null
    //   510: astore 11
    //   512: aconst_null
    //   513: astore 13
    //   515: aload 14
    //   517: astore 12
    //   519: goto -288 -> 231
    //   522: astore_0
    //   523: aconst_null
    //   524: astore 11
    //   526: aload 14
    //   528: astore 12
    //   530: aload 10
    //   532: astore 13
    //   534: goto -303 -> 231
    //   537: astore_0
    //   538: aload 12
    //   540: astore 11
    //   542: aload 14
    //   544: astore 12
    //   546: aload 10
    //   548: astore 13
    //   550: goto -319 -> 231
    //   553: astore_0
    //   554: aload 11
    //   556: astore 13
    //   558: aload 12
    //   560: astore 11
    //   562: aload 13
    //   564: astore 12
    //   566: aload 10
    //   568: astore 13
    //   570: goto -339 -> 231
    //   573: astore 11
    //   575: aconst_null
    //   576: astore 12
    //   578: aload 10
    //   580: astore_0
    //   581: aload 12
    //   583: astore 10
    //   585: aload 13
    //   587: astore 12
    //   589: goto -373 -> 216
    //   592: astore 11
    //   594: aload 10
    //   596: astore_0
    //   597: aload 12
    //   599: astore 10
    //   601: aload 13
    //   603: astore 12
    //   605: goto -389 -> 216
    //   608: astore 14
    //   610: aload 11
    //   612: astore 13
    //   614: aload 10
    //   616: astore_0
    //   617: aload 14
    //   619: astore 11
    //   621: aload 12
    //   623: astore 10
    //   625: aload 13
    //   627: astore 12
    //   629: goto -413 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	632	0	paramArrayOfByte	byte[]
    //   0	632	1	paramInt1	int
    //   0	632	2	paramInt2	int
    //   0	632	3	paramInt3	int
    //   270	179	4	i	int
    //   261	214	5	j	int
    //   256	151	6	k	int
    //   313	123	7	m	int
    //   350	44	8	n	int
    //   342	28	9	i1	int
    //   142	328	10	localObject1	Object
    //   493	1	10	localException1	Exception
    //   498	1	10	localException2	Exception
    //   503	76	10	localException3	Exception
    //   583	41	10	localObject2	Object
    //   167	16	11	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    //   205	12	11	localIOException1	IOException
    //   226	335	11	localObject3	Object
    //   573	1	11	localIOException2	IOException
    //   592	19	11	localIOException3	IOException
    //   619	1	11	localIOException4	IOException
    //   156	472	12	localObject4	Object
    //   4	622	13	localObject5	Object
    //   1	1	14	localObject6	Object
    //   219	324	14	localObject7	Object
    //   608	10	14	localIOException5	IOException
    // Exception table:
    //   from	to	target	type
    //   135	144	205	java/io/IOException
    //   216	219	219	finally
    //   182	187	481	java/lang/Exception
    //   187	192	485	java/lang/Exception
    //   192	197	489	java/lang/Exception
    //   231	236	493	java/lang/Exception
    //   236	241	498	java/lang/Exception
    //   241	246	503	java/lang/Exception
    //   135	144	508	finally
    //   144	158	522	finally
    //   158	169	537	finally
    //   169	182	553	finally
    //   144	158	573	java/io/IOException
    //   158	169	592	java/io/IOException
    //   169	182	608	java/io/IOException
  }
  
  private static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    a(paramArrayOfByte2, 0, paramInt1, paramArrayOfByte1, 0, paramInt2);
    return paramArrayOfByte1;
  }
  
  private static final byte[] c(int paramInt)
  {
    if ((paramInt & 0x10) == 16) {
      return g;
    }
    if ((paramInt & 0x20) == 32) {
      return c;
    }
    return e;
  }
  
  static class a
    extends FilterOutputStream
  {
    private final byte[] a;
    private final boolean b;
    private byte[] c;
    private final int d;
    private final byte[] e;
    private final boolean f;
    private int g;
    private final int h;
    private int i;
    private boolean j;
    
    public a(OutputStream paramOutputStream)
    {
      this(paramOutputStream, 1);
    }
    
    public a(OutputStream paramOutputStream, int paramInt)
    {
      super();
      boolean bool1;
      if ((paramInt & 0x8) != 0)
      {
        bool1 = true;
        this.b = bool1;
        if ((paramInt & 0x1) == 0) {
          break label106;
        }
        bool1 = bool2;
        label34:
        this.f = bool1;
        if (!this.f) {
          break label112;
        }
      }
      label106:
      label112:
      for (int k = 3;; k = 4)
      {
        this.d = k;
        this.c = new byte[this.d];
        this.i = 0;
        this.g = 0;
        this.j = false;
        this.a = new byte[4];
        this.h = paramInt;
        this.e = Base64.a(paramInt);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label34;
      }
    }
    
    public void a()
      throws IOException
    {
      if (this.i > 0)
      {
        if (this.f)
        {
          this.out.write(Base64.a(this.a, this.c, this.i, this.h));
          this.i = 0;
        }
      }
      else {
        return;
      }
      throw new IOException("Base64 input not properly padded.");
    }
    
    public void close()
      throws IOException
    {
      a();
      super.close();
      this.c = null;
      this.out = null;
    }
    
    public void write(int paramInt)
      throws IOException
    {
      if (this.j) {
        this.out.write(paramInt);
      }
      do
      {
        do
        {
          do
          {
            return;
            if (!this.f) {
              break;
            }
            arrayOfByte = this.c;
            k = this.i;
            this.i = (k + 1);
            arrayOfByte[k] = ((byte)paramInt);
          } while (this.i < this.d);
          this.out.write(Base64.a(this.a, this.c, this.d, this.h));
          this.g += 4;
          if ((this.b) && (this.g >= 76))
          {
            this.out.write(10);
            this.g = 0;
          }
          this.i = 0;
          return;
          if (this.e[(paramInt & 0x7F)] <= -5) {
            break;
          }
          byte[] arrayOfByte = this.c;
          int k = this.i;
          this.i = (k + 1);
          arrayOfByte[k] = ((byte)paramInt);
        } while (this.i < this.d);
        paramInt = Base64.a(this.c, 0, this.a, 0, this.h);
        this.out.write(this.a, 0, paramInt);
        this.i = 0;
        return;
      } while (this.e[(paramInt & 0x7F)] == -5);
      throw new IOException("Invalid character in Base64 data.");
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      if (this.j) {
        this.out.write(paramArrayOfByte, paramInt1, paramInt2);
      }
      for (;;)
      {
        return;
        int k = 0;
        while (k < paramInt2)
        {
          write(paramArrayOfByte[(paramInt1 + k)]);
          k += 1;
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/utils/Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */