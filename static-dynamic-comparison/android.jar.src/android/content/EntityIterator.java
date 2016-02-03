package android.content;

import java.util.Iterator;

public abstract interface EntityIterator
        extends Iterator<Entity> {
    public abstract void reset();

    public abstract void close();
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/EntityIterator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */