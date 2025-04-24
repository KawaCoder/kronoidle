import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import java.util.List;



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
    private List<Item> items;
    private Player player;
    private Cell<Image> clickImageCell;

    @Override
    public void create () {
        spriteBatch = new SpriteBatch();
        viewport = new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        // BACKGROUND
        backgroundPrehistoire = new Texture("backprehistoire.png");
        System.out.println("Image width: " + backgroundPrehistoire.getWidth());
        System.out.println("Image height: " + backgroundPrehistoire.getHeight());


        // FONT
        font = new BitmapFont(Gdx.files.internal("kronofont.fnt"));


        // ITEMS
        items = ItemLoader.loadItems();
        player = new Player();


        // KR COUNTER
        krono.setActionListener(new ActionListener() {
        /**
         * Method called when the Krono count changes.
         * 
         * @param newKrono the new Krono count.
         */
            @Override
            public void onKronoChanged(int newKrono) {
                kronoText = newKrono + "Kr";
            }
        });


        // BUTTON
        Texture buttonTexture = new Texture("buttonKrono1.png");
        clickImage = new Image(new TextureRegionDrawable(new TextureRegion(buttonTexture)));

        clickImage.addListener(new ClickListener() {
            /**
             * Called when the user clicks on the button.
             * 
             * @param event the event that triggered this call
             * @param x the x-coordinate of the click
             * @param y the y-coordinate of the click
             */
            
            @Override
            public void clicked(InputEvent event, float x, float y) {
                krono.addKrono(1);
            }
        });

        float initialSize = Math.min(viewport.getWorldWidth(), viewport.getWorldHeight()) * 0.25f;
        
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.setFillParent(true);
        table.row().padTop(30);
        table.add(clickImage).size(initialSize, initialSize).center();

        stage.addActor(table);
        clickImageCell = table.add(clickImage).size(initialSize, initialSize).expand().center();

        
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

        // BACKGROUND
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
        
        // Draw Krono counter
        font.getData().setScale(0.5f); 
        layout.setText(font, kronoText);
        float textX = (viewport.getWorldWidth() - layout.width) / 2;
        float textY = viewport.getWorldHeight() - 100;
        font.draw(spriteBatch, layout, textX, textY);

        // Draw items list
        float itemY = viewport.getWorldHeight() - 200;
        font.getData().setScale(0.4f);
        for (Item item : items) {
            String itemText = item.getName() + " - Cost: " + item.getCost() + " Kr (x" + player.getItemQuantity(item) + ")";
            layout.setText(font, itemText);
            font.draw(spriteBatch, layout, 50, itemY);
            itemY -= 40;
        }

        spriteBatch.end();
        
    }

    @Override
    public void resize (int width, int height) {
        viewport.update(width, height, true);
        stage.getViewport().update(width, height, true); // BACKGROUND resize
        float responsiveSize = Math.min(width, height) * 0.25f; // BUTTON resize
        if (clickImageCell != null) {
            clickImageCell.size(responsiveSize, responsiveSize);
            
        }

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
