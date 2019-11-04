package javaConcurrencePractice.gui;

import javaConcurrencePractice.bean.MutablePoint;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 平面直角坐标系
 */
public class NumberAxis extends JPanel {
    private JFrame frame;
    private List<MutablePoint> points;

    public NumberAxis() {
    }

    public void setPoints(List<MutablePoint> points) {
        this.points = points;
        frame.repaint();
    }

    public static void main(String[] args) {
        List<MutablePoint> points = new ArrayList<>();
        points.add(new MutablePoint(10, 20));
        points.add(new MutablePoint(50, 440));
        points.add(new MutablePoint(300, 400));
        points.add(new MutablePoint(420, 430));
        points.add(new MutablePoint(120, 220));

        NumberAxis numberAxis = new NumberAxis();
        numberAxis.go(numberAxis);
    }

    public void go(NumberAxis numberAxis) {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.add(numberAxis);
        frame.setTitle("李俊的的平面直角坐标系(y = " + "x * x * x" + ")");
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Color[] color = {Color.blue, Color.red, Color.gray, Color.yellow, Color.black};
        int x, y;
        for (int i = 0; i < points.size(); i++) {
            g.setColor(color[i]);
            g.fillOval(points.get(i).x, points.get(i).y, 20, 20);
        }
    }


    private boolean isRight(double num1, double num2, double error) {
        //判断两个数字是否在误差允许范围
        return Math.abs(num1 - num2) <= error;
    }
}
