package com.ibm.stringoid;

import com.ibm.wala.classLoader.JarFileModule;
import com.ibm.wala.dalvik.classLoader.DexIRFactory;
import com.ibm.wala.dalvik.util.AndroidAnalysisScope;
import com.ibm.wala.dalvik.util.AndroidEntryPointLocator;
import com.ibm.wala.ipa.callgraph.*;
import com.ibm.wala.ipa.callgraph.impl.Util;
import com.ibm.wala.ipa.callgraph.propagation.InstanceKey;
import com.ibm.wala.ipa.callgraph.propagation.PointerAnalysis;
import com.ibm.wala.ipa.callgraph.propagation.SSAPropagationCallGraphBuilder;
import com.ibm.wala.ipa.cha.ClassHierarchy;
import com.ibm.wala.ipa.cha.ClassHierarchyException;
import com.ibm.wala.ipa.cha.IClassHierarchy;
import com.ibm.wala.types.ClassLoaderReference;
import com.ibm.wala.util.CancelException;
import com.ibm.wala.util.MonitorUtil;
import com.ibm.wala.util.NullProgressMonitor;
import com.ibm.wala.util.collections.HashSetFactory;
import com.ibm.wala.util.collections.Pair;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Set;
import java.util.jar.JarFile;

public class WalaApkCallGraphBuilder {

    public static void main(String[] args) throws Exception {
        URI[] libs = new URI[] {
                WalaApkCallGraphBuilder.class.getClassLoader().getResource("androidJars/core.jar").toURI(),
                WalaApkCallGraphBuilder.class.getClassLoader().getResource("androidJars/framework.jar").toURI(),
                WalaApkCallGraphBuilder.class.getClassLoader().getResource("androidJars/framework2.jar").toURI(),
                WalaApkCallGraphBuilder.class.getClassLoader().getResource("androidJars/framework3.jar").toURI()
        };
        Pair<CallGraph, PointerAnalysis<InstanceKey>> pair = makeAPKCallGraph(
                libs,
                null,
                "/Users/mrapopo/IBM/stringoid/src/test/resources/cgeo.geocaching.developer-build.apk",
                new NullProgressMonitor(),
                AnalysisOptions.ReflectionOptions.NONE);

        System.out.println(pair.fst.toString());
    }

    public static Pair<CallGraph, PointerAnalysis<InstanceKey>> makeAPKCallGraph(
            URI[] androidLibs,
            File androidAPIJar,
            String apkFileName,
            MonitorUtil.IProgressMonitor monitor,
            AnalysisOptions.ReflectionOptions policy
    ) throws IOException, ClassHierarchyException, IllegalArgumentException, CancelException {
        AnalysisScope scope = makeDalvikScope(androidLibs, androidAPIJar, apkFileName);

        final IClassHierarchy cha = ClassHierarchy.make(scope);

        AnalysisCache cache = new AnalysisCache(new DexIRFactory());

        Set<AndroidEntryPointLocator.LocatorFlags> flags = HashSetFactory.make();
        flags.add(AndroidEntryPointLocator.LocatorFlags.INCLUDE_CALLBACKS);
        flags.add(AndroidEntryPointLocator.LocatorFlags.EP_HEURISTIC);
        flags.add(AndroidEntryPointLocator.LocatorFlags.CB_HEURISTIC);
        AndroidEntryPointLocator eps = new AndroidEntryPointLocator(flags);
        List<? extends Entrypoint> es = eps.getEntryPoints(cha);

        assert ! es.isEmpty();

        AnalysisOptions options = new AnalysisOptions(scope, es);
        options.setReflectionOptions(policy);

        // SSAPropagationCallGraphBuilder cgb = Util.makeZeroCFABuilder(options, cache, cha, scope, null, makeDefaultInterpreter(options, cache));
        SSAPropagationCallGraphBuilder cgb = Util.makeZeroCFABuilder(options, cache, cha, scope);

        CallGraph callGraph = cgb.makeCallGraph(options, monitor);

        PointerAnalysis<InstanceKey> ptrAnalysis = cgb.getPointerAnalysis();

        return Pair.make(callGraph, ptrAnalysis);
    }

    public static AnalysisScope makeDalvikScope(URI[] androidLibs, File androidAPIJar, String dexFileName) throws IOException {
        if (androidLibs != null) {
            return AndroidAnalysisScope.setUpAndroidAnalysisScope(
                    new File(dexFileName).toURI(),
                    "exclusions.txt",
                    WalaApkCallGraphBuilder.class.getClassLoader(),
                    androidLibs);

        } else {
            AnalysisScope scope = AndroidAnalysisScope.setUpAndroidAnalysisScope(
                    new File(dexFileName).toURI(),
                    "exclusions.txt",
                    WalaApkCallGraphBuilder.class.getClassLoader());

            if (androidAPIJar != null) {
                scope.addToScope(ClassLoaderReference.Primordial, new JarFileModule(new JarFile(androidAPIJar)));
            }

            return scope;
        }
    }
}
