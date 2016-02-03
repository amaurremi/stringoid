package com.mopub.mobileads.util.vast;

import org.w3c.dom.Node;

class d {
    private final Node b;

    d(b paramb, Node paramNode) {
        if (paramNode == null) {
            throw new IllegalArgumentException("Media node cannot be null");
        }
        this.b = paramNode;
    }

    Integer a() {
        return f.b(this.b, "width");
    }

    Integer b() {
        return f.b(this.b, "height");
    }

    String c() {
        return f.c(this.b, "type");
    }

    String d() {
        return f.a(this.b);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/util/vast/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */