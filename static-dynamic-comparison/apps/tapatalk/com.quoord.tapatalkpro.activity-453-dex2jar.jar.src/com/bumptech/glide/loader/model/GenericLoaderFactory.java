package com.bumptech.glide.loader.model;

import android.content.Context;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GenericLoaderFactory {
    private Map<Class, ModelLoaderFactory> factories = new HashMap();

    public <T> ModelLoader<T> buildModelLoader(Class<T> paramClass, Context paramContext) {
        ModelLoaderFactory localModelLoaderFactory = getFactory(paramClass);
        if (localModelLoaderFactory == null) {
            throw new IllegalArgumentException("No ModelLoaderFactory registered for class=" + paramClass);
        }
        return localModelLoaderFactory.build(paramContext, this);
    }

    public <T> ModelLoaderFactory<T> getFactory(Class<T> paramClass) {
        ModelLoaderFactory localModelLoaderFactory = (ModelLoaderFactory) this.factories.get(paramClass);
        Iterator localIterator;
        if (localModelLoaderFactory == null) {
            localIterator = this.factories.keySet().iterator();
        }
        Class localClass;
        do {
            if (!localIterator.hasNext()) {
                return localModelLoaderFactory;
            }
            localClass = (Class) localIterator.next();
        } while (!localClass.isAssignableFrom(paramClass));
        return (ModelLoaderFactory) this.factories.get(localClass);
    }

    public <T> ModelLoaderFactory<T> register(Class<T> paramClass, ModelLoaderFactory<T> paramModelLoaderFactory) {
        paramModelLoaderFactory = (ModelLoaderFactory) this.factories.put(paramClass, paramModelLoaderFactory);
        paramClass = paramModelLoaderFactory;
        if (paramModelLoaderFactory != null) {
            paramClass = paramModelLoaderFactory;
            if (this.factories.containsValue(paramModelLoaderFactory)) {
                paramClass = null;
            }
        }
        return paramClass;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/loader/model/GenericLoaderFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */