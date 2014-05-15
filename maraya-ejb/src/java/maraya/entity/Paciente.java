/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maraya.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Portatil
 */
@Entity
@Table(name = "paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p"),
    @NamedQuery(name = "Paciente.findByNss", query = "SELECT p FROM Paciente p WHERE p.nss = :nss"),
    @NamedQuery(name = "Paciente.findByDni", query = "SELECT p FROM Paciente p WHERE p.dni = :dni"),
    @NamedQuery(name = "Paciente.findByNombre", query = "SELECT p FROM Paciente p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Paciente.findByApellidos", query = "SELECT p FROM Paciente p WHERE p.apellidos = :apellidos"),
    @NamedQuery(name = "Paciente.findByFechaNacimiento", query = "SELECT p FROM Paciente p WHERE p.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Paciente.findByTelefono", query = "SELECT p FROM Paciente p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Paciente.findByEmail", query = "SELECT p FROM Paciente p WHERE p.email = :email"),
    @NamedQuery(name = "Paciente.findByProvincia", query = "SELECT p FROM Paciente p WHERE p.provincia = :provincia"),
    @NamedQuery(name = "Paciente.findByCiudad", query = "SELECT p FROM Paciente p WHERE p.ciudad = :ciudad"),
    @NamedQuery(name = "Paciente.findByCodigoPostal", query = "SELECT p FROM Paciente p WHERE p.codigoPostal = :codigoPostal")})
public class Paciente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NSS")
    private String nss;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")
    private int telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Correo electrónico no válido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "provincia")
    private String provincia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codigoPostal")
    private String codigoPostal;
    @JoinColumn(name = "historial", referencedColumnName = "nHistorial")
    @ManyToOne
    private Historial historial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    private Collection<UsuariosPacientes> usuariosPacientesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    private Collection<Formulario> formularioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    private Collection<Gruposmedicos> gruposmedicosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    private Collection<Cambiomedico> cambiomedicoCollection;

    public Paciente() {
    }

    public Paciente(String nss) {
        this.nss = nss;
    }

    public Paciente(String nss, String dni, String nombre, String apellidos, Date fechaNacimiento, int telefono, String email, String provincia, String ciudad, String codigoPostal) {
        this.nss = nss;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.email = email;
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Historial getHistorial() {
        return historial;
    }

    public void setHistorial(Historial historial) {
        this.historial = historial;
    }

    @XmlTransient
    public Collection<UsuariosPacientes> getUsuariosPacientesCollection() {
        return usuariosPacientesCollection;
    }

    public void setUsuariosPacientesCollection(Collection<UsuariosPacientes> usuariosPacientesCollection) {
        this.usuariosPacientesCollection = usuariosPacientesCollection;
    }

    @XmlTransient
    public Collection<Formulario> getFormularioCollection() {
        return formularioCollection;
    }

    public void setFormularioCollection(Collection<Formulario> formularioCollection) {
        this.formularioCollection = formularioCollection;
    }

    @XmlTransient
    public Collection<Gruposmedicos> getGruposmedicosCollection() {
        return gruposmedicosCollection;
    }

    public void setGruposmedicosCollection(Collection<Gruposmedicos> gruposmedicosCollection) {
        this.gruposmedicosCollection = gruposmedicosCollection;
    }

    @XmlTransient
    public Collection<Cambiomedico> getCambiomedicoCollection() {
        return cambiomedicoCollection;
    }

    public void setCambiomedicoCollection(Collection<Cambiomedico> cambiomedicoCollection) {
        this.cambiomedicoCollection = cambiomedicoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nss != null ? nss.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.nss == null && other.nss != null) || (this.nss != null && !this.nss.equals(other.nss))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "maraya.entity.Paciente[ nss=" + nss + " ]";
    }
    
}
