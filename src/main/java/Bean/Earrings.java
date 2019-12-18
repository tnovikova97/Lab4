package Bean;

import javax.persistence.*;

@Entity
public class Earrings {
    private int id;
    private String title;
    private String style;
    private String designer;
    private String stone;
    private String metal;
    private int price;

    public Earrings() {}

    public Earrings (String title, String style, String designer, String stone, String metal, int price) {
        super();
        this.title = title;
        this.style = style;
        this.designer = designer;
        this.stone = stone;
        this.metal = metal;
        this.price = price;
    }

    public Earrings(int id, String title, String style, String designer, String stone, String metal, int price) {
        super();
        this.id = id;
        this.title = title;
        this.style = style;
        this.designer = designer;
        this.stone = stone;
        this.metal = metal;
        this.price = price;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "style")
    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Basic
    @Column(name = "designer")
    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    @Basic
    @Column(name = "stone")
    public String getStone() {
        return stone;
    }

    public void setStone(String stone) {
        this.stone = stone;
    }

    @Basic
    @Column(name = "metal")
    public String getMetal() {
        return metal;
    }

    public void setMetal(String metal) {
        this.metal = metal;
    }

    @Basic
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Earrings{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", style='" + style + '\'' +
                ", designer='" + designer + '\'' +
                ", stone='" + stone + '\'' +
                ", metal='" + metal + '\'' +
                ", price=" + price +
                '}';
    }
}
