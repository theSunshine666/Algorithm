package com.company.wq.datastructure.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;

public class Sort {
    public static void main(String[] args) {
        int[] nums = {2,3,1,5,3,2,7,6,9};
        Sort sort = new Sort();
        sort.bubbleSort(nums);
        System.out.println("1、冒泡排序算法结果为："+Arrays.toString(nums));
        sort.seletSort(nums);
        System.out.println("2、选择排序算法结果为："+Arrays.toString(nums));
        sort.insertSort(nums);
        System.out.println("3、插入排序算法结果为："+Arrays.toString(nums));
        sort.shellSort(nums);
        System.out.println("4、希尔排序算法结果为："+Arrays.toString(nums));
        sort.mergeSort(nums,0,nums.length-1);
        System.out.println("5、归并排序算法结果为："+Arrays.toString(nums));
        int[] nums2 = {2,3,1,5,3,2,7,6,9};
        sort.quickSotr(nums2,0,nums2.length-1);
        System.out.println("6、快速排序算法结果为："+Arrays.toString(nums2));
        int[] nums3 = {2,3,1,5,3,2,7,6,9};
        sort.heapSort(nums3);
        System.out.println("7、堆排序算法的结果为："+Arrays.toString(nums3));
        sort.countSort(nums3);
        System.out.println("8、计数排序算法结果为："+Arrays.toString(nums3));
        sort.bucketSort(nums3,5);
        System.out.println("9、桶排序算法的结果为："+Arrays.toString(nums3));
        sort.radixSort(nums);
        System.out.println("10、基数排序算法结果为："+Arrays.toString(nums));
    }

    /**
     * 排序算法的稳定性：
     * 假定在待排序的记录序列中，存在多个具有相同的关键字的记录，若经过排序，这些记录的相对次序保持不变，则为稳定，否则不稳定
     */

    /**
     * 冒泡排序算法，时间复杂度为O(n方)，空间复杂度O(1)，稳定
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     * 每次循环能将最大的元素放置在最后
     * @param arr
     */
    public void bubbleSort(int[] arr){
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            //用flag来标记本次循环是否发生来交换
            boolean flag = false;
            for(int j = 0; j < len - i; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    //发生来交换，将flag置为false
                    flag = true;
                }
            }
            //未发生交换，说明后面的已经有序，不用再排，直接退出循环即可
            if (!flag){
                break;
            }
        }
    }

    /**
     * 选择排序算法：时间复杂度O(n方)，空间复杂度O(1)，不稳定
     * 每次循环将最小值放在已排序列的前面，不稳定举例：{1,3,3,2}
     * @param arr
     */
    public void seletSort(int[] arr){
        int len = arr.length;
        //用minIndex记录最小元素的下标
        int minIndex,temp;
        for (int i = 0; i < len - 1; i++) {
            //先将minIndex赋值成i，即将i作为最开始的最小值，再与后面的进行比较
            minIndex = i;
            //因为每次循环是将最小值放到最前面，因此要从i+1开始循环
            for (int j = i + 1; j < len; j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            //发生交换
            if (i != minIndex){
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }


    /**
     * 插入排序算法：时间复杂度O(n方)，空间复杂度O(1)，稳定
     * 第一步：将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
     * 第二步：从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。（如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
     * @param arr
     */
    public void insertSort(int[] arr){
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int temp = arr[i];
            int j;
            for (j = i; temp < arr[j-1]; j--){
                arr[j] = arr[j-1];
            }
            if (i != j){
                arr[j] = temp;
            }
        }
    }

    /**
     * 希尔排序，也称递减增量排序算法，是插入排序的一种更高效的改进版本。但希尔排序是非稳定排序算法。
     * 希尔排序的基本思想是：先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，
     * 待整个序列中的记录"基本有序"时，再对全体记录进行依次直接插入排序。
     * 时间复杂度O(nlogn)，空间复杂度O(1),不稳定
     * @param arr
     */
    public void shellSort(int[] arr){
        int len = arr.length;
        int temp;
        for (int k = len / 2; k >= 1; k/=2) {
            for (int i = k; i < len; i++){
                for (int j = i; j - k >= 0; j-=k){
                    if (arr[j] < arr[j-k]){
                        temp = arr[j];
                        arr[j] = arr[j-k];
                        arr[j-k] = temp;
                    }
                }
            }
        }
    }

    /**
     * 归并排序，时间复杂度O(nlogn)，空间复杂度O(1)，稳定
     * @param a     要排序的数组
     * @param low
     * @param mid
     * @param high
     */
    public void merge(int[] a,int low,int mid,int high){
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high){
            if (a[i] < a[j]){
                temp[k++] = a[i++];
            }else {
                temp[k++] = a[j++];
            }
        }
        while (i <= mid){
            temp[k++] = a[i++];
        }
        while (j <= high){
            temp[k++] = a[j++];
        }
        for (int l = 0; l < temp.length; l++) {
            a[l + low] = temp[l];
        }
    }
    public void mergeSort(int[] arr,int low,int high){
        int mid = (low + high) / 2;
        if (low < high){
            //左边
            mergeSort(arr,low,mid);
            //右边
            mergeSort(arr,mid+1,high);
            //左右合并
            merge(arr,low,mid,high);
        }
    }


    //快速排序，时间复杂度O(nlogn)，空间复杂度O(logn)，不稳定
    public void quickSotr(int[] array,int low,int high){
        if (low > high){
            return;
        }
        int pivot = array[low];
        int i = low, j = high;
        while(i != j){
            while(i < j && pivot <= array[j]){
                j--;
            }
            while (i < j && pivot >= array[i]){
                i++;
            }
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        array[low] = array[i];
        array[i] = pivot;
        quickSotr(array,low,i-1);
        quickSotr(array,j+1,high);
    }

    public void swap(int[] arr,int l,int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    /**
     * 堆排序，时间复杂度O(nlogn)，空间复杂度O(1)，不稳定
     * 1、构建大顶堆；
     * 2、交换堆顶和当前末尾的节点，将堆的尺寸缩小1，并再次进行调整为大顶堆；
     * 3、重复以上动作直到堆的尺寸为1。
     */

    public void heapSort(int[] arr){
        if (arr == null || arr.length == 0){
            return;
        }
        int len = arr.length;
        //构建大顶堆，这里其实就是把待排序序列，变成一个大顶堆结构的数组
        buildMaxHeap(arr,len);
        //交换堆顶和当前末尾的节点，重置大顶堆
        for (int j = len - 1; j > 0; j--) {
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            len--;
            adjustHeap(arr,0,len);
        }
    }

    public void buildMaxHeap(int[] arr,int len){
        //从最后一个非叶子节点开始向前遍历，调整节点性质，使之成为大顶堆
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(arr,i,len);
        }
    }

    public void adjustHeap(int[] arr,int i, int len){
        //先根据堆性质，找出它左右节点的索引
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        //默认当前节点（父节点）是最大值
        int largestIndex = i;

        if (left < len && arr[left] > arr[largestIndex]){
            //如果有左节点，且左节点的值更大，则更新最大值的索引
            largestIndex = left;
        }
        if (right < len && arr[right] > arr[largestIndex]){
            //如果有右节点，且右节点的值更大，则更新最大值的索引
            largestIndex = right;
        }

        if (largestIndex != i){
            //如果最大值不是当前非叶子节点的值，那么就把当前节点的值和最大值进行交换
            int temp = arr[i];
            arr[i] = arr[largestIndex];
            arr[largestIndex] = temp;
            //因为互换后子节点的值变了，如果该子节点也有自己的子节点，则需要再次进行调整
            adjustHeap(arr,largestIndex,len);
        }
    }

    /**
     * 计数排序，时间复杂度O(n+k),空间复杂度O(k)，稳定
     * 非比较型排序算法
     * @param arr
     */
    public void countSort(int[] arr){
        int len = arr.length;
        int min = arr[0];
        int max = min;
        //找出数组中的最大、最小值
        for (int i = 0; i < len; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
            if (arr[i] < min){
                min = arr[i];
            }
        }
        int[] temp = new int[max-min+1];
        //记录各数字出现的次数，标记在临时数组中
        for (int i = 0; i < max - min + 1; i++) {
            temp[arr[i] - min] ++;
        }
        int j = 0;
        //根据每个数值出现的次数将值分配回目标数组
        //i代表距离最小值为i，temp[i]代表距离最小值为i的数值出现的次数，出现几次就从min往后移几次
        for (int i = 0; i < max - min + 1; i++) {
            while(temp[i]-- > 0){
                arr[j++] = min + i;
            }
        }
    }

    /**
     * 桶排序：时间复杂度O(n+k),空间复杂度O(n+k)，稳定
     * 是计数排序的升级版
     * @param arr
     * @param bucketSize
     */
    public void bucketSort(int[] arr,int bucketSize){
        ArrayList[] bucket = new ArrayList[bucketSize];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] / 10;
            bucket[index].add(arr[i]);
        }
        for (int i = 0; i < bucket.length; i++) {
            bucket[i].sort(null);
        }
    }

    public void radixSort(int[] arr){
        //1、先求最高位数长度,即基数
        int radix = getRadix(arr);
        //创建桶list所有桶的集合，每一个桶是LinkedList当成队列来用
        LinkedList<Integer>[] lists = new LinkedList[10];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new LinkedList<>();
        }
        //2、分类、收集
        for (int r = 1;r <= radix;r++){
            //分类过程
            for (int i = 0; i < arr.length; i++) {
                lists[getIndex(arr[i],r)].offer(arr[i]);
            }
            int index = 0; //遍历arr原数组
            //收集过程
            for (int i = 0; i < lists.length; i++) {
                while (!lists[i].isEmpty()){
                    arr[index++] = lists[i].poll();
                }
            }
        }
    }

    //获取num的最低位数
    public int getIndex(int num,int r){
        int ret = 0;
        for (int i = 1; i <= r; i++) {
            ret = num % 10;
            num /= 10;
        }
        return  ret;
    }

    //求基数
    public int getRadix(int[] arr){
        //1.1 求最大值
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[0] > max){
                max = arr[0];
            }
        }
        //1.2 基数，即最高位数长度
        return (max + "").length();
    }
}
