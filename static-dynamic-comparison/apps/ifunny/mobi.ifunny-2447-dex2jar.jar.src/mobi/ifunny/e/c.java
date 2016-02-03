package mobi.ifunny.e;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;

import java.io.File;

import mobi.ifunny.util.cache.f;
import mobi.ifunny.util.cache.m;
import mobi.ifunny.util.l;

public class c
        extends android.support.v4.a.a<File> {
    private final Uri f;

    public c(Context paramContext, Uri paramUri) {
        super(paramContext);
        this.f = paramUri;
    }

    public static File a(Context paramContext, Uri paramUri) {
        if ((paramContext == null) || (paramUri == null)) {
        }
        for (; ; ) {
            return null;
            Object localObject = paramUri.getScheme();
            if (TextUtils.equals((CharSequence) localObject, "content")) {
                localObject = paramContext.getContentResolver();
                if (TextUtils.equals(((ContentResolver) localObject).getType(paramUri), "image/gif")) {
                    paramUri = ((ContentResolver) localObject).query(paramUri, new String[]{"_data"}, null, null, null);
                    if (paramUri != null) {
                        try {
                            if (paramUri.moveToFirst()) {
                                localObject = paramUri.getString(paramUri.getColumnIndex("_data"));
                                String str = Uri.parse((String) localObject).getScheme();
                                if ((str == null) || (TextUtils.equals(str, "file"))) {
                                    paramContext = l.b(paramContext, (String) localObject);
                                    return paramContext;
                                }
                                if ((TextUtils.equals(str, "http")) || (TextUtils.equals(str, "https"))) {
                                    paramContext = mobi.ifunny.util.cache.a.a((String) localObject, f.c).b;
                                    return paramContext;
                                }
                            }
                            return null;
                        } finally {
                            paramUri.close();
                        }
                    }
                }
            } else if (TextUtils.equals((CharSequence) localObject, "file")) {
                localObject = MimeTypeMap.getFileExtensionFromUrl(paramUri.toString());
                if (TextUtils.equals(MimeTypeMap.getSingleton().getMimeTypeFromExtension((String) localObject), "image/gif")) {
                    return l.b(paramContext, paramUri.getEncodedPath());
                }
            } else {
                if ((TextUtils.equals((CharSequence) localObject, "http")) || (TextUtils.equals((CharSequence) localObject, "https"))) {
                    return mobi.ifunny.util.cache.a.a(paramUri.toString(), f.c).b;
                }
                if (TextUtils.isEmpty((CharSequence) localObject)) {
                    paramUri = paramUri.getEncodedPath();
                    if (!TextUtils.isEmpty(paramUri)) {
                        try {
                            if (new File(paramUri).exists()) {
                                localObject = MimeTypeMap.getFileExtensionFromUrl(paramUri);
                                if (TextUtils.equals(MimeTypeMap.getSingleton().getMimeTypeFromExtension((String) localObject), "image/gif")) {
                                    paramContext = l.b(paramContext, paramUri);
                                    return paramContext;
                                }
                            }
                        } catch (Exception paramContext) {
                        }
                    }
                }
            }
        }
        return null;
    }

    public File e() {
        return a(getContext(), this.f);
    }

    protected void onStartLoading() {
        forceLoad();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */