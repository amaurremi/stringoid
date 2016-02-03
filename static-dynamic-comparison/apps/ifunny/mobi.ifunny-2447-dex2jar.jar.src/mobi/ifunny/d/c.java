package mobi.ifunny.d;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class c {
    private static String c = "UTF-8";
    protected ConcurrentHashMap<String, String> a;
    protected ConcurrentHashMap<String, d> b;

    public c() {
        d();
    }

    private void d() {
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
    }

    public HttpEntity a() {
        Object localObject1;
        if (!this.b.isEmpty()) {
            f localf = new f();
            localObject1 = this.a.entrySet().iterator();
            while (((Iterator) localObject1).hasNext()) {
                localObject2 = (Map.Entry) ((Iterator) localObject1).next();
                localf.a((String) ((Map.Entry) localObject2).getKey(), (String) ((Map.Entry) localObject2).getValue());
            }
            int j = this.b.entrySet().size();
            Object localObject2 = this.b.entrySet().iterator();
            int i = 0;
            localObject1 = localf;
            if (!((Iterator) localObject2).hasNext()) {
                break label263;
            }
            localObject1 = (Map.Entry) ((Iterator) localObject2).next();
            d locald = (d) ((Map.Entry) localObject1).getValue();
            boolean bool;
            if (locald.a != null) {
                if (i != j - 1) {
                    break label213;
                }
                bool = true;
                label167:
                if (locald.c == null) {
                    break label218;
                }
                localf.a((String) ((Map.Entry) localObject1).getKey(), locald.a(), locald.a, locald.c, bool);
            }
            for (; ; ) {
                i += 1;
                break;
                label213:
                bool = false;
                break label167;
                label218:
                localf.a((String) ((Map.Entry) localObject1).getKey(), locald.a(), locald.a, bool);
            }
        }
        try {
            localObject1 = new UrlEncodedFormEntity(b(), c);
            label263:
            return (HttpEntity) localObject1;
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            localUnsupportedEncodingException.printStackTrace();
        }
        return null;
    }

    public void a(String paramString1, String paramString2) {
        if ((paramString1 != null) && (paramString2 != null)) {
            this.a.put(paramString1, paramString2);
        }
    }

    protected List<BasicNameValuePair> b() {
        LinkedList localLinkedList = new LinkedList();
        Iterator localIterator = this.a.entrySet().iterator();
        while (localIterator.hasNext()) {
            Map.Entry localEntry = (Map.Entry) localIterator.next();
            localLinkedList.add(new BasicNameValuePair((String) localEntry.getKey(), (String) localEntry.getValue()));
        }
        return localLinkedList;
    }

    protected String c() {
        return URLEncodedUtils.format(b(), c);
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder();
        Iterator localIterator = this.a.entrySet().iterator();
        Map.Entry localEntry;
        while (localIterator.hasNext()) {
            localEntry = (Map.Entry) localIterator.next();
            if (localStringBuilder.length() > 0) {
                localStringBuilder.append("&");
            }
            localStringBuilder.append((String) localEntry.getKey());
            localStringBuilder.append("=");
            localStringBuilder.append((String) localEntry.getValue());
        }
        localIterator = this.b.entrySet().iterator();
        while (localIterator.hasNext()) {
            localEntry = (Map.Entry) localIterator.next();
            if (localStringBuilder.length() > 0) {
                localStringBuilder.append("&");
            }
            localStringBuilder.append((String) localEntry.getKey());
            localStringBuilder.append("=");
            localStringBuilder.append("FILE");
        }
        return localStringBuilder.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */