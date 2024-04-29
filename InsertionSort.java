import java.util.Collections;

public class InsertionSort {
  
  /**
   * Loops through unsorted, taking the first element of unsorted and finds its place in the sorted
   * @param unsorted  CardPile to be sorted
   * @param record    SortRecorder that records the piles visually
   * @return          CardPile in a sorted order
   */
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    // register the starting configuration with the recorder
    //record.next();
    record.add(unsorted);

    // Here is the result list you will be creating
    CardPile sorted = new CardPile();
    sorted.add(unsorted.remove());
  
    // ***********************************************************
    // Here is where you'll do the "work" of InsertionSort:
    //   - Use sorted to store the "sorted portion"
    //   - Don't forget to register the new state with the
    //     recorder after each card is transferred:

    // ***********************************************************

    while(!unsorted.isEmpty()) {
      Card insert = unsorted.removeFirst();
      int i=0;
      while(i<sorted.size() && insert.compareTo(sorted.get(i))>0) {
        i++;
      }
      sorted.add(i, insert);
      record.next();
      record.add(sorted);
      record.add(unsorted);
    }



    /*while(!unsorted.isEmpty()) {
      //System.out.print("New run of while loop. ");
      // x.compareTo(y)<0 is the format of x being smaller than y
      Card  x= unsorted.removeFirst();
      System.out.println("Looking for a place for " + x.toString());
      for(int i=0; i<sorted.size(); i++) {
        Card y = sorted.get(i);
        //System.out.println("  For loop! i = " + i + ", Card y = " + y);
        if(x.compareTo(y)<0) {
          //System.out.println(" x is less than y, adding x.");
          sorted.add(i, x);
          record.next();
          record.add(sorted);
          record.add(unsorted);
          break;
        }
        if(i==sorted.size()-1 && x.compareTo(y)>0) {
          //System.out.println("  Last run, so x must be at the end.");
          sorted.addLast(x);
          record.next();
          record.add(sorted);
          record.add(unsorted);
        }
      }
    }
    */


    // return the sorted result here
    return sorted;
  }

  public static void main(String args[]) {

    // set up a class to record and display the sorting results
    SortRecorder recorder = new SortRecorder();

    // set up the deck of cards
    Card.loadImages(recorder);
    CardPile cards = new CardPile(Card.newDeck(true), 2, 2);

    // for debugging purposes, uncomment this to
    // work with a smaller number of cards:
    // cards = cards.split(cards.get(39));

    // mix up the cards
    Collections.shuffle(cards);

    // if you want to sort in array form, use:
    Card[] card_arr = cards.toArray(new Card[0]);


    //cards.split(cards.get(10));

    // in your program, this would be a call to a real sorting algorithm
    cards = InsertionSort.sort(cards, recorder);

    // We can print out the (un)sorted result:
    System.out.println(cards);

    // make window appear showing the record
    recorder.display("Card Sort Demo: InsertionSort");
  }

}

