package org.json.simple.parser;

public class ParseException
        extends Exception {
    public static final int ERROR_UNEXPECTED_CHAR = 0;
    public static final int ERROR_UNEXPECTED_EXCEPTION = 2;
    public static final int ERROR_UNEXPECTED_TOKEN = 1;
    private static final long serialVersionUID = -7880698968187728548L;
    private int errorType;
    private int position;
    private Object unexpectedObject;

    public ParseException(int paramInt) {
        this(-1, paramInt, null);
    }

    public ParseException(int paramInt1, int paramInt2, Object paramObject) {
        this.position = paramInt1;
        this.errorType = paramInt2;
        this.unexpectedObject = paramObject;
    }

    public ParseException(int paramInt, Object paramObject) {
        this(-1, paramInt, paramObject);
    }

    public int getErrorType() {
        return this.errorType;
    }

    public int getPosition() {
        return this.position;
    }

    public Object getUnexpectedObject() {
        return this.unexpectedObject;
    }

    public void setErrorType(int paramInt) {
        this.errorType = paramInt;
    }

    public void setPosition(int paramInt) {
        this.position = paramInt;
    }

    public void setUnexpectedObject(Object paramObject) {
        this.unexpectedObject = paramObject;
    }

    public String toString() {
        StringBuffer localStringBuffer = new StringBuffer();
        switch (this.errorType) {
            default:
                localStringBuffer.append("Unkown error at position ").append(this.position).append(".");
        }
        for (; ; ) {
            return localStringBuffer.toString();
            localStringBuffer.append("Unexpected character (").append(this.unexpectedObject).append(") at position ").append(this.position).append(".");
            continue;
            localStringBuffer.append("Unexpected token ").append(this.unexpectedObject).append(" at position ").append(this.position).append(".");
            continue;
            localStringBuffer.append("Unexpected exception at position ").append(this.position).append(": ").append(this.unexpectedObject);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/json/simple/parser/ParseException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */