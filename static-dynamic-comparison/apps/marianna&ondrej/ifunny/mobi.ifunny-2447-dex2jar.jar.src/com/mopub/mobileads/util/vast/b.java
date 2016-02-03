package com.mopub.mobileads.util.vast;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

class b {
    private Document a;

    private List<String> b(String paramString) {
        return f.a(this.a, "Tracking", "event", paramString);
    }

    String a() {
        List localList = f.a(this.a, "VASTAdTagURI");
        if (localList.size() > 0) {
            return (String) localList.get(0);
        }
        return null;
    }

    void a(String paramString) {
        paramString = paramString.replaceFirst("<\\?.*\\?>", "");
        paramString = "<MPMoVideoXMLDocRoot>" + paramString + "</MPMoVideoXMLDocRoot>";
        DocumentBuilderFactory localDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
        localDocumentBuilderFactory.setCoalescing(true);
        this.a = localDocumentBuilderFactory.newDocumentBuilder().parse(new InputSource(new StringReader(paramString)));
    }

    List<String> b() {
        List localList = f.a(this.a, "Impression");
        localList.addAll(f.a(this.a, "MP_TRACKING_URL"));
        return localList;
    }

    List<String> c() {
        return b("start");
    }

    List<String> d() {
        return b("firstQuartile");
    }

    List<String> e() {
        return b("midpoint");
    }

    List<String> f() {
        return b("thirdQuartile");
    }

    List<String> g() {
        return b("complete");
    }

    String h() {
        List localList = f.a(this.a, "ClickThrough");
        if (localList.size() > 0) {
            return (String) localList.get(0);
        }
        return null;
    }

    List<String> i() {
        return f.a(this.a, "ClickTracking");
    }

    List<d> j() {
        NodeList localNodeList = this.a.getElementsByTagName("MediaFile");
        ArrayList localArrayList = new ArrayList(localNodeList.getLength());
        int i = 0;
        while (i < localNodeList.getLength()) {
            localArrayList.add(new d(this, localNodeList.item(i)));
            i += 1;
        }
        return localArrayList;
    }

    List<c> k() {
        NodeList localNodeList = this.a.getElementsByTagName("Companion");
        ArrayList localArrayList = new ArrayList(localNodeList.getLength());
        int i = 0;
        while (i < localNodeList.getLength()) {
            localArrayList.add(new c(this, localNodeList.item(i)));
            i += 1;
        }
        return localArrayList;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/util/vast/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */