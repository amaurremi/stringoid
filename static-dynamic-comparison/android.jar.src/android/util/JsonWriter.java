/*    */
package android.util;
/*    */ 
/*    */

import java.io.IOException;

/*    */
/*  5 */ public final class JsonWriter implements java.io.Closeable {
    public JsonWriter(java.io.Writer out) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public void setIndent(String indent) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void setLenient(boolean lenient) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public boolean isLenient() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public JsonWriter beginArray() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public JsonWriter endArray() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public JsonWriter beginObject() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public JsonWriter endObject() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public JsonWriter name(String name) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public JsonWriter value(String value) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public JsonWriter nullValue() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public JsonWriter value(boolean value) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public JsonWriter value(double value) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public JsonWriter value(long value) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public JsonWriter value(Number value) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void flush() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void close() throws IOException {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/util/JsonWriter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */