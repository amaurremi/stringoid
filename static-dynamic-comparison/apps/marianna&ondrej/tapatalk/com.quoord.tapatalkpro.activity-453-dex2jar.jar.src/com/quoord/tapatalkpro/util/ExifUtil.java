package com.quoord.tapatalkpro.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.ExifInterface;
import android.net.Uri;

import java.io.File;

public class ExifUtil {
    public static int getExif(Context paramContext, Uri paramUri) {
        paramContext = paramContext.getContentResolver().query(paramUri, new String[]{"orientation"}, null, null, null);
        if ((paramContext != null) && (paramContext.moveToFirst())) {
            return -paramContext.getInt(0);
        }
        return 0;
    }

    public static int getExif(File paramFile) {
        int j = 0;
        int i = 0;
        try {
            int k = new ExifInterface(paramFile.getAbsolutePath()).getAttributeInt("Orientation", 1);
            switch (k) {
                case 4:
                case 5:
                case 7:
                default:
                    return 0;
                case 8:
                    i = 0 - 90;
                case 3:
                    j = i - 90;
            }
            return j - 90;
        } catch (Exception paramFile) {
            paramFile.printStackTrace();
        }
        return 0;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/ExifUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */