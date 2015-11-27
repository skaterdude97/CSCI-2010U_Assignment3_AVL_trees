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

  public int search(int v) {
    return _search(v,storage.root,new int[5],0).index;
  }


  private int[] _search(int v, BNode node,int[] array, int pointer;) {
    System.out.println(v +  ", " +node);
    if (node!=null) {

      if (node.value == v) {
        if (pointer>=array.length) expandArray(array);

        array[pointer] =  node.index;
        pointer++;
        return _search(v, node.left, array,pointer);
      }

      if (v < node.value) return _search(v, node.left,array,pointer);

      if (v > node.value)  return _search(v, node.right,array,pointer);
    }

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

    // YOU NEED TO IMPLEMENT THIS METHOD

    return -1;
  }

  public void show() {
    storage.show();
  }
}
