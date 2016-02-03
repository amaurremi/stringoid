package butterknife.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class ViewInjector {
    private final String className;
    private final String classPackage;
    private final Map<CollectionBinding, int[]> collectionBindings = new LinkedHashMap();
    private String parentInjector;
    private final String targetClass;
    private final Map<Integer, ViewInjection> viewIdMap = new LinkedHashMap();

    ViewInjector(String paramString1, String paramString2, String paramString3) {
        this.classPackage = paramString1;
        this.className = paramString2;
        this.targetClass = paramString3;
    }

    static void emitCastIfNeeded(StringBuilder paramStringBuilder, String paramString) {
        emitCastIfNeeded(paramStringBuilder, "android.view.View", paramString);
    }

    static void emitCastIfNeeded(StringBuilder paramStringBuilder, String paramString1, String paramString2) {
        if (!paramString1.equals(paramString2)) {
            paramStringBuilder.append('(').append(paramString2).append(") ");
        }
    }

    private void emitCollectionBinding(StringBuilder paramStringBuilder, CollectionBinding paramCollectionBinding, int[] paramArrayOfInt) {
        paramStringBuilder.append("    target.").append(paramCollectionBinding.getName()).append(" = ");
        int i;
        switch (ViewInjector
        .1.$SwitchMap$butterknife$internal$CollectionBinding$Kind[paramCollectionBinding.getKind().ordinal()])
        {
            default:
                throw new IllegalStateException("Unknown kind: " + paramCollectionBinding.getKind());
            case 1:
                paramStringBuilder.append("Finder.arrayOf(");
                i = 0;
                label92:
                if (i >= paramArrayOfInt.length) {
                    break label205;
                }
                if (i > 0) {
                    paramStringBuilder.append(',');
                }
                paramStringBuilder.append("\n        ");
                emitCastIfNeeded(paramStringBuilder, paramCollectionBinding.getType());
                if (paramCollectionBinding.isRequired()) {
                    paramStringBuilder.append("finder.findRequiredView(source, ").append(paramArrayOfInt[i]).append(", \"").append(paramCollectionBinding.getName()).append("\")");
                }
                break;
        }
        for (; ; ) {
            i += 1;
            break label92;
            paramStringBuilder.append("Finder.listOf(");
            break;
            paramStringBuilder.append("finder.findOptionalView(source, ").append(paramArrayOfInt[i]).append(")");
        }
        label205:
        paramStringBuilder.append("\n    );");
    }

    static void emitHumanDescription(StringBuilder paramStringBuilder, List<Binding> paramList) {
        int j;
        int i;
        switch (paramList.size()) {
            default:
                j = paramList.size();
                i = 0;
            case 1:
                while (i < j) {
                    Binding localBinding = (Binding) paramList.get(i);
                    if (i != 0) {
                        paramStringBuilder.append(", ");
                    }
                    if (i == j - 1) {
                        paramStringBuilder.append("and ");
                    }
                    paramStringBuilder.append(localBinding.getDescription());
                    i += 1;
                    continue;
                    paramStringBuilder.append(((Binding) paramList.get(0)).getDescription());
                }
                return;
        }
        paramStringBuilder.append(((Binding) paramList.get(0)).getDescription()).append(" and ").append(((Binding) paramList.get(1)).getDescription());
    }

    private void emitInject(StringBuilder paramStringBuilder) {
        paramStringBuilder.append("  public static void inject(Finder finder, final ").append(this.targetClass).append(" target, Object source) {\n");
        if (this.parentInjector != null) {
            paramStringBuilder.append("    ").append(this.parentInjector).append(".inject(finder, target, source);\n\n");
        }
        paramStringBuilder.append("    View view;\n");
        Iterator localIterator = this.viewIdMap.values().iterator();
        while (localIterator.hasNext()) {
            emitViewInjection(paramStringBuilder, (ViewInjection) localIterator.next());
        }
        localIterator = this.collectionBindings.entrySet().iterator();
        while (localIterator.hasNext()) {
            Map.Entry localEntry = (Map.Entry) localIterator.next();
            emitCollectionBinding(paramStringBuilder, (CollectionBinding) localEntry.getKey(), (int[]) localEntry.getValue());
        }
        paramStringBuilder.append("  }\n");
    }

    private void emitListenerBindings(StringBuilder paramStringBuilder, ViewInjection paramViewInjection) {
        Object localObject1 = paramViewInjection.getListenerBindings();
        if (((Map) localObject1).isEmpty()) {
            return;
        }
        boolean bool = paramViewInjection.getRequiredBindings().isEmpty();
        if (bool) {
            paramStringBuilder.append("    if (view != null) {\n");
        }
        for (paramViewInjection = "  "; ; paramViewInjection = "") {
            localObject1 = ((Map) localObject1).entrySet().iterator();
            while (((Iterator) localObject1).hasNext()) {
                Object localObject2 = (Map.Entry) ((Iterator) localObject1).next();
                Object localObject3 = (ListenerClass) ((Map.Entry) localObject2).getKey();
                localObject2 = (Map) ((Map.Entry) localObject2).getValue();
                if (!"android.view.View".equals(((ListenerClass) localObject3).targetType())) {
                }
                int j;
                for (int i = 1; ; i = 0) {
                    paramStringBuilder.append(paramViewInjection).append("    ");
                    if (i == 0) {
                        break label231;
                    }
                    paramStringBuilder.append("((").append(((ListenerClass) localObject3).targetType());
                    if (((ListenerClass) localObject3).genericArguments() <= 0) {
                        break label224;
                    }
                    paramStringBuilder.append('<');
                    j = 0;
                    while (j < ((ListenerClass) localObject3).genericArguments()) {
                        if (j > 0) {
                            paramStringBuilder.append(", ");
                        }
                        paramStringBuilder.append('?');
                        j += 1;
                    }
                }
                paramStringBuilder.append('>');
                label224:
                paramStringBuilder.append(") ");
                label231:
                paramStringBuilder.append("view");
                if (i != 0) {
                    paramStringBuilder.append(')');
                }
                paramStringBuilder.append('.').append(((ListenerClass) localObject3).setter()).append("(\n");
                paramStringBuilder.append(paramViewInjection).append("      new ").append(((ListenerClass) localObject3).type()).append("() {\n");
                localObject3 = getListenerMethods((ListenerClass) localObject3).iterator();
                if (((Iterator) localObject3).hasNext()) {
                    Object localObject4 = (ListenerMethod) ((Iterator) localObject3).next();
                    paramStringBuilder.append(paramViewInjection).append("        @Override public ").append(((ListenerMethod) localObject4).returnType()).append(' ').append(((ListenerMethod) localObject4).name()).append("(\n");
                    Object localObject5 = ((ListenerMethod) localObject4).parameters();
                    i = 0;
                    j = localObject5.length;
                    while (i < j) {
                        paramStringBuilder.append(paramViewInjection).append("          ").append(localObject5[i]).append(" p").append(i);
                        if (i < j - 1) {
                            paramStringBuilder.append(',');
                        }
                        paramStringBuilder.append('\n');
                        i += 1;
                    }
                    paramStringBuilder.append(paramViewInjection).append("        ) {\n");
                    paramStringBuilder.append(paramViewInjection).append("          ");
                    if (!"void".equals(((ListenerMethod) localObject4).returnType())) {
                    }
                    for (i = 1; ; i = 0) {
                        if (i != 0) {
                            paramStringBuilder.append("return ");
                        }
                        if (!((Map) localObject2).containsKey(localObject4)) {
                            break label690;
                        }
                        localObject5 = (ListenerBinding) ((Map) localObject2).get(localObject4);
                        paramStringBuilder.append("target.").append(((ListenerBinding) localObject5).getName()).append('(');
                        localObject5 = ((ListenerBinding) localObject5).getParameters();
                        localObject4 = ((ListenerMethod) localObject4).parameters();
                        j = ((List) localObject5).size();
                        i = 0;
                        while (i < j) {
                            Parameter localParameter = (Parameter) ((List) localObject5).get(i);
                            int k = localParameter.getListenerPosition();
                            emitCastIfNeeded(paramStringBuilder, localObject4[k], localParameter.getType());
                            paramStringBuilder.append('p').append(k);
                            if (i < j - 1) {
                                paramStringBuilder.append(", ");
                            }
                            i += 1;
                        }
                    }
                    paramStringBuilder.append(");");
                    for (; ; ) {
                        paramStringBuilder.append('\n');
                        paramStringBuilder.append(paramViewInjection).append("        }\n");
                        break;
                        label690:
                        if (i != 0) {
                            paramStringBuilder.append(((ListenerMethod) localObject4).defaultReturn()).append(';');
                        }
                    }
                }
                paramStringBuilder.append(paramViewInjection).append("      });\n");
            }
            if (!bool) {
                break;
            }
            paramStringBuilder.append("    }\n");
            return;
        }
    }

    private void emitReset(StringBuilder paramStringBuilder) {
        paramStringBuilder.append("  public static void reset(").append(this.targetClass).append(" target) {\n");
        if (this.parentInjector != null) {
            paramStringBuilder.append("    ").append(this.parentInjector).append(".reset(target);\n\n");
        }
        Iterator localIterator = this.viewIdMap.values().iterator();
        Object localObject;
        while (localIterator.hasNext()) {
            localObject = ((ViewInjection) localIterator.next()).getViewBindings().iterator();
            while (((Iterator) localObject).hasNext()) {
                ViewBinding localViewBinding = (ViewBinding) ((Iterator) localObject).next();
                paramStringBuilder.append("    target.").append(localViewBinding.getName()).append(" = null;\n");
            }
        }
        localIterator = this.collectionBindings.keySet().iterator();
        while (localIterator.hasNext()) {
            localObject = (CollectionBinding) localIterator.next();
            paramStringBuilder.append("    target.").append(((CollectionBinding) localObject).getName()).append(" = null;\n");
        }
        paramStringBuilder.append("  }\n");
    }

    private void emitViewBindings(StringBuilder paramStringBuilder, ViewInjection paramViewInjection) {
        paramViewInjection = paramViewInjection.getViewBindings();
        if (paramViewInjection.isEmpty()) {
        }
        for (; ; ) {
            return;
            paramViewInjection = paramViewInjection.iterator();
            while (paramViewInjection.hasNext()) {
                ViewBinding localViewBinding = (ViewBinding) paramViewInjection.next();
                paramStringBuilder.append("    target.").append(localViewBinding.getName()).append(" = ");
                emitCastIfNeeded(paramStringBuilder, localViewBinding.getType());
                paramStringBuilder.append("view;\n");
            }
        }
    }

    private void emitViewInjection(StringBuilder paramStringBuilder, ViewInjection paramViewInjection) {
        paramStringBuilder.append("    view = ");
        List localList = paramViewInjection.getRequiredBindings();
        if (localList.isEmpty()) {
            paramStringBuilder.append("finder.findOptionalView(source, ").append(paramViewInjection.getId()).append(");\n");
        }
        for (; ; ) {
            emitViewBindings(paramStringBuilder, paramViewInjection);
            emitListenerBindings(paramStringBuilder, paramViewInjection);
            return;
            paramStringBuilder.append("finder.findRequiredView(source, ").append(paramViewInjection.getId()).append(", \"");
            emitHumanDescription(paramStringBuilder, localList);
            paramStringBuilder.append("\");\n");
        }
    }

    static List<ListenerMethod> getListenerMethods(ListenerClass paramListenerClass) {
        if (paramListenerClass.method().length == 1) {
            return Arrays.asList(paramListenerClass.method());
        }
        ArrayList localArrayList;
        for (; ; ) {
            int i;
            ListenerMethod localListenerMethod;
            try {
                localArrayList = new ArrayList();
                paramListenerClass = paramListenerClass.callbacks();
                Enum[] arrayOfEnum = (Enum[]) paramListenerClass.getEnumConstants();
                int j = arrayOfEnum.length;
                i = 0;
                if (i >= j) {
                    break;
                }
                Enum localEnum = arrayOfEnum[i];
                localListenerMethod = (ListenerMethod) paramListenerClass.getField(localEnum.name()).getAnnotation(ListenerMethod.class);
                if (localListenerMethod == null) {
                    throw new IllegalStateException(String.format("@%s's %s.%s missing @%s annotation.", new Object[]{paramListenerClass.getEnclosingClass().getSimpleName(), paramListenerClass.getSimpleName(), localEnum.name(), ListenerMethod.class.getSimpleName()}));
                }
            } catch (NoSuchFieldException paramListenerClass) {
                throw new AssertionError(paramListenerClass);
            }
            localArrayList.add(localListenerMethod);
            i += 1;
        }
        return localArrayList;
    }

    private ViewInjection getOrCreateViewInjection(int paramInt) {
        ViewInjection localViewInjection2 = (ViewInjection) this.viewIdMap.get(Integer.valueOf(paramInt));
        ViewInjection localViewInjection1 = localViewInjection2;
        if (localViewInjection2 == null) {
            localViewInjection1 = new ViewInjection(paramInt);
            this.viewIdMap.put(Integer.valueOf(paramInt), localViewInjection1);
        }
        return localViewInjection1;
    }

    void addCollection(int[] paramArrayOfInt, CollectionBinding paramCollectionBinding) {
        this.collectionBindings.put(paramCollectionBinding, paramArrayOfInt);
    }

    boolean addListener(int paramInt, ListenerClass paramListenerClass, ListenerMethod paramListenerMethod, ListenerBinding paramListenerBinding) {
        ViewInjection localViewInjection = getOrCreateViewInjection(paramInt);
        if (localViewInjection.hasListenerBinding(paramListenerClass, paramListenerMethod)) {
            return false;
        }
        localViewInjection.addListenerBinding(paramListenerClass, paramListenerMethod, paramListenerBinding);
        return true;
    }

    void addView(int paramInt, ViewBinding paramViewBinding) {
        getOrCreateViewInjection(paramInt).addViewBinding(paramViewBinding);
    }

    String brewJava() {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("// Generated code from Butter Knife. Do not modify!\n");
        localStringBuilder.append("package ").append(this.classPackage).append(";\n\n");
        localStringBuilder.append("import android.view.View;\n");
        localStringBuilder.append("import butterknife.ButterKnife.Finder;\n\n");
        localStringBuilder.append("public class ").append(this.className).append(" {\n");
        emitInject(localStringBuilder);
        localStringBuilder.append('\n');
        emitReset(localStringBuilder);
        localStringBuilder.append("}\n");
        return localStringBuilder.toString();
    }

    String getFqcn() {
        return this.classPackage + "." + this.className;
    }

    void setParentInjector(String paramString) {
        this.parentInjector = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/butterknife/internal/ViewInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */