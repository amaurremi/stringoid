package com.everimaging.fotorsdk.collage.params;

import com.everimaging.fotorsdk.algorithms.filter.params.EffectBaseParams.a;
import com.everimaging.fotorsdk.algorithms.filter.params.EffectBaseParams.b;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.xml.entity.AllocationEntity;
import com.everimaging.fotorsdk.algorithms.xml.entity.BaseFilterEntity;
import com.everimaging.fotorsdk.algorithms.xml.entity.EffectEntity;
import com.everimaging.fotorsdk.filter.params.EffectsParams;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.plugins.FeaturePack;
import com.everimaging.fotorsdk.plugins.FeaturePack.a;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Iterator;
import java.util.List;

public class CollageParam {
    private static final String TAG = CollageParam.class.getSimpleName();
    private static final FotorLoggerFactory.c logger = FotorLoggerFactory.a(TAG, FotorLoggerFactory.LoggerType.CONSOLE);
    private BackgroundParam backgroundParam;
    private List<CollageSlotItemParam> slotItemParams;
    private TemplateParam templateParam;

    public BackgroundParam getBackgroundParam() {
        return this.backgroundParam;
    }

    public List<CollageSlotItemParam> getSlotItemParams() {
        return this.slotItemParams;
    }

    public TemplateParam getTemplateParam() {
        return this.templateParam;
    }

    public void parseFromJson(String paramString) {
        Object localObject = new GsonBuilder();
        ((GsonBuilder) localObject).addSerializationExclusionStrategy(new EffectBaseParams.a());
        ((GsonBuilder) localObject).registerTypeAdapter(RSBaseParams.class, new EffectBaseParams.b());
        ((GsonBuilder) localObject).registerTypeAdapter(FeaturePack.class, new FeaturePack.a());
        paramString = (CollageParam) ((GsonBuilder) localObject).create().fromJson(paramString, getClass());
        this.backgroundParam = paramString.backgroundParam;
        this.slotItemParams = paramString.slotItemParams;
        this.templateParam = paramString.templateParam;
        if (this.slotItemParams != null) {
            paramString = this.slotItemParams.iterator();
            while (paramString.hasNext()) {
                localObject = ((CollageSlotItemParam) paramString.next()).getEffectParams();
                if (localObject != null) {
                    logger.c(new Object[]{"Manual deserialize base filters.."});
                    localObject = ((EffectsParams) localObject).getEffectEntity();
                    Iterator localIterator = ((EffectEntity) localObject).getmFilters().iterator();
                    while (localIterator.hasNext()) {
                        BaseFilterEntity localBaseFilterEntity = (BaseFilterEntity) localIterator.next();
                        AllocationEntity localAllocationEntity = localBaseFilterEntity.getSrc();
                        if (localAllocationEntity != null) {
                            localBaseFilterEntity.setSrc(((EffectEntity) localObject).getAllocation(localAllocationEntity.getName()));
                        }
                        localAllocationEntity = localBaseFilterEntity.getDst();
                        if (localAllocationEntity != null) {
                            localBaseFilterEntity.setDst(((EffectEntity) localObject).getAllocation(localAllocationEntity.getName()));
                        }
                        localAllocationEntity = localBaseFilterEntity.getTableTex();
                        if (localAllocationEntity != null) {
                            localBaseFilterEntity.setTableTex(((EffectEntity) localObject).getAllocation(localAllocationEntity.getName()));
                        }
                        localAllocationEntity = localBaseFilterEntity.getTex();
                        if (localAllocationEntity != null) {
                            localBaseFilterEntity.setTex(((EffectEntity) localObject).getAllocation(localAllocationEntity.getName()));
                        }
                    }
                }
            }
        }
    }

    public void setBackgroundParam(BackgroundParam paramBackgroundParam) {
        this.backgroundParam = paramBackgroundParam;
    }

    public void setSlotItemParams(List<CollageSlotItemParam> paramList) {
        this.slotItemParams = paramList;
    }

    public void setTemplateParam(TemplateParam paramTemplateParam) {
        this.templateParam = paramTemplateParam;
    }

    public String toJsonStr() {
        GsonBuilder localGsonBuilder = new GsonBuilder();
        localGsonBuilder.addSerializationExclusionStrategy(new EffectBaseParams.a());
        localGsonBuilder.registerTypeAdapter(RSBaseParams.class, new EffectBaseParams.b());
        localGsonBuilder.registerTypeAdapter(FeaturePack.class, new FeaturePack.a());
        return localGsonBuilder.create().toJson(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/params/CollageParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */