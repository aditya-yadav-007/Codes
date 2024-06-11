import pygame
import sys
import random

# Initialize pygame
pygame.init()

# Set up display
width, height = 800, 600
screen = pygame.display.set_mode((width, height))
pygame.display.set_caption("Simple Shooter Game")

# Set up colors
white = (255, 255, 255)
black = (0, 0, 0)
red = (255, 0, 0)

# Set up player
player_size = 50
player_x = width // 2 - player_size // 2
player_y = height - 2 * player_size
player_speed = 15

# Set up bullet
bullet_size = 10
bullet_speed = 1
bullets = []

# Set up enemy
enemy_size = 50
enemy_speed = 3
enemies = []

# Set up clock
clock = pygame.time.Clock()

# Game loop
while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()

        # Player controls
        keys = pygame.key.get_pressed()
        if keys[pygame.K_LEFT] and player_x > 0:
            player_x -= player_speed
        if keys[pygame.K_RIGHT] and player_x < width - player_size:
            player_x += player_speed
        if keys[pygame.K_SPACE]:
            bullets.append([player_x + player_size // 2, player_y])

    # Update bullets
    for bullet in bullets:
        bullet[1] -= bullet_speed
        if bullet[1] < 0:
            bullets.remove(bullet)

    # Update enemies
    if random.randint(1, 30) == 1:
        enemies.append([random.randint(0, width - enemy_size), 0])

    for enemy in enemies:
        enemy[1] += enemy_speed
        if enemy[1] > height:
            enemies.remove(enemy)

    # Collision detection
    for bullet in bullets:
        for enemy in enemies:
            if (
                enemy[0] < bullet[0] < enemy[0] + enemy_size
                and enemy[1] < bullet[1] < enemy[1] + enemy_size
            ):
                bullets.remove(bullet)
                enemies.remove(enemy)

    # Draw everything
    screen.fill(white)

    pygame.draw.rect(screen, black, [player_x, player_y, player_size, player_size])
    for bullet in bullets:
        pygame.draw.circle(screen, red, bullet, bullet_size)
    for enemy in enemies:
        pygame.draw.rect(screen, red, [enemy[0], enemy[1], enemy_size, enemy_size])

    pygame.display.flip()

    # Control game speed
    clock.tick(30)
