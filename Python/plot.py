import numpy as np
import matplotlib.pyplot as plt

# Define the equations
def line1(x):
    return (-x - 8) / 3

def line2(x):
    return 5 - 2*x

# Generate x values
x_values = np.linspace(-5, 5, 100)

# Plot the lines
plt.plot(x_values, line1(x_values), label='x + 3y + 8 = 0')
plt.plot(x_values, line2(x_values), label='2x + y = 5')

# Mark the point of intersection
intersection_point = (23/5, -21/5)
plt.scatter(*intersection_point, color='red', label='Intersection Point')

# Add labels and legend
plt.xlabel('x')
plt.ylabel('y')
plt.legend()

# Show the plot
plt.grid(True)
plt.axhline(0, color='black',linewidth=0.5)
plt.axvline(0, color='black',linewidth=0.5)
plt.show()
