public class QuicksortTimer {
  public static void main(String args[]) {

      if (args.length < 1) {
          System.err.println("Please specify how many cards to sort!");
      } else {
          Card[] deck = Card.newDeck(true);
          CardPile cards = new CardPile();

          for (int i = 0; i < Integer.parseInt(args[0]); i++) {
              cards.add(deck[(int)(52 * Math.random())]);
          }

          sort(cards);

      }
  }

  /**
   * Takes the first card in unsorted, sorts all cards into < or >= piles, and then recursively sorts those piles.
   * @param unsorted  CardPile to be sorted
   * @param record    SortRecorder that records the piles visually
   * @return          CardPile in a sorted order
   */
  public static CardPile sort(CardPile unsorted) {

      // ***********************************************************
      // Here is where you'll check the stop condition and return
      // if it is satisfied.
      // ***********************************************************

      if (unsorted.size() <= 1) {
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

      for (int i = 0; i < unsorted.size(); i++) {
          Card x = unsorted.get(i);
          if (x.compareTo(pivot) < 0) {
              smaller.add(x);
          } else {
              bigger.add(x);
          }
      }

      result.append(sort(bigger));
      result.add(pivot);
      result.append(sort(smaller));

      // return the sorted result here
      return result;
  }
}