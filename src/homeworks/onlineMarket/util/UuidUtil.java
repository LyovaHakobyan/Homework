package homeworks.onlineMarket.util;

import java.util.UUID;

public abstract class UuidUtil {
    static UUID uuid = UUID.randomUUID();

    public static String getUuid() {
        String[] uuids = uuid.toString().split("-");
        return uuids[0];
    }
}
