/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author aluno
 */
public class CUser {

    private int codigo;
    private String uname;
    private boolean uadmin;
    private String ulogin;
    private String pass;
    private byte[] arq;
    private String nomeArq;
    private String email;
    private String numero;

    public String getNomeArq() {
        return nomeArq;
    }

    /**
     * @param nome the nome to set
     */
    public void setNomeArq(String nome) {
        this.nomeArq = nome;
    }

    /**
     * @return the arq
     */
    public byte[] getArq() {
        return arq;
    }

    /**
     * @param arq the arq to set
     */
    public void setArq(byte[] arq) {
        this.arq = arq;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the uadmin
     */
    public boolean isUadmin() {
        return uadmin;
    }

    /**
     * @param uadmin the uadmin to set
     */
    public void setUadmin(boolean uadmin) {
        this.uadmin = uadmin;
    }

    /**
     * @return the ulogin
     */
    public String getUlogin() {
        return ulogin;
    }

    /**
     * @param ulogin the ulogin to set
     */
    public void setUlogin(String ulogin) {
        this.ulogin = ulogin;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setCodigo(String codigo) throws Exception {
        this.codigo = Integer.parseInt(codigo);
        /*polimorfico*/
    }

    /**
     * @return the uname
     */
    public String getUname() {
        return uname;
    }

    /**
     * @param uname the uname to set
     */
    public void setUname(String uname) {
        this.uname = uname;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

}
