/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autovalidation.autovalidation;

import java.util.Objects;

/**
 *
 * @author Student
 */
public class AutoValidation {

    private String AutoType;
    private int RemainingAutos;
    
    public AutoValidation(String AutoType,int RemainingAutos){
        this.AutoType=AutoType;
        this.RemainingAutos=RemainingAutos;
    }

    public String getAutoType() {
        return AutoType;
    }

    public int getRemainingAutos() {
        return RemainingAutos;
    }

    @Override
    public int hashCode() {
        int hash = 2;
        return hash;
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
        AutoValidation other = (AutoValidation) obj;
        
        return this.AutoType == other.AutoType && this.RemainingAutos == other.RemainingAutos;
    }
    
    public String toString(){
        return "AutoType: " + this.AutoType + " Remaining Autos: " + this.RemainingAutos;
    }
    
}
