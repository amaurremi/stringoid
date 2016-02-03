/*    */
package android.telephony;
/*    */

import android.text.Editable;

/*    */
/*  4 */ public class PhoneNumberUtils {
    public PhoneNumberUtils() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public static boolean isISODigit(char c) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public static final boolean is12Key(char c) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public static final boolean isDialable(char c) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public static final boolean isReallyDialable(char c) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public static final boolean isNonSeparator(char c) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public static final boolean isStartsPostDial(char c) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public static String getNumberFromIntent(android.content.Intent intent, android.content.Context context) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public static String extractNetworkPortion(String phoneNumber) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public static String stripSeparators(String phoneNumber) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public static String extractPostDialPortion(String phoneNumber) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public static boolean compare(String a, String b) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public static boolean compare(android.content.Context context, String a, String b) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public static String toCallerIDMinMatch(String phoneNumber) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public static String getStrippedReversed(String phoneNumber) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public static String stringFromStringAndTOA(String s, int TOA) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public static int toaFromString(String s) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public static String calledPartyBCDToString(byte[] bytes, int offset, int length) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public static String calledPartyBCDFragmentToString(byte[] bytes, int offset, int length) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public static boolean isWellFormedSmsAddress(String address) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public static boolean isGlobalPhoneNumber(String phoneNumber) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public static byte[] networkPortionToCalledPartyBCD(String s) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public static byte[] networkPortionToCalledPartyBCDWithLength(String s) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public static byte[] numberToCalledPartyBCD(String number) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public static String formatNumber(String source) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public static int getFormatTypeForLocale(java.util.Locale locale) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public static void formatNumber(Editable text, int defaultFormattingType) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public static void formatNanpNumber(Editable text) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public static void formatJapaneseNumber(Editable text) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public static boolean isEmergencyNumber(String number) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public static String convertKeypadLettersToDigits(String input) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final char PAUSE = ',';
    /*    */   public static final char WAIT = ';';
    /*    */   public static final char WILD = 'N';
    /*    */   public static final int TOA_International = 145;
    /*    */   public static final int TOA_Unknown = 129;
    /*    */   public static final int FORMAT_UNKNOWN = 0;
    /*    */   public static final int FORMAT_NANP = 1;
    /*    */   public static final int FORMAT_JAPAN = 2;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/telephony/PhoneNumberUtils.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */