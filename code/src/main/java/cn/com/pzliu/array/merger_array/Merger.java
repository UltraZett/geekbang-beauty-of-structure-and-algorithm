package cn.com.pzliu.array.merger_array;

public class Merger<T extends Comparable> {


    public Object[] merger(T[] array1,T[] array2){

        if (array1.length == 0){
            return array2;
        }

        if (array2.length == 0){
            return array1;
        }
        Object[] result = new Object[array1.length+array2.length];
        int array1Index = 0;
        int array2Index = 0;
        int index =0;
        while (Math.max(array1Index,array2Index) < Math.max(array1.length,array2.length)){
            if (array1Index == array1.length){
                result[index++] = array2[array2Index++];
                continue;
            }

            if (array2Index == array2.length){
                result[index++] = array1[array1Index++];
                continue;
            }

            if (array1[array1Index].compareTo(array2[array2Index]) > 0){
                result[index++] =array2[array2Index++];
            }else {
                result[index++] = array1[array1Index++];
            }

        }
        return result;
    }


}
