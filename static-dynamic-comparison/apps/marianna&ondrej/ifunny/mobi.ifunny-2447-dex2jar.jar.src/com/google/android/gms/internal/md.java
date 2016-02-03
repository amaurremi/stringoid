package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@ii
public final class md {
    private final Context a;
    private String b;
    private final float c;
    private float d;
    private float e;
    private float f;
    private int g = 0;

    public md(Context paramContext) {
        this.a = paramContext;
        this.c = paramContext.getResources().getDisplayMetrics().density;
    }

    public md(Context paramContext, String paramString) {
        this(paramContext);
        this.b = paramString;
    }

    private void a() {
        Object localObject2;
        Object localObject1;
        if (!TextUtils.isEmpty(this.b)) {
            localObject2 = new Uri.Builder().encodedQuery(this.b).build();
            localObject1 = new StringBuilder();
            localObject2 = lw.a((Uri) localObject2);
            Iterator localIterator = ((Map) localObject2).keySet().iterator();
            while (localIterator.hasNext()) {
                String str = (String) localIterator.next();
                ((StringBuilder) localObject1).append(str).append(" = ").append((String) ((Map) localObject2).get(str)).append("\n\n");
            }
            localObject1 = ((StringBuilder) localObject1).toString().trim();
            if (TextUtils.isEmpty((CharSequence) localObject1)) {
            }
        }
        for (; ; ) {
            localObject2 = new AlertDialog.Builder(this.a);
            ((AlertDialog.Builder) localObject2).setMessage((CharSequence) localObject1);
            ((AlertDialog.Builder) localObject2).setTitle("Ad Information");
            ((AlertDialog.Builder) localObject2).setPositiveButton("Share", new mf(this, (String) localObject1));
            ((AlertDialog.Builder) localObject2).setNegativeButton("Close", new mh(this));
            ((AlertDialog.Builder) localObject2).create().show();
            return;
            localObject1 = "No debug information";
            continue;
            localObject1 = "No debug information";
        }
    }

    private void a(int paramInt, float paramFloat1, float paramFloat2) {
        if (paramInt == 0) {
            this.g = 0;
            this.d = paramFloat1;
            this.e = paramFloat2;
            this.f = paramFloat2;
        }
        label24:
        label224:
        do {
            do {
                break label24;
                do {
                    return;
                } while (this.g == -1);
                if (paramInt != 2) {
                    break;
                }
                if (paramFloat2 > this.e) {
                    this.e = paramFloat2;
                }
                while (this.e - this.f > 30.0F * this.c) {
                    this.g = -1;
                    return;
                    if (paramFloat2 < this.f) {
                        this.f = paramFloat2;
                    }
                }
                if ((this.g == 0) || (this.g == 2)) {
                    if (paramFloat1 - this.d >= 50.0F * this.c) {
                        this.d = paramFloat1;
                    }
                }
                for (this.g += 1; ; this.g += 1) {
                    do {
                        if ((this.g != 1) && (this.g != 3)) {
                            break label224;
                        }
                        if (paramFloat1 <= this.d) {
                            break;
                        }
                        this.d = paramFloat1;
                        return;
                    } while (((this.g != 1) && (this.g != 3)) || (paramFloat1 - this.d > -50.0F * this.c));
                    this.d = paramFloat1;
                }
            } while ((this.g != 2) || (paramFloat1 >= this.d));
            this.d = paramFloat1;
            return;
        } while ((paramInt != 1) || (this.g != 4));
        a();
    }

    public void a(MotionEvent paramMotionEvent) {
        int j = paramMotionEvent.getHistorySize();
        int i = 0;
        while (i < j) {
            a(paramMotionEvent.getActionMasked(), paramMotionEvent.getHistoricalX(0, i), paramMotionEvent.getHistoricalY(0, i));
            i += 1;
        }
        a(paramMotionEvent.getActionMasked(), paramMotionEvent.getX(), paramMotionEvent.getY());
    }

    public void a(String paramString) {
        this.b = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/md.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */