package org.json.simple.parser;

import java.util.List;
import java.util.Map;

public abstract interface ContainerFactory {
    public abstract List creatArrayContainer();

    public abstract Map createObjectContainer();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/json/simple/parser/ContainerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */