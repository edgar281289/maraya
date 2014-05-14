/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maraya.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Portatil
 */
@Entity
@Table(name = "medicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicos.findAll", query = "SELECT m FROM Medicos m"),
    @NamedQuery(name = "Medicos.findByNColegiado", query = "SELECT m FROM Medicos m WHERE m.nColegiado = :nColegiado"),
    @NamedQuery(name = "Medicos.findByDni", query = "SELECT m FROM Medicos m WHERE m.dni = :dni"),
    @NamedQuery(name = "Medicos.findByNombre", query = "SELECT m FROM Medicos m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Medicos.findByApellidos", query = "SELECT m FROM Medicos m WHERE m.apellidos = :apellidos")})
public class Medicos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "nColegiado")
    private String nColegiado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "DNI")
    private String dni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apellidos")
    private String apellidos;
    @OneToMany(mappedBy = "medico")
    private Collection<Gruposmedicos> gruposmedicosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medico")
    private Collection<UsuariosMedicos> usuariosMedicosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicoActual")
    private Collection<Cambiomedico> cambiomedicoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicoNuevo")
    private Collection<Cambiomedico> cambiomedicoCollection1;
    @JoinColumn(name = "especializacion", referencedColumnName = "ID")
    @ManyToOne
    private Especializaciones especializacion;
    @OneToMany(mappedBy = "medico")
    private Collection<RegistroHistorial> registroHistorialCollection;

    public Medicos() {
    }

    public Medicos(String nColegiado) {
        this.nColegiado = nColegiado;
    }

    public Medicos(String nColegiado, String dni, String nombre, String apellidos) {
        this.nColegiado = nColegiado;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getNColegiado() {
        return nColegiado;
    }

    public void setNColegiado(String nColegiado) {
        this.nColegiado = nColegiado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @XmlTransient
    public Collection<Gruposmedicos> getGruposmedicosCollection() {
        return gruposmedicosCollection;
    }

    public void setGruposmedicosCollection(Collection<Gruposmedicos> gruposmedicosCollection) {
        this.gruposmedicosCollection = gruposmedicosCollection;
    }

    @XmlTransient
    public Collection<UsuariosMedicos> getUsuariosMedicosCollection() {
        return usuariosMedicosCollection;
    }

    public void setUsuariosMedicosCollection(Collection<UsuariosMedicos> usuariosMedicosCollection) {
        this.usuariosMedicosCollection = usuariosMedicosCollection;
    }

    @XmlTransient
    public Collection<Cambiomedico> getCambiomedicoCollection() {
        return cambiomedicoCollection;
    }

    public void setCambiomedicoCollection(Collection<Cambiomedico> cambiomedicoCollection) {
        this.cambiomedicoCollection = cambiomedicoCollection;
    }

    @XmlTransient
    public Collection<Cambiomedico> getCambiomedicoCollection1() {
        return cambiomedicoCollection1;
    }

    public void setCambiomedicoCollection1(Collection<Cambiomedico> cambiomedicoCollection1) {
        this.cambiomedicoCollection1 = cambiomedicoCollection1;
    }

    public Especializaciones getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(Especializaciones especializacion) {
        this.especializacion = especializacion;
    }

    @XmlTransient
    public Collection<RegistroHistorial> getRegistroHistorialCollection() {
        return registroHistorialCollection;
    }

    public void setRegistroHistorialCollection(Collection<RegistroHistorial> registroHistorialCollection) {
        this.registroHistorialCollection = registroHistorialCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nColegiado != null ? nColegiado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicos)) {
            return false;
        }
        Medicos other = (Medicos) object;
        if ((this.nColegiado == null && other.nColegiado != null) || (this.nColegiado != null && !this.nColegiado.equals(other.nColegiado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "maraya.entity.Medicos[ nColegiado=" + nColegiado + " ]";
    }
    
}
