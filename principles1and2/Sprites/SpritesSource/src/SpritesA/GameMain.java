package SpritesA;

import java.util.List;

public class GameMain {
    private List<Sprite> sprites;
    public void moveAll() {
        // Moves all the sprites manually, no method in Sprite to help
    }
    public void moveHero(Sprite hero) {
        hero.x += 1;
    }
    public void moveEnemy(Sprite enemy) {
        enemy.x -= 1;
    }
    public void detectAllCollisions() {
        // Checks all collisions manually, needs to grab data from sprite to function
    }
    public void onHeroCollisionWithEnemy(Sprite enemy, Sprite hero) {
        hero.x = 0;
        enemy.x = 0;
    }
    public void onHeroCollisionWall(Sprite wall, Sprite hero) {
        hero.y = 0;
    }
    public void draw(Sprite anyting) {
        System.out.println("Drawing " + anyting.imageFile + " at (" + anyting.x + "," + anyting.y + ")");
    }

    public static void main(String[] args) {
        GameMain game = new GameMain();
        Sprite hero = new Sprite(); hero.imageFile = "hero.png";
        Sprite enemy = new Sprite(); enemy.imageFile = "enemy.png";
        Sprite wall = new Sprite(); wall.imageFile = "wall.png";
        game.moveHero(hero); game.moveEnemy(enemy);
        game.onHeroCollisionWithEnemy(enemy, hero); game.onHeroCollisionWall(wall, hero);
        game.draw(hero);
    }
}