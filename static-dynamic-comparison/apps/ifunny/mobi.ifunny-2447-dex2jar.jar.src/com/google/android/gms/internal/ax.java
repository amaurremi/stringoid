package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.gms.ads.e;
import com.google.android.gms.d;

@ii
public final class ax {
    private final e[] a;
    private final String b;

    public ax(Context paramContext, AttributeSet paramAttributeSet) {
        paramContext = paramContext.getResources().obtainAttributes(paramAttributeSet, d.AdsAttrs);
        paramAttributeSet = paramContext.getString(d.AdsAttrs_adSize);
        String str = paramContext.getString(d.AdsAttrs_adSizes);
        int i;
        if (!TextUtils.isEmpty(paramAttributeSet)) {
            i = 1;
            if (TextUtils.isEmpty(str)) {
                break label106;
            }
            label53:
            if ((i == 0) || (j != 0)) {
                break label112;
            }
        }
        for (this.a = a(paramAttributeSet); ; this.a = a(str)) {
            this.b = paramContext.getString(d.AdsAttrs_adUnitId);
            if (!TextUtils.isEmpty(this.b)) {
                return;
            }
            throw new IllegalArgumentException("Required XML attribute \"adUnitId\" was missing.");
            i = 0;
            break;
            label106:
            j = 0;
            break label53;
            label112:
            if ((i != 0) || (j == 0)) {
                break label133;
            }
        }
        label133:
        if ((i != 0) && (j != 0)) {
            throw new IllegalArgumentException("Either XML attribute \"adSize\" or XML attribute \"supportedAdSizes\" should be specified, but not both.");
        }
        throw new IllegalArgumentException("Required XML attribute \"adSize\" was missing.");
    }

    private static e[] a(String paramString) {
        String[] arrayOfString1 = paramString.split("\\s*,\\s*");
        e[] arrayOfe = new e[arrayOfString1.length];
        int i = 0;
        if (i < arrayOfString1.length) {
            String str = arrayOfString1[i].trim();
            String[] arrayOfString2;
            if (str.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$")) {
                arrayOfString2 = str.split("[xX]");
                arrayOfString2[0] = arrayOfString2[0].trim();
                arrayOfString2[1] = arrayOfString2[1].trim();
            }
            for (; ; ) {
                try {
                    if ("FULL_WIDTH".equals(arrayOfString2[0])) {
                        j = -1;
                        boolean bool = "AUTO_HEIGHT".equals(arrayOfString2[1]);
                        if (!bool) {
                            continue;
                        }
                        k = -2;
                        arrayOfe[i] = new e(j, k);
                        i += 1;
                        break;
                    }
                    int j = Integer.parseInt(arrayOfString2[0]);
                    continue;
                    int k = Integer.parseInt(arrayOfString2[1]);
                    continue;
                    if (!"BANNER".equals(str)) {
                        break label199;
                    }
                } catch (NumberFormatException paramString) {
                    throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": " + str);
                }
                arrayOfe[i] = e.a;
                continue;
                label199:
                if ("LARGE_BANNER".equals(str)) {
                    arrayOfe[i] = e.c;
                } else if ("FULL_BANNER".equals(str)) {
                    arrayOfe[i] = e.b;
                } else if ("LEADERBOARD".equals(str)) {
                    arrayOfe[i] = e.d;
                } else if ("MEDIUM_RECTANGLE".equals(str)) {
                    arrayOfe[i] = e.e;
                } else if ("SMART_BANNER".equals(str)) {
                    arrayOfe[i] = e.g;
                } else {
                    if (!"WIDE_SKYSCRAPER".equals(str)) {
                        break label319;
                    }
                    arrayOfe[i] = e.f;
                }
            }
            label319:
            throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": " + str);
        }
        if (arrayOfe.length == 0) {
            throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": " + paramString);
        }
        return arrayOfe;
    }

    public String a() {
        return this.b;
    }

    public e[] a(boolean paramBoolean) {
        if ((!paramBoolean) && (this.a.length != 1)) {
            throw new IllegalArgumentException("The adSizes XML attribute is only allowed on PublisherAdViews.");
        }
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */