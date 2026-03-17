public class Matrix {
    public double[][] m = new double[3][3];

    public Matrix(double[][] value){
        m = value;
    }

    public static Matrix rotateX(double angle){
        return new Matrix(new double[][]{
            {1, 0, 0},
            {0, Math.cos(angle), -Math.sin(angle)},
            {0, Math.sin(angle), Math.cos(angle)}
        });
    }

    public static Matrix rotateY(double angle){
        return new Matrix(new double[][]{
            {Math.cos(angle), 0, Math.sin(angle)},
            {0, 1, 0},
            {-Math.sin(angle), 0, Math.cos(angle)}
        });
    }

    public static Matrix rotateZ(double angle){
        return new Matrix(new double[][]{
            {Math.cos(angle), -Math.sin(angle), 0},
            {Math.sin(angle), Math.cos(angle), 0},
            {0, 0, 1}
        });
    }
}
