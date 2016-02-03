/*     */
package android.provider;
/*     */ 
/*     */

import android.net.Uri;

/*     */
/*     */ public final class CalendarContract {
    public static final String ACTION_EVENT_REMINDER = "android.intent.action.EVENT_REMINDER";
    /*     */   public static final String ACTION_HANDLE_CUSTOM_EVENT = "android.provider.calendar.action.HANDLE_CUSTOM_EVENT";
    /*     */   public static final String EXTRA_CUSTOM_APP_URI = "customAppUri";
    /*     */   public static final String EXTRA_EVENT_BEGIN_TIME = "beginTime";
    /*     */   public static final String EXTRA_EVENT_END_TIME = "endTime";
    /*     */   public static final String EXTRA_EVENT_ALL_DAY = "allDay";
    /*     */   public static final String AUTHORITY = "com.android.calendar";

    /*     */
/*     */   protected static abstract interface CalendarSyncColumns {
        public static final String CAL_SYNC1 = "cal_sync1";
        /*     */     public static final String CAL_SYNC2 = "cal_sync2";
        /*     */     public static final String CAL_SYNC3 = "cal_sync3";
        /*     */     public static final String CAL_SYNC4 = "cal_sync4";
        /*     */     public static final String CAL_SYNC5 = "cal_sync5";
        /*     */     public static final String CAL_SYNC6 = "cal_sync6";
        /*     */     public static final String CAL_SYNC7 = "cal_sync7";
        /*     */     public static final String CAL_SYNC8 = "cal_sync8";
        /*     */     public static final String CAL_SYNC9 = "cal_sync9";
        /*     */     public static final String CAL_SYNC10 = "cal_sync10";
/*     */
    }

    /*     */
/*     */   protected static abstract interface SyncColumns extends CalendarContract.CalendarSyncColumns {
        public static final String ACCOUNT_NAME = "account_name";
        /*     */     public static final String ACCOUNT_TYPE = "account_type";
        /*     */     public static final String _SYNC_ID = "_sync_id";
        /*     */     public static final String DIRTY = "dirty";
        /*     */     public static final String DELETED = "deleted";
        /*     */     public static final String CAN_PARTIALLY_UPDATE = "canPartiallyUpdate";
    }

    /*     */
/*     */   protected static abstract interface CalendarColumns {
        public static final String CALENDAR_COLOR = "calendar_color";
        /*     */     public static final String CALENDAR_COLOR_KEY = "calendar_color_index";
        /*     */     public static final String CALENDAR_DISPLAY_NAME = "calendar_displayName";
        /*     */     public static final String CALENDAR_ACCESS_LEVEL = "calendar_access_level";
        /*     */     public static final int CAL_ACCESS_NONE = 0;
        /*     */     public static final int CAL_ACCESS_FREEBUSY = 100;
        /*     */     public static final int CAL_ACCESS_READ = 200;
        /*     */     public static final int CAL_ACCESS_RESPOND = 300;
        /*     */     public static final int CAL_ACCESS_OVERRIDE = 400;
        /*     */     public static final int CAL_ACCESS_CONTRIBUTOR = 500;
        /*     */     public static final int CAL_ACCESS_EDITOR = 600;
        /*     */     public static final int CAL_ACCESS_OWNER = 700;
        /*     */     public static final int CAL_ACCESS_ROOT = 800;
        /*     */     public static final String VISIBLE = "visible";
        /*     */     public static final String CALENDAR_TIME_ZONE = "calendar_timezone";
        /*     */     public static final String SYNC_EVENTS = "sync_events";
        /*     */     public static final String OWNER_ACCOUNT = "ownerAccount";
        /*     */     public static final String CAN_ORGANIZER_RESPOND = "canOrganizerRespond";
        /*     */     public static final String CAN_MODIFY_TIME_ZONE = "canModifyTimeZone";
        /*     */     public static final String MAX_REMINDERS = "maxReminders";
        /*     */     public static final String ALLOWED_REMINDERS = "allowedReminders";
        /*     */     public static final String ALLOWED_AVAILABILITY = "allowedAvailability";
        /*     */     public static final String ALLOWED_ATTENDEE_TYPES = "allowedAttendeeTypes";
    }

    /*     */
/*  56 */   public static final class CalendarEntity implements BaseColumns, CalendarContract.SyncColumns, CalendarContract.CalendarColumns {
        CalendarEntity() {
            throw new RuntimeException("Stub!");
        }

        /*  57 */
        public static android.content.EntityIterator newEntityIterator(android.database.Cursor cursor) {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */ 
/*  60 */     public static final Uri CONTENT_URI = null;
/*     */
    }

    /*     */
/*     */   public static final class Calendars implements BaseColumns, CalendarContract.SyncColumns, CalendarContract.CalendarColumns {
        /*     */     Calendars() {
/*  65 */
            throw new RuntimeException("Stub!");
/*     */
        }

        /*     */
/*     */ 
/*     */ 
/*     */ 
/*  71 */     public static final Uri CONTENT_URI = null;
        /*     */     public static final String DEFAULT_SORT_ORDER = "calendar_displayName";
        /*     */     public static final String NAME = "name";
        /*     */     public static final String CALENDAR_LOCATION = "calendar_location";
/*     */
    }

    /*     */
/*     */   protected static abstract interface AttendeesColumns {
        public static final String EVENT_ID = "event_id";
        /*     */     public static final String ATTENDEE_NAME = "attendeeName";
        /*     */     public static final String ATTENDEE_EMAIL = "attendeeEmail";
        /*     */     public static final String ATTENDEE_RELATIONSHIP = "attendeeRelationship";
        /*     */     public static final int RELATIONSHIP_NONE = 0;
        /*     */     public static final int RELATIONSHIP_ATTENDEE = 1;
        /*     */     public static final int RELATIONSHIP_ORGANIZER = 2;
        /*     */     public static final int RELATIONSHIP_PERFORMER = 3;
        /*     */     public static final int RELATIONSHIP_SPEAKER = 4;
        /*     */     public static final String ATTENDEE_TYPE = "attendeeType";
        /*     */     public static final int TYPE_NONE = 0;
        /*     */     public static final int TYPE_REQUIRED = 1;
        /*     */     public static final int TYPE_OPTIONAL = 2;
        /*     */     public static final int TYPE_RESOURCE = 3;
        /*     */     public static final String ATTENDEE_STATUS = "attendeeStatus";
        /*     */     public static final int ATTENDEE_STATUS_NONE = 0;
        /*     */     public static final int ATTENDEE_STATUS_ACCEPTED = 1;
        /*     */     public static final int ATTENDEE_STATUS_DECLINED = 2;
        /*     */     public static final int ATTENDEE_STATUS_INVITED = 3;
        /*     */     public static final int ATTENDEE_STATUS_TENTATIVE = 4;
        /*     */     public static final String ATTENDEE_IDENTITY = "attendeeIdentity";
        /*     */     public static final String ATTENDEE_ID_NAMESPACE = "attendeeIdNamespace";
/*     */
    }

    /*     */
/* 101 */   public static final class Attendees implements BaseColumns, CalendarContract.AttendeesColumns, CalendarContract.EventsColumns {
        Attendees() {
            throw new RuntimeException("Stub!");
        }

        /* 102 */
        public static final android.database.Cursor query(android.content.ContentResolver cr, long eventId, String[] projection) {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */ 
/* 105 */     public static final Uri CONTENT_URI = null;
/*     */
    }

    /*     */
/*     */   protected static abstract interface EventsColumns {
        /*     */     public static final String CALENDAR_ID = "calendar_id";
        /*     */     public static final String TITLE = "title";
        /*     */     public static final String DESCRIPTION = "description";
        /*     */     public static final String EVENT_LOCATION = "eventLocation";
        /*     */     public static final String EVENT_COLOR = "eventColor";
        /*     */     public static final String EVENT_COLOR_KEY = "eventColor_index";
        /*     */     public static final String DISPLAY_COLOR = "displayColor";
        /*     */     public static final String STATUS = "eventStatus";
        /*     */     public static final int STATUS_TENTATIVE = 0;
        /*     */     public static final int STATUS_CONFIRMED = 1;
        /*     */     public static final int STATUS_CANCELED = 2;
        /*     */     public static final String SELF_ATTENDEE_STATUS = "selfAttendeeStatus";
        /*     */     public static final String SYNC_DATA1 = "sync_data1";
        /*     */     public static final String SYNC_DATA2 = "sync_data2";
        /*     */     public static final String SYNC_DATA3 = "sync_data3";
        /*     */     public static final String SYNC_DATA4 = "sync_data4";
        /*     */     public static final String SYNC_DATA5 = "sync_data5";
        /*     */     public static final String SYNC_DATA6 = "sync_data6";
        /*     */     public static final String SYNC_DATA7 = "sync_data7";
        /*     */     public static final String SYNC_DATA8 = "sync_data8";
        /*     */     public static final String SYNC_DATA9 = "sync_data9";
        /*     */     public static final String SYNC_DATA10 = "sync_data10";
        /*     */     public static final String LAST_SYNCED = "lastSynced";
        /*     */     public static final String DTSTART = "dtstart";
        /*     */     public static final String DTEND = "dtend";
        /*     */     public static final String DURATION = "duration";
        /*     */     public static final String EVENT_TIMEZONE = "eventTimezone";
        /*     */     public static final String EVENT_END_TIMEZONE = "eventEndTimezone";
        /*     */     public static final String ALL_DAY = "allDay";
        /*     */     public static final String ACCESS_LEVEL = "accessLevel";
        /*     */     public static final int ACCESS_DEFAULT = 0;
        /*     */     public static final int ACCESS_CONFIDENTIAL = 1;
        /*     */     public static final int ACCESS_PRIVATE = 2;
        /*     */     public static final int ACCESS_PUBLIC = 3;
        /*     */     public static final String AVAILABILITY = "availability";
        /*     */     public static final int AVAILABILITY_BUSY = 0;
        /*     */     public static final int AVAILABILITY_FREE = 1;
        /*     */     public static final int AVAILABILITY_TENTATIVE = 2;
        /*     */     public static final String HAS_ALARM = "hasAlarm";
        /*     */     public static final String HAS_EXTENDED_PROPERTIES = "hasExtendedProperties";
        /*     */     public static final String RRULE = "rrule";
        /*     */     public static final String RDATE = "rdate";
        /*     */     public static final String EXRULE = "exrule";
        /*     */     public static final String EXDATE = "exdate";
        /*     */     public static final String ORIGINAL_ID = "original_id";
        /*     */     public static final String ORIGINAL_SYNC_ID = "original_sync_id";
        /*     */     public static final String ORIGINAL_INSTANCE_TIME = "originalInstanceTime";
        /*     */     public static final String ORIGINAL_ALL_DAY = "originalAllDay";
        /*     */     public static final String LAST_DATE = "lastDate";
        /*     */     public static final String HAS_ATTENDEE_DATA = "hasAttendeeData";
        /*     */     public static final String GUESTS_CAN_MODIFY = "guestsCanModify";
        /*     */     public static final String GUESTS_CAN_INVITE_OTHERS = "guestsCanInviteOthers";
        /*     */     public static final String GUESTS_CAN_SEE_GUESTS = "guestsCanSeeGuests";
        /*     */     public static final String ORGANIZER = "organizer";
        /*     */     public static final String CAN_INVITE_OTHERS = "canInviteOthers";
        /*     */     public static final String CUSTOM_APP_PACKAGE = "customAppPackage";
        /*     */     public static final String CUSTOM_APP_URI = "customAppUri";
/*     */
    }

    /*     */
/*     */   public static final class EventsEntity implements BaseColumns, CalendarContract.SyncColumns, CalendarContract.EventsColumns {
        /*     */     EventsEntity() {
/* 170 */
            throw new RuntimeException("Stub!");
        }

        /* 171 */
        public static android.content.EntityIterator newEntityIterator(android.database.Cursor cursor, android.content.ContentResolver resolver) {
            throw new RuntimeException("Stub!");
        }

        /* 172 */
        public static android.content.EntityIterator newEntityIterator(android.database.Cursor cursor, android.content.ContentProviderClient provider) {
            throw new RuntimeException("Stub!");
        }

        /*     */
/* 174 */     public static final Uri CONTENT_URI = null;
/*     */
    }

    /*     */
/*     */   public static final class Events implements BaseColumns, CalendarContract.SyncColumns, CalendarContract.EventsColumns, CalendarContract.CalendarColumns {
        /*     */     Events() {
/* 179 */
            throw new RuntimeException("Stub!");
/*     */
        }

        /*     */
/*     */ 
/* 183 */     public static final Uri CONTENT_EXCEPTION_URI = null;
        public static final Uri CONTENT_URI = null;
/*     */
    }

    /*     */
/*     */   public static final class Instances implements BaseColumns, CalendarContract.EventsColumns, CalendarContract.CalendarColumns {
        public static final String END_MINUTE = "endMinute";

        /*     */
/* 188 */     Instances() {
            throw new RuntimeException("Stub!");
        }

        /* 189 */
        public static final android.database.Cursor query(android.content.ContentResolver cr, String[] projection, long begin, long end) {
            throw new RuntimeException("Stub!");
        }

        /* 190 */
        public static final android.database.Cursor query(android.content.ContentResolver cr, String[] projection, long begin, long end, String searchQuery) {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */ 
/*     */     public static final String START_MINUTE = "startMinute";
        /*     */
/*     */     public static final String END_DAY = "endDay";
        /*     */
/*     */     public static final String START_DAY = "startDay";
        /*     */
/*     */     public static final String EVENT_ID = "event_id";
        /*     */
/*     */     public static final String END = "end";
        /*     */     public static final String BEGIN = "begin";
        /* 203 */     public static final Uri CONTENT_SEARCH_BY_DAY_URI = null;
        public static final Uri CONTENT_SEARCH_URI = null;
        public static final Uri CONTENT_BY_DAY_URI = null;
        public static final Uri CONTENT_URI = null;
/*     */
    }

    /*     */
/*     */   protected static abstract interface CalendarCacheColumns {
        /*     */     public static final String KEY = "key";
        /*     */     public static final String VALUE = "value";
/*     */
    }

    /*     */
/*     */   public static final class CalendarCache implements CalendarContract.CalendarCacheColumns {
        /*     */     CalendarCache() {
/* 213 */
            throw new RuntimeException("Stub!");
/*     */
        }

        /*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 220 */     public static final Uri URI = null;
        /*     */     public static final String KEY_TIMEZONE_TYPE = "timezoneType";
        /*     */     public static final String KEY_TIMEZONE_INSTANCES = "timezoneInstances";
        /*     */     public static final String KEY_TIMEZONE_INSTANCES_PREVIOUS = "timezoneInstancesPrevious";
        /*     */     public static final String TIMEZONE_TYPE_AUTO = "auto";
        /*     */     public static final String TIMEZONE_TYPE_HOME = "home";
    }

    /*     */
/*     */   protected static abstract interface EventDaysColumns {
        public static final String STARTDAY = "startDay";
        /*     */     public static final String ENDDAY = "endDay";
    }

    /*     */
/* 230 */   public static final class EventDays implements CalendarContract.EventDaysColumns {
        EventDays() {
            throw new RuntimeException("Stub!");
        }

        /* 231 */
        public static final android.database.Cursor query(android.content.ContentResolver cr, int startDay, int numDays, String[] projection) {
            throw new RuntimeException("Stub!");
        }

        /*     */
/* 233 */     public static final Uri CONTENT_URI = null;
/*     */
    }

    /*     */
/*     */   protected static abstract interface RemindersColumns {
        /*     */     public static final String EVENT_ID = "event_id";
        /*     */     public static final String MINUTES = "minutes";
        /*     */     public static final int MINUTES_DEFAULT = -1;
        /*     */     public static final String METHOD = "method";
        /*     */     public static final int METHOD_DEFAULT = 0;
        /*     */     public static final int METHOD_ALERT = 1;
        /*     */     public static final int METHOD_EMAIL = 2;
        /*     */     public static final int METHOD_SMS = 3;
        /*     */     public static final int METHOD_ALARM = 4;
/*     */
    }

    /*     */
/*     */   public static final class Reminders implements BaseColumns, CalendarContract.RemindersColumns, CalendarContract.EventsColumns {
        /*     */     Reminders() {
/* 250 */
            throw new RuntimeException("Stub!");
        }

        /* 251 */
        public static final android.database.Cursor query(android.content.ContentResolver cr, long eventId, String[] projection) {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */ 
/* 254 */     public static final Uri CONTENT_URI = null;
/*     */
    }

    /*     */
/*     */   protected static abstract interface CalendarAlertsColumns {
        /*     */     public static final String EVENT_ID = "event_id";
        /*     */     public static final String BEGIN = "begin";
        /*     */     public static final String END = "end";
        /*     */     public static final String ALARM_TIME = "alarmTime";
        /*     */     public static final String CREATION_TIME = "creationTime";
        /*     */     public static final String RECEIVED_TIME = "receivedTime";
        /*     */     public static final String NOTIFY_TIME = "notifyTime";
        /*     */     public static final String STATE = "state";
        /*     */     public static final int STATE_SCHEDULED = 0;
        /*     */     public static final int STATE_FIRED = 1;
        /*     */     public static final int STATE_DISMISSED = 2;
        /*     */     public static final String MINUTES = "minutes";
        /*     */     public static final String DEFAULT_SORT_ORDER = "begin ASC,title ASC";
/*     */
    }

    /*     */
/*     */   public static final class CalendarAlerts implements BaseColumns, CalendarContract.CalendarAlertsColumns, CalendarContract.EventsColumns, CalendarContract.CalendarColumns {
        /*     */     CalendarAlerts() {
/* 275 */
            throw new RuntimeException("Stub!");
/*     */
        }

        /*     */
/*     */ 
/* 279 */     public static final Uri CONTENT_URI_BY_INSTANCE = null;
        public static final Uri CONTENT_URI = null;
/*     */
    }

    /*     */
/*     */   protected static abstract interface ColorsColumns extends SyncStateContract.Columns
/*     */ {
        /*     */     public static final String COLOR_TYPE = "color_type";
        /*     */     public static final int TYPE_CALENDAR = 0;
        /*     */     public static final int TYPE_EVENT = 1;
        /*     */     public static final String COLOR_KEY = "color_index";
        /*     */     public static final String COLOR = "color";
/*     */
    }

    /*     */
/*     */   public static final class Colors implements CalendarContract.ColorsColumns {
        /*     */     Colors() {
/* 293 */
            throw new RuntimeException("Stub!");
/*     */
        }

        /*     */
/* 296 */     public static final Uri CONTENT_URI = null;
/*     */
    }

    /*     */
/*     */   protected static abstract interface ExtendedPropertiesColumns {
        /*     */     public static final String EVENT_ID = "event_id";
        /*     */     public static final String NAME = "name";
        /*     */     public static final String VALUE = "value";
/*     */
    }

    /*     */
/*     */   public static final class ExtendedProperties implements BaseColumns, CalendarContract.ExtendedPropertiesColumns, CalendarContract.EventsColumns {
        /*     */     ExtendedProperties() {
/* 307 */
            throw new RuntimeException("Stub!");
        }

        /*     */
/* 309 */     public static final Uri CONTENT_URI = null;
/*     */
    }

    /*     */
/*     */   public static final class SyncState implements SyncStateContract.Columns {
        /*     */     SyncState() {
/* 314 */
            throw new RuntimeException("Stub!");
        }

        /*     */
/* 316 */     public static final Uri CONTENT_URI = null;
    }

    /*     */
/* 318 */   CalendarContract() {
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
/* 329 */   public static final Uri CONTENT_URI = null;
    /*     */   public static final String CALLER_IS_SYNCADAPTER = "caller_is_syncadapter";
    /*     */   public static final String ACCOUNT_TYPE_LOCAL = "LOCAL";
/*     */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/provider/CalendarContract.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */