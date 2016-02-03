package javassist.scopedpool;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

class SoftValueHashMap$SoftValueRef
        extends SoftReference {
    public Object key;

    private SoftValueHashMap$SoftValueRef(Object paramObject1, Object paramObject2, ReferenceQueue paramReferenceQueue) {
        super(paramObject2, paramReferenceQueue);
        this.key = paramObject1;
    }

    private static SoftValueRef create(Object paramObject1, Object paramObject2, ReferenceQueue paramReferenceQueue) {
        if (paramObject2 == null) {
            return null;
        }
        return new SoftValueRef(paramObject1, paramObject2, paramReferenceQueue);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/scopedpool/SoftValueHashMap$SoftValueRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */