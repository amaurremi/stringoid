package javassist;

public class Modifier {
    public static final int ABSTRACT = 1024;
    public static final int ANNOTATION = 8192;
    public static final int ENUM = 16384;
    public static final int FINAL = 16;
    public static final int INTERFACE = 512;
    public static final int NATIVE = 256;
    public static final int PRIVATE = 2;
    public static final int PROTECTED = 4;
    public static final int PUBLIC = 1;
    public static final int STATIC = 8;
    public static final int STRICT = 2048;
    public static final int SYNCHRONIZED = 32;
    public static final int TRANSIENT = 128;
    public static final int VARARGS = 128;
    public static final int VOLATILE = 64;

    public static int clear(int paramInt1, int paramInt2) {
        return (paramInt2 ^ 0xFFFFFFFF) & paramInt1;
    }

    public static boolean isAbstract(int paramInt) {
        return (paramInt & 0x400) != 0;
    }

    public static boolean isAnnotation(int paramInt) {
        return (paramInt & 0x2000) != 0;
    }

    public static boolean isEnum(int paramInt) {
        return (paramInt & 0x4000) != 0;
    }

    public static boolean isFinal(int paramInt) {
        return (paramInt & 0x10) != 0;
    }

    public static boolean isInterface(int paramInt) {
        return (paramInt & 0x200) != 0;
    }

    public static boolean isNative(int paramInt) {
        return (paramInt & 0x100) != 0;
    }

    public static boolean isPackage(int paramInt) {
        return (paramInt & 0x7) == 0;
    }

    public static boolean isPrivate(int paramInt) {
        return (paramInt & 0x2) != 0;
    }

    public static boolean isProtected(int paramInt) {
        return (paramInt & 0x4) != 0;
    }

    public static boolean isPublic(int paramInt) {
        return (paramInt & 0x1) != 0;
    }

    public static boolean isStatic(int paramInt) {
        return (paramInt & 0x8) != 0;
    }

    public static boolean isStrict(int paramInt) {
        return (paramInt & 0x800) != 0;
    }

    public static boolean isSynchronized(int paramInt) {
        return (paramInt & 0x20) != 0;
    }

    public static boolean isTransient(int paramInt) {
        return (paramInt & 0x80) != 0;
    }

    public static boolean isVolatile(int paramInt) {
        return (paramInt & 0x40) != 0;
    }

    public static int setPackage(int paramInt) {
        return paramInt & 0xFFFFFFF8;
    }

    public static int setPrivate(int paramInt) {
        return paramInt & 0xFFFFFFFA | 0x2;
    }

    public static int setProtected(int paramInt) {
        return paramInt & 0xFFFFFFFC | 0x4;
    }

    public static int setPublic(int paramInt) {
        return paramInt & 0xFFFFFFF9 | 0x1;
    }

    public static String toString(int paramInt) {
        return java.lang.reflect.Modifier.toString(paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/Modifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */