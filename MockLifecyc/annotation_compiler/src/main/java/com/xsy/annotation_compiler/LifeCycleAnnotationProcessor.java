package com.xsy.annotation_compiler;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import com.xsy.annotation.Lifecyce;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.LinkedHashSet;
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
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.security.auth.login.LoginException;
import javax.tools.Diagnostic;

@AutoService(Process.class)
public class LifeCycleAnnotationProcessor extends AbstractProcessor {

    private Elements mElementUtils;
    private Messager mMessager;
    private Filer mFiler;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        mElementUtils = processingEnv.getElementUtils();
        mMessager = processingEnv.getMessager();
        mFiler = processingEnv.getFiler();

    }

    int i =0;
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("======================process=============");
//        Set<? extends Element> sets = roundEnv.getElementsAnnotatedWith(Lifecyce.class);
//        for (Element annotatedElement : sets) {
//            TypeElement enclosingElement = (TypeElement) annotatedElement.getEnclosingElement();
//
//            if(!(annotatedElement instanceof ExecutableElement)
//                    || annotatedElement.getKind() != ElementKind.METHOD)
//            continue;
//
////            if(isInaccessible(annotatedElement, "method", Lifecyce.class))
////                continue;
////            TypeElement encloseingElement = (TypeElement) annotatedElement.getEnclosingElement();
////            TypeSpec finderClass = TypeSpec.classBuilder("MyGeneratedClass")
////                    .addModifiers(Modifier.PUBLIC)
////                    .build();
//
//        }
        if(i ==0) {
            ParameterSpec parameterSpec = ParameterSpec.builder(String.class, "str").build();
            MethodSpec methodSpec = MethodSpec.methodBuilder("sayHello")
                    .addParameter(parameterSpec)
                    .returns(TypeName.VOID)
                    .addModifiers(Modifier.PUBLIC)
                    .addStatement("$T.out.println($S)", System.class, "Hello World!")
                    .build();

            TypeSpec finderClass = TypeSpec.classBuilder("MyGeneratedClass")
                    .addMethod(methodSpec)
                    .addModifiers(Modifier.PUBLIC)
                    .build();

            // 创建Java文件
            JavaFile javaFile = JavaFile.builder("com.xsy.annotation", finderClass)
                    .build();
            try {
//                javaFile.writeTo(mFiler);
                javaFile.writeTo(this.processingEnv.getFiler());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        i++;
        return true;
    }

//    private boolean isInaccessible(Element element, String targetThing, Class<? extends Annotation> annotationClass) {
//
//        TypeElement enclosingElement = (TypeElement)element.getEnclosingElement();
//        Set<Modifier> modifiers = element.getModifiers();
//        if (modifiers.contains(Modifier.PRIVATE) || modifiers.contains(Modifier.STATIC)) {
//            this.error(element, "@%s %s must not be private or static. (%s.%s)", annotationClass.getSimpleName(), targetThing, enclosingElement.getQualifiedName(), element.getSimpleName());
//            return true;
//        }
//
//        if (enclosingElement.getKind() != ElementKind.CLASS) {
//            this.error(enclosingElement, "@%s %s may only be contained in classes. (%s.%s)", annotationClass.getSimpleName(), targetThing, enclosingElement.getQualifiedName(), element.getSimpleName());
//            return true;
//        }
//
//        if (enclosingElement.getModifiers().contains(Modifier.PRIVATE)) {
//            this.error(enclosingElement, "@%s %s may not be contained in private classes. (%s.%s)", annotationClass.getSimpleName(), targetThing, enclosingElement.getQualifiedName(), element.getSimpleName());
//            return true;
//        }
//
//        return false;
//    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> types = new LinkedHashSet<>();
        types.add(Lifecyce.class.getCanonicalName());
        return types;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.RELEASE_7;
    }

//    private void error(Element element, String message, Object... args) {
//        this.printMessage(Diagnostic.Kind.ERROR, element, message, args);
//    }
//
//    private void printMessage(Diagnostic.Kind kind, Element element, String message, Object[] args) {
//        if (args.length > 0) {
//            message = String.format(message, args);
//        }
//
//        this.processingEnv.getMessager().printMessage(kind, message, element);
//    }
}
