/*    */
package android.renderscript;

/*    */
/*    */ public class Script
/*    */ extends BaseObj
/*    */ {
    /*    */   public static class Builder {
        /*  7 */     Builder() {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/*    */   public static class FieldBase {
        protected Element mElement;

        /*    */
/* 11 */
        protected FieldBase() {
            throw new RuntimeException("Stub!");
        }

        /* 12 */
        protected void init(RenderScript rs, int dimx) {
            throw new RuntimeException("Stub!");
        }

        /* 13 */
        protected void init(RenderScript rs, int dimx, int usages) {
            throw new RuntimeException("Stub!");
        }

        /* 14 */
        public Element getElement() {
            throw new RuntimeException("Stub!");
        }

        /* 15 */
        public Type getType() {
            throw new RuntimeException("Stub!");
        }

        /* 16 */
        public Allocation getAllocation() {
            throw new RuntimeException("Stub!");
        }

        /* 17 */
        public void updateAllocation() {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */     protected Allocation mAllocation;
    }

    /*    */
/* 21 */   Script() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    protected void invoke(int slot) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    protected void invoke(int slot, FieldPacker v) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    protected void forEach(int slot, Allocation ain, Allocation aout, FieldPacker v) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public void bindAllocation(Allocation va, int slot) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void setVar(int index, float v) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void setVar(int index, double v) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void setVar(int index, int v) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void setVar(int index, long v) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void setVar(int index, boolean v) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public void setVar(int index, BaseObj o) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public void setVar(int index, FieldPacker v) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public void setVar(int index, FieldPacker v, Element e, int[] dims) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public void setTimeZone(String timeZone) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/renderscript/Script.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */