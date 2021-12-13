package src;

import java.util.TreeMap;

class TreeMapSorter implements IntSorter {

    public void sort(int[] a){
        ThreeMapSort(a);
    }

    public void ThreeMapSort(int[] a) {
        int count = 0;
        TreeMap<Integer, Integer> d
                = new TreeMap<Integer, Integer>();
        Integer.valueOf(a[0]);
        for (int newElement : a) {
            Integer newValue = Integer.valueOf(newElement);
            if (!d.containsKey(newValue)) {
                d.put(newValue, 1);
            } else {
                d.put(newValue, d.get(newValue) + 1);
            }
        }
        for (var p : d.entrySet()) {
            for(int i = 0; i < p.getValue(); i++) {
                a[count++] = p.getKey();
            }
        }
    }
}

