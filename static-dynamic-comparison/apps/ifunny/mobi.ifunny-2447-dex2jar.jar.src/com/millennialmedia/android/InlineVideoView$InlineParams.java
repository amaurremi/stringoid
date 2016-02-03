package com.millennialmedia.android;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.millennialmedia.a.a.j;

import java.util.Map;

class InlineVideoView$InlineParams {
    int a;
    boolean b;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h;
    String i;
    String j;
    String k;
    String l;
    boolean m;
    boolean n;
    boolean o = true;
    float p;
    int q;
    boolean r;
    boolean s;
    boolean t;

    InlineVideoView$InlineParams(Map<String, String> paramMap, Context paramContext) {
        if (paramMap.get("x") != null) {
            this.a = ((int) Float.parseFloat((String) paramMap.get("x")));
        }
        if (paramMap.get("y") != null) {
            this.c = ((int) Float.parseFloat((String) paramMap.get("y")));
        }
        if (paramMap.get("width") != null) {
            this.f = ((int) Float.parseFloat((String) paramMap.get("width")));
        }
        if (paramMap.get("height") != null) {
            this.g = ((int) Float.parseFloat((String) paramMap.get("height")));
        }
        this.i = ((String) paramMap.get("streamVideoURI"));
        this.j = ((String) paramMap.get("cachedVideoURI"));
        this.k = ((String) paramMap.get("cachedVideoID"));
        if (paramMap.get("autoPlay") != null) {
            this.m = Boolean.parseBoolean((String) paramMap.get("autoPlay"));
        }
        if (paramMap.get("showControls") != null) {
            this.n = Boolean.parseBoolean((String) paramMap.get("showControls"));
        }
        if (paramMap.get("bodyWidth") != null) {
            this.d = ((int) Float.parseFloat((String) paramMap.get("bodyWidth")));
        }
        if (paramMap.get("bodyHeight") != null) {
            this.e = ((int) Float.parseFloat((String) paramMap.get("bodyHeight")));
        }
        this.l = ((String) paramMap.get("touchCallback"));
        this.p = paramContext.getResources().getDisplayMetrics().density;
    }

    static InlineParams a(String paramString) {
        return (InlineParams) new j().a(paramString, InlineParams.class);
    }

    void b(String paramString) {
        InlineParams localInlineParams = (InlineParams) new j().a(paramString, InlineParams.class);
        this.a = localInlineParams.a;
        this.c = localInlineParams.c;
        this.d = localInlineParams.d;
        this.e = localInlineParams.e;
        this.f = localInlineParams.f;
        this.g = localInlineParams.g;
        this.h = localInlineParams.h;
        this.i = localInlineParams.i;
        this.j = localInlineParams.j;
        this.k = localInlineParams.k;
        this.l = localInlineParams.l;
        this.m = localInlineParams.m;
        this.n = localInlineParams.n;
        this.o = localInlineParams.o;
        this.p = localInlineParams.p;
        this.b = localInlineParams.b;
        this.q = localInlineParams.q;
        this.r = localInlineParams.r;
        MMLog.b("InlineVideoView", "gson*****" + paramString);
        MMLog.b("InlineVideoView", "PARAMS*****" + localInlineParams);
    }

    public String toString() {
        return String.format("%s id, %d x, %d y, %d bWidth, %d bHeight, %d pos, %b autoPlay", new Object[]{this.k, Integer.valueOf(this.a), Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.h), Boolean.valueOf(this.m)});
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/InlineVideoView$InlineParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */