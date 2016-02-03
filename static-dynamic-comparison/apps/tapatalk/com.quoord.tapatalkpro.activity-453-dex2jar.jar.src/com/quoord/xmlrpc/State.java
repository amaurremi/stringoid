package com.quoord.xmlrpc;

public class State {
    public String name;
    public String namespace;
    public PrefixMap prefixMap;
    public State prev;
    public String tag;

    public State(State paramState, PrefixMap paramPrefixMap, String paramString) {
        this.prev = paramState;
        this.prefixMap = paramPrefixMap;
        this.tag = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/xmlrpc/State.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */