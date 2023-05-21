//package jme3test;
//
//import com.jme3.system.AppSettings;
//import com.jme3.testable.Testable;
//import com.jme3.testable.impl.JmeAppTest;
//import com.jme3.util.TestableExecutor;
//
//import java.lang.reflect.InvocationTargetException;
//
///**
// * Tests the new jme test api.
// *
// * @author pavl_g.
// */
//public class Launcher {
//    public static final String SIG_ALL = "ALL";
//    public static final String SIG_WATER_FILTERS = "WATER-FILTER";
//    public static final String PBR = "PBR";
//
//    public static final String[] signatures = new String[] {
//            SIG_ALL
//    };
//
//    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
//        AppSettings settings = new AppSettings(true);
//        settings.setRenderer(AppSettings.LWJGL_OPENGL2);
//        settings.setAudioRenderer(AppSettings.LWJGL_OPENAL);
//        TestableExecutor.getInstance().launch(new String[] {"jme3test"}, settings, signatures);
//    }
//}
