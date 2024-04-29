import java.util.Collections;

public class Quicksort {
  
  /**
   * Takes the first card in unsorted, sorts all cards into < or >= piles, and then recursively sorts those piles.
   * @param unsorted  CardPile to be sorted
   * @param record    SortRecorder that records the piles visually
   * @return          CardPile in a sorted order
   */
  public static CardPile sort(CardPile unsorted, SortRecorder record) {

    // ***********************************************************
    // Here is where you'll check the stop condition and return
    // if it is satisfied.
    // ***********************************************************
    
    if(unsorted.size()<=1) {
      return unsorted;
    }

    // Here are the two partitions you will be creating
    CardPile smaller = new CardPile();
    CardPile bigger = new CardPile();

    // ***********************************************************
    // Here is where you'll do the partition part of Quicksort:
    //   - Choose a pivot
    //   - Partition the unsorted list into two piles
    // ***********************************************************
    Card pivot = unsorted.removeFirst();
    
    // register the partitions with the recorder
    record.add(smaller);
    record.add(pivot);
    record.add(bigger);
    record.next();

    // This will hold the assembled result
    CardPile result = new CardPile();
    
    // ***********************************************************
    // Here is where you'll do the remaining work of Quicksort:
    //   - Make recursive calls on the partitions
    //   - Assemble the sorted results into a single pile
    // ***********************************************************
    
    /*
     * Quicksort on lists is a bit more straightforward than on arrays.  Like MergeSort, it's a recursive algorithm: the stop condition is a list with 0 or 1 elements, which is already sorted and can simply be returned.  For the recursive step, do the following:
 * Take the first element as the pivot.  (_Note: This works well unless the list is already sorted, but we'll ignore that detail._)
 * 
 * Pull the remaining elements off the list one at a time and append them to either of two new sublists: one for elements **less than the pivot** and one for elements **greater than or equal to the pivot**.
 * Recursively sort the two sublists, then glue the results back together with the pivot in the middle, and return that as the result.
     */

     for(int i=0; i<unsorted.size(); i++) {
      Card x = unsorted.get(i);
      if(x.compareTo(pivot)<0) {
        smaller.add(x);
      }
      else {
        bigger.add(x);
      }
     }

     result.append(sort(bigger, record));
     result.add(pivot);
     result.append(sort(smaller, record));

    // record the sorted result
    record.add(result);
    record.next();
    
    // return the sorted result here
    return result;
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
    cards = Quicksort.sort(cards, recorder);

    // We can print out the (un)sorted result:
    System.out.println(cards);

    // make window appear showing the record
    recorder.display("Card Sort Demo: Quick Sort");
  }

}