package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class az
        extends aj {
    private static final String ID = a.ac.toString();
    private static final String XQ = b.bi.toString();
    private static final String Ym = b.cL.toString();
    private static final String Yn = b.cO.toString();
    private static final String Yo = b.co.toString();

    public az() {
        super(ID, new String[]{XQ});
    }

    private String a(String paramString, a parama, Set<Character> paramSet) {
        switch (1. Yp[parama.ordinal()])
        {
            default:
                return paramString;
            case 1:
                try {
                    parama = dk.cd(paramString);
                    return parama;
                } catch (UnsupportedEncodingException parama) {
                    bh.b("Joiner: unsupported encoding", parama);
                    return paramString;
                }
        }
        paramString = paramString.replace("\\", "\\\\");
        parama = paramSet.iterator();
        while (parama.hasNext()) {
            paramSet = ((Character) parama.next()).toString();
            paramString = paramString.replace(paramSet, "\\" + paramSet);
        }
        return paramString;
    }

    private void a(StringBuilder paramStringBuilder, String paramString, a parama, Set<Character> paramSet) {
        paramStringBuilder.append(a(paramString, parama, paramSet));
    }

    private void a(Set<Character> paramSet, String paramString) {
        int i = 0;
        while (i < paramString.length()) {
            paramSet.add(Character.valueOf(paramString.charAt(i)));
            i += 1;
        }
    }

    public boolean jX() {
        return true;
    }

    public d.a x(Map<String, d.a> paramMap) {
        d.a locala = (d.a) paramMap.get(XQ);
        if (locala == null) {
            return dh.lT();
        }
        Object localObject1 = (d.a) paramMap.get(Ym);
        String str1;
        Object localObject2;
        if (localObject1 != null) {
            str1 = dh.j((d.a) localObject1);
            localObject1 = (d.a) paramMap.get(Yn);
            if (localObject1 == null) {
                break label186;
            }
            localObject2 = dh.j((d.a) localObject1);
            label75:
            localObject1 = a.Yq;
            paramMap = (d.a) paramMap.get(Yo);
            if (paramMap == null) {
                break label418;
            }
            paramMap = dh.j(paramMap);
            if (!"url".equals(paramMap)) {
                break label193;
            }
            localObject1 = a.Yr;
            paramMap = null;
        }
        for (; ; ) {
            label118:
            StringBuilder localStringBuilder = new StringBuilder();
            switch (locala.type) {
                default:
                    a(localStringBuilder, dh.j(locala), (a) localObject1, paramMap);
            }
            for (; ; ) {
                return dh.r(localStringBuilder.toString());
                str1 = "";
                break;
                label186:
                localObject2 = "=";
                break label75;
                label193:
                if ("backslash".equals(paramMap)) {
                    localObject1 = a.Ys;
                    paramMap = new HashSet();
                    a(paramMap, str1);
                    a(paramMap, (String) localObject2);
                    paramMap.remove(Character.valueOf('\\'));
                    break label118;
                }
                bh.w("Joiner: unsupported escape type: " + paramMap);
                return dh.lT();
                int j = 1;
                localObject2 = locala.fO;
                int k = localObject2.length;
                int i = 0;
                while (i < k) {
                    locala = localObject2[i];
                    if (j == 0) {
                        localStringBuilder.append(str1);
                    }
                    a(localStringBuilder, dh.j(locala), (a) localObject1, paramMap);
                    i += 1;
                    j = 0;
                }
                i = 0;
                while (i < locala.fP.length) {
                    if (i > 0) {
                        localStringBuilder.append(str1);
                    }
                    String str2 = dh.j(locala.fP[i]);
                    String str3 = dh.j(locala.fQ[i]);
                    a(localStringBuilder, str2, (a) localObject1, paramMap);
                    localStringBuilder.append((String) localObject2);
                    a(localStringBuilder, str3, (a) localObject1, paramMap);
                    i += 1;
                }
            }
            label418:
            paramMap = null;
        }
    }

    private static enum a {
        private a() {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/tagmanager/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */