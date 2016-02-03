package mobi.ifunny.e;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

import java.io.FileNotFoundException;

import mobi.ifunny.util.a.b;
import mobi.ifunny.util.cache.f;
import mobi.ifunny.util.cache.m;

public class l
        extends a {
    private static final String f = l.class.getSimpleName();
    private final Uri g;
    private final mobi.ifunny.util.a.a h;

    public l(Context paramContext, boolean paramBoolean, Uri paramUri, mobi.ifunny.util.a.a parama) {
        super(paramContext, paramBoolean);
        this.g = paramUri;
        this.h = parama;
    }

    public static mobi.ifunny.util.a.d a(Context paramContext, Uri paramUri, mobi.ifunny.util.a.a parama) {
        if (paramUri == null) {
        }
        String str;
        do {
            ContentResolver localContentResolver;
            do {
                do {
                    do {
                        return null;
                        str = paramUri.getScheme();
                        if (!TextUtils.equals(str, "content")) {
                            break;
                        }
                    } while (paramContext == null);
                    localContentResolver = paramContext.getContentResolver();
                    paramContext = localContentResolver.getType(paramUri);
                } while ((paramContext == null) || (!paramContext.startsWith("image")));
                paramContext = localContentResolver.query(paramUri, new String[]{"_data"}, null, null, null);
            } while (paramContext == null);
            try {
                if (paramContext.moveToFirst()) {
                    str = paramContext.getString(paramContext.getColumnIndex("_data"));
                    boolean bool = TextUtils.isEmpty(str);
                    if (bool) {
                        try {
                            paramUri = b.a(localContentResolver.openInputStream(paramUri), parama);
                            return paramUri;
                        } catch (FileNotFoundException paramUri) {
                            mobi.ifunny.d.b(f, "File not found", paramUri);
                            return null;
                        }
                    }
                    paramUri = Uri.parse(str);
                    if (paramUri == null) {
                        return null;
                    }
                    paramUri = paramUri.getScheme();
                    if ((paramUri == null) || (TextUtils.equals(paramUri, "file"))) {
                        paramUri = b.b(str, parama);
                        return paramUri;
                    }
                    if ((TextUtils.equals(paramUri, "http")) || (TextUtils.equals(paramUri, "https"))) {
                        paramUri = (mobi.ifunny.util.a.d) mobi.ifunny.util.cache.a.a(str, f.a(parama)).a;
                        return paramUri;
                    }
                }
                return null;
            } finally {
                paramContext.close();
            }
            if (TextUtils.equals(str, "file")) {
                return b.b(paramUri.getPath(), parama);
            }
        } while ((!TextUtils.equals(str, "http")) && (!TextUtils.equals(str, "https")));
        return (mobi.ifunny.util.a.d) mobi.ifunny.util.cache.a.a(paramUri.toString(), f.a(parama)).a;
    }

    protected mobi.ifunny.util.a.d f() {
        return a(getContext(), this.g, this.h);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/e/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */