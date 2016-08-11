/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UNOModel;

/**
 *
 * @author e0000708
 */
public class UNOCard {
    private String Color; 
    private String Type;
    private int Score;
    private String Image;

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public UNOCard(String Color, String Type, int Score, String Image) {
        this.Color = Color;
        this.Type = Type;
        this.Score = Score;
        this.Image = Image;
    }

    @Override
    public String toString() {
        return "UNOCard:"  + "Color=" + Color + ", Type=" + Type + ", Score=" + Score + ", Image=" + Image + "\n\t\t\t";
    }
    
    

}
