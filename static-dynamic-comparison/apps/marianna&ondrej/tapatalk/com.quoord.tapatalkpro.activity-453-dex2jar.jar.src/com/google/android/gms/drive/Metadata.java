package com.google.android.gms.drive;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.gs;
import com.google.android.gms.internal.gt;
import com.google.android.gms.internal.gv;

import java.util.Date;

public abstract class Metadata
        implements Freezable<Metadata> {
    public static final int CONTENT_AVAILABLE_LOCALLY = 1;
    public static final int CONTENT_NOT_AVAILABLE_LOCALLY = 0;

    protected abstract <T> T a(MetadataField<T> paramMetadataField);

    public String getAlternateLink() {
        return (String) a(gs.FS);
    }

    public int getContentAvailability() {
        Integer localInteger = (Integer) a(gv.Gy);
        if (localInteger == null) {
            return 0;
        }
        return localInteger.intValue();
    }

    public Date getCreatedDate() {
        return (Date) a(gt.Gs);
    }

    public String getDescription() {
        return (String) a(gs.FT);
    }

    public DriveId getDriveId() {
        return (DriveId) a(gs.FR);
    }

    public String getEmbedLink() {
        return (String) a(gs.FU);
    }

    public String getFileExtension() {
        return (String) a(gs.FV);
    }

    public long getFileSize() {
        return ((Long) a(gs.FW)).longValue();
    }

    public Date getLastViewedByMeDate() {
        return (Date) a(gt.Gt);
    }

    public String getMimeType() {
        return (String) a(gs.Gh);
    }

    public Date getModifiedByMeDate() {
        return (Date) a(gt.Gv);
    }

    public Date getModifiedDate() {
        return (Date) a(gt.Gu);
    }

    public String getOriginalFilename() {
        return (String) a(gs.Gi);
    }

    public long getQuotaBytesUsed() {
        return ((Long) a(gs.Gl)).longValue();
    }

    public Date getSharedWithMeDate() {
        return (Date) a(gt.Gw);
    }

    public String getTitle() {
        return (String) a(gs.Go);
    }

    public String getWebContentLink() {
        return (String) a(gs.Gq);
    }

    public String getWebViewLink() {
        return (String) a(gs.Gr);
    }

    public boolean isEditable() {
        Boolean localBoolean = (Boolean) a(gs.Gb);
        if (localBoolean == null) {
            return false;
        }
        return localBoolean.booleanValue();
    }

    public boolean isFolder() {
        return "application/vnd.google-apps.folder".equals(getMimeType());
    }

    public boolean isInAppFolder() {
        Boolean localBoolean = (Boolean) a(gs.FZ);
        if (localBoolean == null) {
            return false;
        }
        return localBoolean.booleanValue();
    }

    public boolean isPinnable() {
        Boolean localBoolean = (Boolean) a(gv.Gz);
        if (localBoolean == null) {
            return false;
        }
        return localBoolean.booleanValue();
    }

    public boolean isPinned() {
        Boolean localBoolean = (Boolean) a(gs.Gc);
        if (localBoolean == null) {
            return false;
        }
        return localBoolean.booleanValue();
    }

    public boolean isRestricted() {
        Boolean localBoolean = (Boolean) a(gs.Gd);
        if (localBoolean == null) {
            return false;
        }
        return localBoolean.booleanValue();
    }

    public boolean isShared() {
        Boolean localBoolean = (Boolean) a(gs.Ge);
        if (localBoolean == null) {
            return false;
        }
        return localBoolean.booleanValue();
    }

    public boolean isStarred() {
        Boolean localBoolean = (Boolean) a(gs.Gm);
        if (localBoolean == null) {
            return false;
        }
        return localBoolean.booleanValue();
    }

    public boolean isTrashed() {
        Boolean localBoolean = (Boolean) a(gs.Gp);
        if (localBoolean == null) {
            return false;
        }
        return localBoolean.booleanValue();
    }

    public boolean isViewed() {
        Boolean localBoolean = (Boolean) a(gs.Gg);
        if (localBoolean == null) {
            return false;
        }
        return localBoolean.booleanValue();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/Metadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */