package butterknife.internal;

import butterknife.InjectView;
import butterknife.InjectViews;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import butterknife.OnFocusChange;
import butterknife.OnItemClick;
import butterknife.OnItemLongClick;
import butterknife.OnItemSelected;
import butterknife.OnLongClick;
import butterknife.OnPageChange;
import butterknife.OnTextChanged;
import butterknife.OnTouch;
import butterknife.Optional;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic.Kind;
import javax.tools.JavaFileObject;

public final class ButterKnifeProcessor
        extends AbstractProcessor {
    public static final String ANDROID_PREFIX = "android.";
    public static final String JAVA_PREFIX = "java.";
    private static final List<Class<? extends Annotation>> LISTENERS;
    private static final String LIST_TYPE;
    public static final String SUFFIX = "$$ViewInjector";
    static final String VIEW_TYPE = "android.view.View";
    private Elements elementUtils;
    private Filer filer;
    private Types typeUtils;

    static {
        if (!ButterKnifeProcessor.class.desiredAssertionStatus()) {
        }
        for (boolean bool = true; ; bool = false) {
            $assertionsDisabled = bool;
            LIST_TYPE = List.class.getCanonicalName();
            LISTENERS = Arrays.asList(new Class[]{OnCheckedChanged.class, OnClick.class, OnEditorAction.class, OnFocusChange.class, OnItemClick.class, OnItemLongClick.class, OnItemSelected.class, OnLongClick.class, OnPageChange.class, OnTextChanged.class, OnTouch.class});
            return;
        }
    }

    private String doubleErasure(TypeMirror paramTypeMirror) {
        String str = this.typeUtils.erasure(paramTypeMirror).toString();
        int i = str.indexOf('<');
        paramTypeMirror = str;
        if (i != -1) {
            paramTypeMirror = str.substring(0, i);
        }
        return paramTypeMirror;
    }

    private void error(Element paramElement, String paramString, Object... paramVarArgs) {
        String str = paramString;
        if (paramVarArgs.length > 0) {
            str = String.format(paramString, paramVarArgs);
        }
        this.processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, str, paramElement);
    }

    private void findAndParseListener(RoundEnvironment paramRoundEnvironment, Class<? extends Annotation> paramClass, Map<TypeElement, ViewInjector> paramMap, Set<String> paramSet) {
        paramRoundEnvironment = paramRoundEnvironment.getElementsAnnotatedWith(paramClass).iterator();
        while (paramRoundEnvironment.hasNext()) {
            Element localElement = (Element) paramRoundEnvironment.next();
            try {
                parseListenerAnnotation(paramClass, localElement, paramMap, paramSet);
            } catch (Exception localException) {
                StringWriter localStringWriter = new StringWriter();
                localException.printStackTrace(new PrintWriter(localStringWriter));
                error(localElement, "Unable to generate view injector for @%s.\n\n%s", new Object[]{paramClass.getSimpleName(), localStringWriter.toString()});
            }
        }
    }

    private Map<TypeElement, ViewInjector> findAndParseTargets(RoundEnvironment paramRoundEnvironment) {
        LinkedHashMap localLinkedHashMap = new LinkedHashMap();
        LinkedHashSet localLinkedHashSet = new LinkedHashSet();
        Object localObject1 = paramRoundEnvironment.getElementsAnnotatedWith(InjectView.class).iterator();
        Object localObject2;
        StringWriter localStringWriter;
        while (((Iterator) localObject1).hasNext()) {
            localObject2 = (Element) ((Iterator) localObject1).next();
            try {
                parseInjectView((Element) localObject2, localLinkedHashMap, localLinkedHashSet);
            } catch (Exception localException1) {
                localStringWriter = new StringWriter();
                localException1.printStackTrace(new PrintWriter(localStringWriter));
                error((Element) localObject2, "Unable to generate view injector for @InjectView.\n\n%s", new Object[]{localStringWriter});
            }
        }
        localObject1 = paramRoundEnvironment.getElementsAnnotatedWith(InjectViews.class).iterator();
        while (((Iterator) localObject1).hasNext()) {
            localObject2 = (Element) ((Iterator) localObject1).next();
            try {
                parseInjectViews((Element) localObject2, localLinkedHashMap, localLinkedHashSet);
            } catch (Exception localException2) {
                localStringWriter = new StringWriter();
                localException2.printStackTrace(new PrintWriter(localStringWriter));
                error((Element) localObject2, "Unable to generate view injector for @InjectViews.\n\n%s", new Object[]{localStringWriter});
            }
        }
        localObject1 = LISTENERS.iterator();
        while (((Iterator) localObject1).hasNext()) {
            findAndParseListener(paramRoundEnvironment, (Class) ((Iterator) localObject1).next(), localLinkedHashMap, localLinkedHashSet);
        }
        paramRoundEnvironment = localLinkedHashMap.entrySet().iterator();
        while (paramRoundEnvironment.hasNext()) {
            localObject1 = (Map.Entry) paramRoundEnvironment.next();
            localObject2 = findParentFqcn((TypeElement) ((Map.Entry) localObject1).getKey(), localLinkedHashSet);
            if (localObject2 != null) {
                ((ViewInjector) ((Map.Entry) localObject1).getValue()).setParentInjector((String) localObject2 + "$$ViewInjector");
            }
        }
        return localLinkedHashMap;
    }

    private String findParentFqcn(TypeElement paramTypeElement, Set<String> paramSet) {
        for (; ; ) {
            paramTypeElement = paramTypeElement.getSuperclass();
            if (paramTypeElement.getKind() == TypeKind.NONE) {
                return null;
            }
            paramTypeElement = (TypeElement) ((DeclaredType) paramTypeElement).asElement();
            if (paramSet.contains(paramTypeElement.toString())) {
                paramSet = getPackageName(paramTypeElement);
                return paramSet + "." + getClassName(paramTypeElement, paramSet);
            }
        }
    }

    private static String getClassName(TypeElement paramTypeElement, String paramString) {
        int i = paramString.length();
        return paramTypeElement.getQualifiedName().toString().substring(i + 1).replace('.', '$');
    }

    private ViewInjector getOrCreateTargetClass(Map<TypeElement, ViewInjector> paramMap, TypeElement paramTypeElement) {
        Object localObject2 = (ViewInjector) paramMap.get(paramTypeElement);
        Object localObject1 = localObject2;
        if (localObject2 == null) {
            localObject1 = paramTypeElement.getQualifiedName().toString();
            localObject2 = getPackageName(paramTypeElement);
            localObject1 = new ViewInjector((String) localObject2, getClassName(paramTypeElement, (String) localObject2) + "$$ViewInjector", (String) localObject1);
            paramMap.put(paramTypeElement, localObject1);
        }
        return (ViewInjector) localObject1;
    }

    private String getPackageName(TypeElement paramTypeElement) {
        return this.elementUtils.getPackageOf(paramTypeElement).getQualifiedName().toString();
    }

    private boolean isBindingInWrongPackage(Class<? extends Annotation> paramClass, Element paramElement) {
        String str = ((TypeElement) paramElement.getEnclosingElement()).getQualifiedName().toString();
        if (str.startsWith("android.")) {
            error(paramElement, "@%s-annotated class incorrectly in Android framework package. (%s)", new Object[]{paramClass.getSimpleName(), str});
            return true;
        }
        if (str.startsWith("java.")) {
            error(paramElement, "@%s-annotated class incorrectly in Java framework package. (%s)", new Object[]{paramClass.getSimpleName(), str});
            return true;
        }
        return false;
    }

    private boolean isSubtypeOfType(TypeMirror paramTypeMirror, String paramString) {
        boolean bool2 = false;
        boolean bool1;
        if (paramString.equals(paramTypeMirror.toString())) {
            bool1 = true;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (!(paramTypeMirror instanceof DeclaredType));
            paramTypeMirror = (DeclaredType) paramTypeMirror;
            List localList = paramTypeMirror.getTypeArguments();
            if (localList.size() > 0) {
                StringBuilder localStringBuilder = new StringBuilder(paramTypeMirror.asElement().toString());
                localStringBuilder.append('<');
                int i = 0;
                while (i < localList.size()) {
                    if (i > 0) {
                        localStringBuilder.append(',');
                    }
                    localStringBuilder.append('?');
                    i += 1;
                }
                localStringBuilder.append('>');
                if (localStringBuilder.toString().equals(paramString)) {
                    return true;
                }
            }
            paramTypeMirror = paramTypeMirror.asElement();
            bool1 = bool2;
        } while (!(paramTypeMirror instanceof TypeElement));
        paramTypeMirror = (TypeElement) paramTypeMirror;
        if (isSubtypeOfType(paramTypeMirror.getSuperclass(), paramString)) {
            return true;
        }
        paramTypeMirror = paramTypeMirror.getInterfaces().iterator();
        do {
            bool1 = bool2;
            if (!paramTypeMirror.hasNext()) {
                break;
            }
        } while (!isSubtypeOfType((TypeMirror) paramTypeMirror.next(), paramString));
        return true;
    }

    private boolean isValidForGeneratedCode(Class<? extends Annotation> paramClass, String paramString, Element paramElement) {
        TypeElement localTypeElement = (TypeElement) paramElement.getEnclosingElement();
        Set localSet = paramElement.getModifiers();
        if ((localSet.contains(Modifier.PRIVATE)) || (localSet.contains(Modifier.STATIC))) {
            error(paramElement, "@%s %s must not be private or static. (%s.%s)", new Object[]{paramClass.getSimpleName(), paramString, localTypeElement.getQualifiedName(), paramElement.getSimpleName()});
        }
        for (boolean bool = true; ; bool = false) {
            if (localTypeElement.getKind() != ElementKind.CLASS) {
                error(localTypeElement, "@%s %s may only be contained in classes. (%s.%s)", new Object[]{paramClass.getSimpleName(), paramString, localTypeElement.getQualifiedName(), paramElement.getSimpleName()});
                bool = true;
            }
            if (localTypeElement.getModifiers().contains(Modifier.PRIVATE)) {
                error(localTypeElement, "@%s %s may not be contained in private classes. (%s.%s)", new Object[]{paramClass.getSimpleName(), paramString, localTypeElement.getQualifiedName(), paramElement.getSimpleName()});
                return true;
            }
            return bool;
        }
    }

    private void parseInjectView(Element paramElement, Map<TypeElement, ViewInjector> paramMap, Set<String> paramSet) {
        boolean bool2 = true;
        TypeElement localTypeElement = (TypeElement) paramElement.getEnclosingElement();
        Object localObject = paramElement.asType();
        if ((localObject instanceof TypeVariable)) {
            localObject = ((TypeVariable) localObject).getUpperBound();
        }
        for (; ; ) {
            if (!isSubtypeOfType((TypeMirror) localObject, "android.view.View")) {
                error(paramElement, "@InjectView fields must extend from View. (%s.%s)", new Object[]{localTypeElement.getQualifiedName(), paramElement.getSimpleName()});
            }
            int i;
            for (boolean bool1 = true; ; i = 0) {
                bool1 = bool1 | isValidForGeneratedCode(InjectView.class, "fields", paramElement) | isBindingInWrongPackage(InjectView.class, paramElement);
                if (paramElement.getAnnotation(InjectViews.class) != null) {
                    error(paramElement, "Only one of @InjectView and @InjectViews is allowed. (%s.%s)", new Object[]{localTypeElement.getQualifiedName(), paramElement.getSimpleName()});
                    bool1 = true;
                }
                if (bool1) {
                    return;
                }
                String str = paramElement.getSimpleName().toString();
                i = ((InjectView) paramElement.getAnnotation(InjectView.class)).value();
                localObject = ((TypeMirror) localObject).toString();
                if (paramElement.getAnnotation(Optional.class) == null) {
                }
                for (; ; ) {
                    getOrCreateTargetClass(paramMap, localTypeElement).addView(i, new ViewBinding(str, (String) localObject, bool2));
                    paramSet.add(localTypeElement.toString());
                    return;
                    bool2 = false;
                }
            }
        }
    }

    private void parseInjectViews(Element paramElement, Map<TypeElement, ViewInjector> paramMap, Set<String> paramSet) {
        CollectionBinding.Kind localKind = null;
        boolean bool = true;
        TypeElement localTypeElement = (TypeElement) paramElement.getEnclosingElement();
        Object localObject = paramElement.asType();
        String str = doubleErasure((TypeMirror) localObject);
        int i;
        if (((TypeMirror) localObject).getKind() == TypeKind.ARRAY) {
            localObject = ((ArrayType) localObject).getComponentType();
            localKind = CollectionBinding.Kind.ARRAY;
            i = 0;
            if (!(localObject instanceof TypeVariable)) {
                break label460;
            }
            localObject = ((TypeVariable) localObject).getUpperBound();
        }
        label460:
        for (; ; ) {
            int j = i;
            if (localObject != null) {
                j = i;
                if (!isSubtypeOfType((TypeMirror) localObject, "android.view.View")) {
                    error(paramElement, "@InjectViews type must extend from View. (%s.%s)", new Object[]{localTypeElement.getQualifiedName(), paramElement.getSimpleName()});
                    j = 1;
                }
            }
            if ((isValidForGeneratedCode(InjectViews.class, "fields", paramElement) | j | isBindingInWrongPackage(InjectViews.class, paramElement))) {
                return;
                if (LIST_TYPE.equals(str)) {
                    localObject = ((DeclaredType) localObject).getTypeArguments();
                    if (((List) localObject).size() != 1) {
                        error(paramElement, "@InjectViews List must have a generic component. (%s.%s)", new Object[]{localTypeElement.getQualifiedName(), paramElement.getSimpleName()});
                        localObject = null;
                    }
                    for (i = 1; ; i = 0) {
                        localKind = CollectionBinding.Kind.LIST;
                        break;
                        localObject = (TypeMirror) ((List) localObject).get(0);
                    }
                }
                error(paramElement, "@InjectViews must be a List or array. (%s.%s)", new Object[]{localTypeElement.getQualifiedName(), paramElement.getSimpleName()});
                localObject = null;
                i = 1;
                break;
            }
            str = paramElement.getSimpleName().toString();
            int[] arrayOfInt = ((InjectViews) paramElement.getAnnotation(InjectViews.class)).value();
            if (arrayOfInt.length == 0) {
                error(paramElement, "@InjectViews must specify at least one ID. (%s.%s)", new Object[]{localTypeElement.getQualifiedName(), paramElement.getSimpleName()});
                return;
            }
            assert (localObject != null);
            localObject = ((TypeMirror) localObject).toString();
            if (paramElement.getAnnotation(Optional.class) == null) {
            }
            for (; ; ) {
                getOrCreateTargetClass(paramMap, localTypeElement).addCollection(arrayOfInt, new CollectionBinding(str, (String) localObject, localKind, bool));
                paramSet.add(localTypeElement.toString());
                return;
                bool = false;
            }
        }
    }

    private void parseListenerAnnotation(Class<? extends Annotation> paramClass, Element paramElement, Map<TypeElement, ViewInjector> paramMap, Set<String> paramSet) {
        if ((!(paramElement instanceof ExecutableElement)) || (paramElement.getKind() != ElementKind.METHOD)) {
            throw new IllegalStateException(String.format("@%s annotation must be on a method.", new Object[]{paramClass.getSimpleName()}));
        }
        ExecutableElement localExecutableElement = (ExecutableElement) paramElement;
        TypeElement localTypeElement = (TypeElement) paramElement.getEnclosingElement();
        Object localObject1 = paramElement.getAnnotation(paramClass);
        Object localObject2 = paramClass.getDeclaredMethod("value", new Class[0]);
        if (((Method) localObject2).getReturnType() != int[].class) {
            throw new IllegalStateException(String.format("@%s annotation value() type not int[].", new Object[]{paramClass}));
        }
        int[] arrayOfInt = (int[]) ((Method) localObject2).invoke(localObject1, new Object[0]);
        String str = localExecutableElement.getSimpleName().toString();
        boolean bool;
        int i;
        int m;
        int k;
        if (paramElement.getAnnotation(Optional.class) == null) {
            bool = true;
            i = isValidForGeneratedCode(paramClass, "methods", paramElement) | isBindingInWrongPackage(paramClass, paramElement);
            localObject2 = new LinkedHashSet();
            m = arrayOfInt.length;
            k = 0;
            label197:
            if (k >= m) {
                break label290;
            }
            int n = arrayOfInt[k];
            if (((Set) localObject2).add(Integer.valueOf(n))) {
                break label1343;
            }
            error(paramElement, "@%s annotation for method contains duplicate ID %d. (%s.%s)", new Object[]{paramClass.getSimpleName(), Integer.valueOf(n), localTypeElement.getQualifiedName(), paramElement.getSimpleName()});
            i = 1;
        }
        label290:
        label1343:
        for (; ; ) {
            k += 1;
            break label197;
            bool = false;
            break;
            ListenerClass localListenerClass = (ListenerClass) paramClass.getAnnotation(ListenerClass.class);
            if (localListenerClass == null) {
                throw new IllegalStateException(String.format("No @%s defined on @%s.", new Object[]{ListenerClass.class.getSimpleName(), paramClass.getSimpleName()}));
            }
            localObject2 = localListenerClass.method();
            if (localObject2.length > 1) {
                throw new IllegalStateException(String.format("Multiple listener methods specified on @%s.", new Object[]{paramClass.getSimpleName()}));
            }
            if (localObject2.length == 1) {
                if (localListenerClass.callbacks() != ListenerClass.NONE.class) {
                    throw new IllegalStateException(String.format("Both method() and callback() defined on @%s.", new Object[]{paramClass.getSimpleName()}));
                }
                localObject1 = localObject2[0];
            }
            List localList;
            Object localObject3;
            do {
                localList = localExecutableElement.getParameters();
                if (localList.size() > ((ListenerMethod) localObject1).parameters().length) {
                    error(paramElement, "@%s methods can have at most %s parameter(s). (%s.%s)", new Object[]{paramClass.getSimpleName(), Integer.valueOf(((ListenerMethod) localObject1).parameters().length), localTypeElement.getQualifiedName(), paramElement.getSimpleName()});
                    i = 1;
                }
                localObject3 = localExecutableElement.getReturnType();
                localObject2 = localObject3;
                if ((localObject3 instanceof TypeVariable)) {
                    localObject2 = ((TypeVariable) localObject3).getUpperBound();
                }
                if (!((TypeMirror) localObject2).toString().equals(((ListenerMethod) localObject1).returnType())) {
                    error(paramElement, "@%s methods must have a '%s' return type. (%s.%s)", new Object[]{paramClass.getSimpleName(), ((ListenerMethod) localObject1).returnType(), localTypeElement.getQualifiedName(), paramElement.getSimpleName()});
                    i = 1;
                }
                if (i == 0) {
                    break;
                }
                return;
                localObject3 = (Enum) paramClass.getDeclaredMethod("callback", new Class[0]).invoke(localObject1, new Object[0]);
                localObject2 = (ListenerMethod) ((Enum) localObject3).getDeclaringClass().getField(((Enum) localObject3).name()).getAnnotation(ListenerMethod.class);
                localObject1 = localObject2;
            } while (localObject2 != null);
            throw new IllegalStateException(String.format("No @%s defined on @%s's %s.%s.", new Object[]{ListenerMethod.class.getSimpleName(), paramClass.getSimpleName(), ((Enum) localObject3).getDeclaringClass().getSimpleName(), ((Enum) localObject3).name()}));
            localObject2 = Parameter.NONE;
            int j;
            if (!localList.isEmpty()) {
                localObject3 = new Parameter[localList.size()];
                BitSet localBitSet = new BitSet(localList.size());
                String[] arrayOfString = ((ListenerMethod) localObject1).parameters();
                i = 0;
                while (i < localList.size()) {
                    TypeMirror localTypeMirror = ((VariableElement) localList.get(i)).asType();
                    localObject2 = localTypeMirror;
                    if ((localTypeMirror instanceof TypeVariable)) {
                        localObject2 = ((TypeVariable) localTypeMirror).getUpperBound();
                    }
                    k = 0;
                    if (k < arrayOfString.length) {
                        if (localBitSet.get(k)) {
                        }
                        while (!isSubtypeOfType((TypeMirror) localObject2, arrayOfString[k])) {
                            k += 1;
                            break;
                        }
                        localObject3[i] = new Parameter(k, ((TypeMirror) localObject2).toString());
                        localBitSet.set(k);
                    }
                    if (localObject3[i] == null) {
                        paramMap = new StringBuilder();
                        paramMap.append("Unable to match @").append(paramClass.getSimpleName()).append(" method arguments. (").append(localTypeElement.getQualifiedName()).append('.').append(paramElement.getSimpleName()).append(')');
                        j = 0;
                        if (j < localObject3.length) {
                            paramClass = localObject3[j];
                            paramMap.append("\n\n  Parameter #").append(j + 1).append(": ").append(((VariableElement) localList.get(j)).asType().toString()).append("\n    ");
                            if (paramClass == null) {
                                paramMap.append("did not match any listener parameters");
                            }
                            for (; ; ) {
                                j += 1;
                                break;
                                paramMap.append("matched listener parameter #").append(paramClass.getListenerPosition() + 1).append(": ").append(paramClass.getType());
                            }
                        }
                        paramMap.append("\n\nMethods may have up to ").append(((ListenerMethod) localObject1).parameters().length).append(" parameter(s):\n");
                        paramClass = ((ListenerMethod) localObject1).parameters();
                        k = paramClass.length;
                        j = 0;
                        while (j < k) {
                            paramElement = paramClass[j];
                            paramMap.append("\n  ").append(paramElement);
                            j += 1;
                        }
                        paramMap.append("\n\nThese may be listed in any order but will be searched for from top to bottom.");
                        error(localExecutableElement, paramMap.toString(), new Object[0]);
                        return;
                    }
                    j += 1;
                }
                localObject2 = localObject3;
            }
            for (; ; ) {
                localObject2 = new ListenerBinding(str, Arrays.asList((Object[]) localObject2), bool);
                paramMap = getOrCreateTargetClass(paramMap, localTypeElement);
                k = arrayOfInt.length;
                j = 0;
                while (j < k) {
                    m = arrayOfInt[j];
                    if (!paramMap.addListener(m, localListenerClass, (ListenerMethod) localObject1, (ListenerBinding) localObject2)) {
                        error(paramElement, "Multiple @%s methods declared for ID %s in %s.", new Object[]{paramClass.getSimpleName(), Integer.valueOf(m), localTypeElement.getQualifiedName()});
                        return;
                    }
                    j += 1;
                }
                paramSet.add(localTypeElement.toString());
                return;
            }
        }
    }

    public Set<String> getSupportedAnnotationTypes() {
        LinkedHashSet localLinkedHashSet = new LinkedHashSet();
        localLinkedHashSet.add(InjectView.class.getCanonicalName());
        localLinkedHashSet.add(InjectViews.class.getCanonicalName());
        Iterator localIterator = LISTENERS.iterator();
        while (localIterator.hasNext()) {
            localLinkedHashSet.add(((Class) localIterator.next()).getCanonicalName());
        }
        return localLinkedHashSet;
    }

    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    public void init(ProcessingEnvironment paramProcessingEnvironment) {
        try {
            super.init(paramProcessingEnvironment);
            this.elementUtils = paramProcessingEnvironment.getElementUtils();
            this.typeUtils = paramProcessingEnvironment.getTypeUtils();
            this.filer = paramProcessingEnvironment.getFiler();
            return;
        } finally {
            paramProcessingEnvironment =finally;
            throw paramProcessingEnvironment;
        }
    }

    public boolean process(Set<? extends TypeElement> paramSet, RoundEnvironment paramRoundEnvironment) {
        paramSet = findAndParseTargets(paramRoundEnvironment).entrySet().iterator();
        while (paramSet.hasNext()) {
            Object localObject = (Map.Entry) paramSet.next();
            paramRoundEnvironment = (TypeElement) ((Map.Entry) localObject).getKey();
            localObject = (ViewInjector) ((Map.Entry) localObject).getValue();
            try {
                Writer localWriter = this.filer.createSourceFile(((ViewInjector) localObject).getFqcn(), new Element[]{paramRoundEnvironment}).openWriter();
                localWriter.write(((ViewInjector) localObject).brewJava());
                localWriter.flush();
                localWriter.close();
            } catch (IOException localIOException) {
                error(paramRoundEnvironment, "Unable to write injector for type %s: %s", new Object[]{paramRoundEnvironment, localIOException.getMessage()});
            }
        }
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/butterknife/internal/ButterKnifeProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */