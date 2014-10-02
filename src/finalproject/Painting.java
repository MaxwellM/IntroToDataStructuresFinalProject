package finalproject;

import javax.swing.*;
import java.awt.*;

/**
 * @author Maxwell Morin
 */
public class Painting extends JTextArea{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Node node;
    private boolean find;
    private double value;

    public Painting()
    {
        setBackground(Color.BLACK);
    }

    public void paintTree(Node root, boolean search, double value)
    {
        node = root;
        if(node == null){
            repaint();
            return;
        }
        find = search;
        int x = node.getProfundidad()+33;
        int y = (node.getProfundidad()*5)+123;
        
        System.out.println(x);
        
        this.setColumns(y);
        this.setRows(x);
        this.setText(" "+"\n");
        if(find){
            this.value = value;
            repaint();
            return;
        }
        repaint();
    }

    public void nodeFound(Node temp, Graphics g)
    {
        if(temp != null){
            nodeFound(temp.getChildLeft(), g);
            g.setColor(Color.WHITE);
            if(temp.getSide() != 0){
                g.drawLine(temp.getXLine()+15, temp.getYLine()+30, temp.getX()+15, temp.getY());
            }
            g.setColor(Color.WHITE);
            if(value == temp.getValue()){
                g.setColor(Color.GREEN);
            }
            g.fillOval(temp.getX(),temp.getY() , 30, 30);
            g.setColor(Color.RED);
            g.setFont(new Font("Arial",1,12));
            g.drawString(""+temp.getValue(), temp.getX()+5,temp.getY()+18);
            nodeFound(temp.getChildRight(), g);
        }
    }

    public void travel(Node temp, Graphics g)
    {
        
        if(temp != null){
            travel(temp.getChildLeft(), g);
            g.setColor(Color.WHITE);
            if(temp.getSide() != 0){
                g.drawLine(temp.getXLine()+15, temp.getYLine()+30, temp.getX()+15, temp.getY());
            }
            g.setColor(Color.WHITE);
            g.fillOval(temp.getX(),temp.getY() , 30, 30);
            g.setColor(Color.RED);
            g.setFont(new Font("Arial",1,12));
            g.drawString(""+temp.getValue(), temp.getX()+5,temp.getY()+18);
            travel(temp.getChildRight(), g);
        }
    }


    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        if(node == null){
            return;
        }
        if(find){
            nodeFound(node, g);
            find = false;
            return;
        }
        travel(node, g);
    }

}
