import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class KronoIdle extends com.badlogic.gdx.ApplicationAdapter {
    Texture backgroundPrehistoire;

    SpriteBatch spriteBatch;
    FitViewport viewport;


    @Override
    public void create () {
        backgroundPrehistoire = new Texture(Gdx.files.internal("backprehistoire.png"));
    }

    @Override
    public void render () {
        input();
        logic();
        draw();
    }

    private void input() {
        
    }

    private void logic() {
        
    }

    private void draw() {
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        spriteBatch.begin();
        spriteBatch.draw(backgroundPrehistoire, 0, 0);
        spriteBatch.end();
        
    }

    @Override
    public void resize (int width, int height) {

    }

    @Override
    public void pause () {

    }

    @Override
    public void resume () {

    }

    @Override
    public void dispose () {
    }
}
