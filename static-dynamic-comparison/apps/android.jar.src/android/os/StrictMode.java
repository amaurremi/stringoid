/*    */
package android.os;

/*    */
/*    */ 
/*    */ public final class StrictMode
/*    */ {
    /*    */   public static final class ThreadPolicy {
        /*    */     public static final class Builder {
            /*  8 */
            public Builder() {
                throw new RuntimeException("Stub!");
            }

            /*  9 */
            public Builder(StrictMode.ThreadPolicy policy) {
                throw new RuntimeException("Stub!");
            }

            /* 10 */
            public Builder detectAll() {
                throw new RuntimeException("Stub!");
            }

            /* 11 */
            public Builder permitAll() {
                throw new RuntimeException("Stub!");
            }

            /* 12 */
            public Builder detectNetwork() {
                throw new RuntimeException("Stub!");
            }

            /* 13 */
            public Builder permitNetwork() {
                throw new RuntimeException("Stub!");
            }

            /* 14 */
            public Builder detectDiskReads() {
                throw new RuntimeException("Stub!");
            }

            /* 15 */
            public Builder permitDiskReads() {
                throw new RuntimeException("Stub!");
            }

            /* 16 */
            public Builder detectCustomSlowCalls() {
                throw new RuntimeException("Stub!");
            }

            /* 17 */
            public Builder permitCustomSlowCalls() {
                throw new RuntimeException("Stub!");
            }

            /* 18 */
            public Builder detectDiskWrites() {
                throw new RuntimeException("Stub!");
            }

            /* 19 */
            public Builder permitDiskWrites() {
                throw new RuntimeException("Stub!");
            }

            /* 20 */
            public Builder penaltyDialog() {
                throw new RuntimeException("Stub!");
            }

            /* 21 */
            public Builder penaltyDeath() {
                throw new RuntimeException("Stub!");
            }

            /* 22 */
            public Builder penaltyDeathOnNetwork() {
                throw new RuntimeException("Stub!");
            }

            /* 23 */
            public Builder penaltyFlashScreen() {
                throw new RuntimeException("Stub!");
            }

            /* 24 */
            public Builder penaltyLog() {
                throw new RuntimeException("Stub!");
            }

            /* 25 */
            public Builder penaltyDropBox() {
                throw new RuntimeException("Stub!");
            }

            /* 26 */
            public StrictMode.ThreadPolicy build() {
                throw new RuntimeException("Stub!");
            }
        }

        /*    */
/* 28 */     ThreadPolicy() {
            throw new RuntimeException("Stub!");
        }

        /* 29 */
        public String toString() {
            throw new RuntimeException("Stub!");
        }

        /*    */
/* 31 */     public static final ThreadPolicy LAX = null;
/*    */
    }

    /*    */
/*    */ 
/*    */   public static final class VmPolicy {
        /*    */     public static final class Builder {
            /* 37 */
            public Builder() {
                throw new RuntimeException("Stub!");
            }

            /* 38 */
            public Builder(StrictMode.VmPolicy base) {
                throw new RuntimeException("Stub!");
            }

            /* 39 */
            public Builder setClassInstanceLimit(Class klass, int instanceLimit) {
                throw new RuntimeException("Stub!");
            }

            /* 40 */
            public Builder detectActivityLeaks() {
                throw new RuntimeException("Stub!");
            }

            /* 41 */
            public Builder detectAll() {
                throw new RuntimeException("Stub!");
            }

            /* 42 */
            public Builder detectLeakedSqlLiteObjects() {
                throw new RuntimeException("Stub!");
            }

            /* 43 */
            public Builder detectLeakedClosableObjects() {
                throw new RuntimeException("Stub!");
            }

            /* 44 */
            public Builder detectLeakedRegistrationObjects() {
                throw new RuntimeException("Stub!");
            }

            /* 45 */
            public Builder penaltyDeath() {
                throw new RuntimeException("Stub!");
            }

            /* 46 */
            public Builder penaltyLog() {
                throw new RuntimeException("Stub!");
            }

            /* 47 */
            public Builder penaltyDropBox() {
                throw new RuntimeException("Stub!");
            }

            /* 48 */
            public StrictMode.VmPolicy build() {
                throw new RuntimeException("Stub!");
            }
        }

        /*    */
/* 50 */     VmPolicy() {
            throw new RuntimeException("Stub!");
        }

        /* 51 */
        public String toString() {
            throw new RuntimeException("Stub!");
        }

        /*    */
/* 53 */     public static final VmPolicy LAX = null;
    }

    /*    */
/* 55 */   StrictMode() {
        throw new RuntimeException("Stub!");
    }

    /* 56 */
    public static void setThreadPolicy(ThreadPolicy policy) {
        throw new RuntimeException("Stub!");
    }

    /* 57 */
    public static ThreadPolicy getThreadPolicy() {
        throw new RuntimeException("Stub!");
    }

    /* 58 */
    public static ThreadPolicy allowThreadDiskWrites() {
        throw new RuntimeException("Stub!");
    }

    /* 59 */
    public static ThreadPolicy allowThreadDiskReads() {
        throw new RuntimeException("Stub!");
    }

    /* 60 */
    public static void setVmPolicy(VmPolicy policy) {
        throw new RuntimeException("Stub!");
    }

    /* 61 */
    public static VmPolicy getVmPolicy() {
        throw new RuntimeException("Stub!");
    }

    /* 62 */
    public static void enableDefaults() {
        throw new RuntimeException("Stub!");
    }

    /* 63 */
    public static void noteSlowCall(String name) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/os/StrictMode.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */