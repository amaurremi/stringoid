/*     */
package android.view;
/*     */ 
/*     */

import android.os.Parcel;

/*     */
/*     */ public class KeyEvent extends InputEvent implements android.os.Parcelable {
    /*     */   public static final int KEYCODE_UNKNOWN = 0;
    /*     */   public static final int KEYCODE_SOFT_LEFT = 1;
    /*     */   public static final int KEYCODE_SOFT_RIGHT = 2;
    /*     */   public static final int KEYCODE_HOME = 3;
    /*     */   public static final int KEYCODE_BACK = 4;
    /*     */   public static final int KEYCODE_CALL = 5;
    /*     */   public static final int KEYCODE_ENDCALL = 6;
    /*     */   public static final int KEYCODE_0 = 7;

    /*     */
/*  15 */   public static class DispatcherState {
        public DispatcherState() {
            throw new RuntimeException("Stub!");
        }

        /*  16 */
        public void reset() {
            throw new RuntimeException("Stub!");
        }

        /*  17 */
        public void reset(Object target) {
            throw new RuntimeException("Stub!");
        }

        /*  18 */
        public void startTracking(KeyEvent event, Object target) {
            throw new RuntimeException("Stub!");
        }

        /*  19 */
        public boolean isTracking(KeyEvent event) {
            throw new RuntimeException("Stub!");
        }

        /*  20 */
        public void performedLongPress(KeyEvent event) {
            throw new RuntimeException("Stub!");
        }

        /*  21 */
        public void handleUpEvent(KeyEvent event) {
            throw new RuntimeException("Stub!");
        }
    }

    /*     */
/*  23 */
    public KeyEvent(int action, int code) {
        throw new RuntimeException("Stub!");
    }

    /*  24 */
    public KeyEvent(long downTime, long eventTime, int action, int code, int repeat) {
        throw new RuntimeException("Stub!");
    }

    /*  25 */
    public KeyEvent(long downTime, long eventTime, int action, int code, int repeat, int metaState) {
        throw new RuntimeException("Stub!");
    }

    /*  26 */
    public KeyEvent(long downTime, long eventTime, int action, int code, int repeat, int metaState, int deviceId, int scancode) {
        throw new RuntimeException("Stub!");
    }

    /*  27 */
    public KeyEvent(long downTime, long eventTime, int action, int code, int repeat, int metaState, int deviceId, int scancode, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*  28 */
    public KeyEvent(long downTime, long eventTime, int action, int code, int repeat, int metaState, int deviceId, int scancode, int flags, int source) {
        throw new RuntimeException("Stub!");
    }

    /*  29 */
    public KeyEvent(long time, String characters, int deviceId, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*  30 */
    public KeyEvent(KeyEvent origEvent) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/*  32 */ public KeyEvent(KeyEvent origEvent, long eventTime, int newRepeat) {
        throw new RuntimeException("Stub!");
    }

    /*  33 */
    public static int getMaxKeyCode() {
        throw new RuntimeException("Stub!");
    }

    /*  34 */
    public static int getDeadChar(int accent, int c) {
        throw new RuntimeException("Stub!");
    }

    /*  35 */
    public static KeyEvent changeTimeRepeat(KeyEvent event, long eventTime, int newRepeat) {
        throw new RuntimeException("Stub!");
    }

    /*  36 */
    public static KeyEvent changeTimeRepeat(KeyEvent event, long eventTime, int newRepeat, int newFlags) {
        throw new RuntimeException("Stub!");
    }

    /*  37 */
    public static KeyEvent changeAction(KeyEvent event, int action) {
        throw new RuntimeException("Stub!");
    }

    /*  38 */
    public static KeyEvent changeFlags(KeyEvent event, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*  39 */
    public final boolean isSystem() {
        throw new RuntimeException("Stub!");
    }

    /*  40 */
    public static final boolean isGamepadButton(int keyCode) {
        throw new RuntimeException("Stub!");
    }

    /*  41 */
    public final int getDeviceId() {
        throw new RuntimeException("Stub!");
    }

    /*  42 */
    public final int getSource() {
        throw new RuntimeException("Stub!");
    }

    /*  43 */
    public final void setSource(int source) {
        throw new RuntimeException("Stub!");
    }

    /*  44 */
    public final int getMetaState() {
        throw new RuntimeException("Stub!");
    }

    /*  45 */
    public final int getModifiers() {
        throw new RuntimeException("Stub!");
    }

    /*  46 */
    public final int getFlags() {
        throw new RuntimeException("Stub!");
    }

    /*  47 */
    public static int getModifierMetaStateMask() {
        throw new RuntimeException("Stub!");
    }

    /*  48 */
    public static boolean isModifierKey(int keyCode) {
        throw new RuntimeException("Stub!");
    }

    /*  49 */
    public static int normalizeMetaState(int metaState) {
        throw new RuntimeException("Stub!");
    }

    /*  50 */
    public static boolean metaStateHasNoModifiers(int metaState) {
        throw new RuntimeException("Stub!");
    }

    /*  51 */
    public static boolean metaStateHasModifiers(int metaState, int modifiers) {
        throw new RuntimeException("Stub!");
    }

    /*  52 */
    public final boolean hasNoModifiers() {
        throw new RuntimeException("Stub!");
    }

    /*  53 */
    public final boolean hasModifiers(int modifiers) {
        throw new RuntimeException("Stub!");
    }

    /*  54 */
    public final boolean isAltPressed() {
        throw new RuntimeException("Stub!");
    }

    /*  55 */
    public final boolean isShiftPressed() {
        throw new RuntimeException("Stub!");
    }

    /*  56 */
    public final boolean isSymPressed() {
        throw new RuntimeException("Stub!");
    }

    /*  57 */
    public final boolean isCtrlPressed() {
        throw new RuntimeException("Stub!");
    }

    /*  58 */
    public final boolean isMetaPressed() {
        throw new RuntimeException("Stub!");
    }

    /*  59 */
    public final boolean isFunctionPressed() {
        throw new RuntimeException("Stub!");
    }

    /*  60 */
    public final boolean isCapsLockOn() {
        throw new RuntimeException("Stub!");
    }

    /*  61 */
    public final boolean isNumLockOn() {
        throw new RuntimeException("Stub!");
    }

    /*  62 */
    public final boolean isScrollLockOn() {
        throw new RuntimeException("Stub!");
    }

    /*  63 */
    public final int getAction() {
        throw new RuntimeException("Stub!");
    }

    /*  64 */
    public final boolean isCanceled() {
        throw new RuntimeException("Stub!");
    }

    /*  65 */
    public final void startTracking() {
        throw new RuntimeException("Stub!");
    }

    /*  66 */
    public final boolean isTracking() {
        throw new RuntimeException("Stub!");
    }

    /*  67 */
    public final boolean isLongPress() {
        throw new RuntimeException("Stub!");
    }

    /*  68 */
    public final int getKeyCode() {
        throw new RuntimeException("Stub!");
    }

    /*  69 */
    public final String getCharacters() {
        throw new RuntimeException("Stub!");
    }

    /*  70 */
    public final int getScanCode() {
        throw new RuntimeException("Stub!");
    }

    /*  71 */
    public final int getRepeatCount() {
        throw new RuntimeException("Stub!");
    }

    /*  72 */
    public final long getDownTime() {
        throw new RuntimeException("Stub!");
    }

    /*  73 */
    public final long getEventTime() {
        throw new RuntimeException("Stub!");
    }

    /*  74 */
    public final KeyCharacterMap getKeyCharacterMap() {
        throw new RuntimeException("Stub!");
    }

    /*  75 */
    public char getDisplayLabel() {
        throw new RuntimeException("Stub!");
    }

    /*  76 */
    public int getUnicodeChar() {
        throw new RuntimeException("Stub!");
    }

    /*  77 */
    public int getUnicodeChar(int metaState) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/*  79 */ public boolean getKeyData(KeyCharacterMap.KeyData results) {
        throw new RuntimeException("Stub!");
    }

    /*  80 */
    public char getMatch(char[] chars) {
        throw new RuntimeException("Stub!");
    }

    /*  81 */
    public char getMatch(char[] chars, int metaState) {
        throw new RuntimeException("Stub!");
    }

    /*  82 */
    public char getNumber() {
        throw new RuntimeException("Stub!");
    }

    /*  83 */
    public boolean isPrintingKey() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/*  85 */ public final boolean dispatch(Callback receiver) {
        throw new RuntimeException("Stub!");
    }

    /*  86 */
    public final boolean dispatch(Callback receiver, DispatcherState state, Object target) {
        throw new RuntimeException("Stub!");
    }

    /*  87 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /*  88 */
    public static String keyCodeToString(int keyCode) {
        throw new RuntimeException("Stub!");
    }

    /*  89 */
    public static int keyCodeFromString(String symbolicName) {
        throw new RuntimeException("Stub!");
    }

    /*  90 */
    public void writeToParcel(Parcel out, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*     */
/*     */ 
/*     */   public static final int KEYCODE_1 = 8;
    /*     */
/*     */   public static final int KEYCODE_2 = 9;
    /*     */
/*     */   public static final int KEYCODE_3 = 10;
    /*     */
/*     */   public static final int KEYCODE_4 = 11;
    /*     */
/*     */   public static final int KEYCODE_5 = 12;
    /*     */
/*     */   public static final int KEYCODE_6 = 13;
    /*     */
/*     */   public static final int KEYCODE_7 = 14;
    /*     */
/*     */   public static final int KEYCODE_8 = 15;
    /*     */   public static final int KEYCODE_9 = 16;
    /*     */   public static final int KEYCODE_STAR = 17;
    /*     */   public static final int KEYCODE_POUND = 18;
    /*     */   public static final int KEYCODE_DPAD_UP = 19;
    /*     */   public static final int KEYCODE_DPAD_DOWN = 20;
    /*     */   public static final int KEYCODE_DPAD_LEFT = 21;
    /*     */   public static final int KEYCODE_DPAD_RIGHT = 22;
    /*     */   public static final int KEYCODE_DPAD_CENTER = 23;
    /*     */   public static final int KEYCODE_VOLUME_UP = 24;
    /*     */   public static final int KEYCODE_VOLUME_DOWN = 25;
    /*     */   public static final int KEYCODE_POWER = 26;
    /*     */   public static final int KEYCODE_CAMERA = 27;
    /*     */   public static final int KEYCODE_CLEAR = 28;
    /*     */   public static final int KEYCODE_A = 29;
    /*     */   public static final int KEYCODE_B = 30;
    /*     */   public static final int KEYCODE_C = 31;
    /*     */   public static final int KEYCODE_D = 32;
    /*     */   public static final int KEYCODE_E = 33;
    /*     */   public static final int KEYCODE_F = 34;
    /*     */   public static final int KEYCODE_G = 35;
    /*     */   public static final int KEYCODE_H = 36;
    /*     */   public static final int KEYCODE_I = 37;
    /*     */   public static final int KEYCODE_J = 38;
    /*     */   public static final int KEYCODE_K = 39;
    /*     */   public static final int KEYCODE_L = 40;
    /*     */   public static final int KEYCODE_M = 41;
    /*     */   public static final int KEYCODE_N = 42;
    /*     */   public static final int KEYCODE_O = 43;
    /*     */   public static final int KEYCODE_P = 44;
    /*     */   public static final int KEYCODE_Q = 45;
    /*     */   public static final int KEYCODE_R = 46;
    /*     */   public static final int KEYCODE_S = 47;
    /*     */   public static final int KEYCODE_T = 48;
    /*     */   public static final int KEYCODE_U = 49;
    /*     */   public static final int KEYCODE_V = 50;
    /*     */   public static final int KEYCODE_W = 51;
    /*     */   public static final int KEYCODE_X = 52;
    /*     */   public static final int KEYCODE_Y = 53;
    /*     */   public static final int KEYCODE_Z = 54;
    /*     */   public static final int KEYCODE_COMMA = 55;
    /*     */   public static final int KEYCODE_PERIOD = 56;
    /*     */   public static final int KEYCODE_ALT_LEFT = 57;
    /*     */   public static final int KEYCODE_ALT_RIGHT = 58;
    /*     */   public static final int KEYCODE_SHIFT_LEFT = 59;
    /*     */   public static final int KEYCODE_SHIFT_RIGHT = 60;
    /*     */   public static final int KEYCODE_TAB = 61;
    /*     */   public static final int KEYCODE_SPACE = 62;
    /*     */   public static final int KEYCODE_SYM = 63;
    /*     */   public static final int KEYCODE_EXPLORER = 64;
    /*     */   public static final int KEYCODE_ENVELOPE = 65;
    /*     */   public static final int KEYCODE_ENTER = 66;
    /*     */   public static final int KEYCODE_DEL = 67;
    /*     */   public static final int KEYCODE_GRAVE = 68;
    /*     */   public static final int KEYCODE_MINUS = 69;
    /*     */   public static final int KEYCODE_EQUALS = 70;
    /*     */   public static final int KEYCODE_LEFT_BRACKET = 71;
    /*     */   public static final int KEYCODE_RIGHT_BRACKET = 72;
    /*     */   public static final int KEYCODE_BACKSLASH = 73;
    /*     */   public static final int KEYCODE_SEMICOLON = 74;
    /*     */   public static final int KEYCODE_APOSTROPHE = 75;
    /*     */   public static final int KEYCODE_SLASH = 76;
    /*     */   public static final int KEYCODE_AT = 77;
    /*     */   public static final int KEYCODE_NUM = 78;
    /*     */   public static final int KEYCODE_HEADSETHOOK = 79;
    /*     */   public static final int KEYCODE_FOCUS = 80;
    /*     */   public static final int KEYCODE_PLUS = 81;
    /*     */   public static final int KEYCODE_MENU = 82;
    /*     */   public static final int KEYCODE_NOTIFICATION = 83;
    /*     */   public static final int KEYCODE_SEARCH = 84;
    /*     */   public static final int KEYCODE_MEDIA_PLAY_PAUSE = 85;
    /*     */   public static final int KEYCODE_MEDIA_STOP = 86;
    /*     */   public static final int KEYCODE_MEDIA_NEXT = 87;
    /*     */   public static final int KEYCODE_MEDIA_PREVIOUS = 88;
    /*     */   public static final int KEYCODE_MEDIA_REWIND = 89;
    /*     */   public static final int KEYCODE_MEDIA_FAST_FORWARD = 90;
    /*     */   public static final int KEYCODE_MUTE = 91;
    /*     */   public static final int KEYCODE_PAGE_UP = 92;
    /*     */   public static final int KEYCODE_PAGE_DOWN = 93;
    /*     */   public static final int KEYCODE_PICTSYMBOLS = 94;
    /*     */   public static final int KEYCODE_SWITCH_CHARSET = 95;
    /*     */   public static final int KEYCODE_BUTTON_A = 96;
    /*     */   public static final int KEYCODE_BUTTON_B = 97;
    /*     */   public static final int KEYCODE_BUTTON_C = 98;
    /*     */   public static final int KEYCODE_BUTTON_X = 99;
    /*     */   public static final int KEYCODE_BUTTON_Y = 100;
    /*     */   public static final int KEYCODE_BUTTON_Z = 101;
    /*     */   public static final int KEYCODE_BUTTON_L1 = 102;
    /*     */   public static final int KEYCODE_BUTTON_R1 = 103;
    /*     */   public static final int KEYCODE_BUTTON_L2 = 104;
    /*     */   public static final int KEYCODE_BUTTON_R2 = 105;
    /*     */   public static final int KEYCODE_BUTTON_THUMBL = 106;
    /*     */   public static final int KEYCODE_BUTTON_THUMBR = 107;
    /*     */   public static final int KEYCODE_BUTTON_START = 108;
    /*     */   public static final int KEYCODE_BUTTON_SELECT = 109;
    /*     */   public static final int KEYCODE_BUTTON_MODE = 110;
    /*     */   public static final int KEYCODE_ESCAPE = 111;
    /*     */   public static final int KEYCODE_FORWARD_DEL = 112;
    /*     */   public static final int KEYCODE_CTRL_LEFT = 113;
    /*     */   public static final int KEYCODE_CTRL_RIGHT = 114;
    /*     */   public static final int KEYCODE_CAPS_LOCK = 115;
    /*     */   public static final int KEYCODE_SCROLL_LOCK = 116;
    /*     */   public static final int KEYCODE_META_LEFT = 117;
    /*     */   public static final int KEYCODE_META_RIGHT = 118;
    /*     */   public static final int KEYCODE_FUNCTION = 119;
    /*     */   public static final int KEYCODE_SYSRQ = 120;
    /*     */   public static final int KEYCODE_BREAK = 121;
    /*     */   public static final int KEYCODE_MOVE_HOME = 122;
    /*     */   public static final int KEYCODE_MOVE_END = 123;
    /*     */   public static final int KEYCODE_INSERT = 124;
    /*     */   public static final int KEYCODE_FORWARD = 125;
    /*     */   public static final int KEYCODE_MEDIA_PLAY = 126;
    /*     */   public static final int KEYCODE_MEDIA_PAUSE = 127;
    /*     */   public static final int KEYCODE_MEDIA_CLOSE = 128;
    /*     */   public static final int KEYCODE_MEDIA_EJECT = 129;
    /*     */   public static final int KEYCODE_MEDIA_RECORD = 130;
    /*     */   public static final int KEYCODE_F1 = 131;
    /*     */   public static final int KEYCODE_F2 = 132;
    /*     */   public static final int KEYCODE_F3 = 133;
    /*     */   public static final int KEYCODE_F4 = 134;
    /*     */   public static final int KEYCODE_F5 = 135;
    /*     */   public static final int KEYCODE_F6 = 136;
    /*     */   public static final int KEYCODE_F7 = 137;
    /*     */   public static final int KEYCODE_F8 = 138;
    /*     */   public static final int KEYCODE_F9 = 139;
    /*     */   public static final int KEYCODE_F10 = 140;
    /*     */   public static final int KEYCODE_F11 = 141;
    /*     */   public static final int KEYCODE_F12 = 142;
    /*     */   public static final int KEYCODE_NUM_LOCK = 143;
    /*     */   public static final int KEYCODE_NUMPAD_0 = 144;
    /*     */   public static final int KEYCODE_NUMPAD_1 = 145;
    /*     */   public static final int KEYCODE_NUMPAD_2 = 146;
    /*     */   public static final int KEYCODE_NUMPAD_3 = 147;
    /*     */   public static final int KEYCODE_NUMPAD_4 = 148;
    /*     */   public static final int KEYCODE_NUMPAD_5 = 149;
    /*     */   public static final int KEYCODE_NUMPAD_6 = 150;
    /*     */   public static final int KEYCODE_NUMPAD_7 = 151;
    /*     */   public static final int KEYCODE_NUMPAD_8 = 152;
    /*     */   public static final int KEYCODE_NUMPAD_9 = 153;
    /*     */   public static final int KEYCODE_NUMPAD_DIVIDE = 154;
    /*     */   public static final int KEYCODE_NUMPAD_MULTIPLY = 155;
    /*     */   public static final int KEYCODE_NUMPAD_SUBTRACT = 156;
    /*     */   public static final int KEYCODE_NUMPAD_ADD = 157;
    /*     */   public static final int KEYCODE_NUMPAD_DOT = 158;
    /*     */   public static final int KEYCODE_NUMPAD_COMMA = 159;
    /*     */   public static final int KEYCODE_NUMPAD_ENTER = 160;
    /*     */   public static final int KEYCODE_NUMPAD_EQUALS = 161;
    /*     */   public static final int KEYCODE_NUMPAD_LEFT_PAREN = 162;
    /*     */   public static final int KEYCODE_NUMPAD_RIGHT_PAREN = 163;
    /*     */   public static final int KEYCODE_VOLUME_MUTE = 164;
    /*     */   public static final int KEYCODE_INFO = 165;
    /*     */   public static final int KEYCODE_CHANNEL_UP = 166;
    /*     */   public static final int KEYCODE_CHANNEL_DOWN = 167;
    /*     */   public static final int KEYCODE_ZOOM_IN = 168;
    /*     */   public static final int KEYCODE_ZOOM_OUT = 169;
    /*     */   public static final int KEYCODE_TV = 170;
    /*     */   public static final int KEYCODE_WINDOW = 171;
    /*     */   public static final int KEYCODE_GUIDE = 172;
    /*     */   public static final int KEYCODE_DVR = 173;
    /*     */   public static final int KEYCODE_BOOKMARK = 174;
    /*     */   public static final int KEYCODE_CAPTIONS = 175;
    /*     */   public static final int KEYCODE_SETTINGS = 176;
    /*     */   public static final int KEYCODE_TV_POWER = 177;
    /*     */   public static final int KEYCODE_TV_INPUT = 178;
    /*     */   public static final int KEYCODE_STB_POWER = 179;
    /*     */   public static final int KEYCODE_STB_INPUT = 180;
    /*     */   public static final int KEYCODE_AVR_POWER = 181;
    /*     */   public static final int KEYCODE_AVR_INPUT = 182;
    /*     */   public static final int KEYCODE_PROG_RED = 183;
    /*     */   public static final int KEYCODE_PROG_GREEN = 184;
    /*     */   public static final int KEYCODE_PROG_YELLOW = 185;
    /*     */   public static final int KEYCODE_PROG_BLUE = 186;
    /*     */   public static final int KEYCODE_APP_SWITCH = 187;
    /*     */   public static final int KEYCODE_BUTTON_1 = 188;
    /*     */   public static final int KEYCODE_BUTTON_2 = 189;
    /*     */   public static final int KEYCODE_BUTTON_3 = 190;
    /*     */   public static final int KEYCODE_BUTTON_4 = 191;
    /*     */   public static final int KEYCODE_BUTTON_5 = 192;
    /*     */   public static final int KEYCODE_BUTTON_6 = 193;
    /*     */   public static final int KEYCODE_BUTTON_7 = 194;
    /*     */   public static final int KEYCODE_BUTTON_8 = 195;
    /*     */   public static final int KEYCODE_BUTTON_9 = 196;
    /*     */   public static final int KEYCODE_BUTTON_10 = 197;
    /*     */   public static final int KEYCODE_BUTTON_11 = 198;
    /*     */   public static final int KEYCODE_BUTTON_12 = 199;
    /*     */   public static final int KEYCODE_BUTTON_13 = 200;
    /*     */   public static final int KEYCODE_BUTTON_14 = 201;
    /*     */   public static final int KEYCODE_BUTTON_15 = 202;
    /*     */   public static final int KEYCODE_BUTTON_16 = 203;
    /*     */   public static final int KEYCODE_LANGUAGE_SWITCH = 204;
    /*     */   public static final int KEYCODE_MANNER_MODE = 205;
    /*     */   public static final int KEYCODE_3D_MODE = 206;
    /*     */   public static final int KEYCODE_CONTACTS = 207;
    /*     */   public static final int KEYCODE_CALENDAR = 208;
    /*     */   public static final int KEYCODE_MUSIC = 209;
    /*     */   public static final int KEYCODE_CALCULATOR = 210;
    /*     */   public static final int KEYCODE_ZENKAKU_HANKAKU = 211;
    /*     */   public static final int KEYCODE_EISU = 212;
    /*     */   public static final int KEYCODE_MUHENKAN = 213;
    /*     */   public static final int KEYCODE_HENKAN = 214;
    /*     */   public static final int KEYCODE_KATAKANA_HIRAGANA = 215;
    /*     */   public static final int KEYCODE_YEN = 216;
    /*     */   public static final int KEYCODE_RO = 217;
    /*     */   public static final int KEYCODE_KANA = 218;
    /*     */   public static final int KEYCODE_ASSIST = 219;
    /*     */
    @Deprecated
/*     */ public static final int MAX_KEYCODE = 84;
    /*     */   public static final int ACTION_DOWN = 0;
    /*     */   public static final int ACTION_UP = 1;
    /*     */   public static final int ACTION_MULTIPLE = 2;
    /*     */   public static final int META_ALT_ON = 2;
    /*     */   public static final int META_ALT_LEFT_ON = 16;
    /*     */   public static final int META_ALT_RIGHT_ON = 32;
    /*     */   public static final int META_SHIFT_ON = 1;
    /*     */   public static final int META_SHIFT_LEFT_ON = 64;
    /*     */   public static final int META_SHIFT_RIGHT_ON = 128;
    /*     */   public static final int META_SYM_ON = 4;
    /*     */   public static final int META_FUNCTION_ON = 8;
    /*     */   public static final int META_CTRL_ON = 4096;
    /*     */   public static final int META_CTRL_LEFT_ON = 8192;
    /*     */   public static final int META_CTRL_RIGHT_ON = 16384;
    /*     */   public static final int META_META_ON = 65536;
    /*     */   public static final int META_META_LEFT_ON = 131072;
    /*     */   public static final int META_META_RIGHT_ON = 262144;
    /*     */   public static final int META_CAPS_LOCK_ON = 1048576;
    /*     */   public static final int META_NUM_LOCK_ON = 2097152;
    /*     */   public static final int META_SCROLL_LOCK_ON = 4194304;
    /*     */   public static final int META_SHIFT_MASK = 193;
    /*     */   public static final int META_ALT_MASK = 50;
    /*     */   public static final int META_CTRL_MASK = 28672;
    /*     */   public static final int META_META_MASK = 458752;
    /*     */   public static final int FLAG_WOKE_HERE = 1;
    /*     */   public static final int FLAG_SOFT_KEYBOARD = 2;
    /*     */   public static final int FLAG_KEEP_TOUCH_MODE = 4;
    /*     */   public static final int FLAG_FROM_SYSTEM = 8;
    /*     */   public static final int FLAG_EDITOR_ACTION = 16;
    /*     */   public static final int FLAG_CANCELED = 32;
    /*     */   public static final int FLAG_VIRTUAL_HARD_KEY = 64;
    /*     */   public static final int FLAG_LONG_PRESS = 128;
    /*     */   public static final int FLAG_CANCELED_LONG_PRESS = 256;
    /*     */   public static final int FLAG_TRACKING = 512;
    /*     */   public static final int FLAG_FALLBACK = 1024;
    /* 349 */   public static final android.os.Parcelable.Creator<KeyEvent> CREATOR = null;

    /*     */
/*     */   public static abstract interface Callback
/*     */ {
        /*     */
        public abstract boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent);

        /*     */
/*     */
        public abstract boolean onKeyLongPress(int paramInt, KeyEvent paramKeyEvent);

        /*     */
/*     */
        public abstract boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent);

        /*     */
/*     */
        public abstract boolean onKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent);
/*     */
    }
/*     */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/KeyEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */