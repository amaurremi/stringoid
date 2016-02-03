package org.apache.commons.lang;

import java.io.File;
import java.io.PrintStream;

public class SystemUtils {
    public static final String AWT_TOOLKIT;
    public static final String FILE_ENCODING;
    public static final String FILE_SEPARATOR;
    public static final boolean IS_JAVA_1_1;
    public static final boolean IS_JAVA_1_2;
    public static final boolean IS_JAVA_1_3;
    public static final boolean IS_JAVA_1_4;
    public static final boolean IS_JAVA_1_5;
    public static final boolean IS_JAVA_1_6;
    public static final boolean IS_JAVA_1_7;
    public static final boolean IS_OS_AIX;
    public static final boolean IS_OS_HP_UX;
    public static final boolean IS_OS_IRIX;
    public static final boolean IS_OS_LINUX;
    public static final boolean IS_OS_MAC;
    public static final boolean IS_OS_MAC_OSX;
    public static final boolean IS_OS_OS2;
    public static final boolean IS_OS_SOLARIS;
    public static final boolean IS_OS_SUN_OS;
    public static final boolean IS_OS_UNIX;
    public static final boolean IS_OS_WINDOWS;
    public static final boolean IS_OS_WINDOWS_2000;
    public static final boolean IS_OS_WINDOWS_7;
    public static final boolean IS_OS_WINDOWS_95;
    public static final boolean IS_OS_WINDOWS_98;
    public static final boolean IS_OS_WINDOWS_ME;
    public static final boolean IS_OS_WINDOWS_NT;
    public static final boolean IS_OS_WINDOWS_VISTA;
    public static final boolean IS_OS_WINDOWS_XP;
    public static final String JAVA_AWT_FONTS;
    public static final String JAVA_AWT_GRAPHICSENV;
    public static final String JAVA_AWT_HEADLESS;
    public static final String JAVA_AWT_PRINTERJOB;
    public static final String JAVA_CLASS_PATH;
    public static final String JAVA_CLASS_VERSION;
    public static final String JAVA_COMPILER;
    public static final String JAVA_ENDORSED_DIRS;
    public static final String JAVA_EXT_DIRS;
    public static final String JAVA_HOME;
    private static final String JAVA_HOME_KEY = "java.home";
    public static final String JAVA_IO_TMPDIR;
    private static final String JAVA_IO_TMPDIR_KEY = "java.io.tmpdir";
    public static final String JAVA_LIBRARY_PATH;
    public static final String JAVA_RUNTIME_NAME;
    public static final String JAVA_RUNTIME_VERSION;
    public static final String JAVA_SPECIFICATION_NAME;
    public static final String JAVA_SPECIFICATION_VENDOR;
    public static final String JAVA_SPECIFICATION_VERSION;
    public static final String JAVA_UTIL_PREFS_PREFERENCES_FACTORY;
    public static final String JAVA_VENDOR;
    public static final String JAVA_VENDOR_URL;
    public static final String JAVA_VERSION;
    public static final float JAVA_VERSION_FLOAT;
    public static final int JAVA_VERSION_INT;
    public static final String JAVA_VERSION_TRIMMED;
    public static final String JAVA_VM_INFO;
    public static final String JAVA_VM_NAME;
    public static final String JAVA_VM_SPECIFICATION_NAME;
    public static final String JAVA_VM_SPECIFICATION_VENDOR;
    public static final String JAVA_VM_SPECIFICATION_VERSION;
    public static final String JAVA_VM_VENDOR;
    public static final String JAVA_VM_VERSION;
    public static final String LINE_SEPARATOR;
    public static final String OS_ARCH;
    public static final String OS_NAME;
    private static final String OS_NAME_WINDOWS_PREFIX = "Windows";
    public static final String OS_VERSION;
    public static final String PATH_SEPARATOR;
    public static final String USER_COUNTRY;
    public static final String USER_DIR;
    private static final String USER_DIR_KEY = "user.dir";
    public static final String USER_HOME;
    private static final String USER_HOME_KEY = "user.home";
    public static final String USER_LANGUAGE;
    public static final String USER_NAME;
    public static final String USER_TIMEZONE;

    static {
        boolean bool2 = false;
        AWT_TOOLKIT = getSystemProperty("awt.toolkit");
        FILE_ENCODING = getSystemProperty("file.encoding");
        FILE_SEPARATOR = getSystemProperty("file.separator");
        JAVA_AWT_FONTS = getSystemProperty("java.awt.fonts");
        JAVA_AWT_GRAPHICSENV = getSystemProperty("java.awt.graphicsenv");
        JAVA_AWT_HEADLESS = getSystemProperty("java.awt.headless");
        JAVA_AWT_PRINTERJOB = getSystemProperty("java.awt.printerjob");
        JAVA_CLASS_PATH = getSystemProperty("java.class.path");
        JAVA_CLASS_VERSION = getSystemProperty("java.class.version");
        JAVA_COMPILER = getSystemProperty("java.compiler");
        JAVA_ENDORSED_DIRS = getSystemProperty("java.endorsed.dirs");
        JAVA_EXT_DIRS = getSystemProperty("java.ext.dirs");
        JAVA_HOME = getSystemProperty("java.home");
        JAVA_IO_TMPDIR = getSystemProperty("java.io.tmpdir");
        JAVA_LIBRARY_PATH = getSystemProperty("java.library.path");
        JAVA_RUNTIME_NAME = getSystemProperty("java.runtime.name");
        JAVA_RUNTIME_VERSION = getSystemProperty("java.runtime.version");
        JAVA_SPECIFICATION_NAME = getSystemProperty("java.specification.name");
        JAVA_SPECIFICATION_VENDOR = getSystemProperty("java.specification.vendor");
        JAVA_SPECIFICATION_VERSION = getSystemProperty("java.specification.version");
        JAVA_UTIL_PREFS_PREFERENCES_FACTORY = getSystemProperty("java.util.prefs.PreferencesFactory");
        JAVA_VENDOR = getSystemProperty("java.vendor");
        JAVA_VENDOR_URL = getSystemProperty("java.vendor.url");
        JAVA_VERSION = getSystemProperty("java.version");
        JAVA_VM_INFO = getSystemProperty("java.vm.info");
        JAVA_VM_NAME = getSystemProperty("java.vm.name");
        JAVA_VM_SPECIFICATION_NAME = getSystemProperty("java.vm.specification.name");
        JAVA_VM_SPECIFICATION_VENDOR = getSystemProperty("java.vm.specification.vendor");
        JAVA_VM_SPECIFICATION_VERSION = getSystemProperty("java.vm.specification.version");
        JAVA_VM_VENDOR = getSystemProperty("java.vm.vendor");
        JAVA_VM_VERSION = getSystemProperty("java.vm.version");
        LINE_SEPARATOR = getSystemProperty("line.separator");
        OS_ARCH = getSystemProperty("os.arch");
        OS_NAME = getSystemProperty("os.name");
        OS_VERSION = getSystemProperty("os.version");
        PATH_SEPARATOR = getSystemProperty("path.separator");
        String str;
        if (getSystemProperty("user.country") == null) {
            str = getSystemProperty("user.region");
            USER_COUNTRY = str;
            USER_DIR = getSystemProperty("user.dir");
            USER_HOME = getSystemProperty("user.home");
            USER_LANGUAGE = getSystemProperty("user.language");
            USER_NAME = getSystemProperty("user.name");
            USER_TIMEZONE = getSystemProperty("user.timezone");
            JAVA_VERSION_TRIMMED = getJavaVersionTrimmed();
            JAVA_VERSION_FLOAT = getJavaVersionAsFloat();
            JAVA_VERSION_INT = getJavaVersionAsInt();
            IS_JAVA_1_1 = getJavaVersionMatches("1.1");
            IS_JAVA_1_2 = getJavaVersionMatches("1.2");
            IS_JAVA_1_3 = getJavaVersionMatches("1.3");
            IS_JAVA_1_4 = getJavaVersionMatches("1.4");
            IS_JAVA_1_5 = getJavaVersionMatches("1.5");
            IS_JAVA_1_6 = getJavaVersionMatches("1.6");
            IS_JAVA_1_7 = getJavaVersionMatches("1.7");
            IS_OS_AIX = getOSMatches("AIX");
            IS_OS_HP_UX = getOSMatches("HP-UX");
            IS_OS_IRIX = getOSMatches("Irix");
            if ((!getOSMatches("Linux")) && (!getOSMatches("LINUX"))) {
                break label683;
            }
        }
        label683:
        for (boolean bool1 = true; ; bool1 = false) {
            IS_OS_LINUX = bool1;
            IS_OS_MAC = getOSMatches("Mac");
            IS_OS_MAC_OSX = getOSMatches("Mac OS X");
            IS_OS_OS2 = getOSMatches("OS/2");
            IS_OS_SOLARIS = getOSMatches("Solaris");
            IS_OS_SUN_OS = getOSMatches("SunOS");
            if ((!IS_OS_AIX) && (!IS_OS_HP_UX) && (!IS_OS_IRIX) && (!IS_OS_LINUX) && (!IS_OS_MAC_OSX) && (!IS_OS_SOLARIS)) {
                bool1 = bool2;
                if (!IS_OS_SUN_OS) {
                }
            } else {
                bool1 = true;
            }
            IS_OS_UNIX = bool1;
            IS_OS_WINDOWS = getOSMatches("Windows");
            IS_OS_WINDOWS_2000 = getOSMatches("Windows", "5.0");
            IS_OS_WINDOWS_95 = getOSMatches("Windows 9", "4.0");
            IS_OS_WINDOWS_98 = getOSMatches("Windows 9", "4.1");
            IS_OS_WINDOWS_ME = getOSMatches("Windows", "4.9");
            IS_OS_WINDOWS_NT = getOSMatches("Windows NT");
            IS_OS_WINDOWS_XP = getOSMatches("Windows", "5.1");
            IS_OS_WINDOWS_VISTA = getOSMatches("Windows", "6.0");
            IS_OS_WINDOWS_7 = getOSMatches("Windows", "6.1");
            return;
            str = getSystemProperty("user.country");
            break;
        }
    }

