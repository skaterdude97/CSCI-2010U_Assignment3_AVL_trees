public class btSample {
  public static void main(String[] args) {

    int integerRange = 100;
    int streamLength = 10;
    int seed = 0;

    Stream stream = new Stream(integerRange, seed);  // 100 is the range of integers
    StreamProcessor processor = new StreamProcessor();


    for (int i=0; i<streamLength; ++i) {
      processor.consumeAVL(stream.getNext());
    }

    System.out.print(processor.graph());
    System.out.println();




    processor.show();
    int find = Integer.parseInt(args[0]);
    // int[] found =  processor.search(5);
    // System.out.println("5 is at " + found[0]);
    int found =  processor.at(find);
    System.out.println("index " + find +" is " + found);
    // found =  processor.search(55);
    // System.out.println("55 is at " + found[0]);
    // found =  processor.search(74);
    // System.out.println("74 is at " + found[0]);

  }
}
