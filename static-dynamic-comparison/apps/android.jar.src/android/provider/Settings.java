/*     */
package android.provider;
/*     */ 
/*     */

import android.content.ContentResolver;

/*     */
/*     */ public final class Settings {
    public static final String ACTION_SETTINGS = "android.settings.SETTINGS";

    /*     */
/*   7 */   public static class SettingNotFoundException extends android.util.AndroidException {
        public SettingNotFoundException(String msg) {
            throw new RuntimeException("Stub!");
        }
    }

    /*     */
/*     */   public static final String ACTION_APN_SETTINGS = "android.settings.APN_SETTINGS";

    /*     */
/*     */   public static class NameValueTable implements BaseColumns {
        public static final String NAME = "name";

        /*  12 */
        public NameValueTable() {
            throw new RuntimeException("Stub!");
        }

        /*  13 */
        protected static boolean putString(ContentResolver resolver, android.net.Uri uri, String name, String value) {
            throw new RuntimeException("Stub!");
        }

        /*  14 */
        public static android.net.Uri getUriFor(android.net.Uri uri, String name) {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */     public static final String VALUE = "value";
    }

    /*     */
/*     */   public static final String ACTION_LOCATION_SOURCE_SETTINGS = "android.settings.LOCATION_SOURCE_SETTINGS";
    /*     */   public static final String ACTION_WIRELESS_SETTINGS = "android.settings.WIRELESS_SETTINGS";
    /*     */   public static final String ACTION_AIRPLANE_MODE_SETTINGS = "android.settings.AIRPLANE_MODE_SETTINGS";

    /*  21 */   public static final class System extends Settings.NameValueTable {
        public System() {
            throw new RuntimeException("Stub!");
        }

        /*  22 */
        public static synchronized String getString(ContentResolver resolver, String name) {
            throw new RuntimeException("Stub!");
        }

        /*  23 */
        public static boolean putString(ContentResolver resolver, String name, String value) {
            throw new RuntimeException("Stub!");
        }

        /*  24 */
        public static android.net.Uri getUriFor(String name) {
            throw new RuntimeException("Stub!");
        }

        /*  25 */
        public static int getInt(ContentResolver cr, String name, int def) {
            throw new RuntimeException("Stub!");
        }

        /*  26 */
        public static int getInt(ContentResolver cr, String name) throws Settings.SettingNotFoundException {
            throw new RuntimeException("Stub!");
        }

        /*  27 */
        public static boolean putInt(ContentResolver cr, String name, int value) {
            throw new RuntimeException("Stub!");
        }

        /*  28 */
        public static long getLong(ContentResolver cr, String name, long def) {
            throw new RuntimeException("Stub!");
        }

        /*  29 */
        public static long getLong(ContentResolver cr, String name) throws Settings.SettingNotFoundException {
            throw new RuntimeException("Stub!");
        }

        /*  30 */
        public static boolean putLong(ContentResolver cr, String name, long value) {
            throw new RuntimeException("Stub!");
        }

        /*  31 */
        public static float getFloat(ContentResolver cr, String name, float def) {
            throw new RuntimeException("Stub!");
        }

        /*  32 */
        public static float getFloat(ContentResolver cr, String name) throws Settings.SettingNotFoundException {
            throw new RuntimeException("Stub!");
        }

        /*  33 */
        public static boolean putFloat(ContentResolver cr, String name, float value) {
            throw new RuntimeException("Stub!");
        }

        /*  34 */
        public static void getConfiguration(ContentResolver cr, android.content.res.Configuration outConfig) {
            throw new RuntimeException("Stub!");
        }

        /*  35 */
        public static boolean putConfiguration(ContentResolver cr, android.content.res.Configuration config) {
            throw new RuntimeException("Stub!");
        }

        /*  36 */
        public static boolean getShowGTalkServiceStatus(ContentResolver cr) {
            throw new RuntimeException("Stub!");
        }

        /*  37 */
        public static void setShowGTalkServiceStatus(ContentResolver cr, boolean flag) {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  89 */     public static final String[] VOLUME_SETTINGS = null;
        /*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 184 */     public static final android.net.Uri CONTENT_URI = null;
        public static final android.net.Uri DEFAULT_RINGTONE_URI = null;
        public static final android.net.Uri DEFAULT_NOTIFICATION_URI = null;
        public static final android.net.Uri DEFAULT_ALARM_ALERT_URI = null;
        public static final String SYS_PROP_SETTING_VERSION = "sys.settings_system_version";
        public static final String STAY_ON_WHILE_PLUGGED_IN = "stay_on_while_plugged_in";
        public static final String END_BUTTON_BEHAVIOR = "end_button_behavior";
        public static final String AIRPLANE_MODE_ON = "airplane_mode_on";
        public static final String RADIO_BLUETOOTH = "bluetooth";
        public static final String RADIO_WIFI = "wifi";
        public static final String RADIO_CELL = "cell";
        public static final String RADIO_NFC = "nfc";
        public static final String AIRPLANE_MODE_RADIOS = "airplane_mode_radios";
        public static final String WIFI_SLEEP_POLICY = "wifi_sleep_policy";
        public static final int WIFI_SLEEP_POLICY_DEFAULT = 0;
        public static final int WIFI_SLEEP_POLICY_NEVER_WHILE_PLUGGED = 1;
        public static final int WIFI_SLEEP_POLICY_NEVER = 2;
        public static final String WIFI_USE_STATIC_IP = "wifi_use_static_ip";
        public static final String WIFI_STATIC_IP = "wifi_static_ip";
        public static final String WIFI_STATIC_GATEWAY = "wifi_static_gateway";
        public static final String WIFI_STATIC_NETMASK = "wifi_static_netmask";
        public static final String WIFI_STATIC_DNS1 = "wifi_static_dns1";
        public static final String WIFI_STATIC_DNS2 = "wifi_static_dns2";
        public static final String BLUETOOTH_DISCOVERABILITY = "bluetooth_discoverability";
        public static final String BLUETOOTH_DISCOVERABILITY_TIMEOUT = "bluetooth_discoverability_timeout";
        @Deprecated
/*     */ public static final String LOCK_PATTERN_ENABLED = "lock_pattern_autolock";
        @Deprecated
/*     */ public static final String LOCK_PATTERN_VISIBLE = "lock_pattern_visible_pattern";
        @Deprecated
/*     */ public static final String LOCK_PATTERN_TACTILE_FEEDBACK_ENABLED = "lock_pattern_tactile_feedback_enabled";
        public static final String NEXT_ALARM_FORMATTED = "next_alarm_formatted";
        public static final String FONT_SCALE = "font_scale";
        public static final String DEBUG_APP = "debug_app";
        public static final String WAIT_FOR_DEBUGGER = "wait_for_debugger";
        public static final String DIM_SCREEN = "dim_screen";
        public static final String SCREEN_OFF_TIMEOUT = "screen_off_timeout";
        public static final String SCREEN_BRIGHTNESS = "screen_brightness";
        public static final String SCREEN_BRIGHTNESS_MODE = "screen_brightness_mode";
        public static final int SCREEN_BRIGHTNESS_MODE_MANUAL = 0;
        public static final int SCREEN_BRIGHTNESS_MODE_AUTOMATIC = 1;
        public static final String SHOW_PROCESSES = "show_processes";
        public static final String ALWAYS_FINISH_ACTIVITIES = "always_finish_activities";
        public static final String MODE_RINGER = "mode_ringer";
        public static final String MODE_RINGER_STREAMS_AFFECTED = "mode_ringer_streams_affected";
        public static final String MUTE_STREAMS_AFFECTED = "mute_streams_affected";
        public static final String VIBRATE_ON = "vibrate_on";
        public static final String VOLUME_RING = "volume_ring";
        public static final String VOLUME_SYSTEM = "volume_system";
        public static final String VOLUME_VOICE = "volume_voice";
        public static final String VOLUME_MUSIC = "volume_music";
        public static final String VOLUME_ALARM = "volume_alarm";
        public static final String VOLUME_NOTIFICATION = "volume_notification";
        public static final String VOLUME_BLUETOOTH_SCO = "volume_bluetooth_sco";
        public static final String APPEND_FOR_LAST_AUDIBLE = "_last_audible";
        public static final String RINGTONE = "ringtone";
        public static final String NOTIFICATION_SOUND = "notification_sound";
        public static final String ALARM_ALERT = "alarm_alert";
        public static final String TEXT_AUTO_REPLACE = "auto_replace";
        public static final String TEXT_AUTO_CAPS = "auto_caps";
        public static final String TEXT_AUTO_PUNCTUATE = "auto_punctuate";
        public static final String TEXT_SHOW_PASSWORD = "show_password";
        public static final String SHOW_GTALK_SERVICE_STATUS = "SHOW_GTALK_SERVICE_STATUS";
        public static final String WALLPAPER_ACTIVITY = "wallpaper_activity";
        public static final String AUTO_TIME = "auto_time";
        public static final String AUTO_TIME_ZONE = "auto_time_zone";
        public static final String TIME_12_24 = "time_12_24";
        public static final String DATE_FORMAT = "date_format";
        public static final String SETUP_WIZARD_HAS_RUN = "setup_wizard_has_run";
        public static final String WINDOW_ANIMATION_SCALE = "window_animation_scale";
        public static final String TRANSITION_ANIMATION_SCALE = "transition_animation_scale";
        public static final String ANIMATOR_DURATION_SCALE = "animator_duration_scale";
        public static final String ACCELEROMETER_ROTATION = "accelerometer_rotation";
        public static final String USER_ROTATION = "user_rotation";
        public static final String DTMF_TONE_WHEN_DIALING = "dtmf_tone";
        public static final String SOUND_EFFECTS_ENABLED = "sound_effects_enabled";
        public static final String HAPTIC_FEEDBACK_ENABLED = "haptic_feedback_enabled";
        @Deprecated
/*     */ public static final String SHOW_WEB_SUGGESTIONS = "show_web_suggestions";
        @Deprecated
/*     */ public static final String ADB_ENABLED = "adb_enabled";
        @Deprecated
/*     */ public static final String ANDROID_ID = "android_id";
        @Deprecated
/*     */ public static final String BLUETOOTH_ON = "bluetooth_on";
        @Deprecated
/*     */ public static final String DATA_ROAMING = "data_roaming";
        @Deprecated
/*     */ public static final String DEVICE_PROVISIONED = "device_provisioned";
        @Deprecated
/*     */ public static final String HTTP_PROXY = "http_proxy";
        @Deprecated
/*     */ public static final String INSTALL_NON_MARKET_APPS = "install_non_market_apps";
        @Deprecated
/*     */ public static final String LOCATION_PROVIDERS_ALLOWED = "location_providers_allowed";
        @Deprecated
/*     */ public static final String LOGGING_ID = "logging_id";
        @Deprecated
/*     */ public static final String NETWORK_PREFERENCE = "network_preference";
        @Deprecated
/*     */ public static final String PARENTAL_CONTROL_ENABLED = "parental_control_enabled";
        @Deprecated
/*     */ public static final String PARENTAL_CONTROL_LAST_UPDATE = "parental_control_last_update";
        @Deprecated
/*     */ public static final String PARENTAL_CONTROL_REDIRECT_URL = "parental_control_redirect_url";
        @Deprecated
/*     */ public static final String SETTINGS_CLASSNAME = "settings_classname";
        @Deprecated
/*     */ public static final String USB_MASS_STORAGE_ENABLED = "usb_mass_storage_enabled";
        @Deprecated
/*     */ public static final String USE_GOOGLE_MAIL = "use_google_mail";
        @Deprecated
/*     */ public static final String WIFI_MAX_DHCP_RETRY_COUNT = "wifi_max_dhcp_retry_count";
        @Deprecated
/*     */ public static final String WIFI_MOBILE_DATA_TRANSITION_WAKELOCK_TIMEOUT_MS = "wifi_mobile_data_transition_wakelock_timeout_ms";
        @Deprecated
/*     */ public static final String WIFI_NETWORKS_AVAILABLE_NOTIFICATION_ON = "wifi_networks_available_notification_on";
        @Deprecated
/*     */ public static final String WIFI_NETWORKS_AVAILABLE_REPEAT_DELAY = "wifi_networks_available_repeat_delay";
        @Deprecated
/*     */ public static final String WIFI_NUM_OPEN_NETWORKS_KEPT = "wifi_num_open_networks_kept";
        @Deprecated
/*     */ public static final String WIFI_ON = "wifi_on";
        @Deprecated
/*     */ public static final String WIFI_WATCHDOG_ACCEPTABLE_PACKET_LOSS_PERCENTAGE = "wifi_watchdog_acceptable_packet_loss_percentage";
        @Deprecated
/*     */ public static final String WIFI_WATCHDOG_AP_COUNT = "wifi_watchdog_ap_count";
        @Deprecated
/*     */ public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_DELAY_MS = "wifi_watchdog_background_check_delay_ms";
        @Deprecated
/*     */ public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_ENABLED = "wifi_watchdog_background_check_enabled";
        @Deprecated
/*     */ public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_TIMEOUT_MS = "wifi_watchdog_background_check_timeout_ms";
        @Deprecated
/*     */ public static final String WIFI_WATCHDOG_INITIAL_IGNORED_PING_COUNT = "wifi_watchdog_initial_ignored_ping_count";
        @Deprecated
/*     */ public static final String WIFI_WATCHDOG_MAX_AP_CHECKS = "wifi_watchdog_max_ap_checks";
        @Deprecated
/*     */ public static final String WIFI_WATCHDOG_ON = "wifi_watchdog_on";
        @Deprecated
/*     */ public static final String WIFI_WATCHDOG_PING_COUNT = "wifi_watchdog_ping_count";
        @Deprecated
/*     */ public static final String WIFI_WATCHDOG_PING_DELAY_MS = "wifi_watchdog_ping_delay_ms";
        @Deprecated
/* 189 */ public static final String WIFI_WATCHDOG_PING_TIMEOUT_MS = "wifi_watchdog_ping_timeout_ms";
    }

    public static final class Secure extends Settings.NameValueTable {
        public Secure() {
            throw new RuntimeException("Stub!");
        }

        /* 190 */
        public static synchronized String getString(ContentResolver resolver, String name) {
            throw new RuntimeException("Stub!");
        }

        /* 191 */
        public static boolean putString(ContentResolver resolver, String name, String value) {
            throw new RuntimeException("Stub!");
        }

        /* 192 */
        public static android.net.Uri getUriFor(String name) {
            throw new RuntimeException("Stub!");
        }

        /* 193 */
        public static int getInt(ContentResolver cr, String name, int def) {
            throw new RuntimeException("Stub!");
        }

        /* 194 */
        public static int getInt(ContentResolver cr, String name) throws Settings.SettingNotFoundException {
            throw new RuntimeException("Stub!");
        }

        /* 195 */
        public static boolean putInt(ContentResolver cr, String name, int value) {
            throw new RuntimeException("Stub!");
        }

        /* 196 */
        public static long getLong(ContentResolver cr, String name, long def) {
            throw new RuntimeException("Stub!");
        }

        /* 197 */
        public static long getLong(ContentResolver cr, String name) throws Settings.SettingNotFoundException {
            throw new RuntimeException("Stub!");
        }

        /* 198 */
        public static boolean putLong(ContentResolver cr, String name, long value) {
            throw new RuntimeException("Stub!");
        }

        /* 199 */
        public static float getFloat(ContentResolver cr, String name, float def) {
            throw new RuntimeException("Stub!");
        }

        /* 200 */
        public static float getFloat(ContentResolver cr, String name) throws Settings.SettingNotFoundException {
            throw new RuntimeException("Stub!");
        }

        /* 201 */
        public static boolean putFloat(ContentResolver cr, String name, float value) {
            throw new RuntimeException("Stub!");
        }

        /* 202 */
        public static final boolean isLocationProviderEnabled(ContentResolver cr, String provider) {
            throw new RuntimeException("Stub!");
        }

        /* 203 */
        public static final void setLocationProviderEnabled(ContentResolver cr, String provider, boolean enabled) {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public static final String SYS_PROP_SETTING_VERSION = "sys.settings_secure_version";
        /*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 280 */     public static final android.net.Uri CONTENT_URI = null;
        public static final String DEVELOPMENT_SETTINGS_ENABLED = "development_settings_enabled";
        public static final String ADB_ENABLED = "adb_enabled";
        public static final String ALLOW_MOCK_LOCATION = "mock_location";
        public static final String ANDROID_ID = "android_id";
        public static final String BLUETOOTH_ON = "bluetooth_on";
        public static final String DATA_ROAMING = "data_roaming";
        public static final String DEFAULT_INPUT_METHOD = "default_input_method";
        public static final String SELECTED_INPUT_METHOD_SUBTYPE = "selected_input_method_subtype";
        public static final String INPUT_METHOD_SELECTOR_VISIBILITY = "input_method_selector_visibility";
        public static final String DEVICE_PROVISIONED = "device_provisioned";
        public static final String ENABLED_INPUT_METHODS = "enabled_input_methods";
        public static final String HTTP_PROXY = "http_proxy";
        public static final String INSTALL_NON_MARKET_APPS = "install_non_market_apps";
        public static final String LOCATION_PROVIDERS_ALLOWED = "location_providers_allowed";
        public static final String LOCK_PATTERN_ENABLED = "lock_pattern_autolock";
        public static final String LOCK_PATTERN_VISIBLE = "lock_pattern_visible_pattern";
        public static final String LOCK_PATTERN_TACTILE_FEEDBACK_ENABLED = "lock_pattern_tactile_feedback_enabled";
        @Deprecated
/*     */ public static final String LOGGING_ID = "logging_id";
        public static final String NETWORK_PREFERENCE = "network_preference";
        public static final String PARENTAL_CONTROL_ENABLED = "parental_control_enabled";
        public static final String PARENTAL_CONTROL_LAST_UPDATE = "parental_control_last_update";
        public static final String PARENTAL_CONTROL_REDIRECT_URL = "parental_control_redirect_url";
        public static final String SETTINGS_CLASSNAME = "settings_classname";
        public static final String USB_MASS_STORAGE_ENABLED = "usb_mass_storage_enabled";
        public static final String USE_GOOGLE_MAIL = "use_google_mail";
        public static final String ACCESSIBILITY_ENABLED = "accessibility_enabled";
        public static final String TOUCH_EXPLORATION_ENABLED = "touch_exploration_enabled";
        public static final String ENABLED_ACCESSIBILITY_SERVICES = "enabled_accessibility_services";
        public static final String ACCESSIBILITY_SPEAK_PASSWORD = "speak_password";
        @Deprecated
/*     */ public static final String TTS_USE_DEFAULTS = "tts_use_defaults";
        public static final String TTS_DEFAULT_RATE = "tts_default_rate";
        public static final String TTS_DEFAULT_PITCH = "tts_default_pitch";
        public static final String TTS_DEFAULT_SYNTH = "tts_default_synth";
        @Deprecated
/*     */ public static final String TTS_DEFAULT_LANG = "tts_default_lang";
        @Deprecated
/*     */ public static final String TTS_DEFAULT_COUNTRY = "tts_default_country";
        @Deprecated
/*     */ public static final String TTS_DEFAULT_VARIANT = "tts_default_variant";
        public static final String TTS_ENABLED_PLUGINS = "tts_enabled_plugins";
        public static final String WIFI_NETWORKS_AVAILABLE_NOTIFICATION_ON = "wifi_networks_available_notification_on";
        public static final String WIFI_NETWORKS_AVAILABLE_REPEAT_DELAY = "wifi_networks_available_repeat_delay";
        public static final String WIFI_NUM_OPEN_NETWORKS_KEPT = "wifi_num_open_networks_kept";
        public static final String WIFI_ON = "wifi_on";
        @Deprecated
/*     */ public static final String WIFI_WATCHDOG_ACCEPTABLE_PACKET_LOSS_PERCENTAGE = "wifi_watchdog_acceptable_packet_loss_percentage";
        @Deprecated
/*     */ public static final String WIFI_WATCHDOG_AP_COUNT = "wifi_watchdog_ap_count";
        @Deprecated
/*     */ public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_DELAY_MS = "wifi_watchdog_background_check_delay_ms";
        @Deprecated
/*     */ public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_ENABLED = "wifi_watchdog_background_check_enabled";
        @Deprecated
/*     */ public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_TIMEOUT_MS = "wifi_watchdog_background_check_timeout_ms";
        @Deprecated
/*     */ public static final String WIFI_WATCHDOG_INITIAL_IGNORED_PING_COUNT = "wifi_watchdog_initial_ignored_ping_count";
        @Deprecated
/*     */ public static final String WIFI_WATCHDOG_MAX_AP_CHECKS = "wifi_watchdog_max_ap_checks";
        public static final String WIFI_WATCHDOG_ON = "wifi_watchdog_on";
        @Deprecated
/*     */ public static final String WIFI_WATCHDOG_WATCH_LIST = "wifi_watchdog_watch_list";
        @Deprecated
/*     */ public static final String WIFI_WATCHDOG_PING_COUNT = "wifi_watchdog_ping_count";
        @Deprecated
/*     */ public static final String WIFI_WATCHDOG_PING_DELAY_MS = "wifi_watchdog_ping_delay_ms";
        @Deprecated
/*     */ public static final String WIFI_WATCHDOG_PING_TIMEOUT_MS = "wifi_watchdog_ping_timeout_ms";
        public static final String WIFI_MAX_DHCP_RETRY_COUNT = "wifi_max_dhcp_retry_count";
        public static final String WIFI_MOBILE_DATA_TRANSITION_WAKELOCK_TIMEOUT_MS = "wifi_mobile_data_transition_wakelock_timeout_ms";
        @Deprecated
/* 282 */ public static final String BACKGROUND_DATA = "background_data";
        public static final String ALLOWED_GEOLOCATION_ORIGINS = "allowed_geolocation_origins";
    }

    public Settings() {
        throw new RuntimeException("Stub!");
    }

    /*     */
/*     */   public static final String ACTION_ACCESSIBILITY_SETTINGS = "android.settings.ACCESSIBILITY_SETTINGS";
    /*     */   public static final String ACTION_SECURITY_SETTINGS = "android.settings.SECURITY_SETTINGS";
    /*     */   public static final String ACTION_PRIVACY_SETTINGS = "android.settings.PRIVACY_SETTINGS";
    /*     */   public static final String ACTION_WIFI_SETTINGS = "android.settings.WIFI_SETTINGS";
    /*     */   public static final String ACTION_WIFI_IP_SETTINGS = "android.settings.WIFI_IP_SETTINGS";
    /*     */   public static final String ACTION_BLUETOOTH_SETTINGS = "android.settings.BLUETOOTH_SETTINGS";
    /*     */   public static final String ACTION_DATE_SETTINGS = "android.settings.DATE_SETTINGS";
    /*     */   public static final String ACTION_SOUND_SETTINGS = "android.settings.SOUND_SETTINGS";
    /*     */   public static final String ACTION_DISPLAY_SETTINGS = "android.settings.DISPLAY_SETTINGS";
    /*     */   public static final String ACTION_LOCALE_SETTINGS = "android.settings.LOCALE_SETTINGS";
    /*     */   public static final String ACTION_INPUT_METHOD_SETTINGS = "android.settings.INPUT_METHOD_SETTINGS";
    /*     */   public static final String ACTION_INPUT_METHOD_SUBTYPE_SETTINGS = "android.settings.INPUT_METHOD_SUBTYPE_SETTINGS";
    /*     */   public static final String ACTION_USER_DICTIONARY_SETTINGS = "android.settings.USER_DICTIONARY_SETTINGS";
    /*     */   public static final String ACTION_APPLICATION_SETTINGS = "android.settings.APPLICATION_SETTINGS";
    /*     */   public static final String ACTION_APPLICATION_DEVELOPMENT_SETTINGS = "android.settings.APPLICATION_DEVELOPMENT_SETTINGS";
    /*     */   public static final String ACTION_QUICK_LAUNCH_SETTINGS = "android.settings.QUICK_LAUNCH_SETTINGS";
    /*     */   public static final String ACTION_MANAGE_APPLICATIONS_SETTINGS = "android.settings.MANAGE_APPLICATIONS_SETTINGS";
    /*     */   public static final String ACTION_MANAGE_ALL_APPLICATIONS_SETTINGS = "android.settings.MANAGE_ALL_APPLICATIONS_SETTINGS";
    /*     */   public static final String ACTION_APPLICATION_DETAILS_SETTINGS = "android.settings.APPLICATION_DETAILS_SETTINGS";
    /*     */   public static final String ACTION_SYNC_SETTINGS = "android.settings.SYNC_SETTINGS";
    /*     */   public static final String ACTION_ADD_ACCOUNT = "android.settings.ADD_ACCOUNT_SETTINGS";
    /*     */   public static final String ACTION_NETWORK_OPERATOR_SETTINGS = "android.settings.NETWORK_OPERATOR_SETTINGS";
    /*     */   public static final String ACTION_DATA_ROAMING_SETTINGS = "android.settings.DATA_ROAMING_SETTINGS";
    /*     */   public static final String ACTION_INTERNAL_STORAGE_SETTINGS = "android.settings.INTERNAL_STORAGE_SETTINGS";
    /*     */   public static final String ACTION_MEMORY_CARD_SETTINGS = "android.settings.MEMORY_CARD_SETTINGS";
    /*     */   public static final String ACTION_SEARCH_SETTINGS = "android.search.action.SEARCH_SETTINGS";
    /*     */   public static final String ACTION_DEVICE_INFO_SETTINGS = "android.settings.DEVICE_INFO_SETTINGS";
    /*     */   public static final String ACTION_NFC_SETTINGS = "android.settings.NFC_SETTINGS";
    /*     */   public static final String ACTION_NFCSHARING_SETTINGS = "android.settings.NFCSHARING_SETTINGS";
    /*     */   public static final String EXTRA_AUTHORITIES = "authorities";
    /*     */   public static final String EXTRA_INPUT_METHOD_ID = "input_method_id";
    /*     */   public static final String AUTHORITY = "settings";
/*     */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/provider/Settings.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */