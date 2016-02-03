package android.nfc.tech;

import android.nfc.Tag;

import java.io.Closeable;
import java.io.IOException;

public abstract interface TagTechnology
        extends Closeable {
    public abstract Tag getTag();

    public abstract void connect()
            throws IOException;

    public abstract void close()
            throws IOException;

    public abstract boolean isConnected();
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/nfc/tech/TagTechnology.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */