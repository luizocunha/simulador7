package grafico.cursoandroid.com.simulador7;

import br.ufjf.mmc.jynacore.systemdynamics.SystemDynamicsItem;

class ItemDeListaDeElementosDS {
    private SystemDynamicsItem item;
    private String elemento;
    private int imagem; // vai armazenar o identificador do recurso
    private String valorelemento;

    public ItemDeListaDeElementosDS(String elemento, String valorelemento, int imagem, SystemDynamicsItem item) {
        this.elemento = elemento;
        this.valorelemento = valorelemento;
        this.imagem = imagem;
        this.item = item;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getValorelemento() {
        return valorelemento;
    }

    public void setValorelemento(String valorelemento) {
        this.valorelemento = valorelemento;
    }

    public SystemDynamicsItem getItem() {
        return item;
    }

    public void setItem(SystemDynamicsItem item) {
        this.item = item;
    }
}