/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.main;

import example.ejb.PersonRemote;
import example.model.Person;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.naming.InitialContext;

/**
 *
 * @author gustavosa
 */
public class PersonRegister {
    public static void main(String[] args) throws Exception {
        InitialContext ctx = new InitialContext();
        PersonRemote ejb = (PersonRemote) ctx.lookup("example.ejb.PersonRemote");
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        
        Person p = new Person();
        p.setName("Gustavo S Assalin");
        p.setBirthday(df.parse("28/08/1995"));
        p.setEmail("gustavo.assalin");
        
        p = ejb.save(p);
        System.out.println("Pessoa salva com o id: " + p.getId());
    }
}
