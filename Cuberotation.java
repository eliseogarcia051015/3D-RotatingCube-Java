//main function
import java.awt.Color;
public class Cuberotation{
    public static void main(String[] args){
        SimpleCanvas canvas = new SimpleCanvas(1000, 1000, "3D Cube");
        canvas.show();

        Cube cube = new Cube();
        double angleX = 0;
        double angleY = 0;
        double angleZ = 0;
        while (true) {

            canvas.clear();

            angleX += 0.02;
            angleY += 0.015;
            angleZ += 0.01;

            Matrix rx = Matrix.rotateX(angleX);
            Matrix ry = Matrix.rotateY(angleY);
            Matrix rz = Matrix.rotateZ(angleZ);

            Vector[] projected = new Vector[cube.vertices.length];

            for (int i = 0; i < cube.vertices.length; i++) {

                Vector v = cube.vertices[i];
                Vector rotated = v.multiply(rx).multiply(ry).multiply(rz);

                double distance = 2;
                double scale = 200;

                double z = rotated.z + distance;

                int x2d = (int)(rotated.x * scale / z) + canvas.getWidth()/2;
                int y2d = (int)(rotated.y * scale / z) + canvas.getHeight()/2;

                projected[i] = new Vector(x2d, y2d, rotated.z);
            }

            canvas.setPenColor(Color.BLACK);

            for (int[] edge : cube.edges) {

                Vector v1 = projected[edge[0]];
                Vector v2 = projected[edge[1]];

                canvas.drawLine((int)v1.x, (int)v1.y, (int)v2.x, (int)v2.y);
            }

            canvas.update();
            canvas.pause(20);
        }
    }
}