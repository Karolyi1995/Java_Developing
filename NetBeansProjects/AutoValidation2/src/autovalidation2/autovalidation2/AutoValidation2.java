/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autovalidation2.autovalidation2;

import java.util.Objects;

/**
 *
 * @author Student
 */
public class AutoValidation2 {

    private String AutoType;
    
    public AutoValidation2(String AutoType){
        this.AutoType=AutoType;
    }

    public String getAutoType() {
        return AutoType;
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
        AutoValidation2 other = (AutoValidation2) obj;
        
        return this.AutoType == other.AutoType;
    }
    
    public String toString(){
        return "AutoType: " + this.AutoType;
    }
    
}
