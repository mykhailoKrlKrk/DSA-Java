# Sorting Algorithms  📊
---
![Java Badge](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white) ![Tomcat Badge](https://img.shields.io/badge/Apache%20Tomcat-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=black)

This project provides an example of the implementation of sorting algorithms in Java with a step-by-step description of execution and analysis of the efficiency of the algorithm under various conditions.
In order to display the results, `Tomcat`, `Servlets`, and `JSP` technologies are utilized in this context.
##  Selection Sort
---

Selection Sort is a sorting technique that sequentially arranges an array by repeatedly selecting the smallest or largest element and placing it in its correct position. It involves multiple iterations to accomplish the sorting. However, its time complexity is higher compared to insertion sort. Selection Sort is not efficient for large datasets due to its time complexity.

### 🧾 Step-by-step explanation
- Find the Smallest: Start by finding the smallest element in the array.
- Swap with First: Swap this smallest element with the first element in the array.
- Move to Next Unsorted: Move to the next unsorted element.
- Repeat Steps 1-3: Repeat steps 1 to 3 for the remaining unsorted elements.
- Array is Sorted: Once all elements are sorted, the array is in order.

📈 Efficient Use Cases:
- Small Datasets: Selection sort can be efficient for small datasets where its simplicity outweighs its inefficiency.

- Nearly Sorted Data: If the data is almost sorted or the number of inversions is small, selection sort can perform reasonably well.

- Memory Constraints: When memory usage needs to be minimized, selection sort's in-place sorting can be beneficial.

📉 Inefficient Use Cases:
- Large Datasets: Selection sort becomes highly inefficient as the dataset grows, so it's not suitable for large arrays or lists.

- Real-Time Systems: In real-time systems where speed is critical, selection sort's time complexity makes it unsuitable.

- Performance Optimization Required: If the goal is to achieve the best sorting performance, more efficient algorithms like quick sort or merge sort should be chosen over selection sort.

## Shell Sort
---
Shell Sort is an efficient sorting algorithm that extends the principles of insertion sort by allowing the exchange of elements that are far apart. It begins by sorting pairs of elements far apart from each other and progressively reduces the gap between elements to sort the entire array.

### 🧾 Step-by-step Explanation
- Define the Gap Sequence: Choose a sequence of gap values to determine the intervals for comparing and swapping elements.
- Start with the Widest Gap: Begin by sorting elements that are "gap" distance apart using insertion sort.
- Reduce the Gap and Repeat: Gradually reduce the gap, and for each gap, perform an insertion sort on the elements.
- Continue Until Gap is 1: Repeat the process until the gap becomes 1, at which point a final insertion sort is performed to ensure the entire array is sorted.


📈 Efficient Use Cases:
- Medium to Large Datasets: Shell sort is efficient for medium-sized datasets and can outperform simple algorithms like bubble sort and selection sort.
- Varying Gap Sequences: Shell sort's efficiency can be optimized by choosing an appropriate gap sequence based on the dataset.


📉 Inefficient Use Cases:
- Already Sorted Data: Shell sort's performance degrades if the data is already mostly sorted, as its efficiency relies on reducing the gap between elements.
- Not the Fastest Algorithm: While efficient, Shell sort is generally outperformed by more advanced algorithms like quick sort and merge sort for larger datasets.

## Quick Sort
Quick Sort is an efficient and widely used sorting algorithm based on the divide-and-conquer technique. It selects a 'pivot' element from the array and partitions the other elements into two sub-arrays, according to whether they are less than or greater than the pivot. The process is then repeated recursively on each sub-array, resulting in a sorted array.

### 🧾 Step-by-step Explanation
- Choose a Pivot: Select a pivot element from the array.
- Partitioning: Rearrange the elements such that elements smaller than the pivot are on the left, and elements greater than the pivot are on the right.
- Recursive Sort: Apply the above steps recursively to the sub-arrays formed by the partitioning.

📈 Efficient Use Cases:

- Average and Best-Case Time: Quick Sort is highly efficient, especially in the average and best-case scenarios, making it a popular choice for general-purpose sorting.
- Memory Efficiency: Quick Sort is an in-place sorting algorithm, requires very little additional memory.

📉 Inefficient Use Cases:

- Worst-Case Time Complexity: In the worst-case scenario, particularly when the array is already sorted or nearly sorted, Quick Sort's time complexity can degrade to O(n^2). However, this is rare in practice.
- Not Stable: Quick Sort is not a stable sorting algorithm, meaning the order of equal elements may change.

## Merge Sort
Merge Sort is an efficient sorting algorithm that follows the divide-and-conquer approach. It divides the array into smaller sub-arrays, sorts them, and then merges them back into a fully sorted array.

### 🧾 Step-by-step Explanation
- Divide: Divide the given array into two halves.
- Conquer: Recursively sort each sub-array.
- Merge: Merge the sorted sub-arrays to produce a sorted array.

📈 Efficient Use Cases:

- General Efficiency: Merge Sort is efficient for general-purpose sorting, offering consistent performance across various datasets.
- Stable Sorting: Merge Sort is a stable sorting algorithm, ensuring that the relative order of equal elements is preserved.

📉 Inefficient Use Cases:

- In-place Sorting: Merge Sort is not an in-place sorting algorithm, which means it requires additional memory proportional to the size of the input array.
- Constant Overhead: The recursive nature of Merge Sort involves function calls and additional memory usage, which may not be optimal for small arrays or systems with limited memory.

## Counting Sort
Counting Sort is a sorting algorithm that operates by counting the occurrences of each element and using arithmetic to determine their positions in the sorted array.

🧾 Step-by-step Explanation
- Counting: Count the occurrences of each element in the given array.
- Positioning: Calculate the positions of elements based on their counts.
- Sorting: Generate the sorted array based on the calculated positions.

📈 Efficient Use Cases:

- Specific Range of Values: Counting Sort is efficient when the range of values in the array is relatively small compared to the size of the array.
- Integer Sorting: It is highly efficient for sorting integers within a specific range.
- Counting Frequencies: Useful for frequency counting applications, such as finding the frequency of elements in an array.

📉 Inefficient Use Cases:

- Sparse Data: Counting Sort becomes inefficient when the range of values is significantly larger than the size of the array.
- Non-integer Data: Not suitable for sorting non-integer or non-numeric data.
- Memory Usage: Requires additional memory proportional to the range of values, which can be inefficient for large ranges.
