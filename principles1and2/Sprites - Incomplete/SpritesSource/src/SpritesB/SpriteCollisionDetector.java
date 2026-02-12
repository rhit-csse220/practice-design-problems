package SpritesB;

import java.util.ArrayList;
import java.util.List;

public class SpriteCollisionDetector {
    public List<Sprite> sprites = new ArrayList<>();

    public void detectAllCollisions() {
        // pretend we checked
    }

    public void onHeroCollisionWithEnemy(Sprite enemy, Sprite hero) {
        hero.x = 0;
        enemy.x = 0;
    }

    public void onHeroCollisionWall(Sprite wall, Sprite hero) {
        hero.y = 0;
    }
}
