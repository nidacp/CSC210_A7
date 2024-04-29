import java.util.Collections;

public class SelectionSort {
  
  /**
   * Loops and searches through the unsorted list for its lowest element, moving it to the sorted list and repeating the process until unsorted is empty
   * @param unsorted  CardPile to be sorted
   * @param record    SortRecorder that records the piles visually
   * @return          CardPile in a sorted order
   */
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    // register the starting configuration with the recorder
    record.add(unsorted);

    // Here is the result list you will be creating
    CardPile sorted = new CardPile();
  
    // ***********************************************************
    // Here is where you'll do the "work" of SelectionSort:
    //   - Use sorted to store the "sorted portion"
    //   - Don't forget to register the new state with the
    //     recorder after each card is transferred:
    //        record.next();        // tell it this is a new step
    //        record.add(sorted);   // the sorted pile
    //        record.add(unsorted); // the unsorted pile
    // ***********************************************************

    while(!unsorted.isEmpty()) {
      Card smallest = unsorted.getFirst();
      for(Card x : unsorted) {
        // TO DO: double check how to compare
        if(x.compareTo(smallest)<0) {
          smallest=x;
        }
      }
      sorted.add(smallest);
      unsorted.remove(smallest);

      //COPY AND PASTED
      record.next();        // tell it this is a new step
      record.add(sorted);
      record.add(unsorted);
    }

    // scan through unsorted
      // remove smallest element from unsorted and add to tail of sorted

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

    // in your program, this would be a call to a real sorting algorithm
    cards = SelectionSort.sort(cards, recorder);

    // We can print out the (un)sorted result:
    System.out.println(cards);

    // make window appear showing the record
    recorder.display("Card Sort Demo: Selection Sort");
  }

}
