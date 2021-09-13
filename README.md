# Merge Sort
This program shows how much time you should spend sorting with the merge algorithm.

I know if array is minimal-sorted it takes less time to sort it.
Lets check it out!

I have one million random generated integers in arrays. The maximum values will be different for pretending middle/minimal-sorted (1st and 2nd variant):
- max is 10
- max is 100 000
- max is 1 000 000 000

![image](https://user-images.githubusercontent.com/29590727/133105635-96e13033-57bd-4cbc-aa33-c33f78eaf0f1.png)

### Ok, what about bigger array, is it takes similar time?
I include next output with one hundred million random elements sorting)

![image](https://user-images.githubusercontent.com/29590727/133098740-5c5d8c31-8ee6-4aa4-9bb7-3952bcda3c13.png)

As you can see, sorting minimal-sorted array and unsorted array (2nd and 3rd output) are very same by the time.

Only ~15% difference!

But if you have middle-sorted array, you will spend ~70% less time. 

## How about sorting an array that's already sorted in reverse order?

This is 1 million elements array:

![image](https://user-images.githubusercontent.com/29590727/133097240-4999f46f-a9e9-4275-8c67-0e26fb10ba3c.png)

If you want to sort an array by reverse order, I think this algorithm is the best.
And it's doesn't matter you must sort the same elements or different elements in reverse order.
Somehow weirdly sorts the dissimilar elements array faster than very similar elements array)

![image](https://user-images.githubusercontent.com/29590727/133108837-e70d1170-8a5e-4e76-9078-d95b7106d7ce.png)

Some statistics:

---
1: 11
2: 22
---
