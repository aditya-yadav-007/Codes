import numpy as np
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D

def f4_orbital(theta, phi):
    return np.sin(theta)**3 * np.cos(3*phi)

def f5_orbital(theta, phi):
    return np.sin(theta)**4 * np.cos(4*phi)

# Create a grid of points in spherical coordinates
theta = np.linspace(0, 2*np.pi, 100)
phi = np.linspace(0, np.pi, 100)
theta, phi = np.meshgrid(theta, phi)

# Convert spherical coordinates to Cartesian coordinates
x = np.sin(phi) * np.cos(theta)
y = np.sin(phi) * np.sin(theta)
z = np.cos(phi)

# Plot the 3D orbitals
fig = plt.figure(figsize=(12, 6))

# f4 orbital
ax1 = fig.add_subplot(121, projection='3d')
ax1.plot_surface(x, y, f4_orbital(theta, phi), cmap='viridis', edgecolor='k')
ax1.set_title('4f Orbital')

# f5 orbital
ax2 = fig.add_subplot(122, projection='3d')
ax2.plot_surface(x, y, f5_orbital(theta, phi), cmap='viridis', edgecolor='k')
ax2.set_title('5f Orbital')

plt.show()
