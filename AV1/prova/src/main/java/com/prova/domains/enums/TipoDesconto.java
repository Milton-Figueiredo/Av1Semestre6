package com.prova.domains.enums;

public enum TipoDesconto {

    AVISTA(0, "ROLE_AVISTA"), PROMACAO(1, "ROLE_PROMOCAO"), VIP(2,"ROLE_VIP");

        private Integer id;
        private String tipoDesconto;
        
        private TipoDesconto(Integer id, String tipoDesconto) {
            this.id = id;
            this.tipoDesconto = tipoDesconto;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTipoDesconto() {
            return tipoDesconto;
        }

        public void setTipoDesconto(String tipoDesconto) {
            this.tipoDesconto = tipoDesconto;
        }

        public static TipoDesconto toEnum(Integer id){
            if(id==null) return null;
            for(TipoDesconto x : TipoDesconto.values()){
                return x;
            }
            throw new IllegalArgumentException("Tipo de desconto invalido.");
        }
            
}
