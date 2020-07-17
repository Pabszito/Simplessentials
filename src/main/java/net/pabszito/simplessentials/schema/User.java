package net.pabszito.simplessentials.schema;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.SerializableAs;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Entity("User")
@SerializableAs("User")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class User implements Schema, ConfigurationSerializable {

    @Id
    @Getter
    private UUID id;

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> serial = new HashMap<>();
        serial.put("id", id);
        return serial;
    }
}
