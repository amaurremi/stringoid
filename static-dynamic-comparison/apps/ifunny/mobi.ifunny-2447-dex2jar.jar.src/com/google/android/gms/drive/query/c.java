package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.a;
import com.google.android.gms.drive.metadata.g;
import com.google.android.gms.drive.query.internal.Operator;
import com.google.android.gms.drive.query.internal.f;

import java.util.Iterator;
import java.util.List;

public class c
        implements f<String> {
    public String a() {
        return "all()";
    }

    public String a(a<?> parama) {
        return String.format("fieldOnly(%s)", new Object[]{parama.a()});
    }

    public <T> String a(a<T> parama, T paramT) {
        return String.format("has(%s,%s)", new Object[]{parama.a(), paramT});
    }

    public <T> String a(g<T> paramg, T paramT) {
        return String.format("contains(%s,%s)", new Object[]{paramg.a(), paramT});
    }

    public <T> String a(Operator paramOperator, a<T> parama, T paramT) {
        return String.format("cmp(%s,%s,%s)", new Object[]{paramOperator.a(), parama.a(), paramT});
    }

    public String a(Operator paramOperator, List<String> paramList) {
        StringBuilder localStringBuilder = new StringBuilder(paramOperator.a() + "(");
        paramList = paramList.iterator();
        for (paramOperator = ""; paramList.hasNext(); paramOperator = ",") {
            String str = (String) paramList.next();
            localStringBuilder.append(paramOperator);
            localStringBuilder.append(str);
        }
        return ")";
    }

    public String a(String paramString) {
        return String.format("not(%s)", new Object[]{paramString});
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/query/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */