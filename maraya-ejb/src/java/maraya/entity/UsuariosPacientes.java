/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maraya.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Portatil
 */
@Entity
@Table(name = "usuarios_pacientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuariosPacientes.findAll", query = "SELECT u FROM UsuariosPacientes u"),
    @NamedQuery(name = "UsuariosPacientes.findById", query = "SELECT u FROM UsuariosPacientes u WHERE u.id = :id"),
    @NamedQuery(name = "UsuariosPacientes.findByUser", query = "SELECT u FROM UsuariosPacientes u WHERE u.user = :user"),
    @NamedQuery(name = "UsuariosPacientes.findByPassword", query = "SELECT u FROM UsuariosPacientes u WHERE u.password = :password")
    ,@NamedQuery(name = "UsuariosPacientes.findByUserAndPassword", query = "SELECT u FROM UsuariosPacientes u WHERE u.user = :user AND u.password = :password")
})
public class UsuariosPacientes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "user")
    private String user;
    @Size(max = 25)
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "paciente", referencedColumnName = "NSS")
    @ManyToOne(optional = false)
    private Paciente paciente;

    public UsuariosPacientes() {
    }

    public UsuariosPacientes(Integer id) {
        this.id = id;
    }

    public UsuariosPacientes(Integer id, String user) {
        this.id = id;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosPacientes)) {
            return false;
        }
        UsuariosPacientes other = (UsuariosPacientes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "maraya.entity.UsuariosPacientes[ id=" + id + " ]";
    }
    
}
