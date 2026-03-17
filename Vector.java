public class Vector{

    public double x, y, z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector multiply(Matrix m) {

        double nx = m.m[0][0]*x + m.m[0][1]*y + m.m[0][2]*z;
        double ny = m.m[1][0]*x + m.m[1][1]*y + m.m[1][2]*z;
        double nz = m.m[2][0]*x + m.m[2][1]*y + m.m[2][2]*z;

        return new Vector(nx, ny, nz);
    }
}