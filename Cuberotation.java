//main function
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import java.awt.Font;
import java.awt.Dimension;

public class Cuberotation{
    public static void main(String[] args){
        SimpleCanvas canvas = new SimpleCanvas(1000,1000,"3D Cube");
        canvas.show();
        JFrame frame =  canvas.getFrame();  
        frame.setLayout(new BorderLayout());

        JPanel sliderPanel = new JPanel();
        sliderPanel.setLayout(new BoxLayout(sliderPanel, BoxLayout.Y_AXIS));
        sliderPanel.setPreferredSize(new Dimension(450, 600));

        Font labelFont = new Font("Arial", Font.BOLD, 30);
        Font sliderFont = new Font("Arial", Font.PLAIN, 20);

        Dimension sliderSize = new Dimension(500, 80);

        // X
        JLabel xLabel = new JLabel("X Rotation");
        xLabel.setFont(labelFont);

        JSlider xSlider = new JSlider(-50, 50, 0);
        xSlider.setFont(sliderFont);
        xSlider.setMaximumSize(sliderSize);
        xSlider.setPaintTicks(true);
        xSlider.setPaintLabels(true);
        xSlider.setMajorTickSpacing(25);

        // Y
        JLabel yLabel = new JLabel("Y Rotation");
        yLabel.setFont(labelFont);

        JSlider ySlider = new JSlider(-50, 50, 0);
        ySlider.setFont(sliderFont);
        ySlider.setMaximumSize(sliderSize);
        ySlider.setPaintTicks(true);
        ySlider.setPaintLabels(true);
        ySlider.setMajorTickSpacing(25);

        // Z
        JLabel zLabel = new JLabel("Z Rotation");
        zLabel.setFont(labelFont);

        JSlider zSlider = new JSlider(-50, 50, 0);
        zSlider.setFont(sliderFont);
        zSlider.setMaximumSize(sliderSize);
        zSlider.setPaintTicks(true);
        zSlider.setPaintLabels(true);
        zSlider.setMajorTickSpacing(25);

        // Add components
        sliderPanel.add(xLabel);
        sliderPanel.add(xSlider);
        sliderPanel.add(yLabel);
        sliderPanel.add(ySlider);
        sliderPanel.add(zLabel);
        sliderPanel.add(zSlider);
        sliderPanel.setOpaque(false);

        frame.add(sliderPanel, BorderLayout.WEST);
        frame.pack();
        frame.setVisible(true);

        Cube cube = new Cube();
        double angleX = 0;
        double angleY = 0;
        double angleZ = 0;

        while (true) {

            canvas.clear();

            angleX += xSlider.getValue() * 0.001;
            angleY += ySlider.getValue() * 0.001;
            angleZ += zSlider.getValue() * 0.001;

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