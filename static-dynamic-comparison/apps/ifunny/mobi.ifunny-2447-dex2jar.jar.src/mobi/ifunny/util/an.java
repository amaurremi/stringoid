package mobi.ifunny.util;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;

import java.io.File;

import mobi.ifunny.IFunnyApplication;
import mobi.ifunny.e;

public final class an {
    public static Uri a(Intent paramIntent) {
        Object localObject2 = paramIntent.getData();
        Object localObject1 = localObject2;
        if (localObject2 == null) {
            paramIntent = paramIntent.getExtras().get("path");
            localObject1 = localObject2;
            if (paramIntent != null) {
                if ((paramIntent instanceof Uri)) {
                    return (Uri) paramIntent;
                }
                localObject1 = localObject2;
                if ((paramIntent instanceof String)) {
                    localObject2 = (String) paramIntent;
                    try {
                        paramIntent = Uri.parse((String) localObject2);
                        localObject1 = paramIntent;
                        if (paramIntent.getScheme() == null) {
                            localObject2 = new File((String) localObject2);
                            localObject1 = paramIntent;
                            if (((File) localObject2).exists()) {
                                paramIntent = Uri.fromFile((File) localObject2);
                                return paramIntent;
                            }
                        }
                    } catch (Exception paramIntent) {
                        return null;
                    }
                }
            }
        }
        return (Uri) localObject1;
    }

    public static String a(Uri paramUri) {
        if (paramUri == null) {
            return null;
        }
        if (TextUtils.equals(paramUri.getScheme(), "content")) {
            return IFunnyApplication.a.getContentResolver().getType(paramUri);
        }
        paramUri = MimeTypeMap.getFileExtensionFromUrl(paramUri.toString());
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramUri);
    }

    public static String b(Uri paramUri) {
        if (paramUri == null) {
            return null;
        }
        Cursor localCursor;
        if (TextUtils.equals(paramUri.getScheme(), "content")) {
            localCursor = IFunnyApplication.a.getContentResolver().query(paramUri, new String[]{"_data"}, null, null, null);
            if (localCursor == null) {
            }
        }
        try {
            if (localCursor.moveToFirst()) {
                paramUri = localCursor.getString(localCursor.getColumnIndex("_data"));
                return paramUri;
            }
            return paramUri.getPath();
        } finally {
            localCursor.close();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */