/*    */
package android.renderscript;

/*    */
/*    */
@Deprecated
/*    */ public class Mesh extends BaseObj
/*    */ {
    /*    */
    @Deprecated
/*    */ public static enum Primitive
/*    */ {
        /*  9 */     LINE,
        /* 10 */     LINE_STRIP,
        /* 11 */     POINT,
        /* 12 */     TRIANGLE,
        /* 13 */     TRIANGLE_FAN,
        /* 14 */     TRIANGLE_STRIP;

        /*    */
/*    */
        private Primitive() {
        }
    }

    /*    */
/*    */
    @Deprecated
/*    */ public static class Builder {
        @Deprecated
/* 20 */ public Builder(RenderScript rs, int usage) {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 22 */ public int getCurrentVertexTypeIndex() {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 24 */ public int getCurrentIndexSetIndex() {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 26 */ public Builder addVertexType(Type t) throws IllegalStateException {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 28 */ public Builder addVertexType(Element e, int size) throws IllegalStateException {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 30 */ public Builder addIndexSetType(Type t, Mesh.Primitive p) {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 32 */ public Builder addIndexSetType(Mesh.Primitive p) {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 34 */ public Builder addIndexSetType(Element e, int size, Mesh.Primitive p) {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 36 */ public Mesh create() {
            throw new RuntimeException("Stub!");
        }
/*    */
    }

    /*    */
/*    */
    @Deprecated
/*    */ public static class AllocationBuilder {
        /*    */
        @Deprecated
/* 42 */ public AllocationBuilder(RenderScript rs) {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 44 */ public int getCurrentVertexTypeIndex() {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 46 */ public int getCurrentIndexSetIndex() {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 48 */ public AllocationBuilder addVertexAllocation(Allocation a) throws IllegalStateException {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 50 */ public AllocationBuilder addIndexSetAllocation(Allocation a, Mesh.Primitive p) {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 52 */ public AllocationBuilder addIndexSetType(Mesh.Primitive p) {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 54 */ public Mesh create() {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
    @Deprecated
/*    */ public static class TriangleMeshBuilder {
        @Deprecated
/*    */ public static final int COLOR = 1;
        @Deprecated
/*    */ public static final int NORMAL = 2;

        /*    */
        @Deprecated
/* 60 */ public TriangleMeshBuilder(RenderScript rs, int vtxSize, int flags) {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 62 */ public TriangleMeshBuilder addVertex(float x, float y) {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 64 */ public TriangleMeshBuilder addVertex(float x, float y, float z) {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 66 */ public TriangleMeshBuilder setTexture(float s, float t) {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 68 */ public TriangleMeshBuilder setNormal(float x, float y, float z) {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 70 */ public TriangleMeshBuilder setColor(float r, float g, float b, float a) {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 72 */ public TriangleMeshBuilder addTriangle(int idx1, int idx2, int idx3) {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 74 */ public Mesh create(boolean uploadToBufferObject) {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */ 
/*    */
        @Deprecated
/*    */ public static final int TEXTURE_0 = 256;
/*    */
    }

    /*    */
/*    */ 
/* 82 */   Mesh() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 84 */ public int getVertexAllocationCount() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 86 */ public Allocation getVertexAllocation(int slot) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 88 */ public int getPrimitiveCount() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 90 */ public Allocation getIndexSetAllocation(int slot) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 92 */ public Primitive getPrimitive(int slot) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/renderscript/Mesh.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */