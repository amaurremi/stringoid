package com.google.android.gms.drive.query;

import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.internal.gs;
import com.google.android.gms.internal.gt;

import java.util.Date;

public class SearchableField {
    public static final SearchableOrderedMetadataField<Date> GE;
    public static final SearchableMetadataField<Boolean> IS_PINNED = gs.Gc;
    public static final SearchableOrderedMetadataField<Date> LAST_VIEWED_BY_ME;
    public static final SearchableMetadataField<String> MIME_TYPE;
    public static final SearchableOrderedMetadataField<Date> MODIFIED_DATE;
    public static final SearchableCollectionMetadataField<DriveId> PARENTS;
    public static final SearchableMetadataField<Boolean> STARRED;
    public static final SearchableMetadataField<String> TITLE = gs.Go;
    public static final SearchableMetadataField<Boolean> TRASHED;

    static {
        MIME_TYPE = gs.Gh;
        TRASHED = gs.Gp;
        PARENTS = gs.Gk;
        GE = gt.Gw;
        STARRED = gs.Gm;
        MODIFIED_DATE = gt.Gu;
        LAST_VIEWED_BY_ME = gt.Gt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/query/SearchableField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */