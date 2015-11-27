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

  public int[] search(int v) {
    return _search(v,storage.root,new int[5],0);
  }


  private int[] _search(int v, BNode node,int[] array, int pointer) {
    if (node!=null) {

      if (node.value == v) {
        if (pointer>=array.length) expandArray(array);

        array[pointer] =  node.index;
        pointer++;
        System.out.println("found");
        return _search(v, node.left, array,pointer);
      }
      System.out.println(node);

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
    if (storage.root!= null) {
      System.out.println("test");
      BNode found = _at(i,storage.root);
      System.out.println(found);
      if (found!=null) return found.value;
    }
    return -1;
  }

  private BNode _at(int i, BNode node) {
     System.out.println(node);

     if (node.left!= null) _at(i,node.left);
     if (node.right!=null) return _at(i,node.right);
     if (node.index==i){
       System.out.println("return");
       return node;
     }
     return node;
  }

  public void show() {
    storage.show();
  }
}
