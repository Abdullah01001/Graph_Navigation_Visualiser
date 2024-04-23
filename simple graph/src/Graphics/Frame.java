package Graphics;

import Graph.Graph;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame
{
    public Frame(Graph graph)
    {
        DrawingCanvas canvas = new DrawingCanvas(graph);
        this.add(canvas);
        this.setSize(500,500);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(() ->
        {
            Graph graph = new Graph();
            new Frame(graph);
        });
    }
}
