package com.bumptech.glide.loader.transformation;

import com.bumptech.glide.resize.load.Transformation;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MultiTransformationLoader<T>
        implements TransformationLoader<T> {
    private final List<TransformationLoader<T>> transformationLoaders;

    public MultiTransformationLoader(List<TransformationLoader<T>> paramList) {
        if (paramList.size() < 1) {
            throw new IllegalArgumentException("MultiTransformationLoader must contain at least one TransformationLoader");
        }
        this.transformationLoaders = paramList;
    }

    public MultiTransformationLoader(TransformationLoader<T>... paramVarArgs) {
        this(Arrays.asList(paramVarArgs));
    }

    public String getId() {
        StringBuilder localStringBuilder = new StringBuilder();
        Iterator localIterator = this.transformationLoaders.iterator();
        for (; ; ) {
            if (!localIterator.hasNext()) {
                return localStringBuilder.toString();
            }
            localStringBuilder.append(((TransformationLoader) localIterator.next()).getId());
        }
    }

    public Transformation getTransformation(T paramT) {
        int j = this.transformationLoaders.size();
        Transformation[] arrayOfTransformation = new Transformation[j];
        int i = 0;
        for (; ; ) {
            if (i >= j) {
                return new MultiTransformation(arrayOfTransformation);
            }
            arrayOfTransformation[i] = ((TransformationLoader) this.transformationLoaders.get(i)).getTransformation(paramT);
            i += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/loader/transformation/MultiTransformationLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */