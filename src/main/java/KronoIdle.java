import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;


public class KronoIdle extends com.badlogic.gdx.ApplicationAdapter {
    Texture backgroundPrehistoire;

    SpriteBatch spriteBatch;
    StretchViewport viewport;

    private KronoCounter krono = new KronoCounter();
    private BitmapFont font;
    private String kronoText = "0 Kr";
    private GlyphLayout layout = new GlyphLayout();
    private Image clickImage;
    private Stage stage;


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

        Texture buttonTexture = new Texture("buttonKrono1.png");
        clickImage = new Image(new TextureRegionDrawable(new TextureRegion(buttonTexture)));

        clickImage.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                krono.addKrono(1);
            }
        });

        float size = Math.min(viewport.getWorldWidth() * 0.25f, viewport.getWorldHeight() * 0.25f);
        
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.setFillParent(true);
        table.row().padTop(30);
        table.add(clickImage).size(size, size).center();



        stage.addActor(table);

    }

    @Override
    public void render () {
        input();
        logic();
        draw();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
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
        layout.setText(font, kronoText);
        float textX = (viewport.getWorldWidth() - layout.width) / 2;
        float textY = viewport.getWorldHeight() - 100;

        font.draw(spriteBatch, layout, textX, textY);



        spriteBatch.end();
        
    }

    @Override
    public void resize (int width, int height) {
        viewport.update(width, height, true);
        stage.getViewport().update(width, height, true);
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
