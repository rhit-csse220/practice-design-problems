package SpritesC;

public class Enemy {
        private Sprite sprite = new Sprite();
 
    public void move() {
        sprite.x -= 1;
    }
 
    public void onCollisionWithHero(Hero hero) {
        hero.getSprite().x = 0;
        sprite.x = 0;
    }
 
    public Sprite getSprite() {
        return sprite;
    }
}
