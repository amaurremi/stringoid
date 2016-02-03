package com.quoord.tapatalkpro.util;

import java.io.IOException;
import java.io.InputStream;

public class ImageItem {
    public static String GIF = "image/gif";
    public static String JPEG = "image/jpeg";
    public static String PNG = "image/png";
    private String ImageType;
    private byte[] content;
    private String name;

    public ImageItem(String paramString, byte[] paramArrayOfByte)
            throws Exception {
        String str = getImageType(paramArrayOfByte);
        if ((str != null) && ((str.equalsIgnoreCase("image/gif")) || (str.equalsIgnoreCase("image/png")) || (str.equalsIgnoreCase("image/jpeg")))) {
            this.content = paramArrayOfByte;
            this.name = paramString;
            this.ImageType = str;
            return;
        }
        throw new IllegalStateException("Unsupported image type, Only Suport JPG ,GIF,PNG!");
    }

    public static String getImageExt(InputStream paramInputStream) {
        if (paramInputStream == null) {
            return null;
        }
        try {
            byte[] arrayOfByte = new byte[8];
            paramInputStream.read(arrayOfByte);
            paramInputStream = getImageExt(arrayOfByte);
            return paramInputStream;
        } catch (IOException paramInputStream) {
        }
        return null;
    }

    public static String getImageExt(byte[] paramArrayOfByte) {
        if (isJPEG(paramArrayOfByte)) {
            return ".jpeg";
        }
        if (isGIF(paramArrayOfByte)) {
            return ".gif";
        }
        if (isPNG(paramArrayOfByte)) {
            return ".png";
        }
        if (isBMP(paramArrayOfByte)) {
            return ".bmp";
        }
        return null;
    }

    /* Error */
    public static String getImageType(java.io.File paramFile) {
        // Byte code:
        //   0: aconst_null
        //   1: astore_2
        //   2: aload_2
        //   3: astore_1
        //   4: aload_0
        //   5: ifnull +12 -> 17
        //   8: aload_0
        //   9: invokevirtual 97	java/io/File:exists	()Z
        //   12: ifne +7 -> 19
        //   15: aload_2
        //   16: astore_1
        //   17: aload_1
        //   18: areturn
        //   19: aconst_null
        //   20: astore_1
        //   21: aconst_null
        //   22: astore_3
        //   23: new 99	java/io/FileInputStream
        //   26: dup
        //   27: aload_0
        //   28: invokespecial 102	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   31: astore_0
        //   32: aload_0
        //   33: invokestatic 104	com/quoord/tapatalkpro/util/ImageItem:getImageType	(Ljava/io/InputStream;)Ljava/lang/String;
        //   36: astore_1
        //   37: aload_1
        //   38: astore_2
        //   39: aload_2
        //   40: astore_1
        //   41: aload_0
        //   42: ifnull -25 -> 17
        //   45: aload_0
        //   46: invokevirtual 107	java/io/InputStream:close	()V
        //   49: aload_2
        //   50: areturn
        //   51: astore_0
        //   52: aload_2
        //   53: areturn
        //   54: astore_0
        //   55: aload_3
        //   56: astore_0
        //   57: aload_2
        //   58: astore_1
        //   59: aload_0
        //   60: ifnull -43 -> 17
        //   63: aload_0
        //   64: invokevirtual 107	java/io/InputStream:close	()V
        //   67: aconst_null
        //   68: areturn
        //   69: astore_0
        //   70: aconst_null
        //   71: areturn
        //   72: astore_0
        //   73: aload_1
        //   74: ifnull +7 -> 81
        //   77: aload_1
        //   78: invokevirtual 107	java/io/InputStream:close	()V
        //   81: aload_0
        //   82: athrow
        //   83: astore_1
        //   84: goto -3 -> 81
        //   87: astore_2
        //   88: aload_0
        //   89: astore_1
        //   90: aload_2
        //   91: astore_0
        //   92: goto -19 -> 73
        //   95: astore_1
        //   96: goto -39 -> 57
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	99	0	paramFile	java.io.File
        //   3	75	1	localObject1	Object
        //   83	1	1	localIOException1	IOException
        //   89	1	1	localFile	java.io.File
        //   95	1	1	localIOException2	IOException
        //   1	57	2	localObject2	Object
        //   87	4	2	localObject3	Object
        //   22	34	3	localObject4	Object
        // Exception table:
        //   from	to	target	type
        //   45	49	51	java/io/IOException
        //   23	32	54	java/io/IOException
        //   63	67	69	java/io/IOException
        //   23	32	72	finally
        //   77	81	83	java/io/IOException
        //   32	37	87	finally
        //   32	37	95	java/io/IOException
    }

    public static String getImageType(InputStream paramInputStream) {
        if (paramInputStream == null) {
            return null;
        }
        try {
            byte[] arrayOfByte = new byte[8];
            paramInputStream.read(arrayOfByte);
            paramInputStream = getImageType(arrayOfByte);
            return paramInputStream;
        } catch (IOException paramInputStream) {
        }
        return null;
    }

    public static String getImageType(byte[] paramArrayOfByte) {
        if (isJPEG(paramArrayOfByte)) {
            return "image/jpeg";
        }
        if (isGIF(paramArrayOfByte)) {
            return "image/gif";
        }
        if (isPNG(paramArrayOfByte)) {
            return "image/png";
        }
        if (isBMP(paramArrayOfByte)) {
            return "application/x-bmp";
        }
        return null;
    }

    private static boolean isBMP(byte[] paramArrayOfByte) {
        if (paramArrayOfByte.length < 2) {
        }
        while ((paramArrayOfByte[0] != 66) || (paramArrayOfByte[1] != 77)) {
            return false;
        }
        return true;
    }

    private static boolean isGIF(byte[] paramArrayOfByte) {
        if (paramArrayOfByte.length < 6) {
        }
        while ((paramArrayOfByte[0] != 71) || (paramArrayOfByte[1] != 73) || (paramArrayOfByte[2] != 70) || (paramArrayOfByte[3] != 56) || ((paramArrayOfByte[4] != 55) && (paramArrayOfByte[4] != 57)) || (paramArrayOfByte[5] != 97)) {
            return false;
        }
        return true;
    }

    private static boolean isJPEG(byte[] paramArrayOfByte) {
        if (paramArrayOfByte.length < 2) {
        }
        while ((paramArrayOfByte[0] != -1) || (paramArrayOfByte[1] != -40)) {
            return false;
        }
        return true;
    }

    private static boolean isPNG(byte[] paramArrayOfByte) {
        if (paramArrayOfByte.length < 8) {
        }
        while ((paramArrayOfByte[0] != -119) || (paramArrayOfByte[1] != 80) || (paramArrayOfByte[2] != 78) || (paramArrayOfByte[3] != 71) || (paramArrayOfByte[4] != 13) || (paramArrayOfByte[5] != 10) || (paramArrayOfByte[6] != 26) || (paramArrayOfByte[7] != 10)) {
            return false;
        }
        return true;
    }

    public byte[] getContent() {
        return this.content;
    }

    public String getImageType() {
        return this.ImageType;
    }

    public String getName() {
        return this.name;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/ImageItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */