package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

final class q
        extends TypeAdapter<Character> {
    public Character a(JsonReader paramJsonReader) {
        if (paramJsonReader.peek() == JsonToken.NULL) {
            paramJsonReader.nextNull();
            return null;
        }
        paramJsonReader = paramJsonReader.nextString();
        if (paramJsonReader.length() != 1) {
            throw new JsonSyntaxException("Expecting character, got: " + paramJsonReader);
        }
        return Character.valueOf(paramJsonReader.charAt(0));
    }

    public void a(JsonWriter paramJsonWriter, Character paramCharacter) {
        if (paramCharacter == null) {
        }
        for (paramCharacter = null; ; paramCharacter = String.valueOf(paramCharacter)) {
            paramJsonWriter.value(paramCharacter);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/bind/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */