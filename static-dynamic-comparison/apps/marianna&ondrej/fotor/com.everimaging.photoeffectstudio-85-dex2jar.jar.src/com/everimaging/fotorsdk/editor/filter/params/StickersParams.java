package com.everimaging.fotorsdk.editor.filter.params;

import android.graphics.RectF;
import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams;
import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams.ParamsType;
import com.everimaging.fotorsdk.plugins.FeaturePack;
import com.everimaging.fotorsdk.plugins.FeaturePack.a;
import com.everimaging.fotorsdk.widget.entity.StickersEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class StickersParams
        extends BaseParams {
    private List<a> mParamObjList = null;

    public StickersParams() {
        super(BaseParams.ParamsType.STICKERS);
    }

    public List<a> getParamObjList() {
        return this.mParamObjList;
    }

    public void parseFromJsonStr(String paramString) {
        GsonBuilder localGsonBuilder = new GsonBuilder();
        localGsonBuilder.registerTypeAdapter(FeaturePack.class, new FeaturePack.a());
        this.mParamObjList = ((StickersParams) localGsonBuilder.create().fromJson(paramString, getClass())).mParamObjList;
    }

    public void setParamObjList(List<a> paramList) {
        this.mParamObjList = paramList;
    }

    public String toJsonStr() {
        GsonBuilder localGsonBuilder = new GsonBuilder();
        localGsonBuilder.registerTypeAdapter(FeaturePack.class, new FeaturePack.a());
        return localGsonBuilder.create().toJson(this);
    }

    public static class a {
        private StickersEntity a;
        private RectF b;
        private float c;
        private float d;
        private float e;
        private float f;
        private int g;
        private int h;
        private boolean i;
        private int j;
        private int k;

        public a(StickersEntity paramStickersEntity, RectF paramRectF, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {
            this.a = paramStickersEntity;
            this.b = paramRectF;
            this.c = paramFloat1;
            this.d = paramFloat2;
            this.e = paramFloat3;
            this.f = paramFloat4;
            this.j = paramInt1;
            this.k = paramInt2;
            this.g = paramInt3;
            this.h = paramInt4;
            this.i = paramBoolean;
        }

        public StickersEntity a() {
            return this.a;
        }

        public RectF b() {
            return this.b;
        }

        public float c() {
            return this.c;
        }

        public float d() {
            return this.d;
        }

        public float e() {
            return this.e;
        }

        public float f() {
            return this.f;
        }

        public int g() {
            return this.j;
        }

        public int h() {
            return this.k;
        }

        public int i() {
            return this.g;
        }

        public int j() {
            return this.h;
        }

        public boolean k() {
            return this.i;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/filter/params/StickersParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */