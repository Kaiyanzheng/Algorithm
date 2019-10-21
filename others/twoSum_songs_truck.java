package jobPrep2019.amazon.eight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class twoSum_songs_truck {
    /** movie on flight
     * amzon music 给定时间 再减30秒 从数组里选两首歌的时长等于给定时间，如果有一样的要按两首歌里最长的排序
     * 飞机上放音乐还是影片，两个加起来刚好等于一个值而且要包含所有符合的结果里面最长一个电影的。返回一对int
     * 第一题 如果有多个 sum = target的话 return 包含更长电影的pair对吗, what if more than one pairs contain the longest song.
     * 只是说包含最长的 所以我才都可以吧。 test case都过了
     *
     *  选出最大值pair的index，会有重复，return含有最大长度的那一组
     * 	Given int array of song list
     * 	return a pair of song which total songs time will end exactly 30 minute before
     * 	given ride duration. if 2 pairs with same duration get the longest song
     * 	 
     * 	For example:
     * 	Ride Duration:90
     * 	Songs: (1,10,25,35,60,20,40)
     * 	 
     * 	Output:
     * 	[20,40] as 40 has longer song
     *
     * 	time: O(n)
     */
    public List<Integer> getSongs(int[] songs, int ride) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int song1 = -1;
        int song2 = -1;
        int longSong = -1;
        for (int i = 0; i < songs.length; i++) {
            if (map.containsKey(ride - 30 - songs[i])) {
                if (longSong < Math.max(songs[i], ride - 30 - songs[i])) {
                    song1 = map.get(ride - 30 - songs[i]);
                    song2 = i;
                    longSong = Math.max(songs[i], ride - 30 - songs[i]);
                }
            }
            map.put(songs[i], i);
        }
        res.add(song1);
        res.add(song2);
        return res;
    }


    public static void main(String[] args) {
        twoSum_songs_truck sol = new twoSum_songs_truck();
        int ride = 90;
        int[] songs = new int[] {1, 10, 25, 35, 60, 20, 40};
        List<Integer> res = sol.getSongs(songs, ride);
        for (Integer k : res) {
            System.out.println(k);
        }
    }
}
