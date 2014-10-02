package finalproject;

/**
@author Dylan Lougee
 */

class ScapeGoatTree
{
    private Node root;
    private int n, q;
    private Interface anInterface;
 
    /* Constructor */    
    public ScapeGoatTree()
    {
        root = null;
        // size = 0
        n = 0;        
    }
    public ScapeGoatTree(Interface anInterface){
    	this.anInterface = anInterface;
    }
    public Node getRoot(){
    	return this.root;
    }
    /* Function to check if tree is empty */
    public boolean isEmpty()
    {
        return root == null;
    }
    /* Function to clear  tree */
    public void makeEmpty()
    {
        root = null;
        n = 0;
    }    
    /* Function to count number of nodes recursively */
    private int size(Node r)
    {
        if (r == null)
            return 0;
        else
        {
            int l = 1;
            l += size(r.getChildLeft());
            l += size(r.getChildRight());
            return l;
        }
    }
    /* Functions to search for an element */
    public boolean search(double val)
    {
        return search(root, val);
    }
    /* Function to search for an element recursively */
    private boolean search(Node r, double val)
    {
        boolean found = false;
        while ((r != null) && !found)
        {
            double rval = r.getValue();
            if (val < rval)
                r = r.getChildLeft();
            else if (val > rval)
                r = r.getChildRight();
            else
            {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }
    /* Function to return current size of tree */   
    public int size() 
    {
        return n;
    }
    /* Function for inorder traversal */
    public void inorder()
    {
        inorder(root);
    }
    private void inorder(Node r)
    {
        if (r != null)
        {
            inorder(r.getChildLeft());
            System.out.print(r.getValue() +" ");
            inorder(r.getChildRight());
        }
    }
    /* Function for preorder traversal */
    public void preorder()
    {
        preorder(root);
    }
    private void preorder(Node r)
    {
        if (r != null)
        {
            System.out.print(r.getValue() +" ");
            preorder(r.getChildLeft());             
            preorder(r.getChildRight());
        }
    }
    /* Function for postorder traversal */
    public void postorder()
    {
        postorder(root);
    }
    private void postorder(Node r)
    {
        if (r != null)
        {
            postorder(r.getChildLeft());             
            postorder(r.getChildRight());
            System.out.print(r.getValue() +" ");
        }
    }     
    private static final int log32(int q) 
    {
        final double log23 = 2.4663034623764317;
        return (int)Math.ceil(log23*Math.log(q));
    }
    /* Function to insert an element */
    public boolean add(double x) 
    {
        /* first do basic insertion keeping track of depth */
        Node u = new Node(x);
        double d = addWithDepth(u);
        if (d > log32(q)) {
            /* depth exceeded, find scapegoat */
            Node w = u.parent;
            while (3*size(w) <= 2*size(w.parent))
                w = w.parent;
            rebuild(w.parent);
        }
        return d >= 0;
    }
    /* Function to rebuild tree from node u */
    protected void rebuild(Node u) 
    {
        int ns = size(u);
        Node p = u.parent;
        Node[] a = new Node[ns];
        packIntoArray(u, a, 0);
        if (p == null) 
        {
            root = buildBalanced(a, 0, ns);
            root.parent = null;
        } 
        else if (p.getChildRight() == u) 
        {
            p.childRight = buildBalanced(a, 0, ns);
            p.childRight.parent = p;
        } 
        else 
        {
            p.childLeft = buildBalanced(a, 0, ns);
            p.childLeft.parent = p;
        }
    }
    /* Function to packIntoArray */
    protected int packIntoArray(Node u, Node[] a, int i) 
    {
        if (u == null) 
        {
            return i;
        }
        i = packIntoArray(u.getChildLeft(), a, i);
        a[i++] = u;
        return packIntoArray(u.getChildRight(), a, i);
    }
    /* Function to build balanced nodes */
    public Node buildBalanced(Node[] a, int i, int ns) 
    {
    	//For some reason getFunctions were returning nodes but I was getting an error.
    	//Left hand side not a variable???
    	//Although reluctantly I had to change the nodes attached to other nodes
    	//as public. - Dylan
        if (ns == 0)
            return null;
        int m = ns / 2;
        a[i + m].childLeft = buildBalanced(a, i, m);
        if (a[i + m].childLeft != null)
            a[i + m].childLeft.parent = a[i + m];
        a[i + m].childRight = buildBalanced(a, i + m + 1, ns - m - 1);
        if (a[i + m].childRight != null)
            a[i + m].childRight.parent = a[i + m];
        return a[i + m];
    }
    /* Function add with depth */
    public double addWithDepth(Node u) 
    {
        Node w = root;
        if (w == null) 
        {
            root = u;
            n++; 
            q++;
            return 0;
        }
        boolean done = false;
        int d = 0;
        do {
 
            if (u.getValue() < w.getValue()) 
            {
                if (w.childLeft == null) 
                {
                    w.childLeft = u;
                    u.parent = w;
                    done = true;
                } 
                else 
                {
                    w = w.childLeft;
                }
            } 
            else if (u.getValue() > w.getValue()) 
            {
                if (w.childRight == null) 
                {
                    w.childRight = u;
                    u.parent = w;
                    done = true;
                }
                w = w.childRight;
            } 
            else 
            {
                return -1;
            }
            d++;
        } while (!done);
        n++; 
        q++;
        return d;
    }
    public void Print(int x)
    {
        if(root == null){
            anInterface.print("THE TREE IS EMPTY");
            return;
        }
        if(x == 0){
            anInterface.print("IN ORDER:" + "\n");
            TourOrder(root);
        }
        if(x == 1){
            anInterface.print("PRE-ORDER:" + "\n");
            GoPreOrder(root);
        }
        if(x == 2){
            anInterface.print("POST-ORDER:" + "\n");
            VisitPostOrder(root);
        }

    }
    public void TourOrder(Node Root)
    {
        if (Root != null)
        {
            TourOrder(Root.getChildLeft());
            anInterface.print(Root.getValue() + "");
            TourOrder(Root.getChildRight());
        }
    }
    public void VisitPostOrder(Node Root)
    {
        if(Root != null)
        {
            VisitPostOrder(Root.getChildLeft());
            VisitPostOrder(Root.getChildRight());
            anInterface.print(Root.getValue() + "");
        }
    }
    public void GoPreOrder(Node Root)
    {
        if(Root != null)
        {
            anInterface.print(Root.getValue() + "");
            GoPreOrder(Root.getChildLeft());
            GoPreOrder(Root.getChildRight());
        }
    }
    public Node removeSearch(double value)
    {
        Node temp = root;
        while(temp != null)
        {
            if(temp.getValue() == value){
                return temp;
            }
            if(value > temp.getValue()){
                temp = temp.getChildRight();
            }else{
                temp = temp.getChildLeft();
            }
        }
        return null;
    }
    public void binarySearchTreeRemove(double value)
    {
        if(root == null){
            anInterface.error("THE TREE IS EMPTY");
            return;
        }
        Node delete = removeSearch(value);
        if(delete == null){
            anInterface.error("ERROR. THE NODE "+value+" DOES NOT EXIST.");
            return;
        }
        Node childLeft = delete.getChildLeft();
        Node childRight = delete.getChildRight();
        if(delete.Parent() != null){
            Node parent = delete.Parent();
            if(delete.getSide() == 1){
                if(childRight != null){
                    childRight.setParent(parent);
                    childRight.setSide(1);
                    parent.setChildLeft(childRight);
                    Node temp = parent;
                    while(temp != null)
                    {
                        if(temp.getChildLeft() != null){
                            temp = temp.getChildLeft();
                        }else{
                            break;
                        }
                    }
                    if(childLeft != null){
                        childLeft.setParent(temp);
                        temp.setChildLeft(childLeft);
                        adjustDepth(childLeft);
                        balance(childLeft);
                    }else{
                        temp.setChildLeft(null);
                        adjustDepth(temp);
                        balance(temp);
                    }
                }else{
                    if(childLeft != null){
                        childLeft.setParent(parent);
                        childLeft.setSide(1);
                        parent.setChildLeft(childLeft);
                        adjustDepth(childLeft);
                        balance(childLeft);
                    }else{
                        parent.setChildLeft(null);
                        adjustDepth(parent);
                        balance(parent);
                    }
                }
            }else{
                if(delete.getSide() == -1){
                    if(childLeft != null){
                        childLeft.setParent(parent);
                        childLeft.setSide(-1);
                        parent.setChildRight(childLeft);
                        Node temp = parent;
                        while(temp != null)
                        {
                            if(temp.getChildRight() != null){
                                temp = temp.getChildRight();
                            }else{
                                break;
                            }
                        }
                        if(childRight != null){
                            childRight.setParent(temp);
                            temp.setChildRight(childRight);
                            adjustDepth(childRight);
                            balance(childRight);
                        }else{
                            temp.setChildRight(null);
                            adjustDepth(temp);
                            balance(temp);
                        }
                    }else{
                        if(childRight != null){
                            childRight.setParent(parent);
                            childRight.setSide(-1);
                            parent.setChildRight(childRight);
                            adjustDepth(childRight);
                            balance(childRight);
                        }else{
                            parent.setChildRight(null);
                            adjustDepth(parent);
                            balance(parent);
                        }
                    }
                }
            }
        }else{
            if(childRight == null && childLeft == null){
                root = null;
                anInterface.error("THE NODE HAS BEEN REMOVED "+ value+".");
                anInterface.paintingTree(root);
                return;
            }
            if(childRight != null){
                root = childRight;
                root.setParent(null);
                root.setSide(0);
                Node temp = root;
                while(temp != null)
                {
                    if(temp.getChildLeft() != null){
                        temp = temp.getChildLeft();
                    }else{
                        break;
                    }
                }
                if(childLeft != null){
                    childLeft.setParent(temp);
                    temp.setChildLeft(childLeft);
                    adjustDepth(childLeft);
                    balance(childLeft);
                }else{
                    temp.setChildLeft(null);
                    adjustDepth(temp);
                    balance(temp);
                }
            }else{
                root = childLeft;
                root.setParent(null);
                root.setSide(0);
                adjustDepth(root);
                balance(root);
            }
        }
        anInterface.error("THE NODE HAS BEEN REMOVED "+ value+".");
        graphics();        
    }
    
    //The scapegoat tree delete that implements all the functions necessary
    //For using its delete function to perform this faster algorithm.
    public boolean delete(double x) {
        if (search(x)) {//If element exists
        	binarySearchTreeRemove(x); //Delete it
            if (2*n < q) {
                rebuild(root);//Rebuild
                q = n;
            }
            return true;//Removed
        }
        return false;//Not removed
    }
    public void graphics()
    {
        root.setLevel(0);
        levels(root.getChildLeft());
        levels(root.getChildRight());
        int x = 661;
        root.setX(x);
        root.setXLine(x);
        root.setY(10);
        root.setYLine(10);
        coordinates(root.getChildLeft());
        coordinates(root.getChildRight());
        anInterface.paintingTree(root);
    }
    public void levels(Node node)
    {
        if(node != null){
            node.setLevel(node.Parent().getLevel() + 1);
            levels(node.getChildLeft());
            levels(node.getChildRight());
        }
    }
    public void coordinates(Node node)
    {
        if(node != null){
            node.setXLine(node.Parent().getX());
            int esc = root.getScale();
            if(node.getSide() == -1){
                node.setX(node.Parent().getX() + ((esc*node.getProfundidad()) / node.getLevel()));
                node.setY(70 + (node.getLevel() * 60));
            }else{
                if(node.getSide() == 1){
                    node.setX(node.Parent().getX() - ((esc*node.getProfundidad()) / node.getLevel()));
                    node.setY(70 + (node.getLevel() * 60));
                }
            }

            node.setYLine(node.Parent().getY());
            coordinates(node.getChildLeft());
            coordinates(node.getChildRight());
        }
    }
    public void adjustDepth(Node node)
    {
        while(node != null)
        {
            if(node.getChildLeft() != null){
                node.setDepthLeft(node.getChildLeft().getProfundidad() + 1);
            }else{
                node.setDepthLeft(1);
            }
            if(node.getChildRight() != null){
                node.setDepthRight(node.getChildRight().getProfundidad() + 1);
            }else{
                node.setDepthRight(1);
            }
            if(node.Parent() != null){
                node = node.Parent();
            }else{
                break;
            }
        }
    }

    public void balance(Node node)
    {
        if(node == null){
            return;
        }
        int left = node.getProfLeft();
        int right = node.getProfRight();

        int difference = left - right;

        if(difference >= 2){
            if(node.getChildLeft() != null){
                if(node.getChildLeft().getProfRight() > node.getChildLeft().getProfLeft()){
                    DoubleRightRotation(node);
                }else{
                    rightRotation(node);
                }
            }else{
                rightRotation(node);
            }
        }
        if(difference <= -2){
            if(node.getChildRight() != null){
                if(node.getChildRight().getProfLeft() > node.getChildRight().getProfRight()){
                    DoubleLeftRotation(node);
                }else{
                    leftRotation(node);
                }
            }else{
                leftRotation(node);
            }
        }
        if(node.getValue() != root.getValue()){
            node = node.Parent();
            balance(node);
        }
    }
    public void rightRotation(Node node)
    {
        Node child = node.getChildLeft();
        if(node.Parent() != null){
            Node parent = node.Parent();
            if(node.getSide() == 1){
                child.setParent(parent);
                child.setSide(node.getSide());
                node.setChildLeft(null);
                if(child.getChildRight() != null){
                    node.setChildLeft(child.getChildRight());
                    node.getChildLeft().setSide(1);
                    node.getChildLeft().setParent(node);
                }
                parent.setChildLeft(child);
                node.setParent(child);
                node.setDepthLeft(1);
                node.setSide(-1);
                parent.getChildLeft().setChildRight(node);
            }else{
                if(node.getSide() == -1){
                    child.setParent(parent);
                    child.setSide(node.getSide());
                    node.setChildLeft(null);
                    if(child.getChildRight() != null){
                        node.setChildLeft(child.getChildRight());
                        node.getChildLeft().setSide(1);
                        node.getChildLeft().setParent(node);
                    }
                    parent.setChildRight(child);
                    node.setParent(child);
                    node.setDepthLeft(1);
                    node.setSide(-1);
                    parent.getChildRight().setChildRight(node);
                }
            }
        }else{
            Node temp = root;
            root = child;
            root.setSide(0);
            temp.setParent(root);
            temp.setChildLeft(null);
            if(child.getChildRight() != null){
                temp.setChildLeft(child.getChildRight());
                temp.getChildLeft().setSide(1);
                temp.getChildLeft().setParent(temp);
            }
            temp.setSide(-1);
            temp.setDepthLeft(1);
            root.setChildRight(temp);
            root.setParent(null);
        }
        adjustDepth(node);
    }
    public void DoubleLeftRotation(Node node)
    {
        Node child = node.getChildRight();
        Node temp = child.getChildLeft();
        if(temp.getChildRight() != null){
            child.setChildLeft(temp.getChildRight());
            child.getChildLeft().setParent(child);
            child.getChildLeft().setSide(1);
        }else{
            child.setChildLeft(null);
        }
        temp.setSide(-1);
        temp.setParent(node);
        temp.setChildRight(child);
        child.setParent(temp);
        node.setChildRight(temp);
        adjustDepth(child);
        leftRotation(node);
    }
    
    public void leftRotation(Node node)
    {
        Node child = node.getChildRight();
        if(node.Parent() != null){
            Node parent = node.Parent();
            if(node.getSide() == 1){
                child.setParent(parent);
                child.setSide(node.getSide());
                parent.setChildLeft(child);
                node.setChildRight(null);
                if(child.getChildLeft() != null){
                        node.setChildRight(child.getChildLeft());
                        node.getChildRight().setSide(-1);
                        node.getChildRight().setParent(node);
                    }
                node.setParent(child);
                node.setSide(1);
                node.setDepthRight(1);
                parent.getChildLeft().setChildLeft(node);
            }else{
                if(node.getSide() == -1){
                    child.setParent(parent);
                    child.setSide(node.getSide());
                    parent.setChildRight(child);
                    node.setChildRight(null);
                    if(child.getChildLeft() != null){
                        node.setChildRight(child.getChildLeft());
                        node.getChildRight().setSide(-1);
                        node.getChildRight().setParent(node);
                    }
                    node.setParent(child);
                    node.setDepthRight(1);
                    node.setSide(1);
                    parent.getChildRight().setChildLeft(node);
                }
            }
        }else{
            Node temp = root;
            temp.setChildRight(null);
            if(child.getChildLeft() != null){
                temp.setChildRight(child.getChildLeft());
                temp.getChildRight().setSide(-1);
                temp.getChildRight().setParent(temp);
            }
            root = child;
            root.setSide(0);
            temp.setParent(root);
            temp.setDepthRight(1);
            temp.setSide(1);
            root.setChildLeft(temp);
            root.setParent(null);
        }
        adjustDepth(node);
    }
    

    public void DoubleRightRotation(Node node)
    {
        Node child = node.getChildLeft();
        Node temp = child.getChildRight();
        if(temp.getChildLeft() != null){
            child.setChildRight(temp.getChildLeft());
            child.getChildRight().setParent(child);
            child.getChildRight().setSide(-1);
        }else{
            child.setChildRight(null);
        }
        temp.setSide(1);
        temp.setParent(node);
        temp.setChildLeft(child);
        child.setParent(temp);
        node.setChildLeft(temp);
        adjustDepth(child);
        rightRotation(node);
    }
    public void addRoot(double value)
    {
        root = new Node(null,null,null,value,0,1,1);
        root.setX(661);
        root.setXLine(661);
        root.setY(10);
        root.setYLine(10);
        graphics();
    }
    public void addNode(double value)
    {
        Node temp = root;
        if(search(value)){
            anInterface.error("ERROR. THE NODE IS NOT ADDED "+ value+" SINCE IT ALREADY EXISTS.");
            return;
        }
        if(root == null){
            addRoot(value);
            return;
        }

        while(temp != null)
        {
            if(value < temp.getValue()){
                if(temp.getChildLeft() != null){
                    temp = temp.getChildLeft();
                }else{
                    break;
                }
            }else{
                if(value > temp.getValue()){
                    if(temp.getChildRight() != null){
                        temp = temp.getChildRight();
                    }else{
                        break;
                    }
                }
             }
        }
        if(value < temp.getValue()){
            temp.setChildLeft(new Node(null, null, temp, value, 1, 1, 1));
            newDepth(temp.getChildLeft());
        }
        if(value > temp.getValue()){
            temp.setChildRight(new Node(null, null, temp, value, -1, 1, 1));
            newDepth(temp.getChildRight());
        }
        balance(temp);
        graphics();
        anInterface.error("ADDED NODE "+ value+".");
    }
    public void newDepth(Node node)
    {
        if(node.Parent() == null){
            return;
        }
        int side;
        while(node.Parent() != null)
        {
            side = node.getSide();
            node = node.Parent();
            if(side == 1){
                node.setDepthLeft(node.getChildLeft().getProfundidad() + 1);
            }else{
                if(side == -1){
                    node.setDepthRight(node.getChildRight().getProfundidad() + 1);
                }
            }
        }
    }
}