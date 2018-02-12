package com.waracle.cake.model;
import io.springlets.format.EntityFormat;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;


@Entity
@EntityFormat
/**
 * = Cake
 *
 * TODO Auto-generated class documentation
 *
 */
public class Cake {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Integer version;
    
    private String image;
    private String description;
    private String title;

	/**
     * TODO Auto-generated method documentation
     * 
     * @return Long
     */
    public Long getId() {
        return this.id;
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @return Integer
     */
    public Integer getVersion() {
        return this.version;
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @param version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @return String
     */
    public String getImage() {
        return this.image;
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @return String
     */
    public String getDescription() {
        return this.description;
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @return String
     */
    public String getTitle() {
        return this.title;
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

	/**
     * TODO Auto-generated attribute documentation
     * 
     */
    public static final String ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE = "The given Iterable of items to add can't be null!";

	/**
     * TODO Auto-generated attribute documentation
     * 
     */
    public static final String ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE = "The given Iterable of items to add can't be null!";

	/**
     * TODO Auto-generated method documentation
     * 
     * @return String
     */
    public String toString() {
        return "Cake {" + 
                "id='" + id + '\'' + 
                ", version='" + version + '\'' + 
                ", image='" + image + '\'' + 
                ", description='" + description + '\'' + 
                ", title='" + title + '\'' + 
                ", ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE='" + ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE + '\'' + 
                ", ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE='" + ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE + '\'' + "}" + super.toString();
    }

	/**
     * This `equals` implementation is specific for JPA entities and uses 
     * the entity identifier for it, following the article in 
     * https://vladmihalcea.com/2016/06/06/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
     * 
     * @param obj
     * @return Boolean
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        // instanceof is false if the instance is null
        if (!(obj instanceof Cake)) {
            return false;
        }
        return getId() != null && Objects.equals(getId(), ((Cake) obj).getId());
    }

	/**
     * This `hashCode` implementation is specific for JPA entities and uses a fixed `int` value to be able 
     * to identify the entity in collections after a new id is assigned to the entity, following the article in 
     * https://vladmihalcea.com/2016/06/06/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
     * 
     * @return Integer
     */
    public int hashCode() {
        return 31;
    }
}
