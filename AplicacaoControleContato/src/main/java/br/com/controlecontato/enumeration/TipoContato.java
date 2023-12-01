package br.com.controlecontato.enumeration;

public enum TipoContato {
	 TELEFONE(0),
     CELULAR(1),
     EMAIL(2);

     private final int value;

     TipoContato(int value) {
         this.value = value;
     }

     public int getValue() {
         return value;
     }
}
