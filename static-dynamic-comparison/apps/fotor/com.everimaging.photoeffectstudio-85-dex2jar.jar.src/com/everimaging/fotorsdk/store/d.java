package com.everimaging.fotorsdk.store;

import android.graphics.Bitmap;
import android.support.v8.renderscript.Float2;
import com.everimaging.fotorsdk.algorithms.params.base.RSFrameBaseFilterParams;
import com.everimaging.fotorsdk.algorithms.xml.entity.BaseFilterEntity;
import com.everimaging.fotorsdk.algorithms.xml.entity.EffectEntity;
import com.everimaging.fotorsdk.algorithms.xml.entity.EffectEntity.Category;
import com.everimaging.fotorsdk.entity.BorderConfig;
import com.everimaging.fotorsdk.entity.BorderConfig.BorderItem;
import com.everimaging.fotorsdk.entity.BorderInfo;
import com.everimaging.fotorsdk.entity.EffectInfo;
import com.everimaging.fotorsdk.filter.FxEffectFilter;
import com.everimaging.fotorsdk.filter.FxEffectFilter.Level;
import com.everimaging.fotorsdk.filter.params.EffectsParams;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.store.entity.DetailPageInfo;
import com.everimaging.fotorsdk.utils.FotorIOUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class d
        extends b {
    public d(FotorStoreAbstractDetailPage.a parama, DetailPageInfo paramDetailPageInfo, j paramj, FotorStoreAbstractDetailPage.SourceType paramSourceType, boolean paramBoolean) {
        super(parama, paramDetailPageInfo, paramj, paramSourceType, paramBoolean);
    }

    protected Bitmap a(EffectInfo paramEffectInfo, Bitmap paramBitmap) {
        for (; ; ) {
            try {
                b.c(new Object[]{"EffectThumbProcessor ->processBitmap:" + paramBitmap});
                Object localObject = new EffectsParams();
                ((EffectsParams) localObject).setEffectEntity(paramEffectInfo.effectEntity);
                if ((paramEffectInfo.effectEntity.getmFilters() != null) && (paramEffectInfo.effectEntity.getmFilters().size() > 0)) {
                    localRSFrameBaseFilterParams = (RSFrameBaseFilterParams) ((BaseFilterEntity) paramEffectInfo.effectEntity.getmFilters().get(0)).getParams();
                    if (localRSFrameBaseFilterParams != null) {
                        localRSFrameBaseFilterParams.setThickness(((BorderInfo) paramEffectInfo).thumbnailThickness);
                    }
                    paramBitmap = new FxEffectFilter(this, paramBitmap, null, (EffectsParams) localObject, FxEffectFilter.Level.SMALL);
                    paramBitmap.a(this.n);
                    localObject = paramBitmap.c();
                    paramBitmap.a();
                    if (localRSFrameBaseFilterParams != null) {
                        localRSFrameBaseFilterParams.setThickness(((BorderInfo) paramEffectInfo).mediumThickness);
                    }
                    return (Bitmap) localObject;
                }
            } finally {
            }
            RSFrameBaseFilterParams localRSFrameBaseFilterParams = null;
        }
    }

    protected List<EffectInfo> k() {
        try {
            Object localObject1 = this.n.b();
            if (localObject1 == null) {
                return null;
            }
            Object localObject2 = (BorderConfig) new GsonBuilder().create().fromJson(new InputStreamReader((InputStream) localObject1), BorderConfig.class);
            FotorIOUtils.closeSilently((Closeable) localObject1);
            if ((localObject2 == null) || (((BorderConfig) localObject2).classes == null) || (((BorderConfig) localObject2).classes.size() == 0)) {
                break label385;
            }
            this.p = new ArrayList();
            localObject1 = new com.everimaging.fotorsdk.algorithms.xml.c();
            localObject2 = ((BorderConfig) localObject2).classes.iterator();
            while (((Iterator) localObject2).hasNext()) {
                BorderConfig.BorderItem localBorderItem = (BorderConfig.BorderItem) ((Iterator) localObject2).next();
                BorderInfo localBorderInfo = new BorderInfo();
                Object localObject3 = this.n.a(localBorderItem.algorithm_file);
                if (localObject3 != null) {
                    ((com.everimaging.fotorsdk.algorithms.xml.c) localObject1).a((InputStream) localObject3);
                    FotorIOUtils.closeSilently((Closeable) localObject3);
                    localObject3 = ((com.everimaging.fotorsdk.algorithms.xml.c) localObject1).a();
                    localBorderInfo.effectEntity = ((EffectEntity) localObject3);
                    float f = Float.parseFloat(localBorderItem.sThickness);
                    b.c(new Object[]{"name:" + localBorderItem.algorithm_file + ",thumbThickness:" + f});
                    localBorderInfo.thumbnailThickness = new Float2(f, f);
                    f = Float.parseFloat(localBorderItem.mThickness);
                    b.c(new Object[]{"name:" + localBorderItem.algorithm_file + ",mediumThickness:" + f});
                    localBorderInfo.mediumThickness = new Float2(f, f);
                    if ((localObject3 != null) && (((EffectEntity) localObject3).getCategory() == EffectEntity.Category.FRAME)) {
                        localBorderInfo.originalThickness = ((RSFrameBaseFilterParams) ((BaseFilterEntity) ((EffectEntity) localObject3).getmFilters().get(0)).getParams()).getThickness();
                    }
                    this.p.add(localBorderInfo);
                }
            }
            localList = this.p;
        } catch (Exception localException) {
            localException.printStackTrace();
            return null;
        }
        List localList;
        return localList;
        label385:
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */