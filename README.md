# Merge Sort
>_If you only want to copy algorithm method [click here](https://github.com/AleksandrZholud/MergeSort/blob/main/README.md#algorithm-method)._

This program shows how much time you should spend sorting with the merge algorithm.

I know if array is minimal-sorted it takes less time to sort it.
Lets check it out!

I have one million random generated integers in arrays. The maximum values will be different for pretending middle/minimal-sorted (1st and 2nd variant):
- max is 10
- max is 100 000
- max is 1 000 000 000

![image](https://user-images.githubusercontent.com/29590727/133105635-96e13033-57bd-4cbc-aa33-c33f78eaf0f1.png)

### Ok, what about bigger array, is it takes similar time?
//if you only want to copy
I include next output with one hundred million random elements sorting)

![image](https://user-images.githubusercontent.com/29590727/133098740-5c5d8c31-8ee6-4aa4-9bb7-3952bcda3c13.png)

As you can see, sorting minimal-sorted array and unsorted array (2nd and 3rd output) are very same by the time.

Only ~15% difference!

But if you have middle-sorted array, you will spend ~70% less time.

## How about sorting an array that's already sorted in reverse order?

This is output of sorting a 1 million elements array:

> [1 000 000 - length]   [10 - max value]
> In 116 ms. (in 0.116 seconds) finished
>
>> [1 000 000 - length]   [100 000 - max value]
> In 79 ms. (in 0.079 seconds) finished
>
>>> [1 000 000 - length]   [1 000 000 000 - max value]
> In 92 ms. (in 0.092 seconds) finished
>

If you want to sort an array by reverse order, I think this algorithm is the best.
And it's doesn't matter you must sort the same elements or different elements in reverse order.
It weirdly sorts the dissimilar elements array faster than very similar elements array)

![image](https://user-images.githubusercontent.com/29590727/133108837-e70d1170-8a5e-4e76-9078-d95b7106d7ce.png)

Some statistics:
---
> Max value of elements is 10

| size of array | composition | time | composition | time | composition | time |
| --- | --- | --- | --- | --- | --- | --- |
| 10 000 | sorted | 0.007 sec | reverse-order | 0.008 sec | random | 0.009 sec |
| 100 000 | sorted | 0.020 sec | reverse-order | 0.055 sec | random | 0.051 sec |
| 1 000 000 | sorted | 0.076 sec | reverse-order | 0.110 sec | random | 0.203 sec |
| 10 000 000 | sorted | 0.940 sec | reverse-order | 0.911 sec | random | 1.959 sec |
| 100 000 000 | sorted | 6.140 sec | reverse-order | 8.356 sec | random | 14.286 sec |

> Max value of elements is 100 000

| size of array | composition | time | composition | time | composition | time |
| --- | --- | --- | --- | --- | --- | --- |
| 10 000 | sorted | 0.010 sec | reverse-order | 0.006 sec | random | 0.007 sec |
| 100 000 | sorted | 0.023 sec | reverse-order | 0.032 sec | random | 0.021 sec |
| 1 000 000 | sorted | 0.112 sec | reverse-order | 0.091 sec | random | 0.211 sec |
| 10 000 000 | sorted | 0.976 sec | reverse-order | 1.022 sec | random | 2.501 sec |
| 100 000 000 | sorted | 6.992 sec | reverse-order | 6.742 sec | random | 23.764 sec |

> Max value of elements is 1 000 000 000

| size of array | composition | time | composition | time | composition | time |
| --- | --- | --- | --- | --- | --- | --- |
| 10 000 | sorted | 0.008 sec | reverse-order | 0.006 sec | random | 0.009 sec |
| 100 000 | sorted | 0.027 sec | reverse-order | 0.022 sec | random | 0.022 sec |
| 1 000 000 | sorted | 0.116 sec | reverse-order | 0.103 sec | random | 0.329 sec |
| 10 000 000 | sorted | 0.945 sec | reverse-order | 1.055 sec | random | 2.918 sec |
| 100 000 000 | sorted | 5.904 sec | reverse-order | 6.954 sec | random | 28.249 sec |

---
## Algorithm method
```sh
public static void MergeSort( int[] array )
    {
        int[] tmpMass = array.clone();
        int mid,            //Max length of lefts
                r_end,      //Max length of rights
                len = array.length,
                left,       //left side pointer
                right,      //right side pointer
                counter;    //counter of accepted (sorted) elements
        
        for ( int i = 1 ; i <= len ; i *= 2 )
        {
            for ( int startLeft = 0 ; startLeft + i <= len ; startLeft += i * 2 )
            {
                mid = startLeft + i;
                r_end = mid + i;
                if ( r_end > len ) r_end = len;
                left = counter = startLeft;
                right = mid;
                
                while ( left < mid && right < r_end ) //while we in left and in right sides
                {
                    if ( array[ left ] <= array[ right ] )
                    {
                        tmpMass[ counter++ ] = array[ left++ ];
                    }
                    else
                    {
                        tmpMass[ counter++ ] = array[ right++ ];
                    }
                }
                
                while ( left < mid ) //finishing left side
                {
                    tmpMass[ counter++ ] = array[ left++ ];
                }
                
                while ( right < r_end ) //finishing right side
                {
                    tmpMass[ counter++ ] = array[ right++ ];
                }
            }
            
            for ( counter = 0; counter < len ; counter++ )
            {
                array[ counter ] = tmpMass[ counter ];
            }
        }
    }
```
