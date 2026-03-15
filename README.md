# Java 3D Rotation Demo

A simple 3D cube renderer written in Java that demonstrates
3D rotation using rotation matrices.

## Features

- Rotate cube around X, Y, Z axes
- Uses real 3D rotation matrices
- Perspective projection
- Keyboard controls

## Controls

X → rotate around x-axis

Y → rotate around y-axis

Z → rotate around z-axis

## Math

The cube is represented as a collection of 3D vertices.  
Each vertex has coordinates:

```
(x, y, z)
```

To rotate the cube, each vertex is multiplied by a rotation matrix.  


---

### Rotation Around the X-Axis

Rotating around the x-axis keeps the x coordinate the same while rotating the point in the y–z plane.

```
Rx(θ) =

[ 1    0       0   ]
[ 0   cosθ   -sinθ ]
[ 0   sinθ    cosθ ]
```

Applying the rotation:

```
[x']     [1      0        0] [x]
[y']  =  [0   cosθ   -sinθ] [y]
[z']     [0   sinθ    cosθ] [z]
```

---

### Rotation Around the Y-Axis

Rotating around the y-axis keeps the y coordinate fixed and rotates the point in the x–z plane.

```
Ry(θ) =

[  cosθ   0   sinθ ]
[   0     1    0   ]
[ -sinθ   0   cosθ ]
```

---

### Rotation Around the Z-Axis

Rotating around the z-axis keeps the z coordinate fixed and rotates the point in the x–y plane.

```
Rz(θ) =

[ cosθ  -sinθ   0 ]
[ sinθ   cosθ   0 ]
[  0       0    1 ]
```

---

### Combining Rotations

Multiple rotations can be applied by multiplying the matrices together.

For example:

```
R = Rz * Ry * Rx
```

Each vertex of the cube is multiplied by this rotation matrix every frame.

---

### Perspective Projection

//TODO

## Demo

![demo](docs/demo.gif)

## How to Run

//TODO