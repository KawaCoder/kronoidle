import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;


public class KronoIdle extends com.badlogic.gdx.ApplicationAdapter {
    Texture backgroundPrehistoire;

    SpriteBatch spriteBatch;
    StretchViewport viewport;

    private Krono krono = new Krono();
    private BitmapFont font;
    private String kronoText = "0 Kr";


    @Override
    public void create () {
        spriteBatch = new SpriteBatch();
        viewport = new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        backgroundPrehistoire = new Texture("backprehistoire.png");
        System.out.println("Image width: " + backgroundPrehistoire.getWidth());
        System.out.println("Image height: " + backgroundPrehistoire.getHeight());
        font = new BitmapFont(Gdx.files.internal("kronofont.fnt"));
        krono.setActionListener(new ActionListener() {
            @Override
            public void onKronoChanged(int newKrono) {
                kronoText = newKrono + "Kr";
            }
        });
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
        spriteBatch.draw(
            backgroundPrehistoire,
            viewport.getCamera().position.x - viewport.getWorldWidth() / 2,
            viewport.getCamera().position.y - viewport.getWorldHeight() / 2,
            viewport.getWorldWidth(),
            viewport.getWorldHeight()
        );
        font.getData().setScale(0.5f); 
        font.draw(spriteBatch, kronoText, viewport.getWorldWidth() / 2 - 20, viewport.getWorldHeight() - 100);


        spriteBatch.end();
        
    }

    @Override
    public void resize (int width, int height) {
        viewport.update(width, height, true);
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
