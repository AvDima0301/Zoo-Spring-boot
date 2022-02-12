package app.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_person")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Column(length = 255, nullable = false)
    private String name;
    @Column(nullable = true, length = 1000)
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
