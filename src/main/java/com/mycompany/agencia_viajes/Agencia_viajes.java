/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.agencia_viajes;

import Dominio.Principal;
import Presentacion.formularioPrincipal;
import Presentacion.formularioUsuarios;


/**
 *
 * @author Usuario
 */
public class Agencia_viajes {

    public static void main(String[] args) {
        //Agencia agencia = new Agencia();  
        //frmUsuario formulario = new frmUsuario(agencia);
        //formulario.setVisible(true);
        
        Principal agencia = new Principal();  
        formularioPrincipal formulario = new formularioPrincipal(agencia);
        formulario.setLocationRelativeTo(null);
        formulario.setVisible(true);
    }
}
