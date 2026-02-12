package SpritesB;

import java.util.ArrayList;
import java.util.List;

public class SpriteMover {
    public List<Sprite> sprites = new ArrayList<>();

    public void moveAll() {
        for (Sprite s : sprites) {
            s.x += 1;
        }
    }

    public void moveHero(Sprite hero) {
        hero.x += 1;
    }

    public void moveEnemy(Sprite enemy) {
        enemy.x -= 1;
    }
}
