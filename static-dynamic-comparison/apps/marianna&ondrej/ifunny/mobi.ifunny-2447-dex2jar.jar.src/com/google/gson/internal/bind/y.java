package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.util.BitSet;

final class y
        extends TypeAdapter<BitSet> {
    public BitSet a(JsonReader paramJsonReader) {
        if (paramJsonReader.peek() == JsonToken.NULL) {
            paramJsonReader.nextNull();
            return null;
        }
        BitSet localBitSet = new BitSet();
        paramJsonReader.beginArray();
        Object localObject = paramJsonReader.peek();
        int i = 0;
        if (localObject != JsonToken.END_ARRAY) {
            boolean bool;
            switch (an.a[localObject.ordinal()]) {
                default:
                    throw new JsonSyntaxException("Invalid bitset value type: " + localObject);
                case 1:
                    if (paramJsonReader.nextInt() != 0) {
                        bool = true;
                    }
                    break;
            }
            for (; ; ) {
                if (bool) {
                    localBitSet.set(i);
                }
                i += 1;
                localObject = paramJsonReader.peek();
                break;
                bool = false;
                continue;
                bool = paramJsonReader.nextBoolean();
                continue;
                localObject = paramJsonReader.nextString();
                try {
                    int j = Integer.parseInt((String) localObject);
                    if (j != 0) {
                        bool = true;
                    } else {
                        bool = false;
                    }
                } catch (NumberFormatException paramJsonReader) {
                    throw new JsonSyntaxException("Error: Expecting: bitset number value (1, 0), Found: " + (String) localObject);
                }
            }
        }
        paramJsonReader.endArray();
        return localBitSet;
    }

    public void a(JsonWriter paramJsonWriter, BitSet paramBitSet) {
        if (paramBitSet == null) {
            paramJsonWriter.nullValue();
            return;
        }
        paramJsonWriter.beginArray();
        int i = 0;
        if (i < paramBitSet.length()) {
            if (paramBitSet.get(i)) {
            }
            for (int j = 1; ; j = 0) {
                paramJsonWriter.value(j);
                i += 1;
                break;
            }
        }
        paramJsonWriter.endArray();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/bind/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */