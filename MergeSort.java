import java.util.ArrayDeque;
import java.util.Collections;

public class MergeSort {
  
  /**
   * seperates elements of unsorted into seperate CardPiles and then sorts while merging them together.
   * @param unsorted  CardPile to be sorted
   * @param record    SortRecorder used to visualize card piles
   * @return          sorted CardPile
   */
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    ArrayDeque<CardPile> queue = new ArrayDeque<CardPile>();
  
    // ***********************************************************
    // Here is where you'll do the "work" of MergeSort:
    //   - Use queue to store the intermediate piles
    //   - Don't forget to register the new state with the
    //     recorder after each merge step:
    //        record.next();        // tell it this is a new step
    //        for (CardPile pile: queue) { // add all piles
    //           record.add(pile);
    //        }
    // ***********************************************************

    
    record.next();
    record.add(unsorted);
    for(int i=0; i<unsorted.size(); i++) {
      Card[] temp = {unsorted.get(i)};
      queue.add(new CardPile(temp, 0, 0));

      //COPY AND PASTED
      record.next();        // tell it this is a new step
      for (CardPile pile: queue) { // add all piles
        record.add(pile);
      }
    }

    while(queue.size()>1) {
      CardPile x = queue.removeFirst();
      CardPile y = queue.removeFirst();
      CardPile z = new CardPile();
      
      boolean finished=false;
      while(!finished) {
        Card xFirst = x.getFirst();
        Card yFirst = y.getFirst();
        // if x starts with the smaller number
        if(xFirst.compareTo(yFirst)<0) {
          // if xLast is smaller than yFirst, then append y to x
          if(x.getLast().compareTo(yFirst)<=0) {
            x.append(y);
            z.append(x);
            finished=true;
          }
          // else, add xFirst to z and remove xFirst
          else {
            z.add(x.removeFirst());
          }
        }
        // if y starts with the smaller or equal number
        else {
          // if xLast is smaller than yFirst, then append y to x
          if(y.getLast().compareTo(xFirst)<=0) {
            y.append(x);
            z.append(y);
            finished = true;
          }
        // else, add yFirst to z and remove y FIrst
        else {
            z.add(y.removeFirst());
          }
        }
      }

      if(x.isEmpty()) {
        z.append(y);
        finished=true;
      }
      if(y.isEmpty()) {
        z.append(x);
        finished=true;
      }

      if(finished==true) {
        queue.add(z);
        //COPY AND PASTED
        record.next();        // tell it this is a new step
        for (CardPile pile: queue) { // add all piles
          record.add(pile);
        }
      }
    }
    
    // return the sorted result here
    return queue.remove();
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
    cards = MergeSort.sort(cards, recorder);

    // We can print out the (un)sorted result:
    System.out.println(cards);

    // make window appear showing the record
    recorder.display("Card Sort Demo: MergeSort");
  }
}
