package com.mopub.mobileads.util.vast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.w3c.dom.Node;

class c {
    private final Node b;

    c(b paramb, Node paramNode) {
        if (paramNode == null) {
            throw new IllegalArgumentException("Companion node cannot be null");
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
        return f.c(f.a(this.b, "StaticResource"), "creativeType");
    }

    String d() {
        return f.a(f.a(this.b, "StaticResource"));
    }

    String e() {
        return f.a(f.a(this.b, "CompanionClickThrough"));
    }

    List<String> f() {
        ArrayList localArrayList = new ArrayList();
        Object localObject = f.a(this.b, "TrackingEvents");
        if (localObject == null) {
            return localArrayList;
        }
        localObject = f.b((Node) localObject, "Tracking", "event", Arrays.asList(new String[]{"creativeView"})).iterator();
        while (((Iterator) localObject).hasNext()) {
            Node localNode = (Node) ((Iterator) localObject).next();
            if (localNode.getFirstChild() != null) {
                localArrayList.add(localNode.getFirstChild().getNodeValue().trim());
            }
        }
        return localArrayList;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/util/vast/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */