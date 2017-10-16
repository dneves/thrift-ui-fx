package com.neon.rpc.gen.grpc.message;

import java.util.HashSet;
import java.util.Set;

public class DummyMessage {

    public static final class Builder {

        private Set< String > ids;
        private int limit;

        public Builder addId( String id ) {
            if ( ids == null ) {
                ids = new HashSet<>();
            }
            ids.add( id );
            return this;
        }

        public Builder addAllId( Iterable< String > ids ) {
            ids.forEach(this::addId);
            return this;
        }

        public Builder setLimit( int value ) {
            this.limit = value;
            return this;
        }

        public DummyMessage build() {
            Set< String > ids = new HashSet<>();
            this.ids.forEach(ids::add);
            return new DummyMessage(ids, limit);
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }



    private final Set< String > id;

    private final int limit;

    private DummyMessage(Set<String> id, int limit) {
        this.id = id;
        this.limit = limit;
    }

    public Set<String> getId() {
        return id;
    }

    public int getLimit() {
        return limit;
    }

}
