/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rgbcode.rgbcode;

import rgbcode.exception.ValueOutOfBoundsEx;

/**
 *
 * @author Student
 */
public class RGBCode {

    private int red,green,blue;
    
    public RGBCode(int red,int green,int blue) throws ValueOutOfBoundsEx {
        if(red <= 0 || red >= 255) throw new ValueOutOfBoundsEx("Red value must be between 0 and 255");
        if(green <= 0 || red >= green) throw new ValueOutOfBoundsEx("Green value must be between 0 and 255");
        if(blue <= 0 || blue >= 255) throw new ValueOutOfBoundsEx("Blue value must be between 0 and 255");
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }
    
    @Override
    public int hashCode(){
        return red*7 + green*11 + blue*13;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        RGBCode other = (RGBCode) obj;
        
        return this.red == other.red && this.green == other.green && this.blue == other.blue;
    }
    
    @Override
    public String toString(){
        return "Red: " + red + " Green: " + green + " Blue: " + blue;
    }
    
}
