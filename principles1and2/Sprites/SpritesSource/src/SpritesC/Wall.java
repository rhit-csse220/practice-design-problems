package SpritesC;

public class Wall {
    private Sprite sprite = new Sprite();
 
    public void move() {
        sprite.x = sprite.x;
    }
 
    public void onCollisionWithHero(Hero hero) {
        hero.getSprite().y = 0;
    }
 
    public Sprite getSprite() {
        return sprite;
    }
}
