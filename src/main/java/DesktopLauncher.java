import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class DesktopLauncher {
    public static void main (String[] arg) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("Krono Idle");
        config.setWindowedMode(1200, 800);
        config.setResizable(false);
        new Lwjgl3Application(new KronoIdle(), config);
    }
}
