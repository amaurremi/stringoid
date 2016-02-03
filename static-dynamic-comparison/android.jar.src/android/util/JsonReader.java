/*    */
package android.util;
/*    */ 
/*    */

import java.io.IOException;

/*    */
/*  5 */ public final class JsonReader implements java.io.Closeable {
    public JsonReader(java.io.Reader in) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public void setLenient(boolean lenient) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public boolean isLenient() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void beginArray() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void endArray() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void beginObject() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void endObject() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public boolean hasNext() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public JsonToken peek() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public String nextName() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public String nextString() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public boolean nextBoolean() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void nextNull() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public double nextDouble() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public long nextLong() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public int nextInt() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void close() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void skipValue() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/util/JsonReader.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */