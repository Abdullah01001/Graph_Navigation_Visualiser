package Graphics;

import java.awt.*;

public class Button
{
    String name;
    Point point;
    Color color;
    int edge;
    final int RADIUS = 30;

    public Button(String name, Point point, Color color, int edge)
    {
        this.name = name;
        this.point = point;
        this.color = color;
        this.edge = edge;
    }

    public boolean inCircle(int x , int y)
    {
        return ((Math.pow((x - point.x) , 2) + Math.pow(y - point.y , 2)) <= Math.pow(RADIUS , 2));
    }

    public void draw(Graphics g)
    {
        g.setColor(color);
        g.fillOval((point.x - RADIUS/2) , (point.y - RADIUS/2) , RADIUS , RADIUS);
    }
}
