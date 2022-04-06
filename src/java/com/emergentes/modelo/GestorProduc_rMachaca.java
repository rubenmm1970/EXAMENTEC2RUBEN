/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.modelo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Ruben
 */
public class GestorProduc_rMachaca {
    private ArrayList<Produc_rMachaca> lista;

    public GestorProduc_rMachaca() 
    {
        lista = new ArrayList<Produc_rMachaca>();
    }

    public ArrayList<Produc_rMachaca> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Produc_rMachaca> lista) {
        this.lista = lista;
    }
     
    public void insertarProducto(Produc_rMachaca item)
    {
      lista.add(item);
    }
    public void modificarProducto(int pos, Produc_rMachaca item)
    {
      lista.set(pos, item);
    }
    public void eliminarProducto(int pos)
    {
      lista.remove(pos);
    }
   
    public int obtieneId()
    {
      int idaux=0;
      
      for (Produc_rMachaca item:lista)
      {
          idaux=item.getId();
      }
      return idaux + 1;
    }
    
    public int ubicarProducto(int id)
    {
        int pos=-1;
        Iterator<Produc_rMachaca> it = lista.iterator();
        
        while ( it.hasNext())
        {
            ++pos;
            Produc_rMachaca aux = it.next();
            
            if(aux.getId()==id)
            {
                break;
            }
        }
        return pos;
    }
}
