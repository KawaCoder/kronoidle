
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;

import javafx.scene.text.Text;


public class GameApp extends GameApplication {

    private Krono krono = new Krono();
    private Text kronoTexte;
    
    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(800);
        settings.setHeight(600);
        settings.setTitle("Krono Idle");
        settings.setVersion("0.0.1");
    }
    @Override
    protected void initUI() {
        kronoText = new Text("Krono : " + krono.getKrono());
        kronoText.setTranslateX(50);
        kronoText.setTranslateY(100);
        FXGL.getGameScene().addUINode(kronoText);
    }
    
}
