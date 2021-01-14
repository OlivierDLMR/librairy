package Domain;

import javax.persistence.*;

@Entity(name = "LIBRARY")
public class Library {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private Type type;

    @Embedded
    private Address address;

    @Embedded
    private Director director;

    public Library() {}

    public Library(final Long id, final Type type, final Address address, final Director director) {
        this.id = id;
        this.type = type;
        this.address = address;
        this.director = director;
    }

    public void update(final Library libraryWithNewInformation) {
        type = libraryWithNewInformation.getType();
        address = libraryWithNewInformation.getAddress();
        director = libraryWithNewInformation.getDirector();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
