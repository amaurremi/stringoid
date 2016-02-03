package com.google.gson.internal;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;

import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

public final class Streams {
    public static JsonElement parse(JsonReader paramJsonReader) {
        int i = 1;
        try {
            paramJsonReader.peek();
            i = 0;
            paramJsonReader = (JsonElement) TypeAdapters.JSON_ELEMENT.read(paramJsonReader);
            return paramJsonReader;
        } catch (EOFException paramJsonReader) {
            if (i != 0) {
                return JsonNull.INSTANCE;
            }
            throw new JsonSyntaxException(paramJsonReader);
        } catch (MalformedJsonException paramJsonReader) {
            throw new JsonSyntaxException(paramJsonReader);
        } catch (IOException paramJsonReader) {
            throw new JsonIOException(paramJsonReader);
        } catch (NumberFormatException paramJsonReader) {
            throw new JsonSyntaxException(paramJsonReader);
        }
    }

    public static void write(JsonElement paramJsonElement, JsonWriter paramJsonWriter) {
        TypeAdapters.JSON_ELEMENT.write(paramJsonWriter, paramJsonElement);
    }

    public static Writer writerForAppendable(Appendable paramAppendable) {
        if ((paramAppendable instanceof Writer)) {
            return (Writer) paramAppendable;
        }
        return new ah(paramAppendable, null);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/Streams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */