package br.com.bandtec.teste.api;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processador.Processador;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import oshi.SystemInfo;
import oshi.hardware.ComputerSystem;
import oshi.hardware.HardwareAbstractionLayer;

public class Teste {

    public static void main(String[] args) {

        SystemInfo informacoesSistema = new SystemInfo();
        HardwareAbstractionLayer ha = new SystemInfo().getHardware();
        ComputerSystem system = ha.getComputerSystem();
        System.out.println(system.getSerialNumber());
        System.out.println(system.getModel());
        System.out.println(system.getManufacturer());

        Timestamp dataDeAgora = new Timestamp(System.currentTimeMillis());
        String chupetinha = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss").format(dataDeAgora);
        System.out.println(chupetinha);

    }
}
