package com.google.gson.internal;

public final class $Gson$Preconditions {
    public static void checkArgument(boolean paramBoolean) {
        if (!paramBoolean) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> T checkNotNull(T paramT) {
        if (paramT == null) {
            throw new NullPointerException();
        }
        return paramT;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/$Gson$Preconditions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */