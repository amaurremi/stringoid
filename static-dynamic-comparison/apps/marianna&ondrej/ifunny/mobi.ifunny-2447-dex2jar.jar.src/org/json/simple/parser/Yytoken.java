package org.json.simple.parser;

public class Yytoken {
    public static final int TYPE_COLON = 6;
    public static final int TYPE_COMMA = 5;
    public static final int TYPE_EOF = -1;
    public static final int TYPE_LEFT_BRACE = 1;
    public static final int TYPE_LEFT_SQUARE = 3;
    public static final int TYPE_RIGHT_BRACE = 2;
    public static final int TYPE_RIGHT_SQUARE = 4;
    public static final int TYPE_VALUE = 0;
    public int type = 0;
    public Object value = null;

    public Yytoken(int paramInt, Object paramObject) {
        this.type = paramInt;
        this.value = paramObject;
    }

    public String toString() {
        StringBuffer localStringBuffer = new StringBuffer();
        switch (this.type) {
        }
        for (; ; ) {
            return localStringBuffer.toString();
            localStringBuffer.append("VALUE(").append(this.value).append(")");
            continue;
            localStringBuffer.append("LEFT BRACE({)");
            continue;
            localStringBuffer.append("RIGHT BRACE(})");
            continue;
            localStringBuffer.append("LEFT SQUARE([)");
            continue;
            localStringBuffer.append("RIGHT SQUARE(])");
            continue;
            localStringBuffer.append("COMMA(,)");
            continue;
            localStringBuffer.append("COLON(:)");
            continue;
            localStringBuffer.append("END OF FILE");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/json/simple/parser/Yytoken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */