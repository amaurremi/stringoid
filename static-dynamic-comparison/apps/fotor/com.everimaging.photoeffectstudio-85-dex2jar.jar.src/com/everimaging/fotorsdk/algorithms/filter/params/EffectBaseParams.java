package com.everimaging.fotorsdk.algorithms.filter.params;

import android.support.v8.renderscript.Allocation;
import com.everimaging.fotorsdk.algorithms.f;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.xml.entity.EffectEntity;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.annotations.Expose;

import java.lang.reflect.Type;

public abstract class EffectBaseParams
        extends BaseParams {
    @Expose
    protected float blend = 1.0F;
    @Expose
    protected EffectEntity effectEntity;

    public EffectBaseParams() {
        super(BaseParams.ParamsType.FX_EFFECT);
    }

    public float getBlend() {
        return this.blend;
    }

    public float getDisplayBlend() {
        return this.blend * 100.0F;
    }

    public EffectEntity getEffectEntity() {
        return this.effectEntity;
    }

    public void reset() {
        super.reset();
        this.blend = 1.0F;
        this.effectEntity = null;
    }

    public void setBlend(float paramFloat) {
        this.blend = (paramFloat / 100.0F);
    }

    public void setEffectEntity(EffectEntity paramEffectEntity) {
        this.effectEntity = paramEffectEntity;
    }

    public static class a
            implements ExclusionStrategy {
        public boolean shouldSkipClass(Class<?> paramClass) {
            return (paramClass.isAssignableFrom(Allocation.class)) || (paramClass.isAssignableFrom(f.class));
        }

        public boolean shouldSkipField(FieldAttributes paramFieldAttributes) {
            return false;
        }
    }

    public static class b
            implements JsonDeserializer<RSBaseParams>, JsonSerializer<RSBaseParams> {
        public RSBaseParams a(JsonElement paramJsonElement, Type paramType, JsonDeserializationContext paramJsonDeserializationContext)
                throws JsonParseException {
            paramJsonElement = paramJsonElement.getAsJsonObject();
            paramType = ((JsonPrimitive) paramJsonElement.get("CLASSNAME")).getAsString();
            try {
                paramType = Class.forName(paramType);
                return (RSBaseParams) paramJsonDeserializationContext.deserialize(paramJsonElement.get("INSTANCE"), paramType);
            } catch (ClassNotFoundException paramJsonElement) {
                paramJsonElement.printStackTrace();
                throw new JsonParseException(paramJsonElement.getMessage());
            }
        }

        public JsonElement a(RSBaseParams paramRSBaseParams, Type paramType, JsonSerializationContext paramJsonSerializationContext) {
            paramType = new JsonObject();
            paramType.addProperty("CLASSNAME", paramRSBaseParams.getClass().getCanonicalName());
            paramType.add("INSTANCE", paramJsonSerializationContext.serialize(paramRSBaseParams));
            return paramType;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/params/EffectBaseParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */