package SpritesB;

public class GameMain {
    public SpriteMover mover = new SpriteMover();
    public SpriteCollisionDetector collisionDetector = new SpriteCollisionDetector();
    public SpriteDrawer drawer = new SpriteDrawer();

    public static void main(String[] args) {
        GameMain game = new GameMain();
        Sprite hero = new Sprite(); hero.imageFile = "hero.png";
        Sprite enemy = new Sprite(); enemy.imageFile = "enemy.png";
        Sprite wall = new Sprite(); wall.imageFile = "wall.png";
        game.mover.moveHero(hero);
        game.mover.moveEnemy(enemy);
        game.collisionDetector.onHeroCollisionWithEnemy(enemy, hero);
        game.collisionDetector.onHeroCollisionWall(wall, hero);
        game.drawer.draw(hero);
        game.drawer.draw(enemy);
    }
}