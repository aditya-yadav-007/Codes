import numpy as np
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D

def dxy_orbital(theta, phi):
    return np.sin(2*theta) * np.sin(phi)**2

def dyz_orbital(theta, phi):
    return np.sin(theta) * np.sin(2*phi)

def dz2_orbital(theta, phi):
    return np.cos(theta)**2

def dxz_orbital(theta, phi):
    return np.cos(theta) * np.sin(2*phi)

def dx2y2_orbital(theta, phi):
    return np.sin(2*theta) * np.cos(phi)**2

# Create a grid of points in spherical coordinates
theta = np.linspace(0, 2*np.pi, 100)
phi = np.linspace(0, np.pi, 100)
theta, phi = np.meshgrid(theta, phi)

# Convert spherical coordinates to Cartesian coordinates
x = np.sin(phi) * np.cos(theta)
y = np.sin(phi) * np.sin(theta)
z = np.cos(phi)

# Plot the 3D orbitals
fig = plt.figure(figsize=(15, 5))

# dxy orbital
ax1 = fig.add_subplot(151, projection='3d')
ax1.plot_surface(x, y, dxy_orbital(theta, phi), cmap='viridis', edgecolor='k')
ax1.set_title('dxy Orbital')

# dyz orbital
ax2 = fig.add_subplot(152, projection='3d')
ax2.plot_surface(x, y, dyz_orbital(theta, phi), cmap='viridis', edgecolor='k')
ax2.set_title('dyz Orbital')

# dz^2 orbital
ax3 = fig.add_subplot(153, projection='3d')
ax3.plot_surface(x, y, dz2_orbital(theta, phi), cmap='viridis', edgecolor='k')
ax3.set_title('dz^2 Orbital')

# dxz orbital
ax4 = fig.add_subplot(154, projection='3d')
ax4.plot_surface(x, y, dxz_orbital(theta, phi), cmap='viridis', edgecolor='k')
ax4.set_title('dxz Orbital')

# dx^2-y^2 orbital
ax5 = fig.add_subplot(155, projection='3d')
ax5.plot_surface(x, y, dx2y2_orbital(theta, phi), cmap='viridis', edgecolor='k')
ax5.set_title('dx^2-y^2 Orbital')

plt.show()
