package javassist.scopedpool;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SoftValueHashMap
        extends AbstractMap
        implements Map {
    private Map hash;
    private ReferenceQueue queue = new ReferenceQueue();

    public SoftValueHashMap() {
        this.hash = new HashMap();
    }

    public SoftValueHashMap(int paramInt) {
        this.hash = new HashMap(paramInt);
    }

    public SoftValueHashMap(int paramInt, float paramFloat) {
        this.hash = new HashMap(paramInt, paramFloat);
    }

    public SoftValueHashMap(Map paramMap) {
        this(Math.max(paramMap.size() * 2, 11), 0.75F);
        putAll(paramMap);
    }

    private void processQueue() {
        for (; ; ) {
            SoftValueHashMap.SoftValueRef localSoftValueRef = (SoftValueHashMap.SoftValueRef) this.queue.poll();
            if (localSoftValueRef == null) {
                break;
            }
            if (localSoftValueRef == (SoftValueHashMap.SoftValueRef) this.hash.get(localSoftValueRef.key)) {
                this.hash.remove(localSoftValueRef.key);
            }
        }
    }

    public void clear() {
        processQueue();
        this.hash.clear();
    }

    public boolean containsKey(Object paramObject) {
        processQueue();
        return this.hash.containsKey(paramObject);
    }

    public Set entrySet() {
        processQueue();
        return this.hash.entrySet();
    }

    public Object get(Object paramObject) {
        processQueue();
        paramObject = (SoftReference) this.hash.get(paramObject);
        if (paramObject != null) {
            return ((SoftReference) paramObject).get();
        }
        return null;
    }

    public boolean isEmpty() {
        processQueue();
        return this.hash.isEmpty();
    }

    public Object put(Object paramObject1, Object paramObject2) {
        processQueue();
        paramObject2 = this.hash.put(paramObject1, SoftValueHashMap.SoftValueRef.access$000(paramObject1, paramObject2, this.queue));
        paramObject1 = paramObject2;
        if (paramObject2 != null) {
            paramObject1 = ((SoftReference) paramObject2).get();
        }
        return paramObject1;
    }

    public Object remove(Object paramObject) {
        processQueue();
        return this.hash.remove(paramObject);
    }

    public int size() {
        processQueue();
        return this.hash.size();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/scopedpool/SoftValueHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */