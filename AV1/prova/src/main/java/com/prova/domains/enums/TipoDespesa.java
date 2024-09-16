package com.prova.domains.enums;

public enum TipoDespesa {

    MULTA(0,"ROLE_MULTA"), COLISAO(1, "ROLE_COLISAO"), PNEU(2, "ROLE_PNEU");

    private Integer id;
    private String tipoDespesa;
    
    private TipoDespesa(Integer id, String tipoDespesa) {
        this.id = id;
        this.tipoDespesa = tipoDespesa;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTipoDespesa() {
        return tipoDespesa;
    }
    public void setTipoDespesa(String tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public static TipoDespesa ToEnum(Integer id){
        if(id==null) return null;
        for(TipoDespesa x : TipoDespesa.values()){
            if(id.equals(x.getId())){
                return x;
            }
        }
        throw new IllegalArgumentException("Tipo Despesa invalida.");
    }

}
