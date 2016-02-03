/*     */
package android.provider;
/*     */ 
/*     */

import android.net.Uri;

/*     */
/*     */ public final class MediaStore {
    public static final String AUTHORITY = "media";
    /*     */
    @Deprecated
/*     */ public static final String INTENT_ACTION_MUSIC_PLAYER = "android.intent.action.MUSIC_PLAYER";
    /*     */   public static final String INTENT_ACTION_MEDIA_SEARCH = "android.intent.action.MEDIA_SEARCH";
    /*     */   public static final String INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH = "android.media.action.MEDIA_PLAY_FROM_SEARCH";
    /*     */   public static final String EXTRA_MEDIA_ARTIST = "android.intent.extra.artist";
    /*     */   public static final String EXTRA_MEDIA_ALBUM = "android.intent.extra.album";
    /*     */   public static final String EXTRA_MEDIA_TITLE = "android.intent.extra.title";
    /*     */   public static final String EXTRA_MEDIA_FOCUS = "android.intent.extra.focus";
    /*     */   public static final String EXTRA_SCREEN_ORIENTATION = "android.intent.extra.screenOrientation";
    /*     */   public static final String EXTRA_FULL_SCREEN = "android.intent.extra.fullScreen";
    /*     */   public static final String EXTRA_SHOW_ACTION_ICONS = "android.intent.extra.showActionIcons";

    /*     */
/*     */   public static abstract interface MediaColumns extends BaseColumns {
        public static final String DATA = "_data";
        /*     */     public static final String SIZE = "_size";
        /*     */     public static final String DISPLAY_NAME = "_display_name";
        /*     */     public static final String TITLE = "title";
        /*     */     public static final String DATE_ADDED = "date_added";
        /*     */     public static final String DATE_MODIFIED = "date_modified";
        /*     */     public static final String MIME_TYPE = "mime_type";
        /*     */     public static final String WIDTH = "width";
        /*     */     public static final String HEIGHT = "height";
    }

    /*     */
/*     */   public static final class Files {
        public static abstract interface FileColumns extends MediaStore.MediaColumns {
            public static final String PARENT = "parent";
            /*     */       public static final String MIME_TYPE = "mime_type";
            /*     */       public static final String TITLE = "title";
            /*     */       public static final String MEDIA_TYPE = "media_type";
            public static final int MEDIA_TYPE_NONE = 0;
            public static final int MEDIA_TYPE_IMAGE = 1;
            public static final int MEDIA_TYPE_AUDIO = 2;
            public static final int MEDIA_TYPE_VIDEO = 3;
            public static final int MEDIA_TYPE_PLAYLIST = 4;
        }

        /*  32 */
        public Files() {
            throw new RuntimeException("Stub!");
        }

        /*  33 */
        public static Uri getContentUri(String volumeName) {
            throw new RuntimeException("Stub!");
        }

        /*  34 */
        public static final Uri getContentUri(String volumeName, long rowId) {
            throw new RuntimeException("Stub!");
        }
/*     */     
/*     */     
/*     */
    }

    /*     */
/*     */   public static final class Images {
        /*     */     public static abstract interface ImageColumns extends MediaStore.MediaColumns {
            /*     */       public static final String DESCRIPTION = "description";
            /*     */       public static final String PICASA_ID = "picasa_id";
            /*     */       public static final String IS_PRIVATE = "isprivate";
            /*     */       public static final String LATITUDE = "latitude";
            /*     */       public static final String LONGITUDE = "longitude";
            /*     */       public static final String DATE_TAKEN = "datetaken";
            /*     */       public static final String ORIENTATION = "orientation";
            /*     */       public static final String MINI_THUMB_MAGIC = "mini_thumb_magic";
            /*     */       public static final String BUCKET_ID = "bucket_id";
            /*     */       public static final String BUCKET_DISPLAY_NAME = "bucket_display_name";
/*     */
        }

        /*     */
/*     */     public static final class Media implements MediaStore.Images.ImageColumns {
            /*     */
            public Media() {
/*  55 */
                throw new RuntimeException("Stub!");
            }

            /*  56 */
            public static final android.database.Cursor query(android.content.ContentResolver cr, Uri uri, String[] projection) {
                throw new RuntimeException("Stub!");
            }

            /*  57 */
            public static final android.database.Cursor query(android.content.ContentResolver cr, Uri uri, String[] projection, String where, String orderBy) {
                throw new RuntimeException("Stub!");
            }

            /*  58 */
            public static final android.database.Cursor query(android.content.ContentResolver cr, Uri uri, String[] projection, String selection, String[] selectionArgs, String orderBy) {
                throw new RuntimeException("Stub!");
            }

            /*  59 */
            public static final android.graphics.Bitmap getBitmap(android.content.ContentResolver cr, Uri url) throws java.io.FileNotFoundException, java.io.IOException {
                throw new RuntimeException("Stub!");
            }

            /*  60 */
            public static final String insertImage(android.content.ContentResolver cr, String imagePath, String name, String description) throws java.io.FileNotFoundException {
                throw new RuntimeException("Stub!");
            }

            /*  61 */
            public static final String insertImage(android.content.ContentResolver cr, android.graphics.Bitmap source, String title, String description) {
                throw new RuntimeException("Stub!");
            }

            /*  62 */
            public static Uri getContentUri(String volumeName) {
                throw new RuntimeException("Stub!");
            }

            /*     */
/*     */ 
/*     */       public static final String DEFAULT_SORT_ORDER = "bucket_display_name";
            /*     */       public static final String CONTENT_TYPE = "vnd.android.cursor.dir/image";
            /*  67 */       public static final Uri EXTERNAL_CONTENT_URI = null;
            public static final Uri INTERNAL_CONTENT_URI = null;
        }

        /*     */
/*     */     public static class Thumbnails implements BaseColumns {
            public static final String HEIGHT = "height";
            /*     */       public static final String WIDTH = "width";

            /*     */
/*  72 */
            public Thumbnails() {
                throw new RuntimeException("Stub!");
            }

            /*  73 */
            public static final android.database.Cursor query(android.content.ContentResolver cr, Uri uri, String[] projection) {
                throw new RuntimeException("Stub!");
            }

            /*  74 */
            public static final android.database.Cursor queryMiniThumbnails(android.content.ContentResolver cr, Uri uri, int kind, String[] projection) {
                throw new RuntimeException("Stub!");
            }

            /*  75 */
            public static final android.database.Cursor queryMiniThumbnail(android.content.ContentResolver cr, long origId, int kind, String[] projection) {
                throw new RuntimeException("Stub!");
            }

            /*  76 */
            public static void cancelThumbnailRequest(android.content.ContentResolver cr, long origId) {
                throw new RuntimeException("Stub!");
            }

            /*  77 */
            public static android.graphics.Bitmap getThumbnail(android.content.ContentResolver cr, long origId, int kind, android.graphics.BitmapFactory.Options options) {
                throw new RuntimeException("Stub!");
            }

            /*  78 */
            public static void cancelThumbnailRequest(android.content.ContentResolver cr, long origId, long groupId) {
                throw new RuntimeException("Stub!");
            }

            /*  79 */
            public static android.graphics.Bitmap getThumbnail(android.content.ContentResolver cr, long origId, long groupId, int kind, android.graphics.BitmapFactory.Options options) {
                throw new RuntimeException("Stub!");
            }

            /*  80 */
            public static Uri getContentUri(String volumeName) {
                throw new RuntimeException("Stub!");
            }

            /*     */
/*     */ 
/*     */       public static final String THUMB_DATA = "thumb_data";
            /*     */
/*     */       public static final int MICRO_KIND = 3;
            /*     */
/*     */       public static final int FULL_SCREEN_KIND = 2;
            /*     */       public static final int MINI_KIND = 1;
            /*     */       public static final String KIND = "kind";
            /*     */       public static final String IMAGE_ID = "image_id";
            /*     */       public static final String DATA = "_data";
            /*     */       public static final String DEFAULT_SORT_ORDER = "image_id ASC";
            /*  93 */       public static final Uri EXTERNAL_CONTENT_URI = null;
            public static final Uri INTERNAL_CONTENT_URI = null;
        }

        /*     */
/*  95 */
        public Images() {
            throw new RuntimeException("Stub!");
        }
/*     */
    }

    /*     */
/*     */   public static final String EXTRA_FINISH_ON_COMPLETION = "android.intent.extra.finishOnCompletion";
    /*     */   public static final String INTENT_ACTION_STILL_IMAGE_CAMERA = "android.media.action.STILL_IMAGE_CAMERA";
    /*     */   public static final String INTENT_ACTION_VIDEO_CAMERA = "android.media.action.VIDEO_CAMERA";
    /*     */   public static final String ACTION_IMAGE_CAPTURE = "android.media.action.IMAGE_CAPTURE";
    /*     */   public static final String ACTION_VIDEO_CAPTURE = "android.media.action.VIDEO_CAPTURE";
    /*     */   public static final String EXTRA_VIDEO_QUALITY = "android.intent.extra.videoQuality";

    /*     */
/*     */   public static final class Audio {
        public static abstract interface AudioColumns extends MediaStore.MediaColumns {
            public static final String TITLE_KEY = "title_key";
            /*     */       public static final String DURATION = "duration";
            /*     */       public static final String BOOKMARK = "bookmark";
            /*     */       public static final String ARTIST_ID = "artist_id";
            /*     */       public static final String ARTIST = "artist";
            /*     */       public static final String ARTIST_KEY = "artist_key";
            /*     */       public static final String COMPOSER = "composer";
            /*     */       public static final String ALBUM_ID = "album_id";
            /*     */       public static final String ALBUM = "album";
            /*     */       public static final String ALBUM_KEY = "album_key";
            /*     */       public static final String TRACK = "track";
            /*     */       public static final String YEAR = "year";
            /*     */       public static final String IS_MUSIC = "is_music";
            /*     */       public static final String IS_PODCAST = "is_podcast";
            /*     */       public static final String IS_RINGTONE = "is_ringtone";
            /*     */       public static final String IS_ALARM = "is_alarm";
            /*     */       public static final String IS_NOTIFICATION = "is_notification";
        }

        /*     */
/* 123 */     public static final class Media implements MediaStore.Audio.AudioColumns {
            public Media() {
                throw new RuntimeException("Stub!");
            }

            /* 124 */
            public static Uri getContentUri(String volumeName) {
                throw new RuntimeException("Stub!");
            }

            /* 125 */
            public static Uri getContentUriForPath(String path) {
                throw new RuntimeException("Stub!");
            }

            /*     */
/*     */ 
/*     */       public static final String EXTRA_MAX_BYTES = "android.provider.MediaStore.extra.MAX_BYTES";
            /*     */       public static final String RECORD_SOUND_ACTION = "android.provider.MediaStore.RECORD_SOUND";
            /*     */       public static final String DEFAULT_SORT_ORDER = "title_key";
            /*     */       public static final String CONTENT_TYPE = "vnd.android.cursor.dir/audio";
            /* 132 */       public static final Uri EXTERNAL_CONTENT_URI = null;
            public static final Uri INTERNAL_CONTENT_URI = null;
/*     */
        }

        /*     */
/*     */     public static abstract interface GenresColumns {
            public static final String NAME = "name";
        }

        /*     */
/*     */     public static final class Genres implements BaseColumns, MediaStore.Audio.GenresColumns {
            public static final String DEFAULT_SORT_ORDER = "name";
            /*     */       public static final String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/genre";
            /*     */       public static final String CONTENT_TYPE = "vnd.android.cursor.dir/genre";

            /*     */
/*     */       public static final class Members implements MediaStore.Audio.AudioColumns {
                public static final String CONTENT_DIRECTORY = "members";
                /*     */         public static final String DEFAULT_SORT_ORDER = "title_key";

                /*     */
/* 144 */
                public Members() {
                    throw new RuntimeException("Stub!");
                }

                /* 145 */
                public static final Uri getContentUri(String volumeName, long genreId) {
                    throw new RuntimeException("Stub!");
                }

                /*     */
/*     */         public static final String AUDIO_ID = "audio_id";
                /*     */         public static final String GENRE_ID = "genre_id";
/*     */
            }

            /*     */
/* 151 */
            public Genres() {
                throw new RuntimeException("Stub!");
            }

            /* 152 */
            public static Uri getContentUri(String volumeName) {
                throw new RuntimeException("Stub!");
            }

            /* 153 */
            public static Uri getContentUriForAudioId(String volumeName, int audioId) {
                throw new RuntimeException("Stub!");
            }

            /*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 159 */       public static final Uri EXTERNAL_CONTENT_URI = null;
            public static final Uri INTERNAL_CONTENT_URI = null;
        }

        /*     */
/*     */     public static abstract interface PlaylistsColumns {
            public static final String NAME = "name";
            /*     */       public static final String DATA = "_data";
            /*     */       public static final String DATE_ADDED = "date_added";
            /*     */       public static final String DATE_MODIFIED = "date_modified";
        }

        /*     */
/*     */     public static final class Playlists implements BaseColumns, MediaStore.Audio.PlaylistsColumns {
            public static final String DEFAULT_SORT_ORDER = "name";
            /*     */       public static final String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/playlist";
            /*     */       public static final String CONTENT_TYPE = "vnd.android.cursor.dir/playlist";

            /*     */
/*     */       public static final class Members implements MediaStore.Audio.AudioColumns {
                public static final String _ID = "_id";
                /*     */         public static final String CONTENT_DIRECTORY = "members";
                /*     */         public static final String AUDIO_ID = "audio_id";

                /*     */
/* 174 */
                public Members() {
                    throw new RuntimeException("Stub!");
                }

                /* 175 */
                public static final Uri getContentUri(String volumeName, long playlistId) {
                    throw new RuntimeException("Stub!");
                }

                /* 176 */
                public static final boolean moveItem(android.content.ContentResolver res, long playlistId, int from, int to) {
                    throw new RuntimeException("Stub!");
                }

                /*     */
/*     */         public static final String PLAYLIST_ID = "playlist_id";
                /*     */         public static final String PLAY_ORDER = "play_order";
                /*     */         public static final String DEFAULT_SORT_ORDER = "play_order";
/*     */
            }

            /*     */
/*     */
            public Playlists() {
/* 184 */
                throw new RuntimeException("Stub!");
            }

            /* 185 */
            public static Uri getContentUri(String volumeName) {
                throw new RuntimeException("Stub!");
            }

            /*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 191 */       public static final Uri EXTERNAL_CONTENT_URI = null;
            public static final Uri INTERNAL_CONTENT_URI = null;
/*     */
        }

        /*     */
/*     */     public static abstract interface ArtistColumns {
            /*     */       public static final String ARTIST = "artist";
            /*     */       public static final String ARTIST_KEY = "artist_key";
            /*     */       public static final String NUMBER_OF_ALBUMS = "number_of_albums";
            /*     */       public static final String NUMBER_OF_TRACKS = "number_of_tracks";
/*     */
        }

        /*     */
/*     */     public static final class Artists implements BaseColumns, MediaStore.Audio.ArtistColumns {
            /*     */       public static final String DEFAULT_SORT_ORDER = "artist_key";
            /*     */       public static final String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/artist";
            /*     */       public static final String CONTENT_TYPE = "vnd.android.cursor.dir/artists";

            /*     */
/* 206 */       public static final class Albums implements MediaStore.Audio.AlbumColumns {
                public Albums() {
                    throw new RuntimeException("Stub!");
                }

                /* 207 */
                public static final Uri getContentUri(String volumeName, long artistId) {
                    throw new RuntimeException("Stub!");
                }
            }

            /*     */
/* 209 */
            public Artists() {
                throw new RuntimeException("Stub!");
            }

            /* 210 */
            public static Uri getContentUri(String volumeName) {
                throw new RuntimeException("Stub!");
            }

            /*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 216 */       public static final Uri EXTERNAL_CONTENT_URI = null;
            public static final Uri INTERNAL_CONTENT_URI = null;
/*     */
        }

        /*     */
/*     */     public static abstract interface AlbumColumns {
            public static final String ALBUM_ID = "album_id";
            /*     */       public static final String ALBUM = "album";
            /*     */       public static final String ARTIST = "artist";
            /*     */       public static final String NUMBER_OF_SONGS = "numsongs";
            /*     */       public static final String NUMBER_OF_SONGS_FOR_ARTIST = "numsongs_by_artist";
            /*     */       public static final String FIRST_YEAR = "minyear";
            /*     */       public static final String LAST_YEAR = "maxyear";
            /*     */       public static final String ALBUM_KEY = "album_key";
            /*     */       public static final String ALBUM_ART = "album_art";
        }

        /*     */
/*     */     public static final class Albums implements BaseColumns, MediaStore.Audio.AlbumColumns {
            public static final String DEFAULT_SORT_ORDER = "album_key";
            /*     */       public static final String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/album";
            /*     */       public static final String CONTENT_TYPE = "vnd.android.cursor.dir/albums";

            /*     */
/* 233 */
            public Albums() {
                throw new RuntimeException("Stub!");
            }

            /* 234 */
            public static Uri getContentUri(String volumeName) {
                throw new RuntimeException("Stub!");
            }

            /*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 240 */       public static final Uri EXTERNAL_CONTENT_URI = null;
            public static final Uri INTERNAL_CONTENT_URI = null;
        }

        /*     */
/* 242 */
        public Audio() {
            throw new RuntimeException("Stub!");
        }

        /* 243 */
        public static String keyFor(String name) {
            throw new RuntimeException("Stub!");
        }
    }

    /*     */
/*     */   public static final String EXTRA_SIZE_LIMIT = "android.intent.extra.sizeLimit";
    /*     */   public static final String EXTRA_DURATION_LIMIT = "android.intent.extra.durationLimit";
    /*     */   public static final String EXTRA_OUTPUT = "output";
    /*     */   public static final String UNKNOWN_STRING = "<unknown>";
    /*     */   public static final String MEDIA_SCANNER_VOLUME = "volume";
    /*     */   public static final String MEDIA_IGNORE_FILENAME = ".nomedia";

    /*     */   public static final class Video {
        public static final String DEFAULT_SORT_ORDER = "_display_name";

        /*     */
/*     */     public static abstract interface VideoColumns extends MediaStore.MediaColumns {
            public static final String DURATION = "duration";
            /*     */       public static final String ARTIST = "artist";
            /*     */       public static final String ALBUM = "album";
            /*     */       public static final String RESOLUTION = "resolution";
            /*     */       public static final String DESCRIPTION = "description";
            /*     */       public static final String IS_PRIVATE = "isprivate";
            /*     */       public static final String TAGS = "tags";
            /*     */       public static final String CATEGORY = "category";
            /*     */       public static final String LANGUAGE = "language";
            /*     */       public static final String LATITUDE = "latitude";
            /*     */       public static final String LONGITUDE = "longitude";
            /*     */       public static final String DATE_TAKEN = "datetaken";
            /*     */       public static final String MINI_THUMB_MAGIC = "mini_thumb_magic";
            /*     */       public static final String BUCKET_ID = "bucket_id";
            /*     */       public static final String BUCKET_DISPLAY_NAME = "bucket_display_name";
            /*     */       public static final String BOOKMARK = "bookmark";
        }

        /*     */
/* 270 */     public static final class Media implements MediaStore.Video.VideoColumns {
            public Media() {
                throw new RuntimeException("Stub!");
            }

            /* 271 */
            public static Uri getContentUri(String volumeName) {
                throw new RuntimeException("Stub!");
            }

            /*     */
/*     */ 
/*     */       public static final String DEFAULT_SORT_ORDER = "title";
            /*     */       public static final String CONTENT_TYPE = "vnd.android.cursor.dir/video";
            /* 276 */       public static final Uri EXTERNAL_CONTENT_URI = null;
            public static final Uri INTERNAL_CONTENT_URI = null;
        }

        /*     */
/*     */     public static class Thumbnails implements BaseColumns {
            public static final String HEIGHT = "height";
            /*     */       public static final String WIDTH = "width";

            /*     */
/* 281 */
            public Thumbnails() {
                throw new RuntimeException("Stub!");
            }

            /* 282 */
            public static void cancelThumbnailRequest(android.content.ContentResolver cr, long origId) {
                throw new RuntimeException("Stub!");
            }

            /* 283 */
            public static android.graphics.Bitmap getThumbnail(android.content.ContentResolver cr, long origId, int kind, android.graphics.BitmapFactory.Options options) {
                throw new RuntimeException("Stub!");
            }

            /* 284 */
            public static android.graphics.Bitmap getThumbnail(android.content.ContentResolver cr, long origId, long groupId, int kind, android.graphics.BitmapFactory.Options options) {
                throw new RuntimeException("Stub!");
            }

            /* 285 */
            public static void cancelThumbnailRequest(android.content.ContentResolver cr, long origId, long groupId) {
                throw new RuntimeException("Stub!");
            }

            /* 286 */
            public static Uri getContentUri(String volumeName) {
                throw new RuntimeException("Stub!");
            }

            /*     */
/*     */ 
/*     */       public static final int MICRO_KIND = 3;
            /*     */
/*     */       public static final int FULL_SCREEN_KIND = 2;
            /*     */
/*     */       public static final int MINI_KIND = 1;
            /*     */       public static final String KIND = "kind";
            /*     */       public static final String VIDEO_ID = "video_id";
            /*     */       public static final String DATA = "_data";
            /*     */       public static final String DEFAULT_SORT_ORDER = "video_id ASC";
            /* 298 */       public static final Uri EXTERNAL_CONTENT_URI = null;
            public static final Uri INTERNAL_CONTENT_URI = null;
        }

        /*     */
/* 300 */
        public Video() {
            throw new RuntimeException("Stub!");
        }

        /* 301 */
        public static final android.database.Cursor query(android.content.ContentResolver cr, Uri uri, String[] projection) {
            throw new RuntimeException("Stub!");
        }
/*     */
    }

    /*     */
/* 304 */
    public MediaStore() {
        throw new RuntimeException("Stub!");
    }

    /* 305 */
    public static Uri getMediaScannerUri() {
        throw new RuntimeException("Stub!");
    }

    /* 306 */
    public static String getVersion(android.content.Context context) {
        throw new RuntimeException("Stub!");
    }
/*     */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/provider/MediaStore.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */