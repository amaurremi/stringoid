/*   */
package android.media.effect;

/*   */
/*   */ public abstract class Effect {
    /* 4 */
    public Effect() {
        throw new RuntimeException("Stub!");
    }

    /*   */
    public abstract String getName();

    /*   */
    public abstract void apply(int paramInt1, int paramInt2, int paramInt3, int paramInt4);

    /*   */
    public abstract void setParameter(String paramString, Object paramObject);

    /* 8 */
    public void setUpdateListener(EffectUpdateListener listener) {
        throw new RuntimeException("Stub!");
    }

    /*   */
/*   */
    public abstract void release();
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/media/effect/Effect.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */