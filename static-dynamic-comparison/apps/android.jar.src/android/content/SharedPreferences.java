package android.content;

import java.util.Map;
import java.util.Set;

public abstract interface SharedPreferences {
    public abstract Map<String, ?> getAll();

    public abstract String getString(String paramString1, String paramString2);

    public abstract Set<String> getStringSet(String paramString, Set<String> paramSet);

    public abstract int getInt(String paramString, int paramInt);

    public abstract long getLong(String paramString, long paramLong);

    public abstract float getFloat(String paramString, float paramFloat);

    public abstract boolean getBoolean(String paramString, boolean paramBoolean);

    public abstract boolean contains(String paramString);

    public abstract Editor edit();

    public abstract void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener);

    public abstract void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener);

    public static abstract interface Editor {
        public abstract Editor putString(String paramString1, String paramString2);

        public abstract Editor putStringSet(String paramString, Set<String> paramSet);

        public abstract Editor putInt(String paramString, int paramInt);

        public abstract Editor putLong(String paramString, long paramLong);

        public abstract Editor putFloat(String paramString, float paramFloat);

        public abstract Editor putBoolean(String paramString, boolean paramBoolean);

        public abstract Editor remove(String paramString);

        public abstract Editor clear();

        public abstract boolean commit();

        public abstract void apply();
    }

    public static abstract interface OnSharedPreferenceChangeListener {
        public abstract void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString);
    }
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/SharedPreferences.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */