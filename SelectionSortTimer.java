public class SelectionSortTimer {
  /** Starts the program running */
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
   * Loops and searches through the unsorted list for its lowest element, moving it to the sorted list and repeating the process until unsorted is empty
   * @param unsorted  CardPile to be sorted
   * @param record    SortRecorder that records the piles visually
   * @return          CardPile in a sorted order
   */
  public static CardPile sort(CardPile unsorted) {

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

      while (!unsorted.isEmpty()) {
          Card smallest = unsorted.getFirst();
          for (Card x: unsorted) {
              // TO DO: double check how to compare
              if (x.compareTo(smallest) < 0) {
                  smallest = x;
              }
          }
          sorted.add(smallest);
          unsorted.remove(smallest);

      }

      // scan through unsorted
      // remove smallest element from unsorted and add to tail of sorted

      // return the sorted result here
      return sorted;
  }

}