package mobi.ifunny.gallery.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import mobi.ifunny.rest.content.IFunny;

public class q {
    private static final String a = q.class.getSimpleName();

    public static f a(IFunny paramIFunny, Bundle paramBundle) {
        Object localObject;
        if (paramIFunny.isAbused()) {
            localObject = new s();
        }
        for (; ; ) {
            label15:
            Bundle localBundle = new Bundle();
            localBundle.putParcelable("arg.content", paramIFunny);
            localBundle.putParcelable("arg.option.args", paramBundle);
            ((f) localObject).setArguments(localBundle);
            return (f) localObject;
            localObject = paramIFunny.type;
            if (TextUtils.isEmpty((CharSequence) localObject)) {
                localObject = new ad();
            } else {
                int i = -1;
                switch (((String) localObject).hashCode()) {
                }
                for (; ; ) {
                    switch (i) {
                        default:
                            localObject = new ad();
                            break label15;
                        if (((String) localObject).equals("old")) {
                            i = 0;
                            continue;
                            if (((String) localObject).equals("dem")) {
                                i = 1;
                                continue;
                                if (((String) localObject).equals("caption")) {
                                    i = 2;
                                    continue;
                                    if (((String) localObject).equals("mem")) {
                                        i = 3;
                                        continue;
                                        if (((String) localObject).equals("comics")) {
                                            i = 4;
                                            continue;
                                            if (((String) localObject).equals("pic")) {
                                                i = 5;
                                                continue;
                                                if (((String) localObject).equals("video")) {
                                                    i = 6;
                                                    continue;
                                                    if (((String) localObject).equals("gif")) {
                                                        i = 7;
                                                        continue;
                                                        if (((String) localObject).equals("gif_caption")) {
                                                            i = 8;
                                                            continue;
                                                            if (((String) localObject).equals("_meanwhile")) {
                                                                i = 9;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    }
                }
                localObject = new s();
                continue;
                localObject = new t();
                continue;
                localObject = new r();
                continue;
                localObject = new aa();
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/fragment/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */