package br.inatel.poo;

public class Computador {

    private String marca;
    private float preco;
    private SistemaOperacional sop;
    private HardwareBasico[] hb;
    private MemoriaUSB memoriausb;



    public Computador(String marca, float preco, String nomeSop, int tipoSop, String nomePro, int capacidadePro, String nomeRam, int capRam, String nomeHd, int capHd){
        this.marca = marca;
        this.preco = preco;

        hb = new HardwareBasico[3];
        sop = new SistemaOperacional(nomeSop,tipoSop);
        hb[0] = new HardwareBasico(nomePro,capacidadePro);
        hb[1] = new HardwareBasico(nomeRam, capRam);
        hb[2] = new HardwareBasico(nomeHd, capHd);

    }


    public void mostraPCConfigs(){

        System.out.println("Marca: " + marca);
        System.out.println("Preco: R$" + preco);

        for(int i = 0; i < hb.length; i++){
            System.out.println(hb[i].getNome() + " - " + hb[i].getCapacidade());
        }

        System.out.println("Sistema Operacional: " + sop.getNome() + " Tipo: " + sop.getTipo() + " bits");

        if(memoriausb != null){
            System.out.println("Acompanha: " + memoriausb.getNome() + " de " + memoriausb.getCapacidade() + "Gb");
        }

    }

    public void addMemoriaUSB(MemoriaUSB musb){
        this.memoriausb = musb;
    }


    public float getPreco() {
        return preco;
    }

}
