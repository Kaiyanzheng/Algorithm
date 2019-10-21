package jobPrep2019.stripe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class trackingInvoices {
    private static class Pair<K, V> {

        private final K element0;
        private final V element1;

        public Pair(K element0, V element1) {
            this.element0 = element0;
            this.element1 = element1;
        }

        public K getKey() {
            return element0;
        }

        public V getValue() {
            return element1;
        }
    }

    public static int calculate_total_owed(List<String> actions) {
        if (actions == null || actions.size() == 0) {
            return 0;
        }

        HashMap<String, Pair<String, Integer>> map = new HashMap<>();

        for (String s : actions) {
            String[] info = s.split("&");
            String id = info[0].substring(info[0].indexOf("id=") + 3);

            int amount = 0;
            String currency = "USD";

            if (s.length() > info[0].length()) {
                amount = Integer.parseInt(info[1].substring(info[1].indexOf("amount=") + 7));
                currency = s.substring(s.indexOf("currency=") + 9);
            }

            if (s == null || s.length() == 0 || !currency.equals("USD")) {
                continue;
            }
            int temp = 0;
            if (s.startsWith("CREATE")) {
                if (map.containsKey(id)) {
                    temp = map.get(id).getValue();
                    if (map.get(id).getKey() != "CREATE")
                        continue;
                }
                else temp = 0;
                temp += amount;
                map.put(id, new Pair<>("CREATE", temp));
            }  else if (s.startsWith("FINALIZE")) {
                if (!map.containsKey(id) || map.get(id).getKey() !=  "CREATE")  continue;
                else {
                    map.put(id, new Pair<>("FINALIZE", amount));
                }
            } else if (s.startsWith("PAY") && map.containsKey(id) && map.get(id).getKey() == "FINALIZE") {
                if (s.length() == info[0].length()) {
                    amount = map.get(id).getValue();
                }
                temp = map.get(id).getValue() - amount;
                map.put(id, new Pair<>("FINALIZE", temp));
            }
        }

        int totalOwned = 0;
        for (Pair<String, Integer> num : map.values()) {
            totalOwned += num.getValue();
        }
        return totalOwned;
    }

    public static void main(String[] args) {
        List<String> action1 = Arrays.asList (
                "CREATE: id=16&amount=800&currency=USD",
                "FINALIZE: id=16&amount=600&currency=USD",
                "PAY: id=16&amount=500&currency=USD"); //100
        List<String> action2 = Arrays.asList (
                "CREATE: id=16&amount=800&currency=USD",
                "FINALIZE: id=16&amount=600&currency=USD",
                "PAY: id=16&amount=500&currency=USD",
                "FINALIZE: id=16&amount=900&currency=USD"); // 600-500=100
        List<String> action3 = Arrays.asList (
                "CREATE: id=16&amount=800&currency=USD",
                "FINALIZE: id=16&amount=600&currency=USD",
                "PAY: id=16&amount=500&currency=USD",
                "CREATE: id=16&amount=900&currency=USD"); // 600-500=100 + 900 = 1000
        List<String> action4 = Arrays.asList (
                "CREATE: id=16&amount=800&currency=USD",
                "FINALIZE: id=16&amount=600&currency=USD",
                "FINALIZE: id=16&amount=900&currency=USD",
                "PAY: id=16&amount=500&currency=USD"); //600-500=100
        List<String> action5 = Arrays.asList (
                "CREATE: id=16&amount=800&currency=RMB",
                "FINALIZE: id=16&amount=600&currency=USD",
                "FINALIZE: id=16&amount=900&currency=USD",
                "PAY: id=16&amount=500&currency=USD"); //0
        List<String> action6 = Arrays.asList (
                "CREATE: id=8&amount=800&currency=USD",
                "FINALIZE: id=8&amount=600&currency=USD",
                "PAY: id=8&amount=500&currency=USD",
                "CREATE: id=16&amount=800&currency=USD",
                "FINALIZE: id=16&amount=600&currency=USD",
                "PAY: id=16&amount=500&currency=USD"); // 100 + 100 = 200
        List<String> action7 = Arrays.asList (
                "CREATE: id=16&amount=800&currency=RMB",
                "FINALIZE: id=16&amount=600&currency=USD",
                "FINALIZE: id=16&amount=900&currency=USD",
                "PAY: id=16&amount=500&currency=USD", //0
                "CREATE: id=8&amount=800&currency=USD",
                "FINALIZE: id=8&amount=600&currency=USD",
                "PAY: id=8&amount=500&currency=USD");
        List<String> action8 = Arrays.asList(
                "CREATE: id=16&amount=800&currency=USD",
                "CREATE: id=8&amount=600&currency=USD",
                "FINALIZE: id=16&amount=900&currency=USD",
                "PAY: id=16&amount=500&currency=USD"); // 1000
        List<String> action9 = Arrays.asList(
                "CREATE: id=14&amount=800&currency=USD",
                "FINALIZE: id=14&amount=800&currency=USD",
                "PAY: id=14");
        /*TrackingInvoice(invoice0);
        calculate_total_owed(invoice1);
        calculate_total_owed(invoice2);
        calculate_total_owed(invoice3);
        calculate_total_owed(invoice4);
        calculate_total_owed(invoice5);
        calculate_total_owed(invoice6);
        calculate_total_owed(invoice7);*/
        calculate_total_owed(action9);
    }
}