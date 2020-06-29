//package com.zorba.study.annotationProcessor;
//
//import com.google.auto.service.AutoService;
//
//import javax.annotation.processing.AbstractProcessor;
//import javax.annotation.processing.RoundEnvironment;
//import javax.lang.model.SourceVersion;
//import javax.lang.model.element.Element;
//import javax.lang.model.element.ElementKind;
//import javax.lang.model.element.Name;
//import javax.lang.model.element.TypeElement;
//import javax.tools.Diagnostic;
//import java.util.Set;
//
//// autoService를 이용해 processor 등록을 해준다.
//// 해당 라이브러리 사용없이는 build를 경로에서 주석처리하고 clean build 한 다음 다시 build 해주어야함
//@AutoService(Process.class)
//public class MagicHatProcessor extends AbstractProcessor {
//
//    @Override
//    public Set<String> getSupportedAnnotationTypes() {
//        return Set.of(Magic.class.getName());
//    }
//
//    @Override
//    public SourceVersion getSupportedSourceVersion() {
//        return SourceVersion.latestSupported();
//    }
//
//    @Override
//    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
//        Set<? extends Element> elements = roundEnvironment.getElementsAnnotatedWith(Magic.class);
//
//        for (Element element : elements) {
//            Name elementName = element.getSimpleName();
//            if (element.getKind() != ElementKind.INTERFACE) { // 어느 타입인지 알 수 있음
//                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Magic annotation can not be used on " + elementName);
//            } else {
//                processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Processing " + elementName);
//            }
//        }
//        return true;
//    }
//}
