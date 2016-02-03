package com.everimaging.fotorsdk.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Images.Media;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ExifUtils {
    private static final String TAG = ExifUtils.class.getSimpleName();
    private static final FotorLoggerFactory.c logger = FotorLoggerFactory.a(TAG, FotorLoggerFactory.LoggerType.CONSOLE);
    private static SimpleDateFormat sFormatter = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");

    static {
        sFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public static String convertFloatToRotationLocation(double paramDouble) {
        try {
            int i = (int) Math.floor(paramDouble);
            int j = (int) Math.floor((paramDouble - i) * 60.0D);
            double d1 = i;
            double d2 = j / 60.0D;
            String str = i + "/1," + j + "/1," + (paramDouble - (d1 + d2)) * 3600000.0D + "/1000";
            return str;
        } catch (Exception localException) {
        }
        return "";
    }

    public static double convertRationalLatLonToFloat(String paramString1, String paramString2) {
        try {
            paramString1 = paramString1.split(",");
            String[] arrayOfString = paramString1[0].split("/");
            int i = (int) (Double.parseDouble(arrayOfString[0].trim()) / Double.parseDouble(arrayOfString[1].trim()));
            arrayOfString = paramString1[1].split("/");
            int j = (int) (Double.parseDouble(arrayOfString[0].trim()) / Double.parseDouble(arrayOfString[1].trim()));
            paramString1 = paramString1[2].split("/");
            double d1 = Double.parseDouble(paramString1[0].trim()) / Double.parseDouble(paramString1[1].trim());
            double d2 = i + j / 60.0D + d1 / 3600.0D;
            if (!paramString2.equals("S")) {
                boolean bool = paramString2.equals("W");
                d1 = d2;
                if (!bool) {
                }
            } else {
                d1 = -d2;
            }
            return d1;
        } catch (RuntimeException paramString1) {
        }
        return 0.0D;
    }

    public static int convertToExifOrientation(int paramInt) {
        if (paramInt == 0) {
        }
        do {
            return 1;
            if (paramInt == 90) {
                return 6;
            }
            if (paramInt == 180) {
                return 3;
            }
        } while (paramInt != 270);
        return 8;
    }

    @SuppressLint({"InlinedApi"})
    public static void copyAllExifAttribute(ExifInterface paramExifInterface1, ExifInterface paramExifInterface2) {
        if ((paramExifInterface1 != null) && (paramExifInterface2 != null)) {
            if (Build.VERSION.SDK_INT >= 11) {
                copyExifAttribute(paramExifInterface1, paramExifInterface2, "FNumber");
                copyExifAttribute(paramExifInterface1, paramExifInterface2, "ExposureTime");
                copyExifAttribute(paramExifInterface1, paramExifInterface2, "ISOSpeedRatings");
            }
            copyExifAttribute(paramExifInterface1, paramExifInterface2, "DateTime");
            copyExifAttribute(paramExifInterface1, paramExifInterface2, "Flash");
            copyExifAttribute(paramExifInterface1, paramExifInterface2, "FocalLength");
            copyExifAttribute(paramExifInterface1, paramExifInterface2, "GPSAltitude");
            copyExifAttribute(paramExifInterface1, paramExifInterface2, "GPSAltitudeRef");
            copyExifAttribute(paramExifInterface1, paramExifInterface2, "GPSDateStamp");
            copyExifAttribute(paramExifInterface1, paramExifInterface2, "GPSLatitude");
            copyExifAttribute(paramExifInterface1, paramExifInterface2, "GPSLatitudeRef");
            copyExifAttribute(paramExifInterface1, paramExifInterface2, "GPSLongitude");
            copyExifAttribute(paramExifInterface1, paramExifInterface2, "GPSLongitudeRef");
            copyExifAttribute(paramExifInterface1, paramExifInterface2, "GPSProcessingMethod");
            copyExifAttribute(paramExifInterface1, paramExifInterface2, "GPSTimeStamp");
            copyExifAttribute(paramExifInterface1, paramExifInterface2, "Make");
            copyExifAttribute(paramExifInterface1, paramExifInterface2, "Model");
            copyExifAttribute(paramExifInterface1, paramExifInterface2, "WhiteBalance");
            copyExifAttribute(paramExifInterface1, paramExifInterface2, "ImageWidth");
            copyExifAttribute(paramExifInterface1, paramExifInterface2, "ImageLength");
            copyExifAttribute(paramExifInterface1, paramExifInterface2, "Orientation");
        }
    }

    public static void copyExifAttribute(ExifInterface paramExifInterface1, ExifInterface paramExifInterface2, String paramString) {
        if ((paramExifInterface1 != null) && (paramExifInterface2 != null)) {
            paramExifInterface1 = paramExifInterface1.getAttribute(paramString);
            if ((paramExifInterface1 == null) || (paramExifInterface1.isEmpty())) {
                break label32;
            }
            paramExifInterface2.setAttribute(paramString, paramExifInterface1);
        }
        label32:
        while (paramString != "DateTime") {
            return;
        }
        paramExifInterface1 = new Date(System.currentTimeMillis());
        paramExifInterface2.setAttribute(paramString, sFormatter.format(paramExifInterface1));
    }

    public static ExifInterface getExif(Uri paramUri, Context paramContext) {
        paramUri = getFilePathFromUri(paramUri, paramContext);
        try {
            paramUri = new ExifInterface(paramUri);
            return paramUri;
        } catch (Exception paramUri) {
            logger.d(new Object[]{"Can't load Exif:" + paramUri.getMessage()});
        }
        return null;
    }

    public static ExifInterface getExif(String paramString) {
        try {
            paramString = new ExifInterface(paramString);
            return paramString;
        } catch (IOException paramString) {
            logger.d(new Object[]{"Can't load Exif:" + paramString.getMessage()});
        }
        return null;
    }

    public static int getExifOrientation(Context paramContext, Uri paramUri) {
        logger.b(new Object[]{"getExifOrientation(context,uri): " + paramUri});
        if ((paramUri == null) || (paramContext == null)) {
            return 0;
        }
        String str = paramUri.getScheme();
        if ((str == null) || ("file".equals(str))) {
            return getExifOrientation(paramUri.getPath());
        }
        int i;
        int j;
        if (str.equals("content")) {
            try {
                paramContext = paramContext.getContentResolver().query(paramUri, new String[]{"orientation", "_data"}, null, null, null);
                if (paramContext == null) {
                    return 0;
                }
            } catch (Exception paramContext) {
                paramContext.printStackTrace();
                return 0;
            }
            i = paramContext.getColumnIndex("orientation");
            j = paramContext.getColumnIndex("_data");
        }
        for (; ; ) {
            try {
                if (paramContext.getCount() > 0) {
                    paramContext.moveToFirst();
                    if (i <= -1) {
                        break label251;
                    }
                    i = paramContext.getInt(i);
                    if (j > -1) {
                        paramUri = paramContext.getString(j);
                        if (paramUri != null) {
                            j = getExifOrientation(paramUri);
                            if (j != 0) {
                                return j;
                            }
                            if (i != 0) {
                                return i;
                            }
                            return 0;
                        }
                    }
                } else {
                    return 0;
                }
            } finally {
                paramContext.close();
            }
            j = 0;
            continue;
            label251:
            i = 0;
        }
    }

    public static int getExifOrientation(String paramString) {
        paramString = getExif(paramString);
        int i;
        if (paramString != null) {
            i = paramString.getAttributeInt("Orientation", -1);
            if (i == -1) {
            }
        }
        switch (i) {
            case 4:
            case 5:
            case 7:
            default:
                return 0;
            case 6:
                return 90;
            case 3:
                return 180;
        }
        return 270;
    }

    @TargetApi(19)
    public static String getFilePathFromUri(Uri paramUri, Context paramContext) {
        Object localObject = paramUri.getScheme();
        if (localObject == null) {
            return "";
        }
        if (((String) localObject).equals("content")) {
        }
        for (; ; ) {
            try {
                localObject = new String[1];
                localObject[0] = "_data";
                if ((Build.VERSION.SDK_INT >= 19) && (DocumentsContract.isDocumentUri(paramContext, paramUri))) {
                    paramUri = DocumentsContract.getDocumentId(paramUri).split(":")[1];
                    paramUri = paramContext.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, (String[]) localObject, "_id=?", new String[]{paramUri}, null);
                    if (paramUri == null) {
                        break label203;
                    }
                    if (!paramUri.moveToFirst()) {
                        break label197;
                    }
                    paramContext = paramUri.getString(paramUri.getColumnIndexOrThrow(localObject[0]));
                }
            } catch (Exception paramUri) {
                paramContext = "";
            }
            try {
                paramUri.close();
                return paramContext;
            } catch (Exception paramUri) {
                for (; ; ) {
                }
            }
            paramUri = paramContext.getContentResolver().query(paramUri, (String[]) localObject, null, null, null);
            continue;
            paramUri.printStackTrace();
            continue;
            if (((String) localObject).equals("file")) {
                localObject = paramUri.getPath();
                paramContext = (Context) localObject;
                if (((String) localObject).startsWith("/android_asset/")) {
                    paramContext = paramUri.toString();
                }
            } else {
                paramContext = paramUri.getPath();
                continue;
                label197:
                paramContext = "";
                continue;
                label203:
                paramContext = "";
            }
        }
    }

    public static void getLatLong(Context paramContext, Uri paramUri, double[] paramArrayOfDouble) {
        getLatLong(getExif(paramUri, paramContext), paramArrayOfDouble);
    }

    public static void getLatLong(ExifInterface paramExifInterface, double[] paramArrayOfDouble) {
        try {
            String str1 = paramExifInterface.getAttribute("GPSLatitude");
            String str2 = paramExifInterface.getAttribute("GPSLatitudeRef");
            String str3 = paramExifInterface.getAttribute("GPSLongitude");
            paramExifInterface = paramExifInterface.getAttribute("GPSLongitudeRef");
            if ((str1 != null) && (str2 != null) && (str3 != null) && (paramExifInterface != null)) {
                paramArrayOfDouble[0] = convertRationalLatLonToFloat(str1, str2);
                paramArrayOfDouble[1] = convertRationalLatLonToFloat(str3, paramExifInterface);
            }
            return;
        } catch (Exception paramExifInterface) {
            paramExifInterface.printStackTrace();
        }
    }

    public static String getLatRef(double paramDouble) {
        if (paramDouble > 0.0D) {
            return "N";
        }
        return "S";
    }

    public static String getLonRef(double paramDouble) {
        if (paramDouble > 0.0D) {
            return "E";
        }
        return "W";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/utils/ExifUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */