
import java.util.Random;

public class Unocard {
    public String color;
    public String type;
    private int value;
    private String image;
    
    public Unocard(String color,String type,int value,String image)
    {
        this.color=color;
        this.type=type;
        this.value=value;
        this.image=image;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "color=" + color + ", type=" + type + ", value=" + value + ", image=" + image;
    }
    
   
    
}

