package org.b.d.a;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.b.d.al;
import org.b.g.a.a;

public class p {
    protected List<o> a = new ArrayList();
    protected o b;

    public p(al paramal) {
        this(paramal, null);
    }

    public p(al paramal, ClassLoader paramClassLoader) {
        a(paramal, paramClassLoader);
    }

    private static o a(String paramString, al paramal, ClassLoader paramClassLoader) {
        try {
            paramString = (o) Class.forName(paramString).getConstructor(new Class[]{al.class, ClassLoader.class}).newInstance(new Object[]{paramal, paramClassLoader});
            return paramString;
        } catch (Exception paramString) {
            paramString.printStackTrace();
        }
        return new j(paramal, paramClassLoader);
    }

    private static boolean b() {
        return !a.a();
    }

    public o a() {
        return this.b;
    }

    public o a(Type paramType, boolean paramBoolean) {
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext()) {
            o localo = (o) localIterator.next();
            if (localo.b(paramType, paramBoolean)) {
                return localo;
            }
        }
        return null;
    }

    protected void a(al paramal, ClassLoader paramClassLoader) {
        if (paramal == null) {
            throw new NullPointerException("registry is null");
        }
        if (b()) {
        }
        for (String str = "org.msgpack.template.builder.JavassistTemplateBuilder"; ; str = "org.msgpack.template.builder.ReflectionTemplateBuilder") {
            this.b = a(str, paramal, paramClassLoader);
            paramClassLoader = this.b;
            this.a.add(new b(paramal));
            this.a.add(new g(paramal));
            this.a.add(paramClassLoader);
            this.a.add(new h(paramal));
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */