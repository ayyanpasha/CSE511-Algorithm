#include <iostream>
#include <vector>
#include <cstdlib>  // For std::rand()
#include <ctime>    // For std::time()

// Function to swap elements in the array
void swap(std::vector<int>& arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

// Partition function for QuickSort
int partition(std::vector<int>& arr, int low, int high) {
    int pivot = arr[high];
    int i = low - 1;

    for (int j = low; j <= high - 1; ++j) {
        if (arr[j] < pivot) {
            ++i;
            swap(arr, i, j);
        }
    }
    swap(arr, i + 1, high);
    return i + 1;
}

// QuickSort function
int quicksort(std::vector<int>& arr, int low, int high, int k) {
    // Random pivot selection
    int pivotIndex = low + std::rand() % (high - low + 1);
    swap(arr, high, pivotIndex);
    
    int partitionIndex = partition(arr, low, high);
    
    if (high - partitionIndex + 1 == k) {
        return arr[partitionIndex];
    } else if (high - partitionIndex + 1 > k) {
        return quicksort(arr, partitionIndex + 1, high, k);
    } else {
        return quicksort(arr, low, partitionIndex - 1, k - (high - partitionIndex + 1));
    }
}

// Function to find the k-th largest element
int findElement(const std::vector<int>& arr, int low, int high, int k) {
    std::vector<int> karr(2 * k, 0);
    
    for (int i = 0; i < k; ++i) {
        karr[i + k] = arr[i];
    }
    
    for (int i = k; i <= high; i += k) {
        int j = 0;
        while (j < k && j + i <= high) {
            karr[j] = arr[j + i];
            ++j;
        }
        while (j < k) {
            karr[j] = 0;
            ++j;
        }
        quicksort(karr, 0, 2 * k - 1, k);
    }
    return karr[k];
}

int main() {
    // Seed random number generator
    std::srand(static_cast<unsigned int>(std::time(0)));
    
    int n, k;
    std::cin >> n >> k;
    
    std::vector<int> arr(n);
    for (int i = 0; i < n; ++i) {
        std::cin >> arr[i];
    }
    
    std::cout << findElement(arr, 0, n - 1, k) << std::endl;
    
    return 0;
}
