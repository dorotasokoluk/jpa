package io.mbab.sda.sdajpa17.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
public abstract class AbstractEntity<ID> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected ID id;

    @Version
    protected Long version = 0L;

    @Transient
    private UUID uuid = UUID.randomUUID();

    public ID getId() {
        return id;
    }
// nie będzie ustawiany ręcznie ID bo jest generowany
//    public void setId(ID id) {
//        this.id = id;
//    }

    public Long getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEntity)) return false;
        AbstractEntity<?> that = (AbstractEntity<?>) o;
        return uuid.equals(that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
