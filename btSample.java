public class btSample {
  public static void main(String[] args) {

    int integerRange = 100;
    int streamLength = 10;
    int seed = 0;

    Stream stream = new Stream(integerRange, 0);  // 100 is the range of integers
    StreamProcessor processor = new StreamProcessor();


    for (int i=0; i<streamLength; ++i) {
      processor.consume(stream.getNext());
    }

    processor.show();
    int find = 10;
    // int[] found =  processor.search(5);
    // System.out.println("5 is at " + found[0]);
    int found =  processor.search(find);
    System.out.println(find +" is at " + found);
    // found =  processor.search(55);
    // System.out.println("55 is at " + found[0]);
    // found =  processor.search(74);
    // System.out.println("74 is at " + found[0]);

  }
}
