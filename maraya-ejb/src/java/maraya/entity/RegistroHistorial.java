/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maraya.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Portatil
 */
@Entity
@Table(name = "registro_historial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistroHistorial.findAll", query = "SELECT r FROM RegistroHistorial r"),
    @NamedQuery(name = "RegistroHistorial.findById", query = "SELECT r FROM RegistroHistorial r WHERE r.id = :id"),
    @NamedQuery(name = "RegistroHistorial.findByContenido", query = "SELECT r FROM RegistroHistorial r WHERE r.contenido = :contenido"),
    @NamedQuery(name = "RegistroHistorial.findByFechaCreacion", query = "SELECT r FROM RegistroHistorial r WHERE r.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "RegistroHistorial.findByFechaModificacion", query = "SELECT r FROM RegistroHistorial r WHERE r.fechaModificacion = :fechaModificacion")})
public class RegistroHistorial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Size(max = 200)
    @Column(name = "contenido")
    private String contenido;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;
    @JoinColumn(name = "historial", referencedColumnName = "nHistorial")
    @ManyToOne
    private Historial historial;
    @JoinColumn(name = "medico", referencedColumnName = "nColegiado")
    @ManyToOne
    private Medicos medico;

    public RegistroHistorial() {
    }

    public RegistroHistorial(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Historial getHistorial() {
        return historial;
    }

    public void setHistorial(Historial historial) {
        this.historial = historial;
    }

    public Medicos getMedico() {
        return medico;
    }

    public void setMedico(Medicos medico) {
        this.medico = medico;
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
        if (!(object instanceof RegistroHistorial)) {
            return false;
        }
        RegistroHistorial other = (RegistroHistorial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "maraya.entity.RegistroHistorial[ id=" + id + " ]";
    }
    
}
