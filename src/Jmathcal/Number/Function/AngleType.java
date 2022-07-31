package Jmathcal.Number.Function;

import java.math.BigDecimal;
import java.math.MathContext;

public enum AngleType {
    
    DEG, RAD, GRAD;

    public BigDecimal cal(MathContext mc) {
        BigDecimal reVal = null;
        switch(this) {
            case DEG :
                reVal = new BigDecimal("180");
                break;
            case RAD :
                reVal = Trigo.PI(mc);
                break;
            case GRAD :
                reVal = new BigDecimal("200");
        }
        return reVal;
    }
}
