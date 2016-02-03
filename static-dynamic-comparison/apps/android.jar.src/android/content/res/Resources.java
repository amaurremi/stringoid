/*    */
package android.content.res;
/*    */ 
/*    */

import android.util.TypedValue;

/*    */
/*    */ public class Resources {
    /*    */   public static class NotFoundException extends RuntimeException {
        /*  7 */
        public NotFoundException() {
            throw new RuntimeException("Stub!");
        }

        /*  8 */
        public NotFoundException(String name) {
            throw new RuntimeException("Stub!");
        }
/*    */
    }

    /*    */
/*    */   public final class Theme {
        /* 12 */     Theme() {
            throw new RuntimeException("Stub!");
        }

        /* 13 */
        public void applyStyle(int resid, boolean force) {
            throw new RuntimeException("Stub!");
        }

        /* 14 */
        public void setTo(Theme other) {
            throw new RuntimeException("Stub!");
        }

        /* 15 */
        public TypedArray obtainStyledAttributes(int[] attrs) {
            throw new RuntimeException("Stub!");
        }

        /* 16 */
        public TypedArray obtainStyledAttributes(int resid, int[] attrs) throws Resources.NotFoundException {
            throw new RuntimeException("Stub!");
        }

        /* 17 */
        public TypedArray obtainStyledAttributes(android.util.AttributeSet set, int[] attrs, int defStyleAttr, int defStyleRes) {
            throw new RuntimeException("Stub!");
        }

        /* 18 */
        public boolean resolveAttribute(int resid, TypedValue outValue, boolean resolveRefs) {
            throw new RuntimeException("Stub!");
        }

        /* 19 */
        public void dump(int priority, String tag, String prefix) {
            throw new RuntimeException("Stub!");
        }

        /* 20 */
        protected void finalize() throws Throwable {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 22 */
    public Resources(AssetManager assets, android.util.DisplayMetrics metrics, Configuration config) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public static Resources getSystem() {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public CharSequence getText(int id) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public CharSequence getQuantityText(int id, int quantity) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public String getString(int id) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public String getString(int id, Object... formatArgs) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public String getQuantityString(int id, int quantity, Object... formatArgs) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public String getQuantityString(int id, int quantity) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public CharSequence getText(int id, CharSequence def) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public CharSequence[] getTextArray(int id) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public String[] getStringArray(int id) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public int[] getIntArray(int id) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public TypedArray obtainTypedArray(int id) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public float getDimension(int id) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public int getDimensionPixelOffset(int id) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public int getDimensionPixelSize(int id) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public float getFraction(int id, int base, int pbase) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public android.graphics.drawable.Drawable getDrawable(int id) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public android.graphics.drawable.Drawable getDrawableForDensity(int id, int density) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public android.graphics.Movie getMovie(int id) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public int getColor(int id) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public ColorStateList getColorStateList(int id) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public boolean getBoolean(int id) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public int getInteger(int id) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    public XmlResourceParser getLayout(int id) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    public XmlResourceParser getAnimation(int id) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    public XmlResourceParser getXml(int id) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    public java.io.InputStream openRawResource(int id) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 50 */
    public java.io.InputStream openRawResource(int id, TypedValue value) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 51 */
    public AssetFileDescriptor openRawResourceFd(int id) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 52 */
    public void getValue(int id, TypedValue outValue, boolean resolveRefs) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 53 */
    public void getValueForDensity(int id, int density, TypedValue outValue, boolean resolveRefs) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 54 */
    public void getValue(String name, TypedValue outValue, boolean resolveRefs) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 55 */
    public final Theme newTheme() {
        throw new RuntimeException("Stub!");
    }

    /* 56 */
    public TypedArray obtainAttributes(android.util.AttributeSet set, int[] attrs) {
        throw new RuntimeException("Stub!");
    }

    /* 57 */
    public void updateConfiguration(Configuration config, android.util.DisplayMetrics metrics) {
        throw new RuntimeException("Stub!");
    }

    /* 58 */
    public android.util.DisplayMetrics getDisplayMetrics() {
        throw new RuntimeException("Stub!");
    }

    /* 59 */
    public Configuration getConfiguration() {
        throw new RuntimeException("Stub!");
    }

    /* 60 */
    public int getIdentifier(String name, String defType, String defPackage) {
        throw new RuntimeException("Stub!");
    }

    /* 61 */
    public String getResourceName(int resid) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 62 */
    public String getResourcePackageName(int resid) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 63 */
    public String getResourceTypeName(int resid) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 64 */
    public String getResourceEntryName(int resid) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 65 */
    public void parseBundleExtras(XmlResourceParser parser, android.os.Bundle outBundle) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 66 */
    public void parseBundleExtra(String tagName, android.util.AttributeSet attrs, android.os.Bundle outBundle) throws org.xmlpull.v1.XmlPullParserException {
        throw new RuntimeException("Stub!");
    }

    /* 67 */
    public final AssetManager getAssets() {
        throw new RuntimeException("Stub!");
    }

    /* 68 */
    public final void flushLayoutCache() {
        throw new RuntimeException("Stub!");
    }

    /* 69 */
    public final void finishPreloading() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/res/Resources.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */