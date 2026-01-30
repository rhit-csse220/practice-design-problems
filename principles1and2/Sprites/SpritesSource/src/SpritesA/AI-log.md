# SpiritesA log

## Versions 
Windsurf: 1.13.9
AI Used: GPT-5.2 Medium Reasoning

## Chat Prompts
### Prompt 1
You are a code generator. I will give you PlantUML for a deliberately BAD design.
Rules:
- Generate minimal Java that follows the UML EXACTLY, including the SAME class names, fields, and methods.
- Do NOT improve the design. Preserve the flaws (e.g., message chains, God classes, type switches).
- Use default package (or tell me how to put into package X if I say so).
- Keep methods tiny, just enough to compile and make the flaw obvious.
- Provide one simple Main class that exercises the flaw in 5–10 lines.

Here is the PlantUML:
@startuml
skinparam style strictuml

class Sprite {
   x
   y
   imageFile
}

class GameMain {
moveAll()
moveHero(hero:Sprite)
moveEnemy(enemy:Sprite)
detectAllCollisions()
onHeroCollisionWithEnemy(enemy:Sprite, hero:Sprite)
onHeroCollisionWall(wall:Sprite, hero:Sprite)
draw(anyting:Sprite)  
  }
GameMain -> "*" Sprite
@enduml

## Manual Edits

## Flaw Locations
