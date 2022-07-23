public class Mergesort {

    //排序
    void merge(int[] array, int left, int middle, int rigth){
       int[] temp = new int[rigth - left +1];
       //赋值
        for (int i = left; i<= rigth; i++){
            temp[i-left] = array[i];
        }
        //左1下标
        int i = left;
        //右1下标
        int j = middle+1;
        for(int k = left; k <= rigth; k++){
            //这就代表 左边的上半部分集合全部赋值
            if(i > middle && j <= rigth){
                array[k] = temp[j-left];
                j++;
            }
            //这就代表右边下半部分集合全部赋值
            else if (j > rigth && i <= middle){
                array[k] = temp[i - left];
                i++;
            }
            //判断右1值和左1值大小, 谁小放谁，并把数组下标往后挪一位
            else if (temp[i - left] > temp[j - left]){
                array[k] = temp[j - left];
                j++;
            }
            //判断判断右1值和左1值大小，谁小放谁，并把数组下标往后挪
            else{
                array[k] = temp[i - left];
                i++;
            }

        }

    }

    //等于array数组下标为left的元素到下标为right的元素进行排序
    void mergesort(int[] array, int left, int right){
        if(left >= right){
            return;
        }
        //获取范围内的中位下标
        int middle = (right+left) / 2;
        //获取数组的前部分
        mergesort(array, left, middle);
        //获取数组的后部分
        mergesort(array,middle+1, right);
        //执行排序
        merge(array, left, middle, right);
    }
}
