package Graphics;

import Graph.Graph;
import Graph.Edge;

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
    int[] pair;
    boolean select;
    boolean added;
    boolean drag;
    public DrawingCanvas(Graph graph)
    {
        this.graph = graph;
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        setBackground(Color.lightGray);
        size = 0;
        verticesList = new ArrayList<>();
        select = false;
        added = true;
        drag = false;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
            for(Button b : verticesList)
            {
                ArrayList<Edge> edges = graph.adjacencyList.get(verticesList.indexOf(b));
                for (Edge e : edges)
                {
                    g.setColor(Color.BLACK);
                    g.drawLine(verticesList.get(e.src).point.x,verticesList.get(e.src).point.y,verticesList.get(e.destination).point.x,verticesList.get(e.destination).point.y);
                }
            }
            for (Button b : verticesList)
            {
                if(b.color == Color.red && !select)
                {
                    b.color = Color.BLUE;
                }
                b.draw(g);
            }
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        if(!drag)
        {
            if(verticesList.size() > 1)
            {
                for (Button b : verticesList)
                {
                    if(b.inCircle(e.getX(),e.getY()) && !select)
                    {
                        pair = new int[2];
                        pair[0] = verticesList.indexOf(b);
                        b.color = Color.red;
                        select = true;
                        added = false;
                    }
                    else if(b.inCircle(e.getX(),e.getY()) && select)
                    {
                        pair[1] = verticesList.indexOf(b);
                        graph.addEdge(pair[0],pair[1]);
                        added = true;
                    }
                }
                if(!select)
                {
                    graph.addVertex();
                    verticesList.add(new Button(String.valueOf(size),new Point(e.getX(),e.getY()),Color.BLUE,size));
                    size++;
                }
                if(added)
                {
                    select = false;
                }
            }
            else
            {
                graph.addVertex();
                verticesList.add(new Button(String.valueOf(size),new Point(e.getX(),e.getY()),Color.BLUE,size));
                size++;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        for (Button b : verticesList)
        {
            if (b.inCircle(e.getX(),e.getY()) && !drag)
            {
                b.pressed = true;
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        for (Button b : verticesList)
        {
            if(b.pressed)
            {
                b.pressed = false;
                drag = false;
            }
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        for (Button b : verticesList)
        {
            if(b.pressed)
            {
                b.setPoint(e.getX(),e.getY());
            }
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        for(Button b : verticesList)
        {
            if(b.inCircle(e.getX(),e.getY()) && !(b.color == Color.red))
            {
                b.color = Color.BLACK;
            }
            else
            {
                if(!(b.color == Color.red))
                {
                    b.color = Color.BLUE;
                }
            }
        }
    }
}
