package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.gs;
import com.google.android.gms.internal.gt;
import com.google.android.gms.internal.gv;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class c {
    private static Map<String, MetadataField<?>> FP = new HashMap();

    static {
        b(gs.FR);
        b(gs.Go);
        b(gs.Gh);
        b(gs.Gm);
        b(gs.Gp);
        b(gs.Gb);
        b(gs.Gc);
        b(gs.FZ);
        b(gs.Ge);
        b(gs.Gk);
        b(gs.FS);
        b(gs.Gj);
        b(gs.FT);
        b(gs.Ga);
        b(gs.FU);
        b(gs.FV);
        b(gs.FW);
        b(gs.Gg);
        b(gs.Gd);
        b(gs.Gi);
        b(gs.Gl);
        b(gs.Gq);
        b(gs.Gr);
        b(gs.FY);
        b(gs.FX);
        b(gs.Gn);
        b(gs.Gf);
        b(gt.Gs);
        b(gt.Gu);
        b(gt.Gv);
        b(gt.Gw);
        b(gt.Gt);
        b(gv.Gy);
        b(gv.Gz);
    }

    public static MetadataField<?> ax(String paramString) {
        return (MetadataField) FP.get(paramString);
    }

    private static void b(MetadataField<?> paramMetadataField) {
        if (FP.containsKey(paramMetadataField.getName())) {
            throw new IllegalArgumentException("Duplicate field name registered: " + paramMetadataField.getName());
        }
        FP.put(paramMetadataField.getName(), paramMetadataField);
    }

    public static Collection<MetadataField<?>> fS() {
        return Collections.unmodifiableCollection(FP.values());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */