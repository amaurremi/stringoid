package javassist.bytecode;

public class AccessFlag {
    public static final int ABSTRACT = 1024;
    public static final int ANNOTATION = 8192;
    public static final int BRIDGE = 64;
    public static final int ENUM = 16384;
    public static final int FINAL = 16;
    public static final int INTERFACE = 512;
    public static final int NATIVE = 256;
    public static final int PRIVATE = 2;
    public static final int PROTECTED = 4;
    public static final int PUBLIC = 1;
    public static final int STATIC = 8;
    public static final int STRICT = 2048;
    public static final int SUPER = 32;
    public static final int SYNCHRONIZED = 32;
    public static final int SYNTHETIC = 4096;
    public static final int TRANSIENT = 128;
    public static final int VARARGS = 128;
    public static final int VOLATILE = 64;

    public static int clear(int paramInt1, int paramInt2) {
        return (paramInt2 ^ 0xFFFFFFFF) & paramInt1;
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

    public static int of(int paramInt) {
        return paramInt;
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

    public static int toModifier(int paramInt) {
        return paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/AccessFlag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */