package com.everimaging.fotorsdk.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FotorZipUtils {
    public static final int UNZIP_FAILED_NO_SPACE = -2;
    public static final int UNZIP_FAILED_UNEXPECTED = -1;
    public static final int UNZIP_SUCCESS = 0;

    public static int UnzipStream(String paramString, ZipInputStream paramZipInputStream) {
        for (; ; ) {
            try {
                arrayOfByte = new byte['Ѐ'];
                localObject = new File(paramString);
                if (!((File) localObject).exists()) {
                    ((File) localObject).mkdirs();
                }
                localObject = paramString;
                if (!paramString.endsWith(File.separator)) {
                    localObject = paramString + File.separator;
                }
            } catch (IOException paramString) {
                byte[] arrayOfByte;
                Object localObject;
                String str;
                paramString.printStackTrace();
                if (SystemUtils.haveEnoughExternalStorage()) {
                    break label197;
                }
                return -2;
                paramString = new FileOutputStream((String) localObject + str);
                int i = paramZipInputStream.read(arrayOfByte);
                if (i == -1) {
                    continue;
                }
                paramString.write(arrayOfByte, 0, i);
                continue;
                paramString.close();
                paramZipInputStream.closeEntry();
                continue;
                paramZipInputStream.close();
                return 0;
            }
            paramString = paramZipInputStream.getNextEntry();
            if (paramString == null) {
                continue;
            }
            str = paramString.getName();
            if (!paramString.isDirectory()) {
                continue;
            }
            new File((String) localObject + str).mkdirs();
        }
        label197:
        return -1;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/utils/FotorZipUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */