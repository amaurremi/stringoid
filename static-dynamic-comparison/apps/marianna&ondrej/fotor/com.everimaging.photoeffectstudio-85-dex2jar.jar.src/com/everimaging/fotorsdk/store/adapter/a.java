package com.everimaging.fotorsdk.store.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap.Config;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.everimaging.fotorsdk.store.R.drawable;
import com.everimaging.fotorsdk.store.R.id;
import com.everimaging.fotorsdk.store.R.integer;
import com.everimaging.fotorsdk.store.R.layout;
import com.everimaging.fotorsdk.store.R.string;
import com.everimaging.fotorsdk.store.StatusAssistant;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.PurchasablePackBaseJsonObject;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.ResPackageJsonObject;
import com.everimaging.fotorsdk.store.widget.PurchaseButton;
import com.everimaging.fotorsdk.uil.core.c.a;
import com.everimaging.fotorsdk.uil.core.display.b;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class a
        extends BaseAdapter {
    private List<FotorStoreJsonObjects.ResPackageJsonObject> a;
    private Context b;
    private LayoutInflater c;
    private com.everimaging.fotorsdk.uil.core.c d;
    private Map<String, FotorStoreJsonObjects.ResPackageJsonObject> e;
    private Map<String, a> f;
    private View.OnClickListener g;

    public a(Context paramContext, String paramString, View.OnClickListener paramOnClickListener) {
        this.b = paramContext;
        this.c = LayoutInflater.from(this.b);
        this.g = paramOnClickListener;
        int i = this.b.getResources().getInteger(R.integer.fotor_anim_short_duration);
        this.d = new c.a().a(true).b(true).a(R.drawable.fotor_transparent).c(R.drawable.fotor_transparent).b(R.drawable.fotor_transparent).a(new b(i, true, true, false)).a(Bitmap.Config.RGB_565).a();
        this.e = new HashMap();
        this.f = new HashMap();
    }

    private void b() {
        this.e.clear();
        if ((this.a != null) && (this.a.size() > 0)) {
            Iterator localIterator = this.a.iterator();
            while (localIterator.hasNext()) {
                FotorStoreJsonObjects.ResPackageJsonObject localResPackageJsonObject = (FotorStoreJsonObjects.ResPackageJsonObject) localIterator.next();
                this.e.put(localResPackageJsonObject.getPackID(), localResPackageJsonObject);
            }
        }
        this.f.clear();
    }

    private String d(String paramString) {
        String str = "";
        if (com.everimaging.fotorsdk.store.utils.c.a(paramString)) {
            str = this.b.getString(R.string.fotor_store_grid_item_borders_suffix);
        }
        do {
            return str;
            if (com.everimaging.fotorsdk.store.utils.c.b(paramString)) {
                return this.b.getString(R.string.fotor_store_grid_item_effects_suffix);
            }
            if (com.everimaging.fotorsdk.store.utils.c.c(paramString)) {
                return this.b.getString(R.string.fotor_store_grid_item_stickers_suffix);
            }
            if (com.everimaging.fotorsdk.store.utils.c.d(paramString)) {
                return this.b.getString(R.string.fotor_store_grid_item_fonts_suffix);
            }
            if (com.everimaging.fotorsdk.store.utils.c.f(paramString)) {
                return this.b.getString(R.string.fotor_store_grid_item_collage_template_suffix);
            }
            if (com.everimaging.fotorsdk.store.utils.c.g(paramString)) {
                return this.b.getString(R.string.fotor_store_grid_item_collage_template_suffix);
            }
            if (com.everimaging.fotorsdk.store.utils.c.h(paramString)) {
                return this.b.getString(R.string.fotor_store_grid_item_collage_pattern_suffix);
            }
        } while (!com.everimaging.fotorsdk.store.utils.c.e(paramString));
        return this.b.getString(R.string.fotor_store_grid_item_bundles_suffix);
    }

    public int a(FotorStoreJsonObjects.ResPackageJsonObject paramResPackageJsonObject) {
        int j = -1;
        int i = j;
        if (this.a != null) {
            i = j;
            if (this.a.size() > 0) {
                i = j;
                if (paramResPackageJsonObject != null) {
                    i = this.a.indexOf(paramResPackageJsonObject);
                }
            }
        }
        return i;
    }

    public FotorStoreJsonObjects.ResPackageJsonObject a(String paramString) {
        return (FotorStoreJsonObjects.ResPackageJsonObject) this.e.get(paramString);
    }

    public List<FotorStoreJsonObjects.ResPackageJsonObject> a() {
        return this.a;
    }

    public void a(PurchaseButton paramPurchaseButton, FotorStoreJsonObjects.ResPackageJsonObject paramResPackageJsonObject) {
        if ((paramResPackageJsonObject.resources != null) && (paramResPackageJsonObject.resources.size() > 0)) {
        }
        for (boolean bool = true; ; bool = false) {
            StatusAssistant.a(this.b, paramResPackageJsonObject.statusInfo, paramPurchaseButton, bool);
            return;
        }
    }

    public void a(List<FotorStoreJsonObjects.ResPackageJsonObject> paramList) {
        for (; ; ) {
            try {
                if (this.a != null) {
                    synchronized (this.a) {
                        this.a = paramList;
                        b();
                        notifyDataSetChanged();
                        return;
                    }
                }
                this.a = paramList;
            } finally {
            }
        }
    }

    public FotorStoreJsonObjects.ResPackageJsonObject b(String paramString) {
        if ((this.a != null) && (this.a.size() > 0)) {
            FotorStoreJsonObjects.ResPackageJsonObject localResPackageJsonObject;
            Iterator localIterator2;
            do {
                Iterator localIterator1 = this.a.iterator();
                while (!localIterator2.hasNext()) {
                    do {
                        if (!localIterator1.hasNext()) {
                            break;
                        }
                        localResPackageJsonObject = (FotorStoreJsonObjects.ResPackageJsonObject) localIterator1.next();
                    }
                    while ((localResPackageJsonObject.resources == null) || (localResPackageJsonObject.resources.size() <= 0));
                    localIterator2 = localResPackageJsonObject.resources.iterator();
                }
            }
            while (!paramString.equals(((FotorStoreJsonObjects.PurchasablePackBaseJsonObject) localIterator2.next()).getPackID()));
            return localResPackageJsonObject;
        }
        return null;
    }

    public a c(String paramString) {
        a locala = (a) this.f.get(paramString);
        if ((locala != null) && (paramString.equals(locala.e))) {
            return locala;
        }
        return null;
    }

    public int getCount() {
        if (this.a != null) {
            return this.a.size();
        }
        return 0;
    }

    public Object getItem(int paramInt) {
        return this.a.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        Object localObject = (FotorStoreJsonObjects.ResPackageJsonObject) getItem(paramInt);
        if (paramView == null) {
            paramView = this.c.inflate(R.layout.fotor_store_grid_item, null);
            paramViewGroup = new a();
            paramViewGroup.a = ((ImageView) paramView.findViewById(R.id.fotor_store_pkg_preview));
            paramViewGroup.b = ((TextView) paramView.findViewById(R.id.fotor_store_pkg_name));
            paramViewGroup.d = ((PurchaseButton) paramView.findViewById(R.id.fotor_store_purchase_button));
            paramViewGroup.c = ((TextView) paramView.findViewById(R.id.fotor_store_pkg_size));
        }
        for (; ; ) {
            com.everimaging.fotorsdk.uil.core.d locald = com.everimaging.fotorsdk.uil.core.d.a();
            com.everimaging.fotorsdk.uil.core.imageaware.c localc = new com.everimaging.fotorsdk.uil.core.imageaware.c(paramViewGroup.a, false);
            locald.a(com.everimaging.fotorsdk.store.utils.d.b(((FotorStoreJsonObjects.ResPackageJsonObject) localObject).thumb), localc, this.d);
            paramViewGroup.b.setText(((FotorStoreJsonObjects.ResPackageJsonObject) localObject).name);
            paramViewGroup.c.setText(String.valueOf(((FotorStoreJsonObjects.ResPackageJsonObject) localObject).count) + " " + d(((FotorStoreJsonObjects.ResPackageJsonObject) localObject).type));
            paramViewGroup.d.setTag(localObject);
            paramViewGroup.d.setOnClickListener(this.g);
            a(paramViewGroup.d, (FotorStoreJsonObjects.ResPackageJsonObject) localObject);
            paramView.setTag(paramViewGroup);
            localObject = ((FotorStoreJsonObjects.ResPackageJsonObject) localObject).getPackID();
            paramViewGroup.e = ((String) localObject);
            this.f.put(localObject, paramViewGroup);
            return paramView;
            paramViewGroup = (a) paramView.getTag();
        }
    }

    public class a {
        public ImageView a;
        public TextView b;
        public TextView c;
        public PurchaseButton d;
        public String e;

        public a() {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/adapter/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */