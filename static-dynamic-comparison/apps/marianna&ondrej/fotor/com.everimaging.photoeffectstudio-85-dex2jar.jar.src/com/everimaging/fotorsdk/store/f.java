package com.everimaging.fotorsdk.store;

import android.graphics.Bitmap;
import com.everimaging.fotorsdk.algorithms.xml.d;
import com.everimaging.fotorsdk.entity.EffectConfig;
import com.everimaging.fotorsdk.entity.EffectConfig.EffectItem;
import com.everimaging.fotorsdk.entity.EffectInfo;
import com.everimaging.fotorsdk.filter.FxEffectFilter;
import com.everimaging.fotorsdk.filter.FxEffectFilter.Level;
import com.everimaging.fotorsdk.filter.params.EffectsParams;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.plugins.c;
import com.everimaging.fotorsdk.store.entity.DetailPageInfo;
import com.everimaging.fotorsdk.utils.FotorIOUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class f
        extends b {
    public f(FotorStoreAbstractDetailPage.a parama, DetailPageInfo paramDetailPageInfo, j paramj, FotorStoreAbstractDetailPage.SourceType paramSourceType, boolean paramBoolean) {
        super(parama, paramDetailPageInfo, paramj, paramSourceType, paramBoolean);
    }

    protected Bitmap a(EffectInfo paramEffectInfo, Bitmap paramBitmap) {
        try {
            b.c(new Object[]{"EffectThumbProcessor ->processBitmap:" + paramBitmap});
            EffectsParams localEffectsParams = new EffectsParams();
            localEffectsParams.setEffectEntity(paramEffectInfo.effectEntity);
            paramEffectInfo = new FxEffectFilter(this, paramBitmap, null, localEffectsParams, FxEffectFilter.Level.SMALL);
            paramEffectInfo.a(this.n);
            paramBitmap = paramEffectInfo.c();
            paramEffectInfo.a();
            return paramBitmap;
        } finally {
            paramEffectInfo =finally;
            throw paramEffectInfo;
        }
    }

    protected List<EffectInfo> k() {
        for (; ; ) {
            int i;
            try {
                Object localObject = this.n.b();
                if (localObject == null) {
                    return null;
                }
                EffectConfig localEffectConfig = (EffectConfig) new GsonBuilder().create().fromJson(new InputStreamReader((InputStream) localObject), EffectConfig.class);
                FotorIOUtils.closeSilently((Closeable) localObject);
                if ((localEffectConfig == null) || (localEffectConfig.classes == null) || (localEffectConfig.classes.size() == 0)) {
                    break label210;
                }
                this.p = new ArrayList();
                localObject = new d();
                i = 0;
                if (i < localEffectConfig.classes.size()) {
                    EffectInfo localEffectInfo = new EffectInfo();
                    EffectConfig.EffectItem localEffectItem = (EffectConfig.EffectItem) localEffectConfig.classes.get(i);
                    InputStream localInputStream = this.n.a(localEffectItem.algorithm_file);
                    if (localInputStream == null) {
                        break label212;
                    }
                    ((d) localObject).a(localInputStream);
                    FotorIOUtils.closeSilently(localInputStream);
                    localEffectInfo.effectEntity = ((d) localObject).a();
                    localEffectInfo.title = localEffectItem.title;
                    this.p.add(localEffectInfo);
                }
            } catch (Exception localException) {
                localException.printStackTrace();
                return null;
            }
            List localList = this.p;
            return localList;
            label210:
            return null;
            label212:
            i += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */