package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;

final class a
        extends JsonReaderInternalAccess {
    public void promoteNameToValue(JsonReader paramJsonReader) {
        if ((paramJsonReader instanceof JsonTreeReader)) {
            ((JsonTreeReader) paramJsonReader).promoteNameToValue();
            return;
        }
        int j = JsonReader.access$000(paramJsonReader);
        int i = j;
        if (j == 0) {
            i = JsonReader.access$100(paramJsonReader);
        }
        if (i == 13) {
            JsonReader.access$002(paramJsonReader, 9);
            return;
        }
        if (i == 12) {
            JsonReader.access$002(paramJsonReader, 8);
            return;
        }
        if (i == 14) {
            JsonReader.access$002(paramJsonReader, 10);
            return;
        }
        throw new IllegalStateException("Expected a name but was " + paramJsonReader.peek() + " " + " at line " + JsonReader.access$200(paramJsonReader) + " column " + JsonReader.access$300(paramJsonReader) + " path " + paramJsonReader.getPath());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/stream/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */