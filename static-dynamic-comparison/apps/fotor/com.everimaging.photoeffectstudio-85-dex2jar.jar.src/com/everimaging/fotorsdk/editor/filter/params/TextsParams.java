package com.everimaging.fotorsdk.editor.filter.params;

import android.graphics.PointF;
import android.graphics.RectF;
import android.text.Layout.Alignment;
import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams;
import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams.ParamsType;
import com.everimaging.fotorsdk.editor.feature.TextFeatureOptionController.ShadowType;
import com.everimaging.fotorsdk.editor.feature.TextFeatureTypefaceController.TypefaceInfo;
import com.everimaging.fotorsdk.editor.feature.TextFeatureTypefaceController.b;
import com.everimaging.fotorsdk.plugins.FeaturePack;
import com.everimaging.fotorsdk.plugins.FeaturePack.a;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class TextsParams
        extends BaseParams {
    private List<a> mParamObjList = null;

    public TextsParams() {
        super(BaseParams.ParamsType.TEXTS);
    }

    public List<a> getParamObjList() {
        return this.mParamObjList;
    }

    public void parseFromJsonStr(String paramString) {
        this.mParamObjList = ((TextsParams) new GsonBuilder().addDeserializationExclusionStrategy(new TextFeatureTypefaceController.b()).registerTypeAdapter(FeaturePack.class, new FeaturePack.a()).create().fromJson(paramString, getClass())).mParamObjList;
    }

    public void setParamObjList(List<a> paramList) {
        this.mParamObjList = paramList;
    }

    public String toJsonStr() {
        return new GsonBuilder().addSerializationExclusionStrategy(new TextFeatureTypefaceController.b()).registerTypeAdapter(FeaturePack.class, new FeaturePack.a()).create().toJson(this);
    }

    public static class a {
        private String a;
        private int b;
        private String c;
        private Layout.Alignment d;
        private boolean e;
        private boolean f;
        private TextFeatureOptionController.ShadowType g;
        private float h;
        private int i;
        private RectF j;
        private float k;
        private float l;
        private TextFeatureTypefaceController.TypefaceInfo m;
        private PointF n;

        public a(String paramString1, int paramInt1, String paramString2, Layout.Alignment paramAlignment, boolean paramBoolean1, boolean paramBoolean2, TextFeatureOptionController.ShadowType paramShadowType, float paramFloat1, int paramInt2, RectF paramRectF, float paramFloat2, float paramFloat3, TextFeatureTypefaceController.TypefaceInfo paramTypefaceInfo, PointF paramPointF) {
            this.a = paramString1;
            this.b = paramInt1;
            this.c = paramString2;
            this.d = paramAlignment;
            this.e = paramBoolean1;
            this.f = paramBoolean2;
            this.g = paramShadowType;
            this.h = paramFloat1;
            this.i = paramInt2;
            this.j = paramRectF;
            this.k = paramFloat2;
            this.m = paramTypefaceInfo;
            this.n = paramPointF;
            this.l = paramFloat3;
        }

        public String a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }

        public Layout.Alignment d() {
            return this.d;
        }

        public boolean e() {
            return this.e;
        }

        public boolean f() {
            return this.f;
        }

        public TextFeatureOptionController.ShadowType g() {
            return this.g;
        }

        public float h() {
            return this.h;
        }

        public int i() {
            return this.i;
        }

        public RectF j() {
            return this.j;
        }

        public float k() {
            return this.k;
        }

        public float l() {
            return this.l;
        }

        public TextFeatureTypefaceController.TypefaceInfo m() {
            return this.m;
        }

        public PointF n() {
            return this.n;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/filter/params/TextsParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */