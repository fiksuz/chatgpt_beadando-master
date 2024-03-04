import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void testFindLegtobbMezo() {
        Map<Integer, String> osvenyek = new HashMap<>();
        osvenyek.put(1, "KKMMM");
        osvenyek.put(2, "KKKMM");
        osvenyek.put(3, "KKKMMM");

        int legtobbMezoSorszam = Main.findLegtobbMezo(osvenyek);

        assertEquals(3, legtobbMezoSorszam);
    }

    // Ide írhatod további teszteket a többi metódushoz

    // ...

}
