package com.uash.uash.enumerado;

public enum RatingOpcao {
    EXCELENTE (5), BOM (4), MEDIO(3), RUIM(2), MUITORUIM(1);

private final int rating;
RatingOpcao(int ratingOp){
rating = ratingOp;
}
public int ratingOp(){
return rating;
}
    
}
