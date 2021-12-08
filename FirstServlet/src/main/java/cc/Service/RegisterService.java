package cc.Service;



import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toList;

public class RegisterService {
    private static Map<Integer, String> timeNames;
    static {
        timeNames = new LinkedHashMap<>();
        timeNames.put(1, "�W��");
        timeNames.put(2, "�U��");
        timeNames.put(3, "�ߤW");
        
    }
    
    public List<String> getTimeNamesById(List<Integer> time) {
        if (time.size() == 0) return null;
        // {1, 3} -> {"�W��", "�ߤW"}
        return time.stream()
                .map(t -> timeNames.get(t))
                .collect(toList());
    }
    
}
