package module8ReflectionSolid.Task_8_Annotation;

public class AnnotationTest {
    @Deprecated
    public static String old() {
        return "old";
    }
}

class callOld {
    public static void main(String[] args) {
        call();
    }
    @SuppressWarnings("deprecation")
    public static void call() {
        System.out.println(AnnotationTest.old());
    }
}