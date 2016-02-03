/*    */
package android.util;

/*    */
/*    */ public abstract class Property<T, V> {
    /*  4 */
    public Property(Class<V> type, String name) {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public static <T, V> Property<T, V> of(Class<T> hostType, Class<V> valueType, String name) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public boolean isReadOnly() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void set(T object, V value) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public abstract V get(T paramT);

    /*  9 */
    public String getName() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public Class<V> getType() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/util/Property.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */