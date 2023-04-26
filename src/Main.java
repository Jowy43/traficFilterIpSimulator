import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<String> origenIps = new ArrayList<>();
        List<String> destinationIps = new ArrayList<>();

        for (int i = 0; i < IpFilter.NUM_IPS; i++) {
            origenIps.add("192.168.0." + (i + 1));
            destinationIps.add("8.8.8.8");
        }

        Map<String, InfoFilter> filer = new HashMap<>();
        for (String ip : origenIps) {
            filer.put(ip, new InfoFilter(IpFilter.TRAFFIC_LIMIT, 0));
        }

        int packageSend = 20;
        for (int i = 0; i < packageSend; i++) {
            String origenIp = origenIps.get((int) (Math.random() * 10));
            String destIp = destinationIps.get((int) (Math.random() * 10));
            Integer packageSize = (int) (Math.random() * IpFilter.MAX_PACKAGE);

            if (filer.containsKey(origenIp)) {
                InfoFilter info = filer.get(origenIp);
                if (info.isBlocked()) {
                    System.out.println("Transmisión no permitida (IP vetada)");
                } else if (info.getActualTraffic() + packageSize > info.getTrafficLimit()) {
                    System.out.println("Transmisión no permitida (Tope de tráfico alcanzado)");
                } else {
                    info.setActualTraffic(info.getActualTraffic() + packageSize);
                    System.out.println("Tranmisión permitida: " + origenIp + " -> " + destIp + "(" + packageSize + ")");
                }
            } else {
                System.out.println("Ip de origen no válida");
            }

        }
    }
}