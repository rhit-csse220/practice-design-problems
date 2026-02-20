package SpritesB;

import java.util.ArrayList;
import java.util.List;

public class SpriteDrawer {
    public List<Sprite> sprites = new ArrayList<>();

    public void draw(Sprite anything) {
        System.out.println("Drawing " + anything.imageFile + " at (" + anything.x + "," + anything.y + ")");
    }
}
