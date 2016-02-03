package com.google.android.gms.drive;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class b
        extends Metadata {
    private final MetadataBundle ED;

    public b(MetadataBundle paramMetadataBundle) {
        this.ED = paramMetadataBundle;
    }

    protected <T> T a(MetadataField<T> paramMetadataField) {
        return (T) this.ED.a(paramMetadataField);
    }

    public Metadata fB() {
        return new b(MetadataBundle.a(this.ED));
    }

    public boolean isDataValid() {
        return this.ED != null;
    }

    public String toString() {
        return "Metadata [mImpl=" + this.ED + "]";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */