package com.flurry.sdk;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d {
    private static final String a = d.class.getSimpleName();

    public static List<e> a(DataInput paramDataInput)
            throws IOException {
        if (46586 != paramDataInput.readUnsignedShort()) {
            throw new IOException("Unexpected data format");
        }
        return b(paramDataInput);
    }

    public static void a(List<e> paramList, DataOutput paramDataOutput)
            throws IOException {
        paramDataOutput.writeShort(46586);
        b(paramList, paramDataOutput);
        paramDataOutput.writeShort(0);
    }

    private static List<e> b(DataInput paramDataInput) {
        localArrayList = new ArrayList();
        try {
            for (; ; ) {
                if (1 != paramDataInput.readUnsignedShort()) {
                    return localArrayList;
                }
                localArrayList.add(new e(paramDataInput));
            }
            return localArrayList;
        } catch (IOException paramDataInput) {
            eo.a(3, a, "unable to read adLog: ", paramDataInput);
        }
    }

    private static void b(List<e> paramList, DataOutput paramDataOutput) {
        Iterator localIterator = paramList.iterator();
        for (; ; ) {
            if (localIterator.hasNext()) {
                paramList = (e) localIterator.next();
                try {
                    paramDataOutput.writeShort(1);
                    paramList.a(paramDataOutput);
                } catch (IOException paramDataOutput) {
                    eo.a(3, a, "unable to write adLog with GUID: " + paramList.b(), paramDataOutput);
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */