/*     */
package android.graphics;

/*     */
/*     */ public class Paint {
    public static final int ANTI_ALIAS_FLAG = 1;
    /*     */   public static final int FILTER_BITMAP_FLAG = 2;

    /*     */
/*   6 */   public static enum Style {
        FILL,
        /*   7 */     FILL_AND_STROKE,
        /*   8 */     STROKE;

        /*     */
/*     */
        private Style() {
        }
    }

    /*     */
/*  12 */   public static enum Cap {
        BUTT,
        /*  13 */     ROUND,
        /*  14 */     SQUARE;

        /*     */
/*     */
        private Cap() {
        }
    }

    /*     */
/*  18 */   public static final int DITHER_FLAG = 4;

    public static enum Join {
        BEVEL,
        /*  19 */     MITER,
        /*  20 */     ROUND;

        /*     */
/*     */
        private Join() {
        }
    }

    /*     */
/*  24 */   public static enum Align {
        CENTER,
        /*  25 */     LEFT,
        /*  26 */     RIGHT;

        /*     */
/*     */
        private Align() {
        }
    }

    /*     */   public static class FontMetrics {
        public float top;
        public float ascent;
        public float descent;

        /*  30 */
        public FontMetrics() {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */     public float bottom;
        /*     */     public float leading;
    }

    /*     */
/*     */   public static final int UNDERLINE_TEXT_FLAG = 8;
    /*     */   public static final int STRIKE_THRU_TEXT_FLAG = 16;

    /*     */   public static class FontMetricsInt {
        public int top;
        /*     */     public int ascent;
        public int descent;

        /*  39 */
        public FontMetricsInt() {
            throw new RuntimeException("Stub!");
        }

        /*  40 */
        public String toString() {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */ 
/*     */     public int bottom;
        /*     */     public int leading;
/*     */
    }

    /*     */
/*  47 */
    public Paint() {
        throw new RuntimeException("Stub!");
    }

    /*  48 */
    public Paint(int flags) {
        throw new RuntimeException("Stub!");
    }

    /*  49 */
    public Paint(Paint paint) {
        throw new RuntimeException("Stub!");
    }

    /*  50 */
    public void reset() {
        throw new RuntimeException("Stub!");
    }

    /*  51 */
    public void set(Paint src) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    public native int getFlags();

    /*     */
    public native void setFlags(int paramInt);

    /*     */
    public native int getHinting();

    /*     */
    public native void setHinting(int paramInt);

    /*  56 */
    public final boolean isAntiAlias() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    public native void setAntiAlias(boolean paramBoolean);

    /*  58 */
    public final boolean isDither() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    public native void setDither(boolean paramBoolean);

    /*     */
    @Deprecated
/*  61 */ public final boolean isLinearText() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/*     */ public native void setLinearText(boolean paramBoolean);

    /*  64 */
    public final boolean isSubpixelText() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    public native void setSubpixelText(boolean paramBoolean);

    /*  66 */
    public final boolean isUnderlineText() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    public native void setUnderlineText(boolean paramBoolean);

    /*  68 */
    public final boolean isStrikeThruText() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    public native void setStrikeThruText(boolean paramBoolean);

    /*  70 */
    public final boolean isFakeBoldText() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    public native void setFakeBoldText(boolean paramBoolean);

    /*  72 */
    public final boolean isFilterBitmap() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    public native void setFilterBitmap(boolean paramBoolean);

    /*  74 */
    public Style getStyle() {
        throw new RuntimeException("Stub!");
    }

    /*  75 */
    public void setStyle(Style style) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    public native int getColor();

    /*     */
    public native void setColor(int paramInt);

    /*     */
    public native int getAlpha();

    /*     */
    public native void setAlpha(int paramInt);

    /*  80 */
    public void setARGB(int a, int r, int g, int b) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    public native float getStrokeWidth();

    /*     */
    public native void setStrokeWidth(float paramFloat);

    /*     */
    public native float getStrokeMiter();

    /*     */
    public native void setStrokeMiter(float paramFloat);

    /*  85 */
    public Cap getStrokeCap() {
        throw new RuntimeException("Stub!");
    }

    /*  86 */
    public void setStrokeCap(Cap cap) {
        throw new RuntimeException("Stub!");
    }

    /*  87 */
    public Join getStrokeJoin() {
        throw new RuntimeException("Stub!");
    }

    /*  88 */
    public void setStrokeJoin(Join join) {
        throw new RuntimeException("Stub!");
    }

    /*  89 */
    public boolean getFillPath(Path src, Path dst) {
        throw new RuntimeException("Stub!");
    }

    /*  90 */
    public Shader getShader() {
        throw new RuntimeException("Stub!");
    }

    /*  91 */
    public Shader setShader(Shader shader) {
        throw new RuntimeException("Stub!");
    }

    /*  92 */
    public ColorFilter getColorFilter() {
        throw new RuntimeException("Stub!");
    }

    /*  93 */
    public ColorFilter setColorFilter(ColorFilter filter) {
        throw new RuntimeException("Stub!");
    }

    /*  94 */
    public Xfermode getXfermode() {
        throw new RuntimeException("Stub!");
    }

    /*  95 */
    public Xfermode setXfermode(Xfermode xfermode) {
        throw new RuntimeException("Stub!");
    }

    /*  96 */
    public PathEffect getPathEffect() {
        throw new RuntimeException("Stub!");
    }

    /*  97 */
    public PathEffect setPathEffect(PathEffect effect) {
        throw new RuntimeException("Stub!");
    }

    /*  98 */
    public MaskFilter getMaskFilter() {
        throw new RuntimeException("Stub!");
    }

    /*  99 */
    public MaskFilter setMaskFilter(MaskFilter maskfilter) {
        throw new RuntimeException("Stub!");
    }

    /* 100 */
    public Typeface getTypeface() {
        throw new RuntimeException("Stub!");
    }

    /* 101 */
    public Typeface setTypeface(Typeface typeface) {
        throw new RuntimeException("Stub!");
    }

    /* 102 */
    public Rasterizer getRasterizer() {
        throw new RuntimeException("Stub!");
    }

    /* 103 */
    public Rasterizer setRasterizer(Rasterizer rasterizer) {
        throw new RuntimeException("Stub!");
    }

    /* 104 */
    public void setShadowLayer(float radius, float dx, float dy, int color) {
        throw new RuntimeException("Stub!");
    }

    /* 105 */
    public void clearShadowLayer() {
        throw new RuntimeException("Stub!");
    }

    /* 106 */
    public Align getTextAlign() {
        throw new RuntimeException("Stub!");
    }

    /* 107 */
    public void setTextAlign(Align align) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    public native float getTextSize();

    /*     */
    public native void setTextSize(float paramFloat);

    /*     */
    public native float getTextScaleX();

    /*     */
    public native void setTextScaleX(float paramFloat);

    /*     */
    public native float getTextSkewX();

    /*     */
    public native void setTextSkewX(float paramFloat);

    /*     */
    public native float ascent();

    /*     */
    public native float descent();

    /*     */
    public native float getFontMetrics(FontMetrics paramFontMetrics);

    /* 117 */
    public FontMetrics getFontMetrics() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    public native int getFontMetricsInt(FontMetricsInt paramFontMetricsInt);

    /* 119 */
    public FontMetricsInt getFontMetricsInt() {
        throw new RuntimeException("Stub!");
    }

    /* 120 */
    public float getFontSpacing() {
        throw new RuntimeException("Stub!");
    }

    /* 121 */
    public float measureText(char[] text, int index, int count) {
        throw new RuntimeException("Stub!");
    }

    /* 122 */
    public float measureText(String text, int start, int end) {
        throw new RuntimeException("Stub!");
    }

    /* 123 */
    public float measureText(String text) {
        throw new RuntimeException("Stub!");
    }

    /* 124 */
    public float measureText(CharSequence text, int start, int end) {
        throw new RuntimeException("Stub!");
    }

    /* 125 */
    public int breakText(char[] text, int index, int count, float maxWidth, float[] measuredWidth) {
        throw new RuntimeException("Stub!");
    }

    /* 126 */
    public int breakText(CharSequence text, int start, int end, boolean measureForwards, float maxWidth, float[] measuredWidth) {
        throw new RuntimeException("Stub!");
    }

    /* 127 */
    public int breakText(String text, boolean measureForwards, float maxWidth, float[] measuredWidth) {
        throw new RuntimeException("Stub!");
    }

    /* 128 */
    public int getTextWidths(char[] text, int index, int count, float[] widths) {
        throw new RuntimeException("Stub!");
    }

    /* 129 */
    public int getTextWidths(CharSequence text, int start, int end, float[] widths) {
        throw new RuntimeException("Stub!");
    }

    /* 130 */
    public int getTextWidths(String text, int start, int end, float[] widths) {
        throw new RuntimeException("Stub!");
    }

    /* 131 */
    public int getTextWidths(String text, float[] widths) {
        throw new RuntimeException("Stub!");
    }

    /* 132 */
    public void getTextPath(char[] text, int index, int count, float x, float y, Path path) {
        throw new RuntimeException("Stub!");
    }

    /* 133 */
    public void getTextPath(String text, int start, int end, float x, float y, Path path) {
        throw new RuntimeException("Stub!");
    }

    /* 134 */
    public void getTextBounds(String text, int start, int end, Rect bounds) {
        throw new RuntimeException("Stub!");
    }

    /* 135 */
    public void getTextBounds(char[] text, int index, int count, Rect bounds) {
        throw new RuntimeException("Stub!");
    }

    /* 136 */
    protected void finalize() throws Throwable {
        throw new RuntimeException("Stub!");
    }

    /*     */
/*     */   public static final int FAKE_BOLD_TEXT_FLAG = 32;
    /*     */   public static final int LINEAR_TEXT_FLAG = 64;
    /*     */   public static final int SUBPIXEL_TEXT_FLAG = 128;
    /*     */   public static final int DEV_KERN_TEXT_FLAG = 256;
    /*     */   public static final int HINTING_OFF = 0;
    /*     */   public static final int HINTING_ON = 1;
/*     */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/graphics/Paint.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */