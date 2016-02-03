package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ag;

import java.util.ArrayList;

public class i {
    private final Context a;
    private final Intent b;
    private boolean c;
    private ArrayList<Uri> d;

    public i(Activity paramActivity) {
        this.a = paramActivity;
        this.b = new Intent().setAction("android.intent.action.SEND");
        this.b.addFlags(524288);
        if ((paramActivity != null) && (paramActivity.getComponentName() != null)) {
            this.c = true;
        }
    }

    public Intent a() {
        boolean bool2 = true;
        int i;
        boolean bool1;
        if ((this.d != null) && (this.d.size() > 1)) {
            i = 1;
            boolean bool3 = "android.intent.action.SEND_MULTIPLE".equals(this.b.getAction());
            boolean bool4 = this.b.getBooleanExtra("com.google.android.apps.plus.GOOGLE_INTERACTIVE_POST", false);
            if ((i != 0) && (bool4)) {
                break label307;
            }
            bool1 = true;
            label59:
            ag.a(bool1, "Call-to-action buttons are only available for URLs.");
            if ((bool4) && (!this.b.hasExtra("com.google.android.apps.plus.CONTENT_URL"))) {
                break label312;
            }
            bool1 = true;
            label84:
            ag.a(bool1, "The content URL is required for interactive posts.");
            bool1 = bool2;
            if (bool4) {
                bool1 = bool2;
                if (!this.b.hasExtra("com.google.android.apps.plus.CONTENT_URL")) {
                    if (!this.b.hasExtra("com.google.android.apps.plus.CONTENT_DEEP_LINK_ID")) {
                        break label317;
                    }
                    bool1 = bool2;
                }
            }
            label125:
            ag.a(bool1, "Must set content URL or content deep-link ID to use a call-to-action button.");
            if (this.b.hasExtra("com.google.android.apps.plus.CONTENT_DEEP_LINK_ID")) {
                ag.a(h.a(this.b.getStringExtra("com.google.android.apps.plus.CONTENT_DEEP_LINK_ID")), "The specified deep-link ID was malformed.");
            }
            if ((i == 0) && (bool3)) {
                this.b.setAction("android.intent.action.SEND");
                if ((this.d == null) || (this.d.isEmpty())) {
                    break label322;
                }
                this.b.putExtra("android.intent.extra.STREAM", (Parcelable) this.d.get(0));
                label217:
                this.d = null;
            }
            if ((i != 0) && (!bool3)) {
                this.b.setAction("android.intent.action.SEND_MULTIPLE");
                if ((this.d == null) || (this.d.isEmpty())) {
                    break label334;
                }
                this.b.putParcelableArrayListExtra("android.intent.extra.STREAM", this.d);
            }
        }
        for (; ; ) {
            if (!"com.google.android.gms.plus.action.SHARE_INTERNAL_GOOGLE".equals(this.b.getAction())) {
                break label346;
            }
            this.b.setPackage("com.google.android.gms");
            return this.b;
            i = 0;
            break;
            label307:
            bool1 = false;
            break label59;
            label312:
            bool1 = false;
            break label84;
            label317:
            bool1 = false;
            break label125;
            label322:
            this.b.removeExtra("android.intent.extra.STREAM");
            break label217;
            label334:
            this.b.removeExtra("android.intent.extra.STREAM");
        }
        label346:
        if (!this.b.hasExtra("android.intent.extra.STREAM")) {
            this.b.setAction("com.google.android.gms.plus.action.SHARE_GOOGLE");
            this.b.setPackage("com.google.android.gms");
            return this.b;
        }
        this.b.setPackage("com.google.android.apps.plus");
        return this.b;
    }

    public i a(Uri paramUri) {
        String str = null;
        if (paramUri != null) {
            str = paramUri.toString();
        }
        if (TextUtils.isEmpty(str)) {
            this.b.removeExtra("com.google.android.apps.plus.CONTENT_URL");
            return this;
        }
        this.b.putExtra("com.google.android.apps.plus.CONTENT_URL", str);
        return this;
    }

    public i a(CharSequence paramCharSequence) {
        this.b.putExtra("android.intent.extra.TEXT", paramCharSequence);
        return this;
    }

    public i a(String paramString) {
        this.b.setType(paramString);
        return this;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/plus/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */