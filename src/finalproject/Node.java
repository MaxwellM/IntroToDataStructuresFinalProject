package finalproject;

/**
 *
 * @author Maxwell Morin
 */

public class Node {

    private int depthRight;
    private int depthLeft;
    private double value;
    public Node childLeft;
    public Node childRight;
    public Node parent;
    private int xLine;
    private int yLine;
    private int scale;
    private int level;
    private int side;
    private int x;
    private int y;

    public Node(Node childLeft, Node childRight, Node parent, double value, int side, int profDer, int profIzq)
    {
        this.childRight = childRight;
        this.childLeft = childLeft;
        this.value = value;
        this.parent = parent;
        this.side = side;
        depthRight = profDer;
        depthLeft = profIzq;
        level = 0;
        scale = 70;
    }
    
    public Node(double x){
    	value = x;
    }

    public void setScale(int esc)
    {
        scale = esc;
    }
    
    public Node getParent(){
    	return this.parent;
    }

    public void setParent(Node parent)
    {
        this.parent = parent;
    }

    public void setSide(int side)
    {
        this.side = side;
    }

    public void setDepthLeft(int prof)
    {
        depthLeft = prof;
    }

    public void setDepthRight(int prof)
    {
        depthRight = prof;
    }

    public void setChildLeft(Node left)
    {
        childLeft = left;
    }

    public void setChildRight(Node right)
    {
        childRight = right;
    }

    public Node Parent()
    {
        return parent;
    }

    public Node getChildLeft()
    {
        return childLeft;
    }

    public Node getChildRight()
    {
        return childRight;
    }

    public double getValue()
    {
        return value;
    }

    public int getProfRight()
    {
        return depthRight;
    }

    public int getProfLeft()
    {
        return depthLeft;
    }

    public int getProfundidad()
    {
        if(depthRight >= depthLeft){
        	System.out.println(depthRight);
        }
        return depthLeft;
    }

    public int getSide()
    {
        return side;
    }
    /*
     * left = 1
     * right = -1
     * root = 0
     */

    public void setLevel(int niv)
    {
        level = niv;
    }

    public int getLevel()
    {
        return level;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getX()
    {
        return x;
    }
    public void setY(int y)
    {
        this.y = y;
    }

    public int getY()
    {
        return y;
    }

     public void setXLine(int xl)
    {
        xLine = xl;
    }

    public int getXLine()
    {
        return xLine;
    }
    public void setYLine(int yl)
    {
        yLine = yl;
    }

    public int getYLine()
    {
        return yLine;
    }

    public int getScale()
    {
        return scale;
    }
}