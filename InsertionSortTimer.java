public class InsertionSortTimer {

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
   * Loops through unsorted, taking the first element of unsorted and finds its place in the sorted
   * @param unsorted  CardPile to be sorted
   * @param record    SortRecorder that records the piles visually
   * @return          CardPile in a sorted order
   */
  public static CardPile sort(CardPile unsorted) {

      // Here is the result list you will be creating
      CardPile sorted = new CardPile();
      sorted.add(unsorted.remove());

      // ***********************************************************
      // Here is where you'll do the "work" of InsertionSort:
      //   - Use sorted to store the "sorted portion"
      //   - Don't forget to register the new state with the
      //     recorder after each card is transferred:

      // ***********************************************************

      while (!unsorted.isEmpty()) {
          Card insert = unsorted.removeFirst();
          int i = 0;
          while (i < sorted.size() && insert.compareTo(sorted.get(i)) > 0) {
              i++;
          }
          sorted.add(i, insert);
      }
      // return the sorted result here
      return sorted;
  }
}