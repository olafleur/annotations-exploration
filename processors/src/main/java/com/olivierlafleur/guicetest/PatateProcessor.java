package com.olivierlafleur.guicetest;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Set;

@SupportedAnnotationTypes("com.olivierlafleur.guicetest.Patate")
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class PatateProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for(Element element : roundEnv.getElementsAnnotatedWith(Patate.class)) {
            for(Element element1 : element.getEnclosedElements()) {
                System.out.println("Truc : " + element1.getSimpleName());
            }

            if (element.getKind() == ElementKind.CLASS) {
                TypeElement classElement = (TypeElement) element;
                PackageElement packageElement = (PackageElement) element.getEnclosingElement();
                try {
                    JavaFileObject jfo = processingEnv.getFiler().createSourceFile(classElement.getQualifiedName() + "Gne");
                    BufferedWriter bw = new BufferedWriter(jfo.openWriter());
                    bw.append("package ");
                    bw.append(packageElement.getQualifiedName());
                    bw.append(";");
                    bw.newLine();
                    bw.newLine();
                    bw.append("public class BillingServiceGne {}");
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }

        processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "PATATE !!");

        return true;
    }
}
