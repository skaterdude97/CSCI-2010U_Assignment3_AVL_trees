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
    
    // YOU NEED TO IMPLEMENT THIS METHOD

    return new int[1];
  }

  public int at(int i) {

    // YOU NEED TO IMPLEMENT THIS METHOD
    
    return -1;
  }

  public void show() {    
    storage.show();
  }
}