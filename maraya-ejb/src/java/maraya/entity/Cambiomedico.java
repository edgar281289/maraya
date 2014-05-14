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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Portatil
 */
@Entity
@Table(name = "cambiomedico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cambiomedico.findAll", query = "SELECT c FROM Cambiomedico c"),
    @NamedQuery(name = "Cambiomedico.findById", query = "SELECT c FROM Cambiomedico c WHERE c.id = :id"),
    @NamedQuery(name = "Cambiomedico.findByDia", query = "SELECT c FROM Cambiomedico c WHERE c.dia = :dia"),
    @NamedQuery(name = "Cambiomedico.findByDescripci\u00f3n", query = "SELECT c FROM Cambiomedico c WHERE c.descripci\u00f3n = :descripci\u00f3n")})
public class Cambiomedico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dia")
    @Temporal(TemporalType.DATE)
    private Date dia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "descripci\u00f3n")
    private String descripción;
    @JoinColumn(name = "medicoActual", referencedColumnName = "nColegiado")
    @ManyToOne(optional = false)
    private Medicos medicoActual;
    @JoinColumn(name = "medicoNuevo", referencedColumnName = "nColegiado")
    @ManyToOne(optional = false)
    private Medicos medicoNuevo;
    @JoinColumn(name = "paciente", referencedColumnName = "NSS")
    @ManyToOne(optional = false)
    private Paciente paciente;

    public Cambiomedico() {
    }

    public Cambiomedico(Integer id) {
        this.id = id;
    }

    public Cambiomedico(Integer id, Date dia, String descripción) {
        this.id = id;
        this.dia = dia;
        this.descripción = descripción;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public Medicos getMedicoActual() {
        return medicoActual;
    }

    public void setMedicoActual(Medicos medicoActual) {
        this.medicoActual = medicoActual;
    }

    public Medicos getMedicoNuevo() {
        return medicoNuevo;
    }

    public void setMedicoNuevo(Medicos medicoNuevo) {
        this.medicoNuevo = medicoNuevo;
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
        if (!(object instanceof Cambiomedico)) {
            return false;
        }
        Cambiomedico other = (Cambiomedico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "maraya.entity.Cambiomedico[ id=" + id + " ]";
    }
    
}
