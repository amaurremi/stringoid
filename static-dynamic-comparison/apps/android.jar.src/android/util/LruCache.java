/*    */
package android.util;
/*    */

import java.util.Map;

/*    */
/*  4 */ public class LruCache<K, V> {
    public LruCache(int maxSize) {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public final V get(K key) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public final V put(K key, V value) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public final V remove(K key) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    protected void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    protected V create(K key) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    protected int sizeOf(K key, V value) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public final void evictAll() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public final synchronized int size() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public final synchronized int maxSize() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public final synchronized int hitCount() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public final synchronized int missCount() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public final synchronized int createCount() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public final synchronized int putCount() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public final synchronized int evictionCount() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public final synchronized Map<K, V> snapshot() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public final synchronized String toString() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/util/LruCache.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */