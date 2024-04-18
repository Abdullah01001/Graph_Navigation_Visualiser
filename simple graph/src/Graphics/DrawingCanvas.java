package Graphics;

import Graph.Graph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class DrawingCanvas extends JPanel implements MouseListener , MouseMotionListener
{
    Graph graph;
    ArrayList<Button> verticesList;
    int size;
    public DrawingCanvas(Graph graph)
    {
        this.graph = graph;
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        size = 0;
        verticesList = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
            for (Button b : verticesList)
            {
                b.draw(g);
            }
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        graph.addVertex();
        verticesList.add(new Button(String.valueOf(size),new Point(e.getX(),e.getY()),Color.BLUE,size));
        size++;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        for(Button b : verticesList)
        {
            if(b.inCircle(e.getX(),e.getY()))
            {
                b.color = Color.BLACK;
            }
            else
            {
                b.color = Color.BLUE;
            }
        }
    }
}
