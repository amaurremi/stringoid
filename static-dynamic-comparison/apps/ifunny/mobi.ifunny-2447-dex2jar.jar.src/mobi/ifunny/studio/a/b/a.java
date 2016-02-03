package mobi.ifunny.studio.a.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a {
    public boolean a = true;
    public List<b> b = new ArrayList();

    public boolean a() {
        return this.b.isEmpty();
    }

    public boolean b() {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext()) {
            if (!((b) localIterator.next()).a()) {
                return false;
            }
        }
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/a/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */