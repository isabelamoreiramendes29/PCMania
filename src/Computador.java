public class Computador {

    private String marca;
    private float preco;
    SistemaOperacional sop;
    HardwareBasico[] hb;
    MemoriaUSB memoriausb;


    public Computador(){
        sop = new SistemaOperacional();
        hb = new HardwareBasico[2];
        for(int i = 0; i<hb.length;i++) {
            hb[i] = new HardwareBasico();
        }
    }


    public void mostraPCConfigs(){

    }

    public void addmemoriaUSB(MemoriaUSB musb){

    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public SistemaOperacional getSop() {
        return sop;
    }

    public void setSop(SistemaOperacional sop) {
        this.sop = sop;
    }

    public HardwareBasico[] getHb() {
        return hb;
    }

    public void setHb(HardwareBasico[] hb) {
        this.hb = hb;
    }

    public MemoriaUSB getMemoriausb() {
        return memoriausb;
    }

    public void setMemoriausb(MemoriaUSB memoriausb) {
        this.memoriausb = memoriausb;
    }
}
