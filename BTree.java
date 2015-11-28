class BTree {
  public BNode root;
  private String graphViz;

  public BTree() {
    root = null;
  }

  public void insert(int value, int index) {
    if (root == null) {
      root = new BNode(value, index);
    }
    else {
      insert(root, value, index);
    }
  }

  public void insert(BNode node, int value, int index) {
    if (value <= node.value) {
      if (node.left == null) {
        node.left = new BNode(value, index);
      }
      else {
        insert(node.left, value, index);
      }
    }
    else {
      if (node.right == null) {
        node.right = new BNode(value, index);
      }
      else {
        insert(node.right, value, index);
      }
    }

  }

  public void insertAVL(int value, int index) {

    // IMPLEMENT THIS METHOD
    // IT WILL INSERT A NODE AND IF THE INSERTION
    // VIOLATES THE AVL CONDITION, THE METHOD WILL
    // BALANCE THE TREE

    insert(value,index);
    System.out.println("adding " + value);
    System.out.println(root);
    System.out.println(height(root));
    System.out.println(printGraphViz());
    AVLCheck();
    System.out.println();
    System.out.println(root);
    System.out.println(height(root));
    System.out.println(printGraphViz());
    System.out.println();
    System.out.println();

  }

  private void AVLCheck(){
    _AVLCheck(root);
  }

  private void _AVLCheck(BNode node) {

    if (node!=null) {
      if (root==node) {
        System.out.println("check root");
        if (node.left!=null){
          if (height(node.left.right)-1>height(node.left.left)){
            System.out.println("root double, left to right");
            BNode temp1 = node.left.right;
            BNode temp2 = node.left;
            node.left = temp1.right;
            temp1.right = node;
            temp2.right = temp1.left;
            temp1.left = temp2;
            root = temp1;

          } else if (height(node.left)-1>height(node.right)) {
            System.out.println("root single, left to right");
            BNode temp = node.left;
            node.left = temp.right;
            temp.right = node;
            root = temp;
          }
        }
        if (node.right!=null) {
          if (height(node.right.left)-1>height(node.right.right)) {
            System.out.println("root double, right to left");
            BNode temp1 = node.right.left;
            BNode temp2 = node.right;
            node.right = temp1.left;
            temp1.left = node;
            temp2.left = temp1.right;
            temp1.right = temp2;
            root = temp1;


          } else if (height(node.right)-1>height(node.left)) {
            System.out.println("root single, right to left");
            BNode temp = node.right;
            node.right = temp.left;
            temp.left = node;
            root = temp;
          }
        }
      }

      if (node.right!=null) {
        if (node.right.right!=null){
          if (height(node.right.right.left)-1>height(node.right.right)) {
            System.out.println("double, right to left");
            BNode temp1 = node.right.right.left;
            BNode temp2 = node.right.right;
            node.right.right = temp1.left;
            temp1.left = node.right;
            temp2.left = temp1.right;
            temp1.right = temp2;
            node.right = temp1;

          } else if (height(node.right.right)-1>height(node.right.left)) {
            System.out.println("single, right to left");
            BNode temp = node.right.right;
            node.right.right = temp.left;
            temp.left = node.right;
            node.right = temp;
          }
        }
      }
      if (node.left!=null) {
        if (node.left.right!=null){
          if (height(node.left.right.left)-1>height(node.left.right)) {
            System.out.println("double, right to left");
            BNode temp1 = node.left.right.left;
            BNode temp2 = node.left.right;
            node.left.right = temp1.left;
            temp1.left = node.left;
            temp2.left = temp1.right;
            temp1.right = temp2;
            node.left = temp1;
          } else if (height(node.left.right)-1>height(node.left.left)) {
            System.out.println("single, right to left");
            BNode temp = node.left.right;
            node.left.right = temp.left;
            temp.left = node.left;
            node.left = temp;
          }
        }
      }

    _AVLCheck(node.right);
    _AVLCheck(node.left);
    }
  }

  public int height(BNode node) {
    return _height(node);
  }

  private int _height(BNode node){
    if (node==null) return 0;
    int left = _height(node.left);
    int right = _height(node.right);
    if (left>=right) return left+1;
    else return right+1;
  }

  public String printGraphViz() {
    graphViz = "digraph G {\n";
    _printGraphViz(root);
    graphViz += "}";
    return graphViz;
  }

  private void _printGraphViz(BNode n) {
    if (n == null) return;

    if (n.left != null) {
      graphViz += (n.value + "->" + n.left.value + " [label=l];\n");
    }
    _printGraphViz(n.left);
    if (n.right != null) {
      graphViz += (n.value + "->" + n.right.value + " [label=r];\n");
    }
    _printGraphViz(n.right);
  }


  public void show() {
    show(root);
  }

  public void show(BNode node) {
    if (node != null) {
      show(node.left);
      System.out.println(node);
      show(node.right);
    }
  }
}
