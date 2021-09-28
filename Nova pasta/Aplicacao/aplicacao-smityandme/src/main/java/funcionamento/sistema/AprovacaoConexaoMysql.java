/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionamento.sistema;

import java.io.File;

/**
 *
 * @author victor.pederzini
 */
public class AprovacaoConexaoMysql {
    
    public static Boolean verificarSeDeveConectarAoMysql() {
        
        return new File("smity.cfg").exists();
       
    }
    
}
