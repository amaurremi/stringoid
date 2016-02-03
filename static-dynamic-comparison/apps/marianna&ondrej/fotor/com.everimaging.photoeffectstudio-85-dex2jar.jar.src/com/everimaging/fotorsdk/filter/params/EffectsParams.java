package com.everimaging.fotorsdk.filter.params;

import com.everimaging.fotorsdk.algorithms.filter.params.EffectBaseParams;
import com.everimaging.fotorsdk.algorithms.filter.params.EffectBaseParams.a;
import com.everimaging.fotorsdk.algorithms.filter.params.EffectBaseParams.b;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.xml.entity.AllocationEntity;
import com.everimaging.fotorsdk.algorithms.xml.entity.BaseFilterEntity;
import com.everimaging.fotorsdk.algorithms.xml.entity.EffectEntity;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.plugins.FeatureInternalPack;
import com.everimaging.fotorsdk.plugins.FeaturePack;
import com.everimaging.fotorsdk.plugins.FeaturePack.a;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Iterator;
import java.util.List;

public class EffectsParams
        extends EffectBaseParams {
    private static final String TAG = EffectsParams.class.getSimpleName();
    private static final FotorLoggerFactory.c logger = FotorLoggerFactory.a(TAG, FotorLoggerFactory.LoggerType.CONSOLE);
    private FeaturePack mFeaturePack;

    public FeatureInternalPack getFeaturePack() {
        return (FeatureInternalPack) this.mFeaturePack;
    }

    public void parseFromJsonStr(String paramString) {
        Object localObject = new GsonBuilder();
        ((GsonBuilder) localObject).addSerializationExclusionStrategy(new EffectBaseParams.a());
        ((GsonBuilder) localObject).registerTypeAdapter(RSBaseParams.class, new EffectBaseParams.b());
        ((GsonBuilder) localObject).registerTypeAdapter(FeaturePack.class, new FeaturePack.a());
        paramString = (EffectsParams) ((GsonBuilder) localObject).create().fromJson(paramString, getClass());
        this.effectEntity = paramString.effectEntity;
        this.blend = paramString.blend;
        this.mFeaturePack = paramString.mFeaturePack;
        logger.c(new Object[]{"Manual deserialize base filters.."});
        paramString = this.effectEntity.getmFilters().iterator();
        while (paramString.hasNext()) {
            localObject = (BaseFilterEntity) paramString.next();
            AllocationEntity localAllocationEntity = ((BaseFilterEntity) localObject).getSrc();
            if (localAllocationEntity != null) {
                ((BaseFilterEntity) localObject).setSrc(this.effectEntity.getAllocation(localAllocationEntity.getName()));
            }
            localAllocationEntity = ((BaseFilterEntity) localObject).getDst();
            if (localAllocationEntity != null) {
                ((BaseFilterEntity) localObject).setDst(this.effectEntity.getAllocation(localAllocationEntity.getName()));
            }
            localAllocationEntity = ((BaseFilterEntity) localObject).getTableTex();
            if (localAllocationEntity != null) {
                ((BaseFilterEntity) localObject).setTableTex(this.effectEntity.getAllocation(localAllocationEntity.getName()));
            }
            localAllocationEntity = ((BaseFilterEntity) localObject).getTex();
            if (localAllocationEntity != null) {
                ((BaseFilterEntity) localObject).setTex(this.effectEntity.getAllocation(localAllocationEntity.getName()));
            }
        }
    }

    public void setFeaturePack(FeatureInternalPack paramFeatureInternalPack) {
        this.mFeaturePack = paramFeatureInternalPack;
    }

    public String toJsonStr() {
        GsonBuilder localGsonBuilder = new GsonBuilder();
        localGsonBuilder.addSerializationExclusionStrategy(new EffectBaseParams.a());
        localGsonBuilder.registerTypeAdapter(RSBaseParams.class, new EffectBaseParams.b());
        localGsonBuilder.registerTypeAdapter(FeaturePack.class, new FeaturePack.a());
        return localGsonBuilder.create().toJson(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/filter/params/EffectsParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */