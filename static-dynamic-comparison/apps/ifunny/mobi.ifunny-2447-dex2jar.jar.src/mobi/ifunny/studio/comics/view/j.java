package mobi.ifunny.studio.comics.view;

import android.util.Pair;
import android.util.SparseArray;
import android.view.View;

import java.util.ArrayList;

class j {
    private SparseArray<ArrayList<View>> b = new SparseArray(4);

    private j(HorizontalAdapterView paramHorizontalAdapterView) {
    }

    public Pair<Integer, Integer> a(View paramView, int paramInt) {
        int i = 0;
        while (i < paramInt) {
            ArrayList localArrayList = (ArrayList) this.b.get(i);
            if (localArrayList != null) {
                int k = localArrayList.size();
                int j = 0;
                while (j < k) {
                    if (paramView.equals(localArrayList.get(j))) {
                        return new Pair(Integer.valueOf(i), Integer.valueOf(j));
                    }
                    j += 1;
                }
            }
            i += 1;
        }
        return null;
    }

    public View a(int paramInt) {
        ArrayList localArrayList = (ArrayList) this.b.get(paramInt);
        if ((localArrayList != null) && (localArrayList.size() > 0)) {
            return (View) localArrayList.get(0);
        }
        return null;
    }

    public void a(int paramInt1, int paramInt2) {
        ArrayList localArrayList = (ArrayList) this.b.get(paramInt1);
        if (localArrayList == null) {
            return;
        }
        paramInt1 = paramInt2;
        if (paramInt2 == -1) {
            paramInt1 = localArrayList.size() - 1;
        }
        localArrayList.remove(paramInt1);
    }

    public void a(int paramInt1, int paramInt2, View paramView) {
        ArrayList localArrayList2 = (ArrayList) this.b.get(paramInt1);
        ArrayList localArrayList1 = localArrayList2;
        if (localArrayList2 == null) {
            localArrayList1 = new ArrayList();
            this.b.append(paramInt1, localArrayList1);
        }
        paramInt1 = paramInt2;
        if (paramInt2 == -1) {
            paramInt1 = localArrayList1.size();
        }
        localArrayList1.add(paramInt1, paramView);
    }

    public View b(int paramInt) {
        ArrayList localArrayList = (ArrayList) this.b.get(paramInt);
        if ((localArrayList != null) && (localArrayList.size() > 0)) {
            return (View) localArrayList.get(localArrayList.size() - 1);
        }
        return null;
    }

    public View b(int paramInt1, int paramInt2) {
        ArrayList localArrayList = (ArrayList) this.b.get(paramInt1);
        if (localArrayList == null) {
            return null;
        }
        paramInt1 = paramInt2;
        if (paramInt2 == -1) {
            paramInt1 = localArrayList.size() - 1;
        }
        return (View) localArrayList.get(paramInt1);
    }

    public int c(int paramInt) {
        ArrayList localArrayList = (ArrayList) this.b.get(paramInt);
        if (localArrayList == null) {
            return 0;
        }
        return localArrayList.size();
    }

    public void d(int paramInt) {
        int i = 0;
        while (i < paramInt) {
            ArrayList localArrayList = (ArrayList) this.b.get(i);
            if (localArrayList != null) {
                localArrayList.clear();
            }
            i += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/view/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */