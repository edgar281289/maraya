/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maraya.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "especializaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especializaciones.findAll", query = "SELECT e FROM Especializaciones e"),
    @NamedQuery(name = "Especializaciones.findById", query = "SELECT e FROM Especializaciones e WHERE e.id = :id"),
    @NamedQuery(name = "Especializaciones.findByEspecializacion", query = "SELECT e FROM Especializaciones e WHERE e.especializacion = :especializacion")})
public class Especializaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "especializacion")
    private String especializacion;
    @OneToMany(mappedBy = "especializacion")
    private Collection<Medicos> medicosCollection;

    public Especializaciones() {
    }

    public Especializaciones(Integer id) {
        this.id = id;
    }

    public Especializaciones(Integer id, String especializacion) {
        this.id = id;
        this.especializacion = especializacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }

    @XmlTransient
    public Collection<Medicos> getMedicosCollection() {
        return medicosCollection;
    }

    public void setMedicosCollection(Collection<Medicos> medicosCollection) {
        this.medicosCollection = medicosCollection;
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
        if (!(object instanceof Especializaciones)) {
            return false;
        }
        Especializaciones other = (Especializaciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "maraya.entity.Especializaciones[ id=" + id + " ]";
    }
    
}
