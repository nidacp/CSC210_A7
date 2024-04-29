import java.util.ArrayDeque;

public class MergeSortTimer {
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
     * seperates elements of unsorted into seperate CardPiles and then sorts while merging them together.
     * @param unsorted  CardPile to be sorted
     * @param record    SortRecorder used to visualize card piles
     * @return          sorted CardPile
     */
    public static CardPile sort(CardPile unsorted) {

        ArrayDeque < CardPile > queue = new ArrayDeque < CardPile > ();

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

        for (int i = 0; i < unsorted.size(); i++) {
            Card[] temp = {
                unsorted.get(i)
            };
            queue.add(new CardPile(temp, 0, 0));
        }

        while (queue.size() > 1) {
            CardPile x = queue.removeFirst();
            CardPile y = queue.removeFirst();
            CardPile z = new CardPile();

            boolean finished = false;
            while (!finished) {
                Card xFirst = x.getFirst();
                Card yFirst = y.getFirst();
                // if x starts with the smaller number
                if (xFirst.compareTo(yFirst) < 0) {
                    // if xLast is smaller than yFirst, then append y to x
                    if (x.getLast().compareTo(yFirst) <= 0) {
                        x.append(y);
                        z.append(x);
                        finished = true;
                    }
                    // else, add xFirst to z and remove xFirst
                    else {
                        z.add(x.removeFirst());
                    }
                }
                // if y starts with the smaller or equal number
                else {
                    // if xLast is smaller than yFirst, then append y to x
                    if (y.getLast().compareTo(xFirst) <= 0) {
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

            if (x.isEmpty()) {
                z.append(y);
                finished = true;
            }
            if (y.isEmpty()) {
                z.append(x);
                finished = true;
            }

            if (finished == true) {
                queue.add(z);
            }
        }

        // return the sorted result here
        return queue.remove();
  }
}