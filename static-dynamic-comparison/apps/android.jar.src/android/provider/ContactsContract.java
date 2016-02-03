/*     */
package android.provider;
/*     */ 
/*     */

import android.net.Uri;

/*     */
/*     */ public final class ContactsContract {
    /*     */   public static final String AUTHORITY = "com.android.contacts";

    /*     */
/*   8 */   public static final class Directory implements BaseColumns {
        Directory() {
            throw new RuntimeException("Stub!");
        }

        /*   9 */
        public static void notifyDirectoryChange(android.content.ContentResolver resolver) {
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
/*  34 */     public static final Uri CONTENT_URI = null;
        /*     */     public static final String CONTENT_TYPE = "vnd.android.cursor.dir/contact_directories";
        /*     */     public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/contact_directory";
        /*     */     public static final long DEFAULT = 0L;
        /*     */     public static final long LOCAL_INVISIBLE = 1L;
        public static final String PACKAGE_NAME = "packageName";
        public static final String TYPE_RESOURCE_ID = "typeResourceId";
        public static final String DISPLAY_NAME = "displayName";
        public static final String DIRECTORY_AUTHORITY = "authority";
        public static final String ACCOUNT_TYPE = "accountType";
        public static final String ACCOUNT_NAME = "accountName";
        public static final String EXPORT_SUPPORT = "exportSupport";
        public static final int EXPORT_SUPPORT_NONE = 0;
        public static final int EXPORT_SUPPORT_SAME_ACCOUNT_ONLY = 1;
        public static final int EXPORT_SUPPORT_ANY_ACCOUNT = 2;
        public static final String SHORTCUT_SUPPORT = "shortcutSupport";
        public static final int SHORTCUT_SUPPORT_NONE = 0;
        public static final int SHORTCUT_SUPPORT_DATA_ITEMS_ONLY = 1;
        public static final int SHORTCUT_SUPPORT_FULL = 2;
        public static final String PHOTO_SUPPORT = "photoSupport";
        public static final int PHOTO_SUPPORT_NONE = 0;
        public static final int PHOTO_SUPPORT_THUMBNAIL_ONLY = 1;
        public static final int PHOTO_SUPPORT_FULL_SIZE_ONLY = 2;
        public static final int PHOTO_SUPPORT_FULL = 3;
    }

    /*  39 */   public static final class SyncState implements SyncStateContract.Columns {
        SyncState() {
            throw new RuntimeException("Stub!");
        }

        /*  40 */
        public static byte[] get(android.content.ContentProviderClient provider, android.accounts.Account account) throws android.os.RemoteException {
            throw new RuntimeException("Stub!");
        }

        /*  41 */
        public static android.util.Pair<Uri, byte[]> getWithUri(android.content.ContentProviderClient provider, android.accounts.Account account) throws android.os.RemoteException {
            throw new RuntimeException("Stub!");
        }

        /*  42 */
        public static void set(android.content.ContentProviderClient provider, android.accounts.Account account, byte[] data) throws android.os.RemoteException {
            throw new RuntimeException("Stub!");
        }

        /*  43 */
        public static android.content.ContentProviderOperation newSetOperation(android.accounts.Account account, byte[] data) {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */     public static final String CONTENT_DIRECTORY = "syncstate";
        /*  46 */     public static final Uri CONTENT_URI = null;
/*     */
    }

    /*     */
/*     */   public static final class ProfileSyncState implements SyncStateContract.Columns {
        public static final String CONTENT_DIRECTORY = "syncstate";

        /*     */
/*  51 */     ProfileSyncState() {
            throw new RuntimeException("Stub!");
        }

        /*  52 */
        public static byte[] get(android.content.ContentProviderClient provider, android.accounts.Account account) throws android.os.RemoteException {
            throw new RuntimeException("Stub!");
        }

        /*  53 */
        public static android.util.Pair<Uri, byte[]> getWithUri(android.content.ContentProviderClient provider, android.accounts.Account account) throws android.os.RemoteException {
            throw new RuntimeException("Stub!");
        }

        /*  54 */
        public static void set(android.content.ContentProviderClient provider, android.accounts.Account account, byte[] data) throws android.os.RemoteException {
            throw new RuntimeException("Stub!");
        }

        /*  55 */
        public static android.content.ContentProviderOperation newSetOperation(android.accounts.Account account, byte[] data) {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */ 
/*  58 */     public static final Uri CONTENT_URI = null;
/*     */
    }

    /*     */
/*     */   protected static abstract interface BaseSyncColumns {
        /*     */     public static final String SYNC1 = "sync1";
        /*     */     public static final String SYNC2 = "sync2";
        /*     */     public static final String SYNC3 = "sync3";
        /*     */     public static final String SYNC4 = "sync4";
/*     */
    }

    /*     */
/*     */   protected static abstract interface SyncColumns extends ContactsContract.BaseSyncColumns {
        /*     */     public static final String ACCOUNT_NAME = "account_name";
        /*     */     public static final String ACCOUNT_TYPE = "account_type";
        /*     */     public static final String SOURCE_ID = "sourceid";
        /*     */     public static final String VERSION = "version";
        /*     */     public static final String DIRTY = "dirty";
/*     */
    }

    /*     */
/*     */   protected static abstract interface ContactOptionsColumns {
        /*     */     public static final String TIMES_CONTACTED = "times_contacted";
        /*     */     public static final String LAST_TIME_CONTACTED = "last_time_contacted";
        /*     */     public static final String STARRED = "starred";
        /*     */     public static final String CUSTOM_RINGTONE = "custom_ringtone";
        /*     */     public static final String SEND_TO_VOICEMAIL = "send_to_voicemail";
/*     */
    }

    /*     */
/*     */   protected static abstract interface ContactsColumns {
        /*     */     public static final String DISPLAY_NAME = "display_name";
        /*     */     public static final String PHOTO_ID = "photo_id";
        /*     */     public static final String PHOTO_FILE_ID = "photo_file_id";
        /*     */     public static final String PHOTO_URI = "photo_uri";
        /*     */     public static final String PHOTO_THUMBNAIL_URI = "photo_thumb_uri";
        /*     */     public static final String IN_VISIBLE_GROUP = "in_visible_group";
        /*     */     public static final String IS_USER_PROFILE = "is_user_profile";
        /*     */     public static final String HAS_PHONE_NUMBER = "has_phone_number";
        /*     */     public static final String LOOKUP_KEY = "lookup";
/*     */
    }

    /*     */
/*     */   protected static abstract interface ContactStatusColumns {
        /*     */     public static final String CONTACT_PRESENCE = "contact_presence";
        /*     */     public static final String CONTACT_CHAT_CAPABILITY = "contact_chat_capability";
        /*     */     public static final String CONTACT_STATUS = "contact_status";
        /*     */     public static final String CONTACT_STATUS_TIMESTAMP = "contact_status_ts";
        /*     */     public static final String CONTACT_STATUS_RES_PACKAGE = "contact_status_res_package";
        /*     */     public static final String CONTACT_STATUS_LABEL = "contact_status_label";
        /*     */     public static final String CONTACT_STATUS_ICON = "contact_status_icon";
/*     */
    }

    /*     */
/*     */   public static abstract interface FullNameStyle {
        /*     */     public static final int UNDEFINED = 0;
        /*     */     public static final int WESTERN = 1;
        /*     */     public static final int CJK = 2;
        /*     */     public static final int CHINESE = 3;
        /*     */     public static final int JAPANESE = 4;
        /*     */     public static final int KOREAN = 5;
/*     */
    }

    /*     */
/*     */   public static abstract interface PhoneticNameStyle {
        /*     */     public static final int UNDEFINED = 0;
        /*     */     public static final int PINYIN = 3;
        /*     */     public static final int JAPANESE = 4;
        /*     */     public static final int KOREAN = 5;
/*     */
    }

    /*     */
/*     */   public static abstract interface DisplayNameSources {
        /*     */     public static final int UNDEFINED = 0;
        /*     */     public static final int EMAIL = 10;
        /*     */     public static final int PHONE = 20;
        /*     */     public static final int ORGANIZATION = 30;
        /*     */     public static final int NICKNAME = 35;
        /*     */     public static final int STRUCTURED_NAME = 40;
/*     */
    }

    /*     */
/*     */   protected static abstract interface ContactNameColumns {
        /*     */     public static final String DISPLAY_NAME_SOURCE = "display_name_source";
        /*     */     public static final String DISPLAY_NAME_PRIMARY = "display_name";
        /*     */     public static final String DISPLAY_NAME_ALTERNATIVE = "display_name_alt";
        /*     */     public static final String PHONETIC_NAME_STYLE = "phonetic_name_style";
        /*     */     public static final String PHONETIC_NAME = "phonetic_name";
        /*     */     public static final String SORT_KEY_PRIMARY = "sort_key";
        /*     */     public static final String SORT_KEY_ALTERNATIVE = "sort_key_alt";
/*     */
    }

    /*     */
/*     */   public static class Contacts implements BaseColumns, ContactsContract.ContactsColumns, ContactsContract.ContactOptionsColumns, ContactsContract.ContactNameColumns, ContactsContract.ContactStatusColumns {
        public static final String CONTENT_VCARD_TYPE = "text/x-vcard";
        /*     */     public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/contact";
        /*     */     public static final String CONTENT_TYPE = "vnd.android.cursor.dir/contact";

        /*     */
/*     */     public static final class Data implements BaseColumns, ContactsContract.DataColumns {
            public static final String CONTENT_DIRECTORY = "data";

            /*     */
/* 147 */       Data() {
                throw new RuntimeException("Stub!");
            }
        }

        /*     */
/*     */     public static final class Entity implements BaseColumns, ContactsContract.ContactsColumns, ContactsContract.ContactNameColumns, ContactsContract.RawContactsColumns, ContactsContract.BaseSyncColumns, ContactsContract.SyncColumns, ContactsContract.DataColumns, ContactsContract.StatusColumns, ContactsContract.ContactOptionsColumns, ContactsContract.ContactStatusColumns {
            public static final String CONTENT_DIRECTORY = "entities";
            /*     */       public static final String RAW_CONTACT_ID = "raw_contact_id";
            /*     */       public static final String DATA_ID = "data_id";

            /*     */
/* 153 */       Entity() {
                throw new RuntimeException("Stub!");
            }
/*     */
        }

        /*     */
/*     */     public static final class StreamItems
/*     */ implements ContactsContract.StreamItemsColumns
/*     */ {
            /*     */       public static final String CONTENT_DIRECTORY = "stream_items";

            /*     */
/* 161 */       StreamItems() {
                throw new RuntimeException("Stub!");
            }
/*     */
        }

        /*     */
/*     */     public static final class AggregationSuggestions implements BaseColumns, ContactsContract.ContactsColumns, ContactsContract.ContactOptionsColumns, ContactsContract.ContactStatusColumns {
            /*     */       public static final String CONTENT_DIRECTORY = "suggestions";

            /*     */
/* 167 */       AggregationSuggestions() {
                throw new RuntimeException("Stub!");
            }
        }

        /*     */
/*     */     public static final class Photo implements BaseColumns, ContactsContract.DataColumnsWithJoins {
            public static final String CONTENT_DIRECTORY = "photo";
            /*     */       public static final String DISPLAY_PHOTO = "display_photo";
            /*     */       public static final String PHOTO_FILE_ID = "data14";
            /*     */       public static final String PHOTO = "data15";

            /* 173 */       Photo() {
                throw new RuntimeException("Stub!");
            }
/*     */
        }

        /*     */
/*     */ 
/*     */     Contacts()
/*     */ {
/* 179 */
            throw new RuntimeException("Stub!");
        }

        /* 180 */
        public static Uri getLookupUri(android.content.ContentResolver resolver, Uri contactUri) {
            throw new RuntimeException("Stub!");
        }

        /* 181 */
        public static Uri getLookupUri(long contactId, String lookupKey) {
            throw new RuntimeException("Stub!");
        }

        /* 182 */
        public static Uri lookupContact(android.content.ContentResolver resolver, Uri lookupUri) {
            throw new RuntimeException("Stub!");
        }

        /*     */
        @Deprecated
/* 184 */ public static void markAsContacted(android.content.ContentResolver resolver, long contactId) {
            throw new RuntimeException("Stub!");
        }

        /* 185 */
        public static java.io.InputStream openContactPhotoInputStream(android.content.ContentResolver cr, Uri contactUri, boolean preferHighres) {
            throw new RuntimeException("Stub!");
        }

        /* 186 */
        public static java.io.InputStream openContactPhotoInputStream(android.content.ContentResolver cr, Uri contactUri) {
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
/* 197 */     public static final Uri CONTENT_GROUP_URI = null;
        public static final Uri CONTENT_STREQUENT_FILTER_URI = null;
        public static final Uri CONTENT_STREQUENT_URI = null;
        public static final Uri CONTENT_FILTER_URI = null;
        public static final Uri CONTENT_VCARD_URI = null;
        public static final Uri CONTENT_LOOKUP_URI = null;
        public static final Uri CONTENT_URI = null;
/*     */
    }

    /*     */
/*     */   public static final class Profile implements BaseColumns, ContactsContract.ContactsColumns, ContactsContract.ContactOptionsColumns, ContactsContract.ContactNameColumns, ContactsContract.ContactStatusColumns {
        public static final long MIN_ID = 9223372034707292160L;

        /*     */
/* 202 */     Profile() {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */ 
/*     */ 
/*     */ 
/* 207 */     public static final Uri CONTENT_RAW_CONTACTS_URI = null;
        public static final Uri CONTENT_VCARD_URI = null;
        public static final Uri CONTENT_URI = null;
/*     */
    }

    /*     */
/*     */   protected static abstract interface RawContactsColumns {
        /*     */     public static final String CONTACT_ID = "contact_id";
        /*     */     public static final String DATA_SET = "data_set";
        /*     */     public static final String AGGREGATION_MODE = "aggregation_mode";
        /*     */     public static final String DELETED = "deleted";
        /*     */     public static final String RAW_CONTACT_IS_READ_ONLY = "raw_contact_is_read_only";
        /*     */     public static final String RAW_CONTACT_IS_USER_PROFILE = "raw_contact_is_user_profile";
/*     */
    }

    /*     */
/*     */   public static final class RawContacts
/*     */ implements BaseColumns, ContactsContract.RawContactsColumns, ContactsContract.ContactOptionsColumns, ContactsContract.ContactNameColumns, ContactsContract.SyncColumns {
        /*     */     public static final class Data implements BaseColumns, ContactsContract.DataColumns {
            /*     */       public static final String CONTENT_DIRECTORY = "data";

            /*     */
/* 224 */       Data() {
                throw new RuntimeException("Stub!");
            }
/*     */
        }

        /*     */
/*     */     public static final class Entity implements BaseColumns, ContactsContract.DataColumns {
            public static final String CONTENT_DIRECTORY = "entity";
            /*     */       public static final String DATA_ID = "data_id";

            /*     */
/* 230 */       Entity() {
                throw new RuntimeException("Stub!");
            }
/*     */
        }

        /*     */
/*     */     public static final class StreamItems
/*     */ implements BaseColumns, ContactsContract.StreamItemsColumns {
            /*     */       public static final String CONTENT_DIRECTORY = "stream_items";

            /*     */
/* 237 */       StreamItems() {
                throw new RuntimeException("Stub!");
            }
/*     */
        }

        /*     */
/*     */     public static final class DisplayPhoto {
            public static final String CONTENT_DIRECTORY = "display_photo";

            /*     */
/* 242 */       DisplayPhoto() {
                throw new RuntimeException("Stub!");
            }
/*     */
        }

        /*     */
/* 245 */     RawContacts() {
            throw new RuntimeException("Stub!");
        }

        /* 246 */
        public static Uri getContactLookupUri(android.content.ContentResolver resolver, Uri rawContactUri) {
            throw new RuntimeException("Stub!");
        }

        /* 247 */
        public static android.content.EntityIterator newEntityIterator(android.database.Cursor cursor) {
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
/* 256 */     public static final Uri CONTENT_URI = null;
        /*     */     public static final String CONTENT_TYPE = "vnd.android.cursor.dir/raw_contact";
        /*     */     public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/raw_contact";
        /*     */     public static final int AGGREGATION_MODE_DEFAULT = 0;
        /*     */
        @Deprecated
/*     */ public static final int AGGREGATION_MODE_IMMEDIATE = 1;
        /*     */     public static final int AGGREGATION_MODE_SUSPENDED = 2;
        /*     */     public static final int AGGREGATION_MODE_DISABLED = 3;
    }

    /*     */
/*     */   protected static abstract interface StatusColumns {
        public static final String PRESENCE = "mode";
        /*     */
        @Deprecated
/*     */ public static final String PRESENCE_STATUS = "mode";
        /*     */     public static final int OFFLINE = 0;
        /*     */     public static final int INVISIBLE = 1;
        /*     */     public static final int AWAY = 2;
        /*     */     public static final int IDLE = 3;
        /*     */     public static final int DO_NOT_DISTURB = 4;
        /*     */     public static final int AVAILABLE = 5;
        /*     */     public static final String STATUS = "status";
        /*     */
        @Deprecated
/*     */ public static final String PRESENCE_CUSTOM_STATUS = "status";
        /*     */     public static final String STATUS_TIMESTAMP = "status_ts";
        /*     */     public static final String STATUS_RES_PACKAGE = "status_res_package";
        /*     */     public static final String STATUS_LABEL = "status_label";
        /*     */     public static final String STATUS_ICON = "status_icon";
        /*     */     public static final String CHAT_CAPABILITY = "chat_capability";
        /*     */     public static final int CAPABILITY_HAS_VOICE = 1;
        /*     */     public static final int CAPABILITY_HAS_VIDEO = 2;
        /*     */     public static final int CAPABILITY_HAS_CAMERA = 4;
    }

    /*     */   public static final class StreamItems implements BaseColumns, ContactsContract.StreamItemsColumns {
        public static final String MAX_ITEMS = "max_items";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/stream_item";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/stream_item";

        /*     */     public static final class StreamItemPhotos implements BaseColumns, ContactsContract.StreamItemPhotosColumns {
            public static final String CONTENT_DIRECTORY = "photo";

            /* 287 */       StreamItemPhotos() {
                throw new RuntimeException("Stub!");
            }

            /*     */
/*     */       public static final String CONTENT_TYPE = "vnd.android.cursor.dir/stream_item_photo";
            /*     */       public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/stream_item_photo";
        }

        /*     */
/* 292 */     StreamItems() {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 299 */     public static final Uri CONTENT_LIMIT_URI = null;
        public static final Uri CONTENT_PHOTO_URI = null;
        public static final Uri CONTENT_URI = null;
/*     */
    }

    /*     */
/*     */   protected static abstract interface StreamItemsColumns {
        /*     */     public static final String CONTACT_ID = "contact_id";
        /*     */     public static final String CONTACT_LOOKUP_KEY = "contact_lookup";
        /*     */     public static final String RAW_CONTACT_ID = "raw_contact_id";
        /*     */     public static final String RES_PACKAGE = "res_package";
        /*     */     public static final String ACCOUNT_TYPE = "account_type";
        /*     */     public static final String ACCOUNT_NAME = "account_name";
        /*     */     public static final String DATA_SET = "data_set";
        /*     */     public static final String RAW_CONTACT_SOURCE_ID = "raw_contact_source_id";
        /*     */     public static final String RES_ICON = "icon";
        /*     */     public static final String RES_LABEL = "label";
        /*     */     public static final String TEXT = "text";
        /*     */     public static final String TIMESTAMP = "timestamp";
        /*     */     public static final String COMMENTS = "comments";
        /*     */     public static final String SYNC1 = "stream_item_sync1";
        /*     */     public static final String SYNC2 = "stream_item_sync2";
        /*     */     public static final String SYNC3 = "stream_item_sync3";
        /*     */     public static final String SYNC4 = "stream_item_sync4";
/*     */
    }

    /*     */
/*     */   public static final class StreamItemPhotos implements BaseColumns, ContactsContract.StreamItemPhotosColumns {
        public static final String PHOTO = "photo";

        /*     */
/* 324 */     StreamItemPhotos() {
            throw new RuntimeException("Stub!");
        }
/*     */
    }

    /*     */
/*     */   protected static abstract interface StreamItemPhotosColumns
/*     */ {
        /*     */     public static final String STREAM_ITEM_ID = "stream_item_id";
        /*     */     public static final String SORT_INDEX = "sort_index";
        /*     */     public static final String PHOTO_FILE_ID = "photo_file_id";
        /*     */     public static final String PHOTO_URI = "photo_uri";
        /*     */     public static final String SYNC1 = "stream_item_photo_sync1";
        /*     */     public static final String SYNC2 = "stream_item_photo_sync2";
        /*     */     public static final String SYNC3 = "stream_item_photo_sync3";
        /*     */     public static final String SYNC4 = "stream_item_photo_sync4";
/*     */
    }

    /*     */
/*     */   protected static abstract interface DataColumns
/*     */ {
        /*     */     public static final String MIMETYPE = "mimetype";
        /*     */     public static final String RAW_CONTACT_ID = "raw_contact_id";
        /*     */     public static final String IS_PRIMARY = "is_primary";
        /*     */     public static final String IS_SUPER_PRIMARY = "is_super_primary";
        /*     */     public static final String IS_READ_ONLY = "is_read_only";
        /*     */     public static final String DATA_VERSION = "data_version";
        /*     */     public static final String DATA1 = "data1";
        /*     */     public static final String DATA2 = "data2";
        /*     */     public static final String DATA3 = "data3";
        /*     */     public static final String DATA4 = "data4";
        /*     */     public static final String DATA5 = "data5";
        /*     */     public static final String DATA6 = "data6";
        /*     */     public static final String DATA7 = "data7";
        /*     */     public static final String DATA8 = "data8";
        /*     */     public static final String DATA9 = "data9";
        /*     */     public static final String DATA10 = "data10";
        /*     */     public static final String DATA11 = "data11";
        /*     */     public static final String DATA12 = "data12";
        /*     */     public static final String DATA13 = "data13";
        /*     */     public static final String DATA14 = "data14";
        /*     */     public static final String DATA15 = "data15";
        /*     */     public static final String SYNC1 = "data_sync1";
        /*     */     public static final String SYNC2 = "data_sync2";
        /*     */     public static final String SYNC3 = "data_sync3";
        /*     */     public static final String SYNC4 = "data_sync4";
/*     */
    }

    /*     */
/*     */   protected static abstract interface DataColumnsWithJoins extends BaseColumns, ContactsContract.DataColumns, ContactsContract.StatusColumns, ContactsContract.RawContactsColumns, ContactsContract.ContactsColumns, ContactsContract.ContactNameColumns, ContactsContract.ContactOptionsColumns, ContactsContract.ContactStatusColumns
/*     */ {
    }

    /*     */
/*     */   public static final class Data implements ContactsContract.DataColumnsWithJoins {
        /*     */     Data() {
/* 373 */
            throw new RuntimeException("Stub!");
        }

        /* 374 */
        public static Uri getContactLookupUri(android.content.ContentResolver resolver, Uri dataUri) {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */ 
/* 377 */     public static final Uri CONTENT_URI = null;
        /*     */     public static final String CONTENT_TYPE = "vnd.android.cursor.dir/data";
    }

    /*     */
/*     */   public static final class RawContactsEntity implements BaseColumns, ContactsContract.DataColumns, ContactsContract.RawContactsColumns {
        public static final String DATA_ID = "data_id";
        /*     */     public static final String CONTENT_TYPE = "vnd.android.cursor.dir/raw_contact_entity";

        /* 382 */     RawContactsEntity() {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */ 
/*     */ 
/*     */ 
/* 387 */     public static final Uri PROFILE_CONTENT_URI = null;
        public static final Uri CONTENT_URI = null;
/*     */
    }

    /*     */
/*     */   protected static abstract interface PhoneLookupColumns {
        /*     */     public static final String NUMBER = "number";
        /*     */     public static final String TYPE = "type";
        /*     */     public static final String LABEL = "label";
        /*     */     public static final String NORMALIZED_NUMBER = "normalized_number";
/*     */
    }

    /*     */
/*     */   public static final class PhoneLookup implements BaseColumns, ContactsContract.PhoneLookupColumns, ContactsContract.ContactsColumns, ContactsContract.ContactOptionsColumns {
        /*     */     PhoneLookup() {
/* 399 */
            throw new RuntimeException("Stub!");
        }

        /*     */
/* 401 */     public static final Uri CONTENT_FILTER_URI = null;
/*     */
    }

    /*     */
/*     */   protected static abstract interface PresenceColumns {
        public static final String DATA_ID = "presence_data_id";
        /*     */     public static final String PROTOCOL = "protocol";
        /*     */     public static final String CUSTOM_PROTOCOL = "custom_protocol";
        /*     */     public static final String IM_HANDLE = "im_handle";
        /*     */     public static final String IM_ACCOUNT = "im_account";
/*     */
    }

    /*     */
/*     */   public static class StatusUpdates implements ContactsContract.StatusColumns, ContactsContract.PresenceColumns {
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/status-update";
        /*     */     public static final String CONTENT_TYPE = "vnd.android.cursor.dir/status-update";

        /*     */
/* 414 */     StatusUpdates() {
            throw new RuntimeException("Stub!");
        }

        /* 415 */
        public static final int getPresenceIconResourceId(int status) {
            throw new RuntimeException("Stub!");
        }

        /* 416 */
        public static final int getPresencePrecedence(int status) {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */ 
/*     */ 
/*     */ 
/* 421 */     public static final Uri PROFILE_CONTENT_URI = null;
        public static final Uri CONTENT_URI = null;
/*     */
    }

    /*     */
/*     */
    @Deprecated
/*     */ public static final class Presence
/*     */ extends ContactsContract.StatusUpdates {
        /* 427 */
        public Presence() {
            throw new RuntimeException("Stub!");
        }
    }

    /*     */
/*     */   public static final class CommonDataKinds {
        public static abstract interface BaseTypes {
            public static final int TYPE_CUSTOM = 0;
        }

        /*     */
/*     */     protected static abstract interface CommonColumns extends ContactsContract.CommonDataKinds.BaseTypes {
            public static final String DATA = "data1";
            /*     */       public static final String TYPE = "data2";
            /*     */       public static final String LABEL = "data3";
        }

        /*     */
/*     */     public static final class StructuredName implements ContactsContract.DataColumnsWithJoins {
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/name";
            /*     */       public static final String DISPLAY_NAME = "data1";
            /*     */       public static final String GIVEN_NAME = "data2";
            /*     */       public static final String FAMILY_NAME = "data3";
            /*     */       public static final String PREFIX = "data4";
            /*     */       public static final String MIDDLE_NAME = "data5";
            /*     */       public static final String SUFFIX = "data6";
            /*     */       public static final String PHONETIC_GIVEN_NAME = "data7";
            /*     */       public static final String PHONETIC_MIDDLE_NAME = "data8";
            /*     */       public static final String PHONETIC_FAMILY_NAME = "data9";

            /* 445 */       StructuredName() {
                throw new RuntimeException("Stub!");
            }
/*     */
        }

        /*     */
/*     */     public static final class Nickname
/*     */ implements ContactsContract.DataColumnsWithJoins, ContactsContract.CommonDataKinds.CommonColumns {
            /*     */       public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/nickname";
            /*     */       public static final int TYPE_DEFAULT = 1;
            /*     */       public static final int TYPE_OTHER_NAME = 2;
            /*     */       public static final int TYPE_MAIDEN_NAME = 3;
            /*     */
            @Deprecated
/*     */ public static final int TYPE_MAINDEN_NAME = 3;
            /*     */       public static final int TYPE_SHORT_NAME = 4;
            /*     */       public static final int TYPE_INITIALS = 5;
            /*     */       public static final String NAME = "data1";

            /*     */
/* 460 */       Nickname() {
                throw new RuntimeException("Stub!");
            }
        }

        /*     */
/*     */     public static final class Phone implements ContactsContract.DataColumnsWithJoins, ContactsContract.CommonDataKinds.CommonColumns {
            public static final String NORMALIZED_NUMBER = "data4";
            /*     */       public static final String NUMBER = "data1";
            /*     */       public static final int TYPE_MMS = 20;
            /*     */       public static final int TYPE_ASSISTANT = 19;
            /*     */       public static final int TYPE_WORK_PAGER = 18;
            /*     */       public static final int TYPE_WORK_MOBILE = 17;
            /*     */       public static final int TYPE_TTY_TDD = 16;
            /*     */       public static final int TYPE_TELEX = 15;
            /*     */       public static final int TYPE_RADIO = 14;
            /*     */       public static final int TYPE_OTHER_FAX = 13;
            /*     */       public static final int TYPE_MAIN = 12;
            /*     */       public static final int TYPE_ISDN = 11;

            /* 474 */       Phone() {
                throw new RuntimeException("Stub!");
            }

            /* 475 */
            public static final int getTypeLabelResource(int type) {
                throw new RuntimeException("Stub!");
            }

            /* 476 */
            public static final CharSequence getTypeLabel(android.content.res.Resources res, int type, CharSequence label) {
                throw new RuntimeException("Stub!");
            }

            /*     */
/*     */ 
/*     */ 
/*     */       public static final int TYPE_COMPANY_MAIN = 10;
            /*     */
/*     */ 
/*     */       public static final int TYPE_CAR = 9;
            /*     */
/*     */       public static final int TYPE_CALLBACK = 8;
            /*     */
/*     */       public static final int TYPE_OTHER = 7;
            /*     */
/*     */       public static final int TYPE_PAGER = 6;
            /*     */
/*     */       public static final int TYPE_FAX_HOME = 5;
            /*     */
/*     */       public static final int TYPE_FAX_WORK = 4;
            /*     */
/*     */       public static final int TYPE_WORK = 3;
            /*     */
/*     */       public static final int TYPE_MOBILE = 2;
            /*     */
/*     */       public static final int TYPE_HOME = 1;
            /*     */
/*     */       public static final String SEARCH_PHONE_NUMBER_KEY = "search_phone_number";
            /*     */
/*     */       public static final String SEARCH_DISPLAY_NAME_KEY = "search_display_name";
            /*     */
/* 505 */       public static final Uri CONTENT_FILTER_URI = null;
            public static final Uri CONTENT_URI = null;
            /*     */       public static final String CONTENT_TYPE = "vnd.android.cursor.dir/phone_v2";
            /*     */       public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/phone_v2";
        }

        /*     */
/*     */     public static final class Email implements ContactsContract.DataColumnsWithJoins, ContactsContract.CommonDataKinds.CommonColumns {
            public static final String DISPLAY_NAME = "data4";
            public static final int TYPE_MOBILE = 4;
            public static final int TYPE_OTHER = 3;

            /* 510 */       Email() {
                throw new RuntimeException("Stub!");
            }

            /* 511 */
            public static final int getTypeLabelResource(int type) {
                throw new RuntimeException("Stub!");
            }

            /* 512 */
            public static final CharSequence getTypeLabel(android.content.res.Resources res, int type, CharSequence label) {
                throw new RuntimeException("Stub!");
            }

            /*     */
/*     */ 
/*     */ 
/*     */       public static final int TYPE_WORK = 2;
            /*     */
/*     */ 
/*     */       public static final int TYPE_HOME = 1;
            /*     */
/*     */ 
/*     */       public static final String ADDRESS = "data1";
            /*     */
/* 524 */       public static final Uri CONTENT_FILTER_URI = null;
            public static final Uri CONTENT_LOOKUP_URI = null;
            public static final Uri CONTENT_URI = null;
            /*     */       public static final String CONTENT_TYPE = "vnd.android.cursor.dir/email_v2";
            /*     */       public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/email_v2";
        }

        /*     */
/*     */     public static final class StructuredPostal implements ContactsContract.DataColumnsWithJoins, ContactsContract.CommonDataKinds.CommonColumns {
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/postal-address_v2";
            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/postal-address_v2";

            /* 529 */       StructuredPostal() {
                throw new RuntimeException("Stub!");
            }

            /* 530 */
            public static final int getTypeLabelResource(int type) {
                throw new RuntimeException("Stub!");
            }

            /* 531 */
            public static final CharSequence getTypeLabel(android.content.res.Resources res, int type, CharSequence label) {
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
/* 546 */       public static final Uri CONTENT_URI = null;
            /*     */       public static final int TYPE_HOME = 1;
            /*     */       public static final int TYPE_WORK = 2;
            /*     */       public static final int TYPE_OTHER = 3;
            /*     */       public static final String FORMATTED_ADDRESS = "data1";
            public static final String STREET = "data4";
            public static final String POBOX = "data5";
            public static final String NEIGHBORHOOD = "data6";
            public static final String CITY = "data7";
            public static final String REGION = "data8";
            public static final String POSTCODE = "data9";
            public static final String COUNTRY = "data10";
        }

        /* 551 */     public static final class Im implements ContactsContract.DataColumnsWithJoins, ContactsContract.CommonDataKinds.CommonColumns {
            Im() {
                throw new RuntimeException("Stub!");
            }

            /* 552 */       public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/im";
            public static final int TYPE_HOME = 1;
            public static final int TYPE_WORK = 2;
            public static final int TYPE_OTHER = 3;

            public static final int getTypeLabelResource(int type) {
                throw new RuntimeException("Stub!");
            }

            /* 553 */       public static final String PROTOCOL = "data5";
            public static final String CUSTOM_PROTOCOL = "data6";

            public static final CharSequence getTypeLabel(android.content.res.Resources res, int type, CharSequence label) {
                throw new RuntimeException("Stub!");
            }

            /* 554 */       public static final int PROTOCOL_CUSTOM = -1;

            public static final int getProtocolLabelResource(int type) {
                throw new RuntimeException("Stub!");
            }

            /* 555 */       public static final int PROTOCOL_AIM = 0;

            public static final CharSequence getProtocolLabel(android.content.res.Resources res, int type, CharSequence label) {
                throw new RuntimeException("Stub!");
            }

            /*     */
/*     */       public static final int PROTOCOL_MSN = 1;
            /*     */       public static final int PROTOCOL_YAHOO = 2;
            /*     */       public static final int PROTOCOL_SKYPE = 3;
            /*     */       public static final int PROTOCOL_QQ = 4;
            /*     */       public static final int PROTOCOL_GOOGLE_TALK = 5;
            /*     */       public static final int PROTOCOL_ICQ = 6;
            /*     */       public static final int PROTOCOL_JABBER = 7;
            /*     */       public static final int PROTOCOL_NETMEETING = 8;
        }

        /*     */
/*     */     public static final class Organization implements ContactsContract.DataColumnsWithJoins, ContactsContract.CommonDataKinds.CommonColumns {
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/organization";
            /*     */       public static final int TYPE_WORK = 1;
            /*     */       public static final int TYPE_OTHER = 2;
            /*     */       public static final String COMPANY = "data1";
            /*     */       public static final String TITLE = "data4";
            /*     */       public static final String DEPARTMENT = "data5";
            /*     */       public static final String JOB_DESCRIPTION = "data6";
            /*     */       public static final String SYMBOL = "data7";
            /*     */       public static final String PHONETIC_NAME = "data8";
            /*     */       public static final String OFFICE_LOCATION = "data9";

            /* 576 */       Organization() {
                throw new RuntimeException("Stub!");
            }

            /* 577 */
            public static final int getTypeLabelResource(int type) {
                throw new RuntimeException("Stub!");
            }

            /* 578 */
            public static final CharSequence getTypeLabel(android.content.res.Resources res, int type, CharSequence label) {
                throw new RuntimeException("Stub!");
            }
        }

        /*     */
/*     */     public static final class Relation implements ContactsContract.DataColumnsWithJoins, ContactsContract.CommonDataKinds.CommonColumns {
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/relation";
            /*     */       public static final int TYPE_ASSISTANT = 1;
            /*     */       public static final int TYPE_BROTHER = 2;
            /*     */       public static final int TYPE_CHILD = 3;
            /*     */       public static final int TYPE_DOMESTIC_PARTNER = 4;
            /*     */       public static final int TYPE_FATHER = 5;
            /*     */       public static final int TYPE_FRIEND = 6;
            /*     */       public static final int TYPE_MANAGER = 7;
            /*     */       public static final int TYPE_MOTHER = 8;
            /*     */       public static final int TYPE_PARENT = 9;
            /*     */       public static final int TYPE_PARTNER = 10;
            /*     */       public static final int TYPE_REFERRED_BY = 11;
            /*     */       public static final int TYPE_RELATIVE = 12;
            public static final int TYPE_SISTER = 13;
            public static final int TYPE_SPOUSE = 14;
            public static final String NAME = "data1";

            /* 593 */       Relation() {
                throw new RuntimeException("Stub!");
            }

            /* 594 */
            public static final int getTypeLabelResource(int type) {
                throw new RuntimeException("Stub!");
            }

            /* 595 */
            public static final CharSequence getTypeLabel(android.content.res.Resources res, int type, CharSequence label) {
                throw new RuntimeException("Stub!");
            }
/*     */
        }

        /*     */
/*     */ 
/*     */ 
/*     */ 
/*     */     public static final class Event
/*     */ implements ContactsContract.DataColumnsWithJoins, ContactsContract.CommonDataKinds.CommonColumns
/*     */ {
            /*     */       public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/contact_event";
            /*     */
/*     */ 
/*     */       public static final int TYPE_ANNIVERSARY = 1;
            /*     */
/*     */       public static final int TYPE_OTHER = 2;
            /*     */
/*     */       public static final int TYPE_BIRTHDAY = 3;
            /*     */
/*     */       public static final String START_DATE = "data1";

            /*     */
/*     */ 
/* 616 */       Event() {
                throw new RuntimeException("Stub!");
            }

            /* 617 */
            public static int getTypeResource(Integer type) {
                throw new RuntimeException("Stub!");
            }
/*     */
        }

        /*     */
/*     */     public static final class Photo implements ContactsContract.DataColumnsWithJoins
/*     */ {
            /*     */       public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/photo";
            /*     */       public static final String PHOTO_FILE_ID = "data14";
            /*     */       public static final String PHOTO = "data15";

            /*     */
/*     */       Photo() {
/* 627 */
                throw new RuntimeException("Stub!");
/*     */
            }
/*     */
        }

        /*     */
/*     */     public static final class Note implements ContactsContract.DataColumnsWithJoins {
            /*     */       public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/note";
            /*     */       public static final String NOTE = "data1";

            /*     */
/* 635 */       Note() {
                throw new RuntimeException("Stub!");
            }
/*     */
        }

        /*     */
/*     */     public static final class GroupMembership implements ContactsContract.DataColumnsWithJoins {
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/group_membership";
            /*     */       public static final String GROUP_ROW_ID = "data1";
            /*     */       public static final String GROUP_SOURCE_ID = "group_sourceid";

            /*     */
/* 642 */       GroupMembership() {
                throw new RuntimeException("Stub!");
            }
        }

        /*     */
/*     */     public static final class Website implements ContactsContract.DataColumnsWithJoins, ContactsContract.CommonDataKinds.CommonColumns {
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/website";
            /*     */       public static final int TYPE_HOMEPAGE = 1;
            /*     */       public static final int TYPE_BLOG = 2;
            /*     */       public static final int TYPE_PROFILE = 3;
            /*     */       public static final int TYPE_HOME = 4;
            /*     */       public static final int TYPE_WORK = 5;
            public static final int TYPE_FTP = 6;
            public static final int TYPE_OTHER = 7;
            public static final String URL = "data1";

            /* 650 */       Website() {
                throw new RuntimeException("Stub!");
            }
/*     */
        }

        /*     */
/*     */ 
/*     */     public static final class SipAddress
/*     */ implements ContactsContract.DataColumnsWithJoins, ContactsContract.CommonDataKinds.CommonColumns
/*     */ {
            /*     */       public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/sip_address";
            /*     */
/*     */       public static final int TYPE_HOME = 1;
            /*     */       public static final int TYPE_WORK = 2;
            /*     */       public static final int TYPE_OTHER = 3;
            /*     */       public static final String SIP_ADDRESS = "data1";

            /*     */
/* 664 */       SipAddress() {
                throw new RuntimeException("Stub!");
            }

            /* 665 */
            public static final int getTypeLabelResource(int type) {
                throw new RuntimeException("Stub!");
            }

            /* 666 */
            public static final CharSequence getTypeLabel(android.content.res.Resources res, int type, CharSequence label) {
                throw new RuntimeException("Stub!");
            }
/*     */
        }

        /*     */
/*     */     public static final class Identity implements ContactsContract.DataColumnsWithJoins
/*     */ {
            /*     */       public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/identity";
            /*     */       public static final String IDENTITY = "data1";
            /*     */       public static final String NAMESPACE = "data2";

            /*     */
/*     */       Identity() {
/* 676 */
                throw new RuntimeException("Stub!");
/*     */
            }
/*     */
        }

        /*     */
/*     */ 
/* 681 */     CommonDataKinds() {
            throw new RuntimeException("Stub!");
        }
/*     */
    }

    /*     */
/*     */   protected static abstract interface GroupsColumns {
        public static final String DATA_SET = "data_set";
        /*     */     public static final String TITLE = "title";
        /*     */     public static final String NOTES = "notes";
        /*     */     public static final String SYSTEM_ID = "system_id";
        /*     */     public static final String SUMMARY_COUNT = "summ_count";
        /*     */     public static final String SUMMARY_WITH_PHONES = "summ_phones";
        /*     */     public static final String GROUP_VISIBLE = "group_visible";
        /*     */     public static final String DELETED = "deleted";
        /*     */     public static final String SHOULD_SYNC = "should_sync";
        /*     */     public static final String AUTO_ADD = "auto_add";
        /*     */     public static final String FAVORITES = "favorites";
        /*     */     public static final String GROUP_IS_READ_ONLY = "group_is_read_only";
/*     */
    }

    /*     */
/*     */   public static final class Groups implements BaseColumns, ContactsContract.GroupsColumns, ContactsContract.SyncColumns {
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/group";
        /*     */     public static final String CONTENT_TYPE = "vnd.android.cursor.dir/group";

        /*     */
/* 701 */     Groups() {
            throw new RuntimeException("Stub!");
        }

        /* 702 */
        public static android.content.EntityIterator newEntityIterator(android.database.Cursor cursor) {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */ 
/*     */ 
/*     */ 
/* 707 */     public static final Uri CONTENT_SUMMARY_URI = null;
        public static final Uri CONTENT_URI = null;
/*     */
    }

    /*     */
/*     */   public static final class AggregationExceptions implements BaseColumns {
        /*     */     AggregationExceptions() {
/* 712 */
            throw new RuntimeException("Stub!");
/*     */
        }

        /*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 722 */     public static final Uri CONTENT_URI = null;
        /*     */     public static final String CONTENT_TYPE = "vnd.android.cursor.dir/aggregation_exception";
        /*     */     public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/aggregation_exception";
        /*     */     public static final String TYPE = "type";
        /*     */     public static final int TYPE_AUTOMATIC = 0;
        /*     */     public static final int TYPE_KEEP_TOGETHER = 1;
        /*     */     public static final int TYPE_KEEP_SEPARATE = 2;
        /*     */     public static final String RAW_CONTACT_ID1 = "raw_contact_id1";
        /*     */     public static final String RAW_CONTACT_ID2 = "raw_contact_id2";
    }

    /*     */
/*     */   protected static abstract interface SettingsColumns {
        public static final String ACCOUNT_NAME = "account_name";
        /*     */     public static final String ACCOUNT_TYPE = "account_type";
        /*     */     public static final String DATA_SET = "data_set";
        /*     */     public static final String SHOULD_SYNC = "should_sync";
        /*     */     public static final String UNGROUPED_VISIBLE = "ungrouped_visible";
        /*     */     public static final String ANY_UNSYNCED = "any_unsynced";
        public static final String UNGROUPED_COUNT = "summ_count";
        public static final String UNGROUPED_WITH_PHONES = "summ_phones";
    }

    /* 738 */   public static final class Settings implements ContactsContract.SettingsColumns {
        Settings() {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */ 
/*     */ 
/* 742 */     public static final Uri CONTENT_URI = null;
        /*     */     public static final String CONTENT_TYPE = "vnd.android.cursor.dir/setting";
        /*     */     public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/setting";
    }

    /*     */   public static final class DataUsageFeedback {
        public static final String USAGE_TYPE_SHORT_TEXT = "short_text";
        public static final String USAGE_TYPE_LONG_TEXT = "long_text";

        /* 746 */
        public DataUsageFeedback() {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */ 
/*     */     public static final String USAGE_TYPE_CALL = "call";
        /*     */
/*     */     public static final String USAGE_TYPE = "type";
        /*     */
/* 753 */     public static final Uri DELETE_USAGE_URI = null;
        public static final Uri FEEDBACK_URI = null;
    }

    /*     */
/*     */   public static final class QuickContact {
        public static final int MODE_SMALL = 1;
        /*     */     public static final int MODE_MEDIUM = 2;
        public static final int MODE_LARGE = 3;

        /* 757 */
        public QuickContact() {
            throw new RuntimeException("Stub!");
        }

        /* 758 */
        public static void showQuickContact(android.content.Context context, android.view.View target, Uri lookupUri, int mode, String[] excludeMimes) {
            throw new RuntimeException("Stub!");
        }

        /* 759 */
        public static void showQuickContact(android.content.Context context, android.graphics.Rect target, Uri lookupUri, int mode, String[] excludeMimes) {
            throw new RuntimeException("Stub!");
        }
/*     */
    }

    /*     */
/*     */   public static final class DisplayPhoto {
        /*     */     public static final String THUMBNAIL_MAX_DIM = "thumbnail_max_dim";
        /*     */     public static final String DISPLAY_MAX_DIM = "display_max_dim";

        /*     */
/* 766 */     DisplayPhoto() {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */ 
/*     */ 
/*     */ 
/* 771 */     public static final Uri CONTENT_MAX_DIMENSIONS_URI = null;
        public static final Uri CONTENT_URI = null;
    }

    /*     */
/*     */   public static final class Intents {
        public static final String SEARCH_SUGGESTION_CLICKED = "android.provider.Contacts.SEARCH_SUGGESTION_CLICKED";
        /*     */     public static final String SEARCH_SUGGESTION_DIAL_NUMBER_CLICKED = "android.provider.Contacts.SEARCH_SUGGESTION_DIAL_NUMBER_CLICKED";
        /*     */     public static final String SEARCH_SUGGESTION_CREATE_CONTACT_CLICKED = "android.provider.Contacts.SEARCH_SUGGESTION_CREATE_CONTACT_CLICKED";
        /*     */     public static final String ATTACH_IMAGE = "com.android.contacts.action.ATTACH_IMAGE";

        /* 777 */     public static final class Insert {
            public Insert() {
                throw new RuntimeException("Stub!");
            }

            /*     */
/*     */       public static final String ACTION = "android.intent.action.INSERT";
            /*     */       public static final String FULL_MODE = "full_mode";
            /*     */       public static final String NAME = "name";
            /*     */       public static final String PHONETIC_NAME = "phonetic_name";
            /*     */       public static final String COMPANY = "company";
            /*     */       public static final String JOB_TITLE = "job_title";
            /*     */       public static final String NOTES = "notes";
            /*     */       public static final String PHONE = "phone";
            /*     */       public static final String PHONE_TYPE = "phone_type";
            /*     */       public static final String PHONE_ISPRIMARY = "phone_isprimary";
            /*     */       public static final String SECONDARY_PHONE = "secondary_phone";
            /*     */       public static final String SECONDARY_PHONE_TYPE = "secondary_phone_type";
            /*     */       public static final String TERTIARY_PHONE = "tertiary_phone";
            /*     */       public static final String TERTIARY_PHONE_TYPE = "tertiary_phone_type";
            /*     */       public static final String EMAIL = "email";
            /*     */       public static final String EMAIL_TYPE = "email_type";
            /*     */       public static final String EMAIL_ISPRIMARY = "email_isprimary";
            /*     */       public static final String SECONDARY_EMAIL = "secondary_email";
            /*     */       public static final String SECONDARY_EMAIL_TYPE = "secondary_email_type";
            /*     */       public static final String TERTIARY_EMAIL = "tertiary_email";
            /*     */       public static final String TERTIARY_EMAIL_TYPE = "tertiary_email_type";
            /*     */       public static final String POSTAL = "postal";
            /*     */       public static final String POSTAL_TYPE = "postal_type";
            /*     */       public static final String POSTAL_ISPRIMARY = "postal_isprimary";
            /*     */       public static final String IM_HANDLE = "im_handle";
            /*     */       public static final String IM_PROTOCOL = "im_protocol";
            /*     */       public static final String IM_ISPRIMARY = "im_isprimary";
            /*     */       public static final String DATA = "data";
        }

        /* 807 */
        public Intents() {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */     public static final String INVITE_CONTACT = "com.android.contacts.action.INVITE_CONTACT";
        /*     */     public static final String SHOW_OR_CREATE_CONTACT = "com.android.contacts.action.SHOW_OR_CREATE_CONTACT";
        /*     */     public static final String EXTRA_FORCE_CREATE = "com.android.contacts.action.FORCE_CREATE";
        /*     */     public static final String EXTRA_CREATE_DESCRIPTION = "com.android.contacts.action.CREATE_DESCRIPTION";
/*     */
    }

    /*     */
/*     */
    public ContactsContract()
/*     */ {
/* 817 */
        throw new RuntimeException("Stub!");
    }

    /* 818 */
    public static boolean isProfileId(long id) {
        throw new RuntimeException("Stub!");
    }

    /*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 826 */   public static final Uri AUTHORITY_URI = null;
    /*     */   public static final String CALLER_IS_SYNCADAPTER = "caller_is_syncadapter";
    /*     */   public static final String DIRECTORY_PARAM_KEY = "directory";
    /*     */   public static final String LIMIT_PARAM_KEY = "limit";
    /*     */   public static final String PRIMARY_ACCOUNT_NAME = "name_for_primary_account";
    /*     */   public static final String PRIMARY_ACCOUNT_TYPE = "type_for_primary_account";
/*     */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/provider/ContactsContract.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */