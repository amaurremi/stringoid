package com.everimaging.fotorsdk.http;

import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class l {
    protected boolean a;
    protected boolean b;
    protected final ConcurrentHashMap<String, String> c = new ConcurrentHashMap();
    protected final ConcurrentHashMap<String, b> d = new ConcurrentHashMap();
    protected final ConcurrentHashMap<String, a> e = new ConcurrentHashMap();
    protected final ConcurrentHashMap<String, Object> f = new ConcurrentHashMap();
    protected String g = "UTF-8";

    public l() {
        this((Map) null);
    }

    public l(Map<String, String> paramMap) {
        if (paramMap != null) {
            paramMap = paramMap.entrySet().iterator();
            while (paramMap.hasNext()) {
                Map.Entry localEntry = (Map.Entry) paramMap.next();
                a((String) localEntry.getKey(), (String) localEntry.getValue());
            }
        }
    }

    private List<BasicNameValuePair> b(String paramString, Object paramObject) {
        LinkedList localLinkedList = new LinkedList();
        Object localObject1;
        if ((paramObject instanceof Map)) {
            localObject1 = (Map) paramObject;
            paramObject = new ArrayList(((Map) localObject1).keySet());
            Collections.sort((List) paramObject);
            Iterator localIterator = ((List) paramObject).iterator();
            Object localObject2;
            do {
                do {
                    if (!localIterator.hasNext()) {
                        break;
                    }
                    paramObject = localIterator.next();
                } while (!(paramObject instanceof String));
                localObject2 = ((Map) localObject1).get(paramObject);
            } while (localObject2 == null);
            if (paramString == null) {
            }
            for (paramObject = (String) paramObject; ; paramObject = String.format("%s[%s]", new Object[]{paramString, paramObject})) {
                localLinkedList.addAll(b((String) paramObject, localObject2));
                break;
            }
        }
        if ((paramObject instanceof List)) {
            paramObject = ((List) paramObject).iterator();
            while (((Iterator) paramObject).hasNext()) {
                localObject1 = ((Iterator) paramObject).next();
                localLinkedList.addAll(b(String.format("%s[]", new Object[]{paramString}), localObject1));
            }
        }
        if ((paramObject instanceof Object[])) {
            paramObject = (Object[]) paramObject;
            int j = paramObject.length;
            int i = 0;
            while (i < j) {
                localObject1 = paramObject[i];
                localLinkedList.addAll(b(String.format("%s[]", new Object[]{paramString}), localObject1));
                i += 1;
            }
        }
        if ((paramObject instanceof Set)) {
            paramObject = ((Set) paramObject).iterator();
            while (((Iterator) paramObject).hasNext()) {
                localLinkedList.addAll(b(paramString, ((Iterator) paramObject).next()));
            }
        }
        if ((paramObject instanceof String)) {
            localLinkedList.add(new BasicNameValuePair(paramString, (String) paramObject));
        }
        return localLinkedList;
    }

    private HttpEntity b(m paramm)
            throws IOException {
        if ((!this.e.isEmpty()) || (!this.d.isEmpty())) {
        }
        Map.Entry localEntry;
        for (boolean bool = true; ; bool = false) {
            paramm = new h(paramm, bool);
            localIterator = this.c.entrySet().iterator();
            while (localIterator.hasNext()) {
                localEntry = (Map.Entry) localIterator.next();
                paramm.a((String) localEntry.getKey(), localEntry.getValue());
            }
        }
        Iterator localIterator = this.f.entrySet().iterator();
        while (localIterator.hasNext()) {
            localEntry = (Map.Entry) localIterator.next();
            paramm.a((String) localEntry.getKey(), localEntry.getValue());
        }
        localIterator = this.e.entrySet().iterator();
        while (localIterator.hasNext()) {
            localEntry = (Map.Entry) localIterator.next();
            paramm.a((String) localEntry.getKey(), localEntry.getValue());
        }
        localIterator = this.d.entrySet().iterator();
        while (localIterator.hasNext()) {
            localEntry = (Map.Entry) localIterator.next();
            b localb = (b) localEntry.getValue();
            if (localb.a != null) {
                paramm.a((String) localEntry.getKey(), b.a(localb.a, localb.b, localb.c, localb.d));
            }
        }
        return paramm;
    }

    private HttpEntity c() {
        try {
            UrlEncodedFormEntity localUrlEncodedFormEntity = new UrlEncodedFormEntity(a(), this.g);
            return localUrlEncodedFormEntity;
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            Log.e("RequestParams", "createFormEntity failed", localUnsupportedEncodingException);
        }
        return null;
    }

    private HttpEntity c(m paramm)
            throws IOException {
        paramm = new o(paramm);
        paramm.a(this.a);
        Iterator localIterator = this.c.entrySet().iterator();
        Object localObject1;
        while (localIterator.hasNext()) {
            localObject1 = (Map.Entry) localIterator.next();
            paramm.a((String) ((Map.Entry) localObject1).getKey(), (String) ((Map.Entry) localObject1).getValue());
        }
        localIterator = b(null, this.f).iterator();
        while (localIterator.hasNext()) {
            localObject1 = (BasicNameValuePair) localIterator.next();
            paramm.a(((BasicNameValuePair) localObject1).getName(), ((BasicNameValuePair) localObject1).getValue());
        }
        localIterator = this.d.entrySet().iterator();
        Object localObject2;
        while (localIterator.hasNext()) {
            localObject1 = (Map.Entry) localIterator.next();
            localObject2 = (b) ((Map.Entry) localObject1).getValue();
            if (((b) localObject2).a != null) {
                paramm.a((String) ((Map.Entry) localObject1).getKey(), ((b) localObject2).b, ((b) localObject2).a, ((b) localObject2).c);
            }
        }
        localIterator = this.e.entrySet().iterator();
        while (localIterator.hasNext()) {
            localObject1 = (Map.Entry) localIterator.next();
            localObject2 = (a) ((Map.Entry) localObject1).getValue();
            paramm.a((String) ((Map.Entry) localObject1).getKey(), ((a) localObject2).a, ((a) localObject2).b);
        }
        return paramm;
    }

    protected List<BasicNameValuePair> a() {
        LinkedList localLinkedList = new LinkedList();
        Iterator localIterator = this.c.entrySet().iterator();
        while (localIterator.hasNext()) {
            Map.Entry localEntry = (Map.Entry) localIterator.next();
            localLinkedList.add(new BasicNameValuePair((String) localEntry.getKey(), (String) localEntry.getValue()));
        }
        localLinkedList.addAll(b(null, this.f));
        return localLinkedList;
    }

    public HttpEntity a(m paramm)
            throws IOException {
        if (this.b) {
            return b(paramm);
        }
        if ((this.d.isEmpty()) && (this.e.isEmpty())) {
            return c();
        }
        return c(paramm);
    }

    public void a(String paramString, int paramInt) {
        if (paramString != null) {
            this.c.put(paramString, String.valueOf(paramInt));
        }
    }

    public void a(String paramString, Object paramObject) {
        if ((paramString != null) && (paramObject != null)) {
            this.f.put(paramString, paramObject);
        }
    }

    public void a(String paramString1, String paramString2) {
        if ((paramString1 != null) && (paramString2 != null)) {
            this.c.put(paramString1, paramString2);
        }
    }

    protected String b() {
        return URLEncodedUtils.format(a(), this.g);
    }

    public void b(String paramString1, String paramString2) {
        Object localObject1;
        if ((paramString1 != null) && (paramString2 != null)) {
            Object localObject2 = this.f.get(paramString1);
            localObject1 = localObject2;
            if (localObject2 == null) {
                localObject1 = new HashSet();
                a(paramString1, localObject1);
            }
            if (!(localObject1 instanceof List)) {
                break label59;
            }
            ((List) localObject1).add(paramString2);
        }
        label59:
        while (!(localObject1 instanceof Set)) {
            return;
        }
        ((Set) localObject1).add(paramString2);
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder();
        Iterator localIterator = this.c.entrySet().iterator();
        Object localObject;
        while (localIterator.hasNext()) {
            localObject = (Map.Entry) localIterator.next();
            if (localStringBuilder.length() > 0) {
                localStringBuilder.append("&");
            }
            localStringBuilder.append((String) ((Map.Entry) localObject).getKey());
            localStringBuilder.append("=");
            localStringBuilder.append((String) ((Map.Entry) localObject).getValue());
        }
        localIterator = this.d.entrySet().iterator();
        while (localIterator.hasNext()) {
            localObject = (Map.Entry) localIterator.next();
            if (localStringBuilder.length() > 0) {
                localStringBuilder.append("&");
            }
            localStringBuilder.append((String) ((Map.Entry) localObject).getKey());
            localStringBuilder.append("=");
            localStringBuilder.append("STREAM");
        }
        localIterator = this.e.entrySet().iterator();
        while (localIterator.hasNext()) {
            localObject = (Map.Entry) localIterator.next();
            if (localStringBuilder.length() > 0) {
                localStringBuilder.append("&");
            }
            localStringBuilder.append((String) ((Map.Entry) localObject).getKey());
            localStringBuilder.append("=");
            localStringBuilder.append("FILE");
        }
        localIterator = b(null, this.f).iterator();
        while (localIterator.hasNext()) {
            localObject = (BasicNameValuePair) localIterator.next();
            if (localStringBuilder.length() > 0) {
                localStringBuilder.append("&");
            }
            localStringBuilder.append(((BasicNameValuePair) localObject).getName());
            localStringBuilder.append("=");
            localStringBuilder.append(((BasicNameValuePair) localObject).getValue());
        }
        return localStringBuilder.toString();
    }

    public static class a {
        public final File a;
        public final String b;
    }

    public static class b {
        public final InputStream a;
        public final String b;
        public final String c;
        public final boolean d;

        public b(InputStream paramInputStream, String paramString1, String paramString2, boolean paramBoolean) {
            this.a = paramInputStream;
            this.b = paramString1;
            this.c = paramString2;
            this.d = paramBoolean;
        }

        static b a(InputStream paramInputStream, String paramString1, String paramString2, boolean paramBoolean) {
            String str = paramString2;
            if (paramString2 == null) {
                str = "application/octet-stream";
            }
            return new b(paramInputStream, paramString1, str, paramBoolean);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/http/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */