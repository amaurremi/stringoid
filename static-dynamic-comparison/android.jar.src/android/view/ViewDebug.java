/*    */
package android.view;
/*    */ 
/*    */

import java.lang.annotation.Annotation;

/*    */
/*    */ public class ViewDebug {
    @java.lang.annotation.Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.METHOD})
/*    */
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
/*    */ public static @interface ExportedProperty {
        boolean resolveId() default false;

        /*    */
/*    */     ViewDebug.IntToString[] mapping() default {};

        /*    */
/*    */     ViewDebug.IntToString[] indexMapping() default {};

        /*    */
/*    */     ViewDebug.FlagToString[] flagMapping() default {};

        /*    */
/*    */     boolean deepExport() default false;

        /*    */
/*    */     String prefix() default "";

        /*    */
/*    */     String category() default "";
    }

    /*    */
/*    */
    @java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
/*    */
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
/*    */ public static @interface IntToString {
        int from();

        /*    */
/*    */     String to();
    }

    /*    */
/*    */
    @java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
/*    */
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
/*    */ public static @interface FlagToString {
        int mask();

        /*    */
/*    */     int equals();

        /*    */
/*    */     String name();

        /*    */
/*    */     boolean outputIf() default true;
    }

    /*    */
/*    */
    @java.lang.annotation.Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.METHOD})
/*    */
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
/*    */ public static @interface CapturedViewProperty {
        boolean retrieveReturn() default false;
    }

    /*    */
    @Deprecated
/* 41 */ public static enum HierarchyTraceType {
        BUILD_CACHE,
        /* 42 */     DRAW,
        /* 43 */     INVALIDATE,
        /* 44 */     INVALIDATE_CHILD,
        /* 45 */     INVALIDATE_CHILD_IN_PARENT,
        /* 46 */     ON_LAYOUT,
        /* 47 */     ON_MEASURE,
        /* 48 */     REQUEST_LAYOUT;

        /*    */
/*    */
        private HierarchyTraceType() {
        }
    }

    /*    */
/*    */
    @Deprecated
/* 53 */ public static enum RecyclerTraceType {
        BIND_VIEW,
        /* 54 */     MOVE_FROM_ACTIVE_TO_SCRAP_HEAP,
        /* 55 */     MOVE_TO_SCRAP_HEAP,
        /* 56 */     NEW_VIEW,
        /* 57 */     RECYCLE_FROM_ACTIVE_HEAP,
        /* 58 */     RECYCLE_FROM_SCRAP_HEAP;

        /*    */
        private RecyclerTraceType() {
        }
    }

    /* 60 */
    public ViewDebug() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */
    @Deprecated
/* 63 */ public static void trace(View view, RecyclerTraceType type, int... parameters) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */
    @Deprecated
/* 66 */ public static void startRecyclerTracing(String prefix, View view) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */
    @Deprecated
/* 69 */ public static void stopRecyclerTracing() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */
    @Deprecated
/* 72 */ public static void trace(View view, HierarchyTraceType type) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */
    @Deprecated
/* 75 */ public static void startHierarchyTracing(String prefix, View view) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 77 */ public static void stopHierarchyTracing() {
        throw new RuntimeException("Stub!");
    }

    /* 78 */
    public static void dumpCapturedView(String tag, Object view) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */
    @Deprecated
/*    */ public static final boolean TRACE_HIERARCHY = false;
    /*    */
    @Deprecated
/*    */ public static final boolean TRACE_RECYCLER = false;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/ViewDebug.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */