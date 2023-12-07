import pygame
import sys
import random

# Initialize Pygame
pygame.init()

# Constants
WIDTH, HEIGHT = 800, 600
FPS = 60
GRAVITY = 0.5
JUMP_HEIGHT = 10
PIPE_WIDTH = 50
PIPE_HEIGHT = 300
PIPE_GAP = 200

# Colors
WHITE = (255, 255, 255)
GREEN = (0, 255, 0)

# Set up the display
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Flappy Bird")

# Load images
bird_img = pygame.image.load("bird.png")
pipe_img = pygame.image.load("pipe.png")

# Resize images
bird_img = pygame.transform.scale(bird_img, (50, 50))
pipe_img = pygame.transform.scale(pipe_img, (PIPE_WIDTH, PIPE_HEIGHT))

# Clock to control the frame rate
clock = pygame.time.Clock()

class Bird:
    def __init__(self):
        self.x = WIDTH // 4
        self.y = HEIGHT // 2
        self.velocity = 0

    def jump(self):
        self.velocity = -JUMP_HEIGHT

    def move(self):
        self.velocity += GRAVITY
        self.y += self.velocity

    def draw(self):
        screen.blit(bird_img, (self.x, self.y))

class Pipe:
    def __init__(self, x):
        self.x = x
        self.height = random.randint(50, HEIGHT - 150)

    def move(self):
        self.x -= 5

    def draw(self):
        screen.blit(pipe_img, (self.x, 0))
        screen.blit(pygame.transform.flip(pipe_img, False, True), (self.x, self.height + PIPE_GAP))

bird = Bird()
pipes = [Pipe(WIDTH + i * (WIDTH // 2)) for i in range(2)]

while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()
        elif event.type == pygame.KEYDOWN and event.key == pygame.K_SPACE:
            bird.jump()

    bird.move()

    if pipes[-1].x < WIDTH - WIDTH // 2:
        pipes.append(Pipe(WIDTH))

    for pipe in pipes:
        pipe.move()

        if bird.x + bird_img.get_width() > pipe.x and bird.x < pipe.x + PIPE_WIDTH:
            if bird.y < pipe.height or bird.y + bird_img.get_height() > pipe.height + PIPE_GAP:
                print("Game Over!")
                pygame.quit()
                sys.exit()

        if pipe.x + PIPE_WIDTH < 0:
            pipes.remove(pipe)

    screen.fill(WHITE)
    bird.draw()

    for pipe in pipes:
        pipe.draw()

    pygame.display.flip()
    clock.tick(FPS)
