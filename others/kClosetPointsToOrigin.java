package jobPrep2019.amazon.eight;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class kClosetPointsToOrigin {
    /**
     * numDest: 3
     * allLocations: {{1,2}, {3,4}, {1,-1}}
     * numDeli: 2
     * return: {{1,2}, {1,-1}}
     */
    public List<List<Integer>> closestXDestination(int numDest, List<List<Integer>> allLocations, int numDeli) {
        if (allLocations == null || allLocations.size() == 0 || allLocations.size() < numDeli) {
            return new ArrayList<>();
        }
        sort(allLocations, 0, numDest - 1, numDeli);
        return allLocations.subList(0, numDeli);
    }

    private void sort(List<List<Integer>> allLocations, int left, int right, int numDeli) {
        if (left >= right) {
            return;
        }
        int pivotPos = partition(allLocations, left, right);
        int leftLen = pivotPos - left + 1;
        if (numDeli < leftLen) {
            sort(allLocations, left, pivotPos - 1, numDeli);
        } else if (numDeli > leftLen) {
            sort(allLocations, pivotPos + 1, right, numDeli - leftLen);
        }
    }

    private int partition(List<List<Integer>> allLocations, int left, int right) {
        int pivotIndex = left + (int)(Math.random() * (right - left + 1));
        int pivot = distance(allLocations.get(pivotIndex));
        swap(pivotIndex, right, allLocations);

        int i = left;
        int j = right - 1;
        while (i <= j) {
            if (distance(allLocations.get(i)) < pivot) {
                i++;
            } else if (distance(allLocations.get(j)) >= pivot) {
                j--;
            } else {
                swap(i++, j--, allLocations);
            }
        }
        swap(i, right, allLocations);
        return i;
    }

    private void swap(int i, int j, List<List<Integer>> allLocations) {
        int t1 = allLocations.get(i).get(0);
        int t2 = allLocations.get(i).get(1);
        allLocations.get(i).set(0, allLocations.get(j).get(0));
        allLocations.get(i).set(1, allLocations.get(j).get(1));
        allLocations.get(j).set(0, t1);
        allLocations.get(j).set(1, t2);
    }

    private int distance(List<Integer> deli) {
        return (int)(Math.pow(deli.get(0), 2) + Math.pow(deli.get(1), 2));
    }

    public List<List<Integer>> kClosest(List<List<Integer>> points, int K) {
        PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<List<Integer>>((a, b)->(b.get(0) * b.get(0)  + b.get(1)  * b.get(1)  - (a.get(0) * a.get(0) + a.get(1) * a.get(1))));
        for (int i = 0; i < points.size(); i++) {
            maxHeap.add(points.get(i));
            if(maxHeap.size() > K) {
                maxHeap.remove();
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            res.add(maxHeap.remove());
        }
        return res;
    }

    public static void main(String[] args) {
        kClosetPointsToOrigin sol = new kClosetPointsToOrigin();
        /*int numDest = 3;
        int numDeli = 2;
        List<List<Integer>> allLocations = new ArrayList<>();
        List<Integer> location1 = new ArrayList<>();
        location1.add(2, 3);
        List<Integer> location2 = new ArrayList<>();
        location1.add(3, 4);
        List<Integer> location3 = new ArrayList<>();
        location1.add(1, -3);
        List<List<Integer>> res = new ArrayList<>();
        allLocations.add(location1);
        allLocations.add(location2);
        allLocations.add(location3);
        res = sol.closestXDestination(numDest, allLocations, numDeli);*/

        int K = 1;
        List<List<Integer>> points = new ArrayList<>();
        List<Integer> point1 = new ArrayList<>();
        point1.add(1);
        point1.add(3);
        points.add(point1);
        List<Integer> point2 = new ArrayList<>();
        point2.add(-2);
        point2.add(2);
        points.add(point2);
        List<List<Integer>> res = sol.kClosest(points, K);
        for (List<Integer> li : res) {
            System.out.println(li);
        }
    }
}
