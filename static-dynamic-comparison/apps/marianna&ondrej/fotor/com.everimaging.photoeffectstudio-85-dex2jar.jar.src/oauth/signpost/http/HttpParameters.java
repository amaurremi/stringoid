package oauth.signpost.http;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import oauth.signpost.a;

public class HttpParameters
        implements Serializable, Map<String, SortedSet<String>> {
    private TreeMap<String, SortedSet<String>> wrappedMap = new TreeMap();

    public void clear() {
        this.wrappedMap.clear();
    }

    public boolean containsKey(Object paramObject) {
        return this.wrappedMap.containsKey(paramObject);
    }

    public boolean containsValue(Object paramObject) {
        Iterator localIterator = this.wrappedMap.values().iterator();
        while (localIterator.hasNext()) {
            if (((SortedSet) localIterator.next()).contains(paramObject)) {
                return true;
            }
        }
        return false;
    }

    public Set<Map.Entry<String, SortedSet<String>>> entrySet() {
        return this.wrappedMap.entrySet();
    }

    public SortedSet<String> get(Object paramObject) {
        return (SortedSet) this.wrappedMap.get(paramObject);
    }

    public String getAsHeaderElement(String paramString) {
        String str = getFirst(paramString);
        if (str == null) {
            return null;
        }
        return paramString + "=\"" + str + "\"";
    }

    public String getAsQueryString(Object paramObject, boolean paramBoolean) {
        StringBuilder localStringBuilder = new StringBuilder();
        Object localObject = paramObject;
        if (paramBoolean) {
            localObject = a.a((String) paramObject);
        }
        paramObject = (Set) this.wrappedMap.get(localObject);
        if (paramObject == null) {
            return localObject + "=";
        }
        paramObject = ((Set) paramObject).iterator();
        while (((Iterator) paramObject).hasNext()) {
            localStringBuilder.append(localObject + "=" + (String) ((Iterator) paramObject).next());
            if (((Iterator) paramObject).hasNext()) {
                localStringBuilder.append("&");
            }
        }
        return localStringBuilder.toString();
    }

    public String getFirst(Object paramObject) {
        return getFirst(paramObject, false);
    }

    public String getFirst(Object paramObject, boolean paramBoolean) {
        paramObject = (SortedSet) this.wrappedMap.get(paramObject);
        if ((paramObject == null) || (((SortedSet) paramObject).isEmpty())) {
            paramObject = null;
        }
        String str;
        do {
            return (String) paramObject;
            str = (String) ((SortedSet) paramObject).first();
            paramObject = str;
        } while (!paramBoolean);
        return a.b(str);
    }

    public HttpParameters getOAuthParameters() {
        HttpParameters localHttpParameters = new HttpParameters();
        Iterator localIterator = entrySet().iterator();
        while (localIterator.hasNext()) {
            Map.Entry localEntry = (Map.Entry) localIterator.next();
            String str = (String) localEntry.getKey();
            if ((str.startsWith("oauth_")) || (str.startsWith("x_oauth_"))) {
                localHttpParameters.put(str, (SortedSet) localEntry.getValue());
            }
        }
        return localHttpParameters;
    }

    public boolean isEmpty() {
        return this.wrappedMap.isEmpty();
    }

    public Set<String> keySet() {
        return this.wrappedMap.keySet();
    }

    public String put(String paramString1, String paramString2) {
        return put(paramString1, paramString2, false);
    }

    public String put(String paramString1, String paramString2, boolean paramBoolean) {
        String str = paramString1;
        if (paramBoolean) {
            str = a.a(paramString1);
        }
        paramString1 = (SortedSet) this.wrappedMap.get(str);
        Object localObject = paramString1;
        if (paramString1 == null) {
            localObject = new TreeSet();
            this.wrappedMap.put(str, localObject);
        }
        paramString1 = paramString2;
        if (paramString2 != null) {
            paramString1 = paramString2;
            if (paramBoolean) {
                paramString1 = a.a(paramString2);
            }
            ((SortedSet) localObject).add(paramString1);
        }
        return paramString1;
    }

    public SortedSet<String> put(String paramString, SortedSet<String> paramSortedSet) {
        return (SortedSet) this.wrappedMap.put(paramString, paramSortedSet);
    }

    public SortedSet<String> put(String paramString, SortedSet<String> paramSortedSet, boolean paramBoolean) {
        if (paramBoolean) {
            remove(paramString);
            paramSortedSet = paramSortedSet.iterator();
            while (paramSortedSet.hasNext()) {
                put(paramString, (String) paramSortedSet.next(), true);
            }
            return get(paramString);
        }
        return (SortedSet) this.wrappedMap.put(paramString, paramSortedSet);
    }

    public void putAll(Map<? extends String, ? extends SortedSet<String>> paramMap) {
        this.wrappedMap.putAll(paramMap);
    }

    public void putAll(Map<? extends String, ? extends SortedSet<String>> paramMap, boolean paramBoolean) {
        if (paramBoolean) {
            Iterator localIterator = paramMap.keySet().iterator();
            while (localIterator.hasNext()) {
                String str = (String) localIterator.next();
                put(str, (SortedSet) paramMap.get(str), true);
            }
        }
        this.wrappedMap.putAll(paramMap);
    }

    public SortedSet<String> remove(Object paramObject) {
        return (SortedSet) this.wrappedMap.remove(paramObject);
    }

    public int size() {
        Iterator localIterator = this.wrappedMap.keySet().iterator();
        String str;
        for (int i = 0; localIterator.hasNext(); i = ((SortedSet) this.wrappedMap.get(str)).size() + i) {
            str = (String) localIterator.next();
        }
        return i;
    }

    public Collection<SortedSet<String>> values() {
        return this.wrappedMap.values();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/oauth/signpost/http/HttpParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */