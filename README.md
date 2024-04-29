# A7 Card Sorting

# Your readme should include the following information. Each student needs to submit all of this information themselves, even when pair programming. 

Programming Partner Name: n/a

Other Collaborators (and kudos to helpful members of the class): n/a

If you have a selfie of your TA Hours Study Group, include it here!

Any references used besides JavaDoc and course materials: n/a

TIMES:

    Quicksort: 10,000 cards = 1.70s user 0.15s system 175% cpu 1.053 total, 20,000 cards = 2.61s user 0.32s system 130% cpu 2.251 total, 40,000 cards = 6.67s user 0.29s system 110% cpu 6.312 total, 80,000 cards = 37.71s user 0.66s system 99% cpu 38.662 total, 160,0000 cards = 237.04s user 1.41s system 96% cpu 4:06.99 total.

    InsertionSort: 10,000 cards = 147.87s user 0.60s system 96% cpu 2:34.29 total

    SelectionSort: 10,000 cards = 1.44s user 0.11s system 163% cpu 0.946 total, 20,000 cards = 2.45s user 0.11s system 131% cpu 1.949 total, 40,000 cards = 6.39s user 0.15s system 105% cpu 6.222 total, 80,000 cards = 21.79s user 0.22s system 100% cpu 21.820 total, 160,000 cards = 99.49s user 0.73s system 97% cpu 1:42.51 total

    MergeSort: 10,000 cards = 1.32s user 0.11s system 189% cpu 0.754 total, 20,000 cards = 1.50s user 0.11s system 176% cpu 0.915 total, 40,000 cards = 2.01s user 0.12s system 148% cpu 1.431 total, 80,000 cards = 3.98s user 0.13s system 121% cpu 3.385 total, 160,000 cards = 12.35s user 0.22s system 101% cpu 12.445 total, 320,000 cards = 59.35s user 0.54s system 100% cpu 59.302 total, 640,000 cards = 270.75s user 1.61s system 99% cpu 4:32.80 total

What did you notice about the differences in runtime across algorithms as you changed the number of cards you were sorting? If you had to split them into "slower" algorithms vs "faster" algorithms, which would you put in each category? 

I would say that MergeSort was the fastest, then SelectionSort and Quicksort, with InsertionSort trailing behind. MergeSort being fast was expected, but I did not expect SelectionSort and InsertionSort to have such different times. I thought at first something might've been wrong with my code and looked for ways to make it more efficient, but then I realized that addLast() in SelectionSort and add(index, card) in InsertionSort have different efficiencies and InsertionSort will inevitably be slower in LinkedLists.

Reflection on your experience with this assignment:

This assignment was very time consuming for me, but I felt I better understood each algorithm by the end. I initially had issues with the animation and debugging strategies, but going to office hours helped.