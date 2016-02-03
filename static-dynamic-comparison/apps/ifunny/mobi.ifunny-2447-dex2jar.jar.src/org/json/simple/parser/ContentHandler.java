package org.json.simple.parser;

public abstract interface ContentHandler {
    public abstract boolean endArray();

    public abstract void endJSON();

    public abstract boolean endObject();

    public abstract boolean endObjectEntry();

    public abstract boolean primitive(Object paramObject);

    public abstract boolean startArray();

    public abstract void startJSON();

    public abstract boolean startObject();

    public abstract boolean startObjectEntry(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/json/simple/parser/ContentHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */