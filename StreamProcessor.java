class StreamProcessor{
  private int index;
  private BTree storage;

  // YOU MIGHT HAVE TO MODIF THIS CLASS BY ADDING NEW METHODS AND MEMBERS

  public StreamProcessor() {
    this.index = 0;
    this.storage = new BTree();
  }

  public void consume(int v)
  {
    storage.insert(v, index);
    index++;
  }

  public void consumeAVL(int v){
    storage.insertAVL(v, index);
    index++;
  }

  public int[] search(int v) {
    return _search(v,storage.root,new int[5],0);
  }


  private int[] _search(int v, BNode node,int[] array, int pointer) {
    if (node!=null) {

      if (node.value == v) {
        if (pointer>=array.length) expandArray(array);

        array[pointer] =  node.index;
        pointer++;
        ////System.out.println("found");
        return _search(v, node.left, array,pointer);
      }
      //System.out.println(node);

      if (v < node.value) return _search(v, node.left,array,pointer);

      if (v > node.value)  return _search(v, node.right,array,pointer);
    }
    array[pointer]=-1;
    if (pointer==0) return trimArray(array,1);
    return trimArray(array,pointer);


  }

  private int[] expandArray(int[]array) {
    int[] newArray = new int[array.length+5];
    for (int n = 0; n < array.length; n++)
      newArray[n] = array[n];
    return newArray;
  }

  private int[] trimArray (int[] array, int i) {
    int[] finalArray = new int[i];
    for (int n = i-1; n >=0; n--){
      finalArray[n] = array[n];
    }
    return finalArray;
  }

  public int at(int i) {
    BNode found = null;
    if (storage.root!= null) {
      found = _at(i, storage.root);
    }
    if (found!=null) return found.value;
    return -1;
  }

  private BNode _at(int i, BNode node) {
    if (node.index==i) return node;

    BNode search = null;

    if (node.left!=null) search = node.left;
    if (search!=null) return search;
    if (node.right!=null) search = node.right;
    if (search!=null) return search;

    return null;
  }

  public String graph() {
    return storage.printGraphViz();
  }

  public void show() {
    storage.show();
  }
}