    public static File getJavaHome() {
        return new File(System.getProperty("java.home"));
    }

    public static File getJavaIoTmpDir() {
        return new File(System.getProperty("java.io.tmpdir"));
    }

    public static float getJavaVersion() {
        return JAVA_VERSION_FLOAT;
    }

    private static float getJavaVersionAsFloat() {
        if (JAVA_VERSION_TRIMMED == null) {
            return 0.0F;
        }
        String str2 = JAVA_VERSION_TRIMMED.substring(0, 3);
        String str1 = str2;
        if (JAVA_VERSION_TRIMMED.length() >= 5) {
            str1 = str2 + JAVA_VERSION_TRIMMED.substring(4, 5);
        }
        try {
            float f = Float.parseFloat(str1);
            return f;
        } catch (Exception localException) {
        }
        return 0.0F;
    }

    private static int getJavaVersionAsInt() {
        if (JAVA_VERSION_TRIMMED == null) {
            return 0;
        }
        String str = JAVA_VERSION_TRIMMED.substring(0, 1);
        str = str + JAVA_VERSION_TRIMMED.substring(2, 3);
        if (JAVA_VERSION_TRIMMED.length() >= 5) {
        }
        for (str = str + JAVA_VERSION_TRIMMED.substring(4, 5); ; str = str + "0") {
            try {
                int i = Integer.parseInt(str);
                return i;
            } catch (Exception localException) {
            }
        }
        return 0;
    }

    private static boolean getJavaVersionMatches(String paramString) {
        if (JAVA_VERSION_TRIMMED == null) {
            return false;
        }
        return JAVA_VERSION_TRIMMED.startsWith(paramString);
    }

    private static String getJavaVersionTrimmed() {
        if (JAVA_VERSION != null) {
            int i = 0;
            while (i < JAVA_VERSION.length()) {
                int j = JAVA_VERSION.charAt(i);
                if ((j >= 48) && (j <= 57)) {
                    return JAVA_VERSION.substring(i);
                }
                i += 1;
            }
        }
        return null;
    }

    private static boolean getOSMatches(String paramString) {
        if (OS_NAME == null) {
            return false;
        }
        return OS_NAME.startsWith(paramString);
    }

    private static boolean getOSMatches(String paramString1, String paramString2) {
        if ((OS_NAME == null) || (OS_VERSION == null)) {
        }
        while ((!OS_NAME.startsWith(paramString1)) || (!OS_VERSION.startsWith(paramString2))) {
            return false;
        }
        return true;
    }

    private static String getSystemProperty(String paramString) {
        try {
            String str = System.getProperty(paramString);
            return str;
        } catch (SecurityException localSecurityException) {
            System.err.println("Caught a SecurityException reading the system property '" + paramString + "'; the SystemUtils property value will default to null.");
        }
        return null;
    }

    public static File getUserDir() {
        return new File(System.getProperty("user.dir"));
    }

    public static File getUserHome() {
        return new File(System.getProperty("user.home"));
    }

    public static boolean isJavaAwtHeadless() {
        if (JAVA_AWT_HEADLESS != null) {
            return JAVA_AWT_HEADLESS.equals(Boolean.TRUE.toString());
        }
        return false;
    }

    public static boolean isJavaVersionAtLeast(float paramFloat) {
        return JAVA_VERSION_FLOAT >= paramFloat;
    }

    public static boolean isJavaVersionAtLeast(int paramInt) {
        return JAVA_VERSION_INT >= paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/SystemUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */