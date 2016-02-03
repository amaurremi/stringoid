package butterknife.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class ViewInjection {
    private final int id;
    private final Map<ListenerClass, Map<ListenerMethod, ListenerBinding>> listenerBindings = new LinkedHashMap();
    private final Set<ViewBinding> viewBindings = new LinkedHashSet();

    ViewInjection(int paramInt) {
        this.id = paramInt;
    }

    public void addListenerBinding(ListenerClass paramListenerClass, ListenerMethod paramListenerMethod, ListenerBinding paramListenerBinding) {
        Object localObject = (Map) this.listenerBindings.get(paramListenerClass);
        if (localObject == null) {
            localObject = new LinkedHashMap();
            this.listenerBindings.put(paramListenerClass, localObject);
        }
        for (; ; ) {
            ListenerBinding localListenerBinding = (ListenerBinding) ((Map) localObject).get(paramListenerMethod);
            if (localListenerBinding != null) {
                throw new IllegalStateException("View " + this.id + " already has listener binding for " + paramListenerClass.type() + "." + paramListenerMethod.name() + " on " + localListenerBinding.getDescription());
            }
            ((Map) localObject).put(paramListenerMethod, paramListenerBinding);
            return;
        }
    }

    public void addViewBinding(ViewBinding paramViewBinding) {
        this.viewBindings.add(paramViewBinding);
    }

    public int getId() {
        return this.id;
    }

    public Map<ListenerClass, Map<ListenerMethod, ListenerBinding>> getListenerBindings() {
        return this.listenerBindings;
    }

    public List<Binding> getRequiredBindings() {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.viewBindings.iterator();
        Object localObject;
        while (localIterator.hasNext()) {
            localObject = (ViewBinding) localIterator.next();
            if (((ViewBinding) localObject).isRequired()) {
                localArrayList.add(localObject);
            }
        }
        localIterator = this.listenerBindings.values().iterator();
        while (localIterator.hasNext()) {
            localObject = ((Map) localIterator.next()).values().iterator();
            while (((Iterator) localObject).hasNext()) {
                ListenerBinding localListenerBinding = (ListenerBinding) ((Iterator) localObject).next();
                if (localListenerBinding.isRequired()) {
                    localArrayList.add(localListenerBinding);
                }
            }
        }
        return localArrayList;
    }

    public Collection<ViewBinding> getViewBindings() {
        return this.viewBindings;
    }

    public boolean hasListenerBinding(ListenerClass paramListenerClass, ListenerMethod paramListenerMethod) {
        paramListenerClass = (Map) this.listenerBindings.get(paramListenerClass);
        return (paramListenerClass != null) && (paramListenerClass.containsKey(paramListenerMethod));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/butterknife/internal/ViewInjection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */