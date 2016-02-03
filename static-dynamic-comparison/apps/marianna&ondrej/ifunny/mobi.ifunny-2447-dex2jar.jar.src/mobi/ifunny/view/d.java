package mobi.ifunny.view;

import android.util.SparseArray;

class d {
    private SparseArray<c> b = new SparseArray();

    public d(DynamicListView paramDynamicListView) {
    }

    public c a(int paramInt) {
        return (c) this.b.get(paramInt);
    }

    public void a(String paramString) {
        int i = 0;
        while (i < this.b.size()) {
            ((c) this.b.get(i)).a(paramString);
            i += 1;
        }
    }

    public void a(c paramc, int paramInt) {
        this.b.put(paramInt, paramc);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */