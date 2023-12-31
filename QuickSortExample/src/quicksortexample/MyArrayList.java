/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksortexample;

import java.util.*;

/**
 *
 * @author Hamilton1
 */
public class MyArrayList<ElementType> extends ArrayList<ElementType> {

    public void quickSort(int iStart, int iEnd) {
        int iPivotIndex;
        if (iStart < iEnd) {
            /*
                select pivot and re-arrange elements in two partitions such as
                all array[start … p-1] are less than pivot = array [p] and
                all array[p+1 … end] are >= pivot
             */
            iPivotIndex = partition(iStart, iEnd);

            // sort first partition of the array (from start to pivot_index-1)
            quickSort(iStart, iPivotIndex - 1);

            //sort second partition of the array
            quickSort(iPivotIndex + 1, iEnd);
        } else // do nothing, the array has one element, so it is sorted
        {
            return;
        }
    }

    public int partition(int iStart, int iEnd) {
        int iUp, iDown;
        ElementType pivot;

        // select the first element as pivot
        pivot = get(iStart);

        // set the UP and DOWN indexes
        iUp = iStart + 1;
        iDown = iEnd;

        // as long as UP and DOWN indexes did not pass each other
        while (iUp < iDown) {
            // increment UP index until found first element higher than pivot
            while (iUp < iEnd && ((Comparable) get(iUp)).compareTo((Comparable) pivot) < 0) {
                iUp = iUp + 1;
            }

            // decrement DOWN until found first element smaller than  pivot
            while (iDown > iStart && (((Comparable) get(iDown)).compareTo((Comparable) pivot) > 0 || ((Comparable) get(iDown)).compareTo((Comparable) pivot) == 0)) {
                iDown = iDown - 1;
            }

            // if UP and DOWN indexes did not pass each other
            if (iUp < iDown) {
                ElementType elementUp = get(iUp);
                //swap the two elements found
                set(iUp, get(iDown));
                set(iDown, elementUp);
            }
        }

        // UP and DOWN indexes have passed each other, so swap pivot with the element on DOWN position
        set(iStart, get(iDown));
        set(iDown, pivot);
        return iDown;
    }
    
     public void bubbleSort() {
        int iCount, jCount;
        Comparable elementAtjCount, elementAtjCountPlus;
        for (iCount = 0; iCount < size(); iCount++) {

            for (jCount = 0; jCount < size() - 1 - iCount; jCount++) {
                elementAtjCount = (Comparable) get(jCount);
                elementAtjCountPlus = (Comparable) get(jCount + 1);

                if (elementAtjCount.compareTo(elementAtjCountPlus) > 0) {
                    //swap element on postion jCount with element on position jCount + 1
                    swap(jCount, jCount + 1);
                }
            }
        }
    }

    public void swap(int inPos1, int inPos2) {
        //Create two objects that will store the info from the two positions
        ElementType objPos1 = get(inPos1);
        ElementType objPos2 = get(inPos2);

        //Remove element from position 1
        remove(inPos1);

        //Insert objPos2 into position 1
        add(inPos1, objPos2);

        //Remove element from position 2
        remove(inPos2);

        // Insert objPos1 into position 2
        add(inPos2, objPos1);
    }
    
    public void insertionSort() {
        // insert your code here
        ElementType keyElement;
        for (int iCount = 1; iCount< size(); iCount++){
            keyElement = get(iCount);
            int iPosition = iCount; //position of the key element
            //used to compare 
            while (iPosition > 0 && ((Comparable) get(iPosition - 1)).compareTo(keyElement) > 0){
                ElementType elementAtiPosition;
                elementAtiPosition = get(iPosition - 1);
                set(iPosition, elementAtiPosition);
                iPosition = iPosition - 1;
            }
            set(iPosition, keyElement);
        }
    }
    
    //Merge Sort Algorithm
    public void mergeSort(int iStart, int iEnd) {
        int iMiddle = 0;
        if (iStart < iEnd) {
            // middle in the middle between start and end is determined
            iMiddle = (iStart + iEnd) / 2;

            // first part of the array (from start to mid) sorted by recursive calls
            mergeSort(iStart, iMiddle);

            // second part of the array (from mid+1 to end) sorted by recursive calls of	merge(array, start, mid, end)
            mergeSort(iMiddle + 1, iEnd);

            // merges array [start .. mid] with array[mid+1.. end]
            merge(iStart, iMiddle, iEnd);
        } else {
            // do nothing, the array has one element, so it is sorted
            return;
        }
    }

    //Merge Sort Algorithm - Merging process
    public void merge(int iLeft, int iMiddle, int iRight) {
        int iCount = iLeft;
        int jCount = iMiddle + 1;
        int kCount = 0;
        ArrayList<Object> tempArray = new ArrayList<Object>();

        while (iCount <= iMiddle && jCount <= iRight) {
            if (((Comparable) get(iCount)).compareTo((Comparable) get(jCount)) < 0) {
                tempArray.add(kCount, get(iCount));
                iCount = iCount + 1;
            } else {
                tempArray.add(kCount, get(jCount));
                jCount = jCount + 1;
            }
            kCount = kCount + 1;
        }

        // there are elements left in 1st half to be copied
        while (iCount <= iMiddle) {
            tempArray.add(kCount, get(iCount));
            kCount = kCount + 1;
            iCount = iCount + 1;
        }

        // there are elements left in 2nd half to be copied
        while (jCount <= iRight) {
            tempArray.add(kCount, get(jCount));
            kCount = kCount + 1;
            jCount = jCount + 1;
        }

        // copy the sorted tempArray into the original array
        for (iCount = iLeft, kCount = 0; iCount <= iRight; iCount++, kCount++) {
            set(iCount, (ElementType) tempArray.get(kCount));
        }
    }
}
