package net.pabszito.simplessentials.schema;

import dev.morphia.annotations.Id;
import lombok.Getter;
import java.util.UUID;

public class User implements Schema {

    @Id @Getter
    private UUID id;
}
