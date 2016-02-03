package mobi.ifunny.util;

import android.util.SparseArray;

final class m
        extends SparseArray<String> {
    m() {
        put(1, "ACCESS");
        put(2, "MODIFY");
        put(4, "ATTRIB");
        put(8, "CLOSE_WRITE");
        put(16, "CLOSE_NOWRITE");
        put(32, "OPEN");
        put(64, "MOVED_FROM");
        put(128, "MOVED_TO");
        put(256, "CREATE");
        put(512, "DELETE");
        put(1024, "DELETE_SELF");
        put(2048, "MOVE_SELF");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */