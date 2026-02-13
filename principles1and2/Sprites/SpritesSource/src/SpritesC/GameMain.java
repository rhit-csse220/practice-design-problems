package SpritesC;

import java.util.ArrayList;
import java.util.List;

public class GameMain {
    public Hero hero = new Hero();
    public List<Wall> walls = new ArrayList<>();
    public List<Enemy> enemies = new ArrayList<>();
 
    public void moveAll() {
        hero.move();
        for (Enemy e : enemies) e.move();
        for (Wall w : walls) w.move();
    }
 
    public void detectAllCollisions() {
        for (Enemy e : enemies) e.onCollisionWithHero(hero);
        for (Wall w : walls) w.onCollisionWithHero(hero);
    }
 
    public void draw(Sprite anyting) {
        System.out.println("Drawing " + anyting.imageFile + " at (" + anyting.x + "," + anyting.y + ")");
    }
 
    public static void main(String[] args) {
        GameMain game = new GameMain();
        game.hero.getSprite().imageFile = "hero.png";
        Enemy e = new Enemy(); e.getSprite().imageFile = "enemy.png";
        Wall w = new Wall(); w.getSprite().imageFile = "wall.png";
        game.enemies.add(e);
        game.walls.add(w);
        game.moveAll();
        game.detectAllCollisions();
        game.draw(game.hero.getSprite());
        game.draw(e.getSprite());
    }
}
