package android.content.res;

import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

public abstract interface XmlResourceParser
        extends XmlPullParser, AttributeSet {
    public abstract void close();
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/res/XmlResourceParser.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */