
package funcionamento.sistema;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.sistema.Sistema;
import oshi.SystemInfo;
import oshi.hardware.ComputerSystem;
import oshi.hardware.HardwareAbstractionLayer;

/**
 *
 * @author vinicius.n.ferreira
 */
public class CapturaInicialDadosComputador {
    
    Looca looca = new Looca();
    Sistema sistema = looca.getSistema();
    Memoria memoria = looca.getMemoria();
    Processador processador = looca.getProcessador();
    DiscosGroup discosGroup = looca.getGrupoDeDiscos();
    SystemInfo informacoesSistema = new SystemInfo();
    HardwareAbstractionLayer ha = new SystemInfo().getHardware();
    ComputerSystem system = ha.getComputerSystem();

    public String getModeloComputador() {
        return system.getModel();
    }
    
    public String getMarcaComputador() {
        return system.getManufacturer();
    }
    
    public String getNomeCPU(){
        return processador.getNome();
    }
    
    public Float getTotalRAM(){ 
        return (float)(memoria.getTotal() / 1000000000);       
    }

    public String getModeloDisco() {
        return informacoesSistema.getHardware().getDiskStores().get(0).getModel();
    }
    
    public Float getTotalDisco(){
        return (float) (discosGroup.getVolumes().get(0).getTotal() / 1000000000);
    }
    
    public String getSistemaOperacional(){
        return sistema.getSistemaOperacional();
    }
    
}
