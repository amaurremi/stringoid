package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.net.InetAddress;

final class z
        extends TypeAdapter<InetAddress> {
    public InetAddress a(JsonReader paramJsonReader) {
        if (paramJsonReader.peek() == JsonToken.NULL) {
            paramJsonReader.nextNull();
            return null;
        }
        return InetAddress.getByName(paramJsonReader.nextString());
    }

    public void a(JsonWriter paramJsonWriter, InetAddress paramInetAddress) {
        if (paramInetAddress == null) {
        }
        for (paramInetAddress = null; ; paramInetAddress = paramInetAddress.getHostAddress()) {
            paramJsonWriter.value(paramInetAddress);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/bind/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */