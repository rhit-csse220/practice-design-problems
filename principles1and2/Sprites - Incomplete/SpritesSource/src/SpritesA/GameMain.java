package SpritesA;

import java.util.List;

public class GameMain {
    private List<Sprite> sprites;
    private Sprite hero;
    private Sprite enemy;
    public void moveAll() {
        // Moves all the sprites manually, no method in Sprite to help
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
    public void detectAllCollisions() {
        // Checks all collisions manually, needs to grab data from sprite to function
        for (Sprite s : sprites) {
           if (s.x == hero.x && s.y == hero.y) {
                if (s == enemy) {
                    onHeroCollisionWithEnemy(s, hero);
                }
                else{
                    onHeroCollisionWall(s, hero);
                }
           }
        }
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
        //All the code is in the main method
        GameMain game = new GameMain();
        game.hero = new Sprite(); game.hero.imageFile = "hero.png";
        game.enemy = new Sprite(); game.enemy.imageFile = "enemy.png";
        Sprite wall = new Sprite(); wall.imageFile = "wall.png";
        game.moveHero(game.hero); game.moveEnemy(game.enemy);
        game.onHeroCollisionWithEnemy(game.enemy, game.hero); game.onHeroCollisionWall(wall, game.hero);
        game.draw(game.hero);
    }
}