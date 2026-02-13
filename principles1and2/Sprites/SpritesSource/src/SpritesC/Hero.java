package SpritesC;

public class Hero {
     private Sprite sprite = new Sprite();
 
    public void move() {
        sprite.x += 1;
    }
 
    public Sprite getSprite() {
        return sprite;
    }
}
