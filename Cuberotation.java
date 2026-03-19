//main function
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
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

        //Button panel
        JPanel buttoPanel = new JPanel();
        JButton button = new JButton("Reset");
        buttoPanel.add(Box.createVerticalStrut(200));
        buttoPanel.add(button);
        button.setPreferredSize(new Dimension(200,60));
        button.setFont(new Font("Arial", Font.BOLD, 24));
        buttoPanel.setOpaque(false);

        //Slider panel
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
        frame.add(buttoPanel, BorderLayout.EAST);
        frame.pack();
        frame.setVisible(true);

        Cube cube = new Cube();
        double angles[] = {0, 0, 0}; //[x,y,z]

        button.addActionListener(e -> {
            xSlider.setValue(0);
            ySlider.setValue(0);
            zSlider.setValue(0);

            angles[0] = 0;
            angles[1] = 0;
            angles[2] = 0;
        });

        while (true) {

            canvas.clear();

            angles[0] += xSlider.getValue() * 0.001;
            angles[1] += ySlider.getValue() * 0.001;
            angles[2] += zSlider.getValue() * 0.001;

            Matrix rx = Matrix.rotateX(angles[0]);
            Matrix ry = Matrix.rotateY(angles[1]);
            Matrix rz = Matrix.rotateZ(angles[2]);

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