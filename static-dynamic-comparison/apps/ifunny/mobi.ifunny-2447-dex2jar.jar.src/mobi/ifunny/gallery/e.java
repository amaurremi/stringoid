package mobi.ifunny.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import butterknife.ButterKnife;
import mobi.ifunny.rest.content.Feed;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.view.DynamicListView;
import mobi.ifunny.view.a;

public abstract class e<D, T extends Feed<D>>
        extends ContentAdapterFragment<D, T>
        implements AdapterView.OnItemClickListener, a {
    protected DynamicListView g;

    protected DynamicListView N() {
        return (DynamicListView) super.E();
    }

    public void O() {
        g(1);
    }

    public void P() {
        g(-1);
    }

    protected void a(int paramInt, T paramT) {
        boolean bool1 = true;
        boolean bool3 = true;
        boolean bool2 = true;
        super.a(paramInt, paramT);
        if (paramInt == 1) {
            this.g.a();
            if (paramT != null) {
                if (paramInt != 0) {
                    break label105;
                }
                paramT = this.g;
                if (B().hasNext()) {
                    break label95;
                }
                bool1 = true;
                label51:
                paramT.setInnerAdapterFilledAtEnd(bool1);
                paramT = this.g;
                if (B().hasPrev()) {
                    break label100;
                }
            }
        }
        label95:
        label100:
        for (bool1 = bool2; ; bool1 = false) {
            paramT.setInnerAdapterFilledAtStart(bool1);
            return;
            if (paramInt != -1) {
                break;
            }
            this.g.b();
            break;
            bool1 = false;
            break label51;
        }
        label105:
        if (paramInt == 1) {
            paramT = this.g;
            if (!B().hasNext()) {
            }
            for (; ; ) {
                paramT.setInnerAdapterFilledAtEnd(bool1);
                return;
                bool1 = false;
            }
        }
        paramT = this.g;
        if (!B().hasPrev()) {
        }
        for (bool1 = bool3; ; bool1 = false) {
            paramT.setInnerAdapterFilledAtStart(bool1);
            return;
        }
    }

    protected void a(T paramT) {
        boolean bool2 = true;
        super.a(paramT);
        if (B() != null) {
            paramT = this.g;
            if (B().hasNext()) {
                break label59;
            }
            bool1 = true;
            paramT.setInnerAdapterFilledAtEnd(bool1);
            paramT = this.g;
            if (B().hasPrev()) {
                break label64;
            }
        }
        label59:
        label64:
        for (boolean bool1 = bool2; ; bool1 = false) {
            paramT.setInnerAdapterFilledAtStart(bool1);
            return;
            bool1 = false;
            break;
        }
    }

    protected void a(boolean paramBoolean) {
        boolean bool = true;
        super.a(paramBoolean);
        DynamicListView localDynamicListView;
        if ((paramBoolean) && (B() != null)) {
            localDynamicListView = this.g;
            if (B().hasNext()) {
                break label63;
            }
            paramBoolean = true;
            localDynamicListView.setInnerAdapterFilledAtEnd(paramBoolean);
            localDynamicListView = this.g;
            if (B().hasPrev()) {
                break label68;
            }
        }
        label63:
        label68:
        for (paramBoolean = bool; ; paramBoolean = false) {
            localDynamicListView.setInnerAdapterFilledAtStart(paramBoolean);
            return;
            paramBoolean = false;
            break;
        }
    }

    protected boolean a(int paramInt, RestError paramRestError) {
        if (paramInt == 1) {
            this.g.a();
        }
        for (; ; ) {
            return super.a(paramInt, paramRestError);
            if (paramInt == -1) {
                this.g.b();
            }
        }
    }

    protected void d(int paramInt) {
        this.g.setSelectionOnItem(paramInt);
    }

    public void e() {
        super.e();
        this.g.a();
        this.g.b();
    }

    protected void e(int paramInt) {
        this.g.c(paramInt);
    }

    protected void j(int paramInt) {
        if (this.g != null) {
            if (paramInt != 1) {
                break label20;
            }
            this.g.a();
        }
        label20:
        while (paramInt != -1) {
            return;
        }
        this.g.b();
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        return paramLayoutInflater.inflate(2130903100, paramViewGroup, false);
    }

    public void onViewCreated(View paramView, Bundle paramBundle) {
        this.g = ((DynamicListView) ButterKnife.findById(paramView, 2131493012));
        a(this.g);
        this.g.setRequestAtLeastItemsAtEnd(o() / 2);
        this.g.setDynamicAdapterViewListener(this);
        this.g.setAutomaticRequestAtStart(true);
        this.g.setAutomaticRequestAtEnd(true);
        super.onViewCreated(paramView, paramBundle);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */